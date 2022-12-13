package com.lhxone.utils;



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

    public static void main(String[] args) {
        Code code = new Code();
        System.out.println(code.GenerateCode());
    }
}
