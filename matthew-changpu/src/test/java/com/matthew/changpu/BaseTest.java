package com.matthew.changpu;


        import org.springframework.test.context.ContextConfiguration;
        import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-03-06 11:37
 */
@ContextConfiguration(locations ={
        "classpath:spring/applicationContext.xml"
})
public class BaseTest extends AbstractJUnit4SpringContextTests {
}
