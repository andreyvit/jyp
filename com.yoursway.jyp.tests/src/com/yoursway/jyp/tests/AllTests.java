package com.yoursway.jyp.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses( { JsonEncodingTests.class, JsonDecodingTests.class, BeanEncodingTests.class,
        BeanDecodingTests.class })
public class AllTests {
    
}
