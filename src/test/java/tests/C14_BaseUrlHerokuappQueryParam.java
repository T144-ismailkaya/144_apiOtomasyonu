package tests;

import baseUrl.RestfulBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C14_BaseUrlHerokuappQueryParam extends RestfulBaseUrl {

    /*
    https://restful-booker.herokuapp.com/booking endpointine
    gerekli Query parametrelerini yazarak “firstname” degeri “Eric” olan
    rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
    donen response’un status code’unun 200 oldugunu ve “Eric” ismine
    sahip en az bir booking oldugunu test edin
     */


    @Test
    public void test16(){
        specRestfull.pathParam("pp1","booking").queryParam("firstname","Murat");

        Response response = given().spec(specRestfull).when().get("/{pp1}");
        response.then().assertThat().statusCode(200).body("size()", Matchers.greaterThan(0));

    }

    /*
    https://restful-booker.herokuapp.com/booking endpointine
    gerekli Query parametrelerini yazarak
    “firstname” degeri “Jim” ve “lastname” degeri “Jackson” olan rezervasyon oldugunu
    test edecek bir GET request gonderdigimizde,
    donen response’un status code’unun 200 oldugunu ve
    “Jim Jackson” ismine sahip en az bir booking oldugunu test edin
     */

    @Test
    public void test17(){
        specRestfull.pathParam("pp1", "booking")
                .queryParam("firstname", "Jim")
                .queryParam("lastname", "Brown");

        Response response = given().when().spec(specRestfull).get("/{pp1}");

        response.prettyPrint();

        response.then().assertThat().statusCode(200)
                .body("booking.size()", Matchers.greaterThan(0));
    }

}