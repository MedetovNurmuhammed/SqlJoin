import java.util.List;

@FunctionalInterface
public interface Foreach<T> {
    void  foreach(List<T> t);
}
