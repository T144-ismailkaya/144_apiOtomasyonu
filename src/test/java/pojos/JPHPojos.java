package pojos;

public class JPHPojos {

    //1- TÜm Variable'lar private olarak oluşturulur

    private String title;
    private String body;
    private int userId;
    private int id;

    //2-Getter() ve Setter()


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //3-parametrli constructor oluştur

    public JPHPojos(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }
//4-Ölen default'un görevini yapacak bir parametresiz contructor oluşturuduk
    public JPHPojos() {

    }

    @Override
    public String toString() {
        return "JPHPojos{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
