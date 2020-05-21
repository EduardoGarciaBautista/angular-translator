package com.upax.app.data.dto;

public class ResponseCrud {
    private Integer codigo;
    private String mensaje;

    public ResponseCrud() {

    }

    public ResponseCrud(Integer codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
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
