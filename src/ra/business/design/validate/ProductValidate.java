package ra.business.design.validate;

import ra.business.design.entity.Catalog;
import ra.business.design.entity.Product;
import ra.service.CatalogService;
import ra.service.ProductService;

import java.util.Scanner;

public class ProductValidate {

    public static String inputProductId(Scanner sc){
        String productId;
        while(true){
            System.out.println("Enter product id: ");
            productId = sc.nextLine().trim();
            boolean valid = productId.matches("^P\\d{4}$");
            if(valid){
                boolean check=false;
                for(Product p : ProductService.products){
                    if(p.getProductId().equals(productId)){
                        check = true;
                        break;
                    }
                }
                if (check){
                    System.err.println("ID had ,please enter a valid product ID");
                    continue;
                }
                return productId;
            }else {
                System.err.println("ID invalided : Pxxxx");
            }
        }
    }
    public static String inputProductName(Scanner sc){
        while (true){
            System.out.println("Enter product name: ");
            String productName = sc.nextLine().trim();
            if(productName.isEmpty()){
                System.err.println("Product name cannot be empty");
                continue;
            }
            if(ProductService.products.stream()
                    .map(Product::getProductName)
                    .anyMatch(productName::equalsIgnoreCase)){
                System.err.println("Product name had ,please enter a valid product name");
                continue;
            }
            return productName;
        }
    }
    public static Double inputProductPrice(Scanner sc){
        while(true){
            try{
                System.out.println("Enter product price: ");
                double productPrice= sc.nextDouble();
                if(productPrice <= 0){
                    System.err.println("Product price cannot be negative");
                    continue;
                }
                sc.nextLine();
                return productPrice;
            }catch(Exception e){
                System.err.println("Invalid price input");
                sc.nextLine();
            }
        }
    }

    public static String inputProductDescription(Scanner sc){
        while(true){
            System.out.println("Enter product description: ");
            String productDescription = sc.nextLine().trim();
            if(productDescription.isEmpty()){
                System.err.println("Product description cannot be empty");
                continue;
            }
            return productDescription;
        }
    }
    public static int inputProductStock(Scanner sc){
        while(true){
            try{
                System.out.println("Enter product stock: ");
                int productStock = sc.nextInt();
                if(productStock < 10){
                    System.err.println("Product stock cannot be negative,and >10");
                    continue;
                }
                return productStock;
            }catch(Exception e){
                System.err.println("Invalid stock input");
                sc.nextLine();
            }
        }
    }

    //check ở feature xem có danh sách k, mới tạo sản phẩm
    public static Catalog inputCatalog(Scanner sc){
        System.out.println("List Category : ");
        for (Catalog c: CatalogService.catalogs){
            System.out.println("ID : "+c.getCatalogId()+" NameCategory : "+c.getCatalogName());
        }
        while(true){
            try {
                System.out.println("Enter product category: ");
                int categoryId = sc.nextInt();
                if(CatalogService.catalogs.stream()
                        .map(Catalog::getCatalogId)
                        .noneMatch(e->e == categoryId)){
                    System.err.println("The ID you entered does not exist");
                    continue;
                }
                return CatalogService.catalogs.stream().filter(e->e.getCatalogId()==categoryId).findFirst().orElse(null);
            }catch (Exception e) {
                System.err.println("Invalid category input");
                sc.nextLine();
            }
        }
    }

    public static Boolean inputProductStatus(Scanner sc){
        while(true){
            try{
                System.out.println("Enter product status: ");
                boolean inputStatus= sc.nextBoolean();
                sc.nextLine();
                return inputStatus;

            }catch (Exception e){
                System.err.println("Invalid product status");
                sc.nextLine();
            }
        }
    }
}
