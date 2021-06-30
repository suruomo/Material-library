package com.suruomo.material.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DisplacementRotationalMaxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DisplacementRotationalMaxExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(BigDecimal value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(BigDecimal value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(BigDecimal value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(BigDecimal value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<BigDecimal> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<BigDecimal> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdIsNull() {
            addCriterion("ANALYSIS_ID is null");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdIsNotNull() {
            addCriterion("ANALYSIS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdEqualTo(BigDecimal value) {
            addCriterion("ANALYSIS_ID =", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdNotEqualTo(BigDecimal value) {
            addCriterion("ANALYSIS_ID <>", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdGreaterThan(BigDecimal value) {
            addCriterion("ANALYSIS_ID >", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ANALYSIS_ID >=", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdLessThan(BigDecimal value) {
            addCriterion("ANALYSIS_ID <", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ANALYSIS_ID <=", value, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdIn(List<BigDecimal> values) {
            addCriterion("ANALYSIS_ID in", values, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdNotIn(List<BigDecimal> values) {
            addCriterion("ANALYSIS_ID not in", values, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ANALYSIS_ID between", value1, value2, "analysisId");
            return (Criteria) this;
        }

        public Criteria andAnalysisIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ANALYSIS_ID not between", value1, value2, "analysisId");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNull() {
            addCriterion("GROUP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNotNull() {
            addCriterion("GROUP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNameEqualTo(String value) {
            addCriterion("GROUP_NAME =", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotEqualTo(String value) {
            addCriterion("GROUP_NAME <>", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThan(String value) {
            addCriterion("GROUP_NAME >", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("GROUP_NAME >=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThan(String value) {
            addCriterion("GROUP_NAME <", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThanOrEqualTo(String value) {
            addCriterion("GROUP_NAME <=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLike(String value) {
            addCriterion("GROUP_NAME like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotLike(String value) {
            addCriterion("GROUP_NAME not like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameIn(List<String> values) {
            addCriterion("GROUP_NAME in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotIn(List<String> values) {
            addCriterion("GROUP_NAME not in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameBetween(String value1, String value2) {
            addCriterion("GROUP_NAME between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotBetween(String value1, String value2) {
            addCriterion("GROUP_NAME not between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andLoadcaseNameIsNull() {
            addCriterion("LOADCASE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andLoadcaseNameIsNotNull() {
            addCriterion("LOADCASE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andLoadcaseNameEqualTo(String value) {
            addCriterion("LOADCASE_NAME =", value, "loadcaseName");
            return (Criteria) this;
        }

        public Criteria andLoadcaseNameNotEqualTo(String value) {
            addCriterion("LOADCASE_NAME <>", value, "loadcaseName");
            return (Criteria) this;
        }

        public Criteria andLoadcaseNameGreaterThan(String value) {
            addCriterion("LOADCASE_NAME >", value, "loadcaseName");
            return (Criteria) this;
        }

        public Criteria andLoadcaseNameGreaterThanOrEqualTo(String value) {
            addCriterion("LOADCASE_NAME >=", value, "loadcaseName");
            return (Criteria) this;
        }

        public Criteria andLoadcaseNameLessThan(String value) {
            addCriterion("LOADCASE_NAME <", value, "loadcaseName");
            return (Criteria) this;
        }

        public Criteria andLoadcaseNameLessThanOrEqualTo(String value) {
            addCriterion("LOADCASE_NAME <=", value, "loadcaseName");
            return (Criteria) this;
        }

        public Criteria andLoadcaseNameLike(String value) {
            addCriterion("LOADCASE_NAME like", value, "loadcaseName");
            return (Criteria) this;
        }

        public Criteria andLoadcaseNameNotLike(String value) {
            addCriterion("LOADCASE_NAME not like", value, "loadcaseName");
            return (Criteria) this;
        }

        public Criteria andLoadcaseNameIn(List<String> values) {
            addCriterion("LOADCASE_NAME in", values, "loadcaseName");
            return (Criteria) this;
        }

        public Criteria andLoadcaseNameNotIn(List<String> values) {
            addCriterion("LOADCASE_NAME not in", values, "loadcaseName");
            return (Criteria) this;
        }

        public Criteria andLoadcaseNameBetween(String value1, String value2) {
            addCriterion("LOADCASE_NAME between", value1, value2, "loadcaseName");
            return (Criteria) this;
        }

        public Criteria andLoadcaseNameNotBetween(String value1, String value2) {
            addCriterion("LOADCASE_NAME not between", value1, value2, "loadcaseName");
            return (Criteria) this;
        }

        public Criteria andSubcaseNameIsNull() {
            addCriterion("SUBCASE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSubcaseNameIsNotNull() {
            addCriterion("SUBCASE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSubcaseNameEqualTo(String value) {
            addCriterion("SUBCASE_NAME =", value, "subcaseName");
            return (Criteria) this;
        }

        public Criteria andSubcaseNameNotEqualTo(String value) {
            addCriterion("SUBCASE_NAME <>", value, "subcaseName");
            return (Criteria) this;
        }

        public Criteria andSubcaseNameGreaterThan(String value) {
            addCriterion("SUBCASE_NAME >", value, "subcaseName");
            return (Criteria) this;
        }

        public Criteria andSubcaseNameGreaterThanOrEqualTo(String value) {
            addCriterion("SUBCASE_NAME >=", value, "subcaseName");
            return (Criteria) this;
        }

        public Criteria andSubcaseNameLessThan(String value) {
            addCriterion("SUBCASE_NAME <", value, "subcaseName");
            return (Criteria) this;
        }

        public Criteria andSubcaseNameLessThanOrEqualTo(String value) {
            addCriterion("SUBCASE_NAME <=", value, "subcaseName");
            return (Criteria) this;
        }

        public Criteria andSubcaseNameLike(String value) {
            addCriterion("SUBCASE_NAME like", value, "subcaseName");
            return (Criteria) this;
        }

        public Criteria andSubcaseNameNotLike(String value) {
            addCriterion("SUBCASE_NAME not like", value, "subcaseName");
            return (Criteria) this;
        }

        public Criteria andSubcaseNameIn(List<String> values) {
            addCriterion("SUBCASE_NAME in", values, "subcaseName");
            return (Criteria) this;
        }

        public Criteria andSubcaseNameNotIn(List<String> values) {
            addCriterion("SUBCASE_NAME not in", values, "subcaseName");
            return (Criteria) this;
        }

        public Criteria andSubcaseNameBetween(String value1, String value2) {
            addCriterion("SUBCASE_NAME between", value1, value2, "subcaseName");
            return (Criteria) this;
        }

        public Criteria andSubcaseNameNotBetween(String value1, String value2) {
            addCriterion("SUBCASE_NAME not between", value1, value2, "subcaseName");
            return (Criteria) this;
        }

        public Criteria andLayerNameIsNull() {
            addCriterion("LAYER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andLayerNameIsNotNull() {
            addCriterion("LAYER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andLayerNameEqualTo(String value) {
            addCriterion("LAYER_NAME =", value, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameNotEqualTo(String value) {
            addCriterion("LAYER_NAME <>", value, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameGreaterThan(String value) {
            addCriterion("LAYER_NAME >", value, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameGreaterThanOrEqualTo(String value) {
            addCriterion("LAYER_NAME >=", value, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameLessThan(String value) {
            addCriterion("LAYER_NAME <", value, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameLessThanOrEqualTo(String value) {
            addCriterion("LAYER_NAME <=", value, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameLike(String value) {
            addCriterion("LAYER_NAME like", value, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameNotLike(String value) {
            addCriterion("LAYER_NAME not like", value, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameIn(List<String> values) {
            addCriterion("LAYER_NAME in", values, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameNotIn(List<String> values) {
            addCriterion("LAYER_NAME not in", values, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameBetween(String value1, String value2) {
            addCriterion("LAYER_NAME between", value1, value2, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameNotBetween(String value1, String value2) {
            addCriterion("LAYER_NAME not between", value1, value2, "layerName");
            return (Criteria) this;
        }

        public Criteria andR1IsNull() {
            addCriterion("R1 is null");
            return (Criteria) this;
        }

        public Criteria andR1IsNotNull() {
            addCriterion("R1 is not null");
            return (Criteria) this;
        }

        public Criteria andR1EqualTo(String value) {
            addCriterion("R1 =", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1NotEqualTo(String value) {
            addCriterion("R1 <>", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1GreaterThan(String value) {
            addCriterion("R1 >", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1GreaterThanOrEqualTo(String value) {
            addCriterion("R1 >=", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1LessThan(String value) {
            addCriterion("R1 <", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1LessThanOrEqualTo(String value) {
            addCriterion("R1 <=", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1Like(String value) {
            addCriterion("R1 like", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1NotLike(String value) {
            addCriterion("R1 not like", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1In(List<String> values) {
            addCriterion("R1 in", values, "r1");
            return (Criteria) this;
        }

        public Criteria andR1NotIn(List<String> values) {
            addCriterion("R1 not in", values, "r1");
            return (Criteria) this;
        }

        public Criteria andR1Between(String value1, String value2) {
            addCriterion("R1 between", value1, value2, "r1");
            return (Criteria) this;
        }

        public Criteria andR1NotBetween(String value1, String value2) {
            addCriterion("R1 not between", value1, value2, "r1");
            return (Criteria) this;
        }

        public Criteria andR2IsNull() {
            addCriterion("R2 is null");
            return (Criteria) this;
        }

        public Criteria andR2IsNotNull() {
            addCriterion("R2 is not null");
            return (Criteria) this;
        }

        public Criteria andR2EqualTo(String value) {
            addCriterion("R2 =", value, "r2");
            return (Criteria) this;
        }

        public Criteria andR2NotEqualTo(String value) {
            addCriterion("R2 <>", value, "r2");
            return (Criteria) this;
        }

        public Criteria andR2GreaterThan(String value) {
            addCriterion("R2 >", value, "r2");
            return (Criteria) this;
        }

        public Criteria andR2GreaterThanOrEqualTo(String value) {
            addCriterion("R2 >=", value, "r2");
            return (Criteria) this;
        }

        public Criteria andR2LessThan(String value) {
            addCriterion("R2 <", value, "r2");
            return (Criteria) this;
        }

        public Criteria andR2LessThanOrEqualTo(String value) {
            addCriterion("R2 <=", value, "r2");
            return (Criteria) this;
        }

        public Criteria andR2Like(String value) {
            addCriterion("R2 like", value, "r2");
            return (Criteria) this;
        }

        public Criteria andR2NotLike(String value) {
            addCriterion("R2 not like", value, "r2");
            return (Criteria) this;
        }

        public Criteria andR2In(List<String> values) {
            addCriterion("R2 in", values, "r2");
            return (Criteria) this;
        }

        public Criteria andR2NotIn(List<String> values) {
            addCriterion("R2 not in", values, "r2");
            return (Criteria) this;
        }

        public Criteria andR2Between(String value1, String value2) {
            addCriterion("R2 between", value1, value2, "r2");
            return (Criteria) this;
        }

        public Criteria andR2NotBetween(String value1, String value2) {
            addCriterion("R2 not between", value1, value2, "r2");
            return (Criteria) this;
        }

        public Criteria andR3IsNull() {
            addCriterion("R3 is null");
            return (Criteria) this;
        }

        public Criteria andR3IsNotNull() {
            addCriterion("R3 is not null");
            return (Criteria) this;
        }

        public Criteria andR3EqualTo(String value) {
            addCriterion("R3 =", value, "r3");
            return (Criteria) this;
        }

        public Criteria andR3NotEqualTo(String value) {
            addCriterion("R3 <>", value, "r3");
            return (Criteria) this;
        }

        public Criteria andR3GreaterThan(String value) {
            addCriterion("R3 >", value, "r3");
            return (Criteria) this;
        }

        public Criteria andR3GreaterThanOrEqualTo(String value) {
            addCriterion("R3 >=", value, "r3");
            return (Criteria) this;
        }

        public Criteria andR3LessThan(String value) {
            addCriterion("R3 <", value, "r3");
            return (Criteria) this;
        }

        public Criteria andR3LessThanOrEqualTo(String value) {
            addCriterion("R3 <=", value, "r3");
            return (Criteria) this;
        }

        public Criteria andR3Like(String value) {
            addCriterion("R3 like", value, "r3");
            return (Criteria) this;
        }

        public Criteria andR3NotLike(String value) {
            addCriterion("R3 not like", value, "r3");
            return (Criteria) this;
        }

        public Criteria andR3In(List<String> values) {
            addCriterion("R3 in", values, "r3");
            return (Criteria) this;
        }

        public Criteria andR3NotIn(List<String> values) {
            addCriterion("R3 not in", values, "r3");
            return (Criteria) this;
        }

        public Criteria andR3Between(String value1, String value2) {
            addCriterion("R3 between", value1, value2, "r3");
            return (Criteria) this;
        }

        public Criteria andR3NotBetween(String value1, String value2) {
            addCriterion("R3 not between", value1, value2, "r3");
            return (Criteria) this;
        }

        public Criteria andMagnitudeIsNull() {
            addCriterion("MAGNITUDE is null");
            return (Criteria) this;
        }

        public Criteria andMagnitudeIsNotNull() {
            addCriterion("MAGNITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andMagnitudeEqualTo(String value) {
            addCriterion("MAGNITUDE =", value, "magnitude");
            return (Criteria) this;
        }

        public Criteria andMagnitudeNotEqualTo(String value) {
            addCriterion("MAGNITUDE <>", value, "magnitude");
            return (Criteria) this;
        }

        public Criteria andMagnitudeGreaterThan(String value) {
            addCriterion("MAGNITUDE >", value, "magnitude");
            return (Criteria) this;
        }

        public Criteria andMagnitudeGreaterThanOrEqualTo(String value) {
            addCriterion("MAGNITUDE >=", value, "magnitude");
            return (Criteria) this;
        }

        public Criteria andMagnitudeLessThan(String value) {
            addCriterion("MAGNITUDE <", value, "magnitude");
            return (Criteria) this;
        }

        public Criteria andMagnitudeLessThanOrEqualTo(String value) {
            addCriterion("MAGNITUDE <=", value, "magnitude");
            return (Criteria) this;
        }

        public Criteria andMagnitudeLike(String value) {
            addCriterion("MAGNITUDE like", value, "magnitude");
            return (Criteria) this;
        }

        public Criteria andMagnitudeNotLike(String value) {
            addCriterion("MAGNITUDE not like", value, "magnitude");
            return (Criteria) this;
        }

        public Criteria andMagnitudeIn(List<String> values) {
            addCriterion("MAGNITUDE in", values, "magnitude");
            return (Criteria) this;
        }

        public Criteria andMagnitudeNotIn(List<String> values) {
            addCriterion("MAGNITUDE not in", values, "magnitude");
            return (Criteria) this;
        }

        public Criteria andMagnitudeBetween(String value1, String value2) {
            addCriterion("MAGNITUDE between", value1, value2, "magnitude");
            return (Criteria) this;
        }

        public Criteria andMagnitudeNotBetween(String value1, String value2) {
            addCriterion("MAGNITUDE not between", value1, value2, "magnitude");
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