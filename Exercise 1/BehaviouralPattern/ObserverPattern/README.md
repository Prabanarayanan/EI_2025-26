# 📘 Observer Pattern – Student Progress Tracker

## 🎯 Intent  
The **Observer Pattern** defines a **one-to-many dependency** between objects.  
When one object (Subject) changes state, all its dependents (Observers) are automatically notified.  

In this example:  
- **Subject:** Student (Alice)  
- **Observers:** Teachers (Mr. Sharma, Ms. Gupta)  
- **Event:** Quiz completion  
- **Notifications:** Teachers receive updates and alerts  

---

## 🏫 Real-World Educational Use Case  
On an **educational platform**:  
- A student completes quizzes.  
- Multiple teachers are “subscribed” to the student’s progress.  
- Teachers automatically get notified of scores.  
- If a score is **low (<40)**, an **alert** is sent to all teachers for intervention.  
- All activities are logged into a file (`observer.log`) for audit and analysis.  

This ensures **real-time monitoring of students** and **timely teacher intervention**.  

---



**Explanation:**  
- `Observer` → interface for all observers.  
- `Teacher` → concrete observer (receives updates).  
- `Student` → subject (maintains list of observers and notifies them).  
- `Main` → demo runner to simulate quiz completion.  

---

## ⚙️ How to Run  

### Compile  
From the **ObserverPattern** folder:  
```bash
javac src/observer/*.java -d out
java -cp out observer.Main
