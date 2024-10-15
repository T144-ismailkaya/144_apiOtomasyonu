package tests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.JPHPojos;

import static io.restassured.RestAssured.given;

public class P20_PUT_PojoClass extends JsonPlaceHolderBaseUrl {
/*

        https://jsonplaceholder.typicode.com/posts/70 url’ine
asagidaki body’e sahip bir PUT request yolladigimizda
donen response’in response body’sinin
asagida verilen ile ayni oldugunu test ediniz

Request Body
{
    “title”: “Ahmet”,
    “body”: “Merhaba”,
    “userId”: 10,
    “id”: 70
}

Expected Data :
{
    “title”: “Ahmet”,
    “body”: “Merhaba”,
    “userId”: 10,
    “id”: 70
}

 */

    @Test
    public void putPojo(){
        specJPH.pathParams("pp1","posts","pp2","70");

        JPHPojos reqPOJO=new JPHPojos("Ahmet","Merhaba",10,70);

        JPHPojos expPOOJO=new JPHPojos("Ahmet","Merhaba",10,70);

        Response response=given().spec(specJPH).contentType(ContentType.JSON).when().body(reqPOJO).put("/{pp1}/{pp2}");


        JPHPojos resPOJO=response.as(JPHPojos.class);

        Assert.assertEquals(expPOOJO.getTitle(),resPOJO.getTitle());
        Assert.assertEquals(expPOOJO.getBody(),resPOJO.getBody());
        Assert.assertEquals(expPOOJO.getUserId(),resPOJO.getUserId());
        Assert.assertEquals(expPOOJO.getId(),resPOJO.getId());



    }
}
