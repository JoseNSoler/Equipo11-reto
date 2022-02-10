# Equipo11-reto

Programa para SofkaX que prueba diferente subrutinas para un procesador. El programa fue realizado en java, utilizando el IDE IntelliJ. Cada clase con sus respectivos
métodos vienen con una breve documentación para un mejor entendimiento del código y se encuentra en la rama master

La CPU tiene 43 registros de enteros sin signo representados en 32-bit, los cuales son nombrados R00..R42. Al inicio del programa todos los registros contienen 0. 
El procesador soporta las siguientes instrucciones:

*MOV Rxx,Ryy → copia el valor del registro Rxx al registro Ryy;

*MOV d,Rxx → copia la constante numérica d (especificada como un número decimal) al registro Rxx;

*ADD Rxx,Ryy → calcula (Rxx + Ryy) MOD 232 y almacena el resultado en el registro Rxx;

*DEC Rxx → disminuye el valor de Rxx en 1. Si el valor del registro es 0, al disminuirlo se genera un desbordamiento y su resultado sería 232–1;

*INC Rxx → aumenta el valor de Rxx en 1. Si el valor del registro es 232–1, al aumentarlo se genera un desbordamiento obteniendo por resultado 0;

*INV Rxx → ejecuta una inversión bit a bit del registro Rxx (convierte 1 en 0 y 0 en 1);

*JMP d   → salta incondicionalmente a la instrucción número d (basado en 1). Se garantiza que d es un número de instrucción válido;

*JZ d    → salta a la instrucción d (basado en 1) sólo si el registro R00 contiene 0;

*NOP     → no hace nada.

La subrutina ejemplo es la siguiente :

subrutina= [
  "MOV 5,R00",
  
  "MOV 10,R01",
  
  "JZ 7",
  
  "ADD R02,R01",
  
  "DEC R00",
  
  "JMP 3",
  
  "MOV R02,R42"
  
]

Teniendo en cuenta la siguiente tabla, la salida debe ser 50
https://imgur.com/aR3n9Sa, https://imgur.com/JzDPYwP


### Contribuidores

hansee1996@gmail.com

el-eche10@outlook.com

mateoytomas2009@hotmail.com

claudiaa2343@gmail.com

santiago.ci9619@gmail.com

jnsoler04@gmail.com








