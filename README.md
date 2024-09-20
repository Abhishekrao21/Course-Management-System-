# Course-Management-System-
This project provides a Course Management System where an administrator, professors, and students interact with courses and student records. The core functionalities include managing course catalogs, updating student records, assigning professors to courses, and handling student complaints.

The project consists of several classes across multiple files:

Admin Class (Admin.java):

The admin manages the course catalog, student records, professor assignments, and complaint handling.
Features:
Course Management: Allows the admin to view, add, or delete courses from the catalog.
Student Records Management: Admin can view and update student information and grades.
Professor Assignment: Admin assigns professors to courses.
Complaint Handling: Admin can view and update the status of complaints submitted by students.
Main Class (Main.java):

The entry point for the system.
It initializes data like courses, students, professors, and complaints.
Provides access to the dashboard for admins, professors, and students.
Courses Class (Courses.java):

Represents individual courses with details like course name, code, timings, professor, prerequisites, credits, and syllabus.
Attributes:
name: Course name
code: Unique course code
professor: The professor assigned to the course
semester: The semester in which the course is offered
timings: Class timings
prerequisites: Other courses required before taking this course
credits: Credit count for the course
syllabus: Course syllabus
Professor Class (Prof.java):

Represents professor data.
Attributes:
email: Email of the professor
password: Professor's login password
Professors can be assigned to courses by the admin.
Student Class (Students.java):

Represents students enrolled in the system.
Attributes:
email: Student's email
password: Student's login password
semester: The semester the student is in
grades: Array holding student grades for courses
Instructions:
How to Run:

Run the Main.java file.
The system will prompt you to log in as an Admin, Student, or Professor.
Admin Functionalities:

After logging in as an admin, you can manage courses, student records, assign professors to courses, and handle complaints through the dashboard interface.
Course Management:

View existing courses, add new courses, or remove courses by entering the respective course codes and details.
Student Records Management:

Admin can view student details, update their email or password, change semester, and assign new grades for courses.
Professor Assignment:

Assign a professor to a course by entering the professor's email and the course code.
Complaint Handling:

Admin can view all submitted complaints and update the status to pending or resolved.
