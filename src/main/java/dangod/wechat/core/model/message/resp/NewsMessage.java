package dangod.wechat.core.model.message.resp;

import dangod.wechat.core.model.message.resp.BaseMessage;

import java.util.List;

public class NewsMessage extends BaseMessage {
    public NewsMessage(String openId){
        this.setToUserName(openId);
        this.setMsgType("news");
    }

    // 图文消息个数，限制为10条以内
    private int ArticleCount;
    // 多条图文消息信息，默认第一个item为大图
    private List<News> Articles;

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<News> getArticles() {
        return Articles;
    }

    public void setArticles(List<News> articles) {
        Articles = articles;
    }
}

