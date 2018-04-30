package ru.sbt.jschool.session1;

import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class MainTask {
    private static BiConsumer<Object, Object> sout = (key, value) -> System.out.format("%s=%s;\n", key, value);

    public static void main(String[] args) {
        printArguments(args);
        printSystemProperties();
        printEnv();
    }

    private static void printArguments(String... args) {
        System.out.println("Arguments: ");
        Stream.of(args).forEach(System.out::println);
    }

    private static void printSystemProperties() {
        System.out.println("\nSystem properties:");
        System.getProperties().forEach(sout);
    }

    private static void printEnv() {
        System.out.println("\nEnv:");
        System.getenv().forEach(sout);
    }
}
