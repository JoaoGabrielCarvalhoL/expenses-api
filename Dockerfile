FROM openjdk:17-alpine
LABEL authors="joao"
MAINTAINER 27.joaogabriel@gmail.com
EXPOSE 80
RUN mkdir /expenses
COPY build/libs/expenses-0.0.1-SNAPSHOT.jar /expenses/expense.jar
ENTRYPOINT ["java", "-jar", "/expenses/expense.jar"]