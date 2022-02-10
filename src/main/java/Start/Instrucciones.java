package Start;

import java.util.Map;
import java.util.Scanner;

class Instrucciones {

    private Map<String, Integer> map;
    private String[] subrutina;

    /**
     * Clase Instrucciones que crea un objeto que contiene la subrutina a analizar.
     *
     * @param subrutina Subrutina a evaluar
     */
    public Instrucciones(String[] subrutina) {
        this.subrutina = subrutina;
    }

    /**
     * Metodo para validar que la subrutina entregada cumpla con la condicion de tener menos de 1024 instrucciones
     */
    public void validarSubrutina() {
        if (this.subrutina.length > 1024) {
            throw new IllegalArgumentException("_Error.- Maximo 1024 Instrucciones");
        }
    }

    /**
     * mov Funcion Ej: MOV 5,R00 || MOV R02,R42
     * referencia = 5, R00
     * value = 5 || R02 -- MemReferencia = R00 || R42
     * Si value es un <int>, copiara el numero a la posicion MemReferencia
     * Si value es un String con direccion en memoria, Copiara el valor en referencia de value
     * en MemReferencia
     */
    public void mov(String referencia) {
        String[] Clave = referencia.split(",");

        if ((Clave[0].matches("[0-9]+"))) {
            // Clave [1] referencia a la posicion Ryy
            map.put(Clave[1], Integer.valueOf(Clave[0]));
        } else {
            map.put(Clave[1], map.get(Clave[0]));
        }
    }

    /**
     * add funcion --EJ: ADD R02,R01
     * referencia = R02,R01
     * value = 5 || R02 -- MemReferencia = R00 || R42
     * si value es un <int>, copiara el numero a la posicion MemReferencia
     * si value es un String con direccion en memoria, Copiara el valor en referencia de value
     */
    public void add(String referencia) {
        String[] Clave = referencia.split(",");
        String MemRef1 = Clave[0];
        String MemRef2 = Clave[1];

        int suma = (int) ((map.get(MemRef1) + map.get(MemRef2)) % (Math.pow(2, 32)));
        map.put(MemRef1, suma);
    }


    /**
     * dec funcion --EJ: DEC R00
     * MemReferencia = R00
     * MemRef1 = R02 -- MemRef2 = R01
     * Disminuye el valor de MemReferencia en 1. Si el valor del registro es 0, al disminuirlo_
     * Se genera un desbordamiento y su resultado sería 232–1.
     */
    public void dec(String MemReferencia) {
        //obtiene el valor de la clave x
        //y lo decrementa en 1
        int valor = map.get(MemReferencia);
        if (valor > 0) {
            map.put(MemReferencia, valor - 1);
        } else {
            map.put(MemReferencia, (int) (Math.pow(2, 32) - 1));
        }
    }


    /**
     * inc funcion --EJ: INC R01
     * MemReferencia = R01
     * Aumenta el valor de MemReferencia en 1. Si el valor del registro es 232–1, al aumentarlo_
     * _se genera un desbordamiento obteniendo por resultado 0.
     */
    public void inc(String MemReferencia) {
        //obtiene el valor de la clave referencia
        //y lo incrementa en 1
        int valor = map.get(MemReferencia);
        if (valor == (Math.pow(2, 32) - 1)) {
            map.put(MemReferencia, 0);
        } else {
            map.put(MemReferencia, valor + 1);
        }
    }

    /**
     * inv funcion --EJ: INV R01
     * MemReferencia = R01
     * Ejecuta una inversión bit a bit del registro MemReferencia (convierte 1 en 0 y 0 en 1).
     */
    public void inv(String MemReferencia) {
        //Obtiene el valor de la clave x y lo convierte a bit
        //dentro del for lo invierte
        String result = Integer.toBinaryString(map.get(MemReferencia));
        String cadenaBinaria = "";
        for (int a = 0; a < result.length(); a++) {
            char d = result.charAt(a);

            if (Character.compare(d, '0') == 0) {
                cadenaBinaria = cadenaBinaria + "1";
            } else {
                cadenaBinaria = cadenaBinaria + "0";
            }

        }
        //en esta parte vuelve a convertir a entero.
        map.put(MemReferencia, Integer.parseInt(cadenaBinaria, 2));
    }

    /**
     * Instruccion que no realiza ninguna accion en el registro
     */
    public void nop() {
    }

    /**
     * Getter para retonar un objeto clave-valor de los registros
     */
    public Map<String, Integer> getMap() {
        return map;
    }

    /**
     * Setter para establecer un objeto objeto clave-valor que almacene los registros
     */
    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }
}
