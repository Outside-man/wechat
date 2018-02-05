package dangod.wechat.core.model.po;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

//TODO 目前是打算把所有用户的所有动作全部记录，或者是考虑记录对于用户的每个动作次数
@Table(name = "d_action_log")
@Entity
public class ActionLog {
    @Id
    @GeneratedValue
    private Long id;


    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="action_id",nullable=true)
    private Action action;

    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="user_id",nullable=true)
    private User user;

    private Timestamp date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public ActionLog(Action action, User user, Timestamp date) {
        this.action = action;
        this.user = user;
        this.date = date;
    }
}
