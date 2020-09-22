package zpq.bean;

public class Css extends User {

    private Boolean isdeleted;


    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    @Override
    public String toString() {
        return "Css{" +
                "isdeleted=" + isdeleted +
                '}';
    }
}