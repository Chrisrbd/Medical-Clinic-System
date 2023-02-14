public class GroceryItemOrder {
    private int quantity;
    private double pricePerUnit;
    protected String name;
    public GroceryItemOrder(String name, int quantity, double pricePerUnit) {
      this.quantity = quantity;
      this.pricePerUnit = pricePerUnit;
    }
  
    public double getCost() {
      return quantity * pricePerUnit;
    }
  
    public void setQuantity(int quantity) {
      this.quantity = quantity;
    }
  }
  