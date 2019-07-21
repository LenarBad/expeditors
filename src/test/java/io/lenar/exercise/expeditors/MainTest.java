package io.lenar.exercise.expeditors;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

import static io.lenar.exercise.expeditors.Main.extractParamsMap;
import static org.testng.Assert.assertEquals;

public class MainTest {

    @DataProvider
    public Object[][] extractParamsData() {
        return new Object[][] {
                {new String[] {"source=testsource", "path=testpath"}, "testsource", "testpath"},
                {new String[] {"path=testpath"}, null, "testpath"},
                {new String[] {"source=testsource"}, "testsource", null},
                {new String[] {}, null, null}
        };
    }

    @Test(dataProvider = "extractParamsData")
    public void extractParamsFromMainMethodArgsTest(String[] args, String source, String path) {
        Map<String, String> params = extractParamsMap(args);
        assertEquals(params.get("source"), source);
        assertEquals(params.get("path"), path);
    }


}
