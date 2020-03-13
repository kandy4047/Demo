package com.tothenew.JPADemo2.Entities;

//import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "creditcard")
//@DiscriminatorValue("cc")
public class CreditCard extends Transaction{
    private String cardno;

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }
}
