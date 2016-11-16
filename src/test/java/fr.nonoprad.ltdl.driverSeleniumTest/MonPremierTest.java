package fr.nonoprad.ltdl.driverSeleniumTest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class MonPremierTest {

    static WebDriver webDriver;



    @BeforeClass
    public static void beforeClass() throws MalformedURLException {
        webDriver = new RemoteWebDriver(new URL("http://192.168.0.16:4444/wd/hub"), DesiredCapabilities.internetExplorer());
    }

    @AfterClass
    public static void afterClass(){
        webDriver.close();
        webDriver.quit();
    }


   /* @Test
    public void testGoogleFr() throws MalformedURLException {
        webDriver.navigate().to("http://www.google.fr");
        assertEquals("Google", webDriver.getTitle());

    }

    @Test
    public void testLeboncoin() throws MalformedURLException {
        webDriver.navigate().to("http://www.leboncoin.fr");
        assertEquals("leboncoin, site de petites annonces gratuites", webDriver.getTitle());

    }
        */
}
