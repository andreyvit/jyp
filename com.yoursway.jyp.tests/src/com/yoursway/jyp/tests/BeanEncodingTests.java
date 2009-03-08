package com.yoursway.jyp.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.yoursway.jyp.BeanEncoding;
import com.yoursway.jyp.JSON;
import com.yoursway.jyp.tests.beans.ImmutableBean;
import com.yoursway.jyp.tests.beans.MoreComplexBean;
import com.yoursway.jyp.tests.beans.SimpleBean;

public class BeanEncodingTests {
    
    @Test
    public void simpleBean() {
        SimpleBean bean = new SimpleBean();
        bean.setFoo(42);
        bean.setBar(6);
        assertEquals("{\"bar\":6,\"foo\":42}", JSON.encode(BeanEncoding.simplify(bean)));
    }
    
    @Test
    public void immutableBean() {
        ImmutableBean bean = new ImmutableBean(42, 6);
        assertEquals("{\"bar\":6,\"foo\":42}", JSON.encode(BeanEncoding.simplify(bean)));
    }
    
    @Test
    public void moreComplexBean() {
        List<ImmutableBean> children = new ArrayList<ImmutableBean>();
        children.add(new ImmutableBean(42, 6));
        children.add(new ImmutableBean(43, 7));
        MoreComplexBean bean = new MoreComplexBean(children);
        bean.setX(11);
        assertEquals("{\"children\":[{\"bar\":6,\"foo\":42},{\"bar\":7,\"foo\":43}],\"x\":11}", JSON
                .encode(BeanEncoding.simplify(bean)));
    }
    
}
