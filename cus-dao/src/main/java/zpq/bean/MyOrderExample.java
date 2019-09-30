package zpq.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyOrderExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public MyOrderExample() {
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
			addCriterion("Id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("Id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("Id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("Id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("Id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("Id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("Id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("Id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("Id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("Id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("Id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("Id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andProidIsNull() {
			addCriterion("ProID is null");
			return (Criteria) this;
		}

		public Criteria andProidIsNotNull() {
			addCriterion("ProID is not null");
			return (Criteria) this;
		}

		public Criteria andProidEqualTo(Integer value) {
			addCriterion("ProID =", value, "proid");
			return (Criteria) this;
		}

		public Criteria andProidNotEqualTo(Integer value) {
			addCriterion("ProID <>", value, "proid");
			return (Criteria) this;
		}

		public Criteria andProidGreaterThan(Integer value) {
			addCriterion("ProID >", value, "proid");
			return (Criteria) this;
		}

		public Criteria andProidGreaterThanOrEqualTo(Integer value) {
			addCriterion("ProID >=", value, "proid");
			return (Criteria) this;
		}

		public Criteria andProidLessThan(Integer value) {
			addCriterion("ProID <", value, "proid");
			return (Criteria) this;
		}

		public Criteria andProidLessThanOrEqualTo(Integer value) {
			addCriterion("ProID <=", value, "proid");
			return (Criteria) this;
		}

		public Criteria andProidIn(List<Integer> values) {
			addCriterion("ProID in", values, "proid");
			return (Criteria) this;
		}

		public Criteria andProidNotIn(List<Integer> values) {
			addCriterion("ProID not in", values, "proid");
			return (Criteria) this;
		}

		public Criteria andProidBetween(Integer value1, Integer value2) {
			addCriterion("ProID between", value1, value2, "proid");
			return (Criteria) this;
		}

		public Criteria andProidNotBetween(Integer value1, Integer value2) {
			addCriterion("ProID not between", value1, value2, "proid");
			return (Criteria) this;
		}

		public Criteria andCusidIsNull() {
			addCriterion("CusID is null");
			return (Criteria) this;
		}

		public Criteria andCusidIsNotNull() {
			addCriterion("CusID is not null");
			return (Criteria) this;
		}

		public Criteria andCusidEqualTo(Integer value) {
			addCriterion("CusID =", value, "cusid");
			return (Criteria) this;
		}

		public Criteria andCusidNotEqualTo(Integer value) {
			addCriterion("CusID <>", value, "cusid");
			return (Criteria) this;
		}

		public Criteria andCusidGreaterThan(Integer value) {
			addCriterion("CusID >", value, "cusid");
			return (Criteria) this;
		}

		public Criteria andCusidGreaterThanOrEqualTo(Integer value) {
			addCriterion("CusID >=", value, "cusid");
			return (Criteria) this;
		}

		public Criteria andCusidLessThan(Integer value) {
			addCriterion("CusID <", value, "cusid");
			return (Criteria) this;
		}

		public Criteria andCusidLessThanOrEqualTo(Integer value) {
			addCriterion("CusID <=", value, "cusid");
			return (Criteria) this;
		}

		public Criteria andCusidIn(List<Integer> values) {
			addCriterion("CusID in", values, "cusid");
			return (Criteria) this;
		}

		public Criteria andCusidNotIn(List<Integer> values) {
			addCriterion("CusID not in", values, "cusid");
			return (Criteria) this;
		}

		public Criteria andCusidBetween(Integer value1, Integer value2) {
			addCriterion("CusID between", value1, value2, "cusid");
			return (Criteria) this;
		}

		public Criteria andCusidNotBetween(Integer value1, Integer value2) {
			addCriterion("CusID not between", value1, value2, "cusid");
			return (Criteria) this;
		}

		public Criteria andAmountIsNull() {
			addCriterion("Amount is null");
			return (Criteria) this;
		}

		public Criteria andAmountIsNotNull() {
			addCriterion("Amount is not null");
			return (Criteria) this;
		}

		public Criteria andAmountEqualTo(Integer value) {
			addCriterion("Amount =", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountNotEqualTo(Integer value) {
			addCriterion("Amount <>", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountGreaterThan(Integer value) {
			addCriterion("Amount >", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountGreaterThanOrEqualTo(Integer value) {
			addCriterion("Amount >=", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountLessThan(Integer value) {
			addCriterion("Amount <", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountLessThanOrEqualTo(Integer value) {
			addCriterion("Amount <=", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountIn(List<Integer> values) {
			addCriterion("Amount in", values, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountNotIn(List<Integer> values) {
			addCriterion("Amount not in", values, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountBetween(Integer value1, Integer value2) {
			addCriterion("Amount between", value1, value2, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountNotBetween(Integer value1, Integer value2) {
			addCriterion("Amount not between", value1, value2, "amount");
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

		public Criteria andIsdeletedIsNull() {
			addCriterion("isDeleted is null");
			return (Criteria) this;
		}

		public Criteria andIsdeletedIsNotNull() {
			addCriterion("isDeleted is not null");
			return (Criteria) this;
		}

		public Criteria andIsdeletedEqualTo(Boolean value) {
			addCriterion("isDeleted =", value, "isdeleted");
			return (Criteria) this;
		}

		public Criteria andIsdeletedNotEqualTo(Boolean value) {
			addCriterion("isDeleted <>", value, "isdeleted");
			return (Criteria) this;
		}

		public Criteria andIsdeletedGreaterThan(Boolean value) {
			addCriterion("isDeleted >", value, "isdeleted");
			return (Criteria) this;
		}

		public Criteria andIsdeletedGreaterThanOrEqualTo(Boolean value) {
			addCriterion("isDeleted >=", value, "isdeleted");
			return (Criteria) this;
		}

		public Criteria andIsdeletedLessThan(Boolean value) {
			addCriterion("isDeleted <", value, "isdeleted");
			return (Criteria) this;
		}

		public Criteria andIsdeletedLessThanOrEqualTo(Boolean value) {
			addCriterion("isDeleted <=", value, "isdeleted");
			return (Criteria) this;
		}

		public Criteria andIsdeletedIn(List<Boolean> values) {
			addCriterion("isDeleted in", values, "isdeleted");
			return (Criteria) this;
		}

		public Criteria andIsdeletedNotIn(List<Boolean> values) {
			addCriterion("isDeleted not in", values, "isdeleted");
			return (Criteria) this;
		}

		public Criteria andIsdeletedBetween(Boolean value1, Boolean value2) {
			addCriterion("isDeleted between", value1, value2, "isdeleted");
			return (Criteria) this;
		}

		public Criteria andIsdeletedNotBetween(Boolean value1, Boolean value2) {
			addCriterion("isDeleted not between", value1, value2, "isdeleted");
			return (Criteria) this;
		}

		/******** 自定义 *******/
		public Criteria andProdNameLike(String value) {
			addCriterion("prodname like", value, "product.prodname");
			return (Criteria) this;
		}

		public Criteria andCssNicknameLike(String value) {
			addCriterion("b.nickname like", value, "Css.nickname");
			return (Criteria) this;
		}

		public Criteria andCustNicknameLike(String value) {
			addCriterion("a.nickname like", value, "Customer.nickname");
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