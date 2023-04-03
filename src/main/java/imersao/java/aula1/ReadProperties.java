package imersao.java.aula1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

     public String getProperties(String key) {

         // recupera a chave da api gravada no arquivo config.properties
         Properties prop = new Properties();
         String propFileName = "config.properties";
         try {
             InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(propFileName);
             prop.load(inputStream);
             return prop.get(key).toString();
         }catch (IOException ex){
             System.out.println(ex.getLocalizedMessage());
             return null;
         }
     }

}
