package com.vostrikov;

import java.util.LinkedList;
import java.util.Queue;

public class Front {

    private static final int REQUEST_NUMBER = 2;

    private Queue<Request> requests = new LinkedList<>();

    public synchronized void add(Request request) throws InterruptedException {
//        System.out.println("Добавление заявки");
        while (requests.size() >= REQUEST_NUMBER) {
//            System.out.println("");
            wait();
        }

        System.out.println("Обработчик заявок №" + Thread.currentThread().getId()
                + ": Получена заявка на обработку по клиенту - Клиент №" + request.getClientNumber());
        requests.add(request);
        notify();
    }

    public synchronized Request getNewRequest() throws InterruptedException {
        while (requests.size() < 1) {
            System.out.println();
            wait();
        }
        System.out.println();
        Request request = requests.poll();

        if (request == null) System.out.println("Пустая заявка была удалена");
        notify();
        return request;
    }

}
