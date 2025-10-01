# Virtual Classroom Manager

## Overview
This Java-based terminal application models a Virtual Classroom system where teachers can create classrooms, add students, create assignments, and grade student submissions using different grading strategies. It demonstrates key Object-Oriented Design principles and design patterns to build a modular, extensible, and maintainable system.

## Features
- Create and manage multiple classrooms with assigned teachers.
- Add students to classrooms with validations and observer notifications.
- Create diverse assignments with configurable deadlines and grading strategies.
- Students can submit assignment responses and receive automatic grading.
- Real-time notifications to teachers and students about assignments and submissions.
- Extensive logging of operations and error handling for improved robustness.
- Interactive command-line interface for straightforward user interaction.

## Design Patterns
- **Singleton**: Ensures a single instance of `ClassroomManager` manages all classrooms.
- **Observer**: Notifications to teachers and students for classroom events.
- **Factory**: Simplifies creation of different assignment types.
- **Strategy**: Flexible grading algorithms selectable per assignment.

## Project Structure
- `entities`: Core domain models - Classroom, Teacher, Student, Assignment, Submission.
- `manager`: Singleton managing classrooms.
- `factories`: Factory for assignment construction.
- `strategy`: Grading algorithm implementations.
- `observers`: Observer and Observable interfaces.
- `main`: CLI main application class.

## How to Run
1. Compile all source files,from the /src folder:
javac -d ../out main/Main.java manager/ClassroomManager.java entities/*.java factories/AssignmentFactory.java observers/*.java strategy/*.java
2. Run the main program:
java -cp ../out main.Main

