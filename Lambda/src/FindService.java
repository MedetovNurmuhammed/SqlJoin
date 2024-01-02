import java.util.List;
@FunctionalInterface
public interface FindService<T> {
    //маркерный интерфейс пусой болот

    T findbyid(List<T>list,Long id);
}
