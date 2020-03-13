package com.tothenew.JPADemo2.Entities;

//import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cheque")
//@DiscriminatorValue("ch")
public class Cheque extends Transaction  {
    private String chequeno;

    public String getChequeno() {
        return chequeno;
    }

    public void setChequeno(String chequeno) {
        this.chequeno = chequeno;
    }
}
