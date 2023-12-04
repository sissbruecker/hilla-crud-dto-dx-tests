# Hilla CRUD DTO DX Test

Contains task and solution for the Hilla CRUD DTO DX test.

You have been given an application that contains an `Employee` JPA entity as well as an `Address` entity. Each employee has a one-to-one relationship to an address. There is also an `EmployeeDTO` class that should be used for the communication with the frontend. Your task is to create a CRUD for the `EmployeeDTO` class:

1. Create a CRUD for listing and editing `EmployeeDTO`s. Make sure the ID is not editable.
2. Make `Employee.address` editable. Add corresponding properties directly to the `EmployeeDTO`, for example `EmployeeDTO.street`.
3. Make the name field required, it should not be null or blank.
4. Add a computed property that includes street, city and country, like so: `12 Baker Street, London, England`. Show the property in the grid instead of the individual fields.
5. Disable filter and sorting for the computed address property.
6. Make sorting and filtering for the name and email fields work.
7. Make sorting and filtering for the computed address field work. To keep it simple, only use the street property in the implementation.

To start with the tasks:
- Clone this repository
- Run the application with mvnw (Windows), or ./mvnw (Mac & Linux)
- Open http://localhost:8080 in your browser
- Open `frontend/views/task/TaskView.tsx` in your IDE to start with the tasks
