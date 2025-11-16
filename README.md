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
- Use **WebDriver API** as much as possible  (browser navigation, clicks, switchTo and etc.)
- Use several **locator strategies**, i.e. different types of locators (and select the most suitable in your case)
- Experiment with **waits** (implicit and explicit)
- Extend your scenario with usage of **Page Object** / **Page Factory** patterns.

## Test Scenarios
### Scenario 1: Successful Login (Form Authentication)
#### Test Steps
1. Open Browser (Chrome) 
2. Navigate to the homepage.
3. Click the link **“Form Authentication”**}
4. Wait for the Login page to load.
5. Enter username: `tomsmith`.
6. Enter password: `SuperSecretPassword!`
7. Click the **Login** button.
8.  Wait for the Secure Area page to load.
9.  Verify that the success message “You logged into a secure area!” appears.
10.  Click the **Logout** button.
11.  Verify the user is returned to the Login page.

#### Expected Result
-   User successfully logs in and sees a confirmation message.
-   After logout, the login page is displayed again.
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
 
#### Expected Result
-   Elements are added and removed correctly from the page.
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

#### Expected Result
-   Both checkboxes toggle state correctly.
---

