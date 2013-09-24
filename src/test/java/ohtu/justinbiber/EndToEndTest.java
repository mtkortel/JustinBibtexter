package ohtu.justinbiber;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class EndToEndTest {
    
    private WebDriver driver;
    private String port;
    
    @Before
    public void setUp() {
        driver = new HtmlUnitDriver();
        port = System.getProperty("jetty.port", "8090");
    }
    
    @Test
    public void weLoveJustin() {
        String uri = "http://localhost:" + port + "/";
        driver.get(uri);
        assertTrue("The page should contain a reference to Justin",
                driver.getPageSource().contains("Justin"));
    }
}