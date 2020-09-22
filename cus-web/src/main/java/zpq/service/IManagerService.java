package zpq.service;

import zpq.bean.Manager;
import zpq.constants.Msg;

public interface IManagerService {
    /**
     * 更新Manager个人信息
     * 
     * @param manager
     * @return
     */
    public Msg updateManager(Manager manager, String oriAccount);

    /**
     * 添加各类人员
     * 
     * @return
     */
    public Msg addManager(Manager manager);
}
