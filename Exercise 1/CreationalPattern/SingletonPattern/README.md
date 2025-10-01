# 📘 Singleton Pattern – Quiz Attempt Tracker

## 🎯 Intent  
The **Singleton Pattern** ensures that a class has **only one instance** and provides a **global point of access** to it.  
It is particularly useful for shared resources or centralized managers where multiple instances could cause inconsistencies.  

In this example:  
- **Singleton:** `QuizAttemptTracker`  
- **Shared Resource:** Tracks quiz attempts for all students  
- **Client:** Main program interacting with multiple students  

---

## 🏫 Real-World Educational Use Case  
On an **e-learning platform**:  
- Multiple students attempt quizzes concurrently.  
- The system maintains a **single centralized tracker** to record each student’s total quiz attempts.  
- Using Singleton ensures:
  - No duplicate trackers are created
  - All attempts are **consistently recorded**
  - Global access to attempt data for reporting
- All actions are logged into `singleton.log` for auditing.  

This ensures **accurate tracking**, **resource efficiency**, and **centralized management** of student quiz activity.

---

**Explanation:**  
- `QuizAttemptTracker` → singleton class that tracks quiz attempts for all students.  
- `LoggerUtil` → logs all quiz interactions and attempt summaries.  
- `Main` → interactive runner where students attempt quizzes and view summaries.  
- The **hashcode** of `QuizAttemptTracker` demonstrates that only **one instance exists** throughout the program.  

---

## ⚙️ How to Run  

### Compile  
From the **SingletonPattern** folder:  
```bash
javac src/singleton/*.java -d out
java -cp out singleton.Main
