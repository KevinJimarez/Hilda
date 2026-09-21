# Demostración de Build con Maven

Este proyecto muestra de forma sencilla la fase **Build** del ciclo DevOps. El código representa pedidos de una cafetería. Maven prepara el proyecto, compila Java, ejecuta dos pruebas y empaqueta el resultado en un archivo JAR.

## Qué se demuestra

El flujo de la presentación se ve aquí de forma práctica:

```text
Código en Git -> Maven lee pom.xml -> compila -> prueba -> empaqueta -> genera un JAR
```

Git conserva el historial del código. Maven transforma una versión concreta de ese código en un artefacto ejecutable. Son herramientas distintas y complementarias.

## Requisitos

- Visual Studio Code
- JDK 17 o una versión posterior
- Apache Maven 3.9 o una versión posterior
- Extensiones recomendadas de VS Code: Extension Pack for Java y Maven for Java

Verifica el entorno en la terminal de VS Code:

```bash
java -version
mvn -version
```

## Abrir el proyecto en VS Code

1. Descarga o clona este repositorio.
2. Abre la carpeta `Hilda` en Visual Studio Code.
3. Espera a que VS Code reconozca el proyecto Maven.
4. Abre una terminal dentro de VS Code.

Si Git está instalado, también puedes clonarlo con:

```bash
git clone https://github.com/KevinJimarez/Hilda.git
cd Hilda
code .
```

## Demostración rápida

### Opción 1 Terminal

Construye el proyecto:

```bash
mvn clean package
```

Durante este comando Maven:

1. `clean` elimina la carpeta `target` anterior.
2. `compile` transforma los archivos `.java` en archivos `.class`.
3. `test` ejecuta las pruebas de `CafeteriaTest`.
4. `package` crea el archivo `target/cafeteria-1.0-SNAPSHOT.jar`.

Si todo funciona, al final aparece:

```text
BUILD SUCCESS
```

Ejecuta el artefacto construido:

```bash
java -jar target/cafeteria-1.0-SNAPSHOT.jar
```

Resultado esperado:

```text
=== PEDIDOS DE CAFETERÍA ===
Ana pidió Café americano - $35.00
Luis pidió Sándwich - $65.00
Total de la venta: $100.00
```

### Opción 2 Tareas de VS Code

1. Abre la paleta de comandos con `Ctrl+Shift+P` o `Cmd+Shift+P`.
2. Escribe `Run Task`.
3. Elige `1. Construir con Maven`.
4. Repite el proceso y elige `2. Ejecutar el JAR`.

## Archivos importantes

```text
pom.xml                              Configuración de Maven
src/main/java/.../App.java           Programa principal
src/main/java/.../Cafeteria.java     Lógica de los pedidos
src/main/java/.../Pedido.java        Datos y validaciones de cada pedido
src/test/java/.../CafeteriaTest.java Pruebas automáticas
target/                               Salida generada por Maven
.github/workflows/build.yml           Build automático en GitHub Actions
```

## Cómo explicarlo durante la exposición

1. Muestra `App.java` y explica que es el código fuente versionado.
2. Muestra `pom.xml` y señala la versión de Java, JUnit y los plugins.
3. Ejecuta `mvn clean package`.
4. Señala que las pruebas pasan y aparece `BUILD SUCCESS`.
5. Abre `target` y muestra el JAR. Ese archivo es el artefacto de Build.
6. Ejecuta el JAR para comprobar que el artefacto funciona.
7. Abre la pestaña Actions de GitHub para mostrar que el mismo build puede repetirse en CI.

## Qué ocurre si una prueba falla

Cambia temporalmente en `CafeteriaTest.java` el total esperado de `100.00` a `99.00` y vuelve a ejecutar:

```bash
mvn clean package
```

Maven detendrá el proceso y no entregará un paquete aprobado. Después regresa el valor a `100.00` y repite el build. Esto demuestra la práctica de detener la entrega ante un fallo.

## Git y Maven no hacen lo mismo

| Git | Maven |
| --- | --- |
| Registra cambios y commits | Compila, prueba y empaqueta |
| Permite colaborar con ramas | Resuelve dependencias del proyecto |
| Conserva la historia del código | Crea un artefacto en `target` |
| Indica qué versión del código usamos | Convierte esa versión en un JAR comprobable |

Git responde **qué cambió y quién lo cambió**. Maven responde **cómo convertir ese código en un programa listo para probar**.

## Build automático en GitHub

El archivo `.github/workflows/build.yml` ejecuta `mvn clean package` cada vez que se envía un cambio a la rama `main` o se abre una solicitud de cambios. Así el equipo repite el mismo proceso en un entorno limpio y detecta errores antes de continuar a la fase Test o Release.

## Problemas comunes

- `mvn: command not found`: Maven no está instalado o no está agregado al PATH.
- `JAVA_HOME` incorrecto: revisa que Maven muestre Java 17 o posterior con `mvn -version`.
- Error al descargar una dependencia: revisa la conexión a Internet y vuelve a ejecutar el comando.
- Una prueba falla: lee el primer error de `target/surefire-reports`, corrige el código y repite el build.

## Relación con las diapositivas

El ejemplo aplica la herramienta seleccionada en la presentación:

- Entrada: código fuente, `pom.xml` y pruebas.
- Proceso: limpiar, compilar, verificar y empaquetar.
- Salida: `cafeteria-1.0-SNAPSHOT.jar` y reportes de pruebas.
- Trazabilidad: el repositorio identifica el commit que produjo cada ejecución del flujo.
