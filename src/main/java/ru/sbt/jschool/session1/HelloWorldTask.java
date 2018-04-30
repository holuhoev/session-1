package ru.sbt.jschool.session1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HelloWorldTask {
    private static String PARAM_NAME = "JSCHOOl1_COUNT";
    private static String PROPERTY_FILE_PARAM = "JSCHOOL1_PROPERTIES_FILE";

    public static void main(String[] args) throws IOException {
        int count = 0;
        boolean isCountExist;
        Optional<String> param = Stream.of(args)
                .filter(s -> s.matches(PARAM_NAME + "=[0-9]+"))
                .findFirst();
        if (isCountExist = param.isPresent()) {
            count = Integer.parseInt(param.get().substring((PARAM_NAME + "=").length(), param.get().length()));
        }

        if (!isCountExist && (isCountExist = (System.getProperty(PARAM_NAME) != null))) {
            count = Integer.parseInt(System.getProperty(PARAM_NAME));
        }

        if (!isCountExist && (isCountExist = System.getenv().containsKey(PARAM_NAME))) {
            count = Integer.parseInt(System.getenv().get(PARAM_NAME));
        }

        if (!isCountExist && System.getenv().containsKey(PROPERTY_FILE_PARAM)) {
            Properties properties = new Properties();
            properties.load(Files.newInputStream(Paths.get(System.getenv(PROPERTY_FILE_PARAM))));
            count = Integer.parseInt(properties.getProperty(PARAM_NAME));
            isCountExist = true;
        }

        if (isCountExist) {
            IntStream.range(0, count)
                    .forEach(index -> {
                        System.out.println("Hello, world!");
                    });
        } else {
            System.out.println("Please, README");
        }
    }
}
