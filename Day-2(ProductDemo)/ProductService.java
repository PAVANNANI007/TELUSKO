import java.util.ArrayList;
import java.util.List;

public class ProductService {

  List<Product> products = new ArrayList<>();

  public void addProduct(Product p) {
    products.add(p);
  }

  public List<Product> getAllProducts() {
    return products;
  }

  public Product getProduct(String name) {
    for (Product p : products) {
      if (p.getName().equals(name))
        return p;
    }

    return null;
  }

  public List<Product> getProductWithText(String text) {
    String str = text.toLowerCase();
    List<Product> prods = new ArrayList<>();

    for (Product p : products) {
      String name = p.getName().toLowerCase();
      String type = p.getType().toLowerCase();
      String place = p.getPlace().toLowerCase();
      if (name.contains(str) || type.contains(str) || place.contains(str))
        prods.add(p);
    }
    return prods;

  }
}
// Assignment :

// 1. convert to stream api
// public List<Product> getProductWithText(String text) {
// String str = text.toLowerCase();

// return products.stream().filter(
// p->p.getName().toLowerCase().contains(str)||
// p.getType().toLowerCase().contains(str)||
// p.getPlace().toLowerCase().contains(str)
// ).collect(Collectors.toList());

// }

// 2. search by place
// public List<Product> getProductWithplace(String place) {
// return products.stream().filter(
// p-> p.getPlace().toLowerCase()equals(place.tolowercase())
// ).collect(Collectors.toList());

// }

// 3. search products out of warranty
// public List<Product> getProductWithoutWarranty() {
// int warrantyYear = Year.now().getValue();
// return products.stream().filter(
// p -> p.getWarranty() < warrantyYear)
// .collect(Collectors.toList());}
