import java.util.ArrayList;

public class Conjunto<T> implements IConjunto<T> {
    private ArrayList<T> datos;
    private boolean permiteRepetidos;

    public Conjunto() {
        this.datos = new ArrayList<>();
        this.permiteRepetidos = false;
    }

    public Conjunto(boolean permiteRepetidos) {
        this.datos = new ArrayList<>();
        this.permiteRepetidos = permiteRepetidos;
    }

    @Override
    public boolean alta(T elemento) {
        if (elemento == null) {
            return false;
        }
        if (!permiteRepetidos && busqueda(elemento) != -1) {
            return false;
        }
        datos.add(elemento);
        return true;
    }

    @Override
    public boolean baja(T elemento) {
        int pos = busqueda(elemento);
        if (pos != -1) {
            datos.remove(pos);
            return true;
        }
        return false;
    }

    @Override
    public int busqueda(T elemento) {
        for (int i = 0; i < datos.size(); i++) {
            if (datos.get(i).equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Conjunto<T> union(Conjunto<T> otro) {
        Conjunto<T> res = new Conjunto<>(true);
        for (int i = 0; i < this.datos.size(); i++) {
            res.alta(this.datos.get(i));
        }
        for (int i = 0; i < otro.datos.size(); i++) {
            res.alta(otro.datos.get(i));
        }
        return res;
    }

    @Override
    public Conjunto<T> unionDistinct(Conjunto<T> otro) {
        Conjunto<T> res = new Conjunto<>(false);
        for (int i = 0; i < this.datos.size(); i++) {
            res.alta(this.datos.get(i));
        }
        for (int i = 0; i < otro.datos.size(); i++) {
            res.alta(otro.datos.get(i));
        }
        return res;
    }

    @Override
    public Conjunto<T> interseccion(Conjunto<T> otro) {
        Conjunto<T> res = new Conjunto<>(false);
        for (int i = 0; i < this.datos.size(); i++) {
            T actual = this.datos.get(i);
            if (otro.busqueda(actual) != -1) {
                res.alta(actual);
            }
        }
        return res;
    }

    @Override
    public Conjunto<T> diferencia(Conjunto<T> otro) {
        Conjunto<T> res = new Conjunto<>(false);
        for (int i = 0; i < this.datos.size(); i++) {
            T actual = this.datos.get(i);
            if (otro.busqueda(actual) == -1) {
                res.alta(actual);
            }
        }
        return res;
    }

    @Override
    public Conjunto<Par<T, T>> productoCartesiano(Conjunto<T> otro) {
        Conjunto<Par<T, T>> res = new Conjunto<>(false);
        for (int i = 0; i < this.datos.size(); i++) {
            for (int j = 0; j < otro.datos.size(); j++) {
                res.alta(new Par<>(this.datos.get(i), otro.datos.get(j)));
            }
        }
        return res;
    }

    @Override
    public Conjunto<Par<T, T>> productoNatural(Conjunto<T> otro) {
        Conjunto<Par<T, T>> res = new Conjunto<>(false);
        for (int i = 0; i < this.datos.size(); i++) {
            for (int j = 0; j < otro.datos.size(); j++) {
                if (this.datos.get(i).equals(otro.datos.get(j))) {
                    res.alta(new Par<>(this.datos.get(i), otro.datos.get(j)));
                }
            }
        }
        return res;
    }

    @Override
    public String toString() {
        String texto = "{ ";
        for (int i = 0; i < datos.size(); i++) {
            texto += datos.get(i);
            if (i < datos.size() - 1) {
                texto += ", ";
            }
        }
        texto += " }";
        return texto;
    }
}