package cigma.mini.project.ecommerce.utils;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@Component
public class Prop {

    private static final Logger log = Logger.getLogger(Prop.class);
    private static FileReader reader;
    private static File fileProp = null;
    private static Properties prop = new Properties();


    @Bean
    public static Properties getPropertiesApp() throws IOException {
        try {
            fileProp = new File("src\\main\\resources\\application.properties");
            reader = new FileReader(fileProp);
            prop.load(reader);
            return prop;
        } catch (IOException e) {
            log.error(e,e);
        }

        return prop;

    }

    @Bean
    public static Properties getPropertiesDataSource() throws IOException {
        try {
            fileProp = new File("src\\main\\resources\\application-dataSource.properties");
            reader = new FileReader(fileProp);
            prop.load(reader);
            return prop;
        } catch (IOException e) {
            log.error(e,e);
        }

        return prop;
    }




}
