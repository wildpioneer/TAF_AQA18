import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void test1() {
        SimpleDriver simpleDriver = new SimpleDriver();
        simpleDriver.getDriver();
    }

    @Test
    public void test2() {
        AdvancedDriver simpleDriver = new AdvancedDriver();
        simpleDriver.getDriver();
    }

    @Test
    public void test3() {
        AdvancedDriver simpleDriver = new AdvancedDriver();
        simpleDriver.getDriver();
    }
}
