package io.lenar.exercise.expeditors;

import io.lenar.files.NetworkResource;
import io.lenar.files.Resource;
import io.lenar.files.ResourceFile;
import io.lenar.files.UserFile;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static Map<String, String> params = new HashMap<>();
    public static SourceType source = SourceType.RESOURCE;
    public static String path = "input.txt";

    enum SourceType {
        FILE_SYSTEM, RESOURCE, NETWORK;
    }

    public static void main(String[] args) throws IOException {
        params = extractParamsMap(args);
        Resource resource = getResource();
        List<Person> people = getPeople(resource);
        printReport(people);
    }

    private static void printReport(List<Person> people) {
        people.stream().collect(Collectors.groupingBy(Person::getAddress))
                .entrySet().stream().forEach(household -> {
                    System.out.println("\nHOUSHOLD <" + household.getKey() + "> with " + household.getValue().size() + " occupants:");
                    household.getValue().stream().filter(Person::isAdult).sorted().forEach(System.out::println);
                });
    }

    private static Resource getResource() {
        if (params.containsKey("path")) {
            path = params.get("path");
            if (params.containsKey("source")) {
                source = SourceType.valueOf(params.get("source"));
            }
        }
        switch (source) {
            case FILE_SYSTEM:
                return new UserFile(path);
            case NETWORK:
                return new NetworkResource(path);
            case RESOURCE:
            default: return new ResourceFile(path);
        }
    }

    private static List<Person> getPeople(Resource resource) throws IOException {
        return resource.lines().stream().map(Person::new).collect(Collectors.toList());
    }

    public static Map<String, String> extractParamsMap(String[] args) {
        Map<String, String> params = new HashMap<>();
        for (String arg : args) {
            String[] argArray = arg.split("=");
            if (argArray.length == 2) {
                params.put(argArray[0], argArray[1]);
            }
        }
        if (System.getProperty("path") != null) {
            params.put("path", System.getProperty("path"));
        }
        if (System.getProperty("source") != null) {
            params.put("source", System.getProperty("source"));
        }
        return params;
    }

}
