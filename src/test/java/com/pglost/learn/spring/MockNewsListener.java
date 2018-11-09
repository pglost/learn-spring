package com.pglost.learn.spring;

public class MockNewsListener implements IFXNewsListener{

    public String[] getAvailableNewsIds() {
        throw new FXNewsRetrieveFailureException();
    }

    public FXNewsBean getNewsByPk(String newsId) {
        return null;
    }

    public void postProcessIfNecessary(String newsId) {

    }
}
