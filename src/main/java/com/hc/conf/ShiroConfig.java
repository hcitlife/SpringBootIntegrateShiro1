package com.hc.conf;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.hc.shiro.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //1.创建realm对象，使用自定义类
    @Bean(name = "userRealm")
    public UserRealm myShiroRealm() { //将自己的验证方式加入容器
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }

    //2.创建DefaultWebSecurityManager
    @Bean(name = "dwSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        //关联realm
        manager.setRealm(userRealm);
        return manager;
    }

    //3.创建ShiroFilterFactoryBean
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("dwSecurityManager") DefaultWebSecurityManager manager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(manager);

        //添加shiro的内置过滤器
        Map<String, String> map = new LinkedHashMap<>();
        //拦截
        map.put("/user/add", "authc");
        map.put("/user/update", "authc");
        map.put("/user/detail", "authc");
        map.put("/user/list", "authc");
        //授权，若当前登录用户未授权则会跳转到授权页面
        map.put("/user/add", "perms[user:add]");
        map.put("/user/update", "perms[user:update]");
        map.put("/user/detail", "perms[user:detail]");
        map.put("/user/list", "perms[user:list]");
        bean.setFilterChainDefinitionMap(map);
        bean.setLoginUrl("/login");
        //设置未授权页面
        bean.setUnauthorizedUrl("/unauth");

        //设置安全管理器
        return bean;
    }

    //Shiro整合thymeleaf
    @Bean
    public ShiroDialect getShiroDialect() {
        ShiroDialect shiroDialect = new ShiroDialect();
        return shiroDialect;
    }
}
