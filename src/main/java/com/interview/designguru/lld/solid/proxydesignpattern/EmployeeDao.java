package com.interview.designguru.lld.solid.proxydesignpattern;

public interface EmployeeDao {
    String create(String client, String msg);
    void remove(String client, String msg);
    String read(String client);

}
