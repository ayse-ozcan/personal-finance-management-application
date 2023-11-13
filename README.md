## Personal Finance Management Application
## Table of contents
1. SPRING BOOT
- [About This Project](https://github.com/ayse-ozcan/personal-finance-management-application/tree/main#about-this-project)
- [Features](https://github.com/ayse-ozcan/personal-finance-management-application/tree/main#features)
- [Usage](https://github.com/ayse-ozcan/personal-finance-management-application/tree/main#usage)
- [Scripts](https://github.com/ayse-ozcan/personal-finance-management-application/tree/main#scripts)
- [Folder Structure](https://github.com/ayse-ozcan/personal-finance-management-application/tree/main#folder-structure)
2. REACT
- [Pre-requisites](https://github.com/ayse-ozcan/personal-finance-management-application/tree/main#pre-requisites)
- [Getting started](https://github.com/ayse-ozcan/personal-finance-management-application/tree/main#getting-started)
- [Technologies](https://github.com/ayse-ozcan/personal-finance-management-application/tree/main#technologies)
- [Folder Structure](https://github.com/ayse-ozcan/personal-finance-management-application/tree/main#folder-structure-1)
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
## React
### Pre-requisites

Install [Node.js](https://nodejs.org/en/blog/release/v18.17.1) version 18.17.1.

### Getting started

- Clone the repository
```
https://github.com/ayse-ozcan/personal-finance-management-application.git
```
- Install dependencies

```
cd <project_name>
npm install
```
- Run the project

```
npm start
```

### Technologies

- [Material UI](https://mui.com/material-ui/getting-started/)

Material UI is an open-source React component library that implements Google's Material Design. 

### Folder Structure

```
    ├── public
    │   ├── favicon.png
    │   ├── index.html
    │   ├── manifest.json
    │   └── robots.txt
    ├── src
    │   ├── assets
    │   │   └── img
    │   ├── components
    │   │   ├── Footer.js
    │   │   └── Header.js
    │   ├── pages
    │   │   ├── change_password
    │   │   │   └── ChangePassword.js
    │   │   ├── home
    │   │   │   └── HomePage.js
    │   │   ├── profile
    │   │   │   └── Profile.js
    │   │   ├── sign-in
    │   │   │   └── SignIn.js
    │   │   └── sign-up
    │   │       └── SignUp.js
    │   ├── store
    │   │   └── user-store.js
    │   ├── App.js
    │   └── index.js
    ├── .gitignore
    ├── package-lock.json
    ├── package.json
    └── README.md
```    
