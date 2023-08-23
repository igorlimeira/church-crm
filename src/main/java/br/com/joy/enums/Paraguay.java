package br.com.joy.enums;

import java.util.Arrays;
import java.util.List;
public enum Paraguay {
    PARAGUAY("Paraguay"),
    PARAGAI("Paraguai");

    private final String value;

    Paraguay(String value) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }
    public static List<String> getAllValues() {
        return Arrays.stream(values()).map(Paraguay::getValue).toList();
    }
}
