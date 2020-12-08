package com.vostrikov;

public class RequestHandler extends Thread {
    private Front front;
    private Back back;

    public RequestHandler(Front front, Back back) {
        super();
        this.front = front;
        this.back = back;
    }

    @Override
    public void run() {
        while (true) {
            Request newRequest = null;
            try {
                newRequest = front.getNewRequest();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            handleRequest(newRequest);
        }
    }

    private void handleRequest(Request request) {
        System.out.println("Выполнение операции");
        if (request.getOperation() == Operation.REPAYMENT) back.repayment(request.getAmount());
        else if (request.getOperation() == Operation.CREDIT) back.credit(request.getAmount());
    }
}
