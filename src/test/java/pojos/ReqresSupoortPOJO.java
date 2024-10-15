package pojos;

public class ReqresSupoortPOJO {

    /*

    "support": {
        "url": "https://reqres.in/#support-heading",
        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    }

     */

    private String url;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ReqresSupoortPOJO(String text, String url) {
        this.text = text;
        this.url = url;
    }

    public ReqresSupoortPOJO() {
    }

    @Override
    public String toString() {
        return "ReqresSupoortPOJO{" +
                "url='" + url + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
