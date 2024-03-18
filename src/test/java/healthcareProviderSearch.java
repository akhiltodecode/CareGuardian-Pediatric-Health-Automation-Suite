import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import java.time.LocalDateTime;

public class healthcareProviderSearch {
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

    @Test(testName = "searchCardiologists")
    public void searchCardiologists1() {
        // Navigate to the healthcare search portal website
        driver.get("https://medlineplus.gov/");

        // Find an element by its CSS selector
        WebElement ele_search = driver.findElement(By.cssSelector("#kh-eyebrow > span.kh-eyebrow-links > a:nth-child(3)"));
        // Interact with the element
        ele_search.click();

        WebElement titleElement = driver.findElement(By.cssSelector("#title-b33dda7b83 > h1"));
        Assert.assertTrue(titleElement.getText().contains("doctor"), "Title does not contain 'doctor'");

        // Find the search input element and type 'cardiologist' then press Enter
        WebElement searchInput = driver.findElement(By.cssSelector("#main > div.searchbox.container-outer-wide > div > div > div > form > div.search-input > input"));
        searchInput.sendKeys("cardiologist");
        searchInput.sendKeys(Keys.ENTER);

        // Wait for the search results summary element
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchResultsSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#main > div.searchresults > div > div > div.search-results-summary-container > div.search-results-count-summary.active")));

        String summaryText = searchResultsSummary.getText();
        if (summaryText.contains("results") && !summaryText.contains("0")) {
            // Test case passes
            System.out.println("Test case passed: Search returned results.");
        } else {
            // Test case fails
            System.out.println("Test case failed: Search did not return results for Cardiologists.");
        }
    }

    @Test(testName = "selectProvider")
    public void testCase2() {
        WebElement firstResultLink = driver.findElement(By.cssSelector("#main > div.searchresults > div > div > div.search-results-container.fad > ul > li:nth-child(1) > div > div.button.button-link-default > a > span.cmp-button__text"));
        firstResultLink.click();

        // Wait for page to divert
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("redirected_page_url")); // Replace "redirected_page_url" with the URL of the redirected page

        // Get the value inside the element
        WebElement valueElement = driver.findElement(By.cssSelector("your_selector_here"));
        String value = valueElement.getText();
        System.out.println("Value: " + value);

        // Verify that the length of the value is between 9 and 12
        int length = value.length();
        Assert.assertTrue(length > 9 && length < 12, "Length of value is not between 9 and 12");

    }

    @AfterClass
    public void tearDown() {
        // Close the WebDriver instance
        driver.quit();
    }
}
