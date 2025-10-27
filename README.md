INTRODUCTION

   1.1 PROJECT OVERVIEW AND PROBLEM STATEMENT
   
   The Kanban Board - Task Management System is a comprehensive web-based application developed using Spring Boot framework to digitize and streamline task management processes within organizations.
   This system serves as a centralized platform that enables efficient management of tasks, visual workflow organization, and real-time monitoring of project progress for teams and individuals.
Built with modern Java technologies including Spring Data JPA for data persistence, and Thymeleaf for dynamic web interfaces, the system provides an intuitive interface for managing tasks across different workflow stages.
The Kanban methodology implementation allows users to visualize their work, limit work-in-progress, and maximize efficiency by moving tasks through defined columns representing different stages of completion.

1.2 OBJECTIVES AND SCOPE
  The primary objective of this project is to develop a secure, web-based task management system that implements the Kanban methodology for visual workflow management.
  The system aims to provide comprehensive task tracking, priority-based organization, and efficient task movement across workflow stages.
Key goals include ensuring data integrity through secure authentication mechanisms, replacing manual task tracking with digital solutions, and enabling productivity monitoring through real-time statistics and visual task organization.
The system is a Spring Boot web application with MySQL database, supporting task and column management through browser interfaces.
It includes basic CRUD operations, priority-based categorization, and statistics dashboard, designed for single-organization deployment with responsive web design.

  SYSTEM REQUIREMENTS & SPECIFICATION
FUNCTIONAL REQUIREMENTS

User Authentication: Secure registration and login with email validation, password encryption, and session management.
Task Management: Users can create, view, update, and delete tasks with title, description, priority, and status tracking.
Column Management: Support for creating and managing workflow columns representing different stages (To Do, In Progress, Done).
Task Movement: Ability to move tasks between columns to reflect status changes and workflow progress.
Priority System: Tasks can be assigned priority levels (High, Medium, Low) with visual color coding.
Dashboard & Statistics: Real-time statistics showing total tasks, in-progress count, and completed tasks with visual indicators.
Search Functionality: Search and filter tasks by title or other criteria.
