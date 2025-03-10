# 📦 **Proyecto Neoris - Sistema de Gestión de Productos, Clientes y Promociones**

Este es un **proyecto Java 17** desarrollado en **Eclipse** que gestiona información sobre **productos**, **clientes**, **empleados**, **promociones** y **proveedores** dentro de un sistema. Utiliza el patrón de diseño **Facade** para encapsular la complejidad y proporcionar una interfaz sencilla para interactuar con el sistema.

## 🌟 **Descripción del Proyecto**

El sistema proporciona varios casos de uso resueltos a través de métodos de la interfaz `Facade`. Los casos de uso son los siguientes:

1. **Clientes que adquirieron un producto**: Muestra una lista de clientes que han adquirido un producto especificado.
2. **Empleados que atendieron a un cliente**: Muestra una lista de empleados que atendieron a un cliente específico.
3. **Productos con promociones vigentes**: Muestra una lista de productos que tienen promociones activas.
4. **Promociones para un producto**: Muestra todas las promociones aplicables a un producto especificado.
5. **Proveedores por categoría**: Muestra una lista de proveedores que ofrecen productos dentro de una categoría especificada.
6. **Reposición de productos**: Utiliza un hilo para verificar los productos que deben ser repuestos para mantener el stock y generar una fila en la tabla de reposición.

## 🛠️ **Patrones de Diseño Utilizados**

### 🔥 **Facade Pattern**

Este proyecto implementa el patrón de diseño **Facade** para simplificar la interacción con el sistema. La interfaz `Facade` proporciona una abstracción de alto nivel que permite realizar operaciones complejas sin tener que interactuar con las clases de dominio subyacentes. El patrón de diseño **Facade** es ideal para agrupar múltiples llamadas a métodos dentro de una única interfaz, mejorando la legibilidad y facilidad de uso del sistema.

## 📁 **Estructura del Proyecto**

La estructura del proyecto es la siguiente:

├───Scripts
└───src
    ├───app
    ├───db
    ├───neoris
    │   └───app
    │       └───domain
    ├───test
    │   └───neoris
    │       ├───app
    │       └───util
    └───thread

   
### 📂 **Descripción de las Carpetas**

- **src**: Código fuente del proyecto.
  - **app**: Clases principales de la aplicación.
  - **db**: Relacionado con la base de datos.
  - **neoris/app/domain**: Clases de dominio (`Categoria`, `Cliente`, `Empleado`, `Producto`, `Promocion`, `Proveedor`).
  - **test**: Clases de pruebas unitarias.
  - **thread**: Clases relacionadas con la funcionalidad de reposición de productos.
- **Scripts**: Scripts útiles para la gestión del proyecto, incluido el script de base de datos HSQLDB.

## ⚙️ **Casos de Uso Implementados**

### 🛒 **Caso de uso #1: Clientes que adquirieron un producto**

- `obtenerProductos()`: Devuelve la lista de productos disponibles.
- `obtenerClientesQueAdquirieron(int idProducto)`: Devuelve la lista de clientes que han adquirido un producto especificado.

### 👩‍💼 **Caso de uso #2: Empleados que atendieron a un cliente**

- `obtenerClientes()`: Devuelve la lista de clientes.
- `obtenerEmpleadosQueAntendieron(int idCliente)`: Devuelve la lista de empleados que atendieron al cliente especificado.

### 📦 **Caso de uso #3: Productos con promociones vigentes**

- `obtenerProductosConPromocionesVigentes()`: Devuelve la lista de productos con promociones activas.

### 🎁 **Caso de uso #4: Promociones para un producto**

- `obtenerPromociones(int idProducto)`: Devuelve todas las promociones aplicables a un producto.

### 🏢 **Caso de uso #5: Proveedores por categoría**

- `obtenerCategorias()`: Devuelve la lista de categorías disponibles.
- `obtenerProveedores(int idCategoria)`: Devuelve la lista de proveedores para una categoría especificada.

### 🔄 **Caso de uso #6: Reposición de productos**

- `generarReposicionProducto()`: Un hilo que verifica los productos que deben ser repuestos y genera una fila en la tabla de reposición.

## 📍 **Requisitos**

- **JDK 17** o superior.
- **Eclipse** (opcional, pero recomendado).
- **HSQLDB** como base de datos.
- **Maven** (opcional, para gestionar dependencias).

## Dependencias

Este proyecto utiliza HSQLDB como sistema de gestión de base de datos. Asegúrate de agregar el archivo `hsqldb.jar` a tu classpath antes de ejecutar el proyecto.

- Si estás usando **Maven** o **Gradle**, puedes agregar la dependencia HSQLDB como se muestra a continuación.
- Si no usas una herramienta de construcción, puedes descargar el archivo JAR desde [HSQLDB](http://hsqldb.org/) e incluirlo manualmente en tu entorno de desarrollo.
