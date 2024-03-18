import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Arrays;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.Keys;

public class ForEducators {
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

    @Test(testName = "navigate_Educator_basic")
    public void navigate_Educator() {

        // Find the element with empty testName attribute and click on it
        WebElement element = driver.findElement(By.cssSelector("[testName='']"));
        element.click();

        // Assert that the URL contains "classroom"
        assert driver.getCurrentUrl().contains("classroom") : "URL does not contain 'classroom'";

        // Find the ul element containing the lists
        WebElement ulElement = driver.findElement(By.cssSelector("ul"));

        // Get all li elements within the ul
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));

        // Display the values of the lists
        for (WebElement liElement : liElements) {
            System.out.println(liElement.getText());
        }

        // Click on the "Read More" button
        WebElement readMoreButton = driver.findElement(By.cssSelector("button.read-more"));
        readMoreButton.click();

        // Wait for redirection to a page containing the URL string "Grade"
        // You can use WebDriverWait or other mechanisms to wait for the URL condition

        // Assert that the redirected URL contains "Grade"
        assert driver.getCurrentUrl().contains("Grade") : "URL does not contain 'Grade'";
    }

    @Test(testName = "searchLessonWaterSafety")
    public void searchingfacility() {
        // Find the element to click and send values
        WebElement searchElement = driver.findElement(By.cssSelector("#q"));

        // Click on the search element
        searchElement.click();

        // Send values to search
        searchElement.sendKeys("Water Safety");

        // Press Enter to initiate search
        searchElement.sendKeys(Keys.ENTER);

        // Get the current URL
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
    }

    @AfterClass
    public void tearDown() {
        // Close the WebDriver instance
        driver.quit();
    }
}
