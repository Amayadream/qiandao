package com.amayadream.qiandao.web.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Spring 初始化监听器
 * @author :  Amayadream
 * @date :  2017.03.15 18:22
 */
@Component
public class SpringListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(event.getApplicationContext().getParent() == null){

        }
    }

}
