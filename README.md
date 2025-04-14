# 📝 JavaFX Registration Form

This is a JavaFX-based desktop application for a **User Registration Form**. It validates user input using **regular expressions (Regex)** and only allows submission when all fields are valid. Upon successful registration, a confirmation screen appears.

---

## 🔧 Features

- Built with **JavaFX**
- Input fields include:
  - First Name
  - Last Name
  - Email (Farmingdale only)
  - Date of Birth
  - ZIP Code
- **Regex-based validation** on focus lost
- **Add button** is disabled until all fields are valid
- Clean and intuitive UI
- Shows **success screen** after form submission
- Includes JavaDoc-style comments

---

## ✅ Field Validations

| Field         | Regex Pattern                                  | Notes                            |
|---------------|--------------------------------------------------|----------------------------------|
| First Name    | `^[a-zA-Z]{2,25}$`                               | Only letters, 2–25 characters    |
| Last Name     | `^[a-zA-Z]{2,25}$`                               | Only letters, 2–25 characters    |
| Email         | `^[a-zA-Z0-9._%+-]+@farmingdale\\.edu$`          | Must be a @farmingdale.edu email |
| Date of Birth | `^(0[1-9]|1[0-2])/([0-2][0-9]|3[01])/\\d{4}$`     | Format: MM/DD/YYYY               |
| Zip Code      | `^\\d{5}$`                                       | Must be a 5-digit number         |

---

## 📦 Technologies

- Java 17+
- JavaFX SDK
- Regex for validation

---

## 🚀 Getting Started

### 🔨 Prerequisites

Make sure JavaFX is set up correctly with your Java development environment.

### 💻 Run the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/javafx-registration-form.git
   cd javafx-registration-form
Developed by Haris Akbar
Contact me via ha.akbar03@gmail.com
