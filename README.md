# Command

Problema y Contexto:

En el contexto de programación actual un simple programa puede ejecutar decenas, o incluso centenares, de invocaciones a subprocesos o subprogramas. En ocasiones es muy conveniente desacoplar la invocación de determinados procesos del contexto donde se encuentran, y ésto es precisamente el problema que viene a solucionar el patrón Command.

Además pueden surgir situaciones en las que las invocaciones deban de tratarse por medio de una cola, pila o estructura de datos similar. Mediante el patrón Command podemos realizar estas acciones de manera sencilla.

Se aplica cuando:

Precisamos de colas, pilas u otras estructuras para gestionar las invocaciones.
Exista la posibilidad de cancelar operaciones.
Se necesite parametrizar de manera uniforme las invocaciones.
El momento de ejecución del subprograma o subproceso deba de ser independiente del contexto en el que se invoca.
Necesitemos realizar llamadas a órdenes cuyos parámetros puedan ser otras órdenes (callbacks).
Las órdenes que debemos desarrollar son de alto nivel y por debajo son implementadas por órdenes simples (primitivas).

Solución y Estructura:

La solución consiste en crear una interfaz Command que contenga un método execute, permitiendo desde la misma ejecutar la operación a la que representa el comando. Adicionalmente, si se permite deshacer operaciones, deberemos añadir un método undo para poder hacerlo.

Las clases que implementen Command, a las que llamaremos ConcreteCommands, definirán la funcionalidad de la orden a la que representa el comando mediante la definición del método execute. Para ello utilizaremos los métodos del objeto que realmente implementa la funcionalidad, al que llamaremos Receiver.

La configuración de los ConcreteCommands y del Receiver se establecera mediante una entidad Client. Otra entidad llamada Invoker será la que utilizará la/las órden/órdenes implementadas.

*Esta conformado por*:

Command: interfaz que representa la orden que se pretende ejecutar de manera desacoplada, permitiendo su ejecución mediante el método execute.

Concrete Command: implementa Command y contiene una referencia al objeto Receiver, el cual contiene la auténtica funcionalidad. La implementación de execute se compondrá de una serie de acciones realizadas por Receiver.

Receiver: Objeto que implementa la funcionalidad que deseamos implementar en el Command. Uno o varios de sus métodos serán llamados a la hora de invocar a la función execute del Command.

Invoker: clase encargada de invocar el método Command.execute().

Client: Establece la configuración del ConcreteCommand y el Receiver.

Consecuencias:

POSITIVAS:

Desacoplamiento de la aplicación que invoca las órdenes y la implementación de las mismos.

Como las órdenes son objetos, podemos aplicar la herencia a las mismas o realizar composiciones de órdenes.

El conjunto de órdenes es escalable.

Permite modificar las órdenes a ejecutar en tiempo de ejecución.

NEGATIVAS:

Aumenta la volumen de nuestro código.

```java
// En primer lugar definiremos la interfaz Command

public interface Command{

        public void execute();

}



// Ahora definiremos una serie de clases que implementarán la funcionalidad

// correspondiente al elemento de nuestra casa inteligente que queremos 

// utilizar (Receivers).



// Elemento que permite apagar y encender las luces

public class Luces{

        public boolean conectar(){

                System.out.println("Conectando al sistema de iluminación...");

                try{

                        System.out.println("Conexión al sistema de iluminación establecida.");

                        return true;

                }catch(Exception e){

                        System.out.println("No se ha podido establecer la conexión al sistema de iluminación. ERROR:n"+e.getMessage());

                        return false;

                }

        }

        public boolean desconectar(){

                System.out.println("Desconectando del sistema de iluminación...");

                try{

                        System.out.println("Se ha desconectado del sistema de iluminación.");

                        return true;

                }catch(Exception e){

                        System.out.println("No se ha podido desconectar del sistema de iluminación. ERROR:n"+e.getMessage());

                        return false;

                }

        }

        public boolean encender(){

                System.out.println("Encendiendo el sistema de iluminación...");

                try{

                        System.out.println("Sistema de iluminación encendido.");

                        return true;

                }catch(Exception e){

                        System.out.println("No se ha podido encender el sistema de iluminación. ERROR:n"+e.getMessage());

                        return false;

                }

        }

        public boolean apagar(){

                System.out.println("Apagando el sistema de iluminación...");

                try{

                        System.out.println("Sistema de iluminación apagado.");

                        return true;

                }catch(Exception e){

                        System.out.println("No se ha podido apagar el sistema de iluminación. ERROR:n"+e.getMessage());

                        return false;

                }

        }

}



// Elemento que permite abrir y cerrar la portada

public class Portada{

        public boolean conectar(){

                System.out.println("Conectando al sistema de la portada...");

                try{

                        System.out.println("Conexión al sistema de la portada establecida.");

                        return true;

                }catch(Exception e){

                        System.out.println("No se ha podido establecer la conexión al sistema de la portada. ERROR:n"+e.getMessage());

                        return false;

                }

        }

        public boolean desconectar(){

                System.out.println("Desconectando del sistema de la portada...");

                try{

                        System.out.println("Se ha desconectado del sistema de la portada.");

                        return true;

                }catch(Exception e){

                        System.out.println("No se ha podido desconectar del sistema de la portada. ERROR:n"+e.getMessage());

                        return false;

                }

        }

        public boolean abrir(){

                System.out.println("Abriendo la portada...");

                try{

                        System.out.println("Portada abierta.");

                        return true;

                }catch(Exception e){

                        System.out.println("No se ha podido abrir la portada. ERROR:n"+e.getMessage());

                        return false;

                }

        }

        public boolean cerrar(){

                System.out.println("Cerrando la portada...");

                try{

                        System.out.println("Portada cerrada.");

                        return true;

                }catch(Exception e){

                        System.out.println("No se ha podido cerrar la portada. ERROR:n"+e.getMessage());

                        return false;

                }

        }

}



// Ahora definiremos los comandos concretos para cada acción

// (Concrete Commands)



// Comando para encender las luces

public class EncenderLuces implements Command{

        

        private Luces luces.



        public EncenderLuces(){

                this.luces = new Luces();

        }



        public void execute(){

                luces.conectar();

                luces.encender();

                luces.desconectar();

        }

}



// Comando para apagar las luces

public class ApagarLuces implements Command{

        

        private Luces luces.



        public ApagarLuces(){

                this.luces = new Luces();

        }



        public void execute(){

                luces.conectar();

                luces.apagar();

                luces.desconectar();

        }

}



// Comando para abrir la portada

public class AbrirPortada implements Command{

        

        private Portada portada.



        public AbrirPortada(){

                this.portada = new Portada();

        }



        public void execute(){

                luces.conectar();

                luces.abrir();

                luces.desconectar();

        }

}

// Comando para cerrar la portada

public class CerrarPortada implements Command{

        

        private Portada portada.



        public CerrarPortada(){

                this.portada = new Portada();

        }



        public void execute(){

                luces.conectar();

                luces.cerrar();

                luces.desconectar();

        }

}



// Ahora vamos a definir el Invoker, que simplemente será

// el encargado de llamar a una orden



public class Invoker{

        private Command orden;



        public Invoker(Command orden){

                this.orden = orden;

        }



        public void run(){

                orden.execute();

        }

}



// Vamos a ver el funcionamiento



public static void main(String [] args){

        

        Command command;



        if(args[0].equals("encender") && args[1].equals("luces")){

                command = new EncenderLuces();

        } else if(args[0].equals("apagar") && args[1].equals("luces")){

                command = new ApagarLuces();

        } else if(args[0].equals("abrir") && args[1].equals("portada")){

                command = new AbrirPortada();

        } else if(args[0].equals("cerrar") && args[1].equals("portada")){

                command = new CerrarPortada();

        }



        Invoker invoker = new Invoker(command);

        invoker.run();

        

}


```
