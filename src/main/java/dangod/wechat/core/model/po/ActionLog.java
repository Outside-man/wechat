package dangod.wechat.core.model.po;

import javax.persistence.*;
import java.sql.Date;

//TODO 目前是打算把所有用户的所有动作全部记录，或者是考虑记录对于用户的每个动作次数
@Table(name = "d_action_log")
@Entity
public class ActionLog {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "action_id", unique = true)
    private Action action;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    private Date date;
}
