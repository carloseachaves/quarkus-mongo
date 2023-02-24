package com.quarkus.sample.carloseachaves.adapter.rest.v1;

import com.quarkus.sample.carloseachaves.domain.exception.MovieNotFound;
import com.quarkus.sample.carloseachaves.service.MovieService;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;


@QuarkusTest
class MovieResourceTest {

    @InjectMock
    MovieService movieService;

    @Test
    public void shouldReturnOkWithMovieBodyWhenValidRequest() {
        String movieId = "12345678";
        String expectedBody = "{\"id\": \"12345678\", \"name\": \"carlos\"}";
        String mockedResponse = "{\"id\": \"12345678\", \"name\": \"carlos\"}";
        when(movieService.getById("12345678")).thenReturn(mockedResponse);
        given()
                .when().get(format("/v1/movies/%s", movieId))
                .then()
                .statusCode(HttpResponseStatus.OK.code())
                .body(is(expectedBody));
    }

    @Test
    public void shouldReturnBadRequestWhenIdIsInvalid() {
        String expectedBody = "{\"message\":\"getById.id: el tamaño debe estar entre 8 y 8\",\"violations\":[{\"path\":\"getById.id\",\"message\":\"el tamaño debe estar entre 8 y 8\"}]}";
        given()
                .when()
                .get(format("/v1/movies/%s", "INVALID_ID"))
                .then()
                .statusCode(Response.Status.BAD_REQUEST.getStatusCode())
                .body(is(expectedBody));
    }

    @Test
    public void shouldReturnNotFoundWhenMovieIsNotFound() {
        String expectedBody = "{\"message\":\"Movie not found 12345678\"}";
        String movieId = "12345678";
        when(movieService.getById(movieId)).thenThrow(new MovieNotFound(movieId));
        given()
                .when().get(format("/v1/movies/%s", movieId))
                .then()
                .statusCode(Response.Status.NOT_FOUND.getStatusCode())
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