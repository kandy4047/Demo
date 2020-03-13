package com.tothenew.JPADemo3.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

//    @OneToMany(mappedBy = "customer")
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
//    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<PhoneNumber> numbers;

    public Set<PhoneNumber> getNumbers() {
        return numbers;
    }

    public void setNumbers(Set<PhoneNumber> numbers) {
        this.numbers = numbers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Better way of Handling Foreign Key
    public void addPhoneNumber(PhoneNumber phoneNumber){
        if(phoneNumber != null){
            if(numbers == null){
                numbers = new HashSet<>();
            }
            phoneNumber.setCustomer(this);
            numbers.add(phoneNumber);
        }
    }
}
