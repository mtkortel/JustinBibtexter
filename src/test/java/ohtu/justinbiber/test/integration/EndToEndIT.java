package ohtu.justinbiber.test.integration;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class EndToEndIT {

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

    /* US2: Käyttäjänä voin listata kaikki viitteet. **/
    @Test
    public void listingReferences() {
        String uri = "http://localhost:" + port + "/";
        driver.get(uri);
        assertTrue("The page should contain a reference to Justin",
                driver.getPageSource().contains("Justin"));
    }
    /* US1: Voin lisätä inproceedings -viitteen yksinkertaisilla tiedoilla. **/

    @Test
    public void addingInproceedingsTypeReference() {
    }

    /* US5: Voin lisätä Book, Article- & misc -viitteen yksinkertaisilla
     tiedoilla. Misc viitteessä "howpublished"**/
    @Test
    public void addingBooksArticlesMiscTypeReferences() {
    }

    /* US5: Voin lisätä kaikentyyppisiä viitteitä **/
    @Test
    public void addingAllTypesOfReferences() {
    }

    /* US3: Käyttäjänä haluan, että voin tulostaa BIbtex -muotoisen tiedoston**/
    @Test
    public void generatingBibTex() {
    }

    /* US4: Ääkkösten pitäisi konvertoitua järjestelmään Bibtex -standardin mukaisesti **/
    @Test
    public void specialCharacterConversion() {
    }

    /* US11: Käyttäjä saa valita ID:n **/
    @Test
    public void settingsID() {
    }
}