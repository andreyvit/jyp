package com.yoursway.jyp.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.yoursway.jyp.BeanEncoding;
import com.yoursway.jyp.JSON;
import com.yoursway.jyp.BeanEncoding.BeanificationException;
import com.yoursway.jyp.JSON.SyntaxError;
import com.yoursway.jyp.tests.beans.ImmutableBean;
import com.yoursway.jyp.tests.beans.MoreComplexBean;
import com.yoursway.jyp.tests.beans.SimpleBean;

public class BeanDecodingTests {
    
    @Test
    public void simpleBean() throws BeanificationException, SyntaxError {
        SimpleBean bean = BeanEncoding.beanify(JSON.decode("{\"bar\":6,\"foo\":42}"), SimpleBean.class);
        assertEquals(42, bean.getFoo());
        assertEquals(6, bean.getBar());
    }
    
    @Test
    public void immutableBean() throws BeanificationException, SyntaxError {
        ImmutableBean bean = BeanEncoding.beanify(JSON.decode("{\"bar\":6,\"foo\":42}"), ImmutableBean.class);
        assertEquals(42, bean.getFoo());
        assertEquals(6, bean.getBar());
    }
    
    @Test
    public void moreComplexBean() throws BeanificationException, SyntaxError {
        MoreComplexBean bean = BeanEncoding.beanify(JSON
                .decode("{\"children\":[{\"bar\":6,\"foo\":42},{\"bar\":7,\"foo\":43}],\"x\":11}"),
            MoreComplexBean.class);
        assertEquals(11, bean.getX());
        assertEquals(2, bean.getChildren().size());
        assertEquals(42, bean.getChildren().get(0).getFoo());
        assertEquals(6, bean.getChildren().get(0).getBar());
        assertEquals(43, bean.getChildren().get(1).getFoo());
        assertEquals(7, bean.getChildren().get(1).getBar());
    }
    
}
