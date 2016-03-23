package com.avinode.databasetester.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * AjaxBean
 *
 * @author <a href="mailto:lorinc.sonnevend@avinode.com">Lorinc Sonnevend</a>
 *         <p>
 *         Created on 23/03/16.
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AjaxBean {

    private int counter;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
