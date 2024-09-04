package ra.service;

import ra.business.design.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IGenericService<Product,String> {
    public static   List<Product> products=new ArrayList<Product>();
    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public void save(Product pro) {
        int indexCheck=findById(pro.getProductId());
        if(indexCheck==-1){
            products.add(pro);
        }else {
            products.set(indexCheck, pro);
        }

    }

    @Override
    public int findById(String id) {
        return products.stream()
                .map(Product::getProductId)
                .toList()
                .indexOf(id);
    }

    @Override
    public void delete(String id) {
        products.remove(findById(id));

    }
}
