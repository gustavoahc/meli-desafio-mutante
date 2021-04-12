# meli-desafio-mutante

Reto propuesto para determinar si un humano es mutante a partir de su ADN por medio de una API REST 

## Tecnologias
* Java 11
* Spring Boot
* Maven
* MySql (Azure)
* JPA

## Endpoints

- [Servicio validador de ADN](https://mutant-1617995143666.azurewebsites.net/mutant)
- [Servicio de estadisticas](https://mutant-1617995143666.azurewebsites.net/stats)
- [Servicio para el listado de registros](https://mutant-1617995143666.azurewebsites.net/list)
- [Documentacion Swagger](https://mutant-1617995143666.azurewebsites.net/swagger-ui.html)

## Uso

Request: 
- POST https://mutant-1617995143666.azurewebsites.net/mutant

### Mutante

Request body:

```
  {"dna":["ATGCGA", "CAGTGC", "TTGTCT", "ATACTG", "CCCTTA", "TCTATG"]}
```

Response:

```
  200 OK
```

### Humano

Request body:

```
  {"dna":["ATGCGA", "CAGTGC", "TTGTCT", "ATACTG", "CCGTTA", "TCTATG"]}
```

Response:

```
  403 Forbidden
```

### Estadisticas

Request: 
- GET https://mutant-1617995143666.azurewebsites.net/stats

Response: 200

```
{
    "ratio": 67.0,
    "count_mutant_dna": 4,
    "count_human_dna": 2
}
```

#### Notas

- Se valida que sea una matriz cuadrada
- Se validan las letras ingresadas en la secuencia de ADN (solamente se permiten las letras A, T, C, G)
- Si la secuencia de ADN es válida, se indica si es mutante o humano. Pero si el código ingresado ya existe en la base de datos, no se ingresa nuevamente y no cuenta para las estadísticas

### Ejecutar localmente

Utilizar el siguiente comando para correr el programa localmente:

```
mvn spring-boot:run
```

Por defecto la aplicacion se va a conectar a la base de datos alojada en Azure. Para conectar a cualquier otra base de datos se deben configurar los datos de conexión en el archivo src\main\resources\application.properties. El script de creación de la tabla se encuentra en el archivo db\stat.sql


### - [Gustavo Adolfo Hernández Cabrera](gustavhc@gmail.com)
