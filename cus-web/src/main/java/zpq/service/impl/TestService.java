package zpq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import zpq.dao.TestMapper;
import zpq.service.ITestService;

public class TestService implements ITestService {
    /**
     * 介于spring容器与springmvc容器处于父子容器的关系，故在service时还未启动mvc容器故找不到对应的bean
     */
    // @Autowired
    // HelloController controller;

    @Autowired
    private TestMapper testMapper;

    @Override
    public void batchInsertCustomer1(int number) {
        for (int i = 0; i < number; i++)
            testMapper.batchInsertCustomer1(number);
    }

    @Override
    public void batchInsertCustomer2(int number) {
        testMapper.batchInsertCustomer2(number);
    }

    @Override
    public void batchInsertCustomer3(int number) {
        testMapper.batchInsertCustomer3(number);
    }

}
