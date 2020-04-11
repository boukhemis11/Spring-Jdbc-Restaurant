package dev;


import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.config.AppConfig;
import dev.dao.PlatDaoJdbc;
import dev.entite.Plat;
import dev.ihm.Menu;

public class AppSpringJava {

	public static void main(String[] args) {
		// Création du contexte Spring à partir d'une configuration Java
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// récupération du bean Menu
		Menu menu = context.getBean(Menu.class);
		menu.afficher();
		PlatDaoJdbc platDaoJdbc = context.getBean(PlatDaoJdbc.class);	

        List<Plat> plats = platDaoJdbc.listerPlats();
        for (Plat p : plats) {
           System.out.println(p.getNom());
        }
		context.close();
	}

}
