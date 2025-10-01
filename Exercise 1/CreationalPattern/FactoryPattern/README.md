# 📘 Factory Method Pattern – Quiz Variant Generator

## 🎯 Intent  
The **Factory Method Pattern** defines an **interface for creating objects** but allows subclasses to decide which object to instantiate.  
It decouples object creation from usage, making the system flexible and extensible.  

In this example:  
- **Creator / Factory:** `QuizFactory`  
- **Concrete Factories:** `MCQQuizFactory`, `TFQuizFactory`, `CodingQuizFactory`  
- **Products:** Different quiz types (Multiple Choice, True/False, Coding Challenge)  
- **Client:** Main program requesting quiz variants dynamically  

---

## 🏫 Real-World Educational Use Case  
On an **e-learning platform**:  
- Students like **Alice** and **Bob** attempt quizzes.  
- The platform offers multiple quiz types:  
  - **Multiple Choice (MCQ)**  
  - **True/False (TF)**  
  - **Coding Challenge**  
- Each quiz attempt generates a **unique variant**:
  - Random question selection  
  - Randomized option order  
- The system tracks **number of attempts per student**.  
- All actions are logged into `factory.log` for auditing and analysis.  

This ensures **dynamic quiz generation**, **decoupled object creation**, and **tracking of student attempts**.

---

**Explanation:**  
- `QuizFactory` → interface for all quiz factories.  
- `MCQQuizFactory` / `TFQuizFactory` / `CodingQuizFactory` → concrete factories creating quiz variants.  
- `Quiz` → abstract product interface defining quiz behavior.  
- `MCQQuiz` / `TFQuiz` / `CodingQuiz` → concrete products implementing different quiz types.  
- `LoggerUtil` → logs all quiz attempts, variant generation, and summary information.  
- `Main` → client that interacts with students and requests quizzes dynamically.  

---

## ⚙️ How to Run  

### Compile  
From the **FactoryPattern** folder:  
```bash
javac src/factory/*.java -d out
java -cp out factory.Main

