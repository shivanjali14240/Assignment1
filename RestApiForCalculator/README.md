
Steps for build application 
1: mvn clean install 


Sample Request - Response of calculator rest api:

Addition :-
 Request: GET http://localhost:8080/calculatorapi/v1/addition?num1=20&num2=10
 Response: { "answer": 30, "detail": "20+10=30" }

Subtraction :-
 Request: GET http://localhost:8080/calculatorapi/v1/subtraction?num1=20&num2=10
 Response: { "answer": 10, "detail": "20-10=10" }

Multiplication :- 
Request: GET http://localhost:8080/calculatorapi/v1/multiplication?num1=20&num2=10
Response: { "answer":200, "detail": "20*10=200" }

Division :- 
Request: GET http://localhost:8080/calculatorapi/v1/division?num1=20.0&num2=10.0
Response: { "answer":2.0, "detail": "20.0/10.0=2.0"" }

Square :- 
Request: GET http://localhost:8080/calculatorapi/v1/square/5
Response: {"answer": 25, "detail": "square of 5=25" }

Squareroot :-
 Request: GET http://localhost:8080/calculatorapi/v1/squareroot/25 
 Response: { "answer":5, "detail": "Squareroot of 25=5" }

Factorial 
Request: GET http://localhost:8080/calculatorapi/v1/factorial/5 
Response: { "answer": 120, "detail": "Factorial of 5=120" }

Max-min :- 
Request: POST  http://localhost:8080/calculatorapi/v1/max-min 
Body { "numbers" : [1,3,2,5,3,6,7] } 
Response: { "max": 7, "min": 1 }
