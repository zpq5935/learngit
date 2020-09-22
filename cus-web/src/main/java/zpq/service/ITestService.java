package zpq.service;

/**
 * 测试服务
 * 
 * @author 22517
 *
 */
public interface ITestService {

    /**
     * java循环插入
     * 
     * @param number
     */
    void batchInsertCustomer1(int number);

    /**
     * xml标签
     * 
     * @param number
     */
    void batchInsertCustomer2(int number);

    /**
     * mybatis的java代码支持
     * 
     * @param number
     */
    void batchInsertCustomer3(int number);
}
