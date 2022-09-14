import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Utilidades {
    
    
    public boolean isFileExists(File file) {
        return file.exists() && !file.isDirectory();
    }

	public void crearCSV(String file,String cadena) {
		final String NEXT_LINE = "\n";
        File nuevofile = new File(file);
        if(isFileExists(nuevofile)){
            try {
                FileWriter fw = new FileWriter(file,true);
                fw.append(cadena);
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
    		try {
                FileWriter fw = new FileWriter(file);
                fw.append(cadena);
                fw.flush();
    			fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
    
    public List<Empleado> listaEmp(String file){
        List<Empleado> auxiliar = new ArrayList<>();
        try {
            FileReader read = new FileReader(file);
            BufferedReader bufer = new BufferedReader(read);
            String temp =" ";
            int contador = 0;
            while(temp!=null){
                temp = bufer.readLine();
                String x = temp;
                if(temp!=null){
                    String[] arrSplit = x.split(",");
                    //crea a los objetos Empleados 
                    String list = arrSplit[3];
                    String[] listSplit = list.split(";");
                    List<String> correos = new ArrayList<>(Arrays.asList(listSplit));
                    String list1 = arrSplit[5];
                    String[] listSplit1 = list1.split(";");
                    List<String> telefonos = new ArrayList<>(Arrays.asList(listSplit1));
                    //crea a los objetos Viveros 
                    String list2 = arrSplit[11];
                    String[] listSplit2 = list2.split(";");
                    List<String> telefonosV = new ArrayList<>(Arrays.asList(listSplit2));
                    //System.out.println(arrSplit[3]);
                    Vivero vivero = new Vivero(arrSplit[8],
                                        arrSplit[9],
                                        arrSplit[10],
                                        telefonosV,
                                        arrSplit[13],
                                        arrSplit[13]);                 
                    Empleado e = new Empleado(arrSplit[0],
                                        arrSplit[1],
                                        arrSplit[2],
                                        correos,
                                        arrSplit[4],
                                        telefonos,
                                        arrSplit[6],
                                        arrSplit[7],
                                        vivero);
                    auxiliar.add(e);
                }
                contador++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return auxiliar;
    }

    public Vivero crearViv(String cadena){
        String[] arrSplit = cadena.split(",");
            //crea a los objetos Viveros 
            String list = arrSplit[3];
            String[] listSplit = list.split(";");
            List<String> telefonos = new ArrayList<>(Arrays.asList(listSplit));
            Vivero e = new Vivero(arrSplit[0],
                                arrSplit[1],
                                arrSplit[2],
                                telefonos,
                                arrSplit[4],
                                arrSplit[5]);
        return e;
    }

     public List<Vivero> listaViv(String file){
        List<Vivero> auxiliar = new ArrayList<>();
        try {
            FileReader read = new FileReader(file);
            BufferedReader bufer = new BufferedReader(read);
            String temp =" ";
            int contador = 0;
            while(temp!=null){
                temp = bufer.readLine();
                String x = temp;
                if(temp!=null){
                    String[] arrSplit = x.split(",");
                    //crea a los objetos Viveros 
                    String list = arrSplit[3];
                    String[] listSplit = list.split(";");
                    List<String> telefonos = new ArrayList<>(Arrays.asList(listSplit));
                    Vivero e = new Vivero(arrSplit[0],
                                        arrSplit[1],
                                        arrSplit[2],
                                        telefonos,
                                        arrSplit[4],
                                        arrSplit[5]);
                    auxiliar.add(e); 
                }
                contador++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return auxiliar;
    }

    public List<Planta> listaPlanta(String file){
        List<Planta> auxiliar = new ArrayList<>();
        try {
            FileReader read = new FileReader(file);
            BufferedReader bufer = new BufferedReader(read);
            String temp =" ";
            int contador = 0;
            while(temp!=null){
                temp = bufer.readLine();
                String x = temp;
                if(temp!=null){
                    String[] arrSplit = x.split(",");
                    /*crea a los objetos Plantas */
                    Planta e = new Planta(arrSplit[0],
                                        arrSplit[1],
                                        arrSplit[2],
                                        arrSplit[3],
                                        arrSplit[4],
                                        arrSplit[5],
                                        arrSplit[6],
                                        arrSplit[7],
                                        arrSplit[8]);
                    auxiliar.add(e);
                    
                }
                contador++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return auxiliar;
    }

    public void cargaArchivo(List<String> cadena, String file){
        File nuevofile = new File(file);
        if(isFileExists(nuevofile)){
            try {
                FileWriter fw = new FileWriter(file);
                for(int i=0;i<cadena.size();i++){
                    fw.append(cadena.get(i));
                }
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("no es posible realizar estracción");
        }
    }
}