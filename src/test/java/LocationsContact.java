import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;

import org.junit.Assert;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LocationsContact {
    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        // Set up WebDriver (ChromeDriver)
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Before
    public void pageStatus() {
        // Refresh the page
        driver.navigate().refresh();

        // Get current URL
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        // Get and log the current system time
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Current System Time: " + currentTime);
    }

    @Test
    @Order(1)
    public void searchAndSelectLocation() {
        // Click on the fifth link in the eyebrow
        WebElement fifthEyebrowLink = driver.findElement(By.cssSelector("#kh-eyebrow > span.kh-eyebrow-links > a:nth-child(5)"));
        fifthEyebrowLink.click();

        // Wait for page navigation
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("desired_url")); // Replace "desired_url" with the expected URL after navigation

        // Assert that the title contains the word "Location"
        WebElement titleElement = driver.findElement(By.cssSelector("#title-d46b9c01c2 > h1"));
        Assert.assertTrue("Title does not contain 'Location'", titleElement.getText().contains("Location"));

        // Click on the search bar
        WebElement searchBar = driver.findElement(By.cssSelector("your_search_bar_css_selector"));
        searchBar.click();

        // Type 'Washington DC' into the search bar
        searchBar.sendKeys("Washington DC");

        // Click on the specified element
        WebElement specifiedElement = driver.findElement(By.cssSelector("#ChIJW-T2Wt7Gt4kRKl2I1CJFUsI"));
        specifiedElement.click();

        // Click on the 'specialty' selector and type 'cardiology'
        WebElement specialtyInput = driver.findElement(By.cssSelector("#specialty"));
        specialtyInput.sendKeys("cardiology");

        // Select the checkbox
        WebElement checkbox = driver.findElement(By.cssSelector("#main > div.locationsearchbox > div > div > form > div.specialty-input.typeahead-active > div.filter-specialty-list.search-typeahead.search-typeahead__scrollable > ul > li.typeahead-item.typeahead-checkbox-item.active"));
        checkbox.click();

        // Click on the button
        WebElement button = driver.findElement(By.cssSelector("#main > div.locationsearchbox > div > div > form > div.specialty-input.typeahead-active > div.filter-specialty-list.search-typeahead.search-typeahead__scrollable > div > button"));
        button.click();

        // Check if the element is visible and display its text
        WebElement visibleElement = driver.findElement(By.cssSelector("your_visible_element_css_selector"));
        if (visibleElement.isDisplayed()) {
            System.out.println("Visible Element Text: " + visibleElement.getText());
        }
    }

    @Test
    @Order(2)
    public void selectCollabCenters() {
        // Navigate to the webpage
        driver.get("https://www.nemours.org/locations.html");

        // Get the text from the selector
        WebElement normalCountElement = driver.findElement(By.cssSelector("your_selector_for_normal_count"));
        String normalCount = normalCountElement.getText();
        System.out.println("Normal Count: " + normalCount);

        // Click on the specified selector
        WebElement specifiedSelector = driver.findElement(By.cssSelector("#main > div.locationsearchbox > div > div > form > div.locationtype-input.search-filters-buttons > ul > li:nth-child(5) > label"));
        specifiedSelector.click();

        // Get the text from the other selector
        WebElement comparisonElement = driver.findElement(By.cssSelector("#main > div.locationsearchresults > div > div > div.search-results-summary-container > div.search-results-count-summary.active"));
        String comparisonText = comparisonElement.getText();
        System.out.println("Comparison Text: " + comparisonText);

        // Assert that both values are not the same
        Assert.assertNotEquals(normalCount, comparisonText, "Counts are equal");
    }

    @AfterClass
    public static void tearDown() {
        // Close the WebDriver instance
        driver.quit();
    }





}

