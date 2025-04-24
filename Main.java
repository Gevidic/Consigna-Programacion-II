import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AppStore appStore = new AppStore();
        int opcion;

        do {
            System.out.println("\n--- MENÚ APPSTORE ---");
            System.out.println("1. Ver información de los juegos");
            System.out.println("2. Comprar licencias de un juego");
            System.out.println("3. Vender licencias de un juego");
            System.out.println("4. Consultar el juego más vendido");
            System.out.println("5. Calcular descuento por volumen de venta");
            System.out.println("6. Evaluar compras por política porcentaje");
            System.out.println("7. Evaluar compras por política categoría");
            System.out.println("8. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    mostrarInfoJuego(appStore.darJuego1());
                    mostrarInfoJuego(appStore.darJuego2());
                    mostrarInfoJuego(appStore.darJuego3());
                    mostrarInfoJuego(appStore.darJuego4());
                    break;

                case 2:
                    System.out.print("Nombre del juego a comprar: ");
                    String nombreCompra = sc.nextLine();
                    System.out.print("Cantidad de licencias: ");
                    int cantidadCompra = sc.nextInt();
                    appStore.comprarLicenciasJuego(nombreCompra, cantidadCompra);
                    System.out.println("Compra realizada.");
                    break;

                case 3:
                    System.out.print("Nombre del juego a vender: ");
                    String nombreVenta = sc.nextLine();
                    System.out.print("Cantidad de licencias: ");
                    int cantidadVenta = sc.nextInt();
                    boolean vendido = appStore.venderLicenciasJuego(nombreVenta, cantidadVenta);
                    System.out.println(vendido ? "Venta realizada." : "No se pudo realizar la venta.");
                    break;

                case 4:
                    System.out.println("Juego más vendido: " + appStore.darJuegoMasVendido());
                    break;

                case 5:
                    System.out.print("Licencias a vender (juego1, juego2, juego3, juego4): ");
                    int c1 = sc.nextInt(), c2 = sc.nextInt(), c3 = sc.nextInt(), c4 = sc.nextInt();
                    System.out.println(appStore.calcularVentaPorVolumen(c1, c2, c3, c4));
                    break;

                case 6:
                    System.out.println(appStore.metodo1());
                    break;

                case 7:
                    System.out.println(appStore.metodo2());
                    break;

                case 8:
                    System.out.println("¡Gracias por usar la AppStore!");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 8);

        sc.close();
    }

    private static void mostrarInfoJuego(Juego juego) {
        System.out.println("\n--- Información del Juego ---");
        System.out.println("Nombre: " + juego.darNombre());
        System.out.println("Categoría: " + juego.darCategoria());
        System.out.println("Precio: $" + juego.darPrecio() + " USD");
        System.out.println("Tamaño: " + juego.darTamanio() + " KB");
        System.out.println("Licencias disponibles: " + juego.darCantidadLicencias());
        System.out.println("Licencias vendidas: " + juego.darCantidadVendidas());
    }
}
