<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Cliente"%>
<%@page import="logica.FormaDePago"%>
<%@page import="logica.Servicio"%>
<%@page import="logica.TipoDeServicio"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!--
  Material Design Lite
  Copyright 2015 Google Inc. All rights reserved.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      https://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License
-->
<html lang="es" xmlns="http://www.w3.org/1999/html">
<head>
    <link rel="icon" type="image/png" href="images/DB_16х16.png">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="A front-end template that helps you build fast, modern mobile web apps.">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Chalten Turismo</title>

    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">


    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-title" content="Material Design Lite">


    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="images/touch/ms-touch-icon-144x144-precomposed.png">
    <meta name="msapplication-TileColor" content="#3372DF">

    <!-- SEO: If your mobile URL is different from the desktop URL, add a canonical link to the desktop page https://developers.google.com/webmasters/smartphone-sites/feature-phones -->
    <!--
    <link rel="canonical" href="http://www.example.com/">
    -->

    <link href='https://fonts.googleapis.com/css?family=Roboto:400,500,300,100,700,900' rel='stylesheet'
          type='text/css'>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!-- inject:css -->
    <link rel="stylesheet" href="css/lib/getmdl-select.min.css">
    <link rel="stylesheet" href="css/lib/nv.d3.min.css">
    <link rel="stylesheet" href="css/application.min.css">
    <!-- endinject -->

</head>
<body>
    <!––valido si hay sesion iniciada*-->
   <%HttpSession misession=request.getSession();
   String usu=(String) misession.getAttribute("usuario");
    if (usu==null){
        response.sendRedirect("login.jsp");
       }
       else{
       
    }
   SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
   %>
    
    
    
    
<div class="mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header is-small-screen">
    <header class="mdl-layout__header">
        <div class="mdl-layout__header-row">
            <div class="mdl-layout-spacer"></div>
            <!-- Search-->
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable">
                
                <label class="mdl-button mdl-js-button mdl-button--icon" for="search">
                    <i class="material-icons">search</i>
                </label>

                <div class="mdl-textfield__expandable-holder">
                    <input class="mdl-textfield__input" type="text" id="search"/>
                    <label class="mdl-textfield__label" for="search">Enter your query...</label>
                </div>
            </div>
            <h1>CHALTEN VIAJES</h1>
    </header>

    <div class="mdl-layout__drawer">
        <header>MENÚ</header>
        <div class="scroll__wrapper" id="scroll__wrapper">
            <div class="scroller" id="scroller">
                <div class="scroll__container" id="scroll__container">
                    <nav class="mdl-navigation">
                        <a class="mdl-navigation__link mdl-navigation__link--current" href="index.jsp">
                            <i class="material-icons" role="presentation">home</i>
                            Inicio
                        </a>
                        <div class="sub-navigation">
                            <a class="mdl-navigation__link">
                                <i class="material-icons">people</i>
                                Empleados
                                <i class="material-icons">keyboard_arrow_down</i>
                            </a>
                            
                            <div class="mdl-navigation">
                                <a class="mdl-navigation__link" href="altaEmpleados.jsp">                             
                                    Registrar
                                </a>                                                              
                                <form action="SvVerEmpleados" method="GET">
                                <a class="mdl-navigation__link" href="SvVerEmpleados">
                                    Administrar
                                </a>
                                </form>                                                               
                            </div>
                        </div>
                        <div class="sub-navigation">
                            <a class="mdl-navigation__link">
                                <i class="material-icons">people</i>
                                Clientes
                                <i class="material-icons">keyboard_arrow_down</i>
                            </a>
                            
                            <div class="mdl-navigation">
                                 <a class="mdl-navigation__link" href="altaCliente.jsp">                             
                                    Registrar
                                </a>                                                              
                                <form action="SvVerCliente" method="GET">
                                <a class="mdl-navigation__link" href="SvVerCliente">
                                    Administrar
                                </a>
                                </form>                                                             
                            </div>
                        </div>
                        <div class="sub-navigation">
                            <a class="mdl-navigation__link">
                                <i class="material-icons">explore</i>
                                Servicios
                                <i class="material-icons">keyboard_arrow_down</i>
                            </a>
                            
                            <div class="mdl-navigation">
                                <form action="SvVerTipoServicio" method="GET">
                                <a class="mdl-navigation__link" href="SvVerTipoServicio">                             
                                    Registrar
                                </a>
                                </form>
                                <form action="SvVerServicio" method="GET">
                                <a class="mdl-navigation__link" href="SvVerServicio">
                                    Administrar
                                </a>
                                </form>                                                             
                            </div>
                        </div>
                        
                        
                        <div class="sub-navigation">
                            <a class="mdl-navigation__link">
                                <i class="material-icons">explore</i>
                                Paquetes
                                <i class="material-icons">keyboard_arrow_down</i>
                            </a>
                            
                            <div class="mdl-navigation">
                                
                                <form action="" method="GET">
                                <a class="mdl-navigation__link" href="">
                                    Administrar
                                </a>
                                </form>                                                             
                            </div>
                        </div>
                        <div class="sub-navigation">
                            <a class="mdl-navigation__link">
                                <i class="material-icons">explore</i>
                                Ventas
                                <i class="material-icons">keyboard_arrow_down</i>
                            </a>
                            <div class="mdl-navigation">
                                <form action="SvVenta" method="GET">
                                <a class="mdl-navigation__link" href="SvVenta">                             
                                    Servicios
                                </a>
                                </form>
                                <form action="SvVentaPaquetes" method="GET">
                                <a class="mdl-navigation__link" href="SvVentaPaquetes">                             
                                    Paquetes
                                </a>
                                </form>
                                <form action="" method="">
                                <a class="mdl-navigation__link" href="">
                                    Administrar
                                </a>
                                </form>                                                             
                            </div>
                        </div>
                       
                        
                        <a class="mdl-navigation__link" href="login.jsp">
                            <i class="material-icons" role="presentation">Login</i>
                            Login
                        
                        
                        <div class="mdl-layout-spacer"></div>
                        <hr>
                        <a class="mdl-navigation__link" href="https://github.com/CreativeIT/getmdl-dashboard">
                            <i class="material-icons" role="presentation">link</i>
                            GitHub
                        </a>
                    </nav>
                </div>
            </div>
            <div class='scroller__bar' id="scroller__bar"></div>
        </div>
    </div>
        <main class="mdl-layout__content mdl-color--grey-100">
            <div class="mdl-card mdl-shadow--2dp employer-form" action="#">
                <div class="mdl-card__title">
                    <h2>Registro de servicios</h2>
                    <div class="mdl-card__subtitle">Complete los datos del servicio a registrar</div>
                </div>

                <div class="mdl-card__supporting-text">
                                       
                        <div class="form__article">
                            <form action="SvVenta" method="POST" class="form">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label full-size">                           
                                <select class="mdl-textfield__input"  type="text" name="idServicio">
                                    <option></option>
                                    <%HttpSession sesion = request.getSession();
                                    List <Servicio> listaSer = (List) sesion.getAttribute("listServicios");                               
                                    for (Servicio serv : listaSer){%>
                                    <%String nombre = serv.getNombre();
                                    int idServ = serv.getCodigo_serv();%>
                                    <option class="black" value="<%=idServ%>"> <%=nombre%></option>
                                    <%}%>
                                </select>
                                <label class="mdl-textfield__label" for="nombre">Servicio</label>
                            </div>
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label full-size">
                                
                                <select class="mdl-textfield__input"  type="text" name="idCliente">
                                    <option></option>
                                    <%List <Cliente> listaCliente = (List) sesion.getAttribute("listClientes");                               
                                    for (Cliente client : listaCliente){%>
                                    <%String nombreClien = client.getNombre();
                                    String apellidoClien = client.getApellido();
                                    String nombreComp = nombreClien + " " + apellidoClien;
                                    int idCliente = client.getId_cliente();%>
                                    <option class="black" value="<%=idCliente%>" ><%=nombreComp%></option>                                  
                                    <%}%>
                                </select>
                                <label class="mdl-textfield__label" for="nombre">Cliente</label>
                            </div>
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label full-size">
                                
                                <% String nomVend =(String) sesion.getAttribute("nombreEmpleado");%>
                                <input class="mdl-textfield__input" type="text" name="vendedor" value="<%=nomVend%>">
                                <label class="mdl-textfield__label" for="vendedor"> Vendedor </label>
                            </div>    
                             <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label full-size">
                                <input class="mdl-textfield__input" type="text" name="fechaVenta">
                                <label class="mdl-textfield__label" for="fechaVenta">Fecha de venta</label>
                            </div>
                             <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label full-size">
                                <input class="mdl-textfield__input" type="text" name="fechaIn">
                                <label class="mdl-textfield__label" for="fechaIn">Fecha desde</label>
                            </div>
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label full-size">
                                <input class="mdl-textfield__input" type="text" name="fechaFin">
                                <label class="mdl-textfield__label" for="fechaFin">Fecha hasta</label>
                            </div>
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label full-size">                           
                                <select class="mdl-textfield__input"  type="text" name="idFormaPago">
                                    <option></option>
                                    <%List <FormaDePago> listafPago = (List) sesion.getAttribute("listFormaPago");                               
                                    for (FormaDePago fPago : listafPago){%>
                                    <%String formaPago = fPago.getNombre();
                                    int idFormaPago = fPago.getId();%>
                                    <option class="black" value="<%=idFormaPago%>"><%=formaPago%></option>
                                                                      
                                    <%}%>
                                </select>
                                <label class="mdl-textfield__label" for="nombre">Forma de pago</label>
                            </div>
                                                         
                            <div class="mdl-layout-spacer"></div>
                            <a href="index.jsp">
                                <button class="mdl-button mdl-js-button mdl-button--raised color--light-blue" type="submit" >
                                    REGISTRAR
                                </button>
                            </a>
                            <a href="tipoServicio.jsp"
                                class="mdl-button mdl-js-button mdl-button--raised color--green" >
                                    AGREGAR TIPO DE SERVICIO
                                
                            </a>
                            </form>
                            
                        </div>
                    
                </div>
            </div>
        </main>
    </div>

<!-- inject:js -->
<script src="js/d3.min.js"></script>
<script src="js/getmdl-select.min.js"></script>
<script src="js/material.min.js"></script>
<script src="js/nv.d3.min.js"></script>
<script src="js/layout/layout.min.js"></script>
<script src="js/scroll/scroll.min.js"></script>
<script src="js/widgets/charts/discreteBarChart.min.js"></script>
<script src="js/widgets/charts/linePlusBarChart.min.js"></script>
<script src="js/widgets/charts/stackedBarChart.min.js"></script>
<script src="js/widgets/employer-form/employer-form.min.js"></script>
<script src="js/widgets/line-chart/line-charts-nvd3.min.js"></script>
<script src="js/widgets/map/maps.min.js"></script>
<script src="js/widgets/pie-chart/pie-charts-nvd3.min.js"></script>
<script src="js/widgets/table/table.min.js"></script>
<script src="js/widgets/todo/todo.min.js"></script>
<!-- endinject -->

</body>
</html>

