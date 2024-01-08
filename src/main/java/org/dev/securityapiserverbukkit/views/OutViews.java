package org.dev.securityapiserverbukkit.views;

public enum OutViews {
    TOKEN_FORMAT("토큰: %s\n\n%s초 뒤에 만료됩니다.\n복사되었습니다!!");
    private final String format;

    OutViews(String format) {
        this.format = format;
    }

    public String toString(Object... args) {
        return String.format(format, args);
    }
}
