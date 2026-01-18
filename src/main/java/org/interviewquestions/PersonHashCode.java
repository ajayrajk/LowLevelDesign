package org.interviewquestions;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PersonHashCode {
    private int id;
    private String name;

    public PersonHashCode(int id, String name) {
        this.id = id;
        this.name = name;
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name); // generate hash from fields
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true; // same reference
        if (o == null || getClass() != o.getClass()) return false;
        PersonHashCode person = (PersonHashCode) o;
        return id == person.id && Objects.equals(name, person.name);
        // compare fields
    }

    public static void main(String[] args) {
        Set<PersonHashCode> people = new HashSet<>();
        people.add(new PersonHashCode(1, "Ajay"));
        people.add(new PersonHashCode(1, "Ajay"));
        // Won’t be added again because equals+hashCode match

        System.out.println(" size :"+people.size());
    }


}
