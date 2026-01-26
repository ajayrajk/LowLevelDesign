package org.java8.features;

import java.util.Optional;

public class OptionalExam {

    public static void main(String[] args) {
       // ❌ Old
        User user=new User();
        if(user != null && user.getName() != null) {
            System.out.println(user.getName());
        }

        // Now day

        Optional<User> user1 = null;

        user1.map(User::getName)
                .ifPresent(System.out::println);

    }


}

class User{
    private String name;

    public String getName() {
        return name;
    }
}
