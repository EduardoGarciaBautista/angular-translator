package com.upax.app.services.login.service;

import com.upax.app.data.dto.RequestLogin;
import com.upax.app.data.dto.ResponseLogin;
import com.upax.app.data.entity.Usuario;
import com.upax.app.data.repository.UsuarioRepository;
import com.upax.app.utils.CodigosRespuestaConst;
import com.upax.app.utils.MensajeConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseLogin loguearUsuario(RequestLogin requestLogin) {

        Optional<Usuario> usuario = usuarioRepository.findUserByUsserAndPassword(requestLogin.getUsuario(),
                requestLogin.getContrasena());

        return usuario.map(value -> new ResponseLogin(value, CodigosRespuestaConst.USUARIO_EXISTENTE_CODIGO,
                MensajeConst.USUARIO_EXISTENTE)).orElse(new ResponseLogin(null,
                CodigosRespuestaConst.USUARIO_INEXISTENTE_CODIGO,
                MensajeConst.USUARIO_INEXISTENTE));
    }
}
