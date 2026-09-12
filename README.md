# 📱 Practical-7 — JSON API & SQLite Database

> **Aim:** Develop an Android application that retrieves person data in **JSON format from an Internet API** and stores the retrieved data in an **SQLite database**.

---

## 🎯 Objective

This practical demonstrates how an Android application can:

- Retrieve JSON data from an Internet API
- Create and use a JSON URL for contact/person data
- Convert JSON data into Kotlin objects
- Display retrieved records using a `RecyclerView` or `ListView`
- Communicate with a web API using `HttpURLConnection`
- Store retrieved data locally using an SQLite database
- Apply the required Internet permission in the Android Manifest

---

## 📋 Person / Contact Data

The JSON data represents contact/person information containing fields such as:

| Field | Description |
|---|---|
| `id` | Unique identifier |
| `name` | Person's name |
| `phone` | Phone number |
| `email` | Email address |
| `address` | Person's address |
| `latitude` | Latitude of the location |
| `longitude` | Longitude of the location |

The practical also specifies creating a JSON URL for contact information containing details such as **ID, Name (First Name, Last Name), Phone No., and Address**.

---

## 🔗 JSON Data

The practical uses a generated JSON URL for retrieving contact data.

**JSON Generator:** https://app.json-generator.com/

> Use the JSON URL generated for your practical in the application.

---

## 🧩 Main Components

### 1. MainActivity

`MainActivity` is responsible for the main application screen and displaying the retrieved contact/person data.

### 2. Data Model Class

Create a class containing the required fields:

```text
id
name
phone
email
address
latitude
longitude
```

The practical specifies that this class should inherit from `Serializable`.

### 3. RecyclerView / ListView

A `RecyclerView` or `ListView` is used to display the retrieved contact records.

The UI displays information such as:

- Person name
- Phone number
- Email ID
- Address
- Delete/action button

### 4. HttpURLConnection

`HttpURLConnection` is used to communicate with the JSON web URL and retrieve data from the Internet.

### 5. SQLite Database

The retrieved person/contact data is stored locally in an **SQLite database**.

---

## 🔄 Application Flow

```text
        JSON API / Web URL
                │
                ▼
         HttpURLConnection
                │
                ▼
          JSON Response
                │
                ▼
        JSON Parsing / Model
                │
          ┌─────┴─────┐
          ▼           ▼
      SQLite DB   RecyclerView
          │           │
          └─────┬─────┘
                ▼
        Contact List UI
```

---

## 🛠️ Development Steps

1. Create `MainActivity` according to the required UI design.
2. Use the JSON URL generated from the JSON Generator website.
3. Create a data model class with the required contact fields.
4. Make the model class implement/inherit from `Serializable` as specified.
5. Generate or prepare the required JSON format.
6. Create a `RecyclerView` or `ListView` adapter.
7. Add Internet permission in `AndroidManifest.xml`.
8. Create an HTTP request class using `HttpURLConnection`.
9. Retrieve the JSON data from the Internet API.
10. Parse the retrieved data and display it in the application.
11. Store the retrieved records in the SQLite database.

---

## 🔐 Android Manifest Permission

Add Internet permission to the Android Manifest:

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

---

## 📚 Concepts Covered

- JSON Format
- JSON API
- `HttpURLConnection`
- `CoroutineScope`
- `RecyclerView`
- `ListView`
- RecyclerView/ListView Adapter
- `Serializable`
- SQLite Database
- Internet Permission
- JSON Parsing
- HTTP Request
- Local Data Storage

---

## 📁 Updated / Added Files

-
-
-
-
-

---

## ▶️ How to Run

1. Open the Android project in **Android Studio**.
2. Make sure the device/emulator has Internet access.
3. Verify that Internet permission is present in `AndroidManifest.xml`.
4. Run the application.
5. The application sends a request to the JSON API.
6. Retrieved contact/person data is displayed in the list.
7. Verify that the retrieved records are stored in the SQLite database.

---

## 🖥️ Expected Application

The application displays a list of contacts/persons similar to the UI shown in the practical:

```text
┌─────────────────────────────────┐
│  👤  Person Name           🗑️   │
│      Phone Number               │
│      Email Address              │
│      Address                    │
└─────────────────────────────────┘
```

---

## ✅ Result

The Android application was successfully developed to **retrieve person/contact data in JSON format from an Internet API, display the data using a list-based UI, and store the retrieved data in an SQLite database**.
