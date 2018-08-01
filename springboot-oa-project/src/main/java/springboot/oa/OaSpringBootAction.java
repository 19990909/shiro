package springboot.oa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by lsf on 2017/12/21.
 */
@SpringBootApplication
@EnableTransactionManagement
@ServletComponentScan
@MapperScan("springboot.oa.dao")
public class OaSpringBootAction extends SpringBootServletInitializer {
    public static void main(String[] args){
        SpringApplication.run(OaSpringBootAction.class,args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(OaSpringBootAction.class);
    }
}
