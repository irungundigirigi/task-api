## Task API
A task management API built on Springboot framework and Postgresql database.

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
