package com.briup.apps.tyd.dao;

import com.briup.apps.tyd.bean.CmsRolePrivilege;
import com.briup.apps.tyd.bean.CmsRolePrivilegeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsRolePrivilegeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role_privilege
     *
     * @mbg.generated Mon Nov 18 16:23:17 CST 2019
     */
    long countByExample(CmsRolePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role_privilege
     *
     * @mbg.generated Mon Nov 18 16:23:17 CST 2019
     */
    int deleteByExample(CmsRolePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role_privilege
     *
     * @mbg.generated Mon Nov 18 16:23:17 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role_privilege
     *
     * @mbg.generated Mon Nov 18 16:23:17 CST 2019
     */
    int insert(CmsRolePrivilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role_privilege
     *
     * @mbg.generated Mon Nov 18 16:23:17 CST 2019
     */
    int insertSelective(CmsRolePrivilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role_privilege
     *
     * @mbg.generated Mon Nov 18 16:23:17 CST 2019
     */
    List<CmsRolePrivilege> selectByExample(CmsRolePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role_privilege
     *
     * @mbg.generated Mon Nov 18 16:23:17 CST 2019
     */
    CmsRolePrivilege selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role_privilege
     *
     * @mbg.generated Mon Nov 18 16:23:17 CST 2019
     */
    int updateByExampleSelective(@Param("record") CmsRolePrivilege record, @Param("example") CmsRolePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role_privilege
     *
     * @mbg.generated Mon Nov 18 16:23:17 CST 2019
     */
    int updateByExample(@Param("record") CmsRolePrivilege record, @Param("example") CmsRolePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role_privilege
     *
     * @mbg.generated Mon Nov 18 16:23:17 CST 2019
     */
    int updateByPrimaryKeySelective(CmsRolePrivilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role_privilege
     *
     * @mbg.generated Mon Nov 18 16:23:17 CST 2019
     */
    int updateByPrimaryKey(CmsRolePrivilege record);
}