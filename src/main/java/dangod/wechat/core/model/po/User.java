package dangod.wechat.core.model.po;

import javax.persistence.*;

@Entity
@Table(name = "d_user")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String opid;

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

    public User(String opid) {
        this.opid = opid;
    }

    public User() {
    }
}
