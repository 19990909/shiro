package springboot.oa.domain.function;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SysFunctionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String fields;

    public SysFunctionExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andFuncUrlIsNull() {
            addCriterion("FUNC_URL is null");
            return (Criteria) this;
        }

        public Criteria andFuncUrlIsNotNull() {
            addCriterion("FUNC_URL is not null");
            return (Criteria) this;
        }

        public Criteria andFuncUrlEqualTo(String value) {
            addCriterion("FUNC_URL =", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlNotEqualTo(String value) {
            addCriterion("FUNC_URL <>", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlGreaterThan(String value) {
            addCriterion("FUNC_URL >", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlGreaterThanOrEqualTo(String value) {
            addCriterion("FUNC_URL >=", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlLessThan(String value) {
            addCriterion("FUNC_URL <", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlLessThanOrEqualTo(String value) {
            addCriterion("FUNC_URL <=", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlLike(String value) {
            addCriterion("FUNC_URL like", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlNotLike(String value) {
            addCriterion("FUNC_URL not like", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlIn(List<String> values) {
            addCriterion("FUNC_URL in", values, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlNotIn(List<String> values) {
            addCriterion("FUNC_URL not in", values, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlBetween(String value1, String value2) {
            addCriterion("FUNC_URL between", value1, value2, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlNotBetween(String value1, String value2) {
            addCriterion("FUNC_URL not between", value1, value2, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncDescIsNull() {
            addCriterion("FUNC_DESC is null");
            return (Criteria) this;
        }

        public Criteria andFuncDescIsNotNull() {
            addCriterion("FUNC_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andFuncDescEqualTo(String value) {
            addCriterion("FUNC_DESC =", value, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescNotEqualTo(String value) {
            addCriterion("FUNC_DESC <>", value, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescGreaterThan(String value) {
            addCriterion("FUNC_DESC >", value, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescGreaterThanOrEqualTo(String value) {
            addCriterion("FUNC_DESC >=", value, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescLessThan(String value) {
            addCriterion("FUNC_DESC <", value, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescLessThanOrEqualTo(String value) {
            addCriterion("FUNC_DESC <=", value, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescLike(String value) {
            addCriterion("FUNC_DESC like", value, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescNotLike(String value) {
            addCriterion("FUNC_DESC not like", value, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescIn(List<String> values) {
            addCriterion("FUNC_DESC in", values, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescNotIn(List<String> values) {
            addCriterion("FUNC_DESC not in", values, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescBetween(String value1, String value2) {
            addCriterion("FUNC_DESC between", value1, value2, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncDescNotBetween(String value1, String value2) {
            addCriterion("FUNC_DESC not between", value1, value2, "funcDesc");
            return (Criteria) this;
        }

        public Criteria andFuncTypeIsNull() {
            addCriterion("FUNC_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andFuncTypeIsNotNull() {
            addCriterion("FUNC_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFuncTypeEqualTo(String value) {
            addCriterion("FUNC_TYPE =", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeNotEqualTo(String value) {
            addCriterion("FUNC_TYPE <>", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeGreaterThan(String value) {
            addCriterion("FUNC_TYPE >", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeGreaterThanOrEqualTo(String value) {
            addCriterion("FUNC_TYPE >=", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeLessThan(String value) {
            addCriterion("FUNC_TYPE <", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeLessThanOrEqualTo(String value) {
            addCriterion("FUNC_TYPE <=", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeLike(String value) {
            addCriterion("FUNC_TYPE like", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeNotLike(String value) {
            addCriterion("FUNC_TYPE not like", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeIn(List<String> values) {
            addCriterion("FUNC_TYPE in", values, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeNotIn(List<String> values) {
            addCriterion("FUNC_TYPE not in", values, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeBetween(String value1, String value2) {
            addCriterion("FUNC_TYPE between", value1, value2, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeNotBetween(String value1, String value2) {
            addCriterion("FUNC_TYPE not between", value1, value2, "funcType");
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

        public Criteria andIsParentIsNull() {
            addCriterion("IS_PARENT is null");
            return (Criteria) this;
        }

        public Criteria andIsParentIsNotNull() {
            addCriterion("IS_PARENT is not null");
            return (Criteria) this;
        }

        public Criteria andIsParentEqualTo(String value) {
            addCriterion("IS_PARENT =", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentNotEqualTo(String value) {
            addCriterion("IS_PARENT <>", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentGreaterThan(String value) {
            addCriterion("IS_PARENT >", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentGreaterThanOrEqualTo(String value) {
            addCriterion("IS_PARENT >=", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentLessThan(String value) {
            addCriterion("IS_PARENT <", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentLessThanOrEqualTo(String value) {
            addCriterion("IS_PARENT <=", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentLike(String value) {
            addCriterion("IS_PARENT like", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentNotLike(String value) {
            addCriterion("IS_PARENT not like", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentIn(List<String> values) {
            addCriterion("IS_PARENT in", values, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentNotIn(List<String> values) {
            addCriterion("IS_PARENT not in", values, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentBetween(String value1, String value2) {
            addCriterion("IS_PARENT between", value1, value2, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentNotBetween(String value1, String value2) {
            addCriterion("IS_PARENT not between", value1, value2, "isParent");
            return (Criteria) this;
        }

        public Criteria andOpenIsNull() {
            addCriterion("OPEN is null");
            return (Criteria) this;
        }

        public Criteria andOpenIsNotNull() {
            addCriterion("OPEN is not null");
            return (Criteria) this;
        }

        public Criteria andOpenEqualTo(String value) {
            addCriterion("OPEN =", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenNotEqualTo(String value) {
            addCriterion("OPEN <>", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenGreaterThan(String value) {
            addCriterion("OPEN >", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenGreaterThanOrEqualTo(String value) {
            addCriterion("OPEN >=", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenLessThan(String value) {
            addCriterion("OPEN <", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenLessThanOrEqualTo(String value) {
            addCriterion("OPEN <=", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenLike(String value) {
            addCriterion("OPEN like", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenNotLike(String value) {
            addCriterion("OPEN not like", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenIn(List<String> values) {
            addCriterion("OPEN in", values, "open");
            return (Criteria) this;
        }

        public Criteria andOpenNotIn(List<String> values) {
            addCriterion("OPEN not in", values, "open");
            return (Criteria) this;
        }

        public Criteria andOpenBetween(String value1, String value2) {
            addCriterion("OPEN between", value1, value2, "open");
            return (Criteria) this;
        }

        public Criteria andOpenNotBetween(String value1, String value2) {
            addCriterion("OPEN not between", value1, value2, "open");
            return (Criteria) this;
        }

        public Criteria andClassfieldIsNull() {
            addCriterion("CLASSFIELD is null");
            return (Criteria) this;
        }

        public Criteria andClassfieldIsNotNull() {
            addCriterion("CLASSFIELD is not null");
            return (Criteria) this;
        }

        public Criteria andClassfieldEqualTo(String value) {
            addCriterion("CLASSFIELD =", value, "classfield");
            return (Criteria) this;
        }

        public Criteria andClassfieldNotEqualTo(String value) {
            addCriterion("CLASSFIELD <>", value, "classfield");
            return (Criteria) this;
        }

        public Criteria andClassfieldGreaterThan(String value) {
            addCriterion("CLASSFIELD >", value, "classfield");
            return (Criteria) this;
        }

        public Criteria andClassfieldGreaterThanOrEqualTo(String value) {
            addCriterion("CLASSFIELD >=", value, "classfield");
            return (Criteria) this;
        }

        public Criteria andClassfieldLessThan(String value) {
            addCriterion("CLASSFIELD <", value, "classfield");
            return (Criteria) this;
        }

        public Criteria andClassfieldLessThanOrEqualTo(String value) {
            addCriterion("CLASSFIELD <=", value, "classfield");
            return (Criteria) this;
        }

        public Criteria andClassfieldLike(String value) {
            addCriterion("CLASSFIELD like", value, "classfield");
            return (Criteria) this;
        }

        public Criteria andClassfieldNotLike(String value) {
            addCriterion("CLASSFIELD not like", value, "classfield");
            return (Criteria) this;
        }

        public Criteria andClassfieldIn(List<String> values) {
            addCriterion("CLASSFIELD in", values, "classfield");
            return (Criteria) this;
        }

        public Criteria andClassfieldNotIn(List<String> values) {
            addCriterion("CLASSFIELD not in", values, "classfield");
            return (Criteria) this;
        }

        public Criteria andClassfieldBetween(String value1, String value2) {
            addCriterion("CLASSFIELD between", value1, value2, "classfield");
            return (Criteria) this;
        }

        public Criteria andClassfieldNotBetween(String value1, String value2) {
            addCriterion("CLASSFIELD not between", value1, value2, "classfield");
            return (Criteria) this;
        }

        public Criteria andSiteIdIsNull() {
            addCriterion("SITE_ID is null");
            return (Criteria) this;
        }

        public Criteria andSiteIdIsNotNull() {
            addCriterion("SITE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSiteIdEqualTo(String value) {
            addCriterion("SITE_ID =", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotEqualTo(String value) {
            addCriterion("SITE_ID <>", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdGreaterThan(String value) {
            addCriterion("SITE_ID >", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdGreaterThanOrEqualTo(String value) {
            addCriterion("SITE_ID >=", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdLessThan(String value) {
            addCriterion("SITE_ID <", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdLessThanOrEqualTo(String value) {
            addCriterion("SITE_ID <=", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdLike(String value) {
            addCriterion("SITE_ID like", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotLike(String value) {
            addCriterion("SITE_ID not like", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdIn(List<String> values) {
            addCriterion("SITE_ID in", values, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotIn(List<String> values) {
            addCriterion("SITE_ID not in", values, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdBetween(String value1, String value2) {
            addCriterion("SITE_ID between", value1, value2, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotBetween(String value1, String value2) {
            addCriterion("SITE_ID not between", value1, value2, "siteId");
            return (Criteria) this;
        }

        public Criteria andPidNameIsNull() {
            addCriterion("pidName is null");
            return (Criteria) this;
        }

        public Criteria andPidNameIsNotNull() {
            addCriterion("pidName is not null");
            return (Criteria) this;
        }

        public Criteria andPidNameEqualTo(String value) {
            addCriterion("pidName =", value, "pidName");
            return (Criteria) this;
        }

        public Criteria andPidNameNotEqualTo(String value) {
            addCriterion("pidName <>", value, "pidName");
            return (Criteria) this;
        }

        public Criteria andPidNameGreaterThan(String value) {
            addCriterion("pidName >", value, "pidName");
            return (Criteria) this;
        }

        public Criteria andPidNameGreaterThanOrEqualTo(String value) {
            addCriterion("pidName >=", value, "pidName");
            return (Criteria) this;
        }

        public Criteria andPidNameLessThan(String value) {
            addCriterion("pidName <", value, "pidName");
            return (Criteria) this;
        }

        public Criteria andPidNameLessThanOrEqualTo(String value) {
            addCriterion("pidName <=", value, "pidName");
            return (Criteria) this;
        }

        public Criteria andPidNameLike(String value) {
            addCriterion("pidName like", value, "pidName");
            return (Criteria) this;
        }

        public Criteria andPidNameNotLike(String value) {
            addCriterion("pidName not like", value, "pidName");
            return (Criteria) this;
        }

        public Criteria andPidNameIn(List<String> values) {
            addCriterion("pidName in", values, "pidName");
            return (Criteria) this;
        }

        public Criteria andPidNameNotIn(List<String> values) {
            addCriterion("pidName not in", values, "pidName");
            return (Criteria) this;
        }

        public Criteria andPidNameBetween(String value1, String value2) {
            addCriterion("pidName between", value1, value2, "pidName");
            return (Criteria) this;
        }

        public Criteria andPidNameNotBetween(String value1, String value2) {
            addCriterion("pidName not between", value1, value2, "pidName");
            return (Criteria) this;
        }

        /************/
        public Criteria andIsleafIsNull() {
            addCriterion("isleaf is null");
            return (Criteria) this;
        }

        public Criteria andIsleafIsNotNull() {
            addCriterion("isleaf is not null");
            return (Criteria) this;
        }

        public Criteria andIsleafEqualTo(String value) {
            addCriterion("isleaf =", value, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafNotEqualTo(String value) {
            addCriterion("isleaf <>", value, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafGreaterThan(String value) {
            addCriterion("isleaf >", value, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafGreaterThanOrEqualTo(String value) {
            addCriterion("isleaf >=", value, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafLessThan(String value) {
            addCriterion("isleaf <", value, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafLessThanOrEqualTo(String value) {
            addCriterion("isleaf <=", value, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafLike(String value) {
            addCriterion("isleaf like", value, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafNotLike(String value) {
            addCriterion("isleaf not like", value, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafIn(List<String> values) {
            addCriterion("isleaf in", values, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafNotIn(List<String> values) {
            addCriterion("isleaf not in", values, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafBetween(String value1, String value2) {
            addCriterion("isleaf between", value1, value2, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafNotBetween(String value1, String value2) {
            addCriterion("isleaf not between", value1, value2, "isleaf");
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