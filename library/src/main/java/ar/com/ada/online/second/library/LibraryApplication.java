package ar.com.ada.online.second.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*indica que la clase en la que se encuentra contiene la configuración principal del proyecto,
indica que se aplicará la configuración automática del starter que hemos utilizado,
ayuda a localizar elementos etiquetados con otras anotaciones cuando sean necesarios.*/
@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
        /*Dicho método, en caso de implementar una aplicación con Spring, deberá llamar al método run de la clase SpringApplication*/
		SpringApplication.run(LibraryApplication.class, args);
	}

}
