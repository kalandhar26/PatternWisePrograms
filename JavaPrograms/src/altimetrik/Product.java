package altimetrik;

public class Product {

    public Product(String name, String category, int salesUnit, double costPerUnit) {
        this.name = name;
        this.category = category;
        this.salesUnit = salesUnit;
        this.costPerUnit = costPerUnit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSalesUnit() {
        return salesUnit;
    }

    public void setSalesUnit(int salesUnit) {
        this.salesUnit = salesUnit;
    }

    public double getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(double costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    private String name;

    private String category;

    private  int salesUnit;

    private double costPerUnit;

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", salesUnit=" + salesUnit +
                ", costPerUnit=" + costPerUnit +
                '}';
    }
}
