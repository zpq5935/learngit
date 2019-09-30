package zpq.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import zpq.bean.MyOrderExample.Criteria;

public class RecordExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public RecordExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("ID is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("ID is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("ID =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("ID <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("ID >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ID >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("ID <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("ID <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("ID in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("ID not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("ID between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ID not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andCusidIsNull() {
			addCriterion("cusID is null");
			return (Criteria) this;
		}

		public Criteria andCusidIsNotNull() {
			addCriterion("cusID is not null");
			return (Criteria) this;
		}

		public Criteria andCusidEqualTo(Integer value) {
			addCriterion("cusID =", value, "cusid");
			return (Criteria) this;
		}

		public Criteria andCusidNotEqualTo(Integer value) {
			addCriterion("cusID <>", value, "cusid");
			return (Criteria) this;
		}

		public Criteria andCusidGreaterThan(Integer value) {
			addCriterion("cusID >", value, "cusid");
			return (Criteria) this;
		}

		public Criteria andCusidGreaterThanOrEqualTo(Integer value) {
			addCriterion("cusID >=", value, "cusid");
			return (Criteria) this;
		}

		public Criteria andCusidLessThan(Integer value) {
			addCriterion("cusID <", value, "cusid");
			return (Criteria) this;
		}

		public Criteria andCusidLessThanOrEqualTo(Integer value) {
			addCriterion("cusID <=", value, "cusid");
			return (Criteria) this;
		}

		public Criteria andCusidIn(List<Integer> values) {
			addCriterion("cusID in", values, "cusid");
			return (Criteria) this;
		}

		public Criteria andCusidNotIn(List<Integer> values) {
			addCriterion("cusID not in", values, "cusid");
			return (Criteria) this;
		}

		public Criteria andCusidBetween(Integer value1, Integer value2) {
			addCriterion("cusID between", value1, value2, "cusid");
			return (Criteria) this;
		}

		public Criteria andCusidNotBetween(Integer value1, Integer value2) {
			addCriterion("cusID not between", value1, value2, "cusid");
			return (Criteria) this;
		}

		public Criteria andCssidIsNull() {
			addCriterion("CssID is null");
			return (Criteria) this;
		}

		public Criteria andCssidIsNotNull() {
			addCriterion("CssID is not null");
			return (Criteria) this;
		}

		public Criteria andCssidEqualTo(Integer value) {
			addCriterion("CssID =", value, "cssid");
			return (Criteria) this;
		}

		public Criteria andCssidNotEqualTo(Integer value) {
			addCriterion("CssID <>", value, "cssid");
			return (Criteria) this;
		}

		public Criteria andCssidGreaterThan(Integer value) {
			addCriterion("CssID >", value, "cssid");
			return (Criteria) this;
		}

		public Criteria andCssidGreaterThanOrEqualTo(Integer value) {
			addCriterion("CssID >=", value, "cssid");
			return (Criteria) this;
		}

		public Criteria andCssidLessThan(Integer value) {
			addCriterion("CssID <", value, "cssid");
			return (Criteria) this;
		}

		public Criteria andCssidLessThanOrEqualTo(Integer value) {
			addCriterion("CssID <=", value, "cssid");
			return (Criteria) this;
		}

		public Criteria andCssidIn(List<Integer> values) {
			addCriterion("CssID in", values, "cssid");
			return (Criteria) this;
		}

		public Criteria andCssidNotIn(List<Integer> values) {
			addCriterion("CssID not in", values, "cssid");
			return (Criteria) this;
		}

		public Criteria andCssidBetween(Integer value1, Integer value2) {
			addCriterion("CssID between", value1, value2, "cssid");
			return (Criteria) this;
		}

		public Criteria andCssidNotBetween(Integer value1, Integer value2) {
			addCriterion("CssID not between", value1, value2, "cssid");
			return (Criteria) this;
		}

		public Criteria andDatetimeIsNull() {
			addCriterion("Datetime is null");
			return (Criteria) this;
		}

		public Criteria andDatetimeIsNotNull() {
			addCriterion("Datetime is not null");
			return (Criteria) this;
		}

		public Criteria andDatetimeEqualTo(Date value) {
			addCriterion("Datetime =", value, "datetime");
			return (Criteria) this;
		}

		public Criteria andDatetimeNotEqualTo(Date value) {
			addCriterion("Datetime <>", value, "datetime");
			return (Criteria) this;
		}

		public Criteria andDatetimeGreaterThan(Date value) {
			addCriterion("Datetime >", value, "datetime");
			return (Criteria) this;
		}

		public Criteria andDatetimeGreaterThanOrEqualTo(Date value) {
			addCriterion("Datetime >=", value, "datetime");
			return (Criteria) this;
		}

		public Criteria andDatetimeLessThan(Date value) {
			addCriterion("Datetime <", value, "datetime");
			return (Criteria) this;
		}

		public Criteria andDatetimeLessThanOrEqualTo(Date value) {
			addCriterion("Datetime <=", value, "datetime");
			return (Criteria) this;
		}

		public Criteria andDatetimeIn(List<Date> values) {
			addCriterion("Datetime in", values, "datetime");
			return (Criteria) this;
		}

		public Criteria andDatetimeNotIn(List<Date> values) {
			addCriterion("Datetime not in", values, "datetime");
			return (Criteria) this;
		}

		public Criteria andDatetimeBetween(Date value1, Date value2) {
			addCriterion("Datetime between", value1, value2, "datetime");
			return (Criteria) this;
		}

		public Criteria andDatetimeNotBetween(Date value1, Date value2) {
			addCriterion("Datetime not between", value1, value2, "datetime");
			return (Criteria) this;
		}

		public Criteria andMmidIsNull() {
			addCriterion("mmID is null");
			return (Criteria) this;
		}

		public Criteria andMmidIsNotNull() {
			addCriterion("mmID is not null");
			return (Criteria) this;
		}

		public Criteria andMmidEqualTo(Integer value) {
			addCriterion("mmID =", value, "mmid");
			return (Criteria) this;
		}

		public Criteria andMmidNotEqualTo(Integer value) {
			addCriterion("mmID <>", value, "mmid");
			return (Criteria) this;
		}

		public Criteria andMmidGreaterThan(Integer value) {
			addCriterion("mmID >", value, "mmid");
			return (Criteria) this;
		}

		public Criteria andMmidGreaterThanOrEqualTo(Integer value) {
			addCriterion("mmID >=", value, "mmid");
			return (Criteria) this;
		}

		public Criteria andMmidLessThan(Integer value) {
			addCriterion("mmID <", value, "mmid");
			return (Criteria) this;
		}

		public Criteria andMmidLessThanOrEqualTo(Integer value) {
			addCriterion("mmID <=", value, "mmid");
			return (Criteria) this;
		}

		public Criteria andMmidIn(List<Integer> values) {
			addCriterion("mmID in", values, "mmid");
			return (Criteria) this;
		}

		public Criteria andMmidNotIn(List<Integer> values) {
			addCriterion("mmID not in", values, "mmid");
			return (Criteria) this;
		}

		public Criteria andMmidBetween(Integer value1, Integer value2) {
			addCriterion("mmID between", value1, value2, "mmid");
			return (Criteria) this;
		}

		public Criteria andMmidNotBetween(Integer value1, Integer value2) {
			addCriterion("mmID not between", value1, value2, "mmid");
			return (Criteria) this;
		}

		public Criteria andOrderidIsNull() {
			addCriterion("OrderID is null");
			return (Criteria) this;
		}

		public Criteria andOrderidIsNotNull() {
			addCriterion("OrderID is not null");
			return (Criteria) this;
		}

		public Criteria andOrderidEqualTo(Integer value) {
			addCriterion("OrderID =", value, "orderid");
			return (Criteria) this;
		}

		public Criteria andOrderidNotEqualTo(Integer value) {
			addCriterion("OrderID <>", value, "orderid");
			return (Criteria) this;
		}

		public Criteria andOrderidGreaterThan(Integer value) {
			addCriterion("OrderID >", value, "orderid");
			return (Criteria) this;
		}

		public Criteria andOrderidGreaterThanOrEqualTo(Integer value) {
			addCriterion("OrderID >=", value, "orderid");
			return (Criteria) this;
		}

		public Criteria andOrderidLessThan(Integer value) {
			addCriterion("OrderID <", value, "orderid");
			return (Criteria) this;
		}

		public Criteria andOrderidLessThanOrEqualTo(Integer value) {
			addCriterion("OrderID <=", value, "orderid");
			return (Criteria) this;
		}

		public Criteria andOrderidIn(List<Integer> values) {
			addCriterion("OrderID in", values, "orderid");
			return (Criteria) this;
		}

		public Criteria andOrderidNotIn(List<Integer> values) {
			addCriterion("OrderID not in", values, "orderid");
			return (Criteria) this;
		}

		public Criteria andOrderidBetween(Integer value1, Integer value2) {
			addCriterion("OrderID between", value1, value2, "orderid");
			return (Criteria) this;
		}

		public Criteria andOrderidNotBetween(Integer value1, Integer value2) {
			addCriterion("OrderID not between", value1, value2, "orderid");
			return (Criteria) this;
		}

		public Criteria andCreatedateIsNull() {
			addCriterion("CreateDate is null");
			return (Criteria) this;
		}

		public Criteria andCreatedateIsNotNull() {
			addCriterion("CreateDate is not null");
			return (Criteria) this;
		}

		public Criteria andCreatedateEqualTo(Date value) {
			addCriterion("CreateDate =", value, "createdate");
			return (Criteria) this;
		}

		public Criteria andCreatedateNotEqualTo(Date value) {
			addCriterion("CreateDate <>", value, "createdate");
			return (Criteria) this;
		}

		public Criteria andCreatedateGreaterThan(Date value) {
			addCriterion("CreateDate >", value, "createdate");
			return (Criteria) this;
		}

		public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
			addCriterion("CreateDate >=", value, "createdate");
			return (Criteria) this;
		}

		public Criteria andCreatedateLessThan(Date value) {
			addCriterion("CreateDate <", value, "createdate");
			return (Criteria) this;
		}

		public Criteria andCreatedateLessThanOrEqualTo(Date value) {
			addCriterion("CreateDate <=", value, "createdate");
			return (Criteria) this;
		}

		public Criteria andCreatedateIn(List<Date> values) {
			addCriterion("CreateDate in", values, "createdate");
			return (Criteria) this;
		}

		public Criteria andCreatedateNotIn(List<Date> values) {
			addCriterion("CreateDate not in", values, "createdate");
			return (Criteria) this;
		}

		public Criteria andCreatedateBetween(Date value1, Date value2) {
			addCriterion("CreateDate between", value1, value2, "createdate");
			return (Criteria) this;
		}

		public Criteria andCreatedateNotBetween(Date value1, Date value2) {
			addCriterion("CreateDate not between", value1, value2, "createdate");
			return (Criteria) this;
		}

		public Criteria andMmagreeIsNull() {
			addCriterion("MmAgree is null");
			return (Criteria) this;
		}

		public Criteria andMmagreeIsNotNull() {
			addCriterion("MmAgree is not null");
			return (Criteria) this;
		}

		public Criteria andMmagreeEqualTo(Boolean value) {
			addCriterion("MmAgree =", value, "mmagree");
			return (Criteria) this;
		}

		public Criteria andMmagreeNotEqualTo(Boolean value) {
			addCriterion("MmAgree <>", value, "mmagree");
			return (Criteria) this;
		}

		public Criteria andMmagreeGreaterThan(Boolean value) {
			addCriterion("MmAgree >", value, "mmagree");
			return (Criteria) this;
		}

		public Criteria andMmagreeGreaterThanOrEqualTo(Boolean value) {
			addCriterion("MmAgree >=", value, "mmagree");
			return (Criteria) this;
		}

		public Criteria andMmagreeLessThan(Boolean value) {
			addCriterion("MmAgree <", value, "mmagree");
			return (Criteria) this;
		}

		public Criteria andMmagreeLessThanOrEqualTo(Boolean value) {
			addCriterion("MmAgree <=", value, "mmagree");
			return (Criteria) this;
		}

		public Criteria andMmagreeIn(List<Boolean> values) {
			addCriterion("MmAgree in", values, "mmagree");
			return (Criteria) this;
		}

		public Criteria andMmagreeNotIn(List<Boolean> values) {
			addCriterion("MmAgree not in", values, "mmagree");
			return (Criteria) this;
		}

		public Criteria andMmagreeBetween(Boolean value1, Boolean value2) {
			addCriterion("MmAgree between", value1, value2, "mmagree");
			return (Criteria) this;
		}

		public Criteria andMmagreeNotBetween(Boolean value1, Boolean value2) {
			addCriterion("MmAgree not between", value1, value2, "mmagree");
			return (Criteria) this;
		}

		public Criteria andCusagreeIsNull() {
			addCriterion("CusAgree is null");
			return (Criteria) this;
		}

		public Criteria andCusagreeIsNotNull() {
			addCriterion("CusAgree is not null");
			return (Criteria) this;
		}

		public Criteria andCusagreeEqualTo(Boolean value) {
			addCriterion("CusAgree =", value, "cusagree");
			return (Criteria) this;
		}

		public Criteria andCusagreeNotEqualTo(Boolean value) {
			addCriterion("CusAgree <>", value, "cusagree");
			return (Criteria) this;
		}

		public Criteria andCusagreeGreaterThan(Boolean value) {
			addCriterion("CusAgree >", value, "cusagree");
			return (Criteria) this;
		}

		public Criteria andCusagreeGreaterThanOrEqualTo(Boolean value) {
			addCriterion("CusAgree >=", value, "cusagree");
			return (Criteria) this;
		}

		public Criteria andCusagreeLessThan(Boolean value) {
			addCriterion("CusAgree <", value, "cusagree");
			return (Criteria) this;
		}

		public Criteria andCusagreeLessThanOrEqualTo(Boolean value) {
			addCriterion("CusAgree <=", value, "cusagree");
			return (Criteria) this;
		}

		public Criteria andCusagreeIn(List<Boolean> values) {
			addCriterion("CusAgree in", values, "cusagree");
			return (Criteria) this;
		}

		public Criteria andCusagreeNotIn(List<Boolean> values) {
			addCriterion("CusAgree not in", values, "cusagree");
			return (Criteria) this;
		}

		public Criteria andCusagreeBetween(Boolean value1, Boolean value2) {
			addCriterion("CusAgree between", value1, value2, "cusagree");
			return (Criteria) this;
		}

		public Criteria andCusagreeNotBetween(Boolean value1, Boolean value2) {
			addCriterion("CusAgree not between", value1, value2, "cusagree");
			return (Criteria) this;
		}

		public Criteria andMaidatestIsNull() {
			addCriterion("MaiDateSt is null");
			return (Criteria) this;
		}

		public Criteria andMaidatestIsNotNull() {
			addCriterion("MaiDateSt is not null");
			return (Criteria) this;
		}

		public Criteria andMaidatestEqualTo(Date value) {
			addCriterion("MaiDateSt =", value, "maidatest");
			return (Criteria) this;
		}

		public Criteria andMaidatestNotEqualTo(Date value) {
			addCriterion("MaiDateSt <>", value, "maidatest");
			return (Criteria) this;
		}

		public Criteria andMaidatestGreaterThan(Date value) {
			addCriterion("MaiDateSt >", value, "maidatest");
			return (Criteria) this;
		}

		public Criteria andMaidatestGreaterThanOrEqualTo(Date value) {
			addCriterion("MaiDateSt >=", value, "maidatest");
			return (Criteria) this;
		}

		public Criteria andMaidatestLessThan(Date value) {
			addCriterion("MaiDateSt <", value, "maidatest");
			return (Criteria) this;
		}

		public Criteria andMaidatestLessThanOrEqualTo(Date value) {
			addCriterion("MaiDateSt <=", value, "maidatest");
			return (Criteria) this;
		}

		public Criteria andMaidatestIn(List<Date> values) {
			addCriterion("MaiDateSt in", values, "maidatest");
			return (Criteria) this;
		}

		public Criteria andMaidatestNotIn(List<Date> values) {
			addCriterion("MaiDateSt not in", values, "maidatest");
			return (Criteria) this;
		}

		public Criteria andMaidatestBetween(Date value1, Date value2) {
			addCriterion("MaiDateSt between", value1, value2, "maidatest");
			return (Criteria) this;
		}

		public Criteria andMaidatestNotBetween(Date value1, Date value2) {
			addCriterion("MaiDateSt not between", value1, value2, "maidatest");
			return (Criteria) this;
		}

		public Criteria andMaidateedIsNull() {
			addCriterion("MaiDateEd is null");
			return (Criteria) this;
		}

		public Criteria andMaidateedIsNotNull() {
			addCriterion("MaiDateEd is not null");
			return (Criteria) this;
		}

		public Criteria andMaidateedEqualTo(Date value) {
			addCriterion("MaiDateEd =", value, "maidateed");
			return (Criteria) this;
		}

		public Criteria andMaidateedNotEqualTo(Date value) {
			addCriterion("MaiDateEd <>", value, "maidateed");
			return (Criteria) this;
		}

		public Criteria andMaidateedGreaterThan(Date value) {
			addCriterion("MaiDateEd >", value, "maidateed");
			return (Criteria) this;
		}

		public Criteria andMaidateedGreaterThanOrEqualTo(Date value) {
			addCriterion("MaiDateEd >=", value, "maidateed");
			return (Criteria) this;
		}

		public Criteria andMaidateedLessThan(Date value) {
			addCriterion("MaiDateEd <", value, "maidateed");
			return (Criteria) this;
		}

		public Criteria andMaidateedLessThanOrEqualTo(Date value) {
			addCriterion("MaiDateEd <=", value, "maidateed");
			return (Criteria) this;
		}

		public Criteria andMaidateedIn(List<Date> values) {
			addCriterion("MaiDateEd in", values, "maidateed");
			return (Criteria) this;
		}

		public Criteria andMaidateedNotIn(List<Date> values) {
			addCriterion("MaiDateEd not in", values, "maidateed");
			return (Criteria) this;
		}

		public Criteria andMaidateedBetween(Date value1, Date value2) {
			addCriterion("MaiDateEd between", value1, value2, "maidateed");
			return (Criteria) this;
		}

		public Criteria andMaidateedNotBetween(Date value1, Date value2) {
			addCriterion("MaiDateEd not between", value1, value2, "maidateed");
			return (Criteria) this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("Status is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("Status is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(String value) {
			addCriterion("Status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(String value) {
			addCriterion("Status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(String value) {
			addCriterion("Status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(String value) {
			addCriterion("Status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(String value) {
			addCriterion("Status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(String value) {
			addCriterion("Status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLike(String value) {
			addCriterion("Status like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotLike(String value) {
			addCriterion("Status not like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<String> values) {
			addCriterion("Status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<String> values) {
			addCriterion("Status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(String value1, String value2) {
			addCriterion("Status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(String value1, String value2) {
			addCriterion("Status not between", value1, value2, "status");
			return (Criteria) this;
		}

		/*****************/
		public Criteria andRecord_CusidEqualTo(Integer value) {
			addCriterion("e.CusID =", value, "cusid");
			return (Criteria) this;
		}

	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}