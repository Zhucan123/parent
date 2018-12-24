package com.zc.loginserver.domain.repository;

import com.zc.loginserver.domain.entity.GroupRole;
import com.zc.loginserver.domain.entity.GroupRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface GroupRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group_role
     *
     * @mbggenerated Fri Dec 21 17:37:49 CST 2018
     */
    int countByExample(GroupRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group_role
     *
     * @mbggenerated Fri Dec 21 17:37:49 CST 2018
     */
    int deleteByExample(GroupRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group_role
     *
     * @mbggenerated Fri Dec 21 17:37:49 CST 2018
     */
    @Insert({
        "insert into t_group_role (id, groupid, ",
        "roleid)",
        "values (#{id,jdbcType=BIGINT}, #{groupid,jdbcType=BIGINT}, ",
        "#{roleid,jdbcType=BIGINT})"
    })
    int insert(GroupRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group_role
     *
     * @mbggenerated Fri Dec 21 17:37:49 CST 2018
     */
    int insertSelective(GroupRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group_role
     *
     * @mbggenerated Fri Dec 21 17:37:49 CST 2018
     */
    List<GroupRole> selectByExample(GroupRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group_role
     *
     * @mbggenerated Fri Dec 21 17:37:49 CST 2018
     */
    int updateByExampleSelective(@Param("record") GroupRole record, @Param("example") GroupRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group_role
     *
     * @mbggenerated Fri Dec 21 17:37:49 CST 2018
     */
    int updateByExample(@Param("record") GroupRole record, @Param("example") GroupRoleExample example);
}