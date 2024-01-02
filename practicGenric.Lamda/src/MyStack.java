import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {
    private List<T>list;


public T push(T a){
    if (list==null) list = new ArrayList<>();
        list.add(a);
    return a;
}

public T peek(){
    return null;
}
public void pop(List<T>list){
      T a =   list.getFirst();

    list.remove(a);
    System.out.println(list);
}
public Boolean isempty(){
    if (list==null) {return list.isEmpty();
    }


}

    @Override
    public String toString() {
        return "MyStack{" +
                "list=" + list +
                '}';
    }
}
