package com.upax.app.services.crud.controller;

import com.upax.app.data.dto.ResponseCrud;
import com.upax.app.data.dto.ResponseLogin;
import com.upax.app.data.entity.Usuario;
import com.upax.app.services.crud.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CrudController {
    @Autowired
    private CrudService crudService;

    /**
     *
     * @param usuario recibe la entidad completa para hacer un registro
     * @return una respuesta con un codigo y un mensaje
     */
    @PostMapping("altaUsuario")
    public ResponseCrud alta(@RequestBody Usuario usuario) {
        return crudService.crearUsuario(usuario);
    }

    /**
     *
     * @param usuario recibe la entidad completa para hacer un update
     * @return una respuesta con un codigo y un mensaje
     */
    @PostMapping("editarUsuario")
    public ResponseCrud editar(@RequestBody Usuario usuario) {
        return crudService.editarUsuario(usuario);
    }


    /**
     *
     * @param idUsuario hace referencia la primary key de la tabla
     * @return una respuesta con un codigo y un mensaje
     */
    @GetMapping("borrarUsuario/{idUsuario}")
    public ResponseCrud alta(@PathVariable("idUsuario") Integer idUsuario) {
        return crudService.eliminarUsuario(idUsuario);
    }

    /**
     *
     * @param idUsuario recibe el idUsuario  para buscar en la BD
     * @return la respuesta de la consulta
     */

    @GetMapping("consultaUsuario/{idUsuario}")
    public ResponseLogin consulta(@PathVariable("idUsuario") Integer idUsuario) {
        return crudService.consultarUsuario(idUsuario);
    }
}
