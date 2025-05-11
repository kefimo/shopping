package org.unify.model.enums;
public enum Unit {
    TIN("tin"),
    LOAF("loaf"),
    BOTTLE("bottle"),
    BAG("bag");

    private String value;


    Unit(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
