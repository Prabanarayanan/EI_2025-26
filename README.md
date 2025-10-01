<center>

# EI 2025-26: 

## Exercise 1: Design Patterns

**Problem Statement:**  
Implement six different use cases to demonstrate your understanding of software design patterns through coding:

1. **Two behavioural design patterns**  
2. **Two creational design patterns**  
3. **Two structural design patterns**

### Patterns Implemented:

| Pattern Type | Pattern | Use Case / Description |
|--------------|---------|----------------------|
| Behavioural | **Strategy** | Student lesson recommendation (Adaptive, Gamified, Time-Based) |
| Behavioural | **Observer** | Teachers observing students’ quiz attempts and receiving notifications |
| Creational  | **Singleton** | Global quiz attempt tracker using a single instance |
| Creational  | **Factory** | Generates quizzes of different types (MCQ, True/False, Coding) |
| Structural  | **Decorator** | Enhance quizzes with Timer, Hints, Bonus Points |
| Structural  | **Proxy** | Controls access to premium quizzes for selected students |

**Notes:**  
- Each pattern has its own folder with a detailed `README.md`, class diagrams.  
- Logging implemented for all patterns to track actions and outputs.

---

## Exercise 2: Virtual Classroom Manager

**Problem Statement:**  
Create a terminal-based Virtual Classroom Manager backend for an EdTech platform to manage:

- Class scheduling  
- Student enrollment and attendance  
- Assignment scheduling and submission  

**Initial State:**  
- Classrooms: 0  
- Students: 0  
- Assignments: 0  

**User Commands:**  
1. `add_classroom <ClassName>` – Create a new classroom  
2. `add_student <StudentID> <ClassName>` – Enroll student  
3. `schedule_assignment <ClassName> <AssignmentDetails>` – Schedule assignment  
4. `submit_assignment <StudentID> <ClassName> <AssignmentDetails>` – Submit assignment  

**Console Output Examples:**  
- `"Classroom [Name] has been created."`  
- `"Student [ID] has been enrolled in [Class Name]."`  
- `"Assignment for [Class Name] has been scheduled."`  
- `"Assignment submitted by Student [ID] in [Class Name]."`

**Functional Requirements:**  
- Classroom Management: Add, list, remove classrooms  
- Student Management: Enroll students, list students in classrooms  
- Assignment Management: Schedule and submit assignments  



</center>
