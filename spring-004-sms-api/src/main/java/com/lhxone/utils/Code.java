package com.lhxone.utils;


import java.util.Objects;

public class Code {
    private String code;



    public String GenerateCode() {
        long currentTimeMillis = System.currentTimeMillis();
        long random = (long) Math.random();
        String code;
        code = String.valueOf((currentTimeMillis ^ random) % 1000000);
        this.code = code;
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Code code1 = (Code) o;
        return Objects.equals(code, code1.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
