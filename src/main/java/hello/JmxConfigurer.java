package hello;

import javax.annotation.PostConstruct;
import javax.management.MBeanServer;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.management.ManagementService;

@Component
public class JmxConfigurer {

    @Autowired
    private ObjectProvider<MBeanServer> mBeanServerProvider;

    @Autowired
    private CacheManager cacheManager;

    @PostConstruct
    public void initJmx() {
        MBeanServer mBeanServer = this.mBeanServerProvider.getIfAvailable();
        if (mBeanServer != null) {
            ManagementService.registerMBeans(this.cacheManager, mBeanServer, true, true, true, true, true);
        }
    }

}
