package tests;

import baseUrl.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import testDatas.RestFullData;

import static io.restassured.RestAssured.given;

public class P23_TokenKullanimi extends RestfulBaseUrl {
    /*
    https://restful-booker.herokuapp.com/booking/2410 (id güncellenmeli)
    adresindeki rezervasyon bilgilerini
        -H 'Content-Type: application/json' \
        -H 'Accept: application/json' \
        -H 'Cookie: token=abc123' \ veya -H 'Authorization:Basic YWRtaW46cGFzc3dvcmQxMjM=' \
        header değerleriyle PUT request göndererek update ediniz.


        Token Oluşturma
        Content-Type: application/json header derğeriyle aşağıdaki body ile
        {
                "username" : "admin",
                "password" : "password123"
        }
        Post Request yapınız

 */

    static  String token;


    @Test
    public void test01(){
        specRestfull.pathParam("pp1","auth");

        JSONObject data = new JSONObject();
        data.put("username" , "admin");
        data.put("password" , "password123");


        Response response=given().contentType(ContentType.JSON).when().spec(specRestfull).body(data.toString())
                                 .header("Content-Type","application/json").post("/{pp1}");

       // response.prettyPrint();


       JsonPath resJP=response.jsonPath();

      token=resJP.getString("token");
      // System.out.println(token);


    }

    @Test
    public void test02(){

        specRestfull.pathParams("pp1","booking","pp2","1166");

        JSONObject reqbody= RestFullData.reqBodyOlustur();

        Response response=given().contentType(ContentType.JSON)
                .when().spec(specRestfull).body(reqbody.toString())
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .header("Cookie","token="+token).put("/{pp1}/{pp2}");

    }

    @Test
    public void test03(){

        specRestfull.pathParams("pp1","booking","pp2","1166");
        JSONObject reqbody= RestFullData.reqBodyOlustur();
        Response response=given().contentType(ContentType.JSON)
                .when().spec(specRestfull).body(reqbody.toString())
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=").put("/{pp1}/{pp2}");

    }

}
