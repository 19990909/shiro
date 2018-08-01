package springboot.oa.domain;

import java.util.ArrayList;
import java.util.List;

public class TbSfqkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSfqkExample() {
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

        public Criteria andSqhdmIsNull() {
            addCriterion("sqhdm is null");
            return (Criteria) this;
        }

        public Criteria andSqhdmIsNotNull() {
            addCriterion("sqhdm is not null");
            return (Criteria) this;
        }

        public Criteria andSqhdmEqualTo(String value) {
            addCriterion("sqhdm =", value, "sqhdm");
            return (Criteria) this;
        }

        public Criteria andSqhdmNotEqualTo(String value) {
            addCriterion("sqhdm <>", value, "sqhdm");
            return (Criteria) this;
        }

        public Criteria andSqhdmGreaterThan(String value) {
            addCriterion("sqhdm >", value, "sqhdm");
            return (Criteria) this;
        }

        public Criteria andSqhdmGreaterThanOrEqualTo(String value) {
            addCriterion("sqhdm >=", value, "sqhdm");
            return (Criteria) this;
        }

        public Criteria andSqhdmLessThan(String value) {
            addCriterion("sqhdm <", value, "sqhdm");
            return (Criteria) this;
        }

        public Criteria andSqhdmLessThanOrEqualTo(String value) {
            addCriterion("sqhdm <=", value, "sqhdm");
            return (Criteria) this;
        }

        public Criteria andSqhdmLike(String value) {
            addCriterion("sqhdm like", value, "sqhdm");
            return (Criteria) this;
        }

        public Criteria andSqhdmNotLike(String value) {
            addCriterion("sqhdm not like", value, "sqhdm");
            return (Criteria) this;
        }

        public Criteria andSqhdmIn(List<String> values) {
            addCriterion("sqhdm in", values, "sqhdm");
            return (Criteria) this;
        }

        public Criteria andSqhdmNotIn(List<String> values) {
            addCriterion("sqhdm not in", values, "sqhdm");
            return (Criteria) this;
        }

        public Criteria andSqhdmBetween(String value1, String value2) {
            addCriterion("sqhdm between", value1, value2, "sqhdm");
            return (Criteria) this;
        }

        public Criteria andSqhdmNotBetween(String value1, String value2) {
            addCriterion("sqhdm not between", value1, value2, "sqhdm");
            return (Criteria) this;
        }

        public Criteria andSfmcIsNull() {
            addCriterion("sfmc is null");
            return (Criteria) this;
        }

        public Criteria andSfmcIsNotNull() {
            addCriterion("sfmc is not null");
            return (Criteria) this;
        }

        public Criteria andSfmcEqualTo(String value) {
            addCriterion("sfmc =", value, "sfmc");
            return (Criteria) this;
        }

        public Criteria andSfmcNotEqualTo(String value) {
            addCriterion("sfmc <>", value, "sfmc");
            return (Criteria) this;
        }

        public Criteria andSfmcGreaterThan(String value) {
            addCriterion("sfmc >", value, "sfmc");
            return (Criteria) this;
        }

        public Criteria andSfmcGreaterThanOrEqualTo(String value) {
            addCriterion("sfmc >=", value, "sfmc");
            return (Criteria) this;
        }

        public Criteria andSfmcLessThan(String value) {
            addCriterion("sfmc <", value, "sfmc");
            return (Criteria) this;
        }

        public Criteria andSfmcLessThanOrEqualTo(String value) {
            addCriterion("sfmc <=", value, "sfmc");
            return (Criteria) this;
        }

        public Criteria andSfmcLike(String value) {
            addCriterion("sfmc like", value, "sfmc");
            return (Criteria) this;
        }

        public Criteria andSfmcNotLike(String value) {
            addCriterion("sfmc not like", value, "sfmc");
            return (Criteria) this;
        }

        public Criteria andSfmcIn(List<String> values) {
            addCriterion("sfmc in", values, "sfmc");
            return (Criteria) this;
        }

        public Criteria andSfmcNotIn(List<String> values) {
            addCriterion("sfmc not in", values, "sfmc");
            return (Criteria) this;
        }

        public Criteria andSfmcBetween(String value1, String value2) {
            addCriterion("sfmc between", value1, value2, "sfmc");
            return (Criteria) this;
        }

        public Criteria andSfmcNotBetween(String value1, String value2) {
            addCriterion("sfmc not between", value1, value2, "sfmc");
            return (Criteria) this;
        }
        
      
      public Criteria andSccbdmjIsNull() {
          addCriterion("sccbdmj is null");
          return (Criteria) this;
      }

      public Criteria andSccbdmjIsNotNull() {
          addCriterion("sccbdmj is not null");
          return (Criteria) this;
      }

      public Criteria andSccbdmjEqualTo(String value) {
          addCriterion("sccbdmj =", value, "sccbdmj");
          return (Criteria) this;
      }

      public Criteria andSccbdmjNotEqualTo(String value) {
          addCriterion("sccbdmj <>", value, "sccbdmj");
          return (Criteria) this;
      }

      public Criteria andSccbdmjGreaterThan(String value) {
          addCriterion("sccbdmj >", value, "sccbdmj");
          return (Criteria) this;
      }

      public Criteria andSccbdmjGreaterThanOrEqualTo(String value) {
          addCriterion("sccbdmj >=", value, "sccbdmj");
          return (Criteria) this;
      }

      public Criteria andSccbdmjLessThan(String value) {
          addCriterion("sccbdmj <", value, "sccbdmj");
          return (Criteria) this;
      }

      public Criteria andSccbdmjLessThanOrEqualTo(String value) {
          addCriterion("sccbdmj <=", value, "sccbdmj");
          return (Criteria) this;
      }

      public Criteria andSccbdmjLike(String value) {
          addCriterion("sccbdmj like", value, "sccbdmj");
          return (Criteria) this;
      }

      public Criteria andSccbdmjNotLike(String value) {
          addCriterion("sccbdmj not like", value, "sccbdmj");
          return (Criteria) this;
      }

      public Criteria andSccbdmjIn(List<String> values) {
          addCriterion("sccbdmj in", values, "sccbdmj");
          return (Criteria) this;
      }

      public Criteria andSccbdmjNotIn(List<String> values) {
          addCriterion("sccbdmj not in", values, "sccbdmj");
          return (Criteria) this;
      }

      public Criteria andSccbdmjBetween(String value1, String value2) {
          addCriterion("sccbdmj between", value1, value2, "sccbdmj");
          return (Criteria) this;
      }

      public Criteria andSccbdmjNotBetween(String value1, String value2) {
          addCriterion("sccbdmj not between", value1, value2, "sccbdmj");
          return (Criteria) this;
      }
      
        
      
      public Criteria andQqmjIsNull() {
          addCriterion("qqmj is null");
          return (Criteria) this;
      }

      public Criteria andQqmjIsNotNull() {
          addCriterion("qqmj is not null");
          return (Criteria) this;
      }

      public Criteria andQqmjEqualTo(String value) {
          addCriterion("qqmj =", value, "qqmj");
          return (Criteria) this;
      }

      public Criteria andQqmjNotEqualTo(String value) {
          addCriterion("qqmj <>", value, "qqmj");
          return (Criteria) this;
      }

      public Criteria andQqmjGreaterThan(String value) {
          addCriterion("qqmj >", value, "qqmj");
          return (Criteria) this;
      }

      public Criteria andQqmjGreaterThanOrEqualTo(String value) {
          addCriterion("qqmj >=", value, "qqmj");
          return (Criteria) this;
      }

      public Criteria andQqmjLessThan(String value) {
          addCriterion("qqmj <", value, "qqmj");
          return (Criteria) this;
      }

      public Criteria andQqmjLessThanOrEqualTo(String value) {
          addCriterion("qqmj <=", value, "qqmj");
          return (Criteria) this;
      }

      public Criteria andQqmjLike(String value) {
          addCriterion("qqmj like", value, "qqmj");
          return (Criteria) this;
      }

      public Criteria andQqmjNotLike(String value) {
          addCriterion("qqmj not like", value, "qqmj");
          return (Criteria) this;
      }

      public Criteria andQqmjIn(List<String> values) {
          addCriterion("qqmj in", values, "qqmj");
          return (Criteria) this;
      }

      public Criteria andQqmjNotIn(List<String> values) {
          addCriterion("qqmj not in", values, "qqmj");
          return (Criteria) this;
      }

      public Criteria andQqmjBetween(String value1, String value2) {
          addCriterion("qqmj between", value1, value2, "qqmj");
          return (Criteria) this;
      }

      public Criteria andQqmjNotBetween(String value1, String value2) {
          addCriterion("qqmj not between", value1, value2, "qqmj");
          return (Criteria) this;
      }

      public Criteria andBzsIsNull() {
          addCriterion("bzs is null");
          return (Criteria) this;
      }

        public Criteria andBzsIsNotNull() {
            addCriterion("bzs is not null");
            return (Criteria) this;
        }

        public Criteria andBzsEqualTo(String value) {
            addCriterion("bzs =", value, "bzs");
            return (Criteria) this;
        }

        public Criteria andBzsNotEqualTo(String value) {
            addCriterion("bzs <>", value, "bzs");
            return (Criteria) this;
        }

        public Criteria andBzsGreaterThan(String value) {
            addCriterion("bzs >", value, "bzs");
            return (Criteria) this;
        }

        public Criteria andBzsGreaterThanOrEqualTo(String value) {
            addCriterion("bzs >=", value, "bzs");
            return (Criteria) this;
        }

        public Criteria andBzsLessThan(String value) {
            addCriterion("bzs <", value, "bzs");
            return (Criteria) this;
        }

        public Criteria andBzsLessThanOrEqualTo(String value) {
            addCriterion("bzs <=", value, "bzs");
            return (Criteria) this;
        }

        public Criteria andBzsLike(String value) {
            addCriterion("bzs like", value, "bzs");
            return (Criteria) this;
        }

        public Criteria andBzsNotLike(String value) {
            addCriterion("bzs not like", value, "bzs");
            return (Criteria) this;
        }

        public Criteria andBzsIn(List<String> values) {
            addCriterion("bzs in", values, "bzs");
            return (Criteria) this;
        }

        public Criteria andBzsNotIn(List<String> values) {
            addCriterion("bzs not in", values, "bzs");
            return (Criteria) this;
        }

        public Criteria andBzsBetween(String value1, String value2) {
            addCriterion("bzs between", value1, value2, "bzs");
            return (Criteria) this;
        }

        public Criteria andBzsNotBetween(String value1, String value2) {
            addCriterion("bzs not between", value1, value2, "bzs");
            return (Criteria) this;
        }

        public Criteria andWcqqqkIsNull() {
            addCriterion("wcqqqk is null");
            return (Criteria) this;
        }

        public Criteria andWcqqqkIsNotNull() {
            addCriterion("wcqqqk is not null");
            return (Criteria) this;
        }

        public Criteria andWcqqqkEqualTo(String value) {
            addCriterion("wcqqqk =", value, "wcqqqk");
            return (Criteria) this;
        }

        public Criteria andWcqqqkNotEqualTo(String value) {
            addCriterion("wcqqqk <>", value, "wcqqqk");
            return (Criteria) this;
        }

        public Criteria andWcqqqkGreaterThan(String value) {
            addCriterion("wcqqqk >", value, "wcqqqk");
            return (Criteria) this;
        }

        public Criteria andWcqqqkGreaterThanOrEqualTo(String value) {
            addCriterion("wcqqqk >=", value, "wcqqqk");
            return (Criteria) this;
        }

        public Criteria andWcqqqkLessThan(String value) {
            addCriterion("wcqqqk <", value, "wcqqqk");
            return (Criteria) this;
        }

        public Criteria andWcqqqkLessThanOrEqualTo(String value) {
            addCriterion("wcqqqk <=", value, "wcqqqk");
            return (Criteria) this;
        }

        public Criteria andWcqqqkLike(String value) {
            addCriterion("wcqqqk like", value, "wcqqqk");
            return (Criteria) this;
        }

        public Criteria andWcqqqkNotLike(String value) {
            addCriterion("wcqqqk not like", value, "wcqqqk");
            return (Criteria) this;
        }

        public Criteria andWcqqqkIn(List<String> values) {
            addCriterion("wcqqqk in", values, "wcqqqk");
            return (Criteria) this;
        }

        public Criteria andWcqqqkNotIn(List<String> values) {
            addCriterion("wcqqqk not in", values, "wcqqqk");
            return (Criteria) this;
        }

        public Criteria andWcqqqkBetween(String value1, String value2) {
            addCriterion("wcqqqk between", value1, value2, "wcqqqk");
            return (Criteria) this;
        }

        public Criteria andWcqqqkNotBetween(String value1, String value2) {
            addCriterion("wcqqqk not between", value1, value2, "wcqqqk");
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