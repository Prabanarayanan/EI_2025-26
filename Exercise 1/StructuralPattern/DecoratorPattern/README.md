# 📘 Decorator Pattern – Dynamic Quiz Enhancements

## 🎯 Intent  
The **Decorator Pattern** allows **adding responsibilities to objects dynamically** without modifying their original class.  
It provides a flexible alternative to subclassing for extending functionality.

In this example:  
- **Component:** BaseQuiz (normal quiz)  
- **Decorators:** Timer, Hints, Bonus Points (can be combined)  
- **Event:** Student selects quiz enhancements  
- **Execution:** Student receives a quiz with chosen enhancements applied dynamically  

---

## 🏫 Real-World Educational Use Case  
On an **e-learning platform**:  
- Students start with a **base quiz** containing standard questions.  
- They can **dynamically add enhancements** such as:
  - **Timer:** Enforces a countdown to complete the quiz  
  - **Hints:** Provides hints for difficult questions  
  - **Bonus Points:** Awards extra points for correct answers  
  - **Combinations:** Timer + Hints, or Timer + Hints + Bonus Points  
- Each enhancement is applied **without changing the original BaseQuiz class**, demonstrating flexibility.  
- All activities are logged into `decorator.log` for monitoring and analysis.

This ensures **customizable quiz experiences**, **runtime flexibility**, and **maintains a clean design**.  

---

**Explanation:**  
- `Quiz` → abstract component/interface.  
- `BaseQuiz` → concrete component (default quiz).  
- `QuizDecorator` → abstract decorator class that wraps a `Quiz`.  
- `TimerDecorator`, `HintsDecorator`, `BonusPointsDecorator` → concrete decorators.  
- `LoggerUtil` → logs all quiz activities.  
- `Main` → interactive runner to simulate applying quiz enhancements.  

---

## ⚙️ How to Run  

### Compile  
From the **DecoratorPattern** folder:  
```bash
javac src/decorator/*.java -d out
java -cp out decorator.Main
