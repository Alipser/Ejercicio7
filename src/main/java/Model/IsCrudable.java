package Model;

import java.util.List;

public interface IsCrudable {
    public List<Object> getAll();

    public Object getbyId(int id);

    public  Object insert(Object objeto);

    public Boolean update(Object objeto);

    public Boolean delete(Object delete);

}
