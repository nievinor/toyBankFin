package com.vostrikov;

public class Back {
    private long balance = 300000;

    public synchronized boolean repayment(long sum) {
        System.out.println("Увеличение");
        balance += sum;
        System.out.println("Новый баланс");
        return true;
    }

    public synchronized boolean credit(long sum) {
        System.out.println("уменьшение");
        if (balance - sum >= 0) {
            balance -= sum;
            System.out.println("Новый баланс");
            return true;
        } else {
            System.out.println("Нет средств");
            return false;
        }
    }
}
