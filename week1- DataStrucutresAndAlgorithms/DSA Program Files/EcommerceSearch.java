package DataStructureAndAlgorthms;


import java.util.*;

public class EcommerceSearch {

    static class Product {
        String productId;
        String productName;
        String category;

        Product(String productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        public String toString() {
            return productId + " | " + productName + " | " + category;
        }
    }

    static class SearchEngine {
        Product[] products;

        SearchEngine(Product[] products) {
            this.products = products;
        }

        Product linearSearch(String name) {
            for (Product p : products) {
                if (p.productName.equalsIgnoreCase(name)) {
                    return p;
                }
            }
            return null;
        }

        Product binarySearch(String name) {
            Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));
            int left = 0, right = products.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                int cmp = products[mid].productName.compareToIgnoreCase(name);
                if (cmp == 0) return products[mid];
                else if (cmp < 0) left = mid + 1;
                else right = mid - 1;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Product[] productList = {
            new Product("Item 1", "Laptop", "Electronics"),
            new Product("Item 2", "Shampoo", "Personal Care"),
            new Product("Item 3", "T-Shirt", "Clothing"),
            new Product("Item 4", "Book", "Stationery"),
            new Product("Item 5", "Phone", "Electronics")
        };

        SearchEngine searchEngine = new SearchEngine(productList);

        Product result1 = searchEngine.linearSearch("T-Shirt");
        System.out.println("Linear Search Result: " + (result1 != null ? result1 : "Not Found"));

        Product result2 = searchEngine.binarySearch("Phone");
        System.out.println("Binary Search Result: " + (result2 != null ? result2 : "Not Found"));
    }
}
