📚 Quantum Bookstore
A fully extensible object-oriented Java application that simulates an online bookstore.
Built for the Fawry N² Dev Slope #10 Challenge, this project handles different types of books and operations such as adding, buying, and removing outdated inventory — all designed with clean code principles.

🧩 Core Concepts
Abstract Design: A base Book class with shared attributes and behavior

Interfaces for Extensibility: Buyable to define purchasing behavior

Specialized Subclasses:

📕 PaperBook — stock-based and delivered via shipping

📘 EBook — sent via email with a defined file type

📙 ShowcaseBook — for display/demo only, not for sale

| Feature                        | Description                                                                |
| ------------------------------ | -------------------------------------------------------------------------- |
| ✅ Add Book                    | Add books with ISBN, title, price, and publish date                        |
| 🛒 Buy Book                    | Buy by ISBN, email, and address (with stock check and delivery simulation) |
| 🔄 Remove Outdated Books       | Automatically remove books older than N years                              |
| 📨 Email & Shipping Simulation | Static `MailService` and `ShippingService` print delivery confirmations    |
| 🧪 Built-in Test Suite         | Includes a complete test class simulating all core use cases               |

📌 Notes
Designed to allow easy extension (e.g., adding AudioBooks) without modifying core logic.

🙋 Author
Seif Omar
Backend Developer | October 6 University

![Screenshot From 2025-07-09 00-21-10](https://github.com/user-attachments/assets/e9577b58-88a1-457f-9bb9-f6b1df6403af)
![Screenshot From 2025-07-09 00-18-40](https://github.com/user-attachments/assets/fe0f4ea9-0a68-4bc0-8d79-c1c37c602a27)
