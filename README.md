## Build Issue

### Problem Description
Sometimes newly created or moved packages are not recognized when running the application, leading to compilation errors or unresolved imports.

### Solution
**Build the Project Properly**:
   - Use Maven or Gradle to build the project:
     - For Maven: Run `mvn clean install` in the terminal/command prompt.
     - For Gradle: Run `./gradlew clean build` in the terminal/command prompt.
Running these commands ensures that all classes are compiled correctly and dependencies are resolved.
