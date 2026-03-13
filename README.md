# 🏦 Banking Application (Phase 3 Complete)

A Java banking system that supports customer/account management, strong input validation, inheritance-based account types, and a Swing GUI.

## 📋 Project Overview

This project demonstrates core object-oriented design in Java across multiple phases. The application now includes:

- Customer profile management
- Account creation and tracking
- Validation and exception handling
- Polymorphic account behavior via inheritance
- A graphical interface using Swing

## ✅ Phase Status

### Phase 1 & 2 (Complete)
- Customer information management
- Account setup and tracking
- Real-time input validation
- Try-catch validation loops
- Data sanitization
- Console output flow

### Phase 3 (Complete)
- `BankAccount` base class hierarchy
- Specialized `CheckingAccount` and `SavingsAccount` classes
- Swing-based GUI in `BankAppGUI`
- Continued use of validation and encapsulation across models

## 🎯 Validation Rules

### Customer Data
- **Customer ID**: Max 5 characters, not blank
- **SSN**: Exactly 9 numeric digits
- **Last Name**: Max 20 characters, not blank
- **First Name**: Max 15 characters, not blank
- **Street**: Max 20 characters, not blank
- **City**: Max 20 characters, not blank
- **State**: Exactly 2 characters
- **Zip Code**: Exactly 5 numeric digits
- **Phone**: Exactly 10 numeric digits

### Account Data
- **Account Number**: Max 5 characters, not blank
- **Account Type**: `CHK` or `SAV`
- **Service Fee**: $0.00 to $10.00
- **Interest Rate**: 0.0% to 10.0%
- **Overdraft Fee**: Non-negative
- **Balance**: Numeric value (defaults/starts at zero where applicable)

## 🛠️ Technologies

- Java
- Swing (GUI)
- ArrayList Collections
- Regex Validation
- Exception Handling (`IllegalArgumentException`, `try/catch`)

## 📁 Project Structure

Banking-Application-Phase-3/
├── Account.java
├── AccountInterface.java
├── BankAccount.java
├── BankAcctApp.java
├── BankAppGUI.java
├── CheckingAccount.java
├── Customer.java
├── DataEntry.java
├── SavingsAccount.java
└── README.md

## 🚀 How to Run

### Prerequisites
- JDK 8+
- VS Code, IntelliJ, Eclipse, or terminal

### Compile
```bash
javac *.java
```

### Run Console App
```bash
java BankAcctApp
```

### Run GUI App
```bash
java BankAppGUI
```

## 🧱 Design Highlights

- Encapsulation through private fields and validated setters
- Inheritance/polymorphism for account behavior
- Separation of concerns across data models, input handling, and UI
- Defensive programming to prevent invalid states


