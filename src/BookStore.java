public class BookStore {
    private Book[] bookList;
    public final int MAX_CAP = 500;
    private double revenue;

    public BookStore(Book[] bookList, double revenue){
        this.bookList = bookList;
        this.revenue = revenue;
    }

    public Book[] getBookList(){
        return bookList;
    }

    public double getRevenue() {
        return revenue;
    }

    public void addBook(Book book){
        if(bookList.length == MAX_CAP)
        {
            System.out.println("Reached max capacity of books");
            return;
        }

        int length = this.bookList.length;
        Book[] bookList = new Book[length+1];
        for(int i=0; i<this.bookList.length; i++){
            bookList[i] = this.bookList[i];
        }
        bookList[length] = book;
        this.bookList = bookList;
    }

    public int searchBook(String title){
        int rackNo = -1;

        for(int i=0; i<bookList.length; i++){
            if(bookList[i].getTitle().equals(title)) {
                rackNo = i;
                break;
            }
        }

        return rackNo;
    }

    public void sellBook(String title, int quantity){
        int rackNo = searchBook(title);

        if(rackNo != -1)
            if(bookList[rackNo].getQuantity() != 0)
                if(bookList[rackNo].getQuantity() >= quantity)
                    {
                        bookList[rackNo].setQuantity(bookList[rackNo].getQuantity()-quantity);
                        revenue += (bookList[rackNo].getPrice()*quantity);
                        System.out.println("Sold "+quantity+" books.");
                    }
                else System.out.println("Not enough books. Only "+bookList[rackNo].getQuantity()+" are available.");
            else System.out.println("Book " + title + " is not available.");
        else System.out.println("Could not find book with title "+title);
    }

    public void printBooks(){

        for(int i=0; i<bookList.length; i++){
            System.out.println(bookList[i]);
            System.out.println("=========================================");
        }
    }

    public void printRevenue(){
        System.out.println("Current Total Revenue: " +String.format("%-10.2f", revenue));
    }

}
