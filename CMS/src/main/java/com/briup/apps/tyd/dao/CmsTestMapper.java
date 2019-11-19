package com.briup.apps.tyd.dao;

import com.briup.apps.tyd.bean.CmsTest;
import com.briup.apps.tyd.bean.CmsTestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsTestMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_test
     *
     * @mbg.generated Mon Nov 11 19:43:01 CST 2019
     */
    long countByExample(CmsTestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_test
     *
     * @mbg.generated Mon Nov 11 19:43:01 CST 2019
     */
    int deleteByExample(CmsTestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_test
     *
     * @mbg.generated Mon Nov 11 19:43:01 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_test
     *
     * @mbg.generated Mon Nov 11 19:43:01 CST 2019
     */
    int insert(CmsTest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_test
     *
     * @mbg.generated Mon Nov 11 19:43:01 CST 2019
     */
    int insertSelective(CmsTest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_test
     *
     * @mbg.generated Mon Nov 11 19:43:01 CST 2019
     */
    List<CmsTest> selectByExample(CmsTestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_test
     *
     * @mbg.generated Mon Nov 11 19:43:01 CST 2019
     */
    CmsTest selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_test
     *
     * @mbg.generated Mon Nov 11 19:43:01 CST 2019
     */
    int updateByExampleSelective(@Param("record") CmsTest record, @Param("example") CmsTestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_test
     *
     * @mbg.generated Mon Nov 11 19:43:01 CST 2019
     */
    int updateByExample(@Param("record") CmsTest record, @Param("example") CmsTestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_test
     *
     * @mbg.generated Mon Nov 11 19:43:01 CST 2019
     */
    int updateByPrimaryKeySelective(CmsTest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_test
     *
     * @mbg.generated Mon Nov 11 19:43:01 CST 2019
     */
    int updateByPrimaryKey(CmsTest record);
}