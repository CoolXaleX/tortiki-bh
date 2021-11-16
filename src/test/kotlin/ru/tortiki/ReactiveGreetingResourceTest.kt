package ru.tortiki

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class ReactiveGreetingResourceTest {

    @Test
    fun testHelloEndpoint() {
        given()
            .`when`().get("/user")
            .then()
            .log().all()
            .statusCode(200)
            .body(`is`("Hello RESTEasy Reactive"))
    }

}