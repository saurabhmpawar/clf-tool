# clf-tool
Cloud log forensics for cost optimization and security




### Running Tests

##### 1. Run only unit tests
```sh
mvn clean test
```

##### 2. Run only integration-test
```sh
mvn clean verify -P integration-test
```

##### rest-assured documentation
<https://github.com/rest-assured/rest-assured>

##### 3. Run both unit and integration tests
```sh
mvn clean install

or

mvn install -DskipTests=true