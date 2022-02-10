package Start;
import java.util.Map;
import java.util.Scanner;

class Instrucciones {
    private Map<String,Integer> map;

    public void Instrucciones(){

    }

    public void mov(String x){
        String[] Clave=x.split(",");
        if((Clave[0].matches("[0-9]+"))){
            map.put(Clave[1], Integer.valueOf(Clave[0]));
        }else{
            map.put(Clave[1],map.get(Clave[0]));
        }
    }

    public void add (String x){

        String[] Clave=x.split(",");
        int suma= (int) ((map.get(Clave[0])+map.get(Clave[1]))%(Math.pow(2,32)));
        map.put(Clave[0],suma);
    }

    public void dec(String x){
        //obtiene el valor de la clave x
        //y lo decrementa en 1
        int valor=map.get(x);
        if(valor>0){
            map.put(x,valor-1);
        }else{
            map.put(x, (int)(Math.pow(2,32)-1));
        }
    }

    public void inc(String x){
        //obtiene el valor de la clave x
        //y lo incrementa en 1
        int valor=map.get(x);
        if(valor==(Math.pow(2,32)-1)){
            map.put(x,0);
        }else{
            map.put(x, valor+1);
        }
    }

    public void inv(String x){
//Obtiene el valor de la clave x y lo convierte a bit
        //dentro del for lo invierte
        String result = Integer.toBinaryString(map.get(x));
        String cad="";
        for (int a=0; a<result.length();a++){
            char d=result.charAt(a);

            if(Character.compare(d,'0')==0){
                cad=cad+"1";
            }else{
                cad=cad+"0";
            }

        }
        //en esta parte vuelve a convertir a entero.
        map.put(x,Integer.parseInt(cad,2));
    }

    public void nop(String x){
    }


    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }
}
