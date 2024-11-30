package com.example.library;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class RestAssuredTest {

    @BeforeAll
    static void setup() {
        // Set the base URI and port for Rest Assured
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8103; // Update the port if necessary
    }

    @Test
    void testGetBooks() {
        RestAssured
            .given()
            .when()
            .get("/api/books")
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("size()", greaterThanOrEqualTo(0)); // Assuming it returns a list
    }

    @Test
    void testAddBook() {
        String newBook = """
            {
                "title": "The Pragmatic Programmer",
                "author": "Andrew Hunt",
                "isbn": "978-0135957059"
            }
        """;

        RestAssured
            .given()
            .contentType(ContentType.JSON)
            .body(newBook)
            .when()
            .post("/api/books")
            .then()
            .statusCode(201)
            .body("title", equalTo("The Pragmatic Programmer"))
            .body("author", equalTo("Andrew Hunt"))
            .body("isbn", equalTo("978-0135957059"));
    }

    @Test
    void testDeleteBook() {
        // Add a book first to ensure it exists
        String bookToDelete = """
            {
                "title": "Test Book",
                "author": "Test Author",
                "isbn": "978-0000000000"
            }
        """;

        Response response = RestAssured
            .given()
            .contentType(ContentType.JSON)
            .body(bookToDelete)
            .when()
            .post("/api/books");

        int bookId = response.jsonPath().getInt("id");

        // Delete the book
        RestAssured
            .given()
            .when()
            .delete("/api/books/" + bookId)
            .then()
            .statusCode(204);
    }
}
