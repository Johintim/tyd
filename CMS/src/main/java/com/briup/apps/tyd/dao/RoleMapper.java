package com.briup.apps.tyd.dao;

import com.briup.apps.tyd.bean.Role;
import com.briup.apps.tyd.bean.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role
     *
     * @mbg.generated Tue Nov 12 14:43:56 CST 2019
     */
    long countByExample(RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role
     *
     * @mbg.generated Tue Nov 12 14:43:56 CST 2019
     */
    int deleteByExample(RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role
     *
     * @mbg.generated Tue Nov 12 14:43:56 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role
     *
     * @mbg.generated Tue Nov 12 14:43:56 CST 2019
     */
    int insert(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role
     *
     * @mbg.generated Tue Nov 12 14:43:56 CST 2019
     */
    int insertSelective(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role
     *
     * @mbg.generated Tue Nov 12 14:43:56 CST 2019
     */
    List<Role> selectByExample(RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role
     *
     * @mbg.generated Tue Nov 12 14:43:56 CST 2019
     */
    Role selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role
     *
     * @mbg.generated Tue Nov 12 14:43:56 CST 2019
     */
    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role
     *
     * @mbg.generated Tue Nov 12 14:43:56 CST 2019
     */
    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role
     *
     * @mbg.generated Tue Nov 12 14:43:56 CST 2019
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role
     *
     * @mbg.generated Tue Nov 12 14:43:56 CST 2019
     */
    int updateByPrimaryKey(Role record);
}