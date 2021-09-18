import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class DrawRocketTest {

    final static String EXPECTED_OUTPUT_DIRECTORY = String.format("tst%1$sExpected_Output%1$s", File.separator);

    private static void setStaticField(Class<?> clazz, String fieldName, Object value) {
        Field field = null;
        try {
            field = clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            Assert.fail(String.format("There is not a field named: %s", fieldName));
        }
        field.setAccessible(true);

        try {
            field.set(null, value);
        } catch (IllegalAccessException e) {
            Assert.fail(String.format("Could not set value of field: %s %s Make sure the field does not have " +
                    "the FINAL modifier", fieldName, System.lineSeparator()));
        }
    }

    private static String captureMainOutput() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream oldOut = System.out;
        System.setOut(ps);

        DrawRocket.main(null);

        System.out.flush();
        System.setOut(oldOut);
        return baos.toString();
    }

    //Need to use this method for cleaning student's output
    //Some students put some whitespace at the end so trim that down
    //This also cleans line separator issue
    //(Expected file doesn't have the whitespace ending)
    private static String cleanWhiteSpaceEndings(String str) {
        StringBuilder sb = new StringBuilder();
        Scanner scan = new Scanner(str);
        while (scan.hasNextLine()) {
            String oneLine = scan.nextLine();
            sb.append(oneLine.replaceFirst("\\s++$", "")); //remove whitespace endings
            sb.append(System.lineSeparator()); //add proper line separator
        }
        return sb.toString();
    }

    //Use this method to read expected output file
    private static String dumpFileContentsToString(String filePath) {
        try {
            String str = Files.readString(Paths.get(filePath));
            return str;
        } catch (IOException e) {
            Assert.fail("Could not load file: " + filePath);
            return null;
        }
    }

    @Test
    public void testSize3() {
        testExpectedOutputWithFile(3);
    }

    @Test
    public void testSize4() {
        testExpectedOutputWithFile(4);
    }

    @Test
    public void testSize5() {
        testExpectedOutputWithFile(5);
    }

    //method used to test the output of DrawRocket against an expected output in a file
    private void testExpectedOutputWithFile(int size) {
        setStaticField(DrawRocket.class, "SIZE", size);
        String studentOutput = captureMainOutput();
        String expectedStr = dumpFileContentsToString(String.format("%sexpected_output_size%s.txt", EXPECTED_OUTPUT_DIRECTORY, size));
        Assert.assertEquals(expectedStr, cleanWhiteSpaceEndings(studentOutput));
    }
}