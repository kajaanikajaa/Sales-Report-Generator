# Sales Reporter

Command-line Java tool for generating a product sales summary from a CSV file.

## Run with Maven

```text
mvn test
```

## Example command

For console output:

```text
java -cp target/classes SalesReporter data/sales.csv console
```

For file output:

```text
java -cp target/classes SalesReporter data/sales.csv file output/report.txt
```

## Team Work

- Member 1: Core logic, CSV reading, calculations and report generation.
- Member 2: File I/O, unit testing and SOLID improvements.
- Member 3: Console interface, exception handling and documentation.
