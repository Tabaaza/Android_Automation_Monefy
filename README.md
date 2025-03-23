# 📱 Monefy Android App - Automated Testing Framework

---

## 🚀 Overview

This framework provides a **scalable**, **maintainable**, mobile automation solution.  
It is built using **Appium**, **Java**, and **TestNG**, following standard best practices:
- **Page Object Model (POM)** design pattern.
- **Reusable Base classes** for common actions.
- Clear **naming conventions** and **consistent structure**.

---

## ✅ Covered Test Scenarios (E2E User Flows)

### 1. **Add Expense Flow**
- Add an expense using the **main expense button**.
- Add an expense by selecting a **category icon**.
- Validate that the **balance** is updated after adding an expense.

### 2. **Add Income Flow**
- Add income using the **main income button** and select a category.
- Add income by selecting a **category icon**.
- Validate that the **balance** is updated after adding income.

### 3. **Settings Flow**
- Navigate to **Settings** via the overflow menu.
- Change the **currency** from USD to EUR.
- Verify that the **currency update** reflects both in **Settings** and on the **Home Page balance**.

---

## 🛠️ Framework Architecture and Design

### ✅ Why It’s Scalable and Maintainable
- **Page Object Model (POM):**  
  Each app screen is represented by a Page Object class contains element locators and interaction methods.

- **BasePage Abstraction:**  
  Common methods (clicks, waits, number entry) are abstracted to the `BasePage` class for reuse.

- **Reusable Test Structure:**  
  Test classes (`AddExpenseTest`, `AddIncomeTest`, `SettingTest`) focus only on test logic, not UI actions.

- **Easy Configurations:**  
  Appium driver capabilities are configured in `BaseTest.java` and easily adjustable for different devices or emulators.

---

## ⚙️ Setup Guide

### ✅ Prerequisites
- Java JDK 11+
- Maven 3.6+
- Android SDK & Emulator or a real Android device
- Appium Server v2+  
  Install globally using:
  ```bash
  npm install -g appium
- Clone the project: 
  ```bash
  git clone https://github.com/yourusername/monefy-automation.git
  cd monefy-automation
- Run: 
  ```bash
  mvn clean install

## ▶️ How to Run the Tests

- Start Appium Server
- Run Appium in a separate terminal window:
  ```bash
  appium
- Start Android Emulator (or connect a real device)
  - Ensure your emulator/device is listed with:
  ```bash
  adb devices
- Run Tests via Maven
   - Execute all tests:
  ```bash
  mvn clean test
  
## 📂 Project structure: 
```bash
    monefy-automation
    ├── apk
    │   └── monefy.apk               # Monefy app APK (place it here)
    ├── src
    │   ├── main
    │   │   └── java
    │   │       └── pages
    │   │           ├── BasePage.java
    │   │           ├── ExpensePage.java
    │   │           ├── HomePage.java
    │   │           ├── IncomePage.java
    │   │           ├── OnboardingPage.java
    │   │           └── SettingsPage.java
    │   └── test
    │       └── java
    │           └── tests
    │               ├── AddExpenseTest.java
    │               ├── AddIncomeTest.java
    │               └── SettingTest.java
    └── test-output                  # TestNG report output

