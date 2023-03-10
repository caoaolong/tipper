package club.calong.tipper.domain.core;

import java.util.HashMap;
import java.util.Map;

public class TipperModule {

    private String name;

    private Map<String, TipperAction> actions = new HashMap<>();

    public Map<String, TipperAction> getActions() {
        return actions;
    }

    public void setActions(Map<String, TipperAction> actions) {
        this.actions = actions;
    }

    public TipperModule(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
