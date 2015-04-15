package com.lxiang.base.core.datatypes;

import javax.persistence.*;
import java.io.Serializable;

/**
 * BaseEntity
 *
 * @author Administrator
 * @since 2015/4/12
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -4701836641660471764L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

}
