package com.zc.loginserver.domain.repository;

import com.zc.loginserver.domain.entity.SysUser;
import com.zc.loginserver.domain.entity.SysUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Tue Dec 25 16:42:45 CST 2018
     */
    int countByExample(SysUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Tue Dec 25 16:42:45 CST 2018
     */
    int deleteByExample(SysUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Tue Dec 25 16:42:45 CST 2018
     */
    @Insert({
        "insert into sys_user (id, username, ",
        "password)",
        "values (#{id,jdbcType=BIGINT}, #{username,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR})"
    })
    int insert(SysUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Tue Dec 25 16:42:45 CST 2018
     */
    int insertSelective(SysUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Tue Dec 25 16:42:45 CST 2018
     */
    List<SysUser> selectByExample(SysUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Tue Dec 25 16:42:45 CST 2018
     */
    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Tue Dec 25 16:42:45 CST 2018
     */
    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);
}