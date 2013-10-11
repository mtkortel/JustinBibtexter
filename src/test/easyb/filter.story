import ohtu.justinbiber.*
import org.openqa.selenium.*
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import com.gargoylesoftware.htmlunit.WebClient
import org.openqa.selenium.support.ui.Select

description 'User can filter results'

port = System.getProperty("jetty.port", "8090")
driver = new HtmlUnitDriver() {
    protected WebClient modifyWebClient(final WebClient client) {
        client.setCssEnabled(false)
        return client
    }
}
driver.setJavascriptEnabled(true)

scenario "user can search with a simple search term from any field", {
    given 'user has navigated to the site', {
        driver.get("http://localhost:" + port)
    }

    when 'user enters simple search term', {
        driver.findElement(By.id("query")).sendKeys("Mannila")
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click()
    }

    then 'the page should contain corresponding result', {
        driver.getPageSource().contains("Mannila").shouldBe true
    }
}

scenario "user can search with multiple search terms", {
    given 'user has navigated to the site', {
        driver.get("http://localhost:" + port)
    }

    when 'user enters two search terms', {
        System.out.println(driver.findElement(By.id("entrycount")).getText())
        driver.findElement(By.id("query")).sendKeys("Caspersen international")
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click()
    }

    then 'the page should contain references that include both terms', {
        driver.findElement(By.id("entrycount")).getText().shouldBe "1"
        //System.out.println(driver.findElement(By.id("entrycount")).getText())
        //System.out.println(driver.findElementByXPath('//dd[text()[contains(., "Roumani, Hamzeh")]]'))
        //System.out.println(driver.findElementByXPath('//dd[text()[contains(., "Roumani, Hamzeh")]]').isDisplayed())
        //driver.findElementByXPath('//dd[text()[contains(., "Roumani, Hamzeh")]]').isDisplayed().shouldBe false
        //driver.findElementById("entry_102").isDisplayed().shouldBe true
        //driver.findElementById("entry_28").isDisplayed().shouldBe false
        //driver.findElementByXPath('//*[contains(text(), "Caspersen, Michael E. and Bennedsen, Jens")]').isDisplayed().shouldBe true
        //driver.findElementByXPath('//*[contains(text(), "Roumani, Hamzeh")]').isDisplayed().shouldBe false
        //driver.findElementByXPath('//*[text()[contains(.,"Caspersen, Michael E. and Bennedsen, Jens")]]').isDisplayed().shouldBe true
        //driver.findElementByXPath('//*[text()[contains(.,"Roumani, Hamzeh")]]').isDisplayed().shouldBe false
    }
}

scenario "the search should be case-insensitive", {
    given 'user has navigated to the site', {
        driver.get("http://localhost:" + port)
    }

    when 'user enters a search term with lower case characters', {
        driver.findElement(By.id("query")).sendKeys("ieee")
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click()
    }

    then 'the page should contain references with upper case characters too', {
        driver.findElement(By.id("entrycount")).getText().shouldBe "1"
        //driver.findElementByXPath('//*[text()[contains(.,"IEEE Computer Society")]]').isDisplayed().shouldBe true
        //driver.findElementByXPath('//*[contains(text(), "Design guidelines for the lab component of objects-first CS1")]').isDisplayed().shouldBe false
    }
}

scenario "user can search references with specific keys", {
    given 'user has navigated to the site', {
        driver.get("http://localhost:" + port)
    }

    when 'user enters a partial key to a reference', {
        driver.findElement(By.id("query")).sendKeys("#03")
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click()
    }

    then 'the page should contain only references with keys that include the search term', {
        driver.findElement(By.id("entrycount")).getText().shouldBe "2"
        //driver.findElementByXPath('//*[text()[contains(.,"Anthony Robins and Janet Rountree and Nathan Rountree")]]').isDisplayed().shouldBe true
        //driver.findElementByXPath('//*[contains(text(), "An approach to teaching Java using computers")]').isDisplayed().shouldBe true
        //driver.findElementByXPath('//*[contains(text(), "Learning and teaching programming: A review and discussion")]').isDisplayed().shouldBe false
    }
}

scenario "user can search references of particular type", {
    given 'user has navigated to the site', {
        driver.get("http://localhost:" + port)
    }

    when 'user enters a partial reference type', {
        driver.findElement(By.id("query")).sendKeys("@npr")
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click()
    }

    then 'the page should contain only references of that specific type', {
        driver.findElement(By.id("entrycount")).getText().shouldBe "8"
        //driver.getPageSource().contains("@inproceedings").shouldBe true
        //driver.getPageSource().contains("@article").shouldBe false
        //driver.getPageSource().contains("@book").shouldBe false
    }
}

scenario "user can bookmark a search page", {
    given 'user has navigated to the site with a query url', {
        driver.get("http://localhost:" + port + "/app/list?query=Anthony+Robins");
    }

    when 'user views the site', {
    }

    then 'the page should contain the correct search results', {
        driver.getPageSource().contains("Anthony Robins").shouldBe true
        //driver.getPageSource().contains("Roumani").shouldBe false
    }
}

scenario "user can search a key value pair", {
    given 'user has navigated to the site', {
        driver.get("http://localhost:" + port);
    }

    when 'user enters a partial key value pair', {
        driver.findElement(By.id("query")).sendKeys("vol:22")
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click()
    }

    then 'the page should contain only references with the specified key-value pair', {
        driver.findElement(By.id("entrycount")).getText().shouldBe "1"
        //driver.getPageSource().contains("Helping novice programming students succeed").shouldBe true
        //driver.getPageSource().contains("Design guidelines for the lab component of objects-first CS1").shouldBe false
        //driver.getPageSource().contains("A survey of literature on the teaching of introductory programming").shouldBe false
    }
}

scenario "user can search with a field key", {
    given 'user has navigated to the site', {
        driver.get("http://localhost:" + port);
    }

    when 'user enters a partial field key', {
        driver.findElement(By.id("query")).sendKeys("publish:")
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click()
    }

    then 'the page should contain only references with the specified field key', {
        driver.findElement(By.id("entrycount")).getText().shouldBe "17"
        //driver.getPageSource().contains("Roumani").shouldBe true
        //driver.getPageSource().contains("Learning and teaching programming: A review and discussion").shouldBe false
    }
}

scenario "user can search with a field value", {
    given 'user has navigated to the site', {
        driver.get("http://localhost:" + port);
    }

    when 'user enters a partial field value', {
        driver.findElement(By.id("query")).sendKeys(":08")
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click()
    }

    then 'the page should contain only references with the specified field value', {
        driver.findElement(By.id("entrycount")).getText().shouldBe "1"
        //driver.getPageSource().contains("Martin, Robert").shouldBe true
        //driver.getPageSource().contains("Guide to the Software Engineering Body of Knownledge").shouldBe false
    }
}

scenario "empty search terms should not filter results", {
    given 'user has navigated to the site', {
        driver.get("http://localhost:" + port);
    }

    when 'user enters an incomplete search term', {
        driver.findElement(By.id("query")).sendKeys("@ # :")
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click()
    }

    then 'the page should contain all results', {
        driver.findElement(By.id("entrycount")).getText().shouldBe "22"
    }
}

scenario "user can search with a complex combination of terms", {
    given 'user has navigated to the site', {
        driver.get("http://localhost:" + port);
    }

    when 'user enters multiple search terms', {
        driver.findElement(By.id("query")).sendKeys("@npr a:g :04")
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click()
    }

    then 'the page should only the appropriate results', {
        driver.findElement(By.id("entrycount")).getText().shouldBe "2"
        //driver.findElement(By.id("entrycount")).getText().shouldBe "1"
        //driver.getPageSource().contains("Kölling Michael").shouldBe true
        //driver.getPageSource().contains("Grissom").shouldBe false
    }
}
