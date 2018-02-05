package dangod.wechat.core.api;

import dangod.wechat.core.model.follower.Follower;

public interface FollowerGetter {
    String getFollowerJSON(String openId);
    String getFollowerJSON(String openId, String lang);
    Follower getFollower(String openId);
    Follower getFollower(String openId, String lang);
}
