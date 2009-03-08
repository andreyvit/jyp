package com.yoursway.jyp.tests.beans;

import com.yoursway.jyp.BeanEncoding;

public class ImmutableBean {
    
    final int foo;
    
    final int bar;
    
    public ImmutableBean(@BeanEncoding.Property("foo") int foo, @BeanEncoding.Property("bar") int bar) {
        this.foo = foo;
        this.bar = bar;
    }
    
    public int getFoo() {
        return foo;
    }
    
    public int getBar() {
        return bar;
    }
    
    @Override
    public String toString() {
        return "(foo=" + foo + ", bar=" + bar + ")";
    }
    
}
