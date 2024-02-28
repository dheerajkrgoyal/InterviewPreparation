package com.interview.designguru.lld.solid.proxydesignpattern;

public class ProxyMainApp {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDaoProxy();
        String ADMIN_CLIENT = "ADMIN";
        String USER_CLIENT = "USER";

        employeeDao.create(USER_CLIENT, "create object");
        employeeDao.remove(ADMIN_CLIENT, "remove object");
    }
}
