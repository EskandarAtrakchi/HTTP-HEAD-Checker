# How to Run

1.  Clone the repository:

    ```
    git clone https://github.com/your-username/HTTP-HEAD-Checker.git
    cd HTTP-HEAD-Checker
    ```
2.  Compile the application:

    ```
    javac HeadRequestApp.java
    ```

## Example Usage

#### Case 1: User enters a valid URL

```
Input: http://httpforever.com/
Output:
Connected to: http://httpforever.com/
Response Code: 200
Response Message: OK
```

#### Case 2: User leaves input blank

```
Input: (blank)
Output:
Connected to: http://nginx.org/
Response Code: 200
Response Message: OK
```

#### Case 3: User enters an invalid URL

```
Input: invalid-url
Output:
Error: Invalid URL: invalid-url
```
