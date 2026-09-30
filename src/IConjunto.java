public interface IConjunto<T> {
    boolean alta(T elemento);
    boolean baja(T elemento);
    int busqueda(T elemento);

    Conjunto<T> union(Conjunto<T> otro);
    Conjunto<T> unionDistinct(Conjunto<T> otro);
    Conjunto<T> interseccion(Conjunto<T> otro);
    Conjunto<T> diferencia(Conjunto<T> otro);
    Conjunto<Par<T, T>> productoCartesiano(Conjunto<T> otro);
    Conjunto<Par<T, T>> productoNatural(Conjunto<T> otro);
}