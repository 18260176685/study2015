package com.lxiang.base.core.domain;

import com.lxiang.base.core.datatypes.BaseEntity;

import javax.persistence.Entity;

/**
 * UserInfo
 *
 * @author Administrator
 * @since 2015/4/6
 */
@Entity
public class UserInfo extends BaseEntity {

    private String name;

    private String title;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
