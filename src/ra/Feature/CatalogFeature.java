package ra.Feature;


import ra.business.design.entity.Catalog;
import ra.business.design.entity.Product;
import ra.business.design.validate.CatalogValidate;
import ra.service.CatalogService;
import ra.service.IGenericService;
import ra.service.ProductService;
import ra.share.Share;

import java.util.Scanner;

public class CatalogFeature {
    public static CatalogService categoryService = new CatalogService();
    public static IGenericService<Product,String> productService = new ProductService();
    public static void addNewCategory(Scanner sc) {
        int number= Share.inputNumber(sc,"Enter your number: ","You must enter a number, please try again");
        for(int i=0;i<number;i++) {
            Catalog category = new Catalog();
            System.out.println("Add Catalog " + (i+1));
            category.inputData(sc);
            categoryService.save(category);
        }
        System.out.println("Add "+number +" success");
    }

    public static void displayAllCategory() {
        // Kiểm tra xem mảng cos rỗng hay không?
        if(CatalogService.catalogs.isEmpty()){
            System.err.println("List catalog is empty");
            return;
        }
        for(Catalog category : CatalogService.catalogs) {
            category.displayData();
        }
    }

    public static void UpdateNameCategoryById(Scanner sc) {
        // Kiểm tra xem mảng cos rỗng hay không?
        if(CatalogService.catalogs.isEmpty()){
            System.err.println("List catalog is empty");
            return;
        }

        int idUpdate= Share.inputNumber(sc,"Enter catagory id you want to change name: ","You must enter a number, please try again");
        int index = categoryService.findById(idUpdate);
        if( index!=-1){
            Catalog c= CatalogService.catalogs.get(index);
            String nameUpdate= CatalogValidate.inputCatalogName(sc);
            c.setCatalogName(nameUpdate);
            categoryService.save(c);
        }else {
            System.err.println("Category not found");
        }

//        String categoryNameUpdate="";
//        Category cUpdate = null;
//        for(Category c:CategoryService.catalogies) {
//            if(c!=null&& c.getcategoryName().equals(categoryNameUpdate)) {
//                cUpdate = c;
//            }
//        }
//        if(cUpdate!=null) {
//            String nameUpdate= CategoryValidate.inputCategoryName(sc);
//            cUpdate.setcategoryName(nameUpdate);
//            categoryService.addOrUpdate(cUpdate);
//        }else {
//            System.err.println("Category not found");
//        }
    }

    public static void deleteCategoryById(Scanner sc) {
        // Kiểm tra xem mảng cos rỗng hay không?
        if(CatalogService.catalogs.isEmpty()){
            System.err.println("List catalog is empty");
            return;
        }
        int idDelete=Share.inputNumber(sc,"Enter catagory id you want to delete: ","You must enter a number, please try again");

        int index = categoryService.findById(idDelete);
        if(index!=-1){
            boolean check=false;
            for(Product p : ProductService.products) {
                if(p.getCatalog().getCatalogId()==idDelete){
                    System.err.println("Cant delete category has products");
                    check=true;
                    break;
                }
            }
            if(!check){
                categoryService.delete(index);
                System.out.println("Delete success");
            }
        }else {
            System.err.println("Category not found");
        }
    }
}

