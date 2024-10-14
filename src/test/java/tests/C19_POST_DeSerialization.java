package tests;

import baseUrl.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import testDatas.RestFullData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C19_POST_DeSerialization  extends RestfulBaseUrl {


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
    public void test21() {
        specRestfull.pathParam("pp1","booking");
        Map<String,Object> reqMap= RestFullData.MapDataOlustur();

        Map<String,Object> expMapBody=RestFullData.expMapOlustur();

        Response response=given().spec(specRestfull).contentType(ContentType.JSON).when().body(reqMap).post("/{pp1}");

        //response.prettyPrint();
        Map<String,Object> respMAP=response.as(HashMap.class);

        assertEquals(((Map)expMapBody.get("booking")).get("firstname"),((Map)respMAP.get("booking")).get("firstname"));
        assertEquals(((Map)expMapBody.get("booking")).get("lastname"),((Map)respMAP.get("booking")).get("lastname"));
        assertEquals(((Map)expMapBody.get("booking")).get("totalprice"),((Map)respMAP.get("booking")).get("totalprice"));
        assertEquals(((Map)expMapBody.get("booking")).get("depositpaid"),((Map)respMAP.get("booking")).get("depositpaid"));
        assertEquals(((Map)expMapBody.get("booking")).get("additionalneeds"),((Map)respMAP.get("booking")).get("additionalneeds"));
        assertEquals(((Map)((Map)expMapBody.get("booking")).get("bookingdates")).get("checkin"),
                (((Map)((Map)respMAP.get("booking")).get("bookingdates")).get("checkin")));
        assertEquals(((Map)((Map)expMapBody.get("booking")).get("bookingdates")).get("checkout"),
                ((Map)((Map)respMAP.get("booking")).get("bookingdates")).get("checkout"));
    }
}
