package pojos;

public class RestfulExpBodyPOJO {

    private int bookingid;
    private RestfulReqBodyPOJO booking;

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public RestfulReqBodyPOJO getBooking() {
        return booking;
    }

    public void setBooking(RestfulReqBodyPOJO booking) {
        this.booking = booking;
    }

    public RestfulExpBodyPOJO(int bookingid, RestfulReqBodyPOJO booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public RestfulExpBodyPOJO() {
    }

    @Override
    public String toString() {
        return "RestfulExpBodyPOJO{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
