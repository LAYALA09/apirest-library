package ar.com.ada.online.second.library.controller;

import ar.com.ada.online.second.library.model.dto.AuthorDTO;
import ar.com.ada.online.second.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class AuthorController {
    /*permite inyectar unas dependencias con otras dentro de Spring,
    En este caso, estamos inyectando la capa de servicio, y por eso no tenemos que instanciarla*/
    @Autowired
    private AuthorService authorService;

    /*es una anotación compuesta que actúa como un acceso directo*/
    @PostMapping({"/book/{bookId}/author", "/book/{bookId}/author/"})
    public ResponseEntity postBooktMethod(
            @Valid @RequestBody AuthorDTO dto,
            @PathVariable Long booktId) throws URISyntaxException {
        /**
         * Este metodo tiene una definicion especial ya que la entidad Author tiene relacion
         * con book, y al momento de crear un Albun, es necesario indicarle a que artista estara
         * asociado, es por ello que en la URL y en el parametro del metodo se coloca una varia (artistId)
         * para indicar cual es el id del artista a buscar en la base de datos para asociarlo a los datos
         * que llegan en el body (dto)
         *
         * esa logica esta en el servicio.
         */
    return null;
    }
}



