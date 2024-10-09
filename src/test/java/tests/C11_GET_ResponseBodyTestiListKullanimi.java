package tests;

import baseUrl.CollectApiBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C11_GET_ResponseBodyTestiListKullanimi extends CollectApiBaseUrl {
    /*

        https://api.collectapi.com/health/dutyPharmacy?il=Kırıkkale url’ine
        bir GET request yolladigimizda
        donen Response’in
        status code’unun 200,
        ve content type’inin Aplication.JSON,
        ve response body’sindeki
            eczane sayısıın sayisinin 4
            ve eczane’lerden birinin “DELİCE ECZANESİ”
            ve eczanele ilçelerinde icinde Merkez ,Delice ve Keskin degerinin oldugunu test edin.
     */
    @Test
    public void test12() {

        //1- Endpoint ve varsa Request Data Hazırlama

        specCollectApi.pathParams("pp1", "health", "pp2", "dutyPharmacy").queryParam("il", "Kırıkkale");

        //2-expected data oluşturma

        //3-Response kaydetme
        String apiKey = "apikey 02kcNzq8lY0dG4kIvsVvSu:17lnXY8mGNkyfPFrjDDtqt";
        Response response = given().spec(specCollectApi).when().header("authorization", apiKey).get("/{pp1}/{pp2}");

        response.then().assertThat().statusCode(200).contentType("application/json")
                .body("result.name", hasSize(5))
                .body("result.name", hasItem("DELİCE ECZANESİ"))
                .body("result.dist", hasItems("Merkez", "Delice", "Keskin"));
    }

}