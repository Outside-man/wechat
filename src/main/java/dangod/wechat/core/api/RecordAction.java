package dangod.wechat.core.api;

public interface RecordAction {
    /**
     *
     * @param openid
     * @param actionId
     * @return
     * 正数表示存储成功 0 保存成功(无问题) 1用户未储存(已解决)
     * 复数表示存储失败 -1 动作未定义(未解决)
     */
    Integer Record(String openid, Integer actionId);
}
