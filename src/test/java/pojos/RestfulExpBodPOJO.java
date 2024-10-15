package pojos;

public class RestfulExpBodPOJO {

    /*
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

    private int bookingid;
    private RestfulReqBodyPOJO booking;

    public RestfulReqBodyPOJO getBooking() {
        return booking;
    }

    public void setBooking(RestfulReqBodyPOJO booking) {
        this.booking = booking;
    }

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public RestfulExpBodPOJO(int bookingid, RestfulReqBodyPOJO booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public RestfulExpBodPOJO() {
    }

    @Override
    public String toString() {
        return "RestfulExpBodPOJO{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
