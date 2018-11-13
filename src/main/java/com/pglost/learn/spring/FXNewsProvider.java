package com.pglost.learn.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Hello world!
 *
 */
@Component
public class FXNewsProvider
{
    @Autowired
    private IFXNewsListener newsListener;
    @Autowired
    private IFXNewsPersister newsPersister;

    public FXNewsProvider() {
    }

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
