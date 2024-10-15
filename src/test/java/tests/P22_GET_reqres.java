package tests;

import baseUrl.ReqResBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.ReqresDataPOJO;
import pojos.ReqresExpPOJO;
import pojos.ReqresSupoortPOJO;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class P22_GET_reqres extends ReqResBaseUrl {

    /*
    Soru: ReqRes API'sini kullanarak,
    bir kullanıcının ID'sine göre bilgilerinin alındığı
    bir GET isteği yapmanız isteniyor.
    Aşağıdaki gereksinimleri karşılayan bir TestNG test sınıfı yazın:

        https://reqres.in/api/users/2 URL'sine bir GET isteği gönderin.

        Dönen cevabın aşağıdaki gibi olduğunu test edin
        {
    "data": {
        "id": 2,
        "email": "janet.weaver@reqres.in",
        "first_name": "Janet",
        "last_name": "Weaver",
        "avatar": "https://reqres.in/img/faces/2-image.jpg"
    },
    "support": {
        "url": "https://reqres.in/#support-heading",
        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    }
}

     */


    @Test
    public void test01() {

        specReqres.pathParams("pp1","api","pp2","users","pp3","2");

        ReqresDataPOJO dataPOJO= new ReqresDataPOJO(2,"janet.weaver@reqres.in","Janet","Weaver","https://reqres.in/img/faces/2-image.jpg");
        ReqresSupoortPOJO supportPOJO=new ReqresSupoortPOJO("To keep ReqRes free, contributions towards server costs are appreciated!","https://reqres.in/#support-heading");

        ReqresExpPOJO expPOJO=new ReqresExpPOJO(dataPOJO,supportPOJO);

        Response response=given().spec(specReqres).when().get("/{pp1}/{pp2}/{pp3}");

        ReqresExpPOJO resPOJO=response.as(ReqresExpPOJO.class);


        assertEquals(expPOJO.getData().getId(),resPOJO.getData().getId());
        assertEquals(expPOJO.getData().getEmail(),resPOJO.getData().getEmail());
        assertEquals(expPOJO.getData().getFirst_name(),resPOJO.getData().getFirst_name());
        assertEquals(expPOJO.getData().getLast_name(),resPOJO.getData().getLast_name());
        assertEquals(expPOJO.getData().getAvatar(),resPOJO.getData().getAvatar());
        assertEquals(expPOJO.getSupport().getUrl(),resPOJO.getSupport().getUrl());
        assertEquals(expPOJO.getSupport().getText(),resPOJO.getSupport().getText());

    }
}
