package zpq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zpq.bean.Manager;
import zpq.bean.ManagerExample;
import zpq.bean.ManagerExample.Criteria;
import zpq.dao.ManagerMapper;
import zpq.constants.Msg;
import zpq.service.IManagerService;

@Service
public class ManagerServiceImpl implements IManagerService {

    @Autowired
    private ManagerMapper managerMapper;
    
    private ManagerExample managerExample;
    private Criteria managerCriteria;

    /**
     * 更新Manager个人信息
     */
    @Override
    public Msg updateManager(Manager manager, String oriAccount) {
        // 检查用户名唯一
        managerExample = new ManagerExample();
        managerCriteria = managerExample.createCriteria();
        managerCriteria.andAccountEqualTo(manager.getAccount());
        if (manager.getAccount().equals(oriAccount)) {
            // 不需任何操作
        } else if (!managerMapper.selectByExample(managerExample).isEmpty()) {
            // 不唯一
            return Msg.fail().add("msg", "修改失败：用户名【" + manager.getAccount() + "】已存在");
        }
        manager.setIsdeleted(false);
        if (managerMapper.updateByPrimaryKey(manager) != 0)
            return Msg.success().add("msg", "修改成功" + manager);
        return Msg.fail().add("msg", "修改失败：原因未知");
    }

    @Override
    public Msg addManager(Manager manager) {
        // TODO Auto-generated method stub
        return null;
    }

}
