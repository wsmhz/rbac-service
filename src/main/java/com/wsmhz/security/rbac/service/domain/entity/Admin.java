package com.wsmhz.security.rbac.service.domain.entity;

import com.wsmhz.common.business.domain.Domain;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

/**
 * create by tangbj on 2018/4/25
 */

@Table(name = "admin")
public class Admin extends Domain {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Column(name = "status")
    private boolean status;

    @JsonIgnore()
    private String password;

    private String email;

    @Max(value = 11,message = "请输入正确的手机号格式")
    @Min(value = 11,message = "请输入正确的手机号格式")
    private String phone;

    @Transient
    @JsonIgnore()
    private List<Resource> resources = new ArrayList<>();

    public Admin() {
    }

    public Admin(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}
