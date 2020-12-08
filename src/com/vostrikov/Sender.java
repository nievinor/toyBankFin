package com.vostrikov;

import java.util.Random;

public class Sender extends Thread{

    private Front front;
    private Random random = new Random();

    public Sender(Front front) {
        this.front = front;
    }

    @Override
    public void run() {
        try {
            long sum = random.nextInt(15) * 3;
            Operation operation = random.nextInt(3) == 2 ? Operation.CREDIT : Operation.REPAYMENT;
            Request request = new Request(operation, sum);
            System.out.println("Клиент №" + request.getClientNumber() + ": Заявка(cl:entThreadName='Клиент №" + request.getClientNumber()
                    + ", amount=" + sum + ", requestType=" + operation);
            front.add(request);
//            front.add(new Request(operation, sum));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
