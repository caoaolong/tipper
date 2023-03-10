package club.calong.tipper.core;

import java.util.List;
import java.util.regex.Matcher;

public class TipperParser {

    public Tipper parse(List<TipperLine> lines) {

        Tipper tipper = new Tipper();
        for (TipperLine line : lines) {
            String content = line.getContent();
            System.out.println(content);
            if (line.getType() == TipperLineType.TP_CODE) {
                if (content.startsWith("module")) {
                    Matcher matcher = TipperPattern.moduleNamePattern.matcher(content);
                    if (matcher.find()) {
                        String module = matcher.group(1);
                        tipper.setModule(module);
                        System.out.println(module);
                    } else {
                        throw new RuntimeException();
                    }
                } else if (content.startsWith("action")) {
                    Matcher matcher = TipperPattern.actionNamePattern.matcher(content);
                    if (matcher.find()) {
                        String action = matcher.group(1);
                        tipper.setAction(action);
                        System.out.println(action);
                    } else {
                        throw new RuntimeException();
                    }
                } else if (content.startsWith("tipper")) {
                    Matcher matcher = TipperPattern.tipperNamePattern.matcher(content);
                    if (matcher.find()) {
                        String tipperName = matcher.group(1);
                        tipper.setTipper(tipperName);
                        System.out.println(tipperName);
                    }
                }
            }
        }

        return tipper;
    }
}
