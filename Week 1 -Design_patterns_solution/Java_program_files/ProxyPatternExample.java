package DesignPatterns;
public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("city.jpg");
        Image image2 = new ProxyImage("city.jpg");

        image1.display();
        image2.display();
    }
}

interface Image {
    void display();
}

class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        System.out.println("Loading image : " + filename);
    }

    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}
