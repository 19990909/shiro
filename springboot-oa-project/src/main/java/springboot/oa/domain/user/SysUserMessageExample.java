package springboot.oa.domain.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SysUserMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String fields;

    public SysUserMessageExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andSjrIsNull() {
            addCriterion("SJR is null");
            return (Criteria) this;
        }

        public Criteria andSjrIsNotNull() {
            addCriterion("SJR is not null");
            return (Criteria) this;
        }

        public Criteria andSjrEqualTo(String value) {
            addCriterion("SJR =", value, "sjr");
            return (Criteria) this;
        }

        public Criteria andSjrNotEqualTo(String value) {
            addCriterion("SJR <>", value, "sjr");
            return (Criteria) this;
        }

        public Criteria andSjrGreaterThan(String value) {
            addCriterion("SJR >", value, "sjr");
            return (Criteria) this;
        }

        public Criteria andSjrGreaterThanOrEqualTo(String value) {
            addCriterion("SJR >=", value, "sjr");
            return (Criteria) this;
        }

        public Criteria andSjrLessThan(String value) {
            addCriterion("SJR <", value, "sjr");
            return (Criteria) this;
        }

        public Criteria andSjrLessThanOrEqualTo(String value) {
            addCriterion("SJR <=", value, "sjr");
            return (Criteria) this;
        }

        public Criteria andSjrLike(String value) {
            addCriterion("SJR like", value, "sjr");
            return (Criteria) this;
        }

        public Criteria andSjrNotLike(String value) {
            addCriterion("SJR not like", value, "sjr");
            return (Criteria) this;
        }

        public Criteria andSjrIn(List<String> values) {
            addCriterion("SJR in", values, "sjr");
            return (Criteria) this;
        }

        public Criteria andSjrNotIn(List<String> values) {
            addCriterion("SJR not in", values, "sjr");
            return (Criteria) this;
        }

        public Criteria andSjrBetween(String value1, String value2) {
            addCriterion("SJR between", value1, value2, "sjr");
            return (Criteria) this;
        }

        public Criteria andSjrNotBetween(String value1, String value2) {
            addCriterion("SJR not between", value1, value2, "sjr");
            return (Criteria) this;
        }

        public Criteria andZtIsNull() {
            addCriterion("ZT is null");
            return (Criteria) this;
        }

        public Criteria andZtIsNotNull() {
            addCriterion("ZT is not null");
            return (Criteria) this;
        }

        public Criteria andZtEqualTo(String value) {
            addCriterion("ZT =", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotEqualTo(String value) {
            addCriterion("ZT <>", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtGreaterThan(String value) {
            addCriterion("ZT >", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtGreaterThanOrEqualTo(String value) {
            addCriterion("ZT >=", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLessThan(String value) {
            addCriterion("ZT <", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLessThanOrEqualTo(String value) {
            addCriterion("ZT <=", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLike(String value) {
            addCriterion("ZT like", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotLike(String value) {
            addCriterion("ZT not like", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtIn(List<String> values) {
            addCriterion("ZT in", values, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotIn(List<String> values) {
            addCriterion("ZT not in", values, "zt");
            return (Criteria) this;
        }

        public Criteria andZtBetween(String value1, String value2) {
            addCriterion("ZT between", value1, value2, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotBetween(String value1, String value2) {
            addCriterion("ZT not between", value1, value2, "zt");
            return (Criteria) this;
        }

        public Criteria andZwIsNull() {
            addCriterion("ZW is null");
            return (Criteria) this;
        }

        public Criteria andZwIsNotNull() {
            addCriterion("ZW is not null");
            return (Criteria) this;
        }

        public Criteria andZwEqualTo(String value) {
            addCriterion("ZW =", value, "zw");
            return (Criteria) this;
        }

        public Criteria andZwNotEqualTo(String value) {
            addCriterion("ZW <>", value, "zw");
            return (Criteria) this;
        }

        public Criteria andZwGreaterThan(String value) {
            addCriterion("ZW >", value, "zw");
            return (Criteria) this;
        }

        public Criteria andZwGreaterThanOrEqualTo(String value) {
            addCriterion("ZW >=", value, "zw");
            return (Criteria) this;
        }

        public Criteria andZwLessThan(String value) {
            addCriterion("ZW <", value, "zw");
            return (Criteria) this;
        }

        public Criteria andZwLessThanOrEqualTo(String value) {
            addCriterion("ZW <=", value, "zw");
            return (Criteria) this;
        }

        public Criteria andZwLike(String value) {
            addCriterion("ZW like", value, "zw");
            return (Criteria) this;
        }

        public Criteria andZwNotLike(String value) {
            addCriterion("ZW not like", value, "zw");
            return (Criteria) this;
        }

        public Criteria andZwIn(List<String> values) {
            addCriterion("ZW in", values, "zw");
            return (Criteria) this;
        }

        public Criteria andZwNotIn(List<String> values) {
            addCriterion("ZW not in", values, "zw");
            return (Criteria) this;
        }

        public Criteria andZwBetween(String value1, String value2) {
            addCriterion("ZW between", value1, value2, "zw");
            return (Criteria) this;
        }

        public Criteria andZwNotBetween(String value1, String value2) {
            addCriterion("ZW not between", value1, value2, "zw");
            return (Criteria) this;
        }

        public Criteria andUploadpathIsNull() {
            addCriterion("UPLOADPATH is null");
            return (Criteria) this;
        }

        public Criteria andUploadpathIsNotNull() {
            addCriterion("UPLOADPATH is not null");
            return (Criteria) this;
        }

        public Criteria andUploadpathEqualTo(String value) {
            addCriterion("UPLOADPATH =", value, "uploadpath");
            return (Criteria) this;
        }

        public Criteria andUploadpathNotEqualTo(String value) {
            addCriterion("UPLOADPATH <>", value, "uploadpath");
            return (Criteria) this;
        }

        public Criteria andUploadpathGreaterThan(String value) {
            addCriterion("UPLOADPATH >", value, "uploadpath");
            return (Criteria) this;
        }

        public Criteria andUploadpathGreaterThanOrEqualTo(String value) {
            addCriterion("UPLOADPATH >=", value, "uploadpath");
            return (Criteria) this;
        }

        public Criteria andUploadpathLessThan(String value) {
            addCriterion("UPLOADPATH <", value, "uploadpath");
            return (Criteria) this;
        }

        public Criteria andUploadpathLessThanOrEqualTo(String value) {
            addCriterion("UPLOADPATH <=", value, "uploadpath");
            return (Criteria) this;
        }

        public Criteria andUploadpathLike(String value) {
            addCriterion("UPLOADPATH like", value, "uploadpath");
            return (Criteria) this;
        }

        public Criteria andUploadpathNotLike(String value) {
            addCriterion("UPLOADPATH not like", value, "uploadpath");
            return (Criteria) this;
        }

        public Criteria andUploadpathIn(List<String> values) {
            addCriterion("UPLOADPATH in", values, "uploadpath");
            return (Criteria) this;
        }

        public Criteria andUploadpathNotIn(List<String> values) {
            addCriterion("UPLOADPATH not in", values, "uploadpath");
            return (Criteria) this;
        }

        public Criteria andUploadpathBetween(String value1, String value2) {
            addCriterion("UPLOADPATH between", value1, value2, "uploadpath");
            return (Criteria) this;
        }

        public Criteria andUploadpathNotBetween(String value1, String value2) {
            addCriterion("UPLOADPATH not between", value1, value2, "uploadpath");
            return (Criteria) this;
        }

        public Criteria andFjrIsNull() {
            addCriterion("FJR is null");
            return (Criteria) this;
        }

        public Criteria andFjrIsNotNull() {
            addCriterion("FJR is not null");
            return (Criteria) this;
        }

        public Criteria andFjrEqualTo(String value) {
            addCriterion("FJR =", value, "fjr");
            return (Criteria) this;
        }

        public Criteria andFjrNotEqualTo(String value) {
            addCriterion("FJR <>", value, "fjr");
            return (Criteria) this;
        }

        public Criteria andFjrGreaterThan(String value) {
            addCriterion("FJR >", value, "fjr");
            return (Criteria) this;
        }

        public Criteria andFjrGreaterThanOrEqualTo(String value) {
            addCriterion("FJR >=", value, "fjr");
            return (Criteria) this;
        }

        public Criteria andFjrLessThan(String value) {
            addCriterion("FJR <", value, "fjr");
            return (Criteria) this;
        }

        public Criteria andFjrLessThanOrEqualTo(String value) {
            addCriterion("FJR <=", value, "fjr");
            return (Criteria) this;
        }

        public Criteria andFjrLike(String value) {
            addCriterion("FJR like", value, "fjr");
            return (Criteria) this;
        }

        public Criteria andFjrNotLike(String value) {
            addCriterion("FJR not like", value, "fjr");
            return (Criteria) this;
        }

        public Criteria andFjrIn(List<String> values) {
            addCriterion("FJR in", values, "fjr");
            return (Criteria) this;
        }

        public Criteria andFjrNotIn(List<String> values) {
            addCriterion("FJR not in", values, "fjr");
            return (Criteria) this;
        }

        public Criteria andFjrBetween(String value1, String value2) {
            addCriterion("FJR between", value1, value2, "fjr");
            return (Criteria) this;
        }

        public Criteria andFjrNotBetween(String value1, String value2) {
            addCriterion("FJR not between", value1, value2, "fjr");
            return (Criteria) this;
        }

        public Criteria andXxlbIsNull() {
            addCriterion("XXLB is null");
            return (Criteria) this;
        }

        public Criteria andXxlbIsNotNull() {
            addCriterion("XXLB is not null");
            return (Criteria) this;
        }

        public Criteria andXxlbEqualTo(String value) {
            addCriterion("XXLB =", value, "xxlb");
            return (Criteria) this;
        }

        public Criteria andXxlbNotEqualTo(String value) {
            addCriterion("XXLB <>", value, "xxlb");
            return (Criteria) this;
        }

        public Criteria andXxlbGreaterThan(String value) {
            addCriterion("XXLB >", value, "xxlb");
            return (Criteria) this;
        }

        public Criteria andXxlbGreaterThanOrEqualTo(String value) {
            addCriterion("XXLB >=", value, "xxlb");
            return (Criteria) this;
        }

        public Criteria andXxlbLessThan(String value) {
            addCriterion("XXLB <", value, "xxlb");
            return (Criteria) this;
        }

        public Criteria andXxlbLessThanOrEqualTo(String value) {
            addCriterion("XXLB <=", value, "xxlb");
            return (Criteria) this;
        }

        public Criteria andXxlbLike(String value) {
            addCriterion("XXLB like", value, "xxlb");
            return (Criteria) this;
        }

        public Criteria andXxlbNotLike(String value) {
            addCriterion("XXLB not like", value, "xxlb");
            return (Criteria) this;
        }

        public Criteria andXxlbIn(List<String> values) {
            addCriterion("XXLB in", values, "xxlb");
            return (Criteria) this;
        }

        public Criteria andXxlbNotIn(List<String> values) {
            addCriterion("XXLB not in", values, "xxlb");
            return (Criteria) this;
        }

        public Criteria andXxlbBetween(String value1, String value2) {
            addCriterion("XXLB between", value1, value2, "xxlb");
            return (Criteria) this;
        }

        public Criteria andXxlbNotBetween(String value1, String value2) {
            addCriterion("XXLB not between", value1, value2, "xxlb");
            return (Criteria) this;
        }

        public Criteria andFsztIsNull() {
            addCriterion("FSZT is null");
            return (Criteria) this;
        }

        public Criteria andFsztIsNotNull() {
            addCriterion("FSZT is not null");
            return (Criteria) this;
        }

        public Criteria andFsztEqualTo(String value) {
            addCriterion("FSZT =", value, "fszt");
            return (Criteria) this;
        }

        public Criteria andFsztNotEqualTo(String value) {
            addCriterion("FSZT <>", value, "fszt");
            return (Criteria) this;
        }

        public Criteria andFsztGreaterThan(String value) {
            addCriterion("FSZT >", value, "fszt");
            return (Criteria) this;
        }

        public Criteria andFsztGreaterThanOrEqualTo(String value) {
            addCriterion("FSZT >=", value, "fszt");
            return (Criteria) this;
        }

        public Criteria andFsztLessThan(String value) {
            addCriterion("FSZT <", value, "fszt");
            return (Criteria) this;
        }

        public Criteria andFsztLessThanOrEqualTo(String value) {
            addCriterion("FSZT <=", value, "fszt");
            return (Criteria) this;
        }

        public Criteria andFsztLike(String value) {
            addCriterion("FSZT like", value, "fszt");
            return (Criteria) this;
        }

        public Criteria andFsztNotLike(String value) {
            addCriterion("FSZT not like", value, "fszt");
            return (Criteria) this;
        }

        public Criteria andFsztIn(List<String> values) {
            addCriterion("FSZT in", values, "fszt");
            return (Criteria) this;
        }

        public Criteria andFsztNotIn(List<String> values) {
            addCriterion("FSZT not in", values, "fszt");
            return (Criteria) this;
        }

        public Criteria andFsztBetween(String value1, String value2) {
            addCriterion("FSZT between", value1, value2, "fszt");
            return (Criteria) this;
        }

        public Criteria andFsztNotBetween(String value1, String value2) {
            addCriterion("FSZT not between", value1, value2, "fszt");
            return (Criteria) this;
        }

        public Criteria andDqztIsNull() {
            addCriterion("DQZT is null");
            return (Criteria) this;
        }

        public Criteria andDqztIsNotNull() {
            addCriterion("DQZT is not null");
            return (Criteria) this;
        }

        public Criteria andDqztEqualTo(String value) {
            addCriterion("DQZT =", value, "dqzt");
            return (Criteria) this;
        }

        public Criteria andDqztNotEqualTo(String value) {
            addCriterion("DQZT <>", value, "dqzt");
            return (Criteria) this;
        }

        public Criteria andDqztGreaterThan(String value) {
            addCriterion("DQZT >", value, "dqzt");
            return (Criteria) this;
        }

        public Criteria andDqztGreaterThanOrEqualTo(String value) {
            addCriterion("DQZT >=", value, "dqzt");
            return (Criteria) this;
        }

        public Criteria andDqztLessThan(String value) {
            addCriterion("DQZT <", value, "dqzt");
            return (Criteria) this;
        }

        public Criteria andDqztLessThanOrEqualTo(String value) {
            addCriterion("DQZT <=", value, "dqzt");
            return (Criteria) this;
        }

        public Criteria andDqztLike(String value) {
            addCriterion("DQZT like", value, "dqzt");
            return (Criteria) this;
        }

        public Criteria andDqztNotLike(String value) {
            addCriterion("DQZT not like", value, "dqzt");
            return (Criteria) this;
        }

        public Criteria andDqztIn(List<String> values) {
            addCriterion("DQZT in", values, "dqzt");
            return (Criteria) this;
        }

        public Criteria andDqztNotIn(List<String> values) {
            addCriterion("DQZT not in", values, "dqzt");
            return (Criteria) this;
        }

        public Criteria andDqztBetween(String value1, String value2) {
            addCriterion("DQZT between", value1, value2, "dqzt");
            return (Criteria) this;
        }

        public Criteria andDqztNotBetween(String value1, String value2) {
            addCriterion("DQZT not between", value1, value2, "dqzt");
            return (Criteria) this;
        }

        public Criteria andBy3IsNull() {
            addCriterion("BY3 is null");
            return (Criteria) this;
        }

        public Criteria andBy3IsNotNull() {
            addCriterion("BY3 is not null");
            return (Criteria) this;
        }

        public Criteria andBy3EqualTo(String value) {
            addCriterion("BY3 =", value, "by3");
            return (Criteria) this;
        }

        public Criteria andBy3NotEqualTo(String value) {
            addCriterion("BY3 <>", value, "by3");
            return (Criteria) this;
        }

        public Criteria andBy3GreaterThan(String value) {
            addCriterion("BY3 >", value, "by3");
            return (Criteria) this;
        }

        public Criteria andBy3GreaterThanOrEqualTo(String value) {
            addCriterion("BY3 >=", value, "by3");
            return (Criteria) this;
        }

        public Criteria andBy3LessThan(String value) {
            addCriterion("BY3 <", value, "by3");
            return (Criteria) this;
        }

        public Criteria andBy3LessThanOrEqualTo(String value) {
            addCriterion("BY3 <=", value, "by3");
            return (Criteria) this;
        }

        public Criteria andBy3Like(String value) {
            addCriterion("BY3 like", value, "by3");
            return (Criteria) this;
        }

        public Criteria andBy3NotLike(String value) {
            addCriterion("BY3 not like", value, "by3");
            return (Criteria) this;
        }

        public Criteria andBy3In(List<String> values) {
            addCriterion("BY3 in", values, "by3");
            return (Criteria) this;
        }

        public Criteria andBy3NotIn(List<String> values) {
            addCriterion("BY3 not in", values, "by3");
            return (Criteria) this;
        }

        public Criteria andBy3Between(String value1, String value2) {
            addCriterion("BY3 between", value1, value2, "by3");
            return (Criteria) this;
        }

        public Criteria andBy3NotBetween(String value1, String value2) {
            addCriterion("BY3 not between", value1, value2, "by3");
            return (Criteria) this;
        }

        public Criteria andBy4IsNull() {
            addCriterion("BY4 is null");
            return (Criteria) this;
        }

        public Criteria andBy4IsNotNull() {
            addCriterion("BY4 is not null");
            return (Criteria) this;
        }

        public Criteria andBy4EqualTo(String value) {
            addCriterion("BY4 =", value, "by4");
            return (Criteria) this;
        }

        public Criteria andBy4NotEqualTo(String value) {
            addCriterion("BY4 <>", value, "by4");
            return (Criteria) this;
        }

        public Criteria andBy4GreaterThan(String value) {
            addCriterion("BY4 >", value, "by4");
            return (Criteria) this;
        }

        public Criteria andBy4GreaterThanOrEqualTo(String value) {
            addCriterion("BY4 >=", value, "by4");
            return (Criteria) this;
        }

        public Criteria andBy4LessThan(String value) {
            addCriterion("BY4 <", value, "by4");
            return (Criteria) this;
        }

        public Criteria andBy4LessThanOrEqualTo(String value) {
            addCriterion("BY4 <=", value, "by4");
            return (Criteria) this;
        }

        public Criteria andBy4Like(String value) {
            addCriterion("BY4 like", value, "by4");
            return (Criteria) this;
        }

        public Criteria andBy4NotLike(String value) {
            addCriterion("BY4 not like", value, "by4");
            return (Criteria) this;
        }

        public Criteria andBy4In(List<String> values) {
            addCriterion("BY4 in", values, "by4");
            return (Criteria) this;
        }

        public Criteria andBy4NotIn(List<String> values) {
            addCriterion("BY4 not in", values, "by4");
            return (Criteria) this;
        }

        public Criteria andBy4Between(String value1, String value2) {
            addCriterion("BY4 between", value1, value2, "by4");
            return (Criteria) this;
        }

        public Criteria andBy4NotBetween(String value1, String value2) {
            addCriterion("BY4 not between", value1, value2, "by4");
            return (Criteria) this;
        }

        public Criteria andBy5IsNull() {
            addCriterion("BY5 is null");
            return (Criteria) this;
        }

        public Criteria andBy5IsNotNull() {
            addCriterion("BY5 is not null");
            return (Criteria) this;
        }

        public Criteria andBy5EqualTo(String value) {
            addCriterion("BY5 =", value, "by5");
            return (Criteria) this;
        }

        public Criteria andBy5NotEqualTo(String value) {
            addCriterion("BY5 <>", value, "by5");
            return (Criteria) this;
        }

        public Criteria andBy5GreaterThan(String value) {
            addCriterion("BY5 >", value, "by5");
            return (Criteria) this;
        }

        public Criteria andBy5GreaterThanOrEqualTo(String value) {
            addCriterion("BY5 >=", value, "by5");
            return (Criteria) this;
        }

        public Criteria andBy5LessThan(String value) {
            addCriterion("BY5 <", value, "by5");
            return (Criteria) this;
        }

        public Criteria andBy5LessThanOrEqualTo(String value) {
            addCriterion("BY5 <=", value, "by5");
            return (Criteria) this;
        }

        public Criteria andBy5Like(String value) {
            addCriterion("BY5 like", value, "by5");
            return (Criteria) this;
        }

        public Criteria andBy5NotLike(String value) {
            addCriterion("BY5 not like", value, "by5");
            return (Criteria) this;
        }

        public Criteria andBy5In(List<String> values) {
            addCriterion("BY5 in", values, "by5");
            return (Criteria) this;
        }

        public Criteria andBy5NotIn(List<String> values) {
            addCriterion("BY5 not in", values, "by5");
            return (Criteria) this;
        }

        public Criteria andBy5Between(String value1, String value2) {
            addCriterion("BY5 between", value1, value2, "by5");
            return (Criteria) this;
        }

        public Criteria andBy5NotBetween(String value1, String value2) {
            addCriterion("BY5 not between", value1, value2, "by5");
            return (Criteria) this;
        }

        public Criteria andBy6IsNull() {
            addCriterion("BY6 is null");
            return (Criteria) this;
        }

        public Criteria andBy6IsNotNull() {
            addCriterion("BY6 is not null");
            return (Criteria) this;
        }

        public Criteria andBy6EqualTo(String value) {
            addCriterion("BY6 =", value, "by6");
            return (Criteria) this;
        }

        public Criteria andBy6NotEqualTo(String value) {
            addCriterion("BY6 <>", value, "by6");
            return (Criteria) this;
        }

        public Criteria andBy6GreaterThan(String value) {
            addCriterion("BY6 >", value, "by6");
            return (Criteria) this;
        }

        public Criteria andBy6GreaterThanOrEqualTo(String value) {
            addCriterion("BY6 >=", value, "by6");
            return (Criteria) this;
        }

        public Criteria andBy6LessThan(String value) {
            addCriterion("BY6 <", value, "by6");
            return (Criteria) this;
        }

        public Criteria andBy6LessThanOrEqualTo(String value) {
            addCriterion("BY6 <=", value, "by6");
            return (Criteria) this;
        }

        public Criteria andBy6Like(String value) {
            addCriterion("BY6 like", value, "by6");
            return (Criteria) this;
        }

        public Criteria andBy6NotLike(String value) {
            addCriterion("BY6 not like", value, "by6");
            return (Criteria) this;
        }

        public Criteria andBy6In(List<String> values) {
            addCriterion("BY6 in", values, "by6");
            return (Criteria) this;
        }

        public Criteria andBy6NotIn(List<String> values) {
            addCriterion("BY6 not in", values, "by6");
            return (Criteria) this;
        }

        public Criteria andBy6Between(String value1, String value2) {
            addCriterion("BY6 between", value1, value2, "by6");
            return (Criteria) this;
        }

        public Criteria andBy6NotBetween(String value1, String value2) {
            addCriterion("BY6 not between", value1, value2, "by6");
            return (Criteria) this;
        }

        public Criteria andBy7IsNull() {
            addCriterion("BY7 is null");
            return (Criteria) this;
        }

        public Criteria andBy7IsNotNull() {
            addCriterion("BY7 is not null");
            return (Criteria) this;
        }

        public Criteria andBy7EqualTo(String value) {
            addCriterion("BY7 =", value, "by7");
            return (Criteria) this;
        }

        public Criteria andBy7NotEqualTo(String value) {
            addCriterion("BY7 <>", value, "by7");
            return (Criteria) this;
        }

        public Criteria andBy7GreaterThan(String value) {
            addCriterion("BY7 >", value, "by7");
            return (Criteria) this;
        }

        public Criteria andBy7GreaterThanOrEqualTo(String value) {
            addCriterion("BY7 >=", value, "by7");
            return (Criteria) this;
        }

        public Criteria andBy7LessThan(String value) {
            addCriterion("BY7 <", value, "by7");
            return (Criteria) this;
        }

        public Criteria andBy7LessThanOrEqualTo(String value) {
            addCriterion("BY7 <=", value, "by7");
            return (Criteria) this;
        }

        public Criteria andBy7Like(String value) {
            addCriterion("BY7 like", value, "by7");
            return (Criteria) this;
        }

        public Criteria andBy7NotLike(String value) {
            addCriterion("BY7 not like", value, "by7");
            return (Criteria) this;
        }

        public Criteria andBy7In(List<String> values) {
            addCriterion("BY7 in", values, "by7");
            return (Criteria) this;
        }

        public Criteria andBy7NotIn(List<String> values) {
            addCriterion("BY7 not in", values, "by7");
            return (Criteria) this;
        }

        public Criteria andBy7Between(String value1, String value2) {
            addCriterion("BY7 between", value1, value2, "by7");
            return (Criteria) this;
        }

        public Criteria andBy7NotBetween(String value1, String value2) {
            addCriterion("BY7 not between", value1, value2, "by7");
            return (Criteria) this;
        }

        public Criteria andFssjIsNull() {
            addCriterion("FSSJ is null");
            return (Criteria) this;
        }

        public Criteria andFssjIsNotNull() {
            addCriterion("FSSJ is not null");
            return (Criteria) this;
        }

        public Criteria andFssjEqualTo(Date value) {
            addCriterionForJDBCDate("FSSJ =", value, "fssj");
            return (Criteria) this;
        }

        public Criteria andFssjNotEqualTo(Date value) {
            addCriterionForJDBCDate("FSSJ <>", value, "fssj");
            return (Criteria) this;
        }

        public Criteria andFssjGreaterThan(Date value) {
            addCriterionForJDBCDate("FSSJ >", value, "fssj");
            return (Criteria) this;
        }

        public Criteria andFssjGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("FSSJ >=", value, "fssj");
            return (Criteria) this;
        }

        public Criteria andFssjLessThan(Date value) {
            addCriterionForJDBCDate("FSSJ <", value, "fssj");
            return (Criteria) this;
        }

        public Criteria andFssjLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("FSSJ <=", value, "fssj");
            return (Criteria) this;
        }

        public Criteria andFssjIn(List<Date> values) {
            addCriterionForJDBCDate("FSSJ in", values, "fssj");
            return (Criteria) this;
        }

        public Criteria andFssjNotIn(List<Date> values) {
            addCriterionForJDBCDate("FSSJ not in", values, "fssj");
            return (Criteria) this;
        }

        public Criteria andFssjBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("FSSJ between", value1, value2, "fssj");
            return (Criteria) this;
        }

        public Criteria andFssjNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("FSSJ not between", value1, value2, "fssj");
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