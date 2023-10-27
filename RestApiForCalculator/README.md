
Steps for build application 
1: mvn clean install 


Sample Request - Response of calculator rest api:

Addition :-
 Request: GET http://localhost:8080/calculatorapi/v1/addition?num1=10&nuum2=1 
 Response: { "answer": 11, "detail": "10 + 1 = 11" }

Subtraction :-
 Request: GET http://localhost:8080/calculatorapi/v1/subtraction?num1=10&nuum2=1 
 Response: { "answer": -3, "detail": "12 - 15 = -3" }

Multiplication :- 
Request: GET http://localhost:8080/calculatorapi/v1/multiplication?num1=10&nuum2=2 
Response: { "answer":20, "detail": "10 * 2 = 20" }

Division :- 
Request: GET http://localhost:8080/calculatorapi/v1/division?num1=10.0&num2=5.0 
Response: { "answer":2, "detail": "10.0/2.0 =55.0" }

Square :- 
Request: GET http://localhost:8080/calculatorapi/v1/square/5 
Response: {"answer": 25, "detail": "square of 5 = 25" }

Squareroot :-
 Request: GET http://localhost:8080/calculatorapi/v1/squareroot/16 
 Response: { "answer":4, "detail": "squareroot of 16 = 4" }

Factorial 
Request: GET http://localhost:8080/calculatorapi/v1/factorial/5 
Response: { "answer": 120, "detail": "5! = 120" }

Max-min :- 
Request: POST http://localhost:8080/calculatorapi/v1/max-min Body { "numbers" : [1,3,2,5,3,6,7] } 
Response: { "min": 1, "max": 7 }