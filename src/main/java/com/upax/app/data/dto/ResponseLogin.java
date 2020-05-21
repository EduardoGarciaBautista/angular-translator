package com.upax.app.data.dto;

import com.upax.app.data.entity.Usuario;

public class ResponseLogin {
    private Usuario usuario;
    private Integer codigo;
    private String mensaje;

    public ResponseLogin() {

    }

    public ResponseLogin(Usuario usuario, Integer codigo, String mensaje) {
        this.usuario = usuario;
        this.codigo = codigo;
        this.mensaje = mensaje;
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
