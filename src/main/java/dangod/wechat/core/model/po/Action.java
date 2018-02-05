package dangod.wechat.core.model.po;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "d_action")
public class Action {
    @Id
    @GeneratedValue
    private Integer id;
    //关键字
    public String keyWord;
    //触发次数
    private long count = 0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long addCount(){
        return ++this.count;
    }


    public Action (){

    }

    public Action(Integer id){
        this.id = id;
    }
}
