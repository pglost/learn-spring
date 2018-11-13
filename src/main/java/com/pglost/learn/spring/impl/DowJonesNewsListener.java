package com.pglost.learn.spring.impl;

import com.pglost.learn.spring.FXNewsBean;
import com.pglost.learn.spring.IFXNewsListener;
import org.springframework.stereotype.Component;

@Component
public class DowJonesNewsListener implements IFXNewsListener{

    public String[] getAvailableNewsIds() {
        return new String[]{"0"};
    }

    public FXNewsBean getNewsByPk(String newsId) {
        return new FXNewsBean();
    }

    public void postProcessIfNecessary(String newsId) {

    }
}
