package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C01_GET_ApiSorgulama {

    /*
    https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde donen Response’un,
    status code’unun 200,
    ve content type’inin application/json; charset=utf-8,
    ve Server isimli Header’in degerinin Cowboy,
    ve status Line’in HTTP/1.1 200 OK
    ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
    */

    /*
    Tüm API Testleri 4 Aşamadan Oluşur
        1- EndPoint ve (varsa) request body hazırlamak
        2- Soruda verilmişse expected Data hazırlamak
        3- Dönen cevabın kullanılabilmesi için bir obje içine kaydetmek
        4- Assetrion istenmişse bu işlemleri yapmak
     */

    @Test
    public void test01(){
        //1- EndPoint ve (varsa) request body hazırlamak
        String url = "https://restful-booker.herokuapp.com/booking/10";

        //2- Soruda verilmişse expected Data hazırlamak
        // Soruda verilmediği için bu adımı geçiyoruz

        //3- Dönen cevabın kullanılabilmesi için bir obje içine kaydetmek
        Response response = given().when().get(url);

        //4- Assetrion istenmişse bu işlemleri yapmak
        System.out.println("Status Code: "+response.getStatusCode());
        System.out.println("Content Type: "+response.contentType());
        System.out.println("Header (Server): "+response.header("Server"));
        System.out.println("Status Line: "+response.statusLine());
        System.out.println("Response Time: "+response.time());
        //System.out.println(response.prettyPrint());
    }

}
