import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
/**
* Clase de Vivero que contiene todos sus atrributos
* @author Andrea Alvarado Camacho
* @version 1.0
*/
public class Vivero{

	String id;// falta generar un id unico
	String nombre;
	String direccion;
	List<String> telefonos = new ArrayList<>();
	String fApertura;
	String area;
	boolean repetir = true,confirmacion,confi;
	String res;
	Scanner in = new Scanner(System.in);
	Scanner on = new Scanner(System.in);

	public Vivero(String id, String nombre, String direccion, List<String> telefonos, String fApertura, String area){
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefonos = telefonos;
		this.fApertura = fApertura;
		this.area = area;
	}

	public Vivero(String id, String nombre, String direccion, String fApertura){
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		agregarTel();
		this.fApertura = fApertura;
		setArea();
	}

	public void setID(String id){
		this.id = id;
	}

	public String getID(){
		return this.id;
	}

	public String getNombre(){
		return this.nombre;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public void setDireccion(String direccion){
		this.direccion = direccion;
	}

	public String getDireccion(){
		return this.direccion;
	}

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

	public List<String> getTelefonos(){
		String str = "";
        for (String telefono : this.telefonos) {
            str+= telefono+";";
        }
        return "["+str+"]";
	}

	public void setFapertura(String fApertura){
		this.fApertura = fApertura;
	}

	public String getFapertura(){
		return this.fApertura;
	}

	public void setArea(){
		repetir = true;
        do{
            try{
                System.out.println("Selecciona el area del vivero: ");
                System.out.println("[1] Plantas Africanas");
                System.out.println("[2] Cactus\n");
                int opc = on.nextInt();

                switch (opc) {
                    case 1:
                        this.area = "Plantas Africanas";
                        repetir = false;
                        break;
                    case 2:
                        this.area = "Cactus";
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

	public String getArea(){
		return this.area;
	}

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
				telefono = in.nextLine();
				verify(telefono);
				int length = telefono.length();
				if(length==10){
					confirmacion = true;
					do{
						System.out.println("¿Ingresaste " + telefono + "?. Escribe Si para confirmar o No para reescribir.");
				        String res = on.nextLine();
				        if(res.equalsIgnoreCase("si") || res.equalsIgnoreCase("chi")){
				            telefonos.add(telefono);
				            confi=true;
				            do{
				            	System.out.println("¿Deseas agregar otro número? si/no");
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
	 * Metodo para imprimir en consola el vivero y sus atributos
	 * @return Cadena con toda la informacion del vivero
	 */
	public String toString(){
		return "\nID: "+this.id+"\nNombre: "+this.nombre+"\nDireccion: " + this.direccion+"\nTelefono(s): " + this.telefonos + "\nFecha de apertura: "+ this.fApertura + "\nArea: "+this.area;
	}

	public String formatoCSV(){
		return this.id+","+this.nombre+"," + this.direccion+"," + this.telefonos + ","+ this.fApertura + ","+this.area+"\n";
	}

	public static void main(String []pps){
		/*Vivero viv = new Vivero("pruebita","dire","23","area");
		List<Integer> list = new ArrayList<>();
		System.out.println(viv);
		viv.setTelefono();
		System.out.println(viv);
		//list.add(34);
		//System.out.println(list);*/
	}
}