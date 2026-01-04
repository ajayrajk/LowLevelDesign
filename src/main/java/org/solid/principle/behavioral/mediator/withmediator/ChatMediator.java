package org.solid.principle.behavioral.mediator.withmediator;

import org.solid.principle.behavioral.mediator.User;

interface ChatMediator {

    void sendMessage(String messages, User user);
    void addUser(User user);

}
