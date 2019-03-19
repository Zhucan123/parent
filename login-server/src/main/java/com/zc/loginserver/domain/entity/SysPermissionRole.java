package com.zc.loginserver.domain.entity;

public class SysPermissionRole extends BaseDomain {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission_role.id
     *
     * @mbggenerated Tue Dec 25 16:42:45 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission_role.role_id
     *
     * @mbggenerated Tue Dec 25 16:42:45 CST 2018
     */
    private Long roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission_role.permission_id
     *
     * @mbggenerated Tue Dec 25 16:42:45 CST 2018
     */
    private Long permissionId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission_role.id
     *
     * @return the value of sys_permission_role.id
     * @mbggenerated Tue Dec 25 16:42:45 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission_role.id
     *
     * @param id the value for sys_permission_role.id
     * @mbggenerated Tue Dec 25 16:42:45 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission_role.role_id
     *
     * @return the value of sys_permission_role.role_id
     * @mbggenerated Tue Dec 25 16:42:45 CST 2018
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission_role.role_id
     *
     * @param roleId the value for sys_permission_role.role_id
     * @mbggenerated Tue Dec 25 16:42:45 CST 2018
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission_role.permission_id
     *
     * @return the value of sys_permission_role.permission_id
     * @mbggenerated Tue Dec 25 16:42:45 CST 2018
     */
    public Long getPermissionId() {
        return permissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission_role.permission_id
     *
     * @param permissionId the value for sys_permission_role.permission_id
     * @mbggenerated Tue Dec 25 16:42:45 CST 2018
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}