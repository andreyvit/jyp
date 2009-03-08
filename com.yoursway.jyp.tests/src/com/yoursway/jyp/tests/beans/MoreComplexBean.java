package com.yoursway.jyp.tests.beans;

import java.util.ArrayList;
import java.util.List;

import com.yoursway.jyp.BeanEncoding;

public class MoreComplexBean {
    
    private final List<ImmutableBean> children;
    
    private int x;
    
    public MoreComplexBean(@BeanEncoding.Property("children") List<ImmutableBean> children) {
        if (children == null)
            throw new NullPointerException("children is null");
        this.children = new ArrayList<ImmutableBean>(children);
    }
    
    public List<ImmutableBean> getChildren() {
        return children;
    }
    
    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
}
