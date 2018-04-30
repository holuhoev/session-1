package ru.sbt.jschool.session1;

public class ExtraTasks {
    public static void main(String[] args) {
        System.out.println(longValueOf("123A", 16));
        System.out.println(longValueOf("1000", 2));
        System.out.println(longValueOf("0", 2));
    }

    private static long longValueOf(String s, int radix) {
        long result = 0;
        int i = 0, len = s.length();
        if (len > 0) {
            while (len > i) {
                int digit = Character.digit(s.charAt(i++), radix);
                if (digit < 0) {
                    throw new NumberFormatException(String.format("for input string %s", s));
                }
                result *= radix;
                result += digit;
            }
        } else {
            throw new NumberFormatException(String.format("for input string %s", s));
        }
        return result;
    }


}
