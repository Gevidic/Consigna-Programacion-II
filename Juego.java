public class Juego
{

    public enum Categoria
    {

        ROMPECABEZAS,


        DEPORTE,


        ACCION
    }


    private String nombre;


    private Categoria categoria;


    private int precio;


    private int tamanio;



    private int cantidadLicencias;


    private int cantidadVendidas;




    public Juego( String pNombre, Categoria pCategoria, int pPrecio, int pTamanio, int pCantidadLicencias)
    {
        nombre = pNombre;
        categoria = pCategoria;
        precio = pPrecio;
        tamanio = pTamanio;
        cantidadLicencias = pCantidadLicencias;
        cantidadVendidas = 0;
    }


    public String darNombre( )
    {
        return nombre;
    }


    public Categoria darCategoria( )
    {
        return categoria;
    }


    public int darPrecio( )
    {
        return precio;
    }


    public int darTamanio( )
    {
        return tamanio;
    }


    public int darCantidadLicencias( )
    {
        return cantidadLicencias;
    }


    public int darCantidadVendidas( )
    {
        return cantidadVendidas;
    }


    public void comprarLicencias( int pCantidad )
    {
        cantidadLicencias += pCantidad;
    }


    public boolean venderLicencias( int pCantidad )
    {
        boolean respuesta = false;
        if( cantidadLicencias >= pCantidad )
        {
            cantidadLicencias -= pCantidad;
            cantidadVendidas += pCantidad;
            respuesta = true;
        }
        return respuesta;
    }
}
