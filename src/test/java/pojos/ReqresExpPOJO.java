package pojos;

public class ReqresExpPOJO {

    private ReqresDataPOJO data;
    private ReqresSupoortPOJO support;


    public ReqresSupoortPOJO getSupport() {
        return support;
    }

    public void setSupport(ReqresSupoortPOJO support) {
        this.support = support;
    }

    public ReqresDataPOJO getData() {
        return data;
    }

    public void setData(ReqresDataPOJO data) {
        this.data = data;
    }

    public ReqresExpPOJO(ReqresDataPOJO data, ReqresSupoortPOJO support) {
        this.data = data;
        this.support = support;
    }

    public ReqresExpPOJO() {
    }

    @Override
    public String toString() {
        return "ReqresExpPOJO{" +
                "data=" + data +
                ", support=" + support +
                '}';
    }
}
