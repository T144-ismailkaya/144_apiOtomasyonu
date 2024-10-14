package tests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.RestfulBookindatesPOJO;
import pojos.RestfulExpBodyPOJO;
import pojos.RestfulReqBodyPOJO;

import static io.restassured.RestAssured.given;

public class P21_POST_PojoClass  extends JsonPlaceHolderBaseUrl {
    /*
    https://restful-booker.herokuapp.com/booking url’ine
asagidaki body’ye sahip bir POST request gonderdigimizde
donen response’un id haric asagidaki gibi oldugunu test edin.
Request body
       {
           “firstname” : “Ahmet”,
           “lastname” : “Bulut”,
           “totalprice” : 500,
           “depositpaid” : false,
           “bookingdates” : {
               “checkin” : “2021-06-01”,
               “checkout” : “2021-06-10”
           },
           “additionalneeds” : “wi-fi”
       }
Response Body // expected data
 {
    “bookingid”: 24,
    “booking”: {
        “firstname”: “Ahmet”,
        “lastname”: “Bulut”,
        “totalprice”: 500,
        “depositpaid”: false,
        “bookingdates”: {
            “checkin”: “2021-06-01",
            “checkout”: “2021-06-10"
        },
        “additionalneeds”: “wi-fi”
    }
}

     */

    @Test
    public void test23(){
        specJPH.pathParam("pp1","booking");
        RestfulBookindatesPOJO bookingdatesPOJO=new RestfulBookindatesPOJO("2024-09-30","2024-10-30");
        RestfulReqBodyPOJO reqPOJO=new RestfulReqBodyPOJO("Ahmet","Bulut",false,"500","wi-fi",bookingdatesPOJO);

        RestfulExpBodyPOJO expPJPO=new RestfulExpBodyPOJO(24,reqPOJO);

        Response response=given().spec(specJPH).contentType(ContentType.JSON).when().body(reqPOJO).post("/{pp1}");
        response.prettyPrint();

        RestfulExpBodyPOJO resPOJO=response.as(RestfulExpBodyPOJO.class);


        Assert.assertEquals(expPJPO.getBooking().getFirstname(),resPOJO.getBooking().getFirstname());
        Assert.assertEquals(expPJPO.getBooking().getLastname(),resPOJO.getBooking().getLastname());
        Assert.assertEquals(expPJPO.getBooking().getTotalprice(),resPOJO.getBooking().getTotalprice());
        Assert.assertEquals(expPJPO.getBooking().getAdditionalneeds(),resPOJO.getBooking().getAdditionalneeds());
        Assert.assertEquals(expPJPO.getBooking().isDepositpaid(),resPOJO.getBooking().isDepositpaid());
        Assert.assertEquals(expPJPO.getBooking().getBookindatesPOJO().getCheckin(),resPOJO.getBooking().getBookindatesPOJO().getCheckin());
        Assert.assertEquals(expPJPO.getBooking().getBookindatesPOJO().getCheckout(),resPOJO.getBooking().getBookindatesPOJO().getCheckout());

    }
}