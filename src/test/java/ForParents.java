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

public class ForParents {
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
    public void verify_Topics() {
        // List of expected values
        List<String> expectedValues = Arrays.asList(
                "General Health",
                "Growth & Development",
                "Infections",
                "Diseases & Conditions",
                "Pregnancy & Baby",
                "Nutrition & Fitness",
                "Emotions & Behavior",
                "School & Family Life",
                "First Aid & Safety",
                "Doctors & Hospitals",
                "Videos",
                "Expert Answers (Q&A)"
        );

        // Locate the ul element
        WebElement ulElement = driver.findElement(By.tagName("ul"));

        // Get all li elements within the ul
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));

        // Assert each value against the text content of the li elements
        for (int i = 0; i < expectedValues.size(); i++) {
            String expectedValue = expectedValues.get(i);
            String actualValue = liElements.get(i).getText();

            assert actualValue.equals(expectedValue) : "Value mismatch: Expected '" + expectedValue + "', Actual '" + actualValue + "'";
        }
    }
    @Test(priority = 2)
    public void parentsPage_Access() {
        // Click on the element
        WebElement elementToClick = driver.findElement(By.cssSelector("#kh-parents-subnav > div > div.kh-section-subnav-row3.desk-nav-only > ul > li:nth-child(1) > a"));
        elementToClick.click();

        // Wait for 5 seconds for page diversion
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("https://kidshealth.org/en/parents/")); // Replace "redirected_page_url" with the URL of the redirected page

        // Assert text of another element on the redirected page
        WebElement elementToAssert = driver.findElement(By.cssSelector("#wch2_6"));
        String expectedText = "Managing Your Toddler's Behavior";
        String actualText = elementToAssert.getText();
        assert actualText.equals(expectedText) : "Text assertion failed: Expected '" + expectedText + "', but found '" + actualText + "'";
    }

    @AfterClass
    public void tearDown() {
        // Close the WebDriver instance
        driver.quit();
    }
}
