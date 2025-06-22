package DataStructureAndAlgorthms;

class Order {
    String id;
    String name;
    double price;

    Order(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    void show() {
        System.out.println(id + " - " + name + " - " + price);
    }
}

public class CustomerOrderSorting {

    static void bubble(Order[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].price < arr[j + 1].price) {
                    Order temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static void quick(Order[] arr, int l, int h) {
        if (l < h) {
            int p = part(arr, l, h);
            quick(arr, l, p - 1);
            quick(arr, p + 1, h);
        }
    }

    static int part(Order[] arr, int l, int h) {
        double piv = arr[h].price;
        int i = l - 1;
        for (int j = l; j < h; j++) {
            if (arr[j].price < piv) {
                i++;
                Order tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        Order tmp = arr[i + 1];
        arr[i + 1] = arr[h];
        arr[h] = tmp;
        return i + 1;
    }

    static void showList(Order[] arr) {
        for (Order o : arr) o.show();
    }

    public static void main(String[] args) {
        Order[] original = {
            new Order("O1", "Fyzal", 2000),
            new Order("O2", "Kiran", 1800),
            new Order("O3", "Fazil", 2500),
            new Order("O4", "Arun", 1600),
            new Order("O5", "Yokes", 2200)
        };

        Order[] bubbleList = original.clone();
        Order[] quickList = original.clone();

        System.out.println("Bubble Sort (Descending):");
        bubble(bubbleList);
        showList(bubbleList);

        System.out.println("\nQuick Sort (Ascending):");
        quick(quickList, 0, quickList.length - 1);
        showList(quickList);
    }
}
