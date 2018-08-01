package springboot.oa.domain;

import java.util.ArrayList;
import java.util.List;

public class TbDkxxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String fields;

    public TbDkxxExample() {
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

    public void setFields(String fields) {
        this.fields=fields;
    }

    public String getFields() {
        return fields;
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

        public Criteria andDkbmIsNull() {
            addCriterion("dkbm is null");
            return (Criteria) this;
        }

        public Criteria andDkbmIsNotNull() {
            addCriterion("dkbm is not null");
            return (Criteria) this;
        }

        public Criteria andDkbmEqualTo(String value) {
            addCriterion("dkbm =", value, "dkbm");
            return (Criteria) this;
        }

        public Criteria andDkbmNotEqualTo(String value) {
            addCriterion("dkbm <>", value, "dkbm");
            return (Criteria) this;
        }

        public Criteria andDkbmGreaterThan(String value) {
            addCriterion("dkbm >", value, "dkbm");
            return (Criteria) this;
        }

        public Criteria andDkbmGreaterThanOrEqualTo(String value) {
            addCriterion("dkbm >=", value, "dkbm");
            return (Criteria) this;
        }

        public Criteria andDkbmLessThan(String value) {
            addCriterion("dkbm <", value, "dkbm");
            return (Criteria) this;
        }

        public Criteria andDkbmLessThanOrEqualTo(String value) {
            addCriterion("dkbm <=", value, "dkbm");
            return (Criteria) this;
        }

        public Criteria andDkbmLike(String value) {
            addCriterion("dkbm like", value, "dkbm");
            return (Criteria) this;
        }

        public Criteria andDkbmNotLike(String value) {
            addCriterion("dkbm not like", value, "dkbm");
            return (Criteria) this;
        }

        public Criteria andDkbmIn(List<String> values) {
            addCriterion("dkbm in", values, "dkbm");
            return (Criteria) this;
        }

        public Criteria andDkbmNotIn(List<String> values) {
            addCriterion("dkbm not in", values, "dkbm");
            return (Criteria) this;
        }

        public Criteria andDkbmBetween(String value1, String value2) {
            addCriterion("dkbm between", value1, value2, "dkbm");
            return (Criteria) this;
        }

        public Criteria andDkbmNotBetween(String value1, String value2) {
            addCriterion("dkbm not between", value1, value2, "dkbm");
            return (Criteria) this;
        }

        public Criteria andDzIsNull() {
            addCriterion("dz is null");
            return (Criteria) this;
        }

        public Criteria andDzIsNotNull() {
            addCriterion("dz is not null");
            return (Criteria) this;
        }

        public Criteria andDzEqualTo(String value) {
            addCriterion("dz =", value, "dz");
            return (Criteria) this;
        }

        public Criteria andDzNotEqualTo(String value) {
            addCriterion("dz <>", value, "dz");
            return (Criteria) this;
        }

        public Criteria andDzGreaterThan(String value) {
            addCriterion("dz >", value, "dz");
            return (Criteria) this;
        }

        public Criteria andDzGreaterThanOrEqualTo(String value) {
            addCriterion("dz >=", value, "dz");
            return (Criteria) this;
        }

        public Criteria andDzLessThan(String value) {
            addCriterion("dz <", value, "dz");
            return (Criteria) this;
        }

        public Criteria andDzLessThanOrEqualTo(String value) {
            addCriterion("dz <=", value, "dz");
            return (Criteria) this;
        }

        public Criteria andDzLike(String value) {
            addCriterion("dz like", value, "dz");
            return (Criteria) this;
        }

        public Criteria andDzNotLike(String value) {
            addCriterion("dz not like", value, "dz");
            return (Criteria) this;
        }

        public Criteria andDzIn(List<String> values) {
            addCriterion("dz in", values, "dz");
            return (Criteria) this;
        }

        public Criteria andDzNotIn(List<String> values) {
            addCriterion("dz not in", values, "dz");
            return (Criteria) this;
        }

        public Criteria andDzBetween(String value1, String value2) {
            addCriterion("dz between", value1, value2, "dz");
            return (Criteria) this;
        }

        public Criteria andDzNotBetween(String value1, String value2) {
            addCriterion("dz not between", value1, value2, "dz");
            return (Criteria) this;
        }

        public Criteria andXzIsNull() {
            addCriterion("xz is null");
            return (Criteria) this;
        }

        public Criteria andXzIsNotNull() {
            addCriterion("xz is not null");
            return (Criteria) this;
        }

        public Criteria andXzEqualTo(String value) {
            addCriterion("xz =", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzNotEqualTo(String value) {
            addCriterion("xz <>", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzGreaterThan(String value) {
            addCriterion("xz >", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzGreaterThanOrEqualTo(String value) {
            addCriterion("xz >=", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzLessThan(String value) {
            addCriterion("xz <", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzLessThanOrEqualTo(String value) {
            addCriterion("xz <=", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzLike(String value) {
            addCriterion("xz like", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzNotLike(String value) {
            addCriterion("xz not like", value, "xz");
            return (Criteria) this;
        }

        public Criteria andXzIn(List<String> values) {
            addCriterion("xz in", values, "xz");
            return (Criteria) this;
        }

        public Criteria andXzNotIn(List<String> values) {
            addCriterion("xz not in", values, "xz");
            return (Criteria) this;
        }

        public Criteria andXzBetween(String value1, String value2) {
            addCriterion("xz between", value1, value2, "xz");
            return (Criteria) this;
        }

        public Criteria andXzNotBetween(String value1, String value2) {
            addCriterion("xz not between", value1, value2, "xz");
            return (Criteria) this;
        }

        public Criteria andNzIsNull() {
            addCriterion("nz is null");
            return (Criteria) this;
        }

        public Criteria andNzIsNotNull() {
            addCriterion("nz is not null");
            return (Criteria) this;
        }

        public Criteria andNzEqualTo(String value) {
            addCriterion("nz =", value, "nz");
            return (Criteria) this;
        }

        public Criteria andNzNotEqualTo(String value) {
            addCriterion("nz <>", value, "nz");
            return (Criteria) this;
        }

        public Criteria andNzGreaterThan(String value) {
            addCriterion("nz >", value, "nz");
            return (Criteria) this;
        }

        public Criteria andNzGreaterThanOrEqualTo(String value) {
            addCriterion("nz >=", value, "nz");
            return (Criteria) this;
        }

        public Criteria andNzLessThan(String value) {
            addCriterion("nz <", value, "nz");
            return (Criteria) this;
        }

        public Criteria andNzLessThanOrEqualTo(String value) {
            addCriterion("nz <=", value, "nz");
            return (Criteria) this;
        }

        public Criteria andNzLike(String value) {
            addCriterion("nz like", value, "nz");
            return (Criteria) this;
        }

        public Criteria andNzNotLike(String value) {
            addCriterion("nz not like", value, "nz");
            return (Criteria) this;
        }

        public Criteria andNzIn(List<String> values) {
            addCriterion("nz in", values, "nz");
            return (Criteria) this;
        }

        public Criteria andNzNotIn(List<String> values) {
            addCriterion("nz not in", values, "nz");
            return (Criteria) this;
        }

        public Criteria andNzBetween(String value1, String value2) {
            addCriterion("nz between", value1, value2, "nz");
            return (Criteria) this;
        }

        public Criteria andNzNotBetween(String value1, String value2) {
            addCriterion("nz not between", value1, value2, "nz");
            return (Criteria) this;
        }

        public Criteria andBzIsNull() {
            addCriterion("bz is null");
            return (Criteria) this;
        }

        public Criteria andBzIsNotNull() {
            addCriterion("bz is not null");
            return (Criteria) this;
        }

        public Criteria andBzEqualTo(String value) {
            addCriterion("bz =", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotEqualTo(String value) {
            addCriterion("bz <>", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThan(String value) {
            addCriterion("bz >", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThanOrEqualTo(String value) {
            addCriterion("bz >=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThan(String value) {
            addCriterion("bz <", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThanOrEqualTo(String value) {
            addCriterion("bz <=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLike(String value) {
            addCriterion("bz like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotLike(String value) {
            addCriterion("bz not like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzIn(List<String> values) {
            addCriterion("bz in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotIn(List<String> values) {
            addCriterion("bz not in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzBetween(String value1, String value2) {
            addCriterion("bz between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotBetween(String value1, String value2) {
            addCriterion("bz not between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(String value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(String value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(String value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(String value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(String value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(String value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<String> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<String> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(String value1, String value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(String value1, String value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andQzbmIsNull() {
            addCriterion("qzbm is null");
            return (Criteria) this;
        }

        public Criteria andQzbmIsNotNull() {
            addCriterion("qzbm is not null");
            return (Criteria) this;
        }

        public Criteria andQzbmEqualTo(Integer value) {
            addCriterion("qzbm =", value, "qzbm");
            return (Criteria) this;
        }

        public Criteria andQzbmNotEqualTo(Integer value) {
            addCriterion("qzbm <>", value, "qzbm");
            return (Criteria) this;
        }

        public Criteria andQzbmGreaterThan(Integer value) {
            addCriterion("qzbm >", value, "qzbm");
            return (Criteria) this;
        }

        public Criteria andQzbmGreaterThanOrEqualTo(Integer value) {
            addCriterion("qzbm >=", value, "qzbm");
            return (Criteria) this;
        }

        public Criteria andQzbmLessThan(Integer value) {
            addCriterion("qzbm <", value, "qzbm");
            return (Criteria) this;
        }

        public Criteria andQzbmLessThanOrEqualTo(Integer value) {
            addCriterion("qzbm <=", value, "qzbm");
            return (Criteria) this;
        }

        public Criteria andQzbmIn(List<Integer> values) {
            addCriterion("qzbm in", values, "qzbm");
            return (Criteria) this;
        }

        public Criteria andQzbmNotIn(List<Integer> values) {
            addCriterion("qzbm not in", values, "qzbm");
            return (Criteria) this;
        }

        public Criteria andQzbmBetween(Integer value1, Integer value2) {
            addCriterion("qzbm between", value1, value2, "qzbm");
            return (Criteria) this;
        }

        public Criteria andQzbmNotBetween(Integer value1, Integer value2) {
            addCriterion("qzbm not between", value1, value2, "qzbm");
            return (Criteria) this;
        }

        public Criteria andXzdwNameIsNull() {
            addCriterion("xzdw_name is null");
            return (Criteria) this;
        }

        public Criteria andXzdwNameIsNotNull() {
            addCriterion("xzdw_name is not null");
            return (Criteria) this;
        }

        public Criteria andXzdwNameEqualTo(String value) {
            addCriterion("xzdw_name =", value, "xzdwName");
            return (Criteria) this;
        }

        public Criteria andXzdwNameNotEqualTo(String value) {
            addCriterion("xzdw_name <>", value, "xzdwName");
            return (Criteria) this;
        }

        public Criteria andXzdwNameGreaterThan(String value) {
            addCriterion("xzdw_name >", value, "xzdwName");
            return (Criteria) this;
        }

        public Criteria andXzdwNameGreaterThanOrEqualTo(String value) {
            addCriterion("xzdw_name >=", value, "xzdwName");
            return (Criteria) this;
        }

        public Criteria andXzdwNameLessThan(String value) {
            addCriterion("xzdw_name <", value, "xzdwName");
            return (Criteria) this;
        }

        public Criteria andXzdwNameLessThanOrEqualTo(String value) {
            addCriterion("xzdw_name <=", value, "xzdwName");
            return (Criteria) this;
        }

        public Criteria andXzdwNameLike(String value) {
            addCriterion("xzdw_name like", value, "xzdwName");
            return (Criteria) this;
        }

        public Criteria andXzdwNameNotLike(String value) {
            addCriterion("xzdw_name not like", value, "xzdwName");
            return (Criteria) this;
        }

        public Criteria andXzdwNameIn(List<String> values) {
            addCriterion("xzdw_name in", values, "xzdwName");
            return (Criteria) this;
        }

        public Criteria andXzdwNameNotIn(List<String> values) {
            addCriterion("xzdw_name not in", values, "xzdwName");
            return (Criteria) this;
        }

        public Criteria andXzdwNameBetween(String value1, String value2) {
            addCriterion("xzdw_name between", value1, value2, "xzdwName");
            return (Criteria) this;
        }

        public Criteria andXzdwNameNotBetween(String value1, String value2) {
            addCriterion("xzdw_name not between", value1, value2, "xzdwName");
            return (Criteria) this;
        }

        public Criteria andXzdwIdIsNull() {
            addCriterion("xzdw_id is null");
            return (Criteria) this;
        }

        public Criteria andXzdwIdIsNotNull() {
            addCriterion("xzdw_id is not null");
            return (Criteria) this;
        }

        public Criteria andXzdwIdEqualTo(String value) {
            addCriterion("xzdw_id =", value, "xzdwId");
            return (Criteria) this;
        }

        public Criteria andXzdwIdNotEqualTo(String value) {
            addCriterion("xzdw_id <>", value, "xzdwId");
            return (Criteria) this;
        }

        public Criteria andXzdwIdGreaterThan(String value) {
            addCriterion("xzdw_id >", value, "xzdwId");
            return (Criteria) this;
        }

        public Criteria andXzdwIdGreaterThanOrEqualTo(String value) {
            addCriterion("xzdw_id >=", value, "xzdwId");
            return (Criteria) this;
        }

        public Criteria andXzdwIdLessThan(String value) {
            addCriterion("xzdw_id <", value, "xzdwId");
            return (Criteria) this;
        }

        public Criteria andXzdwIdLessThanOrEqualTo(String value) {
            addCriterion("xzdw_id <=", value, "xzdwId");
            return (Criteria) this;
        }

        public Criteria andXzdwIdLike(String value) {
            addCriterion("xzdw_id like", value, "xzdwId");
            return (Criteria) this;
        }

        public Criteria andXzdwIdNotLike(String value) {
            addCriterion("xzdw_id not like", value, "xzdwId");
            return (Criteria) this;
        }

        public Criteria andXzdwIdIn(List<String> values) {
            addCriterion("xzdw_id in", values, "xzdwId");
            return (Criteria) this;
        }

        public Criteria andXzdwIdNotIn(List<String> values) {
            addCriterion("xzdw_id not in", values, "xzdwId");
            return (Criteria) this;
        }

        public Criteria andXzdwIdBetween(String value1, String value2) {
            addCriterion("xzdw_id between", value1, value2, "xzdwId");
            return (Criteria) this;
        }

        public Criteria andXzdwIdNotBetween(String value1, String value2) {
            addCriterion("xzdw_id not between", value1, value2, "xzdwId");
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