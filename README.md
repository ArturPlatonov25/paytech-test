# paytech-test
Interview

`docker build -t paytech-app .`<br>
`docker run -p 8080:8080 -e PAYMENT_API_TOKEN=<place_your_token_here> paytech-app`

http://localhost:8080/payment/create