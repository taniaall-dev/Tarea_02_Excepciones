# Reservas de asientos en el cine

**Descripción**: Ejercicio de Java centrado en el desarrollo de una aplicación de consola para gestionar las reservas de asientos en una sala de cine. Se trabaja con varias clases que colaboran entre sí, colecciones dinámicas, validación de datos y excepciones personalizadas para controlar los errores durante la gestión de las reservas.

## 📌 Instrucciones del ejercicio

Desarrollar una aplicación que permita gestionar las reservas de asientos de una sala de cine. Al iniciar el programa, se solicita el número de filas y de asientos por fila. Una vez configurada la sala, se muestra un menú desde el que se pueden consultar, crear y cancelar reservas.

**Objetivos del ejercicio:**

- Diseñar una aplicación compuesta por varias clases que colaboren entre sí.
- Trabajar con colecciones dinámicas como `ArrayList`.
- Crear y gestionar excepciones personalizadas no verificadas (*unchecked exceptions*).
- Aplicar validaciones para controlar las entradas del usuario.
- Utilizar los métodos `equals()`, `hashCode()` y `toString()` para trabajar con objetos.
- Interactuar con el usuario mediante la consola y gestionar los errores de entrada.

## ✨ Características

- **Configuración de la sala:** al iniciar el programa, se solicitan el número de filas y los asientos por fila. Se comprueba que ambas dimensiones sean números positivos antes de crear el servicio de reservas.
- **Menú interactivo:** la clase `ConsoleUI` presenta las opciones disponibles para consultar reservas, reservar asientos, cancelar reservas y salir de la aplicación.
- **Representación de los asientos:** la clase `Seat` almacena la fila, el número de asiento y el nombre de la persona que lo ha reservado.
- **Gestión de reservas:** la clase `ReservationService` contiene la lógica principal para reservar y cancelar asientos, consultar todas las reservas y buscar las correspondientes a una persona.
- **Consulta de reservas:** se pueden mostrar todas las reservas existentes o filtrar las reservas por el nombre de una persona.
- **Cancelación de reservas:** se puede cancelar una reserva individual o eliminar todas las reservas de una persona.
- **Validación de posiciones:** se comprueba que la fila y el asiento estén dentro de las dimensiones de la sala.
- **Validación de nombres:** se rechazan los nombres vacíos o formados únicamente por espacios en blanco, así como los que contienen números.
- **Control de asientos ocupados y vacíos:** se impide reservar un asiento que ya está reservado y cancelar un asiento que no tiene ninguna reserva.
- **Excepciones personalizadas:** se utilizan `InvalidSeatException`, `InvalidPersonNameException`, `SeatAlreadyTakenException` y `SeatAlreadyEmptyException` para identificar situaciones de error concretas.
- **Representación textual de las reservas:** el método `toString()` permite mostrar la fila, el asiento y el nombre de la persona asociada a la reserva.

## 🧩 Estructura de clases

La aplicación se organiza en varias clases con responsabilidades diferenciadas para separar la interacción con el usuario, la lógica de negocio y la representación de las reservas.

**`Main`**

Es el punto de entrada de la aplicación. Solicita las dimensiones de la sala mediante `ConsoleReader`, crea `ReservationService` y `ConsoleUI`, e inicia el menú. Si las dimensiones no son válidas, captura `IllegalArgumentException` y vuelve a solicitarlas.

**`ConsoleUI`**

Se encarga de mostrar el menú, leer las opciones y solicitar los datos necesarios para ejecutar cada operación. Llama a los métodos de `ReservationService` y muestra los resultados o los mensajes de error correspondientes.

**`ReservationService`**

Contiene la lógica de gestión de las reservas y almacena los asientos reservados en una lista. Se encarga de validar las posiciones y los nombres, controlar las reservas duplicadas y gestionar las cancelaciones y consultas.

**`Seat`**

Representa una reserva mediante los atributos `row`, `seat` y `personName`. Sobrescribe `equals()` y `hashCode()` para considerar iguales dos objetos que representan la misma fila y el mismo asiento, independientemente del nombre asociado. También sobrescribe `toString()` para mostrar la información de forma legible.

**Excepciones personalizadas**

Las clases `InvalidSeatException`, `InvalidPersonNameException`, `SeatAlreadyTakenException` y `SeatAlreadyEmptyException` heredan de `RuntimeException`. Permiten identificar errores relacionados con las posiciones, los nombres y el estado de las reservas.

## 📚 Investigación: excepciones personalizadas y métodos de comparación de objetos

### Excepciones verificadas y no verificadas

En Java, las excepciones se clasifican en verificadas (*checked*) y no verificadas (*unchecked*).

Las excepciones verificadas deben capturarse mediante `try-catch` o declararse con `throws`. Las no verificadas heredan de `RuntimeException` y no requieren esa gestión obligatoria para que el código compile, aunque pueden capturarse para controlar los errores.

En este ejercicio, las excepciones personalizadas heredan de `RuntimeException`. De esta manera, `ReservationService` puede lanzarlas cuando detecta una situación no válida y `ConsoleUI` puede capturarlas para mostrar el mensaje correspondiente sin terminar el flujo normal del menú.

### Métodos `equals()` y `hashCode()`

El método `equals()` permite definir cuándo dos objetos deben considerarse iguales. En la clase `Seat`, dos reservas se consideran iguales si coinciden la fila y el número de asiento, aunque el nombre de la persona sea diferente.

El método `hashCode()` genera un valor asociado al objeto y debe ser coherente con `equals()`: si dos objetos son iguales según `equals()`, deben tener el mismo código hash.

Esta implementación permite utilizar operaciones como `contains()` y `remove()` para localizar una reserva por su posición. Por ejemplo, el servicio puede comprobar si un asiento ya está ocupado sin necesitar conocer el nombre de la persona que lo ha reservado.

### Colecciones dinámicas

La clase `ReservationService` utiliza una lista de tipo `List<Seat>` cuya implementación es `ArrayList`. Esta colección permite añadir y eliminar reservas a medida que se realizan las operaciones.

Además, el método `getAllSeats()` devuelve una copia no modificable de la lista mediante `List.copyOf()`, evitando que quien recibe el resultado pueda modificar directamente la colección interna del servicio a través de esa lista.

## Pruebas realizadas en el Main

### Pasos de la prueba

El programa permite comprobar el comportamiento de la aplicación mediante el menú de consola. Las siguientes pruebas describen los casos que se pueden verificar con la implementación actual.

**1. Configuración de las dimensiones de la sala**

Se introducen el número de filas y los asientos por fila. Si alguna dimensión es menor que uno, se lanza `IllegalArgumentException`, se muestra el mensaje correspondiente y se vuelven a solicitar los datos.

**2. Visualización de todas las reservas**

Se selecciona la opción 1 del menú. Si no existen reservas, se muestra el mensaje `No reservations`. Si hay reservas, se muestra la información de cada asiento.

**3. Consulta de las reservas de una persona**

Se selecciona la opción 2 y se introduce un nombre. El servicio busca las reservas asociadas a esa persona y muestra los resultados. Si el nombre está vacío o contiene números, se lanza `InvalidPersonNameException`.

**4. Reserva de un asiento**

Se selecciona la opción 3 y se introducen la fila, el número de asiento y el nombre de la persona. Si la posición es válida, el nombre cumple las condiciones y el asiento está libre, se crea la reserva. Si se produce un error, se captura la excepción correspondiente y se muestra su mensaje.

**5. Intento de reservar un asiento ocupado**

Se intenta reservar una posición que ya tiene una reserva. El servicio lanza `SeatAlreadyTakenException` y la interfaz muestra el mensaje de error correspondiente.

**6. Cancelación de una reserva**

Se selecciona la opción 4 y se introducen la fila y el asiento que se quieren cancelar. Si la posición es válida y está reservada, se elimina la reserva. Si no existe ninguna reserva en esa posición, se lanza `SeatAlreadyEmptyException`.

**7. Cancelación de todas las reservas de una persona**

Se selecciona la opción 5 y se introduce el nombre de la persona. Si existen reservas asociadas a ese nombre, se eliminan todas. Si no existen, se muestra el mensaje `This person has no reservations`.

**8. Comprobación de posiciones y nombres no válidos**

Se introducen posiciones fuera de los límites de la sala o nombres vacíos, formados por espacios o que contienen números. El servicio lanza las excepciones correspondientes y la interfaz muestra los mensajes de error.

**9. Salida de la aplicación**

Se selecciona la opción 0. El programa muestra `Goodbye` y finaliza el menú.

### Conclusión

Con este ejercicio he aprendido a desarrollar una aplicación de consola distribuida en varias clases, separando la interacción con el usuario de la lógica de gestión de las reservas. También he practicado el uso de colecciones dinámicas, la validación de datos y la creación de excepciones personalizadas para controlar situaciones no válidas.

Además, he trabajado con `equals()` y `hashCode()` para definir cuándo dos reservas representan el mismo asiento, y con `toString()` para mostrar los objetos de forma legible. Por último, he aprendido cómo las excepciones permiten comunicar errores entre las distintas clases y cómo pueden capturarse para mostrar mensajes al usuario y mantener el menú operativo.