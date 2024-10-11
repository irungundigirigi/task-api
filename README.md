## Task API

A task management API built on Springboot framework and Postgresql database.

## Installation

```
git clone git@github.com:irungundigirigi/task-api.git
cd task-api/v1
# Create task_api database
sudo su postgres
psql
CREATE DATABASE task_api;
CREATE TABLE tasks (
  id UUID PRIMARY KEY,
  created_at TIMESTAMP,
  updated_at TIMESTAMP,
  object VARCHAR(40),
  user_id UUID,
  task_priority VARCHAR(20),
  status_id VARCHAR(20),
  subject VARCHAR(40),
  description VARCHAR(100),
  due_date  TIMESTAMP
);
# Insert sample data into the tasks table
INSERT INTO tasks (id, created_at, updated_at, object, user_id, task_priority, status_id, subject, description, due_date) VALUES
('e0b29ef6-7f1e-4c25-bf67-3f37ab13b42a', NOW(), NOW(), 'task', 'a3f9d8d3-39b3-4b65-bff0-12a0e6b7c5c3', 'high', 'open', 'Kick-off Meeting', 'Schedule a meeting with all stakeholders to discuss project goals and deliverables.', '2024-10-15T09:00:00.000Z'),
('b4e348d9-48a4-4c2b-9c5a-5a20c4f45b83', NOW(), NOW(), 'task', 'a3f9d8d3-39b3-4b65-bff0-12a0e6b7c5c3', 'normal', 'in_progress', 'Requirements Review', 'Go through the project requirements document and confirm with the team.', '2024-10-20T17:00:00.000Z'),
('c9e4536b-ded2-4f2d-b5b4-0c1e0e67f3c0', NOW(), NOW(), 'task', 'a3f9d8d3-39b3-4b65-bff0-12a0e6b7c5c3', 'low', 'open', 'Team Check-in', 'Conduct a team check-in to discuss progress and any roadblocks.', '2024-10-22T11:00:00.000Z');


./gradlew bootRun

# Open your curl/open in browser http://localhost:8080/api/v1/tasks

{
  "totalPages": 1,
  "totalElements": 2,
  "pageable": {
    "pageNumber": 0,
    "pageSize": 10,
    "sort": {
      "sorted": false,
      "empty": true,
      "unsorted": true
    },
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "size": 10,
  "content": [
    {
      "id": "b9e42a4b-f3d3-4e87-8c61-1b8c9c2a9e05",
      "created_at": "2024-10-09T08:09:24.697+00:00",
      "updated_at": "2024-10-09T08:09:24.697+00:00",
      "object": "task",
      "user_id": "a6e9b97c-d3ee-4b28-b5b6-1956b348ee24",
      "task_priority": "high",
      "status_id": "open",
      "subject": "Finish report",
      "description": "Complete the annual financial report by end of the week.",
      "due_date": "2024-10-12 17:00:00"
    },
    {
      "id": "cbe9bafe-7e3e-4c1c-9e1f-7f94aa1c57d1",
      "created_at": "2024-10-09T08:09:24.697+00:00",
      "updated_at": "2024-10-09T08:09:24.697+00:00",
      "object": "task",
      "user_id": "d7e6e4b8-8b45-42e1-b37f-60b5d7f9cbe2",
      "task_priority": "normal",
      "status_id": "in_progress",
      "subject": "Team meeting",
      "description": "Discuss project updates and next steps.",
      "due_date": "2024-10-10 14:00:00"
    }
  ],
  "number": 0,
  "sort": {
    "sorted": false,
    "empty": true,
    "unsorted": true
  },
  "first": true,
  "last": true,
  "numberOfElements": 2,
  "empty": false
}
CREARE TABLE USERS;

CREATE TABLE users (
  id UUID PRIMARY KEY,
  created_at TIMESTAMP,
  updated_at TIMESTAMP,
  object VARCHAR(40),
  username VARCHAR(50),
  password VARCHAR(20),
  email VARCHAR(60),
);
INSERT INTO users (id, created_at, updated_at, object, username, password, email) VALUES
('3c27b6ab-cc99-4f8e-baf8-1c9cb6c4776c', NOW(), NOW(), 'user', 'ama.adi', '$2b$12$e9QZf0nuj7QUn9A5/4l2hOXMg62PzK8hM63FPpF6HIWw3x9E7lZ8O', 'ama.adi@gmail.com'),
('a3f9d8d3-39b3-4b65-bff0-12a0e6b7c5c3', NOW(), NOW(), 'user', 'kojo.owusu', '$2b$12$J9h/92I4vAy4b3H5X1.3DeF2J5n4.kQExCS2lU6B7ZSYKUV4Ib8dG', 'kojo.owusu@yahoo.com'),
('f7d5c5b8-eef3-49d5-8fbb-080f3e4d7d6d', NOW(), NOW(), 'user', 'nandi.zuma', '$2b$12$E1O1Rzo1CjpQ9u1.RNOAxeB3.Gg5tV9r6PfLzFZC0LZL6IOM5pE1W', 'nandi.zuma@hotmail.com'),
('c3b16af3-5765-4bcb-b7d8-123abc456def', NOW(), NOW(), 'user', 'thabo.mokgosi', '$2b$12$6M8i5s0y1fMK6kD0C2aXeeuC0ihqgQ1eW1aGIfJrZl2v3xdp7O.CC', 'thabo.mokgosi@outlook.com'),
('d2e24c47-e4a7-4d0b-877b-0a8f1ebcc9e2', NOW(), NOW(), 'user', 'fatou.diouf', '$2b$12$E9QZf0nuj7QUn9A5/4l2hOXMg62PzK8hM63FPpF6HIWw3x9E7lZ8O', 'fatou.diouf@gmail.com');

```

### API Endpoints

| Method | Endpoints                        | Access | Description                                                 |
| ------ | -------------------------------- | ------ | ----------------------------------------------------------- |
| GET    | /api v1/tasks                    | Public | Returns a list of all tasks.                                |
| GET    | /api/v1/task/{id}                | Public | Return task with specific id                                |
| POST   | /api/v1/tasks                    | Public | Creates a new task.                                         |
| GET    | /api/v1/tasks/{id}/start_task    | Public | Changes the status of an open task to in_progress.          |
| GET    | /api/v1/tasks/{id}/stop_progress | Public | Changes the status of an in-progress task open.             |
| GET    | /api/v1/tasks/{id}/close         | Public | Changes the status of an open or in-progress task to closed |
| GET    | /api/v1/tasks/{id}/reopen        | Public | Changes the status of a closed task to open.                |
| PATCH  | /api/v1/tasks                    | Public | Modifies an existing task.                                  |
| DELETE | /api/v1/tasks/{id}               | Public | Deletes a specific task by id.                              |

## Build Issue

### Problem Description

Sometimes newly created or moved packages are not recognized when running the application, leading to compilation errors or unresolved imports.

### Solution

**Build the Project Properly**:

- Use Maven or Gradle to build the project: - For Maven: Run `mvn clean install / ./gradlew clean build` in the terminal/command prompt. - For Gradle: Run `./gradlew clean build` in the terminal/command prompt.
  Running these commands ensures that all classes are compiled correctly and dependencies are resolved.
