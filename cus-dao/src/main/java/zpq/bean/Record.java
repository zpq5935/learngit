package zpq.bean;

import java.util.Date;

public class Record {
    private Integer id;

    private Integer cusid;

    private Integer cssid;

    private Date datetime;

    private Integer mmid;

    private Integer orderid;

    private Date createdate;

    private Boolean mmagree;

    private Boolean cusagree;

    private Date maidatest;

    private Date maidateed;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCusid() {
        return cusid;
    }

    public void setCusid(Integer cusid) {
        this.cusid = cusid;
    }

    public Integer getCssid() {
        return cssid;
    }

    public void setCssid(Integer cssid) {
        this.cssid = cssid;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Integer getMmid() {
        return mmid;
    }

    public void setMmid(Integer mmid) {
        this.mmid = mmid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Boolean getMmagree() {
        return mmagree;
    }

    public void setMmagree(Boolean mmagree) {
        this.mmagree = mmagree;
    }

    public Boolean getCusagree() {
        return cusagree;
    }

    public void setCusagree(Boolean cusagree) {
        this.cusagree = cusagree;
    }

    public Date getMaidatest() {
        return maidatest;
    }

    public void setMaidatest(Date maidatest) {
        this.maidatest = maidatest;
    }

    public Date getMaidateed() {
        return maidateed;
    }

    public void setMaidateed(Date maidateed) {
        this.maidateed = maidateed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}