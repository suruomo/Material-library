package com.suruomo.material.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StrainMaxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StrainMaxExample() {
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

        public Criteria andXIsNull() {
            addCriterion("X is null");
            return (Criteria) this;
        }

        public Criteria andXIsNotNull() {
            addCriterion("X is not null");
            return (Criteria) this;
        }

        public Criteria andXEqualTo(String value) {
            addCriterion("X =", value, "x");
            return (Criteria) this;
        }

        public Criteria andXNotEqualTo(String value) {
            addCriterion("X <>", value, "x");
            return (Criteria) this;
        }

        public Criteria andXGreaterThan(String value) {
            addCriterion("X >", value, "x");
            return (Criteria) this;
        }

        public Criteria andXGreaterThanOrEqualTo(String value) {
            addCriterion("X >=", value, "x");
            return (Criteria) this;
        }

        public Criteria andXLessThan(String value) {
            addCriterion("X <", value, "x");
            return (Criteria) this;
        }

        public Criteria andXLessThanOrEqualTo(String value) {
            addCriterion("X <=", value, "x");
            return (Criteria) this;
        }

        public Criteria andXLike(String value) {
            addCriterion("X like", value, "x");
            return (Criteria) this;
        }

        public Criteria andXNotLike(String value) {
            addCriterion("X not like", value, "x");
            return (Criteria) this;
        }

        public Criteria andXIn(List<String> values) {
            addCriterion("X in", values, "x");
            return (Criteria) this;
        }

        public Criteria andXNotIn(List<String> values) {
            addCriterion("X not in", values, "x");
            return (Criteria) this;
        }

        public Criteria andXBetween(String value1, String value2) {
            addCriterion("X between", value1, value2, "x");
            return (Criteria) this;
        }

        public Criteria andXNotBetween(String value1, String value2) {
            addCriterion("X not between", value1, value2, "x");
            return (Criteria) this;
        }

        public Criteria andYIsNull() {
            addCriterion("Y is null");
            return (Criteria) this;
        }

        public Criteria andYIsNotNull() {
            addCriterion("Y is not null");
            return (Criteria) this;
        }

        public Criteria andYEqualTo(String value) {
            addCriterion("Y =", value, "y");
            return (Criteria) this;
        }

        public Criteria andYNotEqualTo(String value) {
            addCriterion("Y <>", value, "y");
            return (Criteria) this;
        }

        public Criteria andYGreaterThan(String value) {
            addCriterion("Y >", value, "y");
            return (Criteria) this;
        }

        public Criteria andYGreaterThanOrEqualTo(String value) {
            addCriterion("Y >=", value, "y");
            return (Criteria) this;
        }

        public Criteria andYLessThan(String value) {
            addCriterion("Y <", value, "y");
            return (Criteria) this;
        }

        public Criteria andYLessThanOrEqualTo(String value) {
            addCriterion("Y <=", value, "y");
            return (Criteria) this;
        }

        public Criteria andYLike(String value) {
            addCriterion("Y like", value, "y");
            return (Criteria) this;
        }

        public Criteria andYNotLike(String value) {
            addCriterion("Y not like", value, "y");
            return (Criteria) this;
        }

        public Criteria andYIn(List<String> values) {
            addCriterion("Y in", values, "y");
            return (Criteria) this;
        }

        public Criteria andYNotIn(List<String> values) {
            addCriterion("Y not in", values, "y");
            return (Criteria) this;
        }

        public Criteria andYBetween(String value1, String value2) {
            addCriterion("Y between", value1, value2, "y");
            return (Criteria) this;
        }

        public Criteria andYNotBetween(String value1, String value2) {
            addCriterion("Y not between", value1, value2, "y");
            return (Criteria) this;
        }

        public Criteria andZIsNull() {
            addCriterion("Z is null");
            return (Criteria) this;
        }

        public Criteria andZIsNotNull() {
            addCriterion("Z is not null");
            return (Criteria) this;
        }

        public Criteria andZEqualTo(String value) {
            addCriterion("Z =", value, "z");
            return (Criteria) this;
        }

        public Criteria andZNotEqualTo(String value) {
            addCriterion("Z <>", value, "z");
            return (Criteria) this;
        }

        public Criteria andZGreaterThan(String value) {
            addCriterion("Z >", value, "z");
            return (Criteria) this;
        }

        public Criteria andZGreaterThanOrEqualTo(String value) {
            addCriterion("Z >=", value, "z");
            return (Criteria) this;
        }

        public Criteria andZLessThan(String value) {
            addCriterion("Z <", value, "z");
            return (Criteria) this;
        }

        public Criteria andZLessThanOrEqualTo(String value) {
            addCriterion("Z <=", value, "z");
            return (Criteria) this;
        }

        public Criteria andZLike(String value) {
            addCriterion("Z like", value, "z");
            return (Criteria) this;
        }

        public Criteria andZNotLike(String value) {
            addCriterion("Z not like", value, "z");
            return (Criteria) this;
        }

        public Criteria andZIn(List<String> values) {
            addCriterion("Z in", values, "z");
            return (Criteria) this;
        }

        public Criteria andZNotIn(List<String> values) {
            addCriterion("Z not in", values, "z");
            return (Criteria) this;
        }

        public Criteria andZBetween(String value1, String value2) {
            addCriterion("Z between", value1, value2, "z");
            return (Criteria) this;
        }

        public Criteria andZNotBetween(String value1, String value2) {
            addCriterion("Z not between", value1, value2, "z");
            return (Criteria) this;
        }

        public Criteria andXyIsNull() {
            addCriterion("XY is null");
            return (Criteria) this;
        }

        public Criteria andXyIsNotNull() {
            addCriterion("XY is not null");
            return (Criteria) this;
        }

        public Criteria andXyEqualTo(String value) {
            addCriterion("XY =", value, "xy");
            return (Criteria) this;
        }

        public Criteria andXyNotEqualTo(String value) {
            addCriterion("XY <>", value, "xy");
            return (Criteria) this;
        }

        public Criteria andXyGreaterThan(String value) {
            addCriterion("XY >", value, "xy");
            return (Criteria) this;
        }

        public Criteria andXyGreaterThanOrEqualTo(String value) {
            addCriterion("XY >=", value, "xy");
            return (Criteria) this;
        }

        public Criteria andXyLessThan(String value) {
            addCriterion("XY <", value, "xy");
            return (Criteria) this;
        }

        public Criteria andXyLessThanOrEqualTo(String value) {
            addCriterion("XY <=", value, "xy");
            return (Criteria) this;
        }

        public Criteria andXyLike(String value) {
            addCriterion("XY like", value, "xy");
            return (Criteria) this;
        }

        public Criteria andXyNotLike(String value) {
            addCriterion("XY not like", value, "xy");
            return (Criteria) this;
        }

        public Criteria andXyIn(List<String> values) {
            addCriterion("XY in", values, "xy");
            return (Criteria) this;
        }

        public Criteria andXyNotIn(List<String> values) {
            addCriterion("XY not in", values, "xy");
            return (Criteria) this;
        }

        public Criteria andXyBetween(String value1, String value2) {
            addCriterion("XY between", value1, value2, "xy");
            return (Criteria) this;
        }

        public Criteria andXyNotBetween(String value1, String value2) {
            addCriterion("XY not between", value1, value2, "xy");
            return (Criteria) this;
        }

        public Criteria andYzIsNull() {
            addCriterion("YZ is null");
            return (Criteria) this;
        }

        public Criteria andYzIsNotNull() {
            addCriterion("YZ is not null");
            return (Criteria) this;
        }

        public Criteria andYzEqualTo(String value) {
            addCriterion("YZ =", value, "yz");
            return (Criteria) this;
        }

        public Criteria andYzNotEqualTo(String value) {
            addCriterion("YZ <>", value, "yz");
            return (Criteria) this;
        }

        public Criteria andYzGreaterThan(String value) {
            addCriterion("YZ >", value, "yz");
            return (Criteria) this;
        }

        public Criteria andYzGreaterThanOrEqualTo(String value) {
            addCriterion("YZ >=", value, "yz");
            return (Criteria) this;
        }

        public Criteria andYzLessThan(String value) {
            addCriterion("YZ <", value, "yz");
            return (Criteria) this;
        }

        public Criteria andYzLessThanOrEqualTo(String value) {
            addCriterion("YZ <=", value, "yz");
            return (Criteria) this;
        }

        public Criteria andYzLike(String value) {
            addCriterion("YZ like", value, "yz");
            return (Criteria) this;
        }

        public Criteria andYzNotLike(String value) {
            addCriterion("YZ not like", value, "yz");
            return (Criteria) this;
        }

        public Criteria andYzIn(List<String> values) {
            addCriterion("YZ in", values, "yz");
            return (Criteria) this;
        }

        public Criteria andYzNotIn(List<String> values) {
            addCriterion("YZ not in", values, "yz");
            return (Criteria) this;
        }

        public Criteria andYzBetween(String value1, String value2) {
            addCriterion("YZ between", value1, value2, "yz");
            return (Criteria) this;
        }

        public Criteria andYzNotBetween(String value1, String value2) {
            addCriterion("YZ not between", value1, value2, "yz");
            return (Criteria) this;
        }

        public Criteria andZxIsNull() {
            addCriterion("ZX is null");
            return (Criteria) this;
        }

        public Criteria andZxIsNotNull() {
            addCriterion("ZX is not null");
            return (Criteria) this;
        }

        public Criteria andZxEqualTo(String value) {
            addCriterion("ZX =", value, "zx");
            return (Criteria) this;
        }

        public Criteria andZxNotEqualTo(String value) {
            addCriterion("ZX <>", value, "zx");
            return (Criteria) this;
        }

        public Criteria andZxGreaterThan(String value) {
            addCriterion("ZX >", value, "zx");
            return (Criteria) this;
        }

        public Criteria andZxGreaterThanOrEqualTo(String value) {
            addCriterion("ZX >=", value, "zx");
            return (Criteria) this;
        }

        public Criteria andZxLessThan(String value) {
            addCriterion("ZX <", value, "zx");
            return (Criteria) this;
        }

        public Criteria andZxLessThanOrEqualTo(String value) {
            addCriterion("ZX <=", value, "zx");
            return (Criteria) this;
        }

        public Criteria andZxLike(String value) {
            addCriterion("ZX like", value, "zx");
            return (Criteria) this;
        }

        public Criteria andZxNotLike(String value) {
            addCriterion("ZX not like", value, "zx");
            return (Criteria) this;
        }

        public Criteria andZxIn(List<String> values) {
            addCriterion("ZX in", values, "zx");
            return (Criteria) this;
        }

        public Criteria andZxNotIn(List<String> values) {
            addCriterion("ZX not in", values, "zx");
            return (Criteria) this;
        }

        public Criteria andZxBetween(String value1, String value2) {
            addCriterion("ZX between", value1, value2, "zx");
            return (Criteria) this;
        }

        public Criteria andZxNotBetween(String value1, String value2) {
            addCriterion("ZX not between", value1, value2, "zx");
            return (Criteria) this;
        }

        public Criteria andVonMisesIsNull() {
            addCriterion("VON_MISES is null");
            return (Criteria) this;
        }

        public Criteria andVonMisesIsNotNull() {
            addCriterion("VON_MISES is not null");
            return (Criteria) this;
        }

        public Criteria andVonMisesEqualTo(String value) {
            addCriterion("VON_MISES =", value, "vonMises");
            return (Criteria) this;
        }

        public Criteria andVonMisesNotEqualTo(String value) {
            addCriterion("VON_MISES <>", value, "vonMises");
            return (Criteria) this;
        }

        public Criteria andVonMisesGreaterThan(String value) {
            addCriterion("VON_MISES >", value, "vonMises");
            return (Criteria) this;
        }

        public Criteria andVonMisesGreaterThanOrEqualTo(String value) {
            addCriterion("VON_MISES >=", value, "vonMises");
            return (Criteria) this;
        }

        public Criteria andVonMisesLessThan(String value) {
            addCriterion("VON_MISES <", value, "vonMises");
            return (Criteria) this;
        }

        public Criteria andVonMisesLessThanOrEqualTo(String value) {
            addCriterion("VON_MISES <=", value, "vonMises");
            return (Criteria) this;
        }

        public Criteria andVonMisesLike(String value) {
            addCriterion("VON_MISES like", value, "vonMises");
            return (Criteria) this;
        }

        public Criteria andVonMisesNotLike(String value) {
            addCriterion("VON_MISES not like", value, "vonMises");
            return (Criteria) this;
        }

        public Criteria andVonMisesIn(List<String> values) {
            addCriterion("VON_MISES in", values, "vonMises");
            return (Criteria) this;
        }

        public Criteria andVonMisesNotIn(List<String> values) {
            addCriterion("VON_MISES not in", values, "vonMises");
            return (Criteria) this;
        }

        public Criteria andVonMisesBetween(String value1, String value2) {
            addCriterion("VON_MISES between", value1, value2, "vonMises");
            return (Criteria) this;
        }

        public Criteria andVonMisesNotBetween(String value1, String value2) {
            addCriterion("VON_MISES not between", value1, value2, "vonMises");
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