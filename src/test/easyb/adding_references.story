import ohtu.justinbiber.*
import org.openqa.selenium.*
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import com.gargoylesoftware.htmlunit.WebClient
import org.openqa.selenium.support.ui.Select



description 'User can add different types of references'

port = System.getProperty("jetty.port", "8090")
driver = new HtmlUnitDriver() {
    protected WebClient modifyWebClient(final WebClient client) {
        client.setCssEnabled(false)
        return client;
    }
}
driver.setJavascriptEnabled(true)

scenario "user can go to webapp and look at the page in awe", {
    given 'user has navigated to the site', {
        driver.get("http://localhost:" + port)
    }

    when 'nothing else in particular', {
    }

    then 'the page should contain a reference to Justin', {
        driver.getPageSource().contains("Justin").shouldBe true
    }
}

scenario "user can add an inproceedings-type reference with required fields", {
    given 'command add new selected and inproceedings selected', {
        driver.get("http://localhost:" + port)
        driver.findElement(By.linkText("Add new")).click()
    }

    when 'required fields are filled', {
        driver.findElement(By.id("inproceedings_author")).sendKeys("Selena Gomez")
        driver.findElement(By.id("inproceedings_title")).sendKeys("ak")
        driver.findElement(By.id("inproceedings_booktitle")).sendKeys("Tell Me Something I Don't Know")
        driver.findElement(By.id("inproceedings_year")).sendKeys("2004")
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click()
    }

    then 'new reference is added to the system', {
        driver.getPageSource().contains("Selena Gomez").shouldBe true
    }
}

/*
scenario "user can not add a reference with the required fields empty", {
    given 'command add new selected', {
        driver.get("http://localhost:" + port)
        driver.findElement(By.linkText("Add new")).click()
    }

    when 'required fields are left empty', {
           driver.findElement(By.cssSelector("input[type=\"submit\"]")).click()
    }

    then 'new reference is not added to the system', {
        driver.getPageSource().contains("Required fields").shouldBe true
    }
}
*/

scenario "user can add an article-type reference", {
    given 'command add new selected and type article selected', {
        driver.get("http://localhost:" + port)
        element = driver.findElement(By.linkText("Add new"));
        element.click();


        element  = driver.findElement(By.id("bibtype"));
        element.click();

        Select select = new Select(driver.findElement(By.xpath("//select")));
        select.selectByVisibleText("article");

    }

    when 'required fields are filled somewhat convincingly', {
        element = driver.findElement(By.name("article_author"));
        element.sendKeys("Jacque Pyles");
        element = driver.findElement(By.name("article_title"));
        element.sendKeys("Just Friends? - A Case Study");
        element = driver.findElement(By.name("article_journal"));
        element.sendKeys("Journal of Justin's Early Life Relationship Failures");
        element = driver.findElement(By.name("article_year"));
        element.sendKeys("2009");

          driver.findElement(By.cssSelector("input[type=\"submit\"]")).click()
    }

    then 'new reference is added to the system', {
        driver.getPageSource().contains("Jacque Pyles").shouldBe true
    }
}

scenario "user can add references with special characters", {
    given 'command add new selected and type book selected', {
        driver.get("http://localhost:" + port)
        element = driver.findElement(By.linkText("Add new"));
        element.click();
         element  = driver.findElement(By.id("bibtype"));
        element.click();

        Select select = new Select(driver.findElement(By.xpath("//select")));
        select.selectByVisibleText("book");
    }

    when 'required fields are filled', {
        element = driver.findElement(By.name("book_author"));
        element.sendKeys("Äiti Åkerlund");
        element = driver.findElement(By.name("book_title"));
        element.sendKeys("Elä hyvä elämä ja tienaa \$5\$5\$5\$5\$5");
        element = driver.findElement(By.name("book_publisher"));
        element.sendKeys("Öisin nukutaan kustannus");
        element = driver.findElement(By.name("book_year"));
        element.sendKeys("1886");

         driver.findElement(By.cssSelector("input[type=\"submit\"]")).click()
    }

    then 'new reference is added to the system', {
        driver.getPageSource().contains("Äiti Åkerlund").shouldBe true
        driver.getPageSource().contains("Elä hyvä elämä").shouldBe true
        driver.getPageSource().contains("tienaa \$5\$5\$5\$5\$5").shouldBe true
        driver.getPageSource().contains("Öisin nukutaan").shouldBe true
    }

    scenario "user can add misc with special characters", {
    given 'command add new selected and type misc selected', {
        driver.get("http://localhost:" + port)
        element = driver.findElement(By.linkText("Add new"));
        element.click();
         element  = driver.findElement(By.id("bibtype"));
        element.click();

        Select select = new Select(driver.findElement(By.xpath("//select")));
        select.selectByVisibleText("misc");
    }

    when 'required fields are filled', {
        element = driver.findElement(By.name("misc_author"));
        element.sendKeys("Åke Böyhä");
        element = driver.findElement(By.name("misc_title"));
        element.sendKeys("Äiti lähetä \$5\$5\$5\$5\$5");
        element = driver.findElement(By.name("misc_howpublished"));
        element.sendKeys("pulloposti");
        element = driver.findElement(By.name("misc_month"));
        element.sendKeys("ääöö");
        element = driver.findElement(By.name("misc_note"));
        element.sendKeys("ö ä å");
        element = driver.findElement(By.name("misc_year"));
        element.sendKeys("123");

         driver.findElement(By.cssSelector("input[type=\"submit\"]")).click()
    }

    then 'new reference is added to the system', {
        driver.getPageSource().contains("Åke Böyhä").shouldBe true
        driver.getPageSource().contains("pulloposti").shouldBe true
        driver.getPageSource().contains("Äiti lähetä \$5\$5\$5\$5\$5").shouldBe true
        driver.getPageSource().contains("ääöö").shouldBe true
        driver.getPageSource().contains("ö ä å").shouldBe true
        driver.getPageSource().contains("123").shouldBe true
    }
    }
        scenario "user can add misc with special characters and review of it is ok", {
    given 'command add new selected and type misc selected', {
        driver.get("http://localhost:" + port)
        element = driver.findElement(By.linkText("Add new"));
        element.click();
         element  = driver.findElement(By.id("bibtype"));
        element.click();

        Select select = new Select(driver.findElement(By.xpath("//select")));
        select.selectByVisibleText("misc");
    }

    when 'required fields are filled and submitted', {
        element = driver.findElement(By.name("misc_author"));
        element.sendKeys("seppo");
        element = driver.findElement(By.name("misc_title"));
        element.sendKeys("Äiti lähetä \$5\$5\$5\$5\$5");
        element = driver.findElement(By.name("misc_year"));
        element.sendKeys("123");

        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click()

        element = driver.findElement(By.linkText("Preview"));
        element.click();

    }

    then 'new reference seems right in bibtex preview', {
       driver.getPageSource().contains("author = {seppo},").shouldBe true
       driver.getPageSource().contains("@misc{,").shouldBe true
        driver.getPageSource().contains("}").shouldBe true
    }
    }
}