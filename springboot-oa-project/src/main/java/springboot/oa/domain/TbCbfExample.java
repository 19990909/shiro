package springboot.oa.domain;

import java.util.ArrayList;
import java.util.List;

public class TbCbfExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbCbfExample() {
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

        public Criteria andCbfbmIsNull() {
            addCriterion("cbfbm is null");
            return (Criteria) this;
        }

        public Criteria andCbfbmIsNotNull() {
            addCriterion("cbfbm is not null");
            return (Criteria) this;
        }

        public Criteria andCbfbmEqualTo(String value) {
            addCriterion("cbfbm =", value, "cbfbm");
            return (Criteria) this;
        }

        public Criteria andCbfbmNotEqualTo(String value) {
            addCriterion("cbfbm <>", value, "cbfbm");
            return (Criteria) this;
        }

        public Criteria andCbfbmGreaterThan(String value) {
            addCriterion("cbfbm >", value, "cbfbm");
            return (Criteria) this;
        }

        public Criteria andCbfbmGreaterThanOrEqualTo(String value) {
            addCriterion("cbfbm >=", value, "cbfbm");
            return (Criteria) this;
        }

        public Criteria andCbfbmLessThan(String value) {
            addCriterion("cbfbm <", value, "cbfbm");
            return (Criteria) this;
        }

        public Criteria andCbfbmLessThanOrEqualTo(String value) {
            addCriterion("cbfbm <=", value, "cbfbm");
            return (Criteria) this;
        }

        public Criteria andCbfbmLike(String value) {
            addCriterion("cbfbm like", value, "cbfbm");
            return (Criteria) this;
        }

        public Criteria andCbfbmNotLike(String value) {
            addCriterion("cbfbm not like", value, "cbfbm");
            return (Criteria) this;
        }

        public Criteria andCbfbmIn(List<String> values) {
            addCriterion("cbfbm in", values, "cbfbm");
            return (Criteria) this;
        }

        public Criteria andCbfbmNotIn(List<String> values) {
            addCriterion("cbfbm not in", values, "cbfbm");
            return (Criteria) this;
        }

        public Criteria andCbfbmBetween(String value1, String value2) {
            addCriterion("cbfbm between", value1, value2, "cbfbm");
            return (Criteria) this;
        }

        public Criteria andCbfbmNotBetween(String value1, String value2) {
            addCriterion("cbfbm not between", value1, value2, "cbfbm");
            return (Criteria) this;
        }



        public Criteria andCbfmcIsNull() {
            addCriterion("cbfmc is null");
            return (Criteria) this;
        }

        public Criteria andCbfmcIsNotNull() {
            addCriterion("cbfmc is not null");
            return (Criteria) this;
        }

        public Criteria andCbfmcEqualTo(String value) {
            addCriterion("cbfmc =", value, "cbfmc");
            return (Criteria) this;
        }

        public Criteria andCbfmcNotEqualTo(String value) {
            addCriterion("cbfmc <>", value, "cbfmc");
            return (Criteria) this;
        }

        public Criteria andCbfmcGreaterThan(String value) {
            addCriterion("cbfmc >", value, "cbfmc");
            return (Criteria) this;
        }

        public Criteria andCbfmcGreaterThanOrEqualTo(String value) {
            addCriterion("cbfmc >=", value, "cbfmc");
            return (Criteria) this;
        }

        public Criteria andCbfmcLessThan(String value) {
            addCriterion("cbfmc <", value, "cbfmc");
            return (Criteria) this;
        }

        public Criteria andCbfmcLessThanOrEqualTo(String value) {
            addCriterion("cbfmc <=", value, "cbfmc");
            return (Criteria) this;
        }

        public Criteria andCbfmcLike(String value) {
            addCriterion("cbfmc like", value, "cbfmc");
            return (Criteria) this;
        }

        public Criteria andCbfmcNotLike(String value) {
            addCriterion("cbfmc not like", value, "cbfmc");
            return (Criteria) this;
        }

        public Criteria andCbfmcIn(List<String> values) {
            addCriterion("cbfmc in", values, "cbfmc");
            return (Criteria) this;
        }

        public Criteria andCbfmcNotIn(List<String> values) {
            addCriterion("cbfmc not in", values, "cbfmc");
            return (Criteria) this;
        }

        public Criteria andCbfmcBetween(String value1, String value2) {
            addCriterion("cbfmc between", value1, value2, "cbfmc");
            return (Criteria) this;
        }

        public Criteria andCbfmcNotBetween(String value1, String value2) {
            addCriterion("cbfmc not between", value1, value2, "cbfmc");
            return (Criteria) this;
        }


        public Criteria andCbflxIsNull() {
            addCriterion("cbflx is null");
            return (Criteria) this;
        }

        public Criteria andCbflxIsNotNull() {
            addCriterion("cbflx is not null");
            return (Criteria) this;
        }

        public Criteria andCbflxEqualTo(String value) {
            addCriterion("cbflx =", value, "cbflx");
            return (Criteria) this;
        }

        public Criteria andCbflxNotEqualTo(String value) {
            addCriterion("cbflx <>", value, "cbflx");
            return (Criteria) this;
        }

        public Criteria andCbflxGreaterThan(String value) {
            addCriterion("cbflx >", value, "cbflx");
            return (Criteria) this;
        }

        public Criteria andCbflxGreaterThanOrEqualTo(String value) {
            addCriterion("cbflx >=", value, "cbflx");
            return (Criteria) this;
        }

        public Criteria andCbflxLessThan(String value) {
            addCriterion("cbflx <", value, "cbflx");
            return (Criteria) this;
        }

        public Criteria andCbflxLessThanOrEqualTo(String value) {
            addCriterion("cbflx <=", value, "cbflx");
            return (Criteria) this;
        }

        public Criteria andCbflxLike(String value) {
            addCriterion("cbflx like", value, "cbflx");
            return (Criteria) this;
        }

        public Criteria andCbflxNotLike(String value) {
            addCriterion("cbflx not like", value, "cbflx");
            return (Criteria) this;
        }

        public Criteria andCbflxIn(List<String> values) {
            addCriterion("cbflx in", values, "cbflx");
            return (Criteria) this;
        }

        public Criteria andCbflxNotIn(List<String> values) {
            addCriterion("cbflx not in", values, "cbflx");
            return (Criteria) this;
        }

        public Criteria andCbflxBetween(String value1, String value2) {
            addCriterion("cbflx between", value1, value2, "cbflx");
            return (Criteria) this;
        }

        public Criteria andCbflxNotBetween(String value1, String value2) {
            addCriterion("cbflx not between", value1, value2, "cbflx");
            return (Criteria) this;
        }



        public Criteria andCbfzjhmIsNull() {
            addCriterion("cbfzjhm is null");
            return (Criteria) this;
        }

        public Criteria andCbfzjhmIsNotNull() {
            addCriterion("cbfzjhm is not null");
            return (Criteria) this;
        }

        public Criteria andCbfzjhmEqualTo(String value) {
            addCriterion("cbfzjhm =", value, "cbfzjhm");
            return (Criteria) this;
        }

        public Criteria andCbfzjhmNotEqualTo(String value) {
            addCriterion("cbfzjhm <>", value, "cbfzjhm");
            return (Criteria) this;
        }

        public Criteria andCbfzjhmGreaterThan(String value) {
            addCriterion("cbfzjhm >", value, "cbfzjhm");
            return (Criteria) this;
        }

        public Criteria andCbfzjhmGreaterThanOrEqualTo(String value) {
            addCriterion("cbfzjhm >=", value, "cbfzjhm");
            return (Criteria) this;
        }

        public Criteria andCbfzjhmLessThan(String value) {
            addCriterion("cbfzjhm <", value, "cbfzjhm");
            return (Criteria) this;
        }

        public Criteria andCbfzjhmLessThanOrEqualTo(String value) {
            addCriterion("cbfzjhm <=", value, "cbfzjhm");
            return (Criteria) this;
        }

        public Criteria andCbfzjhmLike(String value) {
            addCriterion("cbfzjhm like", value, "cbfzjhm");
            return (Criteria) this;
        }

        public Criteria andCbfzjhmNotLike(String value) {
            addCriterion("cbfzjhm not like", value, "cbfzjhm");
            return (Criteria) this;
        }

        public Criteria andCbfzjhmIn(List<String> values) {
            addCriterion("cbfzjhm in", values, "cbfzjhm");
            return (Criteria) this;
        }

        public Criteria andCbfzjhmNotIn(List<String> values) {
            addCriterion("cbfzjhm not in", values, "cbfzjhm");
            return (Criteria) this;
        }

        public Criteria andCbfzjhmBetween(String value1, String value2) {
            addCriterion("cbfzjhm between", value1, value2, "cbfzjhm");
            return (Criteria) this;
        }

        public Criteria andCbfzjhmNotBetween(String value1, String value2) {
            addCriterion("cbfzjhm not between", value1, value2, "cbfzjhm");
            return (Criteria) this;
        }


        public Criteria andJidIsNull() {
            addCriterion("jid is null");
            return (Criteria) this;
        }

        public Criteria andJidIsNotNull() {
            addCriterion("jid is not null");
            return (Criteria) this;
        }

        public Criteria andJidEqualTo(String value) {
            addCriterion("jid =", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidNotEqualTo(String value) {
            addCriterion("jid <>", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidGreaterThan(String value) {
            addCriterion("jid >", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidGreaterThanOrEqualTo(String value) {
            addCriterion("jid >=", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidLessThan(String value) {
            addCriterion("jid <", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidLessThanOrEqualTo(String value) {
            addCriterion("jid <=", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidLike(String value) {
            addCriterion("jid like", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidNotLike(String value) {
            addCriterion("jid not like", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidIn(List<String> values) {
            addCriterion("jid in", values, "jid");
            return (Criteria) this;
        }

        public Criteria andJidNotIn(List<String> values) {
            addCriterion("jid not in", values, "jid");
            return (Criteria) this;
        }

        public Criteria andJidBetween(String value1, String value2) {
            addCriterion("jid between", value1, value2, "jid");
            return (Criteria) this;
        }

        public Criteria andJidNotBetween(String value1, String value2) {
            addCriterion("jid not between", value1, value2, "jid");
            return (Criteria) this;
        }

        public Criteria andLxdhIsNull() {
            addCriterion("lxdh is null");
            return (Criteria) this;
        }

        public Criteria andLxdhIsNotNull() {
            addCriterion("lxdh is not null");
            return (Criteria) this;
        }

        public Criteria andLxdhEqualTo(String value) {
            addCriterion("lxdh =", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhNotEqualTo(String value) {
            addCriterion("lxdh <>", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhGreaterThan(String value) {
            addCriterion("lxdh >", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhGreaterThanOrEqualTo(String value) {
            addCriterion("lxdh >=", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhLessThan(String value) {
            addCriterion("lxdh <", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhLessThanOrEqualTo(String value) {
            addCriterion("lxdh <=", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhLike(String value) {
            addCriterion("lxdh like", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhNotLike(String value) {
            addCriterion("lxdh not like", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhIn(List<String> values) {
            addCriterion("lxdh in", values, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhNotIn(List<String> values) {
            addCriterion("lxdh not in", values, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhBetween(String value1, String value2) {
            addCriterion("lxdh between", value1, value2, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhNotBetween(String value1, String value2) {
            addCriterion("lxdh not between", value1, value2, "lxdh");
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