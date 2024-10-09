package tests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C12_BaseUrlJsonPlaceHolder extends JsonPlaceHolderBaseUrl {
    /*

            https://jsonplaceholder.typicode.com/posts endpointine
             bir GET request gonderdigimizde
             donen response’un status code’unun 200 oldugunu ve
             Response’ta 100 kayit oldugunu test edin


     */
    @Test
    public void test13() {

        specJPH.pathParam("firstname", "posts");

        Response response = given().spec(specJPH).when().get("/{firstname}");
        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasSize(100));

    }

}