package com.tothenew.JPADemo3.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Programmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer sal;

    private Project project;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "programmers_projects",
            joinColumns = @JoinColumn(name = "programmer_id",referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name = "project_id",referencedColumnName="id"))
//    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Project> projects;

    public Set<Project> getProjects() {
        return projects;
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sal=" + sal +
                '}';
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSal() {
        return sal;
    }

    public void setSal(Integer sal) {
        this.sal = sal;
    }
}
