# Expenses 

- The Expense system was developed to help manage your expenses.
The system provides you with several functionalities for managing and consulting your expenses.


- Next versions:
  - Reports
  - Email Service

## Run Expenses API. 
    docker compose build
    docker compose up

## Endpoint for user creation.
    http://localhost:8080/user (POST)
    
## Payload
    {
        "Nome": "João Gabriel Carvalho", 
        "Email": "email@email.com", 
        "Usuário": "joao",
        "Senha": "***", 
        "Papel": "ROLE_ADMIN", 
        "Data de Nascimento": "1996-01-15"
    }

## Swagger (Documentation)
    http://localhost:8080/swagger-ui/index.html#/