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
  task_priority VARCHAR(10),
  status_id VARCHAR(10),
  subject VARCHAR(40),
  description VARCHAR(100),
  due_date  TIMESTAMP
);
./gradlew bootRun
./gradlew bootRun

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
