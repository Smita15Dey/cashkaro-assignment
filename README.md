# CaseKaro Automation Assignment (Playwright + Java)

## 📌 Overview
This project is an **end-to-end UI automation assignment** implemented using **Playwright (Java)** for browser automation and TestNG for test execution and lifecycle management.  
The automation validates the complete shopping flow on **CaseKaro** website for an iPhone model, adds multiple material variants to the cart, and prints detailed cart information to the console.


The focus of this assignment is:
- Real user flow validation
- Reliable locator strategy
- Handling dynamic UI behavior
- Clear test output and debugging visibility

---

## 🧪 Automated Test Scenario (End-to-End Flow)

1. Open **https://casekaro.com**
2. Navigate to **Mobile Covers**
3. Search for **iPhone**
4. Select **iPhone 16 Pro** from search results
5. Open a product
6. Add **3 different materials** of the same product to cart:
   - Soft
   - Hard
   - Glass
7. Open Cart
8. Validate:
   - Total items count
   - Each item's:
     - Material
     - Price
     - Product link
9. Print all cart item details to the console

---

## 🛠️ Tech Stack

- **Language:** Java 8 
- **Automation Tool:** Playwright (Java) -> Browser automation
- **Test Framework:** TestNG -> Test orchestration, annotations, and lifecycle management
- **Build Tool:** Maven -> Build and dependency management
- **Design Pattern:** Page Object Model (POM)

---

## 📂 Project Structure

```
casekaro-automation
│
├── src
│   └── test
│       └── java
│           ├── base
│           │   └── BaseTest.java
│           ├── pages
│           │   ├── HomePage.java
│           │   ├── ProductPage.java
│           │   └── CartPage.java
│           └── tests
│               └── CaseKaroTest.java
├── execution-log.txt   -> Test output captured here
│
├── pom.xml
└── README.md
```

---

## 📄 Page-Wise Responsibilities

### **HomePage.java**
Responsible for:
- Opening the CaseKaro website
- Navigating to Mobile Covers
- Searching for iPhone
- Handling dynamic search results
- Selecting iPhone 16 Pro

This class encapsulates all homepage and search-related actions.

### **ProductPage.java**
Responsible for:
- Selecting product variants (Soft, Hard, Glass)
- Adding products to the cart
- Handling variant selection logic

This class represents product detail interactions.

### **CartPage.java**
Responsible for:
- Opening the cart drawer
- Counting total items in the cart
- Extracting and printing:
  - Material
  - Price
  - Product link

This class handles cart validation and data extraction.

### **CaseKaroTest.java**
Responsible for:
- Orchestrating the end-to-end test flow
- Calling page methods in correct sequence
- Validating final outcomes
- Printing structured console output

This is the test entry point.

### **BaseTest.java**
Responsible for:
- Setting up Playwright browser instance
- Initializing pages
- Managing test lifecycle
- Cleanup and teardown

---

## 📝 Important Note (Test Plan Adjustment)

The original test plan assumed that searching for "Apple" would directly return Apple device models.

During execution, I manually validated the UI behavior and observed that the website does not support "Apple" as a searchable keyword. 

- The actual supported user flow is:
  - Search for "iPhone"
  - The UI then displays all iPhone categories (iPhone 11, 12, 13, 14, 15, 16 Pro, etc.)
  - These results are rendered inside a dynamic container (#searchResults)
  - Multiple similar links appear simultaneously (base models, Pro, Pro Max, accessories)

Because of this real behavior, the automation strategy was intentionally adjusted to:

- Search using "iPhone" instead of "Apple"
- Wait for the search results container to become visible
- Use scoped locators inside search results
- Click only the visible and exact match for iPhone 16 Pro
- Avoid Playwright strict-mode violations caused by duplicate text matches

This adjustment ensures the automation reflects actual user behavior on the website, rather than assumptions made during initial test planning.

---

## 🔧 Automation Strategy Summary

- Real UI behavior was validated manually before coding
- Locators were chosen based on:
  - Visibility
  - Scope
  - Stability
- Dynamic content and strict-mode conflicts were handled explicitly
- Unicode currency handling (₹) was validated in console output

---

## ▶️ How to Run the Tests

### Prerequisites
- Java 8 or above
- Maven installed
- Internet connection

### Steps

1. Clone the repository
   ```bash
   git clone <repo-url>
   cd casekaro-automation
   ```

2. Install dependencies
   ```bash
   mvn clean install
   ```

3. Run the tests
   ```bash
   mvn clean test
   ```

4. View the test results
   ```bash
   # Reports will be generated in target/surefire-reports/
   ```

---

## 💾 Run Tests and Save Console Output to File

To allow reviewers to easily verify test execution and cart details, the complete console output can be saved to a text file using the following command:

### macOS / Linux / Git Bash (Windows)
```bash
mvn clean test | tee execution-log.txt
```

### Windows PowerShell
```powershell
mvn clean test | Tee-Object execution-log.txt
```

### 📄 Output File Details

This will:
- Display logs in the terminal in real-time
- Save the same logs to `execution-log.txt`

The generated file will include:
- Cart item count
- Material, price, and product link for each item
- Test execution status (PASS / FAIL)
- Complete Maven build logs
- Playwright browser initialization details

**Note:** The `execution-log.txt` file will be created in the project root directory after test execution completes.

---

## 📊 Sample Console Output

```
Items in cart: 3

----- CART ITEM DETAILS -----
Item 1
Material : Glass
Price    : ₹ 249.00
Link     : /products/classic-porsche-911-iphone-16-pro-back-cover?variant=41955668263030
-----------------------------
Item 2
Material : Soft
Price    : ₹ 149.00
Link     : /products/classic-porsche-911-iphone-16-pro-back-cover?variant=41955668230262
-----------------------------
Item 3
Material : Hard
Price    : ₹ 69.00
Link     : /products/classic-porsche-911-iphone-16-pro-back-cover?variant=41955668197494
-----------------------------
```

---

## 🎯 Test Features

✅ **End-to-End Flow:** Complete shopping journey from homepage to cart  
✅ **Dynamic Content Handling:** Manages dynamic search results and variant selection  
✅ **Multiple Variants:** Adds and validates different material variants  
✅ **Cart Validation:** Verifies cart count, pricing, and product links  
✅ **Detailed Logging:** Prints structured cart information to console  
✅ **POM Design Pattern:** Clean separation of concerns and maintainable code  
✅ **Error Handling:** Robust handling of dynamic UI elements  

---

## 📝 Troubleshooting

### Test Fails on Search Results
- Ensure the website is accessible: https://casekaro.com
- Check that the search results container (#searchResults) is loading properly
- Verify network connectivity

### Cart Items Not Found
- The product URL may have changed; verify the product link manually
- Check if the variant is still available in inventory

---

## 👤 Author
**Smita Dey**

---

## 🔗 Resources

- [Playwright Java Documentation](https://playwright.dev/java/)
- [TestNG Documentation](https://testng.org/)
- [Maven Documentation](https://maven.apache.org/)
