package yamp.com.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import yamp.com.model.Goods;
import yamp.com.model.GoodsExample;

public interface GoodsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Wed Jun 20 16:18:10 CST 2018
     */
    long countByExample(GoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Wed Jun 20 16:18:10 CST 2018
     */
    int deleteByExample(GoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Wed Jun 20 16:18:10 CST 2018
     */
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("typeId") Integer typeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Wed Jun 20 16:18:10 CST 2018
     */
    int insert(Goods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Wed Jun 20 16:18:10 CST 2018
     */
    int insertSelective(Goods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Wed Jun 20 16:18:10 CST 2018
     */
    List<Goods> selectByExample(GoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Wed Jun 20 16:18:10 CST 2018
     */
    Goods selectByPrimaryKey(@Param("id") Integer id, @Param("typeId") Integer typeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Wed Jun 20 16:18:10 CST 2018
     */
    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Wed Jun 20 16:18:10 CST 2018
     */
    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Wed Jun 20 16:18:10 CST 2018
     */
    int updateByPrimaryKeySelective(Goods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated Wed Jun 20 16:18:10 CST 2018
     */
    int updateByPrimaryKey(Goods record);
}