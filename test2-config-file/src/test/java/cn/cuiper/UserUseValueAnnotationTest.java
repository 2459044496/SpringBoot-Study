package cn.cuiper;

import cn.cuiper.config.PlaceholderProperties;
import cn.cuiper.config.RandomValuePropertySource;
import cn.cuiper.config.UserUseConfigurationPropertiesAnnotation;
import cn.cuiper.config.UserUseValueAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
@Slf4j
public class UserUseValueAnnotationTest {

    @Autowired
    private UserUseValueAnnotation valueAnnotation;

    @Autowired
    private UserUseConfigurationPropertiesAnnotation configurationPropertiesAnnotation;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private RandomValuePropertySource randomValuePropertySource;

    @Autowired
    private PlaceholderProperties placeholderProperties;


    @Test
    public void test() {
        log.info(valueAnnotation.toString());
        log.info(configurationPropertiesAnnotation.toString());
        log.info(randomValuePropertySource.toString());
        log.info(placeholderProperties.toString());
    }

    @Test
    public void test2() {
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            //log.info(beanDefinitionName);
        }

        boolean useBeanAnnotation = context.containsBean("useBeanAnnotation");
        log.info("useBeanAnnotation is:{}", useBeanAnnotation);
        boolean useImportResourceAnnotation = context.containsBean("useImportResourceAnnotation");
        log.info("useImportResourceAnnotation is:{}", useImportResourceAnnotation);

    }

}
