import java.util.Objects;

public class Par<A, B> {
    private A primero;
    private B segundo;

    public Par(A primero, B segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public A getPrimero() {
        return primero;
    }

    public B getSegundo() {
        return segundo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Par<?, ?> otro = (Par<?, ?>) obj;
        return Objects.equals(primero, otro.primero) &&
                Objects.equals(segundo, otro.segundo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primero, segundo);
    }

    @Override
    public String toString() {
        return "(" + primero + ", " + segundo + ")";
    }
}