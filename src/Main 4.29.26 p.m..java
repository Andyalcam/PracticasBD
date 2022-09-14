import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/**
* Programa para registrar jugadores para el mataron
* @author Andrea Alvarado Camacho
* @version 1.0
*/
public class Main{
	public static void main(String []pps){
		Scanner in = new Scanner(System.in);
		Scanner on = new Scanner(System.in);
		String nombre = "";
		int dia = 0;
		int mes = 0;
		int telefono = 0;
		int año = 0;
		int sueldo = 0;
		int precio = 0;
		int opc;
		String sexo = "";
		String res = "";
		String direccion = "";
		boolean repetir=true;
		boolean excep=true;
		List<Vivero> viveros = new ArrayList<>();
		List<Empleado> empleados = new ArrayList<>();
		List<Planta> plantas = new ArrayList<>();
		List<String> idsViveros = new ArrayList<>();
		List<String> idsEmpleados = new ArrayList<>();
		List<String> idsPlantas = new ArrayList<>();
		//Jugador [] jugadores = new Jugador[0];
		Utilidades ut = new Utilidades();
		viveros = ut.listaViv("CSVViveros.csv");
		empleados = ut.listaEmp("CSVEmpleados.csv");
		plantas = ut.listaPlanta("CSVPlantas.csv");
		ut.cargaArchivo(idsViveros,"CSVIDV.csv");
		ut.cargaArchivo(idsEmpleados,"CSVIDE.csv");
		ut.cargaArchivo(idsPlantas,"CSVIDP.csv");
		/*jugadores = ut.leerObjetoArchivo("jugadores.txt");
		juego1 = ut.leerObjetoBJ("juego1.txt"); 
		juego2 = ut.leerObjetoDados("juego2.txt"); 
		juego3 = ut.leerObjetoConecta4("juego3.txt");*/ // Leer los objetos jugador para mantener la consistencia
		System.out.println("\n\t*** BIENVENIDO AL MENU ***");
		do{
			try{
				System.out.println("\n\t\t*** Menu ***");
				System.out.println("--------------------------------------------");
				System.out.println("1. Agregar vivero");
				System.out.println("2. Agregar empleado");
				System.out.println("3. Agregar planta");
				System.out.println("4. Consultar vivero");
				System.out.println("5. Consultar empleado");
				System.out.println("6. Consultar planta");
				System.out.println("7. Eliminar/Editar vivero");
				System.out.println("8. Eliminar/Editar empleado");
				System.out.println("9. Eliminar/Editar planta");
				System.out.println("6. Salir");
				System.out.println("--------------------------------------------");
				System.out.print("Ingresa una opcion del menu: ");
				opc = in.nextInt();

				switch(opc){
					// Registrar un nuevo vivero
					case 1: System.out.print("ID del vivero: ");
							String id = on.nextLine();

							System.out.print("Nombre del vivero: ");
							nombre = on.nextLine();

							System.out.print("Dirección: ");
							direccion = on.nextLine();

							repetir=true;
							do{
								try{
									System.out.print("Dia de apertura: ");
									dia = in.nextInt();
									if(dia>0 && dia<32){
										repetir = false;
									}else{
										System.out.println("\tDebes ingresar un numero mayor a 0 y menor o igual a 31");
									}
								}catch(Exception e){
									System.out.println("\t"+e+" Debes ingresar un numero\n\tIntentalo de nuevo");
									in.next();
								}
							}while(repetir);

							repetir=true;
							do{
								try{
									System.out.print("Mes de apertura: ");
									mes = in.nextInt();
									if(mes>0 && mes<13){
										repetir = false;
									}else{
										System.out.println("\tDebes ingresar un numero mayor a 0 y menor o igual a 12");
									}
								}catch(Exception e){
									System.out.println("\t"+e+" Debes ingresar un numero\n\tIntentalo de nuevo");
									in.next();
								}
							}while(repetir);

							repetir=true;
							do{
								try{
									System.out.print("Año de apertura: ");
									año = in.nextInt();
									if(año>0 && año<=2022){
										repetir = false;
									}else{
										System.out.println("\tDebes ingresar un numero mayor a 0 y menor o igual a 2022");
									}
								}catch(Exception e){
									System.out.println("\t"+e+" Debes ingresar un numero\n\tIntentalo de nuevo");
									in.next();
								}
							}while(repetir);

							Vivero viv = new Vivero (id,nombre,direccion,(dia+"/"+mes+"/"+año));
							viveros.add(viv);
							ut.crearCSV("CSVViveros.csv",viv.formatoCSV());
							ut.crearCSV("CSVIDV.csv",viv.getID()+",");
							System.out.println(viv);
					break;
					// Mostrar los jugadores registrados
					case 2: if(!viveros.isEmpty()){
								System.out.print("ID del Empleado: ");
								id = on.nextLine();

								System.out.print("Nombre del Empleado: ");
								nombre = on.nextLine();

								System.out.print("Dirección: ");
								direccion = on.nextLine();

								repetir=true;
								do{
									try{
										System.out.print("Sueldo: ");
										sueldo = in.nextInt();
										repetir = false;
									}catch(Exception e){
										System.out.println("\t"+e+" Debes ingresar un numero\n\tIntentalo de nuevo");
										in.next();
									}
								}while(repetir);

								repetir=true;
								do{
									try{
										System.out.print("Dia de nacimiento: ");
										dia = in.nextInt();
										if(dia>0 && dia<32){
											repetir = false;
										}else{
											System.out.println("\tDebes ingresar un numero mayor a 0 y menor o igual a 31");
										}
									}catch(Exception e){
										System.out.println("\t"+e+" Debes ingresar un numero\n\tIntentalo de nuevo");
										in.next();
									}
								}while(repetir);

								repetir=true;
								do{
									try{
										System.out.print("Mes de nacimiento: ");
										mes = in.nextInt();
										if(mes>0 && mes<13){
											repetir = false;
										}else{
											System.out.println("\tDebes ingresar un numero mayor a 0 y menor o igual a 12");
										}
									}catch(Exception e){
										System.out.println("\t"+e+" Debes ingresar un numero\n\tIntentalo de nuevo");
										in.next();
									}
								}while(repetir);

								repetir=true;
								do{
									try{
										System.out.print("Año de nacimiento: ");
										año = in.nextInt();
										if(año>0 && año<=2022){
											repetir = false;
										}else{
											System.out.println("\tDebes ingresar un numero mayor a 0 y menor o igual a 2022");
										}
									}catch(Exception e){
										System.out.println("\t"+e+" Debes ingresar un numero\n\tIntentalo de nuevo");
										in.next();
									}
								}while(repetir);

								repetir = true;
						        do{
						            try{
						                System.out.println("\nSelecciona el vivero en el que trabajas: \n");
						                for (int i=0; i< viveros.size(); i++) {
						                	System.out.println("["+(i+1)+"] "+viveros.get(i).getNombre());
						                }
						                opc = on.nextInt();
						                repetir = false;

						            }catch (Exception e) {
						            	e.printStackTrace();
						                System.out.println("\tDebes ingresar un número\tIntentalo de nuevo\n");
						                on.next();
						                repetir = true;
						            }
						        }while(repetir);

								Empleado empleado = new Empleado (id,nombre,direccion,""+sueldo,(dia+"/"+mes+"/"+año),viveros.get(opc-1));
								empleados.add(empleado);
								ut.crearCSV("CSVEmpleados.csv",empleado.formatoCSV());
								ut.crearCSV("CSVIDE.csv",empleado.getID()+",");
								System.out.println(empleado);
							}else{
								System.out.println("No puedes agregar a un empleado sin haber registrado un vivero donde trabajar");
								excep = true;
							}
					break;
					case 3: System.out.print("ID del la Planta: ");
							id = in.nextLine();

							System.out.print("Nombre de la planta: ");
							nombre = on.nextLine();

							System.out.print("Genero de la planta: ");
							String genero = on.nextLine();

							System.out.print("Cuidados basicos de la planta: ");
							String cuidados = on.nextLine();

							System.out.print("Tipo de sustrato de la planta: ");
							String sustrato = on.nextLine();

							repetir=true;
							do{
								try{
									System.out.print("Precio: ");
									precio = in.nextInt();
									repetir = false;
								}catch(Exception e){
									System.out.println("\t"+e+" Debes ingresar un numero\n\tIntentalo de nuevo");
									in.next();
								}
							}while(repetir);

							repetir=true;
							do{
								try{
									System.out.print("Dia de germinación: ");
									dia = in.nextInt();
									if(dia>0 && dia<32){
										repetir = false;
									}else{
										System.out.println("\tDebes ingresar un numero mayor a 0 y menor o igual a 31");
									}
								}catch(Exception e){
									System.out.println("\t"+e+" Debes ingresar un numero\n\tIntentalo de nuevo");
									in.next();
								}
							}while(repetir);

							repetir=true;
							do{
								try{
									System.out.print("Mes de germinación: ");
									mes = in.nextInt();
									if(mes>0 && mes<13){
										repetir = false;
									}else{
										System.out.println("\tDebes ingresar un numero mayor a 0 y menor o igual a 12");
									}
								}catch(Exception e){
									System.out.println("\t"+e+" Debes ingresar un numero\n\tIntentalo de nuevo");
									in.next();
								}
							}while(repetir);

							repetir=true;
							do{
								try{
									System.out.print("Año de germinación: ");
									año = in.nextInt();
									if(año>0 && año<=2022){
										repetir = false;
									}else{
										System.out.println("\tDebes ingresar un numero mayor a 0 y menor o igual a 2022");
									}
								}catch(Exception e){
									System.out.println("\t"+e+" Debes ingresar un numero\n\tIntentalo de nuevo");
									in.next();
								}
							}while(repetir);
							Planta planta = new Planta (id,nombre,genero,""+precio,cuidados,sustrato,(dia+"/"+mes+"/"+año));
							plantas.add(planta);
							ut.crearCSV("CSVPlantas.csv",planta.formatoCSV());
							ut.crearCSV("CSVIDP.csv",planta.getID()+",");
							System.out.println(planta);
					break;
					// Lista del torneo
					case 4: System.out.print("\nViveros: " + viveros);
							System.out.print("\nEmpleados: " + empleados);
							System.out.print("\nPlantas: " + plantas);
					break;
					// Partidas registradas
					/*case 5: System.out.println("\nA continuacion se muestran las partidas ya concluidas y su resultado");
							System.out.println("\n\tTotal de partidas concluidas: "+(juego1.length+juego2.length+juego3.length)+"\n");
							int count=1;
							// Se imprimen los objetos de Mini BlackJack con su respectivo estado
							for(int i=0; i<juego1.length; i++){
								String estado1=juego1[i].obtenerEstado();
								System.out.println((count)+".- "+estado1);
								count++;
							}
							// Se imprimen los objetos de Dados con su respectivo estado
							for(int i=0; i<juego2.length; i++){
								String estado=juego2[i].obtenerEstado();
								System.out.println((count)+".- "+estado);
								count++;
							}
							// Se imprimen los objetos de Conecta 4 con su respectivo estado
							for(int i=0; i<juego3.length; i++){
								String estado=juego3[i].obtenerEstado();
								System.out.println((count)+".- "+estado);
								count++;
							}
					break;*/
					// Salir del programa
					case 6: //ut.EscribirObjetosArchivo("jugadores.txt",jugadores); // Se guardan los objetos de tipo jugador nuevos (los registros nuevos)
							System.out.println("\n\tHasta luego :)\n");
							System.exit(0); // Salida del programa 
					break;

					case 7: 
						if (!viveros.isEmpty()) {
							System.out.println("\nIngresa el ID del vivero que quieres eliminar/editar\n");
							res = on.nextLine();
							if (idsViveros.contains(res)) {
								
							}
						}else {
							System.out.println("No hay viveros registrados");
							excep = true;
						}
					break;
					case 8: //ut.EscribirObjetosArchivo("jugadores.txt",jugadores); // Se guardan los objetos de tipo jugador nuevos (los registros nuevos)
							System.out.println("\n\tHasta luego :)\n");
							System.exit(0); // Salida del programa 
					break;
					case 9: //ut.EscribirObjetosArchivo("jugadores.txt",jugadores); // Se guardan los objetos de tipo jugador nuevos (los registros nuevos)
							System.out.println("\n\tHasta luego :)\n");
							System.exit(0); // Salida del programa 
					break;

					default:
							System.out.println("Elige una opcion de menu plis :c");
					break;
				}
			}catch(Exception e2){
				System.out.println("\n\n"+e2+"\nDebes ingresar un numero");
				in.next();
				excep=true;
			}
		}while(excep);
	}
}