package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C02_GET_ResponseBilgileriAssertion {

    /*
    https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde donen Response’un,
    status code’unun 200,
    ve content type’inin application/json; charset=utf-8,
    ve Server isimli Header’in degerinin Cowboy,
    ve status Line’in HTTP/1.1 200 OK
     */

    @Test
    public void test02(){

        //1- EndPoint ve (varsa) request body hazırlamak
        String url = "https://restful-booker.herokuapp.com/booking/10";

        //2- Soruda verilmişse expected Data hazırlamak
        // Soruda verilmediği için bu adımı geçiyoruz

        //3- Dönen cevabın kullanılabilmesi için bir obje içine kaydetmek
        Response response = given().when().get(url);

        //4- Assetrion istenmişse bu işlemleri yapmak
        response.then().assertThat().statusCode(200)
                .contentType("application/json; charset=utf-8")
                .statusLine("HTTP/1.1 200 OK")
                .header("Server","Cowboy");
    }

}