package org.designpattern.behavioral.mediator.withmediator;

import org.designpattern.behavioral.mediator.User;

interface ChatMediator {

    void sendMessage(String messages, User user);
    void addUser(User user);

}
