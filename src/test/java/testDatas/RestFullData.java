package testDatas;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RestFullData {

    public static JSONObject bookingdatesOlustur(String checkin, String checkout) {
        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", checkin);
        bookingdates.put("checkout", checkout);
        return bookingdates;
    }

    public static JSONObject jsonDataOlustur(String firstname, String lastname, int totalprice, boolean depoistpaid, JSONObject bookingdates, String additionalneeds) {
        JSONObject booking = new JSONObject();


        booking.put("firstname", firstname);
        booking.put("lastname", lastname);
        booking.put("totalprice", totalprice);
        booking.put("depoistpaid", depoistpaid);
        booking.put("bookingdates", bookingdates);
        booking.put("additionalneeds", additionalneeds);

        return booking;
    }

    public static Map<String, Object> MapDataOlustur() {
        Map<String, Object> innerMap = new HashMap<>();
        innerMap.put("checkin", "2021-06-01");
        innerMap.put("checkout", "2021-06-10");


        Map<String, Object> bookingMap = new HashMap<>();
        bookingMap.put("firstname", "Ahmet");
        bookingMap.put("totalprice", 500);
        bookingMap.put("lastname", false);
        bookingMap.put("depoistpaid", innerMap);

        return bookingMap;
    }

    public static Map<String,Object >expMapOlustur(){
        Map<String,Object >expMap = new HashMap<>();
        expMap.put("bookingid",24);
        expMap.put("booking",RestFullData.MapDataOlustur());

        return expMap;
    }


}
