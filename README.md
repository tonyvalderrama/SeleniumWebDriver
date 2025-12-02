# Selenium WebDriver
This project contains automated UI tests using **Selenium WebDriver** on the practice website **[https://the-internet.herokuapp.com](https://the-internet.herokuapp.com)**.  
The goal is to practice using the **Page Object Model (POM)** and to automate **3 linear scenarios** of 8–10 simple steps each.

## Technologies & Tools
-   **Language:** Java
-   **Automation Framework:** Selenium WebDriver
-   **Design Pattern:** Page Object Model (POM)
-   **Test Runner:** TestNG
-   **Build Tool:** Maven

## Requirements
- Use **WebDriver API** as much as possible  (browser navigation, clicks, switchTo, etc.)
- Use several **locator strategies**, i.e. different types of locators (and select the most suitable in your case)
- Experiment with **waits** (implicit and explicit)
- Extend your scenario with usage of **Page Object** / **Page Factory** patterns.

## Improvements
- Renamed PageClasses folder to PageObjects for a more consistent namestyle
- Created a more consistent package naming: `com.epam.tat.module7`
- Centralized the baseURLs (in `config/ConfigURLs,java`)
- Added TextNG config files
  - Added smoke, regression and all test groups
  - Added appropriate xml files in the `resources` folder
- Added the Maven commands to run tests at the end of this file
- Modified LoginTest to use a DataProvider instead of hardcoding values

## Test Scenarios
### Scenario 1: Successful and unsuccessful Login (Form Authentication)
#### Tests
1. Both tests:
   - Open the browser (Chrome)
   - Navigate to the homepage.
   - Click the link **“Form Authentication”**
   - Wait for the Login page to load.
2. On the Successful Login:
   - Enter username: `tomsmith`.
   - Enter password: `SuperSecretPassword!`
   - Click the **Login** button.
   - See if the Secure Area page is loaded.
3. On the unsuccessful Login test:
    - Enter username: `johndoe`.
    - Enter password: `SomeOtherPassword!`
    - Click the **Login** button.
    - Verify that the Secure Area page couldn't load.

#### Notes
- Test Class: **LoginTest**
---
### Scenario 2: Add and Remove Elements
#### Test Steps
1.  Open browser and navigate to the homepage.    
2.  Click the link **“Add/Remove Elements”**.    
3.  Wait for the page to load.    
4.  Click the **Add Element** button twice.
5.  Verify that two **Delete** buttons are displayed.
6.  Click the first **Delete** button.
7.  Verify only one **Delete** button remains.
8.  Click the remaining **Delete** button.
9.  Verify that no **Delete** buttons are visible.

#### Notes
- Test Class: **AddRemoveElementsTest**
---
### Scenario 3: Checkboxes Interaction
#### Test Steps
1.  Open browser and navigate to the homepage.
2.  Click the link **“Checkboxes”**.
3.  Wait for the page to load.
4.  Verify Checkbox 1 is **unchecked**.
5.  Click Checkbox 1.
6.  Confirm Checkbox 1 is now **checked**.
7.  Verify Checkbox 2 is **checked** by default.
8.  Click Checkbox 2 to uncheck it.
9.  Confirm Checkbox 2 is **unchecked**.
10.  Click Checkbox 2 again to check it back.

#### Notes
- Test Class: **CheckboxTest**
---
### Scenario 4: Multiple Windows
#### Test Steps
1. Open browser and navigate to the homepage.
2. Click the **Multiple Windows** link to go to that test page.
3. On the Multiple Windows page click **Click Here**.
4. Wait for the new window to appear and switch the WebDriver to it.
5. Verify the new window's heading is New Window.
6. Switch back to the original window.
7. Verify we returned to the original page (by checking URL).

#### Notes
- Test Class: **MultipleWindowsTest**

## Maven Commands
**Test suites** (example: regression tests in `regression.xml`)
`mvn clean test "-DsuiteXmlFile=/src/test/resources/regression.xml"`

**Test a class**, a test scenario (example MultipleWindowsTest class)
`mvn clean test "-Dtest=com.epam.tat.module7.test.MultipleWindowsTest"`