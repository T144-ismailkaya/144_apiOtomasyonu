package tests;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C05_GET_ResponseBodyTesti {

    /*
    C5_Get_ResponseBodyTesti
    https://jsonplaceholder.typicode.com/posts/44 url’ine bir GET request yolladigimizda
    donen Response’in
    status code’unun 200,
    ve content type’inin aplication.JSON,
    ve response body’sinde bulunan userId’nin 5,
    ve response body’sinde bulunan title’in “optio dolor molestias sit”
    oldugunu test edin.,
     */

    @Test
    public void test06(){

        //1- EndPoint ve (varsa) request body hazırlamak
        String url = "https://jsonplaceholder.typicode.com/posts/44";

        //2- Soruda verilmişse expected Data hazırlamak
        // Soruda verilmediği için bu adımı geçiyoruz

        //3- Dönen cevabın kullanılabilmesi için bir obje içine kaydetmek
        Response response = given().when().get(url);

        //4- Assetrion istenmişse bu işlemleri yapmak
        response.then().assertThat().statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("title", Matchers.equalTo("optio dolor molestias sit"))
                .body("userId",Matchers.equalTo(5));
    }

}
