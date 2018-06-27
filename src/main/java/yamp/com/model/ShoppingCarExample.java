package yamp.com.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCarExample  extends BaseExample{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table shopping_car
     *
     * @mbg.generated Wed Jun 20 16:18:41 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table shopping_car
     *
     * @mbg.generated Wed Jun 20 16:18:41 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table shopping_car
     *
     * @mbg.generated Wed Jun 20 16:18:41 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopping_car
     *
     * @mbg.generated Wed Jun 20 16:18:41 CST 2018
     */
    public ShoppingCarExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopping_car
     *
     * @mbg.generated Wed Jun 20 16:18:41 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopping_car
     *
     * @mbg.generated Wed Jun 20 16:18:41 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopping_car
     *
     * @mbg.generated Wed Jun 20 16:18:41 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopping_car
     *
     * @mbg.generated Wed Jun 20 16:18:41 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopping_car
     *
     * @mbg.generated Wed Jun 20 16:18:41 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopping_car
     *
     * @mbg.generated Wed Jun 20 16:18:41 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopping_car
     *
     * @mbg.generated Wed Jun 20 16:18:41 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopping_car
     *
     * @mbg.generated Wed Jun 20 16:18:41 CST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopping_car
     *
     * @mbg.generated Wed Jun 20 16:18:41 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopping_car
     *
     * @mbg.generated Wed Jun 20 16:18:41 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table shopping_car
     *
     * @mbg.generated Wed Jun 20 16:18:41 CST 2018
     */
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

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Integer value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Integer value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Integer value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Integer value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Integer value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Integer> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Integer> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Integer value1, Integer value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Integer value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Integer value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Integer value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Integer value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Integer> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Integer> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(Double value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(Double value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(Double value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(Double value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(Double value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(Double value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<Double> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<Double> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(Double value1, Double value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(Double value1, Double value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andBoxTotalIsNull() {
            addCriterion("box_total is null");
            return (Criteria) this;
        }

        public Criteria andBoxTotalIsNotNull() {
            addCriterion("box_total is not null");
            return (Criteria) this;
        }

        public Criteria andBoxTotalEqualTo(Integer value) {
            addCriterion("box_total =", value, "boxTotal");
            return (Criteria) this;
        }

        public Criteria andBoxTotalNotEqualTo(Integer value) {
            addCriterion("box_total <>", value, "boxTotal");
            return (Criteria) this;
        }

        public Criteria andBoxTotalGreaterThan(Integer value) {
            addCriterion("box_total >", value, "boxTotal");
            return (Criteria) this;
        }

        public Criteria andBoxTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("box_total >=", value, "boxTotal");
            return (Criteria) this;
        }

        public Criteria andBoxTotalLessThan(Integer value) {
            addCriterion("box_total <", value, "boxTotal");
            return (Criteria) this;
        }

        public Criteria andBoxTotalLessThanOrEqualTo(Integer value) {
            addCriterion("box_total <=", value, "boxTotal");
            return (Criteria) this;
        }

        public Criteria andBoxTotalIn(List<Integer> values) {
            addCriterion("box_total in", values, "boxTotal");
            return (Criteria) this;
        }

        public Criteria andBoxTotalNotIn(List<Integer> values) {
            addCriterion("box_total not in", values, "boxTotal");
            return (Criteria) this;
        }

        public Criteria andBoxTotalBetween(Integer value1, Integer value2) {
            addCriterion("box_total between", value1, value2, "boxTotal");
            return (Criteria) this;
        }

        public Criteria andBoxTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("box_total not between", value1, value2, "boxTotal");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andBranchTotalIsNull() {
            addCriterion("branch_total is null");
            return (Criteria) this;
        }

        public Criteria andBranchTotalIsNotNull() {
            addCriterion("branch_total is not null");
            return (Criteria) this;
        }

        public Criteria andBranchTotalEqualTo(Integer value) {
            addCriterion("branch_total =", value, "branchTotal");
            return (Criteria) this;
        }

        public Criteria andBranchTotalNotEqualTo(Integer value) {
            addCriterion("branch_total <>", value, "branchTotal");
            return (Criteria) this;
        }

        public Criteria andBranchTotalGreaterThan(Integer value) {
            addCriterion("branch_total >", value, "branchTotal");
            return (Criteria) this;
        }

        public Criteria andBranchTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("branch_total >=", value, "branchTotal");
            return (Criteria) this;
        }

        public Criteria andBranchTotalLessThan(Integer value) {
            addCriterion("branch_total <", value, "branchTotal");
            return (Criteria) this;
        }

        public Criteria andBranchTotalLessThanOrEqualTo(Integer value) {
            addCriterion("branch_total <=", value, "branchTotal");
            return (Criteria) this;
        }

        public Criteria andBranchTotalIn(List<Integer> values) {
            addCriterion("branch_total in", values, "branchTotal");
            return (Criteria) this;
        }

        public Criteria andBranchTotalNotIn(List<Integer> values) {
            addCriterion("branch_total not in", values, "branchTotal");
            return (Criteria) this;
        }

        public Criteria andBranchTotalBetween(Integer value1, Integer value2) {
            addCriterion("branch_total between", value1, value2, "branchTotal");
            return (Criteria) this;
        }

        public Criteria andBranchTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("branch_total not between", value1, value2, "branchTotal");
            return (Criteria) this;
        }

        public Criteria andTransactionIsNull() {
            addCriterion("transaction is null");
            return (Criteria) this;
        }

        public Criteria andTransactionIsNotNull() {
            addCriterion("transaction is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionEqualTo(Double value) {
            addCriterion("transaction =", value, "transaction");
            return (Criteria) this;
        }

        public Criteria andTransactionNotEqualTo(Double value) {
            addCriterion("transaction <>", value, "transaction");
            return (Criteria) this;
        }

        public Criteria andTransactionGreaterThan(Double value) {
            addCriterion("transaction >", value, "transaction");
            return (Criteria) this;
        }

        public Criteria andTransactionGreaterThanOrEqualTo(Double value) {
            addCriterion("transaction >=", value, "transaction");
            return (Criteria) this;
        }

        public Criteria andTransactionLessThan(Double value) {
            addCriterion("transaction <", value, "transaction");
            return (Criteria) this;
        }

        public Criteria andTransactionLessThanOrEqualTo(Double value) {
            addCriterion("transaction <=", value, "transaction");
            return (Criteria) this;
        }

        public Criteria andTransactionIn(List<Double> values) {
            addCriterion("transaction in", values, "transaction");
            return (Criteria) this;
        }

        public Criteria andTransactionNotIn(List<Double> values) {
            addCriterion("transaction not in", values, "transaction");
            return (Criteria) this;
        }

        public Criteria andTransactionBetween(Double value1, Double value2) {
            addCriterion("transaction between", value1, value2, "transaction");
            return (Criteria) this;
        }

        public Criteria andTransactionNotBetween(Double value1, Double value2) {
            addCriterion("transaction not between", value1, value2, "transaction");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table shopping_car
     *
     * @mbg.generated do_not_delete_during_merge Wed Jun 20 16:18:41 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table shopping_car
     *
     * @mbg.generated Wed Jun 20 16:18:41 CST 2018
     */
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