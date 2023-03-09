package club.calong.tipper;

import club.calong.tipper.core.Tipper;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TipperContext {

    private static final HashMap<String, List<Tipper>> tippers = new HashMap<>();

    public static HashMap<String, List<Tipper>> getTippers() {
        return tippers;
    }

    public void putTipper(String tipperName, Tipper tipper) {

        if (tippers.containsKey(tipperName)) {
            tippers.get(tipperName).add(tipper);
        } else {
            List<Tipper> tipperList = new LinkedList<>();
            tipperList.add(tipper);
            tippers.put(tipperName, tipperList);
        }
    }
}
