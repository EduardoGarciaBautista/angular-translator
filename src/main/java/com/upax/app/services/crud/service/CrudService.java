package com.upax.app.services.crud.service;

import com.upax.app.data.dto.ResponseCrud;
import com.upax.app.data.dto.ResponseLogin;
import com.upax.app.data.entity.Usuario;
import com.upax.app.data.repository.UsuarioRepository;
import com.upax.app.utils.CodigosRespuestaConst;
import com.upax.app.utils.MensajeConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CrudService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public ResponseCrud crearUsuario(Usuario usuario) {
        usuarioRepository.saveAndFlush(usuario);
        return new ResponseCrud(CodigosRespuestaConst.CRUD_USUARIO_OK_CODE, MensajeConst.USUARIO_CREADO);
    }

    public ResponseCrud editarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
        return new ResponseCrud(CodigosRespuestaConst.CRUD_USUARIO_OK_CODE, MensajeConst.USUARIO_EDITADO);
    }


    public ResponseCrud eliminarUsuario(Integer idUsuario) {
        usuarioRepository.deleteById(idUsuario);
        final boolean existeRegistro = usuarioRepository.existsById(idUsuario);
        if (existeRegistro) {
            return new ResponseCrud(CodigosRespuestaConst.CRUD_USUARIO_OK_CODE, MensajeConst.USUARIO_ELIMINADO);
        } else {
            return new ResponseCrud(CodigosRespuestaConst.USUARIO_EXISTENTE_CODIGO, MensajeConst.USUARIO_INEXISTENTE);
        }
    }


    public ResponseLogin consultarUsuario(Integer idUsuario) {
        Optional<Usuario> usuarioConsulta =
                usuarioRepository.findById(idUsuario);
        return usuarioConsulta.map(user -> new ResponseLogin(user, CodigosRespuestaConst.USUARIO_EXISTENTE_CODIGO,
                MensajeConst.USUARIO_EXISTENTE)).orElse(new ResponseLogin(null, CodigosRespuestaConst.USUARIO_INEXISTENTE_CODIGO,
                MensajeConst.USUARIO_INEXISTENTE));
    }

}
