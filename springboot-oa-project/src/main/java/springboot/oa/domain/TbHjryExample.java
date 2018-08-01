package springboot.oa.domain;

import java.util.ArrayList;
import java.util.List;

public class TbHjryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbHjryExample() {
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

        public Criteria andHjsfIsNull() {
            addCriterion("hjsf is null");
            return (Criteria) this;
        }

        public Criteria andHjsfIsNotNull() {
            addCriterion("hjsf is not null");
            return (Criteria) this;
        }

        public Criteria andHjsfEqualTo(String value) {
            addCriterion("hjsf =", value, "hjsf");
            return (Criteria) this;
        }

        public Criteria andHjsfNotEqualTo(String value) {
            addCriterion("hjsf <>", value, "hjsf");
            return (Criteria) this;
        }

        public Criteria andHjsfGreaterThan(String value) {
            addCriterion("hjsf >", value, "hjsf");
            return (Criteria) this;
        }

        public Criteria andHjsfGreaterThanOrEqualTo(String value) {
            addCriterion("hjsf >=", value, "hjsf");
            return (Criteria) this;
        }

        public Criteria andHjsfLessThan(String value) {
            addCriterion("hjsf <", value, "hjsf");
            return (Criteria) this;
        }

        public Criteria andHjsfLessThanOrEqualTo(String value) {
            addCriterion("hjsf <=", value, "hjsf");
            return (Criteria) this;
        }

        public Criteria andHjsfLike(String value) {
            addCriterion("hjsf like", value, "hjsf");
            return (Criteria) this;
        }

        public Criteria andHjsfNotLike(String value) {
            addCriterion("hjsf not like", value, "hjsf");
            return (Criteria) this;
        }

        public Criteria andHjsfIn(List<String> values) {
            addCriterion("hjsf in", values, "hjsf");
            return (Criteria) this;
        }

        public Criteria andHjsfNotIn(List<String> values) {
            addCriterion("hjsf not in", values, "hjsf");
            return (Criteria) this;
        }

        public Criteria andHjsfBetween(String value1, String value2) {
            addCriterion("hjsf between", value1, value2, "hjsf");
            return (Criteria) this;
        }

        public Criteria andHjsfNotBetween(String value1, String value2) {
            addCriterion("hjsf not between", value1, value2, "hjsf");
            return (Criteria) this;
        }

        public Criteria andHjryxmIsNull() {
            addCriterion("hjryxm is null");
            return (Criteria) this;
        }

        public Criteria andHjryxmIsNotNull() {
            addCriterion("hjryxm is not null");
            return (Criteria) this;
        }

        public Criteria andHjryxmEqualTo(String value) {
            addCriterion("hjryxm =", value, "hjryxm");
            return (Criteria) this;
        }

        public Criteria andHjryxmNotEqualTo(String value) {
            addCriterion("hjryxm <>", value, "hjryxm");
            return (Criteria) this;
        }

        public Criteria andHjryxmGreaterThan(String value) {
            addCriterion("hjryxm >", value, "hjryxm");
            return (Criteria) this;
        }

        public Criteria andHjryxmGreaterThanOrEqualTo(String value) {
            addCriterion("hjryxm >=", value, "hjryxm");
            return (Criteria) this;
        }

        public Criteria andHjryxmLessThan(String value) {
            addCriterion("hjryxm <", value, "hjryxm");
            return (Criteria) this;
        }

        public Criteria andHjryxmLessThanOrEqualTo(String value) {
            addCriterion("hjryxm <=", value, "hjryxm");
            return (Criteria) this;
        }

        public Criteria andHjryxmLike(String value) {
            addCriterion("hjryxm like", value, "hjryxm");
            return (Criteria) this;
        }

        public Criteria andHjryxmNotLike(String value) {
            addCriterion("hjryxm not like", value, "hjryxm");
            return (Criteria) this;
        }

        public Criteria andHjryxmIn(List<String> values) {
            addCriterion("hjryxm in", values, "hjryxm");
            return (Criteria) this;
        }

        public Criteria andHjryxmNotIn(List<String> values) {
            addCriterion("hjryxm not in", values, "hjryxm");
            return (Criteria) this;
        }

        public Criteria andHjryxmBetween(String value1, String value2) {
            addCriterion("hjryxm between", value1, value2, "hjryxm");
            return (Criteria) this;
        }

        public Criteria andHjryxmNotBetween(String value1, String value2) {
            addCriterion("hjryxm not between", value1, value2, "hjryxm");
            return (Criteria) this;
        }
        
      
      public Criteria andHjzwIsNull() {
          addCriterion("hjzw is null");
          return (Criteria) this;
      }

      public Criteria andHjzwIsNotNull() {
          addCriterion("hjzw is not null");
          return (Criteria) this;
      }

      public Criteria andHjzwEqualTo(String value) {
          addCriterion("hjzw =", value, "hjzw");
          return (Criteria) this;
      }

      public Criteria andHjzwNotEqualTo(String value) {
          addCriterion("hjzw <>", value, "hjzw");
          return (Criteria) this;
      }

      public Criteria andHjzwGreaterThan(String value) {
          addCriterion("hjzw >", value, "hjzw");
          return (Criteria) this;
      }

      public Criteria andHjzwGreaterThanOrEqualTo(String value) {
          addCriterion("hjzw >=", value, "hjzw");
          return (Criteria) this;
      }

      public Criteria andHjzwLessThan(String value) {
          addCriterion("hjzw <", value, "hjzw");
          return (Criteria) this;
      }

      public Criteria andHjzwLessThanOrEqualTo(String value) {
          addCriterion("hjzw <=", value, "hjzw");
          return (Criteria) this;
      }

      public Criteria andHjzwLike(String value) {
          addCriterion("hjzw like", value, "hjzw");
          return (Criteria) this;
      }

      public Criteria andHjzwNotLike(String value) {
          addCriterion("hjzw not like", value, "hjzw");
          return (Criteria) this;
      }

      public Criteria andHjzwIn(List<String> values) {
          addCriterion("hjzw in", values, "hjzw");
          return (Criteria) this;
      }

      public Criteria andHjzwNotIn(List<String> values) {
          addCriterion("hjzw not in", values, "hjzw");
          return (Criteria) this;
      }

      public Criteria andHjzwBetween(String value1, String value2) {
          addCriterion("hjzw between", value1, value2, "hjzw");
          return (Criteria) this;
      }

      public Criteria andHjzwNotBetween(String value1, String value2) {
          addCriterion("hjzw not between", value1, value2, "hjzw");
          return (Criteria) this;
      }
      
        
      
      public Criteria andHjdzIsNull() {
          addCriterion("hjdz is null");
          return (Criteria) this;
      }

      public Criteria andHjdzIsNotNull() {
          addCriterion("hjdz is not null");
          return (Criteria) this;
      }

      public Criteria andHjdzEqualTo(String value) {
          addCriterion("hjdz =", value, "hjdz");
          return (Criteria) this;
      }

      public Criteria andHjdzNotEqualTo(String value) {
          addCriterion("hjdz <>", value, "hjdz");
          return (Criteria) this;
      }

      public Criteria andHjdzGreaterThan(String value) {
          addCriterion("hjdz >", value, "hjdz");
          return (Criteria) this;
      }

      public Criteria andHjdzGreaterThanOrEqualTo(String value) {
          addCriterion("hjdz >=", value, "hjdz");
          return (Criteria) this;
      }

      public Criteria andHjdzLessThan(String value) {
          addCriterion("hjdz <", value, "hjdz");
          return (Criteria) this;
      }

      public Criteria andHjdzLessThanOrEqualTo(String value) {
          addCriterion("hjdz <=", value, "hjdz");
          return (Criteria) this;
      }

      public Criteria andHjdzLike(String value) {
          addCriterion("hjdz like", value, "hjdz");
          return (Criteria) this;
      }

      public Criteria andHjdzNotLike(String value) {
          addCriterion("hjdz not like", value, "hjdz");
          return (Criteria) this;
      }

      public Criteria andHjdzIn(List<String> values) {
          addCriterion("hjdz in", values, "hjdz");
          return (Criteria) this;
      }

      public Criteria andHjdzNotIn(List<String> values) {
          addCriterion("hjdz not in", values, "hjdz");
          return (Criteria) this;
      }

      public Criteria andHjdzBetween(String value1, String value2) {
          addCriterion("hjdz between", value1, value2, "hjdz");
          return (Criteria) this;
      }

      public Criteria andHjdzNotBetween(String value1, String value2) {
          addCriterion("hjdz not between", value1, value2, "hjdz");
          return (Criteria) this;
      }
      

        public Criteria andHjyxIsNull() {
            addCriterion("hjyx is null");
            return (Criteria) this;
        }

        public Criteria andHjyxIsNotNull() {
            addCriterion("hjyx is not null");
            return (Criteria) this;
        }

        public Criteria andHjyxEqualTo(String value) {
            addCriterion("hjyx =", value, "hjyx");
            return (Criteria) this;
        }

        public Criteria andHjyxNotEqualTo(String value) {
            addCriterion("hjyx <>", value, "hjyx");
            return (Criteria) this;
        }

        public Criteria andhHjyxGreaterThan(String value) {
            addCriterion("hjyx >", value, "hjyx");
            return (Criteria) this;
        }

        public Criteria andHjyxGreaterThanOrEqualTo(String value) {
            addCriterion("hjyx >=", value, "hjyx");
            return (Criteria) this;
        }

        public Criteria andHjyxLessThan(String value) {
            addCriterion("hjyx <", value, "hjyx");
            return (Criteria) this;
        }

        public Criteria andHjyxLessThanOrEqualTo(String value) {
            addCriterion("hjyx <=", value, "hjyx");
            return (Criteria) this;
        }

        public Criteria andHjyxLike(String value) {
            addCriterion("hjyx like", value, "hjyx");
            return (Criteria) this;
        }

        public Criteria andHjyxNotLike(String value) {
            addCriterion("hjyx not like", value, "hjyx");
            return (Criteria) this;
        }

        public Criteria andHjyxIn(List<String> values) {
            addCriterion("hjyx in", values, "hjyx");
            return (Criteria) this;
        }

        public Criteria andHjyxNotIn(List<String> values) {
            addCriterion("hjyx not in", values, "hjyx");
            return (Criteria) this;
        }

        public Criteria andHjyxBetween(String value1, String value2) {
            addCriterion("hjyx between", value1, value2, "hjyx");
            return (Criteria) this;
        }

        public Criteria andHjyxNotBetween(String value1, String value2) {
            addCriterion("hjyx not between", value1, value2, "hjyx");
            return (Criteria) this;
        }


        public Criteria andHjlxdhIsNull() {
            addCriterion("hjlxdh is null");
            return (Criteria) this;
        }

        public Criteria andHjlxdhIsNotNull() {
            addCriterion("hjlxdh is not null");
            return (Criteria) this;
        }

        public Criteria andHjlxdhEqualTo(String value) {
            addCriterion("hjlxdh =", value, "hjlxdh");
            return (Criteria) this;
        }

        public Criteria andHjlxdhNotEqualTo(String value) {
            addCriterion("hjlxdh <>", value, "hjlxdh");
            return (Criteria) this;
        }

        public Criteria andHjlxdhGreaterThan(String value) {
            addCriterion("hjlxdh >", value, "hjlxdh");
            return (Criteria) this;
        }

        public Criteria andHjlxdhGreaterThanOrEqualTo(String value) {
            addCriterion("hjlxdh >=", value, "hjlxdh");
            return (Criteria) this;
        }

        public Criteria andHjlxdhLessThan(String value) {
            addCriterion("hjlxdh <", value, "hjlxdh");
            return (Criteria) this;
        }

        public Criteria andHjlxdhLessThanOrEqualTo(String value) {
            addCriterion("hjlxdh <=", value, "hjlxdh");
            return (Criteria) this;
        }

        public Criteria andHjlxdhLike(String value) {
            addCriterion("hjlxdh like", value, "hjlxdh");
            return (Criteria) this;
        }




        public Criteria andHjlxdhNotLike(String value) {
            addCriterion("hjlxdh not like", value, "hjlxdh");
            return (Criteria) this;
        }

        public Criteria andHjlxdhIn(List<String> values) {
            addCriterion("hjlxdh in", values, "hjlxdh");
            return (Criteria) this;
        }

        public Criteria andHjlxdhNotIn(List<String> values) {
            addCriterion("hjlxdh not in", values, "hjlxdh");
            return (Criteria) this;
        }

        public Criteria andHjlxdhBetween(String value1, String value2) {
            addCriterion("hjlxdh between", value1, value2, "hjlxdh");
            return (Criteria) this;
        }

        public Criteria andHjlxdhNotBetween(String value1, String value2) {
            addCriterion("hjlxdh not between", value1, value2, "hjlxdh");
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