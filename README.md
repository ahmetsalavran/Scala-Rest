# Scala-Rest

1-->  git clone https://github.com/ahmetsalavran/Scala-Rest.git

2--> cd Scala-Rest

3--> sbt run


*******CURL***********

GET  /healthcheck

curl --location --request GET "http://localhost:9000/healthcheck"

GET /messages/:id

curl --location --request GET "http://localhost:9000/messages/616c30c2b161b15f6ae4a216"

POST /messages

curl --location --request POST 'http://localhost:9000/messages' \
--header 'User-Agent: emilie' \
--header 'Content-Type: application/json' \
--data-raw '{"message":"Oh my gosh! It’s racism #FuckThePolice #BlackLivesMatters"}'

DELETE /messages/:id

curl --location --request DELETE 'http://localhost:9000/messages/616c30c2b161b15f6ae4a216'

GET /messages

curl --location --request GET 'http://localhost:9000/messages?tag=FuckThePolice,BlackLivesMatters&page=1&count=2' \
--header 'User-Agent: emilie' \
--header 'Content-Type: application/json' \
--data-raw '{"message":"Oh my gosh! It’s racism #FuckThePolice #BlackLivesMatters"}'

```html
<h2>Example of code</h2>

<pre>
    <div class="container">
        <div class="block two first">
            <h2>Your title</h2>
            <div class="wrap">
            //Your content
            </div>
        </div>
    </div>
</pre>
```
