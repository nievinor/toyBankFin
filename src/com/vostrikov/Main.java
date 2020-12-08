package com.vostrikov;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here

        Front front             = new Front();
        Back back               = new Back();
        List<Sender> senders    = new ArrayList<>();
        int clientCount         = 7;
        int handlerCount        = 2;

        for (int i = 0; i < clientCount; i++) {
            Sender sender = new Sender(front);
            sender.start();
            senders.add(sender);
        }

        List<RequestHandler> handlers = new ArrayList<>();
        for (int i = 0; i < handlerCount; i++) {
            RequestHandler requestHandler = new RequestHandler(front, back);
            requestHandler.start();
            handlers.add(requestHandler);
        }

        System.out.println("senders");

        for(Sender sender : senders) sender.join();

        System.out.println("end");

    }
}
