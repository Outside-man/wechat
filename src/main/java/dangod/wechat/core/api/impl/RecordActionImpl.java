package dangod.wechat.core.api.impl;

import dangod.wechat.core.api.RecordAction;
import dangod.wechat.core.dao.ActionLogRepo;
import dangod.wechat.core.dao.ActionRepo;
import dangod.wechat.core.dao.UserRepo;
import dangod.wechat.core.model.po.Action;
import dangod.wechat.core.model.po.ActionLog;
import dangod.wechat.core.model.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

@Service
public class RecordActionImpl implements RecordAction{
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ActionRepo actionRepo;
    @Autowired
    ActionLogRepo actionLogRepo;
    //TODO Redis 批量操作 定时更新，目前无法应对高并发以及效率低下
    @Override
    public Integer Record(String openid, Integer actionId){
        Action a = actionRepo.getOne(actionId);
        if(a == null){
            return -1;
        }else{
            System.out.println("aaa:"+a.addCount());
        }
        int result = 0;
        User u = userRepo.getUserByOpid(openid);
        if(u == null){
            userRepo.save(new User(openid));
            result = 1;
        }
        actionLogRepo.save(new ActionLog(a, u, new Timestamp(Calendar.getInstance().getTime().getTime())));
        return result;
    }
}
