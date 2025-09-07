# 📺 TV Platform

**Author:** Mihai-Emilian Băban, 324 CD

A video streaming platform built in Java, developed as a university project. The application simulates a Netflix-like service, with authentication, page navigation, movie management, and features for both standard and premium users.

---

## 🚀 Implemented Features

### Stage 1 – Core Functionality

- **Login / Register system** with validations
- **Page navigation:** Homepage, Movies, See details, Upgrades, etc.
- **Page actions:** search, filter, purchase, watch, like, and rate movies
- **Error handling** for forbidden actions or invalid navigation
- **JSON output** according to the specification

### Stage 2 – Advanced Features

- **Genre subscription:** users can receive notifications when new movies from chosen categories appear
- **Persistent notifications:** each user has a notification queue that persists between sessions
- **Database management:**
  - `add movie` → add a movie and notify subscribers of the relevant genres
  - `delete movie` → remove a movie and refund users who purchased it
- **Back button:** navigate back using a stack of pages
- **Recommendations for premium users:** algorithm based on the most liked genres

---

## 🛠️ Technologies & Design

- **Java 17**
- **Object-oriented programming:** inheritance, polymorphism, encapsulation
- **Design patterns:**
  - Singleton (database management, page stack)
  - Observer (user notifications)
  - Command (page actions)
  - Factory (creating page/action objects)
- **Input/output handling in JSON format**
- **Extensible and maintainable architecture**

---

## 📂 Project Structure

```
src/
 ├── actions/         # command implementation (change page, on page, database, etc.)
 ├── database/        # movie and user management
 ├── entities/        # classes for User, Movie, Notification
 ├── pages/           # logic for each platform page
 ├── utils/           # helpers for parsing and validation
```

### Main Classes Overview

- **User:** user data and credentials
- **Movie:** movie data
- **Page:** page name, current user, visible movie list, current movie
- **Output:** output structure; `addInJsonArrayNode` method for JSON writing
- **PagesStack:** page stack for "back" functionality
- **Notification:** movie name and message for notifications
- **Recommendation:** output for recommendations, with `setRecommendedMovie(Page page)` method
- **Actions:** classes for each action type, extending Action

---

## 📸 Example Run

**Input:**
```json
{ "action": "change page", "page": "Movies" }
```

**Output:**
```json
{
  "error": null,
  "currentMoviesList": [{ "name": "Inception", "rating": 9.1 }],
  "currentUser": { "name": "John", "notifications": [] }
}
```

---

## 📖 What I Learned

- How to build a scalable and maintainable OOP project
- Choosing and integrating appropriate design patterns
- Managing user ↔ application interaction through a page flow
- Implementing a personalized recommendation algorithm

---

## ▶️ How to Run

Clone the repository:

```bash
git clone https://github.com/EmiBaban/TV-Platform.git
cd TV-Platform
```

Compile and run:

```bash
javac Main.java
java Main input.json output.json
```

- `input.json` → file containing actions
- `output.json` → execution results

---

## 📚 Additional Details

- For details on each action, see the `Main` class and the packages in `src/`
- Singleton is used for `DataBase` and `PagesStack` to ensure a single instance
- For writing to JSON, use the `addInJsonArrayNode` method from the Output class
- Premium user recommendations are generated based on preferred genres
