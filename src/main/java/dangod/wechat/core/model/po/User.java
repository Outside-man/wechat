package dangod.wechat.model.core.po;

import javax.persistence.*;

@Entity
@Table(name = "d_user")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String opid;
    @OneToOne(optional = false, mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserInfo userInfo;
    @OneToOne(optional = false, mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ActionLog actionLog;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpid() {
        return opid;
    }

    public void setOpid(String opid) {
        this.opid = opid;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public ActionLog getActionLog() {
        return actionLog;
    }

    public void setActionLog(ActionLog actionLog) {
        this.actionLog = actionLog;
    }
}
