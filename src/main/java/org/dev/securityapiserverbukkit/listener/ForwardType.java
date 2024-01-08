package org.dev.securityapiserverbukkit.listener;

public enum ForwardType {
    FORWARD_TO_PLAYER("ForwardToPlayer");
    private final String name;
    ForwardType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
