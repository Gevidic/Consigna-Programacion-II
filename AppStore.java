public class AppStore {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    public final static int CANT_MIN_ROMPECABEZAS = 25;
    public final static int CANT_MIN_DEPORTE = 20;
    public final static int CANT_MIN_ACCION = 12;
    public final static double DESCUENTO_1 = 0.20;
    public final static double DESCUENTO_2 = 0.15;

    // Nuevas constantes
    public final static double PORCENTAJE_MINIMO = 0.25;
    public final static int LICENCIAS_MINIMAS_DEPORTE = 10;
    public final static int LICENCIAS_MINIMAS_ACCION = 15;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    private Juego juego1;
    private Juego juego2;
    private Juego juego3;
    private Juego juego4;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    public AppStore() {
        juego1 = new Juego("Candy Crush", Juego.Categoria.ROMPECABEZAS, 3000, 300, 50);
        juego2 = new Juego("Flow", Juego.Categoria.ROMPECABEZAS, 5500, 250, 15);
        juego3 = new Juego("FIFA", Juego.Categoria.DEPORTE, 7500, 850, 80);
        juego4 = new Juego("Clash of Clans", Juego.Categoria.ACCION, 2000, 1000, 36);
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    public Juego darJuego1() { return juego1; }
    public Juego darJuego2() { return juego2; }
    public Juego darJuego3() { return juego3; }
    public Juego darJuego4() { return juego4; }

    public Juego buscarJuego(String pNombreJuego) {
        if (pNombreJuego.equals(juego1.darNombre())) return juego1;
        else if (pNombreJuego.equals(juego2.darNombre())) return juego2;
        else if (pNombreJuego.equals(juego3.darNombre())) return juego3;
        else if (pNombreJuego.equals(juego4.darNombre())) return juego4;
        else return null;
    }

    public boolean venderLicenciasJuego(String pNombreJuego, int pCantidad) {
        Juego juego = buscarJuego(pNombreJuego);
        return juego != null && juego.venderLicencias(pCantidad);
    }

    public void comprarLicenciasJuego(String pNombreJuego, int pCantidad) {
        Juego juego = buscarJuego(pNombreJuego);
        if (juego != null) juego.comprarLicencias(pCantidad);
    }

    public String darJuegoMasVendido() {
        String masVendido = "Ninguno";
        int cantidadMasVendida = 0;

        if (juego1.darCantidadVendidas() > cantidadMasVendida) {
            masVendido = juego1.darNombre();
            cantidadMasVendida = juego1.darCantidadVendidas();
        }
        if (juego2.darCantidadVendidas() > cantidadMasVendida) {
            masVendido = juego2.darNombre();
            cantidadMasVendida = juego2.darCantidadVendidas();
        }
        if (juego3.darCantidadVendidas() > cantidadMasVendida) {
            masVendido = juego3.darNombre();
            cantidadMasVendida = juego3.darCantidadVendidas();
        }
        if (juego4.darCantidadVendidas() > cantidadMasVendida) {
            masVendido = juego4.darNombre();
            cantidadMasVendida = juego4.darCantidadVendidas();
        }

        return masVendido;
    }

    public String calcularVentaPorVolumen(int p1, int p2, int p3, int p4) {
        int cantRompecab = 0, cantDeporte = 0, cantAccion = 0;

        Juego[] juegos = {juego1, juego2, juego3, juego4};
        int[] cantidades = {p1, p2, p3, p4};

        for (int i = 0; i < juegos.length; i++) {
            switch (juegos[i].darCategoria()) {
                case ROMPECABEZAS: cantRompecab += cantidades[i]; break;
                case DEPORTE: cantDeporte += cantidades[i]; break;
                case ACCION: cantAccion += cantidades[i]; break;
            }
        }

        double totalVenta = juego1.darPrecio() * p1 + juego2.darPrecio() * p2 + juego3.darPrecio() * p3 + juego4.darPrecio() * p4;
        double descuento = 0;

        if (cantRompecab >= CANT_MIN_ROMPECABEZAS)
            descuento = totalVenta * DESCUENTO_1;
        else if (cantDeporte >= CANT_MIN_DEPORTE && cantAccion >= CANT_MIN_ACCION)
            descuento = totalVenta * DESCUENTO_2;

        double totalConDescuento = totalVenta - descuento;

        return "El precio total de la venta sería: $" + totalVenta + ".\n" +
                "El descuento sería de: $" + descuento + "\n" +
                "El precio con descuento sería: $" + totalConDescuento + ".";
    }

    public String darJuegoMenosVendido() {
        int min = juego1.darCantidadVendidas();
        String nombre = juego1.darNombre();

        int[] vendidas = {juego1.darCantidadVendidas(), juego2.darCantidadVendidas(), juego3.darCantidadVendidas(), juego4.darCantidadVendidas()};

        if (vendidas[1] < min) { min = vendidas[1]; nombre = juego2.darNombre(); }
        if (vendidas[2] < min) { min = vendidas[2]; nombre = juego3.darNombre(); }
        if (vendidas[3] < min) { min = vendidas[3]; nombre = juego4.darNombre(); }

        int iguales = 0;
        for (int v : vendidas) {
            if (v == min) iguales++;
        }

        return iguales == 4 ? "NINGUNO" : nombre;
    }

    public String darComprasPorPorcentaje() {
        String menosVendido = darJuegoMenosVendido();
        if (menosVendido.equals("NINGUNO")) return "NINGUNO";

        Juego ref = buscarJuego(menosVendido);
        int umbral = (int)(ref.darCantidadLicencias() * PORCENTAJE_MINIMO);
        String resultado = "";

        if (juego1.darCantidadLicencias() < umbral) resultado += juego1.darNombre() + ", ";
        if (juego2.darCantidadLicencias() < umbral) resultado += juego2.darNombre() + ", ";
        if (juego3.darCantidadLicencias() < umbral) resultado += juego3.darNombre() + ", ";
        if (juego4.darCantidadLicencias() < umbral) resultado += juego4.darNombre() + ", ";

        return resultado.isEmpty() ? "NINGUNO" : resultado.substring(0, resultado.length() - 2);
    }

    public String metodo1() {
        return "Juegos que deben comprarse por política de porcentaje: " + darComprasPorPorcentaje();
    }

    public boolean seDebeComprarPorCategoria(String nombreJuego) {
        Juego juego = buscarJuego(nombreJuego);
        if (juego == null) return false;

        switch (juego.darCategoria()) {
            case DEPORTE:
            case ROMPECABEZAS:
                return juego.darCantidadLicencias() < LICENCIAS_MINIMAS_DEPORTE;
            case ACCION:
                return juego.darCantidadLicencias() < LICENCIAS_MINIMAS_ACCION;
            default:
                return false;
        }
    }

    public String metodo2() {
        String juegos = "";

        if (seDebeComprarPorCategoria(juego1.darNombre())) juegos += juego1.darNombre() + ", ";
        if (seDebeComprarPorCategoria(juego2.darNombre())) juegos += juego2.darNombre() + ", ";
        if (seDebeComprarPorCategoria(juego3.darNombre())) juegos += juego3.darNombre() + ", ";
        if (seDebeComprarPorCategoria(juego4.darNombre())) juegos += juego4.darNombre() + ", ";

        return juegos.isEmpty() ? "NINGUNO" : "Juegos a comprar por política de categoría: " + juegos.substring(0, juegos.length() - 2);
    }
}
