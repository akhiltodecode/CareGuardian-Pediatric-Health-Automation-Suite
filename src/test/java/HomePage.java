import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

import java.time.LocalDateTime;

public class HomePage {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up WebDriver (ChromeDriver)
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

        try {
            Thread.sleep(2000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void page_status() {
        // Refresh the page
        driver.navigate().refresh();

        // Get current URL
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        // Get and log the current system time
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Current System Time: " + currentTime);
    }

    @Test(priority = 0)
    public void access_Webpage() {
        // Navigate to the healthcare search portal website
        driver.get("https://kidshealth.org/");

        String title_value = driver.getTitle();
        Assert.assertEquals(title_value, "Nemours KidsHealth - the Web's most visited site about children's health", "Title Cannot be Found, Check the Webpage");
    }

    @Test(priority = 1)
    public void checklinksFromHome() {
        // Navigate to the healthcare search portal website
        // Find the ul element with id 'kh-topnav-tabs'
        WebElement ulElement = driver.findElement(By.id("kh-topnav-tabs"));

        // Get all li elements within the ul (tabs)
        List<WebElement> tabElements = ulElement.findElements(By.tagName("li"));

        // List out the tabs
        System.out.println("Tabs:");
        for (WebElement tab : tabElements) {
            System.out.println(tab.getText());
        }

        // Display some contents from the footer
        WebElement footerElement = driver.findElement(By.cssSelector("your_footer_css_selector"));
        System.out.println("Footer Content:");
        System.out.println(footerElement.getText());
    }

    @AfterClass
    public void tearDown() {
        // Close the WebDriver instance
        driver.quit();
    }
}
