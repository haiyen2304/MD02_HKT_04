package ra.service;

import ra.business.design.entity.Catalog;

import java.util.ArrayList;
import java.util.List;

public class CatalogService implements IGenericService<Catalog,Integer> {
    public static List<Catalog> catalogs=new ArrayList<Catalog>();
    static {
        catalogs.add(new Catalog(1,"Hoa","dep"));
        catalogs.add(new Catalog(2,"Qua","Ngon"));
        catalogs.add(new Catalog(3,"Banh","Ngot"));
    }
    @Override
    public List<Catalog> getAll() {
        return catalogs;
    }

    @Override
    public void save(Catalog c) {
        int indexCheck=findById(c.getCatalogId());
        if(indexCheck==-1){
            catalogs.add(c);
        }else {
            catalogs.set(indexCheck,c);
        }
    }

    @Override
    public int findById(Integer id) {
        return catalogs.stream()
                .map(Catalog::getCatalogId)
                .toList()
                .indexOf(id);
    }

    @Override
    public void delete(Integer index) {
        catalogs.remove(index.intValue());

    }
}
