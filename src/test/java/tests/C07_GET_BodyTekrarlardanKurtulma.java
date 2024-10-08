package tests;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class C07_GET_BodyTekrarlardanKurtulma {

    /*
    https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde donen Response’un,
    status code’unun 200,
    ve content type’inin application-json,
    ve response body’sindeki
    “firstname”in, “Susan”,
    ve “lastname”in, “Jackson”,
    ve “totalprice”in, 612,
    ve “depositpaid”in, false,
    ve “additionalneeds”in, “Breakfast”
    oldugunu test edin
     */

    @Test
    public void test08(){
        String url = "https://restful-booker.herokuapp.com/booking/10";

        Response response = given().when().get(url);

        response.then().assertThat().statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("firstname", equalTo("Susan"),
                "lastname", equalTo("Jackson"),
                "totalprice", equalTo(991),
                "depositpaid", equalTo(true),
                "additionalneeds", equalTo(null));

    }

}