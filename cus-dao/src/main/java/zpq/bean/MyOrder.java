package zpq.bean;

import java.util.Date;

public class MyOrder {
    private Integer id;

    private Integer proid;

    private Integer cusid;

    private Integer amount;

    private Date datetime;

    private Integer cssid;

    private Boolean isdeleted;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public Integer getCusid() {
        return cusid;
    }

    public void setCusid(Integer cusid) {
        this.cusid = cusid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Integer getCssid() {
        return cssid;
    }

    public void setCssid(Integer cssid) {
        this.cssid = cssid;
    }

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    
    /**********************/
    private Customer customer;
    private Product product;
    private Css css;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Css getCss() {
		return css;
	}

	public void setCss(Css css) {
		this.css = css;
	}

	@Override
	public String toString() {
		return "MyOrder [id=" + id + ", proid=" + proid + ", cusid=" + cusid + ", amount=" + amount + ", datetime="
				+ datetime + ", cssid=" + cssid + ", isdeleted=" + isdeleted + ", remark=" + remark + ", customer="
				+ customer + ", product=" + product + ", css=" + css + "]";
	}
    
}