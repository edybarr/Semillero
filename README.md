# Semillero

Se crean las dependencias en el build.gradle


Las clases  implementan la interfaz Task, que es parte del patrón de diseño Screenplay utilizado en Serenity BDD para la automatización de pruebas.

El objetivo principal de esta clase es realizar una solicitud GET a la API https://thecatapi.com/ para obtener información sobre razas, categorías y votos de gatos.


La clase GetVotes implementa la interfaz Task, lo que indica que es una tarea que se puede ejecutar en el contexto de un escenario de pruebas automatizadas.

La clase tiene dos variables miembro: resourceApi y voteID, que se pasan al constructor al crear una instancia de la tarea.

El constructor de la clase GetVotes asigna los valores pasados al constructor a las variables miembro correspondientes.

El método performAs es el método principal de la tarea. Se anota con @Step para indicar que es un paso en el escenario de pruebas y se muestra en el informe de ejecución. Recibe un objeto Actor, que representa al usuario o actor que realiza la tarea.

Dentro del método performAs, se verifica si el ID del voto (voteID) está en blanco. Si está en blanco, se envía una solicitud HTTP GET al recurso especificado por resourceApi sin incluir el parámetro "vote_id". De lo contrario, se incluye el parámetro "vote_id" en la solicitud GET.

En ambos casos, se establece el encabezado "X-API-KEY" en la solicitud HTTP GET utilizando el valor de la constante API_KEY.

Después de enviar la solicitud GET, se extrae la respuesta y se almacena.

El método executeGetVoteMethodWithThe es un método estático de conveniencia para crear y devolver una instancia de la clase GetVotes. Toma los parámetros resourceApi y voteID y los pasa al constructor de GetVotes utilizando el método Tasks.instrumented().

