package dangod.wechat.core.model.message.resp;

import dangod.wechat.core.model.message.resp.bo.News;

import java.util.List;

import static dangod.wechat.core.constant.MessageType.RESP_MESSAGE_TYPE_NEWS;

public class NewsMessage extends BaseMessage {
    public NewsMessage(String fromUserName, String openId){
        this.setFromUserName(fromUserName);
        this.setToUserName(openId);
        this.setMsgType(RESP_MESSAGE_TYPE_NEWS);
    }
    public NewsMessage(String fromUserName, String openId, List<News> articles){
        this.setFromUserName(fromUserName);
        this.Articles = articles;
        this.ArticleCount = articles.size();
        this.setToUserName(openId);
        this.setMsgType(RESP_MESSAGE_TYPE_NEWS);
    }

    public NewsMessage() {
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
        this.ArticleCount = articles.size();
    }
}

