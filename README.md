# Hilla CRUD DTO DX Test

Contains task and solution for the Hilla CRUD DTO DX test.

You have been given an application that contains an `Employee` JPA entity as well as an `Address` entity. Each employee has a one-to-one relationship to an address. There are also `EmployeeDTO` and `AddressDTO` classes that should be used for the communication with the frontend. Your task is to create a CRUD for editing employees:

1. Create a CRUD for listing and editing `EmployeeDTO`s and their related addresses.
2. Make the name field required, it should not be null or blank.
3. As it turns out each employee also needs to be assigned to a department. There already is a `Department` entity and the `Employee` entity already has a `department` property.
    - Add `departmentId` and `departmentName` to `EmployeeDTO`.
    - Add a select to the form for selecting the department.
4. Make sorting and filtering for the name and email fields work.
5. Make sorting and filtering for the department name work.

To start with the tasks:
- Clone this repository
- Run the application with mvnw (Windows), or ./mvnw (Mac & Linux)
- Open http://localhost:8080 in your browser
- Open `frontend/views/task/TaskView.tsx` in your IDE to start with the tasks
