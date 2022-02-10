package Start;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Main {

    // Se va a utilizar un map Para los registros
    public static void main(String[] args) {
        int contadorEjecuciones = 0;
        Map<String, Integer> registros = new HashMap<>();

        String [] subrutina = {
                        "MOV 5,R00",
                        "MOV 10,R01",
                        "JZ 7",
                        "ADD R02,R01",
                        "DEC R00",
                        "JMP 3",
                        "MOV R02,R42"
                };

        Instrucciones instrucciones = new Instrucciones(subrutina);

                // Creacion de 42 registros R
        IntStream numeroRegistro = IntStream.range(0, 42);
                // Repletar los registros con 0
        numeroRegistro.forEach(x ->
                        registros.put(String.format("R" + (x >= 10 ? "" : "0") + "%s", x), 0));
        instrucciones.setMap(registros);


        instrucciones.validarSubrutina();
        // Iteracion sobre todas las instrucciones en base a posSubRutina
        for (int posSubrutina = 0; posSubrutina < subrutina.length; posSubrutina++) {
            if (contadorEjecuciones++ <= 50000) {
                // rutinaInstruccion = MOV 5,R00
                // rutinaInstruccion[0] = MOV -- rutinaInstruccion[1] = 5, R00
                String[] rutinaInstruccion = subrutina[posSubrutina].split("\\s+");
                // nombreInstruccion = MOV
                String nombreInstruccion = rutinaInstruccion[0];
                switch (nombreInstruccion) {
                    case "MOV":
                        instrucciones.mov(rutinaInstruccion[1]);
                        break;
                    case "JZ":        // Dependiendo de si el valor en R00 en 0// Dependiendo de si el valor en R00 en 0/ Dependiendo de si el valor en R00 en 0
                       int instruccionN = instrucciones.getMap().get("R00");
                        // Dependiendo de si el valor en R00 en 0
                        if (instruccionN == 0) {
                            // Salta la iteracion hasta la instruccion valor R00
                            posSubrutina = Integer.parseInt(rutinaInstruccion[1]) - 2;
                        }
                        break;
                    case "ADD":
                        instrucciones.add(rutinaInstruccion[1]);
                        break;
                    case "DEC":
                        instrucciones.dec(rutinaInstruccion[1]);
                        break;
                    case "INC":
                        instrucciones.inc(rutinaInstruccion[1]);
                        break;
                    case "INV":
                        instrucciones.inv(rutinaInstruccion[1]);
                        break;
                    case "JMP":
                        // Salto incondicional a N instruccion
                        posSubrutina = Integer.parseInt(rutinaInstruccion[1]) - 2;
                        break;
                    case "NOP":
                        instrucciones.nop();
                        break;
                }
            } else {
                throw new IllegalArgumentException("_Error.- Maximo de iteraciones alcanzados");
                //System.out.println("_Error.- Maximo de iteraciones alcanzados");
            }
        }
        System.out.println(instrucciones.getMap().get("R42"));
    }
}
