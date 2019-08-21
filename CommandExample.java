package Command;

//Cliente
public class Main
{
    public static void main(String[] args)
    {
        // Crear el objeto Menú (el Invocador)
        Menu objMenu = new Menu();
        // Crear el Receptor
        Receptor objReceptor = new Receptor();
        // Crear las opciones de menú, indicándoles el Receptor
        IMenuItem objOpcionAbrir = new MenuItemAbrir( objReceptor );
        IMenuItem objOpcionImprimir = new MenuItemImprimir( objReceptor );
        IMenuItem objOpcionSalir = new MenuItemSalir( objReceptor );
        // Agregar las opciones al Menú
        objMenu.add( objOpcionAbrir );
        objMenu.add( objOpcionImprimir );
        objMenu.add( objOpcionSalir );
        // Ejecutar cada opción del menú
        objMenu.get(0).ejecutar();
        objMenu.get(1).ejecutar();
        objMenu.get(2).ejecutar();
    }
}

//Receptor
public class Receptor
{
    public Receptor() {
    }
    // -----------------------
     public void accion( String accion )
    {
        if( accion.compareTo("ABRIR") == 0 ) {
            System.out.println("Abrir documento");
        } else if( accion.compareTo("IMPRIMIR") == 0 ) {
            System.out.println("Imprimir documento");
        } else if( accion.compareTo("SALIR") == 0 ) {
            System.out.println("Salir del programa");
        } else {
            System.out.println("Opción no válida");
        }
    }
}

//Invocador

import java.util.ArrayList;
public class Menu
{
     private ArrayList<IMenuItem> aMenu = new ArrayList<IMenuItem>();
    // --------------------------
    public Menu() {
    }
    // --------------------------
    public void add( IMenuItem objMenuItem )
    {
        this.aMenu.add( objMenuItem );
    }
    // --------------------------
    public IMenuItem get( int nOpcion )
    {
        return this.aMenu.get( nOpcion );
    }
}

//Command

public interface IMenuItem {
     public void ejecutar();
}


//Dos concrete commands

public class MenuItemAbrir implements IMenuItem
{
     Receptor r;
    // --------------------------
    public MenuItemAbrir( Receptor r ) {
        this.r = r;
    }
    // --------------------------
    @Override
     public void ejecutar() {
         r.accion("ABRIR");
    }
}

public class MenuItemImprimir implements IMenuItem
{
     Receptor r;
    // --------------------------
    public MenuItemImprimir( Receptor r ) {
        this.r = r;
    }
    // --------------------------
    @Override
     public void ejecutar() {
         r.accion("IMPRIMIR");
    }
}

public class MenuItemSalir implements IMenuItem
{
     Receptor r;
    // --------------------------
    public MenuItemSalir( Receptor r ) {
        this.r = r;
    }
    // --------------------------
    @Override
     public void ejecutar() {
         r.accion("SALIR");
    }
}
