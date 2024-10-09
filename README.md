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
('b9e42a4b-f3d3-4e87-8c61-1b8c9c2a9e05', NOW(), NOW(), 'task', 'a6e9b97c-d3ee-4b28-b5b6-1956b348ee24', 'high', 'open', 'Finish report', 'Complete the annual financial report by end of the week.', '2024-10-12 17:00:00'),

('cbe9bafe-7e3e-4c1c-9e1f-7f94aa1c57d1', NOW(), NOW(), 'task', 'd7e6e4b8-8b45-42e1-b37f-60b5d7f9cbe2', 'normal', 'in_progress', 'Team meeting', 'Discuss project updates and next steps.', '2024-10-10 14:00:00');

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

```

### API Endpoints
| Method | Endpoints                         | Access  | Description                              |
| ------- | ---------------------------------- | ------- | ---------------------------------------- |
| GET     | /api v1/tasks                       | Public  | Returns a list of all tasks.            |
| GET     | /api/v1/task/{id}                   | Public  | Return task with specific id            |
| POST    | /api/v1/tasks                       | Public  | Creates a new task.                                   |
| GET     | /api/v1/tasks/{id}/start_task       | Public  | Changes the status of an open task to in_progress.    |
| GET     | /api/v1/tasks/{id}/stop_progress    | Public  | Changes the status of an in-progress task open.                   |
| GET     | /api/v1/tasks/{id}/close            | Public  | Changes the status of an open or in-progress task to closed                  |
| GET  | /api/v1/tasks/{id}/reopen              | Public  | Changes the status of a closed task to open.                 |
| PATCH  | /api/v1/tasks                        | Public  | Modifies an existing task.                         |
| DELETE    | /api/v1/tasks/{id}                | Public  | Deletes a specific task by id.                      |


## Build Issue

### Problem Description
Sometimes newly created or moved packages are not recognized when running the application, leading to compilation errors or unresolved imports.

### Solution
**Build the Project Properly**:
   - Use Maven or Gradle to build the project:
     - For Maven: Run `mvn clean install` in the terminal/command prompt.
     - For Gradle: Run `./gradlew clean build` in the terminal/command prompt.
Running these commands ensures that all classes are compiled correctly and dependencies are resolved.
