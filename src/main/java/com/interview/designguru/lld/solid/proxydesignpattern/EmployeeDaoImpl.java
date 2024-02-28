package com.interview.designguru.lld.solid.proxydesignpattern;

public class EmployeeDaoImpl implements EmployeeDao{
    @Override
    public String create(String client, String msg) {
        System.out.println("created: " + msg);
        return msg;
    }

    @Override
    public void remove(String client, String msg) {
        System.out.println("removed: " + msg);
    }

    @Override
    public String read(String client) {
        System.out.println("read: msg");
        return "msg";
    }
}
