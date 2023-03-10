package club.calong.tipper;

import club.calong.tipper.core.Tipper;
import club.calong.tipper.core.TipperLine;
import club.calong.tipper.core.TipperLineType;
import club.calong.tipper.core.TipperParser;
import club.calong.tipper.domain.core.TipperAction;
import club.calong.tipper.domain.core.TipperModule;
import club.calong.tipper.exception.TipperParseException;
import club.calong.tipper.properties.TipperProperties;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TipperContext {

    private final TipperProperties tipperProperties;

    private final TipperParser tipperParser;

    public TipperContext (TipperProperties tipperProperties) {

        this.tipperProperties = tipperProperties;

        this.tipperParser = new TipperParser();
    }

    /**
     * Module
     *   |
     *   +--Action
     *   |    |
     *   |    +--Api
     *   |    |
     *   |    +--Api
     *   |
     *   +--Action
     *        |
     *        +--Api
     */
    private static final HashMap<String, TipperModule> tippers = new HashMap<>();

    public static HashMap<String, TipperModule> getTippers() {
        return tippers;
    }

    public static void createTipper(Tipper tipperValue) {

        String module = tipperValue.getModule();
        String action = tipperValue.getAction();
        String tipper = tipperValue.getTipper();

        TipperModule tipperModule;
        if (tippers.containsKey(module)) {
            tipperModule = tippers.get(module);
        } else {
            tipperModule = new TipperModule(module);
            tippers.put(module, tipperModule);
        }

        TipperAction tipperAction;
        if (tipperModule.getActions().containsKey(action)) {
            tipperAction = tipperModule.getActions().get(action);
        } else {
            tipperAction = new TipperAction(action);
            tipperModule.getActions().put(action, tipperAction);
        }

        if (tipperAction.getTippers().containsKey(tipper)) {
            throw new RuntimeException();
        } else {
            tipperAction.getTippers().put(tipper, tipperValue);
        }
    }

    public void loadTipperFile(File file) {

        try {
            FileInputStream ins = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(ins, tipperProperties.getEncoding());
            LineNumberReader lineNumberReader = new LineNumberReader(reader);
            List<TipperLine> lines = new LinkedList<>();
            String line;
            while ((line = lineNumberReader.readLine()) != null) {
                line = line.trim();
                if (line.length() == 0) {
                    continue;
                }
                if (line.startsWith("//")) {
                    lines.add(new TipperLine(
                            TipperLineType.TP_COMMENT,
                            lineNumberReader.getLineNumber(),
                            line));
                    continue;
                }
                lines.add(new TipperLine(
                        TipperLineType.TP_CODE,
                        lineNumberReader.getLineNumber(),
                        line));
            }
            ins.close();
            lineNumberReader.close();
            reader.close();

            Tipper tipper = tipperParser.parse(lines);

            createTipper(tipper);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void scanTipperFiles(File dir, List<File> tipperFiles) {

        File[] files = dir.listFiles();

        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                scanTipperFiles(file, tipperFiles);
            } else if (file.getName().endsWith(".tip")) {
                tipperFiles.add(file);
            }
        }
    }
}
