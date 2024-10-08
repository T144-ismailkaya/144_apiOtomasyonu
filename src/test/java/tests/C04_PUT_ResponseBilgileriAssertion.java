package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C04_PUT_ResponseBilgileriAssertion {

    /*
    https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki Json formatindaki body ile bir PUT request gonderdigimizde
    {
        “title”: “Ahmet”,
        “body”: “Merhaba”,
        “userId”: 10,
        “id”: 70
    }
    donen Response’un,
      status code’unun 200,
     ve content type’inin application/json; charset=utf-8,
     ve Server isimli Header’in degerinin cloudflare,
     ve status Line’in HTTP/1.1 200 OK
     */

    @Test
    public void test05(){
        //1- EndPoint ve (varsa) request body hazırlamak
        String url = "https://jsonplaceholder.typicode.com/posts/70";

        JSONObject reqBody = new JSONObject();
        reqBody.put("title","Ahmet");
        reqBody.put("body","Merhaba");
        reqBody.put("userId",10);
        reqBody.put("id",70);

        //2- Soruda verilmişse expected Data hazırlamak
        // Soruda verilmediği için bu adımı geçiyoruz

        //3- Dönen cevabın kullanılabilmesi için bir obje içine kaydetmek
        Response response = given().contentType(ContentType.JSON).when().body(reqBody.toString()).put(url);

        //4- Assetrion istenmişse bu işlemleri yapmak
        response.then().assertThat().statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","cloudflare")
                .statusLine("HTTP/1.1 200 OK");
        System.out.println("Tüm Testler Başarıyla Tamamlandı.");
    }

}