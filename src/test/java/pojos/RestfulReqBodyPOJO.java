package pojos;

public class RestfulReqBodyPOJO {

    /*
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
     */

    private String firstname;
    private String lastname;
    private boolean depositpaid;
    private String totalprice;
    private String additionalneeds;
    private RestfulBookindatesPOJO bookindatesPOJO;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public RestfulBookindatesPOJO getBookindatesPOJO() {
        return bookindatesPOJO;
    }

    public void setBookindatesPOJO(RestfulBookindatesPOJO bookindatesPOJO) {
        this.bookindatesPOJO = bookindatesPOJO;
    }

    public RestfulReqBodyPOJO(String firstname, String lastname, boolean depositpaid, String totalprice, String additionalneeds, RestfulBookindatesPOJO bookindatesPOJO) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.depositpaid = depositpaid;
        this.totalprice = totalprice;
        this.additionalneeds = additionalneeds;
        this.bookindatesPOJO = bookindatesPOJO;
    }

    public RestfulReqBodyPOJO() {
    }

    @Override
    public String toString() {
        return "RestfulReqBodyPOJO{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", depositpaid=" + depositpaid +
                ", totalprice='" + totalprice + '\'' +
                ", additionalneeds='" + additionalneeds + '\'' +
                ", bookindatesPOJO=" + bookindatesPOJO +
                '}';
    }
}
