package yamp.com.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCarExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table shopping_car
     *
     * @mbg.generated Tue Jul 03 14:39:27 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table shopping_car
     *
     * @mbg.generated Tue Jul 03 14:39:27 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table shopping_car
     *
     * @mbg.generated Tue Jul 03 14:39:27 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopping_car
     *
     * @mbg.generated Tue Jul 03 14:39:27 CST 2018
     */
    public ShoppingCarExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopping_car
     *
     * @mbg.generated Tue Jul 03 14:39:27 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopping_car
     *
     * @mbg.generated Tue Jul 03 14:39:27 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopping_car
     *
     * @mbg.generated Tue Jul 03 14:39:27 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopping_car
     *
     * @mbg.generated Tue Jul 03 14:39:27 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopping_car
     *
     * @mbg.generated Tue Jul 03 14:39:27 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopping_car
     *
     * @mbg.generated Tue Jul 03 14:39:27 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopping_car
     *
     * @mbg.generated Tue Jul 03 14:39:27 CST 2018
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
     * @mbg.generated Tue Jul 03 14:39:27 CST 2018
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
     * @mbg.generated Tue Jul 03 14:39:27 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shopping_car
     *
     * @mbg.generated Tue Jul 03 14:39:27 CST 2018
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
     * @mbg.generated Tue Jul 03 14:39:27 CST 2018
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

        public Criteria andCustomerIdEqualTo(String value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(String value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(String value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(String value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(String value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(String value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLike(String value) {
            addCriterion("customer_id like", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotLike(String value) {
            addCriterion("customer_id not like", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<String> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<String> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(String value1, String value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(String value1, String value2) {
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

        public Criteria andGoodsIdEqualTo(String value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(String value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(String value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(String value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(String value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(String value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLike(String value) {
            addCriterion("goods_id like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotLike(String value) {
            addCriterion("goods_id not like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<String> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<String> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(String value1, String value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(String value1, String value2) {
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

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
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

        public Criteria andGoodsUrlIsNull() {
            addCriterion("goods_url is null");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlIsNotNull() {
            addCriterion("goods_url is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlEqualTo(String value) {
            addCriterion("goods_url =", value, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlNotEqualTo(String value) {
            addCriterion("goods_url <>", value, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlGreaterThan(String value) {
            addCriterion("goods_url >", value, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlGreaterThanOrEqualTo(String value) {
            addCriterion("goods_url >=", value, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlLessThan(String value) {
            addCriterion("goods_url <", value, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlLessThanOrEqualTo(String value) {
            addCriterion("goods_url <=", value, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlLike(String value) {
            addCriterion("goods_url like", value, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlNotLike(String value) {
            addCriterion("goods_url not like", value, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlIn(List<String> values) {
            addCriterion("goods_url in", values, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlNotIn(List<String> values) {
            addCriterion("goods_url not in", values, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlBetween(String value1, String value2) {
            addCriterion("goods_url between", value1, value2, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlNotBetween(String value1, String value2) {
            addCriterion("goods_url not between", value1, value2, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsBranchPriceIsNull() {
            addCriterion("goods_branch_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsBranchPriceIsNotNull() {
            addCriterion("goods_branch_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsBranchPriceEqualTo(Double value) {
            addCriterion("goods_branch_price =", value, "goodsBranchPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsBranchPriceNotEqualTo(Double value) {
            addCriterion("goods_branch_price <>", value, "goodsBranchPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsBranchPriceGreaterThan(Double value) {
            addCriterion("goods_branch_price >", value, "goodsBranchPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsBranchPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("goods_branch_price >=", value, "goodsBranchPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsBranchPriceLessThan(Double value) {
            addCriterion("goods_branch_price <", value, "goodsBranchPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsBranchPriceLessThanOrEqualTo(Double value) {
            addCriterion("goods_branch_price <=", value, "goodsBranchPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsBranchPriceIn(List<Double> values) {
            addCriterion("goods_branch_price in", values, "goodsBranchPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsBranchPriceNotIn(List<Double> values) {
            addCriterion("goods_branch_price not in", values, "goodsBranchPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsBranchPriceBetween(Double value1, Double value2) {
            addCriterion("goods_branch_price between", value1, value2, "goodsBranchPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsBranchPriceNotBetween(Double value1, Double value2) {
            addCriterion("goods_branch_price not between", value1, value2, "goodsBranchPrice");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table shopping_car
     *
     * @mbg.generated do_not_delete_during_merge Tue Jul 03 14:39:27 CST 2018
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
     * @mbg.generated Tue Jul 03 14:39:27 CST 2018
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