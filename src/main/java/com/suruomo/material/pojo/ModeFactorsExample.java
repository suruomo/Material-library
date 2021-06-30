package com.suruomo.material.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ModeFactorsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModeFactorsExample() {
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

        public Criteria andModeNoIsNull() {
            addCriterion("MODE_NO is null");
            return (Criteria) this;
        }

        public Criteria andModeNoIsNotNull() {
            addCriterion("MODE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andModeNoEqualTo(BigDecimal value) {
            addCriterion("MODE_NO =", value, "modeNo");
            return (Criteria) this;
        }

        public Criteria andModeNoNotEqualTo(BigDecimal value) {
            addCriterion("MODE_NO <>", value, "modeNo");
            return (Criteria) this;
        }

        public Criteria andModeNoGreaterThan(BigDecimal value) {
            addCriterion("MODE_NO >", value, "modeNo");
            return (Criteria) this;
        }

        public Criteria andModeNoGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MODE_NO >=", value, "modeNo");
            return (Criteria) this;
        }

        public Criteria andModeNoLessThan(BigDecimal value) {
            addCriterion("MODE_NO <", value, "modeNo");
            return (Criteria) this;
        }

        public Criteria andModeNoLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MODE_NO <=", value, "modeNo");
            return (Criteria) this;
        }

        public Criteria andModeNoIn(List<BigDecimal> values) {
            addCriterion("MODE_NO in", values, "modeNo");
            return (Criteria) this;
        }

        public Criteria andModeNoNotIn(List<BigDecimal> values) {
            addCriterion("MODE_NO not in", values, "modeNo");
            return (Criteria) this;
        }

        public Criteria andModeNoBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MODE_NO between", value1, value2, "modeNo");
            return (Criteria) this;
        }

        public Criteria andModeNoNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MODE_NO not between", value1, value2, "modeNo");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNull() {
            addCriterion("FREQUENCY is null");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNotNull() {
            addCriterion("FREQUENCY is not null");
            return (Criteria) this;
        }

        public Criteria andFrequencyEqualTo(BigDecimal value) {
            addCriterion("FREQUENCY =", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotEqualTo(BigDecimal value) {
            addCriterion("FREQUENCY <>", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThan(BigDecimal value) {
            addCriterion("FREQUENCY >", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FREQUENCY >=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThan(BigDecimal value) {
            addCriterion("FREQUENCY <", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FREQUENCY <=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyIn(List<BigDecimal> values) {
            addCriterion("FREQUENCY in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotIn(List<BigDecimal> values) {
            addCriterion("FREQUENCY not in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FREQUENCY between", value1, value2, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FREQUENCY not between", value1, value2, "frequency");
            return (Criteria) this;
        }

        public Criteria andT1IsNull() {
            addCriterion("T1 is null");
            return (Criteria) this;
        }

        public Criteria andT1IsNotNull() {
            addCriterion("T1 is not null");
            return (Criteria) this;
        }

        public Criteria andT1EqualTo(String value) {
            addCriterion("T1 =", value, "t1");
            return (Criteria) this;
        }

        public Criteria andT1NotEqualTo(String value) {
            addCriterion("T1 <>", value, "t1");
            return (Criteria) this;
        }

        public Criteria andT1GreaterThan(String value) {
            addCriterion("T1 >", value, "t1");
            return (Criteria) this;
        }

        public Criteria andT1GreaterThanOrEqualTo(String value) {
            addCriterion("T1 >=", value, "t1");
            return (Criteria) this;
        }

        public Criteria andT1LessThan(String value) {
            addCriterion("T1 <", value, "t1");
            return (Criteria) this;
        }

        public Criteria andT1LessThanOrEqualTo(String value) {
            addCriterion("T1 <=", value, "t1");
            return (Criteria) this;
        }

        public Criteria andT1Like(String value) {
            addCriterion("T1 like", value, "t1");
            return (Criteria) this;
        }

        public Criteria andT1NotLike(String value) {
            addCriterion("T1 not like", value, "t1");
            return (Criteria) this;
        }

        public Criteria andT1In(List<String> values) {
            addCriterion("T1 in", values, "t1");
            return (Criteria) this;
        }

        public Criteria andT1NotIn(List<String> values) {
            addCriterion("T1 not in", values, "t1");
            return (Criteria) this;
        }

        public Criteria andT1Between(String value1, String value2) {
            addCriterion("T1 between", value1, value2, "t1");
            return (Criteria) this;
        }

        public Criteria andT1NotBetween(String value1, String value2) {
            addCriterion("T1 not between", value1, value2, "t1");
            return (Criteria) this;
        }

        public Criteria andT2IsNull() {
            addCriterion("T2 is null");
            return (Criteria) this;
        }

        public Criteria andT2IsNotNull() {
            addCriterion("T2 is not null");
            return (Criteria) this;
        }

        public Criteria andT2EqualTo(String value) {
            addCriterion("T2 =", value, "t2");
            return (Criteria) this;
        }

        public Criteria andT2NotEqualTo(String value) {
            addCriterion("T2 <>", value, "t2");
            return (Criteria) this;
        }

        public Criteria andT2GreaterThan(String value) {
            addCriterion("T2 >", value, "t2");
            return (Criteria) this;
        }

        public Criteria andT2GreaterThanOrEqualTo(String value) {
            addCriterion("T2 >=", value, "t2");
            return (Criteria) this;
        }

        public Criteria andT2LessThan(String value) {
            addCriterion("T2 <", value, "t2");
            return (Criteria) this;
        }

        public Criteria andT2LessThanOrEqualTo(String value) {
            addCriterion("T2 <=", value, "t2");
            return (Criteria) this;
        }

        public Criteria andT2Like(String value) {
            addCriterion("T2 like", value, "t2");
            return (Criteria) this;
        }

        public Criteria andT2NotLike(String value) {
            addCriterion("T2 not like", value, "t2");
            return (Criteria) this;
        }

        public Criteria andT2In(List<String> values) {
            addCriterion("T2 in", values, "t2");
            return (Criteria) this;
        }

        public Criteria andT2NotIn(List<String> values) {
            addCriterion("T2 not in", values, "t2");
            return (Criteria) this;
        }

        public Criteria andT2Between(String value1, String value2) {
            addCriterion("T2 between", value1, value2, "t2");
            return (Criteria) this;
        }

        public Criteria andT2NotBetween(String value1, String value2) {
            addCriterion("T2 not between", value1, value2, "t2");
            return (Criteria) this;
        }

        public Criteria andT3IsNull() {
            addCriterion("T3 is null");
            return (Criteria) this;
        }

        public Criteria andT3IsNotNull() {
            addCriterion("T3 is not null");
            return (Criteria) this;
        }

        public Criteria andT3EqualTo(String value) {
            addCriterion("T3 =", value, "t3");
            return (Criteria) this;
        }

        public Criteria andT3NotEqualTo(String value) {
            addCriterion("T3 <>", value, "t3");
            return (Criteria) this;
        }

        public Criteria andT3GreaterThan(String value) {
            addCriterion("T3 >", value, "t3");
            return (Criteria) this;
        }

        public Criteria andT3GreaterThanOrEqualTo(String value) {
            addCriterion("T3 >=", value, "t3");
            return (Criteria) this;
        }

        public Criteria andT3LessThan(String value) {
            addCriterion("T3 <", value, "t3");
            return (Criteria) this;
        }

        public Criteria andT3LessThanOrEqualTo(String value) {
            addCriterion("T3 <=", value, "t3");
            return (Criteria) this;
        }

        public Criteria andT3Like(String value) {
            addCriterion("T3 like", value, "t3");
            return (Criteria) this;
        }

        public Criteria andT3NotLike(String value) {
            addCriterion("T3 not like", value, "t3");
            return (Criteria) this;
        }

        public Criteria andT3In(List<String> values) {
            addCriterion("T3 in", values, "t3");
            return (Criteria) this;
        }

        public Criteria andT3NotIn(List<String> values) {
            addCriterion("T3 not in", values, "t3");
            return (Criteria) this;
        }

        public Criteria andT3Between(String value1, String value2) {
            addCriterion("T3 between", value1, value2, "t3");
            return (Criteria) this;
        }

        public Criteria andT3NotBetween(String value1, String value2) {
            addCriterion("T3 not between", value1, value2, "t3");
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