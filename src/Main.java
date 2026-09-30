public class Main {
    public static void main(String[] args) {
        Conjunto<Integer> conjA = new Conjunto<>();
        Conjunto<Integer> conjB = new Conjunto<>();

        // Prueba de Alta
        System.out.println("--- 1. Alta de elementos ---");
        conjA.alta(10);
        conjA.alta(20);
        conjA.alta(30);
        conjA.alta(40);

        conjB.alta(30);
        conjB.alta(40);
        conjB.alta(50);
        conjB.alta(60);

        System.out.println("Conjunto A: " + conjA);
        System.out.println("Conjunto B: " + conjB);

        // Prueba de Busqueda
        System.out.println("\n--- 2. Busqueda ---");
        System.out.println("Posicion del 30 en A: " + conjA.busqueda(30));
        System.out.println("Posicion del 90 en A: " + conjA.busqueda(90));

        // Prueba de Baja
        System.out.println("\n--- 3. Baja de elementos ---");
        conjA.baja(10);
        System.out.println("Conjunto A luego de eliminar el 10: " + conjA);
        conjA.alta(10); // lo volvemos a agregar

        // Operaciones de conjunto
        System.out.println("\n--- 4. Union y Union Distinct ---");
        System.out.println("Union: " + conjA.union(conjB));
        System.out.println("Union Distinct: " + conjA.unionDistinct(conjB));

        System.out.println("\n--- 5. Interseccion ---");
        System.out.println("Interseccion A y B: " + conjA.interseccion(conjB));

        System.out.println("\n--- 6. Diferencia ---");
        System.out.println("Diferencia A - B: " + conjA.diferencia(conjB));
        System.out.println("Diferencia B - A: " + conjB.diferencia(conjA));

        System.out.println("\n--- 7. Producto Cartesiano ---");
        System.out.println("A x B: " + conjA.productoCartesiano(conjB));

        System.out.println("\n--- 8. Producto Natural ---");
        System.out.println("Producto Natural A y B: " + conjA.productoNatural(conjB));
    }
}