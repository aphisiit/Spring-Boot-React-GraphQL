# Spring-Boot | React
This project is spring boot project and include react js in project. 
In development must run with terminal only.

### Run project
```shell script
$ mvn clean compile -Dmaven.test.skip=true
```

### Build project
```shell script
$ mvn clean compile -Dmaven.test.skip=true package
```

Note : You need import package `babel-polyfill` at head of *.js file, 
Because if no import, your web page will not work when you start application.

### Testing GraphQL API
Go to http://localhost:8080/DemoQL/graphiql

Insert Data : 
```graphql
mutation {
  createBook(name: "How to write song", isbn: "1234-5678-0912", author: "Taylor Swift", price: "10.4") 
  {
    id
  }
}
```
Query All Data :
```graphql
{
  books {
    id,
    name,
    author,
    publishDate
  }
}
```
Query By ID
```graphql
{
  book(id: 1) {
    name,
    author,
    publishDate
  }
}
```

`Note :` You can remove field or add field in query