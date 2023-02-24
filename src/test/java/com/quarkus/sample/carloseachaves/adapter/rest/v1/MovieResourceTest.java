package com.quarkus.sample.carloseachaves.adapter.rest.v1;

import com.quarkus.sample.carloseachaves.service.MovieService;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;


@QuarkusTest
class MovieResourceTest {

    @InjectMock
    MovieService movieService;

    @Test
    public void shouldReturnOkWithMovieBodyWhenValidRequest() {
        String expectedBody = "{\"id\": \"1\", \"name\": \"carlos\"}";
        String mockedResponse = "{\"id\": \"1\", \"name\": \"carlos\"}";
        when(movieService.getById("1")).thenReturn(mockedResponse);
        given()
                .when().get("/v1/movies/1")
                .then()
                .statusCode(HttpResponseStatus.OK.code())
                .body(is(expectedBody));
    }

    @Test
    public void shouldReturnBadRequestWhenIdIsInvalid() {
        String expectedBody = "BODY INVALID";
        given()
                .when().get("/v1/movies/1")
                .then()
                .statusCode(HttpResponseStatus.BAD_REQUEST.code())
                .body(is(expectedBody));
    }

    @Test
    public void shouldReturnNotFoundWhenMovieIsNotFound() {
        String expectedBody = "BODY NOT FOUND";
        given()
                .when().get("/v1/movies/1")
                .then()
                .statusCode(HttpResponseStatus.NOT_FOUND.code())
                .body(is(expectedBody));
    }

    @Test
    public void shouldReturnInternalServerErrorWhenUnknownErrorIsThrow() {
        String expectedBody = "BODY NOT FOUND";
        given()
                .when().get("/v1/movies/1")
                .then()
                .statusCode(HttpResponseStatus.INTERNAL_SERVER_ERROR.code())
                .body(is(expectedBody));
    }

    @Test
    public void shouldReturnGatewayTimeoutWhenResponseIsTimedOut() {
        String expectedBody = "BODY NOT FOUND";
        given()
                .when().get("/v1/movies/1")
                .then()
                .statusCode(HttpResponseStatus.GATEWAY_TIMEOUT.code())
                .body(is(expectedBody));
    }

}