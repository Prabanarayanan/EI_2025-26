# 📘 Proxy Pattern – Controlled Quiz Access

## 🎯 Intent  
The **Proxy Pattern** provides a **surrogate or placeholder** for another object to control access to it.  
It allows **additional functionality** such as access control, logging, or lazy loading without modifying the original object.  

In this example:  
- **Real Subject:** PremiumQuiz (actual quiz with advanced questions)  
- **Proxy:** QuizProxy (controls access to the premium quiz)  
- **Client:** Student (Alice or Bob)  
- **Event:** Attempting to access a premium quiz  
- **Execution:** Proxy checks permissions before forwarding the request to the real quiz  

---

## 🏫 Real-World Educational Use Case  
On an **e-learning platform**:  
- Certain quizzes are **premium** and require special permissions or subscriptions.  
- The system uses a **proxy** to manage access:
  - **Authorized students** (e.g., Bob) can attempt the premium quiz  
  - **Unauthorized students** (e.g., Alice) are denied access  
- All attempts are logged in a file (`proxy.log`) for auditing and monitoring  

This ensures **secure access control**, **centralized permission handling**, and **prevents unauthorized actions** without changing the premium quiz code.  

---

**Explanation:**  
- `Quiz` → interface for all quizzes  
- `PremiumQuiz` → real subject, contains actual quiz logic  
- `QuizProxy` → proxy, checks permissions before forwarding requests  
- `LoggerUtil` → logs all access attempts  
- `Main` → interactive runner to simulate student quiz attempts  

---

## ⚙️ How to Run  

### Compile  
From the **ProxyPattern** folder:  
```bash
javac src/proxy/*.java -d out
java -cp out proxy.Main
