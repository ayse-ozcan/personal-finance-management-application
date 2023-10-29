## Personal Finance Management Application
### About This Project
### Usage
You will need to have Gradle and JDK 8 or higher. The recommended way to run the sample applications is with IDEs like IntelliJ IDEA or Eclipse. You will also need to run MongoDB, in Docker container, so you must have Docker installed on your local machine.
### Scripts
- MongoDB
```
docker run -d -e MONGO_INITDB_ROOT_USERNAME=mongoadmin -e MONGO_INITDB_ROOT_PASSWORD=secret -p 27017:27017 mongo
```
### Folder Structure

```
└── src
    ├── main
    │   ├── java
    │   │   └── com.ayseozcan
    │   │       ├── config
    │   │       │   └── security
    │   │       ├── constant
    │   │       │   └── ApiUrls
    │   │       ├── controller
    │   │       │   ├── BudgetController
    │   │       │   ├── ExpenseController
    │   │       │   ├── IncomeController
    │   │       │   └── UserController    
    │   │       ├── dto
    │   │       │   ├── request
    │   │       │   └── response       
    │   │       ├── exception
    │   │       │   ├── ErrorMessage
    │   │       │   ├── ErrorType
    │   │       │   ├── FinanceManagementException
    │   │       │   └── GlobalExceptionHandler      
    │   │       ├── mapper
    │   │       ├── repository
    │   │       │   ├── entity
    │   │       │   │   ├── BaseEntity 
    │   │       │   │   ├── Budget
    │   │       │   │   ├── Expense
    │   │       │   │   ├── Income
    │   │       │   │   └── User    
    │   │       │   ├── enums
    │   │       │   │   ├── ERole
    │   │       │   │   └── EStatus      
    │   │       │   ├── IBudgetRepository
    │   │       │   ├── IExpenseRepository
    │   │       │   ├── IIncomeRepository
    │   │       │   └── IUserRepository 
    │   │       ├── service 
    │   │       │   ├── BudgetService
    │   │       │   ├── ExpenseService
    │   │       │   ├── IncomeService
    │   │       │   └── UserService   
    │   │       ├── utility 
    │   │       │   ├── IService
    │   │       │   └── ServiceManager  
    │   │       └── FinanceManagementApplication
    │   └── resources
    │       ├── static
    │       ├── templates
    │       └── application.yaml
    └── test
        ├── java
        ├── com.ayseozcan
        └── FinanceManagementApplicationTests
```