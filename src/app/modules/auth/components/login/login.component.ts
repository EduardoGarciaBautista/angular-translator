import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {LoginService} from "../../../../core/services/login/login.service";
import {Router} from "@angular/router";
import Swal from 'sweetalert2';
import {TranslateService} from "@ngx-translate/core";


@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

    form: FormGroup;

    languages: string[] = [];
    languageSelected: string = '';

    constructor(private formBuilder: FormBuilder,
                private loginService: LoginService,
                private router: Router,
                private translateService: TranslateService) {
        this.generarFormulario();
        this.languages = translateService.getLangs();
        this.languageSelected = translateService.currentLang;
    }

    ngOnInit(): void {
    }

    generarFormulario() {
        this.form = this.formBuilder.group({
            usuario: [null, [Validators.required, Validators.minLength(3), Validators.maxLength(50)]],
            contrasena: [null, [Validators.required, Validators.minLength(5), Validators.maxLength(30)]]
        });
    }

    logear() {
        if (this.form.valid) {
            this.loginService.logear(this.form.value).subscribe((result) => {
                if (result.codigo === 200) {
                    let saludo: string = '';
                    this.translateService.get('SALUDO').subscribe(res => {
                        saludo = res;
                    })
                    this.router.navigate(['/home', result.usuario.idUsuario]);
                    Swal.fire({
                        title: saludo,
                        icon: 'success'
                    });

                } else {
                    Swal.fire({
                        title: 'Usuario o contraseña incorrecto',
                        icon: 'error'
                    });
                }
            }, (error => {
                console.log(error)
            }))
        }
    }

    /**
     * Metodo para validar si el control tiene algun error dependiendo el parametro
     * @param control
     * @param error
     */
    tieneError(control: string, error: string): boolean {
        return this.form.get(control).hasError(error);
    }

    establecerIdioma(valor: string) {
        this.translateService.use(valor);
    }
}
