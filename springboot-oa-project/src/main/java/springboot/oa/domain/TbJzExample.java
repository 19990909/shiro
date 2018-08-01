package springboot.oa.domain;

import java.util.ArrayList;
import java.util.List;

public class TbJzExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbJzExample() {
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

        public Criteria andJzbmIsNull() {
            addCriterion("jzbm is null");
            return (Criteria) this;
        }

        public Criteria andJzbmIsNotNull() {
            addCriterion("jzbm is not null");
            return (Criteria) this;
        }

        public Criteria andJzbmEqualTo(String value) {
            addCriterion("jzbm =", value, "jzbm");
            return (Criteria) this;
        }

        public Criteria andJzbmNotEqualTo(String value) {
            addCriterion("jzbm <>", value, "jzbm");
            return (Criteria) this;
        }

        public Criteria andJzbmGreaterThan(String value) {
            addCriterion("jzbm >", value, "jzbm");
            return (Criteria) this;
        }

        public Criteria andJzbmGreaterThanOrEqualTo(String value) {
            addCriterion("jzbm >=", value, "jzbm");
            return (Criteria) this;
        }

        public Criteria andJzbmLessThan(String value) {
            addCriterion("jzbm <", value, "jzbm");
            return (Criteria) this;
        }

        public Criteria andJzbmLessThanOrEqualTo(String value) {
            addCriterion("jzbm <=", value, "jzbm");
            return (Criteria) this;
        }

        public Criteria andJzbmLike(String value) {
            addCriterion("jzbm like", value, "jzbm");
            return (Criteria) this;
        }

        public Criteria andJzbmNotLike(String value) {
            addCriterion("jzbm not like", value, "jzbm");
            return (Criteria) this;
        }

        public Criteria andJzbmIn(List<String> values) {
            addCriterion("jzbm in", values, "jzbm");
            return (Criteria) this;
        }

        public Criteria andJzbmNotIn(List<String> values) {
            addCriterion("jzbm not in", values, "jzbm");
            return (Criteria) this;
        }

        public Criteria andJzbmBetween(String value1, String value2) {
            addCriterion("jzbm between", value1, value2, "jzbm");
            return (Criteria) this;
        }

        public Criteria andJzbmNotBetween(String value1, String value2) {
            addCriterion("jzbm not between", value1, value2, "jzbm");
            return (Criteria) this;
        }

        public Criteria andJzlxIsNull() {
            addCriterion("jzlx is null");
            return (Criteria) this;
        }

        public Criteria andJzlxIsNotNull() {
            addCriterion("jzlx is not null");
            return (Criteria) this;
        }

        public Criteria andJzlxEqualTo(String value) {
            addCriterion("jzlx =", value, "jzlx");
            return (Criteria) this;
        }

        public Criteria andJzlxNotEqualTo(String value) {
            addCriterion("jzlx <>", value, "jzlx");
            return (Criteria) this;
        }

        public Criteria andJzlxGreaterThan(String value) {
            addCriterion("jzlx >", value, "jzlx");
            return (Criteria) this;
        }

        public Criteria andJzlxGreaterThanOrEqualTo(String value) {
            addCriterion("jzlx >=", value, "jzlx");
            return (Criteria) this;
        }

        public Criteria andJzlxLessThan(String value) {
            addCriterion("jzlx <", value, "jzlx");
            return (Criteria) this;
        }

        public Criteria andJzlxLessThanOrEqualTo(String value) {
            addCriterion("jzlx <=", value, "jzlx");
            return (Criteria) this;
        }

        public Criteria andJzlxIn(List<Integer> values) {
            addCriterion("jzlx in", values, "jzlx");
            return (Criteria) this;
        }

        public Criteria andJzlxNotIn(List<Integer> values) {
            addCriterion("jzlx not in", values, "jzlx");
            return (Criteria) this;
        }

        public Criteria andJzlxBetween(Integer value1, Integer value2) {
            addCriterion("jzlx between", value1, value2, "jzlx");
            return (Criteria) this;
        }

        public Criteria andJzlxNotBetween(Integer value1, Integer value2) {
            addCriterion("jzlx not between", value1, value2, "jzlx");
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