package com.matthew.spring;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-11-10 16:23
 */
@RunWith(SpringJUnit4ClassRunner.class)//基于JUnit的spring测试框架
@ContextConfiguration(locations = {"classpath:conf/"})
public class BaseTest {
}
