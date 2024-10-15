# Conversor de Monedas

Este proyecto es un **Conversor de Monedas** que permite a los usuarios convertir una cantidad de dinero de una moneda a otra utilizando tasas de cambio en tiempo real proporcionadas por la API **ExchangeRate-API**.

## Funcionalidades

- **Selección de Monedas**: El usuario puede elegir las monedas de origen y destino desde una lista de opciones.
- **Conversión de Montos**: El programa realiza la conversión de la cantidad introducida por el usuario según la tasa de cambio actual.
- **Interfaz de Consola**: El programa interactúa con el usuario a través de la consola, lo que lo hace fácil de usar en cualquier entorno de terminal.

## Tecnologías

- **Java**: Lenguaje de programación utilizado para desarrollar el conversor.
- **API de ExchangeRate-API**: Utilizada para obtener las tasas de cambio actuales entre diferentes monedas.
- **JSON**: El formato de respuesta utilizado para procesar los datos de la API.

## Requisitos

- **Java 17 o superior**: Necesario para compilar y ejecutar el código.
- **Conexión a Internet**: Para poder realizar las solicitudes a la API de ExchangeRate.

## Configuración del Proyecto

1. **Descargar e Instalar Java**:
   - Asegúrate de tener Java instalado en tu máquina. Puedes descargarlo desde [la página oficial de Java](https://www.oracle.com/java/technologies/javase-downloads.html).
   - Verifica la instalación con el comando:
     ```bash
     java -version
     ```

2. **Obtener tu API Key**:
   - Para utilizar la API de tasas de cambio, necesitarás una API Key válida. Regístrate en [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener una clave.
   - Sustituye la clave `API_KEY` en el código por la clave obtenida.