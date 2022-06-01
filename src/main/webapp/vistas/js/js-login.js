function mostrarPassword() {
    let password = document.getElementById('password');
    password.type = 'text';
    let mostrar_password = document.getElementById('mostrar-password');
    mostrar_password.hidden = "hidden";
    let ocultar_password = document.getElementById('ocultar-password');
    ocultar_password.hidden = "";
}
function ocultarPassword() {
    let password = document.getElementById('password');
    password.type = "password";
    let mostrar_password = document.getElementById('mostrar-password');
    mostrar_password.hidden = "";
    let ocultar_password = document.getElementById('ocultar-password');
    ocultar_password.hidden = "hidden";
}
function limpiarCampos() {
    let usuario = document.getElementById('usuario');
    let password = document.getElementById('password');

    usuario.value = "";
    password.value = "";
}
function deshabilitaRetroceso() {
    window.location.hash = "no-back-button";
    window.location.hash = "Again-No-back-button"; //chrome
    window.onhashchange = function () {
        window.location.hash = "";
    }
}

