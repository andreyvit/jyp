package com.yoursway.jyp.tests.beans;

import com.yoursway.jyp.BeanEncoding;

public class ArrayBean {
    
    private final ImmutableBean[] children;
    
    public ArrayBean(@BeanEncoding.Property("children") ImmutableBean[] children) {
        if (children == null)
            throw new NullPointerException("children is null");
        this.children = children;
    }
    
    public ImmutableBean[] getChildren() {
        return children;
    }
    
}
