package springboot.oa.domain.sjhj;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SysOaSjhjExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String fields;

    public SysOaSjhjExample() {
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

        public Criteria andPronameIsNull() {
            addCriterion("proName is null");
            return (Criteria) this;
        }

        public Criteria andPronameIsNotNull() {
            addCriterion("proName is not null");
            return (Criteria) this;
        }

        public Criteria andPronameEqualTo(String value) {
            addCriterion("proName =", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameNotEqualTo(String value) {
            addCriterion("proName <>", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameGreaterThan(String value) {
            addCriterion("proName >", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameGreaterThanOrEqualTo(String value) {
            addCriterion("proName >=", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameLessThan(String value) {
            addCriterion("proName <", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameLessThanOrEqualTo(String value) {
            addCriterion("proName <=", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameLike(String value) {
            addCriterion("proName like", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameNotLike(String value) {
            addCriterion("proName not like", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameIn(List<String> values) {
            addCriterion("proName in", values, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameNotIn(List<String> values) {
            addCriterion("proName not in", values, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameBetween(String value1, String value2) {
            addCriterion("proName between", value1, value2, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameNotBetween(String value1, String value2) {
            addCriterion("proName not between", value1, value2, "proname");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNull() {
            addCriterion("province_code is null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNotNull() {
            addCriterion("province_code is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeEqualTo(String value) {
            addCriterion("province_code =", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotEqualTo(String value) {
            addCriterion("province_code <>", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThan(String value) {
            addCriterion("province_code >", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("province_code >=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThan(String value) {
            addCriterion("province_code <", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThanOrEqualTo(String value) {
            addCriterion("province_code <=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLike(String value) {
            addCriterion("province_code like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotLike(String value) {
            addCriterion("province_code not like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIn(List<String> values) {
            addCriterion("province_code in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotIn(List<String> values) {
            addCriterion("province_code not in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeBetween(String value1, String value2) {
            addCriterion("province_code between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotBetween(String value1, String value2) {
            addCriterion("province_code not between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andCitynameIsNull() {
            addCriterion("cityName is null");
            return (Criteria) this;
        }

        public Criteria andCitynameIsNotNull() {
            addCriterion("cityName is not null");
            return (Criteria) this;
        }

        public Criteria andCitynameEqualTo(String value) {
            addCriterion("cityName =", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotEqualTo(String value) {
            addCriterion("cityName <>", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameGreaterThan(String value) {
            addCriterion("cityName >", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameGreaterThanOrEqualTo(String value) {
            addCriterion("cityName >=", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameLessThan(String value) {
            addCriterion("cityName <", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameLessThanOrEqualTo(String value) {
            addCriterion("cityName <=", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameLike(String value) {
            addCriterion("cityName like", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotLike(String value) {
            addCriterion("cityName not like", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameIn(List<String> values) {
            addCriterion("cityName in", values, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotIn(List<String> values) {
            addCriterion("cityName not in", values, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameBetween(String value1, String value2) {
            addCriterion("cityName between", value1, value2, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotBetween(String value1, String value2) {
            addCriterion("cityName not between", value1, value2, "cityname");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNull() {
            addCriterion("city_code is null");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNotNull() {
            addCriterion("city_code is not null");
            return (Criteria) this;
        }

        public Criteria andCityCodeEqualTo(String value) {
            addCriterion("city_code =", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotEqualTo(String value) {
            addCriterion("city_code <>", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThan(String value) {
            addCriterion("city_code >", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("city_code >=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThan(String value) {
            addCriterion("city_code <", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThanOrEqualTo(String value) {
            addCriterion("city_code <=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLike(String value) {
            addCriterion("city_code like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotLike(String value) {
            addCriterion("city_code not like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIn(List<String> values) {
            addCriterion("city_code in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotIn(List<String> values) {
            addCriterion("city_code not in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeBetween(String value1, String value2) {
            addCriterion("city_code between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotBetween(String value1, String value2) {
            addCriterion("city_code not between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andHjrxmIsNull() {
            addCriterion("hjrxm is null");
            return (Criteria) this;
        }

        public Criteria andHjrxmIsNotNull() {
            addCriterion("hjrxm is not null");
            return (Criteria) this;
        }

        public Criteria andHjrxmEqualTo(String value) {
            addCriterion("hjrxm =", value, "hjrxm");
            return (Criteria) this;
        }

        public Criteria andHjrxmNotEqualTo(String value) {
            addCriterion("hjrxm <>", value, "hjrxm");
            return (Criteria) this;
        }

        public Criteria andHjrxmGreaterThan(String value) {
            addCriterion("hjrxm >", value, "hjrxm");
            return (Criteria) this;
        }

        public Criteria andHjrxmGreaterThanOrEqualTo(String value) {
            addCriterion("hjrxm >=", value, "hjrxm");
            return (Criteria) this;
        }

        public Criteria andHjrxmLessThan(String value) {
            addCriterion("hjrxm <", value, "hjrxm");
            return (Criteria) this;
        }

        public Criteria andHjrxmLessThanOrEqualTo(String value) {
            addCriterion("hjrxm <=", value, "hjrxm");
            return (Criteria) this;
        }

        public Criteria andHjrxmLike(String value) {
            addCriterion("hjrxm like", value, "hjrxm");
            return (Criteria) this;
        }

        public Criteria andHjrxmNotLike(String value) {
            addCriterion("hjrxm not like", value, "hjrxm");
            return (Criteria) this;
        }

        public Criteria andHjrxmIn(List<String> values) {
            addCriterion("hjrxm in", values, "hjrxm");
            return (Criteria) this;
        }

        public Criteria andHjrxmNotIn(List<String> values) {
            addCriterion("hjrxm not in", values, "hjrxm");
            return (Criteria) this;
        }

        public Criteria andHjrxmBetween(String value1, String value2) {
            addCriterion("hjrxm between", value1, value2, "hjrxm");
            return (Criteria) this;
        }

        public Criteria andHjrxmNotBetween(String value1, String value2) {
            addCriterion("hjrxm not between", value1, value2, "hjrxm");
            return (Criteria) this;
        }

        public Criteria andHjrxmIdIsNull() {
            addCriterion("hjrxm_id is null");
            return (Criteria) this;
        }

        public Criteria andHjrxmIdIsNotNull() {
            addCriterion("hjrxm_id is not null");
            return (Criteria) this;
        }

        public Criteria andHjrxmIdEqualTo(String value) {
            addCriterion("hjrxm_id =", value, "hjrxmId");
            return (Criteria) this;
        }

        public Criteria andHjrxmIdNotEqualTo(String value) {
            addCriterion("hjrxm_id <>", value, "hjrxmId");
            return (Criteria) this;
        }

        public Criteria andHjrxmIdGreaterThan(String value) {
            addCriterion("hjrxm_id >", value, "hjrxmId");
            return (Criteria) this;
        }

        public Criteria andHjrxmIdGreaterThanOrEqualTo(String value) {
            addCriterion("hjrxm_id >=", value, "hjrxmId");
            return (Criteria) this;
        }

        public Criteria andHjrxmIdLessThan(String value) {
            addCriterion("hjrxm_id <", value, "hjrxmId");
            return (Criteria) this;
        }

        public Criteria andHjrxmIdLessThanOrEqualTo(String value) {
            addCriterion("hjrxm_id <=", value, "hjrxmId");
            return (Criteria) this;
        }

        public Criteria andHjrxmIdLike(String value) {
            addCriterion("hjrxm_id like", value, "hjrxmId");
            return (Criteria) this;
        }

        public Criteria andHjrxmIdNotLike(String value) {
            addCriterion("hjrxm_id not like", value, "hjrxmId");
            return (Criteria) this;
        }

        public Criteria andHjrxmIdIn(List<String> values) {
            addCriterion("hjrxm_id in", values, "hjrxmId");
            return (Criteria) this;
        }

        public Criteria andHjrxmIdNotIn(List<String> values) {
            addCriterion("hjrxm_id not in", values, "hjrxmId");
            return (Criteria) this;
        }

        public Criteria andHjrxmIdBetween(String value1, String value2) {
            addCriterion("hjrxm_id between", value1, value2, "hjrxmId");
            return (Criteria) this;
        }

        public Criteria andHjrxmIdNotBetween(String value1, String value2) {
            addCriterion("hjrxm_id not between", value1, value2, "hjrxmId");
            return (Criteria) this;
        }

        public Criteria andHjjzdmIsNull() {
            addCriterion("hjjzdm is null");
            return (Criteria) this;
        }

        public Criteria andHjjzdmIsNotNull() {
            addCriterion("hjjzdm is not null");
            return (Criteria) this;
        }

        public Criteria andHjjzdmEqualTo(String value) {
            addCriterion("hjjzdm =", value, "hjjzdm");
            return (Criteria) this;
        }

        public Criteria andHjjzdmNotEqualTo(String value) {
            addCriterion("hjjzdm <>", value, "hjjzdm");
            return (Criteria) this;
        }

        public Criteria andHjjzdmGreaterThan(String value) {
            addCriterion("hjjzdm >", value, "hjjzdm");
            return (Criteria) this;
        }

        public Criteria andHjjzdmGreaterThanOrEqualTo(String value) {
            addCriterion("hjjzdm >=", value, "hjjzdm");
            return (Criteria) this;
        }

        public Criteria andHjjzdmLessThan(String value) {
            addCriterion("hjjzdm <", value, "hjjzdm");
            return (Criteria) this;
        }

        public Criteria andHjjzdmLessThanOrEqualTo(String value) {
            addCriterion("hjjzdm <=", value, "hjjzdm");
            return (Criteria) this;
        }

        public Criteria andHjjzdmLike(String value) {
            addCriterion("hjjzdm like", value, "hjjzdm");
            return (Criteria) this;
        }

        public Criteria andHjjzdmNotLike(String value) {
            addCriterion("hjjzdm not like", value, "hjjzdm");
            return (Criteria) this;
        }

        public Criteria andHjjzdmIn(List<String> values) {
            addCriterion("hjjzdm in", values, "hjjzdm");
            return (Criteria) this;
        }

        public Criteria andHjjzdmNotIn(List<String> values) {
            addCriterion("hjjzdm not in", values, "hjjzdm");
            return (Criteria) this;
        }

        public Criteria andHjjzdmBetween(String value1, String value2) {
            addCriterion("hjjzdm between", value1, value2, "hjjzdm");
            return (Criteria) this;
        }

        public Criteria andHjjzdmNotBetween(String value1, String value2) {
            addCriterion("hjjzdm not between", value1, value2, "hjjzdm");
            return (Criteria) this;
        }

        public Criteria andHjjzdmIdIsNull() {
            addCriterion("hjjzdm_id is null");
            return (Criteria) this;
        }

        public Criteria andHjjzdmIdIsNotNull() {
            addCriterion("hjjzdm_id is not null");
            return (Criteria) this;
        }

        public Criteria andHjjzdmIdEqualTo(String value) {
            addCriterion("hjjzdm_id =", value, "hjjzdmId");
            return (Criteria) this;
        }

        public Criteria andHjjzdmIdNotEqualTo(String value) {
            addCriterion("hjjzdm_id <>", value, "hjjzdmId");
            return (Criteria) this;
        }

        public Criteria andHjjzdmIdGreaterThan(String value) {
            addCriterion("hjjzdm_id >", value, "hjjzdmId");
            return (Criteria) this;
        }

        public Criteria andHjjzdmIdGreaterThanOrEqualTo(String value) {
            addCriterion("hjjzdm_id >=", value, "hjjzdmId");
            return (Criteria) this;
        }

        public Criteria andHjjzdmIdLessThan(String value) {
            addCriterion("hjjzdm_id <", value, "hjjzdmId");
            return (Criteria) this;
        }

        public Criteria andHjjzdmIdLessThanOrEqualTo(String value) {
            addCriterion("hjjzdm_id <=", value, "hjjzdmId");
            return (Criteria) this;
        }

        public Criteria andHjjzdmIdLike(String value) {
            addCriterion("hjjzdm_id like", value, "hjjzdmId");
            return (Criteria) this;
        }

        public Criteria andHjjzdmIdNotLike(String value) {
            addCriterion("hjjzdm_id not like", value, "hjjzdmId");
            return (Criteria) this;
        }

        public Criteria andHjjzdmIdIn(List<String> values) {
            addCriterion("hjjzdm_id in", values, "hjjzdmId");
            return (Criteria) this;
        }

        public Criteria andHjjzdmIdNotIn(List<String> values) {
            addCriterion("hjjzdm_id not in", values, "hjjzdmId");
            return (Criteria) this;
        }

        public Criteria andHjjzdmIdBetween(String value1, String value2) {
            addCriterion("hjjzdm_id between", value1, value2, "hjjzdmId");
            return (Criteria) this;
        }

        public Criteria andHjjzdmIdNotBetween(String value1, String value2) {
            addCriterion("hjjzdm_id not between", value1, value2, "hjjzdmId");
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

        public Criteria andHjsjIsNull() {
            addCriterion("hjsj is null");
            return (Criteria) this;
        }

        public Criteria andHjsjIsNotNull() {
            addCriterion("hjsj is not null");
            return (Criteria) this;
        }

        public Criteria andHjsjEqualTo(Date value) {
            addCriterionForJDBCDate("hjsj =", value, "hjsj");
            return (Criteria) this;
        }

        public Criteria andHjsjNotEqualTo(Date value) {
            addCriterionForJDBCDate("hjsj <>", value, "hjsj");
            return (Criteria) this;
        }

        public Criteria andHjsjGreaterThan(Date value) {
            addCriterionForJDBCDate("hjsj >", value, "hjsj");
            return (Criteria) this;
        }

        public Criteria andHjsjGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("hjsj >=", value, "hjsj");
            return (Criteria) this;
        }

        public Criteria andHjsjLessThan(Date value) {
            addCriterionForJDBCDate("hjsj <", value, "hjsj");
            return (Criteria) this;
        }

        public Criteria andHjsjLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("hjsj <=", value, "hjsj");
            return (Criteria) this;
        }

        public Criteria andHjsjIn(List<Date> values) {
            addCriterionForJDBCDate("hjsj in", values, "hjsj");
            return (Criteria) this;
        }

        public Criteria andHjsjNotIn(List<Date> values) {
            addCriterionForJDBCDate("hjsj not in", values, "hjsj");
            return (Criteria) this;
        }

        public Criteria andHjsjBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("hjsj between", value1, value2, "hjsj");
            return (Criteria) this;
        }

        public Criteria andHjsjNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("hjsj not between", value1, value2, "hjsj");
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