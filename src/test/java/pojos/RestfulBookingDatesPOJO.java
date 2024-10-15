package pojos;

public class RestfulBookingDatesPOJO {


    /*
    “bookingdates” : {
               “checkin” : “2021-06-01”,
               “checkout” : “2021-06-10”
           }
     */

    private String checkin;
    private String checkout;

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public RestfulBookingDatesPOJO(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public RestfulBookingDatesPOJO() {
    }

    @Override
    public String toString() {
        return "RestfulBookingDatesPOJO{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
