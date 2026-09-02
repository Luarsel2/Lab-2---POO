# Lab-2-POO
# Raul Robles - 26919
# Luis Garcia - 26547

- 1. ¿Qué propiedades y métodos tendrá cada clase?
Parque:
Propiedades: Nombre, código de identificación, nombre del encargado, lista de puntos de acceso, lista de visitantes.
Métodos: Registrar/modificar/cerrar punto de acceso, registrar/buscar/modificar/eliminar visitante, y calcular estadísticas.
PuntoAcceso:
Propiedades: Código, nombre, ubicación, capacidad máxima por hora, estado (abierto/cerrado).
Métodos: Getters y setters.
Visitante:
Propiedades: Código de entrada, nombre, edad, atracciones visitadas, puntos acumulados.
Métodos: Getters y setters.
- 2. ¿Qué tipo deben tener las propiedades y métodos de cada clase?
Cadenas de texto (String): Nombres, códigos y ubicaciones.
Enteros (int): Capacidad máxima, edad, cantidad de atracciones y puntos acumulados.
Booleanos (boolean): Estado del punto de acceso (ej. true = abierto, false = cerrado).
Los métodos de gestión en Parque retornarán principalmente void o el objeto buscado (Visitante o PuntoAcceso), mientras que los cálculos de estadísticas retornarán int o double (para el promedio).
- 3. ¿Cuál de las propiedades identificadas debe implementarse utilizando un arreglo básico? ¿Qué tipo de objetos almacenará y cuál será su tamaño?
La propiedad correspondiente a los puntos de acceso (dentro de la clase Parque). Será un arreglo de tipo PuntoAcceso[] y tendrá un tamaño fijo de 5.
- 4. ¿Cuál de las propiedades identificadas debe implementarse utilizando un ArrayList? ¿Qué tipo de objetos almacenará?
La propiedad correspondiente a los visitantes registrados. Se implementará como un ArrayList<Visitante> para manejar una cantidad desconocida (dinámica) de objetos de tipo Visitante.
- 5. ¿Cuáles deben ser los modificadores de visibilidad de los miembros en cada clase?
Propiedades (atributos): Deben ser private en todas las clases para asegurar el encapsulamiento y evitar alteraciones directas.
Métodos (constructores, getters, setters y cálculos): Deben ser public para permitir la interacción del menú principal con los objetos.
- 6. ¿Qué parámetros serán requeridos por los métodos en sus clases?
Para instanciar: Los constructores pedirán los atributos base (ej. código, nombre, ubicación, etc.).
Para buscar/eliminar: Los métodos de búsqueda pedirán el String codigoEntrada (visitantes) o el int indice (puntos de acceso).
Para registrar en el arreglo: El método pedirá el objeto PuntoAcceso y la posición int indice.
- 7. ¿Cómo proveerá de valores iniciales a sus objetos? ¿Qué valores deberán validarse antes de modificar el estado de los objetos?
Los valores iniciales se proveerán mediante los constructores al momento de usar la palabra reservada new.
Se deben validar:
En PuntoAcceso: Capacidad máxima > 0.
En Visitante: Edad > 0, atracciones >= 0 y puntos acumulados >= 0.
Si no se cumplen, los setters o constructores deberán lanzar un throw new IllegalArgumentException("Mensaje de error");.
- 8. ¿Cómo determinará si una posición del arreglo contiene un punto de acceso o contiene null?
Mediante una condición básica de desigualdad: if (arreglo[indice] != null). Si la condición se cumple, la posición está ocupada y es seguro llamar a sus métodos.
- 9. ¿Cómo realizará las operaciones de búsqueda, modificación y eliminación dentro del ArrayList?
Búsqueda: Utilizando un ciclo for o for-each para recorrer el ArrayList. Por cada iteración, se compara el código del visitante con .equals().
Modificación: Una vez encontrado el índice del visitante (o el objeto mismo), se utilizan sus métodos setters (setEdad(), setPuntos(), etc.).
Eliminación: Una vez localizado, se utiliza el método nativo de la lista: listaVisitantes.remove(visitanteEncontrado);.
- 10. ¿Qué situaciones del programa pueden producir excepciones? Identifique qué excepciones deberán manejarse y en qué partes del programa utilizará try-catch y finally.
InputMismatchException: En la clase Main (menú), al utilizar Scanner cuando se espera un número y el usuario teclea una letra. Se usa el try-catch para atraparlo, limpiar el buffer (scanner.nextLine()) y mostrar un mensaje de error.
IllegalArgumentException: Se lanza desde dentro de las clases Visitante y PuntoAcceso si los números no cumplen las reglas (ej. valores negativos). El Main lo atrapa en un bloque catch para evitar que el programa se cierre.
finally: Se colocará en las operaciones de lectura o menús para imprimir un mensaje (ej. "Operación de validación finalizada") o para asegurar la limpieza del Scanner independientemente de si hubo error o éxito