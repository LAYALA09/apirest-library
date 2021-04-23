package ar.com.ada.online.second.library.controller;

import ar.com.ada.online.second.library.model.dto.AuthorDTO;
import ar.com.ada.online.second.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class AuthorController {
    /*permite inyectar unas dependencias con otras dentro de Spring,
    En este caso, estamos inyectando la capa de servicio, y por eso no tenemos que instanciarla*/
    @Autowired
    private AuthorService authorService;

    /*es una anotación compuesta que actúa como un acceso directo*/
    @PostMapping({"/book/{bookId}/author", "/book/{bookId}/author/"})
    public ResponseEntity postArtistMethod(
            @Valid @RequestBody AuthorDTO dto,
            @PathVariable Long artistId) throws URISyntaxException {
        /**
         * Este metodo tiene una definicion especial ya que la entidad Author tiene relacion
         * con book, y al momento de crear un Albun, es necesario indicarle a que artista estara
         * asociado, es por ello que en la URL y en el parametro del metodo se coloca una varia (artistId)
         * para indicar cual es el id del artista a buscar en la base de datos para asociarlo a los datos
         * que llegan en el body (dto)
         *
         * esa logica esta en el servicio.
         */
        AuthorDTO authorDTO = authorServices.createNew(dto, bookId);

        URI uri = new URI("/artist/" + albumSa-ved.getId());

        return ResponseEntity
                .created(uri)
                .body(albumSaved);
    }


    @GetMapping({ "/albums", "/albums/" })

    public ResponseEntity getAlbumsMethod() {
        // se llama al servicio y se le pide el listado de albums

        List<AlbumDTO> albums = albumServices.getAll();

        // se crea el response request
        return ResponseEntity
                .ok()
                .body(albums);
    }

    @GetMapping({ "/albums/{id}", "/albums/{id}/" })

    public ResponseEntity getAlbumByIdMet-hod(@PathVariable Long id) {

        AlbumDTO byId = albumServices.getById(id);

        return ResponseEntity
                .ok()
                .body(byId);
    }


    @DeleteMapping({ "/albums/{id}", "/albums/{id}/" })

    public ResponseEntity deleteAlbumByIdMet-hod(@PathVariable Long id) {
        albumServices.remove(id);
        return ResponseEntity
                .noContent()
                .build();
    }


    @PatchMapping({ "/artists/{artistId}/albums/{albumId}", "/artists/{artistId}/albums/{albumId}/" })

    public ResponseEntity patchArtistByIdMethod(

            @RequestBody AlbumDTO dto,
            @PathVariable Long artistId,
            @PathVariable Long albumId) {

        AlbumDTO albumUpdated = albumServi-ces.update(dto, artistId, albumId);

        return ResponseEntity
                .ok()
                .body(albumUpdated);
    }




}



