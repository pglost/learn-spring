package com.pglost.learn.spring;

public interface IFXNewsListener {
    String[] getAvailableNewsIds();
    FXNewsBean getNewsByPk(String newsId);
    void postProcessIfNecessary(String newsId);
}
