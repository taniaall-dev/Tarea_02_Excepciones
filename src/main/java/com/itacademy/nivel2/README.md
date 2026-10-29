# Lectura segura desde el teclado

**Descripción**: Ejercicio de Java centrado en la lectura segura de datos introducidos por teclado mediante `Scanner`, el tratamiento de excepciones estándar y personalizadas, y la validación de entradas para evitar que el programa se interrumpa cuando el usuario introduce datos incorrectos.

## 📌 Instrucciones del ejercicio

Desarrollar una clase utilitaria llamada `ConsoleReader` que permita leer distintos tipos de datos desde el teclado de forma segura. La clase debe gestionar los errores de entrada, mostrar mensajes personalizados y volver a solicitar los datos hasta que sean válidos.

**Objetivos del ejercicio:**

- Aprender a capturar y gestionar excepciones durante la introducción de datos por teclado.
- Evitar que la aplicación se cierre debido a errores de entrada del usuario.
- Practicar el uso de excepciones estándar, como `InputMismatchException`, y excepciones personalizadas.
- Consolidar el uso de métodos estáticos para facilitar la reutilización del código.
- Validar los datos introducidos antes de devolverlos al programa.

## ✨ Características

- **Clase utilitaria `ConsoleReader`:** clase final que agrupa los métodos estáticos encargados de leer los datos. Su constructor es privado para impedir que se creen instancias de la clase.
- **Uso de `Scanner`:** se utiliza un único objeto `Scanner`, almacenado en un atributo estático y privado, para leer los datos introducidos por teclado.
- **Lectura de tipos numéricos:** los métodos `readByte()`, `readInt()`, `readFloat()` y `readDouble()` permiten leer valores numéricos de distintos tipos. Si se produce una `InputMismatchException`, se muestra un mensaje de error y se vuelve a solicitar el dato.
- **Lectura de caracteres:** el método `readChar()` comprueba que la entrada contenga un único carácter. Si la longitud es diferente de uno, lanza una excepción personalizada.
- **Lectura de cadenas de texto:** el método `readString()` permite introducir una cadena y comprueba que no esté vacía ni contenga únicamente espacios en blanco.
- **Lectura de respuestas afirmativas o negativas:** el método `readYesNo()` acepta las respuestas `y` y `n`, sin distinguir entre mayúsculas y minúsculas. Devuelve `true` para `y` y `false` para `n`. Cualquier otra entrada genera una excepción personalizada.
- **Excepción personalizada `InvalidInputException`:** excepción propia del ejercicio que hereda de `Exception` y permite comunicar errores de validación mediante mensajes específicos.
- **Repetición de las solicitudes:** los métodos de lectura utilizan bucles `while` para volver a solicitar los datos cuando la entrada no cumple las condiciones establecidas.
- **Clase `Main`:** contiene el método `readAndDisplayData()`, que utiliza `ConsoleReader` para solicitar diferentes datos personales y mostrar después un resumen por consola.

## 📚 Investigación: excepciones estándar y personalizadas

En Java, las excepciones permiten gestionar situaciones anómalas que se producen durante la ejecución de un programa. En este ejercicio se utilizan tanto una excepción estándar como una excepción personalizada.

**`InputMismatchException`**

Es una excepción estándar que se produce cuando un método de lectura de `Scanner` recibe un dato que no coincide con el tipo esperado. Por ejemplo, puede producirse al introducir texto cuando se espera un número entero.

Los métodos `readByte()`, `readInt()`, `readFloat()` y `readDouble()` utilizan bloques `try-catch` para capturar esta excepción. Cuando se produce, se descarta la entrada incorrecta y se muestra un mensaje de error antes de volver a solicitar el dato.

**`InvalidInputException`**

Es una excepción personalizada creada para representar errores de validación que no quedan cubiertos por `InputMismatchException`.

La clase hereda de `Exception`, por lo que es una excepción verificada (*checked exception*). Esto significa que Java obliga a capturarla o declararla mediante `throws`.

En este ejercicio, los métodos `readChar()`, `readString()` y `readYesNo()` utilizan esta excepción cuando la entrada no cumple las condiciones establecidas. La excepción se captura dentro del propio método y se muestra su mensaje mediante `getMessage()`.

**Diferencias entre ambas excepciones**

La diferencia principal es que `InputMismatchException` ya forma parte de Java y permite detectar determinados errores de formato al leer datos con `Scanner`, mientras que `InvalidInputException` se define específicamente para comunicar errores de validación establecidos por el programador.

Ambas pueden capturarse mediante `try-catch`. Sin embargo, al heredar de `Exception` y no de `RuntimeException`, `InvalidInputException` requiere una gestión obligatoria en el código para que compile.

## Pruebas realizadas en el Main

### Pasos de la prueba

El método `readAndDisplayData()` permite comprobar el funcionamiento de los métodos de lectura de `ConsoleReader` al solicitar distintos tipos de datos.

**1. Lectura de una cadena de texto**

Se solicita el nombre mediante `readString()`. Si se introduce una cadena vacía o formada únicamente por espacios, se muestra el mensaje de error correspondiente y se vuelve a solicitar el dato.

**2. Lectura de un número entero pequeño**

Se solicita la edad mediante `readByte()`. Si se introduce un valor que no puede convertirse al tipo esperado, se captura `InputMismatchException` y se vuelve a solicitar la entrada.

**3. Lectura de un carácter**

Se solicita la inicial del nombre mediante `readChar()`. Si se introduce más de un carácter o no se introduce ninguno, se lanza y captura `InvalidInputException`.

**4. Lectura de un número entero**

Se solicita el número de hermanos mediante `readInt()`. Si la entrada no tiene un formato válido para un entero, se muestra el mensaje de error y se repite la solicitud.

**5. Lectura de números decimales**

Se solicita la altura mediante `readFloat()` y el peso mediante `readDouble()`. Estos métodos gestionan los errores de formato mediante `InputMismatchException`.

**6. Lectura de una respuesta afirmativa o negativa**

Se solicita una respuesta mediante `readYesNo()`. El método acepta `y` o `n`, tanto en mayúsculas como en minúsculas, y devuelve un valor booleano. Las demás entradas provocan una `InvalidInputException`, que se captura para volver a solicitar la respuesta.

**7. Visualización de los datos**

Cuando todas las entradas son válidas, se muestran por consola los datos introducidos: nombre, edad, inicial, número de hermanos, altura, peso y respuesta a la pregunta final.

### Conclusión

Con este ejercicio he aprendido a utilizar excepciones estándar y personalizadas para gestionar errores durante la lectura de datos por teclado. También he practicado la validación de entradas, el uso de bloques `try-catch` y de bucles `while` para volver a solicitar los datos hasta que sean válidos.

Además, he trabajado con métodos estáticos y una clase utilitaria que centraliza la lectura de diferentes tipos de datos, lo que permite reutilizar la lógica de entrada en otras partes del programa sin tener que repetirla. Por último, he aprendido a crear una excepción personalizada para controlar situaciones que requieren reglas de validación específicas.