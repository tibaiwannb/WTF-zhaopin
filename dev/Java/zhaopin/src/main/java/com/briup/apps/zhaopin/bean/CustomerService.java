package com.briup.apps.zhaopin.bean;

public class CustomerService {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zp_customer_service.id
     *
     * @mbg.generated Thu Dec 12 19:18:16 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zp_customer_service.username
     *
     * @mbg.generated Thu Dec 12 19:18:16 CST 2019
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zp_customer_service.realname
     *
     * @mbg.generated Thu Dec 12 19:18:16 CST 2019
     */
    private String realname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zp_customer_service.gender
     *
     * @mbg.generated Thu Dec 12 19:18:16 CST 2019
     */
    private String gender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zp_customer_service.status
     *
     * @mbg.generated Thu Dec 12 19:18:16 CST 2019
     */
    private String status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zp_customer_service.id
     *
     * @return the value of zp_customer_service.id
     *
     * @mbg.generated Thu Dec 12 19:18:16 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zp_customer_service.id
     *
     * @param id the value for zp_customer_service.id
     *
     * @mbg.generated Thu Dec 12 19:18:16 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zp_customer_service.username
     *
     * @return the value of zp_customer_service.username
     *
     * @mbg.generated Thu Dec 12 19:18:16 CST 2019
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zp_customer_service.username
     *
     * @param username the value for zp_customer_service.username
     *
     * @mbg.generated Thu Dec 12 19:18:16 CST 2019
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zp_customer_service.realname
     *
     * @return the value of zp_customer_service.realname
     *
     * @mbg.generated Thu Dec 12 19:18:16 CST 2019
     */
    public String getRealname() {
        return realname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zp_customer_service.realname
     *
     * @param realname the value for zp_customer_service.realname
     *
     * @mbg.generated Thu Dec 12 19:18:16 CST 2019
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zp_customer_service.gender
     *
     * @return the value of zp_customer_service.gender
     *
     * @mbg.generated Thu Dec 12 19:18:16 CST 2019
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zp_customer_service.gender
     *
     * @param gender the value for zp_customer_service.gender
     *
     * @mbg.generated Thu Dec 12 19:18:16 CST 2019
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zp_customer_service.status
     *
     * @return the value of zp_customer_service.status
     *
     * @mbg.generated Thu Dec 12 19:18:16 CST 2019
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zp_customer_service.status
     *
     * @param status the value for zp_customer_service.status
     *
     * @mbg.generated Thu Dec 12 19:18:16 CST 2019
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}