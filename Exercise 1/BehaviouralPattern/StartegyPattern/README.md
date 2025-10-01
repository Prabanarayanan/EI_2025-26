# 📘 Strategy Pattern – E-Learning Recommendation System

## 🎯 Intent  
The **Strategy Pattern** defines a **family of algorithms** and allows selecting one at runtime.  
It encapsulates each algorithm (strategy) and makes them interchangeable without modifying the client code.  

In this example:  
- **Context:** Student (Alice)  
- **Strategies:** Adaptive, Gamified, Time-Based  
- **Event:** Selecting a learning strategy  
- **Execution:** Student receives recommendations based on the chosen strategy  

---

## 🏫 Real-World Educational Use Case  
On an **e-learning platform**:  
- Students have different learning preferences.  
- Each student can choose a **learning strategy** dynamically:
  - **Adaptive:** Personalized lessons based on performance  
  - **Gamified:** Lessons with gamification elements to make learning fun  
  - **Time-Based:** Lessons scheduled according to the student’s timetable  
- The system logs each strategy usage into a file (`strategy.log`) for tracking.  

This ensures **personalized learning**, **runtime flexibility**, and **tracking of strategy usage**.  

---

**Explanation:**  
- `LearningStrategy` → interface for all strategies.  
- `AdaptiveStrategy` / `GamifiedStrategy` / `TimeBasedStrategy` → concrete strategies.  
- `Student` → context that uses the selected strategy.  
- `LoggerUtil` → logs interactions and strategy usage.  
- `Main` → interactive runner to simulate choosing strategies.  

---

## ⚙️ How to Run  

### Compile  
From the **StrategyPattern** folder:  
```bash
javac src/strategy/*.java -d out
