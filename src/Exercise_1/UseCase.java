package Exercise_1;

import java.util.List;

/**
 * Created by LuckyP on 29.09.17.
 */
public class UseCase {

    public String id;
    public List<ClassDescription> realLinkedClassDesciprtions;

    public UseCase(String id, List<ClassDescription> realLinkedClassDesciprtions) {
        this.id = id;
        this.realLinkedClassDesciprtions = realLinkedClassDesciprtions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ClassDescription> getRealLinkedClassDesciprtions() {
        return realLinkedClassDesciprtions;
    }

    public void setRealLinkedClassDesciprtions(List<ClassDescription> realLinkedClassDesciprtions) {
        this.realLinkedClassDesciprtions = realLinkedClassDesciprtions;
    }

    @Override
    public String toString() {
        return "UseCase{" +
                "id='" + id + '\'' +
                ", realLinkedClassDesciprtions=" + realLinkedClassDesciprtions +
                '}';
    }
}
