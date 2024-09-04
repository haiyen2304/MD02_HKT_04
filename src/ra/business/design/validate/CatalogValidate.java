package ra.business.design.validate;

import ra.business.design.entity.Catalog;
import ra.service.CatalogService;

import java.util.Scanner;

public class CatalogValidate {
    public static  String inputCatalogName(Scanner sc) {
        while (true) {
            System.out.println("Enter Catalog Name: ");
            String catalogName = sc.nextLine().trim();
            if(catalogName.isEmpty()){
                System.out.println("Catalog Name is Empty");
                continue;
            }
            if(CatalogService.catalogs.stream()
                    .map(Catalog::getCatalogName)
                    .anyMatch(catalogName::equalsIgnoreCase)){
                System.out.println("Catalog Name Already Exists");
                continue;
            }
            return catalogName;
        }
    }
    public static  String inputCatalogDescription(Scanner sc) {
        while (true){
            System.out.println("Enter catalog Description");
            String catalogDescription = sc.nextLine().trim();
            if(catalogDescription.isBlank()){
                System.out.println("Catalog Description cannot be blank");
                continue;
            }
            return catalogDescription;
        }
    }

}
