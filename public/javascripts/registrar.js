$(document).ready(function(){

    $("#btnRegistrar").click(function(){
        var username = $('#username').val();
        var correo = $('#correo').val();
        var contraseña = $('#contraseña').val();
        var contraseñarepetida = $('#contraseñarepetida').val();
            if(contraseñarepetida == contraseñarepetida){
                $.ajax({
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    url: "/dsaApp/auth/registrarUsuario",
                    type: "POST",
                    data: JSON.stringify({"username": username, "contraseña": contraseña, "correo": correo}),
                    dataType:'json',

                    success: function (response) {
                    console.log("Registrado");

                    },
                    error: function(error){
                    message = '"Error"';
                    console.log("Error", error);
                    },

                    });
            }

            else{
                    message = '"Las contraseñas no coinciden"';

            }
    });