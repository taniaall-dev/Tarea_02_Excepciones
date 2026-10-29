# Excepciones personalizadas y control de errores

**Descripción**: Ejercicio de Java centrado en la gestión de errores mediante excepciones personalizadas y excepciones propias del lenguaje. Se trabaja con colecciones de productos, cálculos sobre sus precios y el tratamiento de situaciones excepcionales durante la ejecución del programa.

## 📌 Instrucciones del ejercicio
Desarrollar un programa Java para gestionar productos y calcular el importe total de una venta, controlando los posibles errores que puedan producirse durante la ejecución.

**Objetivos del ejercicio:**

- Crear una excepción personalizada y aprender a lanzarla y capturarla.
- Trabajar con colecciones (`ArrayList<Product>`) y realizar cálculos sobre los datos almacenados.
- Detectar y gestionar errores habituales al manipular colecciones, como `IndexOutOfBoundsException`.
- Comprender las diferencias entre las excepciones verificadas (_checked_) y las no verificadas (_unchecked_).

## ✨ Características

- **Representación de productos:** creación de la clase `Product`, con los atributos `name` y `price`, para representar cada producto de una venta.
- **Gestión de ventas:** creación de la clase `Sale`, encargada de almacenar una colección de productos y guardar el importe total en el atributo `totalPrice`.
- **Cálculo del importe total:** implementación del método `calculateTotal()`, que comprueba si hay productos antes de calcular la suma de sus precios.
- **Excepción personalizada:** creación de `EmptySaleException` para controlar el intento de calcular una venta sin productos. El mensaje asociado será: «Para hacer una venta primero debes añadir productos».
- **Control de errores en colecciones:** prueba de una situación que genere `IndexOutOfBoundsException` y captura de la excepción para mostrar el mensaje de error.
- **Excepciones verificadas y no verificadas:** modificación de `EmptySaleException` para que herede de `RuntimeException` y análisis de las implicaciones de este cambio.

## 📚 Investigación: diferencias entre excepción verificada y excepción no verificada
En Java, las excepciones se clasifican en verificadas (checked) y no verificadas (unchecked). La principal diferencia entre ambas es si el compilador obliga a gestionar la excepción mediante un bloque try-catch o a declararla mediante throws.

Las excepciones verificadas, como una excepción personalizada que hereda de Exception sin heredar de RuntimeException, deben capturarse o declararse para que el código compile. En cambio, las excepciones no verificadas, como las que heredan de RuntimeException, no requieren esa gestión obligatoria, aunque también pueden capturarse mediante try-catch.

En este ejercicio, se prueba inicialmente EmptySaleException heredando de Exception y, posteriormente, se cambia a RuntimeException para comprobar las diferencias entre ambos tipos. Con la primera versión, es obligatorio capturar la excepción o declararla mediante throws; con la segunda, esa obligación desaparece, aunque la excepción sigue pudiendo lanzarse y capturarse. Si no se captura, puede interrumpir la ejecución del programa.

Esta prueba permite comprender que la diferencia principal entre ambos tipos de excepciones no es que unas puedan capturarse y otras no, sino la obligación de gestionarlas que impone Java durante la compilación.

## Pruebas realizadas en el Main

### Pasos de la prueba

Pruebas realizadas en Main

**1. Preparación de los datos**

Se crean cuatro objetos `Product` con sus respectivos nombres y precios. A continuación, se prepara una lista con los cuatro productos y otra lista vacía. Con ambas listas se crean dos objetos Sale para comprobar el comportamiento del cálculo del importe en distintas situaciones.

**2. Acceso a una posición inexistente**

Se intenta acceder a la posición 5 de una lista que contiene cuatro productos. Como las posiciones válidas van de 0 a 3, se produce una `IndexOutOfBoundsException`. La excepción se captura mediante un bloque `try-catch` y se muestra su mensaje de error.

**3. Cálculo del importe de una venta con productos**

Se llama al método `calculateTotal()` sobre una venta que contiene cuatro productos. Se comprueba que el método suma sus precios y devuelve el importe total de 24.79, sin lanzar la excepción personalizada.

**4. Cálculo del importe de una venta vacía**

Se llama al método `calculateTotal()` sobre una venta sin productos. Se comprueba que el método lanza `EmptySaleException` y que el bloque catch captura la excepción y muestra el mensaje correspondiente: To make a sale, you must first add products.

**5. Continuación de la ejecución**

Después de las pruebas, se muestra el mensaje End of test. Esto permite comprobar que el programa continúa ejecutándose después de capturar las excepciones, en lugar de finalizar a causa de ellas.

### Conclusión  

Con este ejercicio he aprendido a utilizar excepciones para controlar errores y a entender cómo afectan al funcionamiento de un programa. Las pruebas me han permitido comprobar las diferencias entre las excepciones verificadas (*checked*) y las no verificadas (*unchecked*). Las excepciones *checked* deben capturarse con `try-catch` o declararse con `throws`; si no se hace, IntelliJ IDEA señala el error y el programa no compila, por lo que no se puede ejecutar. En cambio, las excepciones *unchecked* no requieren esta gestión obligatoria y permiten ejecutar el programa sin necesidad de capturarlas o declararlas, aunque pueden producir errores durante la ejecución.
