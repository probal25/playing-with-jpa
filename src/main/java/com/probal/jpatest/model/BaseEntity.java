package com.probal.jpatest.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@MappedSuperclass
public abstract class BaseEntity<T extends Serializable> implements Serializable {

    @Serial
    private static final long serialVersionUID = 3779027956207925319L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected T id;
    @Version
    private Long version;
    private Date createdAt;
    private Date updatedAt;
    private Boolean deleted = Boolean.FALSE;

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = new Date();
    }

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = new Date();
    }
}
