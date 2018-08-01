package springboot.oa.domain.dict;

import java.util.ArrayList;
import java.util.List;

public class SysDictExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String fields;

    public SysDictExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDictTypeIsNull() {
            addCriterion("DICT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andDictTypeIsNotNull() {
            addCriterion("DICT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDictTypeEqualTo(String value) {
            addCriterion("DICT_TYPE =", value, "dictType");
            return (Criteria) this;
        }

        public Criteria andDictTypeNotEqualTo(String value) {
            addCriterion("DICT_TYPE <>", value, "dictType");
            return (Criteria) this;
        }

        public Criteria andDictTypeGreaterThan(String value) {
            addCriterion("DICT_TYPE >", value, "dictType");
            return (Criteria) this;
        }

        public Criteria andDictTypeGreaterThanOrEqualTo(String value) {
            addCriterion("DICT_TYPE >=", value, "dictType");
            return (Criteria) this;
        }

        public Criteria andDictTypeLessThan(String value) {
            addCriterion("DICT_TYPE <", value, "dictType");
            return (Criteria) this;
        }

        public Criteria andDictTypeLessThanOrEqualTo(String value) {
            addCriterion("DICT_TYPE <=", value, "dictType");
            return (Criteria) this;
        }

        public Criteria andDictTypeLike(String value) {
            addCriterion("DICT_TYPE like", value, "dictType");
            return (Criteria) this;
        }

        public Criteria andDictTypeNotLike(String value) {
            addCriterion("DICT_TYPE not like", value, "dictType");
            return (Criteria) this;
        }

        public Criteria andDictTypeIn(List<String> values) {
            addCriterion("DICT_TYPE in", values, "dictType");
            return (Criteria) this;
        }

        public Criteria andDictTypeNotIn(List<String> values) {
            addCriterion("DICT_TYPE not in", values, "dictType");
            return (Criteria) this;
        }

        public Criteria andDictTypeBetween(String value1, String value2) {
            addCriterion("DICT_TYPE between", value1, value2, "dictType");
            return (Criteria) this;
        }

        public Criteria andDictTypeNotBetween(String value1, String value2) {
            addCriterion("DICT_TYPE not between", value1, value2, "dictType");
            return (Criteria) this;
        }

        public Criteria andDictCodeIsNull() {
            addCriterion("DICT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andDictCodeIsNotNull() {
            addCriterion("DICT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andDictCodeEqualTo(String value) {
            addCriterion("DICT_CODE =", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeNotEqualTo(String value) {
            addCriterion("DICT_CODE <>", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeGreaterThan(String value) {
            addCriterion("DICT_CODE >", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeGreaterThanOrEqualTo(String value) {
            addCriterion("DICT_CODE >=", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeLessThan(String value) {
            addCriterion("DICT_CODE <", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeLessThanOrEqualTo(String value) {
            addCriterion("DICT_CODE <=", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeLike(String value) {
            addCriterion("DICT_CODE like", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeNotLike(String value) {
            addCriterion("DICT_CODE not like", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeIn(List<String> values) {
            addCriterion("DICT_CODE in", values, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeNotIn(List<String> values) {
            addCriterion("DICT_CODE not in", values, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeBetween(String value1, String value2) {
            addCriterion("DICT_CODE between", value1, value2, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeNotBetween(String value1, String value2) {
            addCriterion("DICT_CODE not between", value1, value2, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictValueIsNull() {
            addCriterion("DICT_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andDictValueIsNotNull() {
            addCriterion("DICT_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andDictValueEqualTo(String value) {
            addCriterion("DICT_VALUE =", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueNotEqualTo(String value) {
            addCriterion("DICT_VALUE <>", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueGreaterThan(String value) {
            addCriterion("DICT_VALUE >", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueGreaterThanOrEqualTo(String value) {
            addCriterion("DICT_VALUE >=", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueLessThan(String value) {
            addCriterion("DICT_VALUE <", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueLessThanOrEqualTo(String value) {
            addCriterion("DICT_VALUE <=", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueLike(String value) {
            addCriterion("DICT_VALUE like", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueNotLike(String value) {
            addCriterion("DICT_VALUE not like", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueIn(List<String> values) {
            addCriterion("DICT_VALUE in", values, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueNotIn(List<String> values) {
            addCriterion("DICT_VALUE not in", values, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueBetween(String value1, String value2) {
            addCriterion("DICT_VALUE between", value1, value2, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueNotBetween(String value1, String value2) {
            addCriterion("DICT_VALUE not between", value1, value2, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictStatusIsNull() {
            addCriterion("DICT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andDictStatusIsNotNull() {
            addCriterion("DICT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andDictStatusEqualTo(String value) {
            addCriterion("DICT_STATUS =", value, "dictStatus");
            return (Criteria) this;
        }

        public Criteria andDictStatusNotEqualTo(String value) {
            addCriterion("DICT_STATUS <>", value, "dictStatus");
            return (Criteria) this;
        }

        public Criteria andDictStatusGreaterThan(String value) {
            addCriterion("DICT_STATUS >", value, "dictStatus");
            return (Criteria) this;
        }

        public Criteria andDictStatusGreaterThanOrEqualTo(String value) {
            addCriterion("DICT_STATUS >=", value, "dictStatus");
            return (Criteria) this;
        }

        public Criteria andDictStatusLessThan(String value) {
            addCriterion("DICT_STATUS <", value, "dictStatus");
            return (Criteria) this;
        }

        public Criteria andDictStatusLessThanOrEqualTo(String value) {
            addCriterion("DICT_STATUS <=", value, "dictStatus");
            return (Criteria) this;
        }

        public Criteria andDictStatusLike(String value) {
            addCriterion("DICT_STATUS like", value, "dictStatus");
            return (Criteria) this;
        }

        public Criteria andDictStatusNotLike(String value) {
            addCriterion("DICT_STATUS not like", value, "dictStatus");
            return (Criteria) this;
        }

        public Criteria andDictStatusIn(List<String> values) {
            addCriterion("DICT_STATUS in", values, "dictStatus");
            return (Criteria) this;
        }

        public Criteria andDictStatusNotIn(List<String> values) {
            addCriterion("DICT_STATUS not in", values, "dictStatus");
            return (Criteria) this;
        }

        public Criteria andDictStatusBetween(String value1, String value2) {
            addCriterion("DICT_STATUS between", value1, value2, "dictStatus");
            return (Criteria) this;
        }

        public Criteria andDictStatusNotBetween(String value1, String value2) {
            addCriterion("DICT_STATUS not between", value1, value2, "dictStatus");
            return (Criteria) this;
        }

        public Criteria andDictCreateuserIsNull() {
            addCriterion("DICT_CREATEUSER is null");
            return (Criteria) this;
        }

        public Criteria andDictCreateuserIsNotNull() {
            addCriterion("DICT_CREATEUSER is not null");
            return (Criteria) this;
        }

        public Criteria andDictCreateuserEqualTo(String value) {
            addCriterion("DICT_CREATEUSER =", value, "dictCreateuser");
            return (Criteria) this;
        }

        public Criteria andDictCreateuserNotEqualTo(String value) {
            addCriterion("DICT_CREATEUSER <>", value, "dictCreateuser");
            return (Criteria) this;
        }

        public Criteria andDictCreateuserGreaterThan(String value) {
            addCriterion("DICT_CREATEUSER >", value, "dictCreateuser");
            return (Criteria) this;
        }

        public Criteria andDictCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("DICT_CREATEUSER >=", value, "dictCreateuser");
            return (Criteria) this;
        }

        public Criteria andDictCreateuserLessThan(String value) {
            addCriterion("DICT_CREATEUSER <", value, "dictCreateuser");
            return (Criteria) this;
        }

        public Criteria andDictCreateuserLessThanOrEqualTo(String value) {
            addCriterion("DICT_CREATEUSER <=", value, "dictCreateuser");
            return (Criteria) this;
        }

        public Criteria andDictCreateuserLike(String value) {
            addCriterion("DICT_CREATEUSER like", value, "dictCreateuser");
            return (Criteria) this;
        }

        public Criteria andDictCreateuserNotLike(String value) {
            addCriterion("DICT_CREATEUSER not like", value, "dictCreateuser");
            return (Criteria) this;
        }

        public Criteria andDictCreateuserIn(List<String> values) {
            addCriterion("DICT_CREATEUSER in", values, "dictCreateuser");
            return (Criteria) this;
        }

        public Criteria andDictCreateuserNotIn(List<String> values) {
            addCriterion("DICT_CREATEUSER not in", values, "dictCreateuser");
            return (Criteria) this;
        }

        public Criteria andDictCreateuserBetween(String value1, String value2) {
            addCriterion("DICT_CREATEUSER between", value1, value2, "dictCreateuser");
            return (Criteria) this;
        }

        public Criteria andDictCreateuserNotBetween(String value1, String value2) {
            addCriterion("DICT_CREATEUSER not between", value1, value2, "dictCreateuser");
            return (Criteria) this;
        }

        public Criteria andDictCodePidIsNull() {
            addCriterion("DICT_CODE_PID is null");
            return (Criteria) this;
        }

        public Criteria andDictCodePidIsNotNull() {
            addCriterion("DICT_CODE_PID is not null");
            return (Criteria) this;
        }

        public Criteria andDictCodePidEqualTo(String value) {
            addCriterion("DICT_CODE_PID =", value, "dictCodePid");
            return (Criteria) this;
        }

        public Criteria andDictCodePidNotEqualTo(String value) {
            addCriterion("DICT_CODE_PID <>", value, "dictCodePid");
            return (Criteria) this;
        }

        public Criteria andDictCodePidGreaterThan(String value) {
            addCriterion("DICT_CODE_PID >", value, "dictCodePid");
            return (Criteria) this;
        }

        public Criteria andDictCodePidGreaterThanOrEqualTo(String value) {
            addCriterion("DICT_CODE_PID >=", value, "dictCodePid");
            return (Criteria) this;
        }

        public Criteria andDictCodePidLessThan(String value) {
            addCriterion("DICT_CODE_PID <", value, "dictCodePid");
            return (Criteria) this;
        }

        public Criteria andDictCodePidLessThanOrEqualTo(String value) {
            addCriterion("DICT_CODE_PID <=", value, "dictCodePid");
            return (Criteria) this;
        }

        public Criteria andDictCodePidLike(String value) {
            addCriterion("DICT_CODE_PID like", value, "dictCodePid");
            return (Criteria) this;
        }

        public Criteria andDictCodePidNotLike(String value) {
            addCriterion("DICT_CODE_PID not like", value, "dictCodePid");
            return (Criteria) this;
        }

        public Criteria andDictCodePidIn(List<String> values) {
            addCriterion("DICT_CODE_PID in", values, "dictCodePid");
            return (Criteria) this;
        }

        public Criteria andDictCodePidNotIn(List<String> values) {
            addCriterion("DICT_CODE_PID not in", values, "dictCodePid");
            return (Criteria) this;
        }

        public Criteria andDictCodePidBetween(String value1, String value2) {
            addCriterion("DICT_CODE_PID between", value1, value2, "dictCodePid");
            return (Criteria) this;
        }

        public Criteria andDictCodePidNotBetween(String value1, String value2) {
            addCriterion("DICT_CODE_PID not between", value1, value2, "dictCodePid");
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