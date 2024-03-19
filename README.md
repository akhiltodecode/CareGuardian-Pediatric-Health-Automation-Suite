# CareGuardian-Pediatric-Health-Automation-Suite
CareGuardian is a comprehensive automation suite designed for testing pediatric healthcare websites. Powered by Selenium, Junit, TestNG &amp; Maven, it ensures the seamless functioning of features, enhancing the digital experience for both patients and educators.
It leverages TestNG, JUnit, Selenium, and Maven for dependency management and test automation. The project focuses on testing various modules of the healthcare website, covering functionalities relevant to parents, educators, location searches, home page navigation, finding providers, and more.

Please Note: This project is a work in progress and contains modules that are yet to be implemented. However, it provides an overview of the power of Selenium with TestNG and JUnit for various types of testing scenarios.

## Modules

The project is organized into the following modules:

1. **Parent Module**
   - Accessing Healthcare Webpage for Kids Care
   - Verifying Topics Relevant to Parents
   - Navigating to Parents Page and Verifying Content

2. **Educator Module**
   - Navigating to Educator Page and Clicking on "Read More" Button
   - Accessing Facility by Typing in Search Box

3. **Location Contacts Module**
   - Searching a Location and Selecting Location from Drop-down
   - Selecting a Category of Healthcare Center and Verifying Results

4. **Home Page Module**
   - Checking Links/Tabs Navigation
   - Verifying Footer Context

5. **FindProviders Module**
   - Navigating to Find Doctors Page
   - Searching for a Specialist like Cardiologist
   - Contacting a Specific Doctor

## Test Cases

### Parent Module
1. **Accessing Healthcare Webpage for Kids Care**
   - Verify successful access to the healthcare webpage for kids care.

2. **Verifying Topics Relevant to Parents**
   - Verify the relevance of 10 topics for parents.

3. **Navigating to Parents Page and Verifying Content**
   - Navigate to the parents page and verify the content.

### Educator Module
1. **Navigating to Educator Page and Clicking on "Read More" Button**
   - Navigate to the educator page and click on the "Read More" button.

2. **Accessing Facility by Typing in Search Box**
   - Access a facility by typing in the search box and wait for the response.

### Location Contacts Module
1. **Searching a Location and Selecting Location from Drop-down**
   - Search for a location and select it from the drop-down list.

2. **Selecting a Category of Healthcare Center and Verifying Results**
   - Select a category of healthcare center and verify the results.

### Home Page Module
1. **Checking Links/Tabs Navigation**
   - Check the functionality of links and tabs navigating to respective pages.

2. **Verifying Footer Context**
   - Verify the context of the footer.

### FindProviders Module
1. **Navigating to Find Doctors Page**
   - Navigate to the find doctors page.

2. **Searching for a Specialist like Cardiologist**
   - Search for a cardiologist and verify the results.

3. **Contacting a Specific Doctor**
   - Contact a specific doctor listed on the website.

##Test Suite Execution
### Parent Module
-> **Accessing Healthcare Webpage for Kids Care** | **Verifying Topics Relevant to Parents** | **Navigating to Parents Page and Verifying Content**
   -> mvn test -DsuiteXmlFile=resources/ForParents.xml

### Educator Module
-> **Navigating to Educator Page and Clicking on "Read More" Button** | **Accessing Facility by Typing in Search Box**
   -> mvn test -DsuiteXmlFile=resources/ForEducators.xml

### Location Contacts Module
-> **Searching a Location and Selecting Location from Drop-down** | **Selecting a Category of Healthcare Center and Verifying Results**
   -> mvn test -DsuiteXmlFile=resources/LocationsContacts.xml

### Home Page Module
-> **Checking Links/Tabs Navigation** | **Verifying Footer Context**
   -> mvn test -DsuiteXmlFile=resources/HomePage.xml

### FindProviders Module
-> **Navigating to Find Doctors Page** | **Searching for a Specialist like Cardiologist** | **Contacting a Specific Doctor**
   -> mvn test -DsuiteXmlFile=resources/FindProviders.xml

## Test Execution Flow

Each module follows a similar test execution flow:

**Before Class:** Setup tasks such as opening the browser and navigating to the website.

**Before Each Test Case:** Refresh the page and display or save the URL.

**Test Cases:** Execute the test cases specific to the module.

**After Class:** Cleanup tasks such as closing the browser.

## Dependencies
The project uses the following dependencies managed by Maven:
- **TestNG:** For organizing and executing tests.
- **JUnit:** For unit testing capabilities.
- **Selenium:** For automating web browser interactions.
- **Maven:** For project management and dependency resolution.

## Setup Instructions
1. Clone the project repository from GitHub.
2. Ensure you have Java and Maven installed on your system.
3. Configure Selenium WebDriver for your preferred browser (e.g., Chrome).
4. Install any required dependencies specified in the `pom.xml` file.
5. Configure test data and environment variables as necessary.
6. Run the tests using Maven commands (`mvn test`)

Contributors
Contributions are welcome! Please submit pull requests or open issues to contribute to the project.
