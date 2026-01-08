package org.solid.principle.behavioral.mediator.withmediator;


import org.solid.principle.behavioral.mediator.User;
import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements ChatMediator{

    private List<User> users=new ArrayList<>();

    @Override
    public void sendMessage(String messages, User sender) {
        for (User user:users){
            //if (user!=sender)
                //user.sendMessage();
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}
