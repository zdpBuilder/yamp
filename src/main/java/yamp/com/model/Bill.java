package yamp.com.model;

public class Bill {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill.id
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill.order_code
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    private String orderCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill.transaction
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    private Double transaction;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill.player
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    private String player;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill.player_time
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    private String playerTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill.goods_ids
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    private String goodsIds;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill.line_order_status
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    private Integer lineOrderStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill.status
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill.creater
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    private String creater;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill.create_time
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    private String createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill.into_or_out_status
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    private Integer intoOrOutStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill.address
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    private String address;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill.id
     *
     * @return the value of bill.id
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill.id
     *
     * @param id the value for bill.id
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill.order_code
     *
     * @return the value of bill.order_code
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill.order_code
     *
     * @param orderCode the value for bill.order_code
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill.transaction
     *
     * @return the value of bill.transaction
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    public Double getTransaction() {
        return transaction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill.transaction
     *
     * @param transaction the value for bill.transaction
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    public void setTransaction(Double transaction) {
        this.transaction = transaction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill.player
     *
     * @return the value of bill.player
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    public String getPlayer() {
        return player;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill.player
     *
     * @param player the value for bill.player
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    public void setPlayer(String player) {
        this.player = player == null ? null : player.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill.player_time
     *
     * @return the value of bill.player_time
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    public String getPlayerTime() {
        return playerTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill.player_time
     *
     * @param playerTime the value for bill.player_time
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    public void setPlayerTime(String playerTime) {
        this.playerTime = playerTime == null ? null : playerTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill.goods_ids
     *
     * @return the value of bill.goods_ids
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    public String getGoodsIds() {
        return goodsIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill.goods_ids
     *
     * @param goodsIds the value for bill.goods_ids
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    public void setGoodsIds(String goodsIds) {
        this.goodsIds = goodsIds == null ? null : goodsIds.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill.line_order_status
     *
     * @return the value of bill.line_order_status
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    public Integer getLineOrderStatus() {
        return lineOrderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill.line_order_status
     *
     * @param lineOrderStatus the value for bill.line_order_status
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    public void setLineOrderStatus(Integer lineOrderStatus) {
        this.lineOrderStatus = lineOrderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill.status
     *
     * @return the value of bill.status
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill.status
     *
     * @param status the value for bill.status
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill.creater
     *
     * @return the value of bill.creater
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    public String getCreater() {
        return creater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill.creater
     *
     * @param creater the value for bill.creater
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill.create_time
     *
     * @return the value of bill.create_time
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill.create_time
     *
     * @param createTime the value for bill.create_time
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill.into_or_out_status
     *
     * @return the value of bill.into_or_out_status
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    public Integer getIntoOrOutStatus() {
        return intoOrOutStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill.into_or_out_status
     *
     * @param intoOrOutStatus the value for bill.into_or_out_status
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    public void setIntoOrOutStatus(Integer intoOrOutStatus) {
        this.intoOrOutStatus = intoOrOutStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill.address
     *
     * @return the value of bill.address
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill.address
     *
     * @param address the value for bill.address
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}