package com.susannelson;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class FileSamples {

    private final static String INPUT_FILE_PATH = "/com/susannelson/file.txt";
    private final static String OUTPUT_FILE_PATH = "/src/main/java/com/susannelson/sorted_file.txt";

    public void sortFileRecordsBySecondField() {

        List<String> inputLInes = readInputFile();
        Map<Integer, Set<String>> sortedLines = sortBySecondField(inputLInes);
        writeSortedFile(sortedLines);
    }

    //java 8 stream is fast and doesn't cause memory errors with large files
    public void readFileWithJava8Stream() throws URISyntaxException {

        long startTime = System.nanoTime();
        //Path file = Paths.get("c:/temp/my-large-file.csv");
        Path file = Paths.get(getClass().getResource(INPUT_FILE_PATH).toURI());

        try
        {
            //Java 8: Stream class
            Stream<String> lines = Files.lines(file, StandardCharsets.UTF_8);

            for( String line : (Iterable<String>) lines::iterator )
            {
                System.out.println(line);
            }

        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        long endTime = System.nanoTime();
        long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
        System.out.println("Total elapsed time: " + elapsedTimeInMillis + " ms");
    }

    Map<Integer, Set<String>> sortBySecondField(List<String> inputLines) {

        Map<Integer, Set<String>> sortedLines = new TreeMap<>();
        Set<String> linesByKey;
        String[] fields;
        Integer key;

        for (String line: inputLines) {

            fields = line.split(",");

            if (fields.length > 1) {

                key = Integer.valueOf(fields[1]);

                if (sortedLines.containsKey(key)) {

                    linesByKey = sortedLines.get(key);
                    linesByKey.add(line);
                } else {
                    linesByKey = new HashSet<>();
                    linesByKey.add(line);
                    sortedLines.put(key, linesByKey);
                }
            } //else ignore
        }

        return sortedLines;
    }

    private List<String> readInputFile() {

        final List<String> fileLines = new ArrayList<>();

        try (InputStream stream = getClass().getResourceAsStream(INPUT_FILE_PATH);
             BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (StringUtils.isNotEmpty(line)) {

                    fileLines.add(line);
                }
            }
        } catch (Exception e) {

            throw new RuntimeException("Not able to read file lines: " + e.getMessage());
        }

        return fileLines;
    }

    private void writeSortedFile(Map<Integer, Set<String>> sortedLines) {

        String basePath = this.getModulePath("samples");
        try (PrintWriter out = new PrintWriter(new BufferedWriter(
                new FileWriter(basePath + OUTPUT_FILE_PATH)))) {

            for (Set<String> lines : sortedLines.values()) {

                for (String line : lines) {

                    out.println(line);
                }
            }
        } catch (Exception e) {

            throw new RuntimeException("Not able to write sorted lines: " + e.getMessage());
        }
    }

    /**
     * This returns the path of the module.
     *
     * The logic addresses the rootDir being either: <br/>
     * 1. trunk (within Eclipse) <br/>
     * 2. trunk/&lt;module&gt; (within Eclipse) <br/>
     * 3. trunk/build (within Ant build)
     */
    private String getModulePath(String module) {

        String rootDir = System.getProperty("user.dir");
        String moduleRoot = rootDir;
        File file;
        // Covers within Eclipse...
        // if the rootDir is not already the module directory then append
        // "/<module>"
        if (!rootDir.endsWith(module)) {
            moduleRoot = rootDir + "/" + module;
        }
        file = new File(moduleRoot);
        if (file.isDirectory()) {
            return file.getAbsolutePath();
        }

        Assert.fail("Invalid module path, " + moduleRoot + ", for root " + rootDir);
        return null;
    }
}
