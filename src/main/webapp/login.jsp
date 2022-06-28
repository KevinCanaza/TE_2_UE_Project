<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/login.css">
        <title>Login</title>
        <style>
            body {
                height: 100vh;
                display: flex;
                background-attachment: fixed;
                align-items: center;
                justify-content: center;
                background-image: url(img/login/fondo_login.jpg);
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;
                color: white;

            }
        </style>
    </head>

    <body>
        <div class="container-form sign-up">

            <form action="LoginControlador" method="post" class="formulario">
                <h2 class="create-account">Iniciar Sesion</h2>
                <p class="cuenta-gratis">Ingrese sus Datos</p>
                <input type="text" name="usuario" placeholder="Usuario">
                <input type="password" name="password" placeholder="Contraseña">

                <button class="button" type="submit">Ingresar</button>

            </form>
            <form class="formulario2">
                <div class="center"><img class="center" src="img/invitado/invitado.png" alt=""></div>
                <div class="welcome-back">
                    <div class="message">
                        <h2>Bienvenido</h2>
                        <p>Ingresar como Invitado</p>
                        <div class="wrap">
                            <a href="invitado.jsp" class="a">Invitado</a>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>

</html>