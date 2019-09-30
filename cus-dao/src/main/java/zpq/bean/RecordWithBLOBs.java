package zpq.bean;

public class RecordWithBLOBs extends Record {
	private String appremark;

	private String cuseva;

	public String getAppremark() {
		return appremark;
	}

	public void setAppremark(String appremark) {
		this.appremark = appremark == null ? null : appremark.trim();
	}

	public String getCuseva() {
		return cuseva;
	}

	public void setCuseva(String cuseva) {
		this.cuseva = cuseva == null ? null : cuseva.trim();
	}

	/*************** 自己添加的，为了查询维修记录可以查询各个名称 *********/

	private Product product;

	private Customer customer;

	private Css css;

	private MainMan mainMan;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Css getCss() {
		return css;
	}

	public void setCss(Css css) {
		this.css = css;
	}

	public MainMan getMainMan() {
		return mainMan;
	}

	public void setMainMan(MainMan mainMan) {
		this.mainMan = mainMan;
	}

	@Override
	public String toString() {
		return "RecordWithBLOBs [id=" + this.getId() + ", cusid=" + this.getCusid() + ", cssid=" + this.getCssid()
				+ ", datetime=" + this.getDatetime() + ", mmid=" + this.getMmid() + ", orderid=" + this.getOrderid()
				+ ", createdate=" + this.getCreatedate() + ", mmagree=" + this.getMmagree() + ", cusagree="
				+ this.getCusagree() + ", maidatest=" + this.getMaidatest() + ", maidateed=" + this.getMaidateed()
				+ ", status=" + this.getStatus() + ", appremark=" + appremark + ", cuseva=" + cuseva + "]";
	}
}