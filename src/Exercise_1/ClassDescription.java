package Exercise_1;

import java.util.List;

/**
 * Created by LuckyP on 29.09.17.
 */
public class ClassDescription {

    public String id;

    public ClassDescription(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ClassDescription{" +
                "id='" + id + '\'' +
                '}';
    }
}
