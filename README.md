# 🏦 Banking Application

A Java-based console application for managing customer accounts with comprehensive data validation and error handling.

## 📋 Project Overview

This Banking Application demonstrates object-oriented programming principles, input validation, and exception handling in Java. The system allows users to create and manage customer profiles with associated bank accounts, ensuring data integrity through multi-layered validation.

## ✨ Features

### Phase 1 & 2 (Complete)
- ✅ Customer information management
- ✅ Account creation and tracking
- ✅ Real-time input validation with error messages
- ✅ Try-catch exception handling with retry loops
- ✅ Data sanitization (trim whitespace)
- ✅ Multi-account support (CHK/SAV)
- ✅ Formatted console output

### Phase 3 (Upcoming)
- 🔄 Inheritance hierarchy with BankAccount base class
- 🔄 CheckingAccount and SavingsAccount specialized classes
- 🔄 GUI implementation with Swing

## 🎯 Validation Rules

### Customer Requirements
- **Customer ID**: Max 5 characters, cannot be blank
- **SSN**: Exactly 9 numeric digits, cannot be blank
- **Last Name**: Max 20 characters, cannot be blank
- **First Name**: Max 15 characters, cannot be blank
- **Street**: Max 20 characters, cannot be blank
- **City**: Max 20 characters, cannot be blank
- **State**: Exactly 2 characters, cannot be blank
- **Zip Code**: Exactly 5 numeric digits, cannot be blank
- **Phone**: Exactly 10 numeric digits, no punctuation

### Account Requirements
- **Account Number**: Max 5 characters, cannot be blank
- **Account Type**: Must be "CHK" or "SAV" (case-insensitive)
- **Service Fee**: Range 0.00 to 10.00 dollars (inclusive)
- **Interest Rate**: Range 0.0 to 10.0 percent (stored as decimal, e.g., 7.5)
- **Overdraft Fee**: Must be non-negative
- **Balance**: Any value (initially zero)

## 🛠️ Technologies Used

- **Language**: Java
- **Collections**: ArrayList
- **Input/Output**: Scanner, Console I/O
- **Validation**: Regular Expressions (Regex)
- **Error Handling**: Try-Catch blocks, IllegalArgumentException
- **Design Patterns**: Encapsulation, Helper Methods, Lambda Expressions
- **Version Control**: Git, GitHub

## 📁 Project Structure
Banking Application/
├── Account.java # Account data model with validation
├── BankAccount.java # Abstract base class for accounts (Phase 3)
├── BankAcctApp.java # Main application entry point
├── BankAppGUI.java # GUI implementation (Phase 3)
├── CheckingAccount.java # Checking account subclass (Phase 3)
├── Customer.java # Customer data model with validation
├── DataEntry.java # Utility class for input handling
├── SavingsAccount.java # Savings account subclass (Phase 3)
└── README.md # Project documentation


## 🚀 How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line terminal or IDE (VS Code, IntelliJ, Eclipse)

### Compilation
```bash
javac *.java

### Execution
java BankAcctApp

🔒 Security Features
Input sanitization (trim whitespace)
Strict type validation
Range boundary checking
Null-safe operations
Exception-safe execution (no crashes)

🏗️ Architecture Highlights
Design Principles
Encapsulation: Private fields with public getters/setters
Separation of Concerns: Distinct classes for data, logic, and I/O
DRY Principle: Reusable utility methods in DataEntry
Defensive Programming: Validation at multiple layers
Lambda Expressions: Modern Java functional programming


