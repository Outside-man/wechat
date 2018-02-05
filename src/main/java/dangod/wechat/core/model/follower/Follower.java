package dangod.wechat.core.model.follower;

import dangod.wechat.core.api.impl.FollowerGetterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Follower {
    @Autowired
    private FollowerGetterImpl getter;
    private Integer subscribe;
    private String openid;
    private String nickname;
    private Integer sex;
    private String city;
    private String province;
    private String country;
    private String language;
    private String headimgurl;
    private Long subscribeTime;
    private String unionid;
    private String remark;
    private Integer groupId;
//    private String tagid_list;


    public Integer getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Integer subscribe) {
        this.subscribe = subscribe;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public Long getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Long subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Follower() {
    }

    public Follower(Map follower) {
        this.subscribe = (Integer) getData(follower, "subscribe");
        this.openid = (String)getData(follower, "openid");
        this.nickname = (String)getData(follower, "nickname");
        this.sex = (Integer) getData(follower, "sex");
        this.city = (String)getData(follower, "city");
        this.province = (String)getData(follower, "province");
        this.country = (String)getData(follower, "country");
        this.language = (String)getData(follower, "language");
        this.headimgurl = (String)getData(follower, "headimgurl");
        this.subscribeTime = (Long) getData(follower, "subscribeTime");
        this.unionid = (String)getData(follower, "unionid");
        this.remark = (String)getData(follower, "remark");
        this.groupId = (Integer) getData(follower, "groupId");
    }

    private static Object getData(Map m, String k){
        if(m.containsKey(k))
            return m.get(k);
        return null;
    }
}
