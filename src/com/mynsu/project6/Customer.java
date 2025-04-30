/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynsu.project6;
/**
 *
 * @author 
 * Brandon Cruz, Mark-Anthony Wright, Marcos Rodriguez, Jonathan Vargas
 */
public class Customer {

    private int id;
    private int arrival;
    private int enter;
    private int exit;
    private int status;

    public static final int CUST_NOT_PROCESSED = 0;
    public static final int CUST_ENTERED = 1;
    public static final int CUST_EXITED = 2;

    public Customer(int id, int arrival, int enter, int exit) {
        if (id <= 0 || arrival <= 0 || enter <= 0 || exit <= 0 || enter == exit) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.arrival = arrival;
        this.enter = enter;
        this.exit = exit;
        this.status = CUST_NOT_PROCESSED;
    }

    public int getId() {
        return id;
    }

    public int getArrival() {
        return this.arrival;
    }

    public int getEnter() {
        return enter;
    }

    public int getExit() {
        return exit;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        if (status < CUST_NOT_PROCESSED || status > CUST_EXITED) {
            throw new IllegalArgumentException();
        }
        this.status = status;
    }
}

