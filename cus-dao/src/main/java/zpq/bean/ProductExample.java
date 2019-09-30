package zpq.bean;

import java.util.ArrayList;
import java.util.List;

public class ProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProdnameIsNull() {
            addCriterion("Prodname is null");
            return (Criteria) this;
        }

        public Criteria andProdnameIsNotNull() {
            addCriterion("Prodname is not null");
            return (Criteria) this;
        }

        public Criteria andProdnameEqualTo(String value) {
            addCriterion("Prodname =", value, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameNotEqualTo(String value) {
            addCriterion("Prodname <>", value, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameGreaterThan(String value) {
            addCriterion("Prodname >", value, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameGreaterThanOrEqualTo(String value) {
            addCriterion("Prodname >=", value, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameLessThan(String value) {
            addCriterion("Prodname <", value, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameLessThanOrEqualTo(String value) {
            addCriterion("Prodname <=", value, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameLike(String value) {
            addCriterion("Prodname like", value, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameNotLike(String value) {
            addCriterion("Prodname not like", value, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameIn(List<String> values) {
            addCriterion("Prodname in", values, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameNotIn(List<String> values) {
            addCriterion("Prodname not in", values, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameBetween(String value1, String value2) {
            addCriterion("Prodname between", value1, value2, "prodname");
            return (Criteria) this;
        }

        public Criteria andProdnameNotBetween(String value1, String value2) {
            addCriterion("Prodname not between", value1, value2, "prodname");
            return (Criteria) this;
        }

        public Criteria andPara1IsNull() {
            addCriterion("Para1 is null");
            return (Criteria) this;
        }

        public Criteria andPara1IsNotNull() {
            addCriterion("Para1 is not null");
            return (Criteria) this;
        }

        public Criteria andPara1EqualTo(String value) {
            addCriterion("Para1 =", value, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1NotEqualTo(String value) {
            addCriterion("Para1 <>", value, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1GreaterThan(String value) {
            addCriterion("Para1 >", value, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1GreaterThanOrEqualTo(String value) {
            addCriterion("Para1 >=", value, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1LessThan(String value) {
            addCriterion("Para1 <", value, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1LessThanOrEqualTo(String value) {
            addCriterion("Para1 <=", value, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1Like(String value) {
            addCriterion("Para1 like", value, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1NotLike(String value) {
            addCriterion("Para1 not like", value, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1In(List<String> values) {
            addCriterion("Para1 in", values, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1NotIn(List<String> values) {
            addCriterion("Para1 not in", values, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1Between(String value1, String value2) {
            addCriterion("Para1 between", value1, value2, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1NotBetween(String value1, String value2) {
            addCriterion("Para1 not between", value1, value2, "para1");
            return (Criteria) this;
        }

        public Criteria andPara2IsNull() {
            addCriterion("Para2 is null");
            return (Criteria) this;
        }

        public Criteria andPara2IsNotNull() {
            addCriterion("Para2 is not null");
            return (Criteria) this;
        }

        public Criteria andPara2EqualTo(String value) {
            addCriterion("Para2 =", value, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2NotEqualTo(String value) {
            addCriterion("Para2 <>", value, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2GreaterThan(String value) {
            addCriterion("Para2 >", value, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2GreaterThanOrEqualTo(String value) {
            addCriterion("Para2 >=", value, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2LessThan(String value) {
            addCriterion("Para2 <", value, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2LessThanOrEqualTo(String value) {
            addCriterion("Para2 <=", value, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2Like(String value) {
            addCriterion("Para2 like", value, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2NotLike(String value) {
            addCriterion("Para2 not like", value, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2In(List<String> values) {
            addCriterion("Para2 in", values, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2NotIn(List<String> values) {
            addCriterion("Para2 not in", values, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2Between(String value1, String value2) {
            addCriterion("Para2 between", value1, value2, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2NotBetween(String value1, String value2) {
            addCriterion("Para2 not between", value1, value2, "para2");
            return (Criteria) this;
        }

        public Criteria andPara3IsNull() {
            addCriterion("Para3 is null");
            return (Criteria) this;
        }

        public Criteria andPara3IsNotNull() {
            addCriterion("Para3 is not null");
            return (Criteria) this;
        }

        public Criteria andPara3EqualTo(String value) {
            addCriterion("Para3 =", value, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3NotEqualTo(String value) {
            addCriterion("Para3 <>", value, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3GreaterThan(String value) {
            addCriterion("Para3 >", value, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3GreaterThanOrEqualTo(String value) {
            addCriterion("Para3 >=", value, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3LessThan(String value) {
            addCriterion("Para3 <", value, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3LessThanOrEqualTo(String value) {
            addCriterion("Para3 <=", value, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3Like(String value) {
            addCriterion("Para3 like", value, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3NotLike(String value) {
            addCriterion("Para3 not like", value, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3In(List<String> values) {
            addCriterion("Para3 in", values, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3NotIn(List<String> values) {
            addCriterion("Para3 not in", values, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3Between(String value1, String value2) {
            addCriterion("Para3 between", value1, value2, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3NotBetween(String value1, String value2) {
            addCriterion("Para3 not between", value1, value2, "para3");
            return (Criteria) this;
        }

        public Criteria andPara4IsNull() {
            addCriterion("Para4 is null");
            return (Criteria) this;
        }

        public Criteria andPara4IsNotNull() {
            addCriterion("Para4 is not null");
            return (Criteria) this;
        }

        public Criteria andPara4EqualTo(String value) {
            addCriterion("Para4 =", value, "para4");
            return (Criteria) this;
        }

        public Criteria andPara4NotEqualTo(String value) {
            addCriterion("Para4 <>", value, "para4");
            return (Criteria) this;
        }

        public Criteria andPara4GreaterThan(String value) {
            addCriterion("Para4 >", value, "para4");
            return (Criteria) this;
        }

        public Criteria andPara4GreaterThanOrEqualTo(String value) {
            addCriterion("Para4 >=", value, "para4");
            return (Criteria) this;
        }

        public Criteria andPara4LessThan(String value) {
            addCriterion("Para4 <", value, "para4");
            return (Criteria) this;
        }

        public Criteria andPara4LessThanOrEqualTo(String value) {
            addCriterion("Para4 <=", value, "para4");
            return (Criteria) this;
        }

        public Criteria andPara4Like(String value) {
            addCriterion("Para4 like", value, "para4");
            return (Criteria) this;
        }

        public Criteria andPara4NotLike(String value) {
            addCriterion("Para4 not like", value, "para4");
            return (Criteria) this;
        }

        public Criteria andPara4In(List<String> values) {
            addCriterion("Para4 in", values, "para4");
            return (Criteria) this;
        }

        public Criteria andPara4NotIn(List<String> values) {
            addCriterion("Para4 not in", values, "para4");
            return (Criteria) this;
        }

        public Criteria andPara4Between(String value1, String value2) {
            addCriterion("Para4 between", value1, value2, "para4");
            return (Criteria) this;
        }

        public Criteria andPara4NotBetween(String value1, String value2) {
            addCriterion("Para4 not between", value1, value2, "para4");
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