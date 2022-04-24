@abc
Feature:

 @listing_employees
  Scenario: Return a list of Employees
    Given User sends a GET request "endpoint(fake)"
    Then User takes a response
    And User asserts Status Code that is 200
    And User validates all of employee's list


@creating_employees
  Scenario: Create a new Employee
    Given User creates a mock data for creating a new employee
    Then User sends POST request "endpoint(fake)" with mock data
    And User asserts Status Code that is 201
    And User validates that data was created



 @roles
  Scenario: Return all the Roles
    Given User sends a GET request "endpoint(fake)" for roles
    Then User takes a response for role
    And User asserts Status Code that is 200
    And User validates all of role's list

 @creating_roles
  Scenario Outline:Create a new Role for a User
    Given User creates a mock data for creating a new roles
    Then User sends POST request "endpoint(fake)" with "<Role1>" ,"<Role2>","<Role3>"
    And User asserts Status Code that is 201
    And User validates that role data was created

    Examples:
      |Role1  |Role2|Role3|
      |Manager|Admin |User|



@associate_roles
  Scenario Outline:Associate a Role to a User
    Given User sends PATCH request "endpoint(fake)" with "<EmployeeId>","<EmployeeRole>"
    Then User asserts the Status Code that is 204
    And User validates that Role is assigned  to employee
    Examples:
     |EmployeeId|EmployeeRole|
     |1234      |  User      |
     |5678      |   User     |
     |8979      |   Admin    |


