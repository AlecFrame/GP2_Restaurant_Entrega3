package Vistas;

import Modelo.Producto;
import Modelo.Mesero;
import Modelo.Mesa;
import Persistencia.ProductosData;
import Persistencia.MeseroData;
import Persistencia.MesaData; 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class main {

    public static void main(String[] args) {
        VentPrincipal ventana = new VentPrincipal();
        ventana.setVisible(true);

        System.out.println("/////   Trabajo Práctico Restaurante, Grupo 2, 2024, Comision 2 /////");
        System.out.println("////\n///// por: Walter Alexander Vertacnik,");
        System.out.println("////       Soto Vela Luciano Ezequiel, ");
        System.out.println("////       Ferro Julieta, ");
        System.out.println("////       Pagnone Patricia, ");
        System.out.println("////       Muñoz Maycol\n//");

        Set<String> accionesValidas = new HashSet<>();
        ProductosData pdata = new ProductosData();
        MeseroData meseroData = new MeseroData();
        MesaData mesadata = new MesaData();
        accionesValidas.add("1");
        accionesValidas.add("2"); 
        accionesValidas.add("3");
        accionesValidas.add("4");
        
        String accion = "";
        Scanner leerInt = new Scanner(System.in);
        Scanner leerString = new Scanner(System.in);
        boolean seguir = true;

        do {
            try {
                Thread.sleep(20); // Breve pausa para cargar los prints
            } catch (InterruptedException e) {}
            System.out.println("/// Bienvenido al sistema de gestión del Restaurante Entre Amigos ///");
            System.out.println("// 1 - Gestión de productos");
            System.out.println("// 2 - Gestión de meseros");
            System.out.println("// 3 - Gestión de mesas");
            System.out.println("// 4 - Salir del sistema\n//");
            System.out.print("//// Ingrese una opción: ");
            accion = leerString.nextLine().toLowerCase();

            if (!accionesValidas.contains(accion)) {
                System.err.println("//// Opción inválida, inténtelo de nuevo");
            }

            switch (accion) {
                case "1": 
                    gestionarProductos(pdata, leerInt, leerString);
                    break;
                case "2": 
                    gestionarMeseros(meseroData, leerInt, leerString);
                    break;
                case "3":
                    gestionarMesas (mesadata, leerInt, leerString);
                    break;
                case "4":
                    seguir = false;
                    System.out.println("//// Saliendo del sistema...");
                    break;
            }

        } while (seguir);
        
    }

    private static void gestionarProductos(ProductosData pdata, Scanner leerInt, Scanner leerString) {
        Set<String> accionesValidas = new HashSet<>();
        accionesValidas.add("1");
        accionesValidas.add("2");
        accionesValidas.add("3");
        accionesValidas.add("4");
        accionesValidas.add("5");
        accionesValidas.add("6");
        accionesValidas.add("7");
        accionesValidas.add("listar");
        accionesValidas.add("guardar");
        accionesValidas.add("inhabilitar");
        accionesValidas.add("actualizar");
        accionesValidas.add("buscar");
        accionesValidas.add("filtrar");
        accionesValidas.add("salir");
        
        Set<String> categorias = new HashSet<>();
        categorias.add("1");
        categorias.add("2");
        categorias.add("3");
        categorias.add("4");
        categorias.add("5");
        categorias.add("6");
        categorias.add("7");
        categorias.add("pizzas");
        categorias.add("lomos");
        categorias.add("hamburguesas");
        categorias.add("tacos");
        categorias.add("bebidas con alcohol");
        categorias.add("bebidas sin alcohol");
        categorias.add("bebidas gaseosas");
        
        String accion = "";
        boolean seguir = true;
        int entidad = 1;
        
        if (entidad==1) {
        do {
            try {
            Thread.sleep(20); // 50 milisegundos para que poder cargar los prints a continuacion correctamente y no se sobrepongan
            } catch (InterruptedException e) {}
            System.out.println("/// Bienvenido a la consola para gestionar la base de datos de los productos del Restaurante Entre Amigos ///");
            System.out.println("//                 (1/listar) Lista los productos de la base de datos");
            System.out.println("//                 (2/buscar) Busca un producto en la base de datos por codigo del producto");
            System.out.println("//                 (3/guardar) Inserta un nuevo producto a la base de datos");
            System.out.println("//                 (4/inhabilitar) Cambia el Estado de un producto de la base de datos para deshabilitarlo");
            System.out.println("//                 (5/actualizar) Actualiza los datos de un producto por codigo del producto");
            System.out.println("//                 (6/filtrar) filtra los productos que quieras ver por categoria");
            System.out.println("//                 (7/salir) Volver\n//");

            accion = "";

            System.out.print("//// Ingrese a continuación el número o la palabra para realizar alguna acción\n//// : ");
            do {
                accion = leerString.nextLine();
                if (!accionesValidas.contains(accion.toLowerCase())) {
                    System.err.println("//// Accion invalida intentelo de nuevo");
                    System.out.print("//// : ");
                }
            } while (!accionesValidas.contains(accion.toLowerCase()));
            
            switch (accion.toLowerCase()) {
                case ("1") : case ("listar") : {
                    try {
                        ArrayList<Producto> lista = pdata.listar();
                        System.out.println("\n///// Lista de productos /////");
                        for (Producto p : lista) {
                            System.out.println(" - "+p);
                        }
                        System.out.println("");
                    } catch (SQLException ex) {
                        System.err.println("Error de SQL");
                    }
                    break;
                }
                case ("2") : case ("buscar") : { //////////////////  UN CASE  ///////////////////
                    Producto p = null;
                    boolean valido = true;
                    System.out.print("//// Ingrese la código del produto que quiera buscar\n//// : ");
                    do {
                        valido = true;
                        try {
                            p = pdata.buscar(leerInt.nextInt());
                        } catch (SQLException ex) {
                            System.err.println("Error de SQL");
                        } catch (Exception ex) {
                            System.err.println("El valor ingresado es invalido, tiene que ser un entero");
                            valido = false;
                        }
                        if (!valido) {
                            leerInt.next();
                            System.out.print("//// Código invalido, Intentelo nuevamente\n//// : ");
                        }
                    } while (!valido);
                    if (p==null) {
                        System.out.println("\nProducto no encontrado\n");
                    }else{
                        System.out.println("\n - "+p+"\n");
                    }
                    break;
                }
                case ("3") : case ("guardar") : { //////////////////  UN CASE  ///////////////////
                    Producto p = new Producto();
                    p.setCodigo(0);
                    boolean valido = true;
                    System.out.print("//// Ingrese el nombre del nuevo produto\n//// : ");
                    do {
                        valido = true;
                        p.setNombre(leerString.nextLine());
                        if (p.getNombre().trim().isEmpty()|p.getNombre().isEmpty()) {
                            System.err.print("//// El nombre del producto está vacio, intentelo nuevamente\n//// : ");
                            valido=false;
                        }
                    } while (!valido);
                    System.out.print("//// Ingrese el precio del nuevo producto\n//// : ");
                    do {
                        valido = true;
                        try {
                            p.setPrecio(leerInt.nextDouble());
                        } catch (InputMismatchException e) {
                            System.err.print("//// valor invalido, tiene que ser un numero, intentelo nuevamente\n//// : ");
                            leerInt.nextLine();
                            valido = false;
                        }
                    } while (!valido);
                    System.out.print("//// Ingrese (1|habilitado o 2|inhabilitado) para el estado del nuevo producto\n//// : ");
                    do {
                        valido = true;
                        String estado = leerString.nextLine();
                        switch (estado.toLowerCase()) {
                            case ("1") : case ("habilitado") : {
                                p.setEstado(true);break;
                            }
                            case ("2") : case ("inhabilitado") : {
                                p.setEstado(false);break;
                            }
                            default : {
                                System.err.print("//// Invalido debe ingresar una de estas opciones (1|habilitado o 2|inhabilitado), intentelo nuevamente\n//// : ");
                                valido = false;
                                break;
                            }
                        }
                    } while (!valido);
                    System.out.print("//// Ingrese un número entero para el stock del nuevo producto\n//// : ");
                    do {
                        valido = true;
                        try {
                            p.setStock(leerInt.nextInt());
                        } catch (InputMismatchException e) {
                            System.err.print("//// valor invalido, tiene que ser un entero, intentelo nuevamente\n//// : ");
                            leerInt.nextLine();
                            valido = false;
                        }
                    } while (!valido);
                    System.out.print("//// Ingrese la categoria (1:pizzas|2:lomos|3:hamburguesas|4:tacos|5:bebidas con alcohol|6:bebidas sin alcohol|7:bebidas gaseosas) del nuevo producto\n//// : ");
                    do {
                        valido = true;
                        String opcion = leerString.nextLine();
                        switch (opcion.toLowerCase()) {
                            case ("1") : case ("pizzas") : {
                                p.setCategoria("pizzas");break;
                            }
                            case ("2") : case ("lomos") : {
                                p.setCategoria("lomos");break;
                            }
                            case ("3") : case ("hamburguesas") : {
                                p.setCategoria("hamburguesas");break;
                            }
                            case ("4") : case ("tacos") : {
                                p.setCategoria("tacos");break;
                            }
                            case ("5") : case ("bebidas con alcohol") : {
                                p.setCategoria("bebidas con alcohol");break;
                            }
                            case ("6") : case ("bebidas sin alcohol") : {
                                p.setCategoria("bebidas sin alcohol");break;
                            }
                            case ("7") : case ("bebidas gaseosas") : {
                                p.setCategoria("bebidas gaseosas");break;
                            }
                            default : {
                                System.err.print("//// Invalido debe ingresar una de estas opciones (1:pizzas|2:lomos|3:hamburguesas|4:tacos|5:bebidas con alcohol|6:bebidas sin alcohol|7:bebidas gaseosas), intentelo nuevamente\n//// : ");
                                valido = false;
                                break;
                            }
                        }
                    } while (!valido);
                    System.out.print("\n//// ");
                    try {
                        pdata.guardarProducto(p);
                        p.setCodigo(pdata.listar().size());
                    } catch (SQLException ex) {
                        System.err.println("Error SQL al mostrar el producto guardado");
                    }
                    System.out.println(" - "+p+"\n");
                    break;
                }
                case ("4") : case ("inhabilitar") : { //////////////////  UN CASE  ///////////////////
                    boolean valido = true;
                    System.out.print("//// Ingrese el código del producto que desea inhabilitar\n//// : ");
                    do {
                        valido = true;
                        try {
                            pdata.CambiarEstado(false,leerInt.nextInt());
                        } catch (SQLException ex) {
                            System.err.println("Error de SQL");
                        } catch (Exception ex) {
                            System.err.println("El valor ingresado es invalido, tiene que ser un entero");
                            valido = false;
                        }
                        if (!valido) {
                            leerInt.next();
                            System.out.print("//// Código invalido, Intentelo nuevamente\n//// : ");
                        }
                    } while (!valido);
                    break;
                }
                case ("5") : case ("actualizar") : { //////////////////  UN CASE  ///////////////////
                    Producto p = new Producto(null, 0, false, 0, null);
                    boolean valido = true;
                    String opcions = null;
                    System.out.print("//// Ingrese el código del producto que desea actualizar, ingrese 0 para cancelar\n//// : ");
                    do {
                        valido = true;
                        opcions = String.valueOf(leerInt.nextInt());
                        if ("0".equals(opcions)) {
                            System.out.println("///// Operacion cancelada /////\n");
                            break;
                        }else{
                            try {
                                p.setCodigo(Integer.parseInt(opcions));
                            } catch (NumberFormatException ex) {
                                System.out.print("//// Código invalido, Intentelo nuevamente o ingrese 0 para cancelar\n//// : ");
                                leerInt.next();
                                valido = false;
                            }
                        }
                    } while (!valido);
                try {
                    if (pdata.buscar(p.getCodigo())!=null) {
                        System.out.print("//// Ingrese que atributos del producto desea actualizar: (nombre, precio, stock, categoria, estado) puede ponerlo asi para todos o solo algunos\n//// : ");
                        String filtros = leerString.nextLine().toLowerCase();
                        if (filtros.contains("nombre")) {
                            System.out.print("//// Ingrese el nuevo nombre del produto\n//// : ");
                            do {
                                valido = true;
                                p.setNombre(leerString.nextLine());
                                if (p.getNombre().trim().isEmpty()|p.getNombre().isEmpty()) {
                                    System.err.print("//// El nombre del producto está vacio, intentelo nuevamente\n//// : ");
                                    valido=false;
                                }
                            } while (!valido);
                        }
                        if (filtros.contains("precio")) {
                            System.out.print("//// Ingrese el precio del nuevo producto\n//// : ");
                            do {
                                valido = true;
                                try {
                                    p.setPrecio(leerInt.nextDouble());
                                } catch (InputMismatchException e) {
                                    System.err.print("//// valor invalido, tiene que ser un numero, intentelo nuevamente\n//// : ");
                                    leerInt.nextLine();
                                    valido = false;
                                }
                            } while (!valido);
                        }
                        if (filtros.contains("estado")) {
                            System.out.print("//// Ingrese (1|habilitado o 2|inhabilitado) para el nuevo estado del producto\n//// : ");
                            do {
                                valido = true;
                                String estado = leerString.nextLine();
                                switch (estado.toLowerCase()) {
                                    case ("1") : case ("habilitado") : {
                                        p.setEstado(true);break;
                                    }
                                    case ("2") : case ("inhabilitado") : {
                                        p.setEstado(false);break;
                                    }
                                    default : {
                                        System.err.print("//// Invalido debe ingresar una de estas opciones (1|habilitado o 2|inhabilitado), intentelo nuevamente\n//// : ");
                                        valido = false;
                                        break;
                                    }
                                }
                            } while (!valido);
                        }
                        if (filtros.contains("stock")) {
                            System.out.print("//// Ingrese un número entero para el nuevo stock del producto\n//// : ");
                            do {
                                valido = true;
                                try {
                                    p.setStock(leerInt.nextInt());
                                } catch (InputMismatchException e) {
                                    System.err.print("//// valor invalido, tiene que ser un entero, intentelo nuevamente\n//// : ");
                                    leerInt.nextLine();
                                    valido = false;
                                }
                            } while (!valido);
                        }
                        if (filtros.contains("categoria")) {
                            System.out.print("//// Ingrese la nueva categoria (1:pizzas|2:lomos|3:hamburguesas|4:tacos|5:bebidas con alcohol|6:bebidas sin alcohol|7:bebidas gaseosas) del producto\n//// : ");
                            do {
                                valido = true;
                                String opcion = leerString.nextLine();
                                switch (opcion.toLowerCase()) {
                                    case ("1") : case ("pizzas") : {
                                        p.setCategoria("pizzas");break;
                                    }
                                    case ("2") : case ("lomos") : {
                                        p.setCategoria("lomos");break;
                                    }
                                    case ("3") : case ("hamburguesas") : {
                                        p.setCategoria("hamburguesas");break;
                                    }
                                    case ("4") : case ("tacos") : {
                                        p.setCategoria("tacos");break;
                                    }
                                    case ("5") : case ("bebidas con alcohol") : {
                                        p.setCategoria("bebidas con alcohol");break;
                                    }
                                    case ("6") : case ("bebidas sin alcohol") : {
                                        p.setCategoria("bebidas sin alcohol");break;
                                    }
                                    case ("7") : case ("bebidas gaseosas") : {
                                        p.setCategoria("bebidas gaseosas");break;
                                    }
                                    default : {
                                        System.err.print("//// Invalido debe ingresar una de estas opciones (1:pizzas|2:lomos|3:hamburguesas|4:tacos|5:bebidas con alcohol|6:bebidas sin alcohol|7:bebidas gaseosas), intentelo nuevamente\n//// : ");
                                        valido = false;
                                        break;
                                    }
                                }
                            } while (!valido);
                        }
                        pdata.actualizar(p,filtros);
                        System.out.println(" - "+pdata.buscar(p.getCodigo())+"\n");
                        break;
                    }else {
                        if (!"0".equals(opcions)) {
                            System.err.println("Producto no encontrado");
                        }
                        break;
                    }
                } catch (SQLException ex) {
                    System.err.println("Error SQL: "+ex);
                }}
                case ("6") : case ("filtrar") : { //////////////////  UN CASE  ///////////////////
                    boolean valido = true;
                    String filtro = null;
                    System.out.print("//// Ingrese la nueva categoria (1:pizzas|2:lomos|3:hamburguesas|4:tacos|5:bebidas con alcohol|6:bebidas sin alcohol|7:bebidas gaseosas) del producto\n//// : ");
                    do {
                        valido = true;
                        filtro = leerString.nextLine();
                        if (!categorias.contains(filtro)) {
                            System.err.print("//// Invalido debe ingresar una de estas opciones (1:pizzas|2:lomos|3:hamburguesas|4:tacos|5:bebidas con alcohol|6:bebidas sin alcohol|7:bebidas gaseosas), intentelo nuevamente\n//// : ");
                            valido = false;
                        }else {
                            switch (filtro) {
                                case ("1") : {filtro="pizzas";break;}
                                case ("2") : {filtro="lomos";break;}
                                case ("3") : {filtro="hamburguesas";break;}
                                case ("4") : {filtro="tacos";break;}
                                case ("5") : {filtro="bebidas con alcohol";break;}
                                case ("6") : {filtro="bebidas sin alcohol";break;}
                                case ("7") : {filtro="bebidas gaseosas";break;}
                            }
                        }
                    } while (!valido);
                    try {
                        ArrayList<Producto> lista = pdata.filtrarCategoria(filtro);
                        System.out.println("\n///// Lista de productos de la categoria "+filtro+" /////");
                        for (Producto p : lista) {
                            System.out.println(" - "+p);
                        }
                        System.out.println("");
                    } catch (SQLException ex) {
                        System.err.println("Error de SQL: "+ex);
                    }
                    break;
                }
                case ("7") : case ("salir") : {
                    seguir = false;break;
                }
            }
            
        } while (seguir);
        
        System.out.println("\nFin de la ejecucion\n");
        
    }
    }
    private static void gestionarMeseros(MeseroData meseroData, Scanner leerInt, Scanner leerString) {
        Set<String> accionesMesero = new HashSet<>();
        accionesMesero.add("1");
        accionesMesero.add("2");
        accionesMesero.add("3");
        accionesMesero.add("4");
        accionesMesero.add("5");

        String accionMesero = "";

        do {
            System.out.println("/// Gestión de Meseros ///");
            System.out.println("// 1 - Listar meseros");
            System.out.println("// 2 - Buscar mesero por ID");
            System.out.println("// 3 - Agregar nuevo mesero");
            System.out.println("// 4 - Actualizar datos de un mesero");
            System.out.println("// 5 - Volver al menú principal\n//");
            System.out.print("//// Ingrese una opción: ");
            accionMesero = leerString.nextLine().toLowerCase();

            if (!accionesMesero.contains(accionMesero)) {
                System.err.println("//// Opción inválida, inténtelo de nuevo");
            }

            switch (accionMesero) {
                case "1": 
                    try {
                        ArrayList<Mesero> listaMeseros = meseroData.listarMeseros();
                        System.out.println("\n///// Lista de meseros /////");
                        for (Mesero m : listaMeseros) {
                            System.out.println(" - " + m);
                        }
                        System.out.println("");
                    } catch (SQLException ex) {
                        System.err.println("Error al listar meseros: " + ex.getMessage());
                    }
                    break;

                case "2": 
                    try {
                        System.out.print("//// Ingrese el ID del mesero: ");
                        int idMesero = leerInt.nextInt();
                        Mesero mesero = meseroData.buscar(String.valueOf(idMesero));
                        if (mesero != null) {
                            System.out.println("Mesero encontrado: " + mesero);
                        } else {
                            System.out.println("Mesero no encontrado.");
                        }
                    } catch (SQLException ex) {
                        System.err.println("Error de SQL al buscar mesero: " + ex.getMessage());
                    } catch (InputMismatchException ex) {
                        System.err.println("El valor ingresado es inválido.");
                        leerInt.next(); 
                    }
                    break;

                case "3": {
                    Mesero nuevoMesero = new Mesero(0,null,null,false);
                    MesaData mdata = new MesaData();
                    MeseroData msdata = new MeseroData();
                    boolean valido = true;
                    System.out.print("//// Ingrese el DNI del nuevo mesero: ");
                    do {
                        valido = true;
                        try {
                            nuevoMesero.setDniMesero((int)leerInt.nextInt());
                            if (msdata.buscar(String.valueOf(nuevoMesero.getDniMesero()))!=null) {
                                System.err.print("//// valor invalido, el DNI ingresado ya existe, intentelo nuevamente\n//// : ");
                                leerInt.nextLine();
                                valido = false;
                            }
                        } catch (SQLException | InputMismatchException e) {
                            System.err.print("//// valor invalido, tiene que ser un numero, intentelo nuevamente\n//// : ");
                            leerInt.nextLine();
                            valido = false;
                        }
                    } while (!valido);
                    System.out.print("//// Ingrese el apellido del nuevo mesero: ");
                    do {
                        valido = true;
                        nuevoMesero.setApellido(leerString.nextLine());
                        if (nuevoMesero.getApellido().trim().isEmpty()) {
                            System.err.print("//// El apellido del mesero está vacio, intentelo nuevamente\n//// : ");
                            valido=false;
                        }
                    } while (!valido);
                    System.out.print("//// Ingrese el nombre del nuevo mesero: ");
                    do {
                        valido = true;
                        nuevoMesero.setNombre(leerString.nextLine());
                        if (nuevoMesero.getNombre().trim().isEmpty()) {
                            System.err.print("//// El nombre del mesero está vacio, intentelo nuevamente\n//// : ");
                            valido=false;
                        }
                    } while (!valido);
                    System.out.print("//// Ingrese (1|habilitado o 2|inhabilitado) para el estado del nuevo mesero\n//// : ");
                    do {
                        valido = true;
                        String estado = leerString.nextLine();
                        switch (estado.toLowerCase()) {
                            case ("1") : case ("habilitado") : {
                                nuevoMesero.setEstado(true);break;
                            }
                            case ("2") : case ("inhabilitado") : {
                                nuevoMesero.setEstado(false);break;
                            }
                            default : {
                                System.err.print("//// Invalido debe ingresar una de estas opciones (1|habilitado o 2|inhabilitado), intentelo nuevamente\n//// : ");
                                valido = false;
                                break;
                            }
                        }
                    } while (!valido);
                    
                    try {
                        meseroData.guardar(nuevoMesero);
                        System.out.println("Mesero agregado exitosamente.");
                    } catch (SQLException ex) {
                        System.err.println("Error al agregar mesero: " + ex.getMessage());
                    }
                    break;
                }
                case "4": {
                    MeseroData msdata = new MeseroData();
                    Mesero m = new Mesero(0,null,null,false);
                    boolean valido = true;
                    String opcions = null;
                    System.out.print("//// Ingrese el DNI del mesero que desea actualizar, ingrese 0 para cancelar\n//// : ");
                    do {
                        valido = true;
                        opcions = String.valueOf(leerInt.nextInt());
                        if ("0".equals(opcions)) {
                            System.out.println("///// Operacion cancelada /////\n");
                            break;
                        }else{
                            try {
                                m.setDniMesero(Integer.parseInt(opcions));
                                if (msdata.buscar(opcions)!=null) {
                                    System.err.print("//// valor invalido, el DNI ingresado ya existe, intentelo nuevamente\n//// : ");
                                    leerInt.nextLine();
                                    valido = false;
                                }
                            } catch (SQLException | NumberFormatException ex) {
                                System.out.print("//// DNI invalido, Intentelo nuevamente o ingrese 0 para cancelar\n//// : ");
                                leerInt.next();
                                valido = false;
                            }
                        }
                    } while (!valido);
                try {
                    if (msdata.buscar(String.valueOf(m.getDniMesero()))!=null) {
                        System.out.print("//// Ingrese que atributos del producto desea actualizar: (apellido, nombre, estado) puede ponerlo asi para todos o solo algunos\n//// : ");
                        String filtros = leerString.nextLine().toLowerCase();
                        
                        if (filtros.contains("apellido")) {
                            System.out.print("//// Ingrese el nuevo apellido del mesero\n//// : ");
                            do {
                                valido = true;
                                m.setApellido(leerString.nextLine());
                                if (m.getApellido().trim().isEmpty()|m.getApellido().isEmpty()) {
                                    System.err.print("//// El apellido del mesero está vacio, intentelo nuevamente\n//// : ");
                                    valido=false;
                                }
                            } while (!valido);
                        }
                        if (filtros.contains("nombre")) {
                            System.out.print("//// Ingrese el nuevo nombre del mesero\n//// : ");
                            do {
                                valido = true;
                                m.setNombre(leerString.nextLine());
                                if (m.getNombre().trim().isEmpty()|m.getNombre().isEmpty()) {
                                    System.err.print("//// El nombre del mesero está vacio, intentelo nuevamente\n//// : ");
                                    valido=false;
                                }
                            } while (!valido);
                        }
                        if (filtros.contains("estado")) {
                            System.out.print("//// Ingrese (1|habilitado o 2|inhabilitado) para el nuevo estado del mesero\n//// : ");
                            do {
                                valido = true;
                                String estado = leerString.nextLine();
                                switch (estado.toLowerCase()) {
                                    case ("1") : case ("habilitado") : {
                                        m.setEstado(true);break;
                                    }
                                    case ("2") : case ("inhabilitado") : {
                                        m.setEstado(false);break;
                                    }
                                    default : {
                                        System.err.print("//// Invalido debe ingresar una de estas opciones (1|habilitado o 2|inhabilitado), intentelo nuevamente\n//// : ");
                                        valido = false;
                                        break;
                                    }
                                }
                            } while (!valido);
                        }
                        
                        msdata.actualizar(m,m.getDniMesero());
                        System.out.println(" - "+msdata.buscar(String.valueOf(m.getDniMesero()))+"\n");
                        break;
                    }else {
                        if (!"0".equals(opcions)) {
                            System.err.println("Mesero no encontrado");
                        }
                        break;
                    }
                } catch (SQLException ex) {
                    System.err.println("Error SQL: "+ex);
                }}
                case "5":
                    System.out.println("Volviendo al menú principal...");
                    break;
            }

        } while (!accionMesero.equals("5"));
    }
    private static void gestionarMesas(MesaData mesaData, Scanner leerInt, Scanner leerString) {
    Set<String> accionesMesa = new HashSet<>();
    MeseroData msdata = new MeseroData();
    accionesMesa.add("1");
    accionesMesa.add("2");
    accionesMesa.add("3");
    accionesMesa.add("4");
    accionesMesa.add("5");

    String accionMesa = "";

    do {
        System.out.println("/// Gestión de Mesas ///");
        System.out.println("// 1 - Listar mesas");
        System.out.println("// 2 - Buscar mesa por número");
        System.out.println("// 3 - Agregar nueva mesa");
        System.out.println("// 4 - Actualizar datos de una mesa");
        System.out.println("// 5 - Volver al menú principal\n//");
        System.out.print("//// Ingrese una opción: ");
        accionMesa = leerString.nextLine().toLowerCase();

        if (!accionesMesa.contains(accionMesa)) {
            System.err.println("//// Opción inválida, inténtelo de nuevo");
        }

        switch (accionMesa) {
            case "1":
                try {
                    ArrayList<Mesa> listaMesas = mesaData.listarMesas();
                    System.out.println("\n///// Lista de mesas /////");
                    for (Mesa m : listaMesas) {
                        System.out.println(" - Mesa " + m.getNumeroMesa() + ": Capacidad " + m.getCapacidad() + ", Estado " + (m.isEstado() ? "Disponible" : "Ocupada") + ", Ocupada: " + m.getOcupada());
                    }
                    System.out.println("");
                } catch (SQLException ex) {
                    System.err.println("Error al listar mesas: " + ex.getMessage());
                }
                break;

            case "2":
                try {
                    System.out.print("//// Ingrese el número de la mesa: ");
                    int numeroMesa = leerInt.nextInt();
                    Mesa mesa = mesaData.buscar(numeroMesa);
                    if (mesa != null) {
                        System.out.println("Mesa encontrada: " + "Mesa " + mesa.getNumeroMesa() + ": Capacidad " + mesa.getCapacidad() + ", Estado " + (mesa.isEstado() ? "Disponible" : "Ocupada") + ", Ocupada: " + mesa.getOcupada());
                    } else {
                        System.out.println("Mesa no encontrada.");
                    }
                } catch (SQLException ex) {
                    System.err.println("Error de SQL al buscar mesa: " + ex.getMessage());
                } catch (InputMismatchException ex) {
                    System.err.println("El valor ingresado es inválido.");
                    leerInt.next();
                }
                break;

            case "3":
                Mesa nuevaMesa = new Mesa(0,0,false,null,null);
                boolean valido = true;
                System.out.print("//// Ingrese la capacidad de la mesa\n//// : ");
                do {
                    valido = true;
                    try {
                        nuevaMesa.setCapacidad((int)leerInt.nextInt());
                    } catch (InputMismatchException e) {
                         System.err.print("//// valor invalido, tiene que ser un numero, intentelo nuevamente\n//// : ");
                        leerInt.nextLine();
                        valido = false;
                    }
                } while (!valido);
                System.out.print("//// Ingrese el estado de ocupación (1:libre | 2:ocupada | 3:atendida): ");
                do {
                    valido = true;
                    String estado = leerString.nextLine();
                    switch (estado.toLowerCase()) {
                        case ("1") : case ("libre") : {
                            nuevaMesa.setOcupada("libre");break;
                        }
                        case ("2") : case ("ocupada") : {
                            nuevaMesa.setOcupada("ocupada");break;
                        }
                        case ("3") : case ("atendida") : {
                            nuevaMesa.setOcupada("atendida");break;
                        }
                        default : {
                            System.err.print("//// Invalido debe ingresar una de estas opciones (1:libre | 2:ocupada | 3:atendida), intentelo nuevamente\n//// : ");
                            valido = false;
                            break;
                        }
                    }
                } while (!valido);
                System.out.print("//// Ingrese (1|habilitado o 2|inhabilitado) para el nuevo estado de la mesa\n//// : ");
                do {
                    valido = true;
                    String estado = leerString.nextLine();
                    switch (estado.toLowerCase()) {
                        case ("1") : case ("habilitado") : {
                            nuevaMesa.setEstado(true);break;
                        }
                        case ("2") : case ("inhabilitado") : {
                            nuevaMesa.setEstado(false);break;
                        }
                        default : {
                            System.err.print("//// Invalido debe ingresar una de estas opciones (1|habilitado o 2|inhabilitado), intentelo nuevamente\n//// : ");
                            valido = false;
                            break;
                        }
                    }
                } while (!valido);
                System.out.print("//// Ingrese el dni del mesero asignado a la mesa, puede ser null\n//// : ");
                do {
                    valido = true;
                    String dni = leerString.nextLine();
                    try {
                        if ("null".equals(dni)) {
                            nuevaMesa.setMesero(null);
                        }else
                        if (msdata.buscar(dni)!=null) {
                            nuevaMesa.setMesero(msdata.buscar(dni));
                        }else {
                            System.err.print("//// EL DNI del mesero ingresado no existe, intentelo nuevamente\n//// : ");
                            valido = false;
                        }
                    } catch (SQLException e) {
                        System.err.println("Error SQL");
                    }
                } while (!valido);

                try {
                    mesaData.guardarMesa(nuevaMesa);
                    System.out.println("Mesa agregada exitosamente.");
                } catch (SQLException ex) {
                    System.err.println("Error al agregar mesa: " + ex.getMessage());
                }
                break;

            case "4":
                try {
                    System.out.print("//// Ingrese el número de la mesa a actualizar: ");
                    int numeroMesaActualizar = leerInt.nextInt();
                    Mesa mesaActualizar = mesaData.buscar(numeroMesaActualizar);

                    if (mesaActualizar != null) {
                        System.out.println("Mesa encontrada: " + "Mesa " + mesaActualizar.getNumeroMesa() + ": Capacidad " + mesaActualizar.getCapacidad() + ", Estado " + (mesaActualizar.isEstado() ? "Disponible" : "Ocupada") + ", Ocupada: " + mesaActualizar.getOcupada());
                        System.out.print("//// Ingrese la nueva capacidad de la mesa: ");
                        do {
                            valido = true;
                            try {
                                mesaActualizar.setCapacidad((int)leerInt.nextInt());
                            } catch (InputMismatchException e) {
                                 System.err.print("//// valor invalido, tiene que ser un numero, intentelo nuevamente\n//// : ");
                                leerInt.nextLine();
                                valido = false;
                            }
                        } while (!valido);
                        System.out.print("//// Ingrese el estado de ocupación (1:libre | 2:ocupada | 3:atendida): ");
                        do {
                            valido = true;
                            String estado = leerString.nextLine();
                            switch (estado.toLowerCase()) {
                                case ("1") : case ("libre") : {
                                    mesaActualizar.setOcupada("libre");break;
                                }
                                case ("2") : case ("ocupada") : {
                                    mesaActualizar.setOcupada("ocupada");break;
                                }
                                case ("3") : case ("atendida") : {
                                    mesaActualizar.setOcupada("atendida");break;
                                }
                                default : {
                                    System.err.print("//// Invalido debe ingresar una de estas opciones (1:libre | 2:ocupada | 3:atendida), intentelo nuevamente\n//// : ");
                                    valido = false;
                                    break;
                                }
                            }
                        } while (!valido);
                        System.out.print("//// Ingrese (1|habilitado o 2|inhabilitado) para el nuevo estado de la mesa\n//// : ");
                        do {
                            valido = true;
                            String estado = leerString.nextLine();
                            switch (estado.toLowerCase()) {
                                case ("1") : case ("habilitado") : {
                                    mesaActualizar.setEstado(true);break;
                                }
                                case ("2") : case ("inhabilitado") : {
                                    mesaActualizar.setEstado(false);break;
                                }
                                default : {
                                    System.err.print("//// Invalido debe ingresar una de estas opciones (1|habilitado o 2|inhabilitado), intentelo nuevamente\n//// : ");
                                    valido = false;
                                    break;
                                }
                            }
                        } while (!valido);
                        System.out.print("//// Ingrese el dni del mesero asignado a la mesa, puede ser null\n//// : ");
                        do {
                            valido = true;
                            String dni = leerString.nextLine();
                            try {
                                if ("null".equals(dni)) {
                                    mesaActualizar.setMesero(null);
                                }else
                                if (msdata.buscar(dni)!=null) {
                                    mesaActualizar.setMesero(msdata.buscar(dni));
                                }else {
                                    System.err.print("//// EL DNI del mesero ingresado no existe, intentelo nuevamente\n//// : ");
                                    valido = false;
                                }
                            } catch (SQLException e) {
                                System.err.println("Error SQL");
                            }
                        } while (!valido);
                        
                        mesaData.Actualizar(mesaActualizar, mesaActualizar.getNumeroMesa());
                        System.out.println("Mesa actualizada exitosamente.");
                    } else {
                        System.out.println("Mesa no encontrada.");
                    }
                } catch (SQLException ex) {
                    System.err.println("Error al actualizar mesa: " + ex.getMessage());
                } catch (InputMismatchException ex) {
                    System.err.println("El valor ingresado es inválido.");
                    leerInt.next();
                }
                break;

            case "5":
                System.out.println("Volviendo al menú principal...");
                break;
        }

    } while (!accionMesa.equals("5"));
}

}
