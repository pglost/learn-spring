package com.pglost.learn.spring;


/**
 * Hello world!
 *
 */
public class FXNewsProvider
{
    private IFXNewsListener newsListener;
    private IFXNewsPersister newsPersister;

    public FXNewsProvider(IFXNewsListener newsListener, IFXNewsPersister newsPersister) {
        this.newsListener = newsListener;
        this.newsPersister = newsPersister;
    }

    public void setNewsListener(IFXNewsListener newsListener) {
        this.newsListener = newsListener;
    }

    public void setNewsPersister(IFXNewsPersister newsPersister) {
        this.newsPersister = newsPersister;
    }

    public void getAndPersistNews(){
        String[] newsIds = newsListener.getAvailableNewsIds();
        if(newsIds == null || newsIds.length == 0) {
            return;
        }
        for (String newsId : newsIds) {
            FXNewsBean newsBean = newsListener.getNewsByPk(newsId);
            newsPersister.persistNews(newsBean);
            newsListener.postProcessIfNecessary(newsId);
        }
    }
}
