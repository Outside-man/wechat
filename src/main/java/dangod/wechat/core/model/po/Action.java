package dangod.wechat.core.model.po;

import javax.persistence.*;

@Entity
@Table(name = "d_action")
public class Action {
    @Id
    @GeneratedValue
    private Integer id;
    //关键字
    private String keyWord;
    //触发次数
    private Long count;
    @OneToOne(optional = false, mappedBy = "action", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ActionLog actionLog;


}
