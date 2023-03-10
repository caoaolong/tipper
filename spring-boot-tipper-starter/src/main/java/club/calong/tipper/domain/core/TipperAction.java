package club.calong.tipper.domain.core;

import club.calong.tipper.core.Tipper;

import java.util.HashMap;
import java.util.Map;

public class TipperAction {

    private String name;

    private Map<String, Tipper> tippers = new HashMap<>();

    public Map<String, Tipper> getTippers() {
        return tippers;
    }

    public void setTippers(Map<String, Tipper> tippers) {
        this.tippers = tippers;
    }

    public TipperAction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
