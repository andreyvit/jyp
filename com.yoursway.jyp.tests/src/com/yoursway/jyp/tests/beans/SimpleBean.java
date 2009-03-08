package com.yoursway.jyp.tests.beans;

public class SimpleBean {
    
    int foo;
    
    int bar;
    
    public int getFoo() {
        return foo;
    }
    
    public void setFoo(int foo) {
        this.foo = foo;
    }
    
    public int getBar() {
        return bar;
    }
    
    public void setBar(int bar) {
        this.bar = bar;
    }
    
    @Override
    public String toString() {
        return "(foo=" + foo + ", bar=" + bar + ")";
    }
    
}
