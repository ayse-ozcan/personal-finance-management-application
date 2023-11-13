## Personal Finance Management Application
### About This Project
This project is a personal budget management application developed in Java, designed to streamline the process of tracking income and expenses while providing a comprehensive overview of the total budget.

#### Features:
- **Income and Expense Tracking:** Users can input their income and expenses, allowing for a detailed record of financial transactions.
- **Budget Calculation:** The application dynamically calculates the overall budget by considering both income and expenses, providing users with a clear snapshot of their financial status.
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
    │   │       │   ├── security
    │   │       │   │   ├── JwtFilter
    │   │       │   │   ├── JwtUserDetails
    │   │       │   │   └── SecurityConfig
    │   │       │   └── swagger
    │   │       │       └── SwaggerConfig
    │   │       ├── constant
    │   │       │   └── ApiUrls
    │   │       ├── controller
    │   │       │   ├── BudgetController
    │   │       │   ├── ExpenseController
    │   │       │   ├── IncomeController
    │   │       │   └── UserController    
    │   │       ├── dto
    │   │       │   ├── request
    │   │       │   │   ├── ChangePasswordRequestDto
    │   │       │   │   ├── ExpenseSaveRequestDto
    │   │       │   │   ├── ExpenseUpdateRequestDto
    │   │       │   │   ├── IncomeSaveRequestDto
    │   │       │   │   ├── IncomeUpdateRequestDto
    │   │       │   │   ├── LoginRequestDto
    │   │       │   │   ├── RegisterRequestDto
    │   │       │   │   └── UserUpdateRequestDto 
    │   │       │   └── response
    │   │       │       ├── FindExpenseResponseDto
    │   │       │       ├── FindIncomeResponseDto
    │   │       │       ├── FindUserResponseDto
    │   │       │       ├── GetExpenseAmountResponseDto
    │   │       │       ├── GetIncomeAmountResponseDto
    │   │       │       └── UserLoginResponseDto          
    │   │       ├── exception
    │   │       │   ├── ErrorMessage
    │   │       │   ├── ErrorType
    │   │       │   ├── FinanceManagementException
    │   │       │   └── GlobalExceptionHandler      
    │   │       ├── mapper
    │   │       │   ├── IExpenseMapper 
    │   │       │   ├── IIncomeMapper
    │   │       │   └── IUserMapper 
    │   │       ├── repository
    │   │       │   ├── entity
    │   │       │   │   ├── BaseEntity 
    │   │       │   │   ├── Budget
    │   │       │   │   ├── Expense
    │   │       │   │   ├── Income
    │   │       │   │   └── User    
    │   │       │   ├── enums
    │   │       │   │   └── ERole      
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
    │   │       │   ├── JwtProvider
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