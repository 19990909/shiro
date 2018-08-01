package springboot.oa.domain.org;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SysOrgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String fields;

    public SysOrgExample() {
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

        public Criteria andOrgNameIsNull() {
            addCriterion("ORG_NAME is null");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNotNull() {
            addCriterion("ORG_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andOrgNameEqualTo(String value) {
            addCriterion("ORG_NAME =", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotEqualTo(String value) {
            addCriterion("ORG_NAME <>", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThan(String value) {
            addCriterion("ORG_NAME >", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_NAME >=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThan(String value) {
            addCriterion("ORG_NAME <", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThanOrEqualTo(String value) {
            addCriterion("ORG_NAME <=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLike(String value) {
            addCriterion("ORG_NAME like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotLike(String value) {
            addCriterion("ORG_NAME not like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameIn(List<String> values) {
            addCriterion("ORG_NAME in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotIn(List<String> values) {
            addCriterion("ORG_NAME not in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameBetween(String value1, String value2) {
            addCriterion("ORG_NAME between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotBetween(String value1, String value2) {
            addCriterion("ORG_NAME not between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgTelIsNull() {
            addCriterion("ORG_TEL is null");
            return (Criteria) this;
        }

        public Criteria andOrgTelIsNotNull() {
            addCriterion("ORG_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andOrgTelEqualTo(String value) {
            addCriterion("ORG_TEL =", value, "orgTel");
            return (Criteria) this;
        }

        public Criteria andOrgTelNotEqualTo(String value) {
            addCriterion("ORG_TEL <>", value, "orgTel");
            return (Criteria) this;
        }

        public Criteria andOrgTelGreaterThan(String value) {
            addCriterion("ORG_TEL >", value, "orgTel");
            return (Criteria) this;
        }

        public Criteria andOrgTelGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_TEL >=", value, "orgTel");
            return (Criteria) this;
        }

        public Criteria andOrgTelLessThan(String value) {
            addCriterion("ORG_TEL <", value, "orgTel");
            return (Criteria) this;
        }

        public Criteria andOrgTelLessThanOrEqualTo(String value) {
            addCriterion("ORG_TEL <=", value, "orgTel");
            return (Criteria) this;
        }

        public Criteria andOrgTelLike(String value) {
            addCriterion("ORG_TEL like", value, "orgTel");
            return (Criteria) this;
        }

        public Criteria andOrgTelNotLike(String value) {
            addCriterion("ORG_TEL not like", value, "orgTel");
            return (Criteria) this;
        }

        public Criteria andOrgTelIn(List<String> values) {
            addCriterion("ORG_TEL in", values, "orgTel");
            return (Criteria) this;
        }

        public Criteria andOrgTelNotIn(List<String> values) {
            addCriterion("ORG_TEL not in", values, "orgTel");
            return (Criteria) this;
        }

        public Criteria andOrgTelBetween(String value1, String value2) {
            addCriterion("ORG_TEL between", value1, value2, "orgTel");
            return (Criteria) this;
        }

        public Criteria andOrgTelNotBetween(String value1, String value2) {
            addCriterion("ORG_TEL not between", value1, value2, "orgTel");
            return (Criteria) this;
        }

        public Criteria andOrgAddressIsNull() {
            addCriterion("ORG_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andOrgAddressIsNotNull() {
            addCriterion("ORG_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andOrgAddressEqualTo(String value) {
            addCriterion("ORG_ADDRESS =", value, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressNotEqualTo(String value) {
            addCriterion("ORG_ADDRESS <>", value, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressGreaterThan(String value) {
            addCriterion("ORG_ADDRESS >", value, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_ADDRESS >=", value, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressLessThan(String value) {
            addCriterion("ORG_ADDRESS <", value, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressLessThanOrEqualTo(String value) {
            addCriterion("ORG_ADDRESS <=", value, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressLike(String value) {
            addCriterion("ORG_ADDRESS like", value, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressNotLike(String value) {
            addCriterion("ORG_ADDRESS not like", value, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressIn(List<String> values) {
            addCriterion("ORG_ADDRESS in", values, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressNotIn(List<String> values) {
            addCriterion("ORG_ADDRESS not in", values, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressBetween(String value1, String value2) {
            addCriterion("ORG_ADDRESS between", value1, value2, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgAddressNotBetween(String value1, String value2) {
            addCriterion("ORG_ADDRESS not between", value1, value2, "orgAddress");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIsNull() {
            addCriterion("ORG_CODE is null");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIsNotNull() {
            addCriterion("ORG_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andOrgCodeEqualTo(String value) {
            addCriterion("ORG_CODE =", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotEqualTo(String value) {
            addCriterion("ORG_CODE <>", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThan(String value) {
            addCriterion("ORG_CODE >", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_CODE >=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThan(String value) {
            addCriterion("ORG_CODE <", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThanOrEqualTo(String value) {
            addCriterion("ORG_CODE <=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLike(String value) {
            addCriterion("ORG_CODE like", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotLike(String value) {
            addCriterion("ORG_CODE not like", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIn(List<String> values) {
            addCriterion("ORG_CODE in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotIn(List<String> values) {
            addCriterion("ORG_CODE not in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeBetween(String value1, String value2) {
            addCriterion("ORG_CODE between", value1, value2, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotBetween(String value1, String value2) {
            addCriterion("ORG_CODE not between", value1, value2, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgStatusIsNull() {
            addCriterion("ORG_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andOrgStatusIsNotNull() {
            addCriterion("ORG_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andOrgStatusEqualTo(String value) {
            addCriterion("ORG_STATUS =", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusNotEqualTo(String value) {
            addCriterion("ORG_STATUS <>", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusGreaterThan(String value) {
            addCriterion("ORG_STATUS >", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_STATUS >=", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusLessThan(String value) {
            addCriterion("ORG_STATUS <", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusLessThanOrEqualTo(String value) {
            addCriterion("ORG_STATUS <=", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusLike(String value) {
            addCriterion("ORG_STATUS like", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusNotLike(String value) {
            addCriterion("ORG_STATUS not like", value, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusIn(List<String> values) {
            addCriterion("ORG_STATUS in", values, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusNotIn(List<String> values) {
            addCriterion("ORG_STATUS not in", values, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusBetween(String value1, String value2) {
            addCriterion("ORG_STATUS between", value1, value2, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgStatusNotBetween(String value1, String value2) {
            addCriterion("ORG_STATUS not between", value1, value2, "orgStatus");
            return (Criteria) this;
        }

        public Criteria andOrgBzIsNull() {
            addCriterion("ORG_BZ is null");
            return (Criteria) this;
        }

        public Criteria andOrgBzIsNotNull() {
            addCriterion("ORG_BZ is not null");
            return (Criteria) this;
        }

        public Criteria andOrgBzEqualTo(String value) {
            addCriterion("ORG_BZ =", value, "orgBz");
            return (Criteria) this;
        }

        public Criteria andOrgBzNotEqualTo(String value) {
            addCriterion("ORG_BZ <>", value, "orgBz");
            return (Criteria) this;
        }

        public Criteria andOrgBzGreaterThan(String value) {
            addCriterion("ORG_BZ >", value, "orgBz");
            return (Criteria) this;
        }

        public Criteria andOrgBzGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_BZ >=", value, "orgBz");
            return (Criteria) this;
        }

        public Criteria andOrgBzLessThan(String value) {
            addCriterion("ORG_BZ <", value, "orgBz");
            return (Criteria) this;
        }

        public Criteria andOrgBzLessThanOrEqualTo(String value) {
            addCriterion("ORG_BZ <=", value, "orgBz");
            return (Criteria) this;
        }

        public Criteria andOrgBzLike(String value) {
            addCriterion("ORG_BZ like", value, "orgBz");
            return (Criteria) this;
        }

        public Criteria andOrgBzNotLike(String value) {
            addCriterion("ORG_BZ not like", value, "orgBz");
            return (Criteria) this;
        }

        public Criteria andOrgBzIn(List<String> values) {
            addCriterion("ORG_BZ in", values, "orgBz");
            return (Criteria) this;
        }

        public Criteria andOrgBzNotIn(List<String> values) {
            addCriterion("ORG_BZ not in", values, "orgBz");
            return (Criteria) this;
        }

        public Criteria andOrgBzBetween(String value1, String value2) {
            addCriterion("ORG_BZ between", value1, value2, "orgBz");
            return (Criteria) this;
        }

        public Criteria andOrgBzNotBetween(String value1, String value2) {
            addCriterion("ORG_BZ not between", value1, value2, "orgBz");
            return (Criteria) this;
        }

        public Criteria andOrgCreateuserIsNull() {
            addCriterion("ORG_CREATEUSER is null");
            return (Criteria) this;
        }

        public Criteria andOrgCreateuserIsNotNull() {
            addCriterion("ORG_CREATEUSER is not null");
            return (Criteria) this;
        }

        public Criteria andOrgCreateuserEqualTo(String value) {
            addCriterion("ORG_CREATEUSER =", value, "orgCreateuser");
            return (Criteria) this;
        }

        public Criteria andOrgCreateuserNotEqualTo(String value) {
            addCriterion("ORG_CREATEUSER <>", value, "orgCreateuser");
            return (Criteria) this;
        }

        public Criteria andOrgCreateuserGreaterThan(String value) {
            addCriterion("ORG_CREATEUSER >", value, "orgCreateuser");
            return (Criteria) this;
        }

        public Criteria andOrgCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_CREATEUSER >=", value, "orgCreateuser");
            return (Criteria) this;
        }

        public Criteria andOrgCreateuserLessThan(String value) {
            addCriterion("ORG_CREATEUSER <", value, "orgCreateuser");
            return (Criteria) this;
        }

        public Criteria andOrgCreateuserLessThanOrEqualTo(String value) {
            addCriterion("ORG_CREATEUSER <=", value, "orgCreateuser");
            return (Criteria) this;
        }

        public Criteria andOrgCreateuserLike(String value) {
            addCriterion("ORG_CREATEUSER like", value, "orgCreateuser");
            return (Criteria) this;
        }

        public Criteria andOrgCreateuserNotLike(String value) {
            addCriterion("ORG_CREATEUSER not like", value, "orgCreateuser");
            return (Criteria) this;
        }

        public Criteria andOrgCreateuserIn(List<String> values) {
            addCriterion("ORG_CREATEUSER in", values, "orgCreateuser");
            return (Criteria) this;
        }

        public Criteria andOrgCreateuserNotIn(List<String> values) {
            addCriterion("ORG_CREATEUSER not in", values, "orgCreateuser");
            return (Criteria) this;
        }

        public Criteria andOrgCreateuserBetween(String value1, String value2) {
            addCriterion("ORG_CREATEUSER between", value1, value2, "orgCreateuser");
            return (Criteria) this;
        }

        public Criteria andOrgCreateuserNotBetween(String value1, String value2) {
            addCriterion("ORG_CREATEUSER not between", value1, value2, "orgCreateuser");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CREATETIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CREATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("CREATETIME =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("CREATETIME <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("CREATETIME >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATETIME >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterionForJDBCDate("CREATETIME <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATETIME <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("CREATETIME in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("CREATETIME not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATETIME between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATETIME not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andOrgRegionIdIsNull() {
            addCriterion("ORG_REGION_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrgRegionIdIsNotNull() {
            addCriterion("ORG_REGION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrgRegionIdEqualTo(String value) {
            addCriterion("ORG_REGION_ID =", value, "orgRegionId");
            return (Criteria) this;
        }

        public Criteria andOrgRegionIdNotEqualTo(String value) {
            addCriterion("ORG_REGION_ID <>", value, "orgRegionId");
            return (Criteria) this;
        }

        public Criteria andOrgRegionIdGreaterThan(String value) {
            addCriterion("ORG_REGION_ID >", value, "orgRegionId");
            return (Criteria) this;
        }

        public Criteria andOrgRegionIdGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_REGION_ID >=", value, "orgRegionId");
            return (Criteria) this;
        }

        public Criteria andOrgRegionIdLessThan(String value) {
            addCriterion("ORG_REGION_ID <", value, "orgRegionId");
            return (Criteria) this;
        }

        public Criteria andOrgRegionIdLessThanOrEqualTo(String value) {
            addCriterion("ORG_REGION_ID <=", value, "orgRegionId");
            return (Criteria) this;
        }

        public Criteria andOrgRegionIdLike(String value) {
            addCriterion("ORG_REGION_ID like", value, "orgRegionId");
            return (Criteria) this;
        }

        public Criteria andOrgRegionIdNotLike(String value) {
            addCriterion("ORG_REGION_ID not like", value, "orgRegionId");
            return (Criteria) this;
        }

        public Criteria andOrgRegionIdIn(List<String> values) {
            addCriterion("ORG_REGION_ID in", values, "orgRegionId");
            return (Criteria) this;
        }

        public Criteria andOrgRegionIdNotIn(List<String> values) {
            addCriterion("ORG_REGION_ID not in", values, "orgRegionId");
            return (Criteria) this;
        }

        public Criteria andOrgRegionIdBetween(String value1, String value2) {
            addCriterion("ORG_REGION_ID between", value1, value2, "orgRegionId");
            return (Criteria) this;
        }

        public Criteria andOrgRegionIdNotBetween(String value1, String value2) {
            addCriterion("ORG_REGION_ID not between", value1, value2, "orgRegionId");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("PID is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("PID is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(String value) {
            addCriterion("PID =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(String value) {
            addCriterion("PID <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(String value) {
            addCriterion("PID >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(String value) {
            addCriterion("PID >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(String value) {
            addCriterion("PID <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(String value) {
            addCriterion("PID <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLike(String value) {
            addCriterion("PID like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotLike(String value) {
            addCriterion("PID not like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<String> values) {
            addCriterion("PID in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<String> values) {
            addCriterion("PID not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(String value1, String value2) {
            addCriterion("PID between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(String value1, String value2) {
            addCriterion("PID not between", value1, value2, "pid");
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