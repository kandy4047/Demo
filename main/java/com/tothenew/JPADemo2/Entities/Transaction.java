package com.tothenew.JPADemo2.Entities;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "pmode",discriminatorType = DiscriminatorType.STRING)
public abstract class Transaction {
    private Integer id;
    private Double amount;

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
