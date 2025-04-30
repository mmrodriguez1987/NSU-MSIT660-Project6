# Project 6: Train System Simulation

## Overview

This project is a Java-based **Train System Simulation**, developed using **Test-Driven Development (TDD)** practices. The simulation models customer behavior and train operations based on a predefined Software Design Specification (SDS) and a suite of JUnit tests.

You are required to **match the design specification exactly** without modifications, ensuring all unit tests pass successfully.

---

## Objectives

- Implement all classes, attributes, methods, constructors, and constants exactly as defined in the design spec (`Project6-Train-SDS.doc`).
- Ensure all **JUnit tests** provided in the test suite (`tests.zip`) pass.
- Validate correct simulation logic by executing the system with a sample input file.

---

## Provided Resources

- ✅ `Project6-Train-SDS.doc` – the system design specification (not included here).
- ✅ `tests.zip` – JUnit tests divided into **basic** and **advanced** per class.
- ✅ `simulate.txt` – implementation code for the `Train.simulate()` method.
- ✅ `Project6-Instructions.docx` – project instructions and deliverables.

---

## Implementation Strategy

### 1. Project Setup
- Create a new Java project in **Eclipse** or your preferred IDE.
- Import `tests.zip` and place all tests in the `src` directory.
- Add the **JUnit 4.x or 5.x** library to your project.

### 2. Development Workflow
- Start by creating stub classes with the correct **attributes**, **constants**, and **method signatures** to pass **basic tests**.
- Gradually implement method logic while running the **unit tests** frequently.
- For `Train.simulate()`, copy and paste the code from `simulate.txt`.

### 3. Testing
- Run individual tests using:
  ```
  Right Click > Run As > JUnit Test
  ```
- Some advanced tests (e.g., `TestSimulatorAdvanced`) may require or skip a specific file:
  - Path: `C:/train/customer-data.txt`
  - Check test comments for file requirements.

---

## Important Notes

- ❗ **Do NOT redesign** or change the system structure.
- ❗ **Do NOT close `Scanner`** objects used for reading input, or subsequent reads may fail.
- ✅ Implement all methods and constants **exactly as defined** in the SDS and test cases.

---

## Sample Deliverables

- `Customer.java`, `Train.java`, and all other `.java` files (1 per class).
- `data.txt` – sample input file.
- Output screenshot – saved in `your-name-Output.docx`.

---

## Authors

- Brandon Cruz  
- Mark-Anthony Wright  
- Marcos Rodriguez  
- Jonathan Vargas  

Test Suite by: **Renata Rand McFadden**

---

## License

This project is for academic use under MSIT 660: Platform and Network Technologies at NSU.