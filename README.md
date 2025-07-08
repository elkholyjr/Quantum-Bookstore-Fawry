# Quantum Bookstore 📚✨

![1](https://github.com/user-attachments/assets/b9671b12-bf78-4902-b45c-020afa37e2bc)

Welcome to the **Quantum Bookstore** – a simple, extensible online bookstore system implemented in Java.

## Features

### 📘 Book Types
The system supports multiple types of books:
- **PaperBook**: Has stock and can be shipped to a physical address.
- **EBook**: Has a filetype and can be delivered via email.
- **ShowcaseBook**: Demo-only books that are **not for sale**.

### ✅ Functionality
- **Add Book**: Add books to the inventory with ISBN, title, author, publish year, and price.
- **Remove Outdated Books**: Remove and return books older than a certain number of years.
- **Buy Book**:
  - Specify ISBN, quantity, customer email, and address.
  - Validates stock availability.
  - Reduces quantity from inventory.
  - Returns the total amount paid.
  - Sends:
    - PaperBooks to the `ShippingService` (no implementation required)
    - EBooks to the `MailService` (no implementation required)

### 🧪 Test Class
Use `QuantumBookstoreFullTest` to:
- Add various books
- Remove outdated ones
- Simulate purchase scenarios

### 🔁 Extensibility
The design uses polymorphism and abstraction, allowing you to add new book types **without modifying** the existing system.

## 🛠 Technologies
- Java (OOP principles)
- Simple CLI output (prefixed with `Quantum book store:`)

## 🧾 Example Usage
```
Quantum book store: Added book with ISBN 1234
Quantum book store: Book with ISBN 1234 purchased. Amount: $19.99
Quantum book store: Sent paper book to ShippingService
```
