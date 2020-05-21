import {Usuario} from "./Usuario.model";

export interface LoginModel {
    usuario: string;
    contrasena: string;
}

export interface LoginResponse {
    mensaaje: string;
    codigo: number;
    usuario: Usuario;
}
