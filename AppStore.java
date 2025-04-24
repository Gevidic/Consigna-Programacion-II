public class AppStore
{

    public final static int CANT_MIN_ROMPECABEZAS = 25;


    public final static int CANT_MIN_DEPORTE = 20;


    public final static int CANT_MIN_ACCION = 12;



    public final static double DESCUENTO_1 = 0.20;

    public final static double DESCUENTO_2 = 0.15;



    private Juego juego1;


    private Juego juego2;


    private Juego juego3;


    private Juego juego4;


    public AppStore( )
    {
        juego1 = new Juego( "Candy Crush", Juego.Categoria.ROMPECABEZAS, 3000, 300, 50 );
        juego2 = new Juego( "Flow", Juego.Categoria.ROMPECABEZAS, 5500, 250, 15 );
        juego3 = new Juego( "FIFA", Juego.Categoria.DEPORTE, 7500, 850, 80 );
        juego4 = new Juego( "Clash of Clans", Juego.Categoria.ACCION, 2000, 1000, 36 );
    }


    public Juego darJuego1( )
    {
        return juego1;
    }


    public Juego darJuego2( )
    {
        return juego2;
    }


    public Juego darJuego3( )
    {
        return juego3;
    }


    public Juego darJuego4( )
    {
        return juego4;
    }


    public Juego buscarJuego( String pNombreJuego )
    {
        Juego buscado = null;
        if( pNombreJuego.equals( juego1.darNombre( ) ) )
        {
            buscado = juego1;
        }
        else if( pNombreJuego.equals( juego2.darNombre( ) ) )
        {
            buscado = juego2;
        }
        else if( pNombreJuego.equals( juego3.darNombre( ) ) )
        {
            buscado = juego3;
        }
        else if( pNombreJuego.equals( juego4.darNombre( ) ) )
        {
            buscado = juego4;
        }

        return buscado;
    }


    public boolean venderLicenciasJuego( String pNombreJuego, int pCantidad )
    {
        boolean respuesta = false;
        if( buscarJuego( pNombreJuego ) != null )
        {
            respuesta = buscarJuego( pNombreJuego ).venderLicencias( pCantidad );
        }
        return respuesta;
    }


    public void comprarLicenciasJuego( String pNombreJuego, int pCantidad )
    {
        if( buscarJuego( pNombreJuego ) != null )
        {
            buscarJuego( pNombreJuego ).comprarLicencias( pCantidad );
        }
    }


    public String darJuegoMasVendido( )
    {
        String masVendido = "Ninguno";
        int cantidadMasVendida = 0;
        if( juego1.darCantidadVendidas( ) > cantidadMasVendida )
        {
            masVendido = juego1.darNombre( );
            cantidadMasVendida = juego1.darCantidadVendidas( );
        }
        if( juego2.darCantidadVendidas( ) > cantidadMasVendida )
        {
            masVendido = juego2.darNombre( );
            cantidadMasVendida = juego2.darCantidadVendidas( );
        }
        if( juego3.darCantidadVendidas( ) > cantidadMasVendida )
        {
            masVendido = juego3.darNombre( );
            cantidadMasVendida = juego3.darCantidadVendidas( );
        }
        if( juego4.darCantidadVendidas( ) > cantidadMasVendida )
        {
            masVendido = juego4.darNombre( );
            cantidadMasVendida = juego4.darCantidadVendidas( );
        }

        return masVendido;
    }


    public String calcularVentaPorVolumen( int pCantidadLicenciasJuego1, int pCantidadLicenciasJuego2, int pCantidadLicenciasJuego3, int pCantidadLicenciasJuego4 )
    {
        int cantRompecab = 0;
        int cantDeporte = 0;
        int cantAccion = 0;

        switch( juego1.darCategoria( ) )
        {
            case ROMPECABEZAS:
            {
                cantRompecab += pCantidadLicenciasJuego1;
                break;
            }
            case DEPORTE:
            {
                cantDeporte += pCantidadLicenciasJuego1;
                break;
            }
            case ACCION:
            {
                cantAccion += pCantidadLicenciasJuego1;
                break;
            }
        }
        switch( juego2.darCategoria( ) )
        {
            case ROMPECABEZAS:
            {
                cantRompecab += pCantidadLicenciasJuego2;
                break;
            }
            case DEPORTE:
            {
                cantDeporte += pCantidadLicenciasJuego2;
                break;
            }
            case ACCION:
            {
                cantAccion += pCantidadLicenciasJuego2;
                break;
            }
        }
        switch( juego3.darCategoria( ) )
        {
            case ROMPECABEZAS:
            {
                cantRompecab += pCantidadLicenciasJuego3;
                break;
            }
            case DEPORTE:
            {
                cantDeporte += pCantidadLicenciasJuego3;
                break;
            }
            case ACCION:
            {
                cantAccion += pCantidadLicenciasJuego3;
                break;
            }
        }
        switch( juego4.darCategoria( ) )
        {
            case ROMPECABEZAS:
            {
                cantRompecab += pCantidadLicenciasJuego4;
                break;
            }
            case DEPORTE:
            {
                cantDeporte += pCantidadLicenciasJuego4;
                break;
            }
            case ACCION:
            {
                cantAccion += pCantidadLicenciasJuego4;
                break;
            }
        }

        double totalVenta = ( juego1.darPrecio( ) * pCantidadLicenciasJuego1 ) + ( juego2.darPrecio( ) * pCantidadLicenciasJuego2 ) + ( juego3.darPrecio( ) * pCantidadLicenciasJuego3 ) + ( juego4.darPrecio( ) * pCantidadLicenciasJuego4 );
        double descuento = 0;

        if( cantRompecab >= CANT_MIN_ROMPECABEZAS )
        {
            descuento = totalVenta * DESCUENTO_1;
        }
        else if( cantDeporte >= CANT_MIN_DEPORTE && cantAccion >= CANT_MIN_ACCION )
        {
            descuento = totalVenta * DESCUENTO_2;
        }
        else
        {
            descuento = 0;
        }

        double totalConDescuento = totalVenta - descuento;

        String mensaje = "El precio total de la venta ser�a: $" + totalVenta + ".\n" + "El descuento ser�a de: $" + descuento + "\n" + "El precio con descuento ser�a: $" + totalConDescuento + ".";

        return mensaje;

    }


    public String metodo1( )
    {
        return "Respuesta 1";
    }


    public String metodo2( )
    {
        return "Respuesta 2";
    }
}
