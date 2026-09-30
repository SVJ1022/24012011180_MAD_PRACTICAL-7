# 📱 Practical-7 — JSON API & SQLite Database

## 🎯 Aim

Develop an Android application that retrieves person data in JSON format from an Internet API and stores the retrieved data in an SQLite database.

## 📌 Objective

This practical demonstrates retrieving person/contact information from an online JSON API, parsing the received JSON data, displaying the records using a RecyclerView or ListView, and storing the retrieved information in an SQLite database.

## 📚 Practical Overview

The application retrieves person information containing:

- ID
- Name
- Phone Number
- Email ID
- Address
- Latitude
- Longitude

The retrieved JSON data is converted into `Person` objects and displayed in the application. The data is also stored locally using SQLite.

## 🔄 Application Flow

```text
Internet API
     ↓
JSON Response
     ↓
HttpURLConnection
     ↓
JSON Parsing
     ↓
Person Objects
     ↓
SQLite Database
     ↓
RecyclerView / ListView
     ↓
Display Person Data
```

## 🧩 Main Components

### Person Class

A `Person` class is created with the following variables:

- Id
- Name
- Phone No
- Email Id
- Address
- Latitude
- Longitude

The class implements `Serializable` so that person objects can be passed between Android activities.

### HTTP Request

`HttpURLConnection` is used for communicating with the Web URL and retrieving JSON data from the Internet API.

### JSON Parsing

The JSON response received from the API is parsed and converted into `Person` objects.

### RecyclerView / ListView

The retrieved records are displayed using a RecyclerView or ListView Adapter.

Each record displays information such as:

- Person Name
- Phone Number
- Email ID
- Address

### SQLite Database

The retrieved person data is stored locally using an SQLite database.

### CoroutineScope

`CoroutineScope` is used for handling API-related operations without blocking the main UI thread.

## 📱 Application Features

- Retrieve person data from an Internet API
- Display person/contact records
- Store retrieved records in SQLite
- Refresh the displayed data
- Delete person records
- Display contact information in card-based UI

## 🔄 Refresh Operation

```text
Click Refresh
     ↓
Send HTTP Request
     ↓
Receive JSON Response
     ↓
Parse JSON Data
     ↓
Create Person Objects
     ↓
Store / Update SQLite Data
     ↓
Update RecyclerView
```

## 🗑️ Delete Operation

The application provides a delete option for person records. The selected record can be removed from the locally stored data.

## 🌐 JSON Data

The application retrieves person/contact information in JSON format from an Internet API.

Example structure:

```json
{
    "id": 1,
    "name": "Yesenia Yang",
    "phone": "1234567890",
    "email": "yesenia@example.com",
    "address": "Example Address",
    "latitude": "23.0225",
    "longitude": "72.5714"
}
```

## 🔐 Internet Permission

Internet permission is required for communicating with the online API.

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

## 📚 Concepts Covered

- JSON Format
- JSON Parsing
- Internet API
- HTTP Communication
- HttpURLConnection
- RecyclerView
- ListView
- Adapter
- SQLite Database
- CRUD Operations
- Serializable
- CoroutineScope
- Internet Permission
- Android Manifest
- API Communication
- Local Data Storage

## 📂 Project Structure

```text
24012011180_MAD_PRACTICAL-7
│
├── .idea/
├── app/
│   └── src/
│       └── main/
│
├── gradle/
├── .gitignore
├── build.gradle.kts
├── gradle.properties
├── gradlew
├── gradlew.bat
└── settings.gradle.kts
```

## 📝 Updated / Added Files

1. MainActivity.kt
2. activity_main.xml
3. EditActivity.kt
4. activity_edit.xml
5. PersonAdapter.kt
6. DatabaseHelper.kt
7. HttpRequest.kt
8. single_item.xml
9. Person.kt

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Kotlin | Android application development |
| Android Studio | Development environment |
| Android SDK | Android application development |
| JSON | Data exchange format |
| HttpURLConnection | API communication |
| RecyclerView / ListView | Displaying person records |
| SQLite | Local database storage |
| CoroutineScope | Handling background operations |
| Git & GitHub | Version control |

## ▶️ How to Run

1. Clone the repository.
2. Open the project in Android Studio.
3. Allow Gradle synchronization to complete.
4. Connect an Android device or start an Android Emulator.
5. Make sure the device has an active Internet connection.
6. Run the application.
7. The application retrieves person data from the configured JSON API and displays the records.

## 📸 Output

The application displays retrieved person/contact records in a card-based list.

Each record contains:

- Name
- Phone Number
- Email ID
- Address

The application also provides options to refresh the data and delete individual records.

## 🔁 Overall Working

```text
                    START
                      │
                      ▼
              Open Application
                      │
                      ▼
              Request JSON Data
                      │
                      ▼
                Internet API
                      │
                      ▼
               Receive JSON
                      │
                      ▼
              Parse JSON Data
                      │
                      ▼
             Create Person Objects
                      │
                ┌─────┴─────┐
                ▼           ▼
          SQLite Database  RecyclerView
                │           │
                ▼           ▼
          Local Storage  Display Data
```

## 🌐 JSON Generator Reference

The practical uses the following website for generating JSON data:

**JSON Generator:**  
https://app.json-generator.com/

## 📸 Screenshots

| # | Screenshot | Description |
|---|---|---|
| 1 | <img width="450" height="900" alt="image" src="https://github.com/user-attachments/assets/cb7c8f30-c4b2-4663-b820-2e067bb9dfd6" /> | Main application screen displaying the person/contact records after retrieving from JSON. |
| 2 | <img width="450" height="900" alt="image" src="https://github.com/user-attachments/assets/77a7aec9-f468-409c-b589-cad4c8cca501" /> | Edit person details including name, phone number, email ID and address. |
| 3 | <img width="800" height="900" alt="Screenshot 2026-09-30 232840" src="https://github.com/user-attachments/assets/0130064c-a435-4a61-98e4-3e82d065a1d2" /> | Refresh operation showing updated/retrieved data from the JSON API. |


## ✅ Result

The Android application successfully demonstrates retrieving person data in JSON format from an Internet API, displaying the retrieved records using a RecyclerView/ListView, and storing the retrieved data in an SQLite database.

---

**Subject:** Mobile Application Development (MAD)  
**Practical:** 7  
**Topic:** JSON API & SQLite Database  
**Language:** Kotlin  
**Platform:** Android
