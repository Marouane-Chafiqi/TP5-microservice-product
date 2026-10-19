package ma.spring.ma.product;

import ma.spring.ma.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestHibernate {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("Contexte Spring initialisé avec succès !");
        context.close();
    }
}