import java.util.Scanner;
/**
 * Clase para representar plantas. una planta tiene id, nombre, género, precio,
 * cuidado, tipo, sustrato, fecha de germinación.
 */
public class Planta {
    
    String idPlanta;
    String nombre;
    String genero;
    String precio;
    String cuidado;
    String tipo;//luz o sombra
    String sustrato;
    String fechaGerminacion;
    String riego;
    String otroR = "";
    boolean repetir = true;
    Scanner sca = new Scanner(System.in);
    Scanner on = new Scanner(System.in);


    public Planta(String idPlanta, String nombre, String genero, String precio, String cuidado,
                  String tipo, String sustrato, String fechaGerminacion, String riego){
        this.idPlanta = idPlanta;
        this.nombre = nombre;
        this.genero = genero;
        this.precio = precio;
        this.cuidado = cuidado;
        this.tipo = tipo;
        this.sustrato = sustrato;
        this.fechaGerminacion = fechaGerminacion;
        this.riego = riego;

    }

    public Planta(String idPlanta, String nombre, String genero, String precio, String cuidado,
                  String sustrato, String fechaGerminacion){
        this.idPlanta = idPlanta;
        this.nombre = nombre;
        this.genero = genero;
        this.precio = precio;
        this.cuidado = cuidado;
        setTipoPlanta();
        this.sustrato = sustrato;
        this.fechaGerminacion = fechaGerminacion;
        setRiego();

    }

    public String getID(){
        return this.idPlanta;
    }
    public void setIdPlanta(String ID){
        this.idPlanta = ID;
    }

    public String getNombrePlanta(){
        return this.nombre;
    }
    public void setNombrePlanta(String Nombre){
        this.nombre = Nombre;
    }

    public String getGeneroPlanta(){
        return this.genero;
    }
    public void setGeneroPlanta(String Genero){
        this.genero = Genero;
    }

    public String getPrecioPlnata(){
        return this.precio;
    }
    public void setPrecioPlanta(String Precio){
        this.precio = Precio;
    }

    public String getCuidadoPlanta(){
        return this.cuidado;
    }
    public void setCuidadoPlanta(String Cuidado){
        this.cuidado = Cuidado;
    }
    public String getTipoPlanta(){
        return this.tipo;
    }
    public void setTipoPlanta(){
        repetir = true;
        do{
            try{
                System.out.println("Selecciona el tipo de luz de la planta: ");
                System.out.println("[1] Sombra");
                System.out.println("[2] Resolana\n");
                int opc = on.nextInt();

                switch (opc) {
                    case 1:
                        this.tipo = "Sombra";
                        repetir = false;
                        break;
                    case 2:
                        this.tipo = "Resolana";
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
    public String getSustratoPlanta(){
        return this.sustrato;
    }
    public void setSustratoPlanta(String Sustrato){
        this.sustrato = Sustrato;
    }
    public String getFechaGerminacionPlanta(){
        return this.fechaGerminacion;
    }
    public void setFechaGerminacionPlanta(String Fecha){
        this.fechaGerminacion = Fecha;
    }
    public String getRiego(){
        return this.riego;
    }
    public void setRiego(){
        repetir = true;
        do{
            try{
                System.out.println("Selecciona el tipo de riego de la planta: ");
                System.out.println("[1] Por superficie o gravedad");
                System.out.println("[2] Por aspersion");
                System.out.println("[3] Localizado");
                System.out.println("[4] Subterraneo");
                System.out.println("[5] Otro\n");
                int opc = on.nextInt();

                switch (opc) {
                    case 1:
                        this.riego = "Por superficie o gravedad";
                        repetir = false;
                        break;
                    case 2:
                        this.riego = "Por aspersion";
                        repetir = false;
                        break;
                    case 3:
                        this.riego = "Empleado de mostrador";
                        repetir = false;
                        break;
                    case 4:
                        this.riego = "Localizado";
                        repetir = false;
                        break;
                    case 5:
                        System.out.print("Escribe el tipo de riego: ");
                        otroR = sca.nextLine();
                        this.riego = otroR;
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

    public String toString(){
        return ("ID: " + this.idPlanta + "\nNombre: " + this.nombre +
                "\nGénero: " + this.genero + "\nPrecio: " + this.precio +
                "\nCuidado: " + this.cuidado + "\nTipo: " + this.tipo +
                "\nSustrato: " + this.sustrato + "\nFecha de germinación: "+
                this.fechaGerminacion + "\nRiego: " + this.riego);
    }

    public String formatoCSV(){
        return (this.idPlanta + "," + this.nombre + "," +
                this.genero + "," + this.precio + "," +
                this.cuidado + ", " + this.tipo + "," +
                this.sustrato + ","+ this.fechaGerminacion + "," + this.riego+"\n");
    }

    public static void main(String []pps){
        //Planta viv = new Planta("012","Nombresito","genero",1000,"mucho cuidado","tipo","sustrato","fechita","riego");
        //List<Integer> list = new ArrayList<>();
        //System.out.println(viv);
        //viv.setTelefono();
        //System.out.println(viv);
        //list.add(34);
        //System.out.println(list);
    }
}
