import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
/**
 * Clase para representar a los Empleados, un empleado tiene, id, nombre, dirección, correo, rol,
 *  telefono,sueldo y fecha de nacimiento.
 * @author Josue Morales Torres
 * @author Andrea Alvarado Camacho
 * @version 2.0
 */
public class Empleado {

    /*id del Empleado. */
    private String idEmpleado;
    /*Nombre del empleado. */
    private String nombre;
    /*Direccion del empleado. */
    private String direccion;
    /*Correos electronico del empleado. */
    List<String> correos = new ArrayList<>();
    /*Rol del empleado. */
    private String rol;
    /*Telefonos del empleado. */
    List<String> telefonos = new ArrayList<>();
    /*Sueldo del empleado. */
    private String sueldo;
    /*Fecha de nacimiento del empleado. */
    private String fechNacimiento;
    Vivero vivero;

    boolean repetir = true,confirmacion,confi;
    String res;
    Scanner in = new Scanner(System.in);
    Scanner on = new Scanner(System.in);
    Scanner sc = new Scanner(System.in);

    public Empleado(String idEmpleado, String nombre, String direccion, List<String> correos, String rol,
                    List<String> telefonos, String sueldo, String fechNacimiento, Vivero vivero){                        
        this.idEmpleado = idEmpleado; 
        this.nombre = nombre;
        this.direccion = direccion;
        this.correos = correos;
        this.rol = rol;
        this.telefonos = telefonos;
        this.sueldo = sueldo;
        this.fechNacimiento = fechNacimiento;
        this.vivero = vivero;
    }

    /**
     * Define el estado inicial del empleado.
     * @param idEmpleado id del empleado.
     * @param nombre el dombre del emplado.
     * @param direccion la direccion del empleado.
     * @param sueldo el sueldo del empleado.
     * @param fechNacimiento fecha de nacimiento del empleado.
     */
    public Empleado(String idEmpleado, String nombre, String direccion,
                    String sueldo, String fechNacimiento, Vivero vivero){                        
        this.idEmpleado = idEmpleado; 
        this.nombre = nombre;
        this.direccion = direccion;
        agregarCorr();
        setRolEmpleado();
        agregarTel();
        this.sueldo = sueldo;
        this.fechNacimiento = fechNacimiento;
        this.vivero = vivero;
    }

    public void setVivero(Vivero viv){
        this.vivero = viv;
    }

    public Vivero getVivero(){
        return this.vivero;
    }

    /**
     * Regresa el id del empleado.
     * @return el id del empleado.
     */
    public String getID(){
        return this.idEmpleado;
    }

    /**
     * Define el id del emlpeado.
     * @param id el nuevo id del empleado.
     */
    public void setIdNombre(String id){
        this.idEmpleado = id;

    }
    
    /**
     * Regresa el nombre del empleado.
     * @return el nombre del empleado.
     */
    public String getNombreEmpleado(){
        return this.nombre;
    }

    /**
     * Define el nombre del empleado.
     * @param Nombre el nuevo nombre del empleado.
     */
    public void setNombreEmpleado(String Nombre){
        this.nombre = Nombre;
    }

    /**
     * Regresa la dirección del empleado.
     * @return la direccion del empleado.
     */
    public String getDireccionEmpleado(){
        return this.direccion;
    }

    /**
     * Define la direccion del empleado.
     * @param Direccion la nueva direccion del empleado.
     */
    public void setDireccionEmpleado(String Direccion){
        this.direccion = Direccion;
    }

    /**
     * Regresa el correo del empleado.
     * @return el correo del empleado.
     */
    public String getCorreos(){
        String str = "";
        for (String correo : this.correos) {
            str+= correo+";";
        }
        return "["+str+"]";
    }

    /**
     * Método para validar el correo electrónico.
     * @return el correo electrónico.
     */
    public static void verifyCorr(String correo) throws IOException{
        if(correo!=""){
            if(correo.contains("@ciencias.unam.mx") ||
               correo.contains("@gmail.com") ||
               correo.contains("@hotmail.com") ||
               correo.contains("@outlook.com.es") ||
               correo.contains("@adinet.com.uy") ||
               correo.contains("@vera.com.uy")){
            }else{
                throw new IOException ("El dominio no existe");
            }
        }else{
            throw new IOException ("No de puede dejar la correo vacío.");
        }
    }

    /**
     * Define el correo del empleado.
     * @param Correo el nuevo correo del empleado.
     */
    public void setCorreoEmpleado(){
        boolean confirmacion = true;
        String elim="",edit;
        do{
            System.out.println("¿Deseas eliminar o editar un correo? Escribe eliminar/editar");
            String respuesta = in.nextLine();
            if(respuesta.equalsIgnoreCase("eliminar")){
                System.out.print(correos + " - Escribe el correo que quieres eliminar: ");
                elim = in.nextLine();
                if(correos.remove(elim)){
                    System.out.println("Se elimino con exito\nCorreo(s): "+correos);
                    confirmacion = false;
                }else {
                    System.out.println("El correo ingresado no esta registrado");
                    confirmacion = true;
                }
            }else if(respuesta.equalsIgnoreCase("editar")){
                System.out.print(correos + " - Escribe el corrreo que quieres editar: ");
                elim = in.nextLine();
                if(correos.remove(elim)){
                    System.out.print(correos + " - Escribe el nuevo correo: ");
                    editarCorr();
                    confirmacion = false;
                }else {
                    System.out.println("El correo ingresado no esta registrado");
                    confirmacion = true;
                }
            }else{
                System.out.println("Ingresa solamente eliminar o editar");
                confirmacion = true;
            }
        }while(confirmacion);
    }

    /**
     * Regresa el rol del empleado.
     * @return el rol del emppleado.
     */
    public String getRolEmpleado(){
        return this.rol;
    }

    /**
     * Define el rol del empleado.
     * @param Rol el nuevo rol del empleado.
     */
    public void setRolEmpleado(){
        repetir = true;
        do{
            try{
                System.out.println("Selecciona el rol que tienes: ");
                System.out.println("[1] Gerente de Vivero");
                System.out.println("[2] Cuidador de plantas");
                System.out.println("[3] Empleado de mostrador");
                System.out.println("[4] Cajero de vivero\n");
                int opc = on.nextInt();

                switch (opc) {
                    case 1:
                        this.rol = "Gerente de vivero";
                        repetir = false;
                        break;
                    case 2:
                        this.rol = "Cuidador de plantas";
                        repetir = false;
                        break;
                    case 3:
                        this.rol = "Empleado de mostrador";
                        repetir = false;
                        break;
                    case 4:
                        this.rol = "Cajero de vivero";
                        repetir = false;
                        break;
                    default:
                        System.out.println("Ingresa una opción valida");
                        break;
                }
            }catch (Exception e) {
                System.out.println("\tDebes ingresar un número\tIntentalo de nuevo\n");
                on.next();
                repetir = true;
            }
        }while(repetir);
    }

    /**
     * Regresa el telefono del empleado.
     * @return
     */
    public List<String> getTelefonos(){
        String str = "";
        for (String telefono : this.telefonos) {
            str+= telefono+";";
        }
        return "["+str+"]";
    }

    /**
     * Define el telefono del empleado.
     * @param Telefono el nuevo telefono del empleado.
     */
    public void setTelefono(){
        boolean confirmacion = true;
        String elim="",edit;
        do{
            System.out.println("¿Deseas eliminar o editar un numero? Escribe eliminar/editar");
            String respuesta = in.nextLine();
            if(respuesta.equalsIgnoreCase("eliminar")){
                System.out.print(telefonos + " - Escribe el numero que quieres eliminar: ");
                elim = in.nextLine();
                if(telefonos.remove(elim)){
                    System.out.println("Se elimino con exito\nTelefono(s): "+telefonos);
                    confirmacion = false;
                }else {
                    System.out.println("El numero ingresado no esta registrado");
                    confirmacion = true;
                }
            }else if(respuesta.equalsIgnoreCase("editar")){
                System.out.print(telefonos + " - Escribe el numero que quieres editar: ");
                elim = in.nextLine();
                if(telefonos.remove(elim)){
                    System.out.print(telefonos + " - Escribe el nuevo numero: ");
                    editarTel();
                    confirmacion = false;
                }else {
                    System.out.println("El numero ingresado no esta registrado");
                    confirmacion = true;
                }
            }else{
                System.out.println("Ingresa solamente eliminar o editar");
                confirmacion = true;
            }
        }while(confirmacion);
    }

    /**
     * Regresa el sueldo del empleado.
     * @return el sueldo del empleado.
     */
    public String getSueldoEmpleado(){
        return this.sueldo;
    }

    /**
     * Define el sueldo del empleado.
     * @param Sueldo el nuevo sueldo del empleado.
     */
    public void setSueldoEmpleado(String Sueldo){
        this.sueldo = Sueldo;
    }

    /**
     * Regresa la fecha de nacimeinto del empleado.
     * @return la fehca de nacimiento del empleado.
     */
    public String getFechaNacimientoEmpleado(){
        return this.fechNacimiento;
    }

    /**
     * Define la fehca de nacimiento del empleado.
     * @param fecha la nueva fecha de nacimeinto del empleado.
     */
    public void setFechaNacimientoEmpleado(String fecha){
        this.fechNacimiento = fecha;
    }

    public void editarCorr(){
        repetir = true;
        do{
            try{
                System.out.print("\nCorreo: ");
                String correo = in.nextLine();
                if(correo.contains("@")){
                    verifyCorr(correo);
                    confirmacion = true;
                    do{
                        System.out.println("¿Ingresaste " + correo + "?. Escribe Si para confirmar o No para reescribir.");
                        String res = on.nextLine();
                        if(res.equalsIgnoreCase("si") || res.equalsIgnoreCase("chi")){
                            correos.add(correo);
                            confirmacion = false;
                            repetir = false;
                        }else if(res.equalsIgnoreCase("no") || res.equalsIgnoreCase("ño")){
                            repetir = true;
                            confirmacion = false;
                        }else{
                            System.out.println("Ingresa solamente si o no");
                            confirmacion = true;
                        }
                    }while(confirmacion);
                }else{
                    System.out.println("\tCorreo no valido");
                }
            }catch(Exception e){
                System.out.println("\t"+e+"\n\tIntentalo de nuevo");
            }
        }while(repetir);
    }

    public void agregarCorr(){
        String correo;
        repetir = true;
        do{
            try{
                System.out.print("Correo(s): ");
                correo = in.nextLine();
                if(correo.contains("@")){
                    verifyCorr(correo);
                    confirmacion = true;
                    do{
                        System.out.println("¿Ingresaste " + correo + "?. Escribe Si para confirmar o No para reescribir.");
                        String res = on.nextLine();
                        if(res.equalsIgnoreCase("si") || res.equalsIgnoreCase("chi")){
                            correos.add(correo);
                            confi=true;
                            do{
                                System.out.println("¿Deseas agregar otro correo? si/no");
                                res = on.nextLine();
                                if(res.equalsIgnoreCase("si") || res.equalsIgnoreCase("chi")){
                                    repetir = true;
                                    confirmacion = false;
                                    confi = false;
                                }else if(res.equalsIgnoreCase("no") || res.equalsIgnoreCase("ño")){
                                    repetir = false;
                                    confirmacion = false;
                                    confi = false;
                                }else {
                                    System.out.println("Ingresa solamente si o no");
                                    repetir = true;
                                    confirmacion = false;
                                    confi = true;
                                }
                            }while(confi);
                        }else if(res.equalsIgnoreCase("no") || res.equalsIgnoreCase("ño")){
                            repetir = true;
                            confirmacion = false;
                        }else{
                            System.out.println("Ingresa solamente si o no");
                            confirmacion = true;
                        }
                    }while(confirmacion);
                }else{
                    System.out.println("\tCorreo no valido");
                }
            }catch(Exception e){
                System.out.println("\t"+e+"\n\tIntentalo de nuevo");
            }
        }while(repetir);
    }//aqui termina correo

    public void editarTel(){
        repetir = true;
        do{
            try{
                System.out.print("\nTelefono: ");
                String telefono = in.nextLine();
                verify(telefono);
                int length = telefono.length();
                if(length==10){
                    confirmacion = true;
                    do{
                        System.out.println("¿Ingresaste " + telefono + "?. Escribe Si para confirmar o No para reescribir.");
                        String res = on.nextLine();
                        if(res.equalsIgnoreCase("si") || res.equalsIgnoreCase("chi")){
                            telefonos.add(telefono);
                            confirmacion = false;
                            repetir = false;
                        }else if(res.equalsIgnoreCase("no") || res.equalsIgnoreCase("ño")){
                            repetir = true;
                            confirmacion = false;
                        }else{
                            System.out.println("Ingresa solamente si o no");
                            confirmacion = true;
                        }
                    }while(confirmacion);
                }else{
                    System.out.println("\tNumero de telefono no valido");
                }
            }catch(Exception e){
                System.out.println("\t"+e+" Debes ingresar un numero\n\tIntentalo de nuevo");
            }
        }while(repetir);
    }

    public void agregarTel(){
        String telefono;
        repetir = true;
        do{
            try{
                System.out.print("Telefono(s): ");
                telefono = sc.nextLine();
                verify(telefono);
                int length = telefono.length();
                if(length==10){
                    confirmacion = true;
                    do{
                        System.out.println("¿Ingresaste " + telefono + "?. Escribe Si para confirmar o No para reescribir.");
                        String res = sc.nextLine();
                        if(res.equalsIgnoreCase("si") || res.equalsIgnoreCase("chi")){
                            telefonos.add(telefono);
                            confi=true;
                            do{
                                System.out.println("¿Deseas agregar otro número? si/no");
                                res = sc.nextLine();
                                if(res.equalsIgnoreCase("si") || res.equalsIgnoreCase("chi")){
                                    repetir = true;
                                    confirmacion = false;
                                    confi = false;
                                }else if(res.equalsIgnoreCase("no") || res.equalsIgnoreCase("ño")){
                                    repetir = false;
                                    confirmacion = false;
                                    confi = false;
                                }else {
                                    System.out.println("Ingresa solamente si o no");
                                    repetir = true;
                                    confirmacion = false;
                                    confi = true;
                                }
                            }while(confi);
                        }else if(res.equalsIgnoreCase("no") || res.equalsIgnoreCase("ño")){
                            repetir = true;
                            confirmacion = false;
                        }else{
                            System.out.println("Ingresa solamente si o no");
                            confirmacion = true;
                        }
                    }while(confirmacion);
                }else{
                    System.out.println("\tNumero de telefono no valido");
                }
            }catch(Exception e){
                System.out.println("\t"+e+" Debes ingresar un numero\n\tIntentalo de nuevo");
            }
        }while(repetir);
    }

    public static void verify(String tel) throws IOException{
        boolean isNum = tel.matches("[+-]?\\d*(\\.\\d+)?");
        if(!isNum)
            throw new IOException ("El numero contiene letras. ");
    }

    /**
     * Metodo para imprimir en consola el empleado y sus atributos
     * @return Cadena con toda la informacion del empleado
     */
    public String toString(){
        return "\nID: "+this.idEmpleado+"\nNombre: "+this.nombre+
                "\nDireccion: " + this.direccion+"\nCorreo(s): " + this.correos +
                "\nRol: "+ this.rol + "\nTelefonos: "+this.telefonos+"\nSueldo: "+this.sueldo+
                "\nFecha de Nacimiento: "+this.fechNacimiento+"\nVivero: "+this.vivero.getNombre();
    }

    public String formatoCSV(){
        return this.idEmpleado+","+this.nombre+"," +
                this.direccion+"," + this.getCorreos() + ","+
                this.rol + ","+this.getTelefonos()+","+
                this.sueldo+","+this.fechNacimiento+","+this.vivero.formatoCSV();
    }

    public static void main(String []pps){
        //Empleado viv = new Empleado("ID01","Andy","Cuajis","3500","28/06/02");
        //List<String> list = new ArrayList<>();
        //list.add("oa");
        //System.out.println(viv.getCorreoEMpleado());
        //System.out.println(list.contains("oa"));
        //System.out.println(viv);
        //list.add(34);
        //System.out.println(list);
    }
}
