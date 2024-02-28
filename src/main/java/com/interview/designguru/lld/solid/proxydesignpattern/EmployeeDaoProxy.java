package com.interview.designguru.lld.solid.proxydesignpattern;

public class EmployeeDaoProxy implements EmployeeDao{

    EmployeeDao employeeDao;

    public EmployeeDaoProxy(){
        this.employeeDao = new EmployeeDaoImpl();
    }
    @Override
    public String create(String client, String msg) {
        if(client.equals("ADMIN")){
            return employeeDao.create(client, msg);
        }
        else{
            System.out.println("Access denied");
            return null;
        }
    }

    @Override
    public void remove(String client, String msg) {
        if(client.equals("ADMIN")){
            employeeDao.remove(client, msg);
        }
        else{
            System.out.println("Access denied");
        }
    }

    @Override
    public String read(String client) {
        return employeeDao.read(client);
    }
}
