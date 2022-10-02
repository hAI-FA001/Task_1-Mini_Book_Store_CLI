public class Book {
 private int isbn;
 private int quantity;
 private String title;
 private Person author;
 private double price;

    public Book(int isbn, int quantity, String title, Person author, double price) {
        this.isbn = isbn;
        this.quantity = quantity;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString(){
        return String.format("ISBN: %10d\nTitle: %15s\nAuthor: %10s\nPrice: %5.2f\tQuantity: %-7d",
                isbn, title, author, price, quantity);
    }

    public boolean equals(Object o){
        Book b = (Book)o;

        return this.isbn == b.isbn;
    }
}
