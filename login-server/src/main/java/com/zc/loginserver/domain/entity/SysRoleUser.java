package com.zc.loginserver.domain.entity;

public class SysRoleUser extends BaseDomain {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_user.id
     *
     * @mbggenerated Tue Dec 25 16:42:45 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_user.sys_user_id
     *
     * @mbggenerated Tue Dec 25 16:42:45 CST 2018
     */
    private Long sysUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_user.sys_role_id
     *
     * @mbggenerated Tue Dec 25 16:42:45 CST 2018
     */
    private Long sysRoleId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_user.id
     *
     * @return the value of sys_role_user.id
     *
     * @mbggenerated Tue Dec 25 16:42:45 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_user.id
     *
     * @param id the value for sys_role_user.id
     *
     * @mbggenerated Tue Dec 25 16:42:45 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_user.sys_user_id
     *
     * @return the value of sys_role_user.sys_user_id
     *
     * @mbggenerated Tue Dec 25 16:42:45 CST 2018
     */
    public Long getSysUserId() {
        return sysUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_user.sys_user_id
     *
     * @param sysUserId the value for sys_role_user.sys_user_id
     *
     * @mbggenerated Tue Dec 25 16:42:45 CST 2018
     */
    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_user.sys_role_id
     *
     * @return the value of sys_role_user.sys_role_id
     *
     * @mbggenerated Tue Dec 25 16:42:45 CST 2018
     */
    public Long getSysRoleId() {
        return sysRoleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_user.sys_role_id
     *
     * @param sysRoleId the value for sys_role_user.sys_role_id
     *
     * @mbggenerated Tue Dec 25 16:42:45 CST 2018
     */
    public void setSysRoleId(Long sysRoleId) {
        this.sysRoleId = sysRoleId;
    }
}