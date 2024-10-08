package tests;

import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class C03_jSONObjesiOlusturma {

    @Test
    public void test03(){
        JSONObject data = new JSONObject();
        data.put("title","Ahmet");
        data.put("body","Merhaba");
        data.put("userId",1);

        System.out.println(data);
    }

    /*
    {
    “firstname”:“Jim”,
    “additionalneeds”:“Breakfast”,
    “bookingdates”: {
            “checkin”:“2018-01-01",
            “checkout”:“2019-01-01"
 },
     “totalprice”:111,
     “depositpaid”:true,
     “lastname”:“Brown”
 }
     */

    @Test
    public void test04(){
        JSONObject updateData = new JSONObject();
        JSONObject innerData = new JSONObject();
        // İçten İçe data varsa önce en içteki yazılmalı
        innerData.put("checkin","2018-01-01");
        innerData.put("checkout","2019-01-01");

        updateData.put("firstname","Jim");
        updateData.put("additionalneeds","Breakfast");
        updateData.put("bookingdates",innerData);
        updateData.put("totalprice",111);
        updateData.put("depositpaid",true);
        updateData.put("lastname","Brown");

        System.out.println("Update Data: "+updateData);
    }

}