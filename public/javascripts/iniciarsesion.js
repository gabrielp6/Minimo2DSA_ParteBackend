$(document).ready(function(){

   $("#btnIniciarSesion").click(function(){
       var username = $('#username').val();
       var contraseña = $('#contraseña').val();
       $.ajax({
           headers: {
               'Accept': 'application/json',
               'Content-Type': 'application/json'
               },
               url: "/dsaApp/auth/iniciarSesion",
               type: "POST",
               data: JSON.stringify({"username": username, "password": password}),
               dataType:'json',

               success: function (response) {
                   myStorage.setItem("user",response.username);
                   myStorage.setItem("password",response.password);
                   myStorage.setItem("id",response.id);


                    message = '"Has iniciado sesión"';

               },
                error: function(error){

                   message = '"Nombre/contraseña mal introducido"';

               },
        });
    });