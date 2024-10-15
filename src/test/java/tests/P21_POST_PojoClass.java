package tests;

import baseUrl.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.RestfulBookingDatesPOJO;
import pojos.RestfulExpBodPOJO;
import pojos.RestfulReqBodyPOJO;

import static io.restassured.RestAssured.given;

public class P21_POST_PojoClass  extends RestfulBaseUrl {
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
    public void test01(){

        specRestfull.pathParam("pp1","booking");

        RestfulBookingDatesPOJO bookingDatesPOJO=new RestfulBookingDatesPOJO("2021-01-01","2021-01-10");
        RestfulReqBodyPOJO reqBodyPOJO=new RestfulReqBodyPOJO("wi-fi",bookingDatesPOJO,false,500,"Bulut","Ahmet");


        RestfulExpBodPOJO expBodPOJO=new RestfulExpBodPOJO(24,reqBodyPOJO);

        Response response=given().spec(specRestfull).contentType(ContentType.JSON)
                .when().body(reqBodyPOJO).post("/{pp1}");


        response.prettyPrint();
        RestfulExpBodPOJO resPOJO=response.as(RestfulExpBodPOJO.class);

        Assert.assertEquals(expBodPOJO.getBooking().getFirstname(),resPOJO.getBooking().getFirstname());
        Assert.assertEquals(expBodPOJO.getBooking().getLastname(),resPOJO.getBooking().getLastname());
        Assert.assertEquals(expBodPOJO.getBooking().getTotalprice(),resPOJO.getBooking().getTotalprice());
        Assert.assertEquals(expBodPOJO.getBooking().isDepositpaid(),resPOJO.getBooking().isDepositpaid());
        Assert.assertEquals(expBodPOJO.getBooking().getBookingdates().getCheckin(),resPOJO.getBooking().getBookingdates().getCheckin());
        Assert.assertEquals(expBodPOJO.getBooking().getBookingdates().getCheckout(),resPOJO.getBooking().getBookingdates().getCheckout());
        Assert.assertEquals(expBodPOJO.getBooking().getAdditionalneeds(),resPOJO.getBooking().getAdditionalneeds());

    }


}
