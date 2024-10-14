package tests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import testDatas.JsonPlaceData;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C18_PUT_DeSerialization extends JsonPlaceHolderBaseUrl {

    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine
    asagidaki body’e sahip bir PUT request yolladigimizda
    donen response’in response body’sinin
    asagida verilen ile ayni oldugunu test ediniz

    Request Body
    {
    "title": "Ahmet",
    "body": "Merhaba",
    "userId": 10,
    "id": 70
    }

    Expected Data :
    {
    "title": "Ahmet",
    "body": "Merhaba",
    "userId": 10,
    "id": 70
    }
     */

    @Test
    public void test20(){
        specJPH.pathParams("pp1","posts","pp2","70");

        Map<String, Object> reqMapBody = JsonPlaceData.MapDataOlustur("Ahmet","Merhaba",10.0,70.0);
        Map<String, Object> expMapBody = JsonPlaceData.MapDataOlustur("Ahmet","Merhaba",10.0,70.0);

        Response response = given().spec(specJPH).contentType(ContentType.JSON).when().body(reqMapBody).put("/{pp1}/{pp2}");
        Map<String,Objects> resMap = response.as(HashMap.class);

        assertEquals(expMapBody.get("title"),resMap.get("title"));
        assertEquals(expMapBody.get("body"),resMap.get("body"));
        assertEquals(expMapBody.get("userId"),resMap.get("userId"));
        assertEquals(expMapBody.get("id"),resMap.get("id"));

    }

}