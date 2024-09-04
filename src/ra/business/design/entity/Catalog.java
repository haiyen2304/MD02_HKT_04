package ra.business.design.entity;

import ra.business.design.validate.CatalogValidate;

import java.util.Scanner;

public class Catalog implements IModel{
    private static int count=1;
    private int catalogId;
    private String catalogName;
    private String description;
    public Catalog(){

    }
    public Catalog(int catalogId, String catalogName, String description) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.description = description;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Catalog.count = count;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void inputData(Scanner sc) {
        this.catalogId = count++;
        this.catalogName = CatalogValidate.inputCatalogName(sc);
        this.description=  CatalogValidate.inputCatalogDescription(sc);
    }
    @Override
    public void displayData() {
        System.out.println( "CatalogID: " +this.catalogId + "   |   CatalogName: "+this.catalogName +"\n"
                +"------------------------------------------------------------------");

    }
}
