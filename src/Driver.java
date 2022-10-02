import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Book[] bookList = new Book[10];
        for(int i=0; i<bookList.length;i++){
            bookList[i] = new Book(100000+i*3, i*2+1, "BookTitle"+i,
                    new Person("first"+i, "last"+i, "emailAddress"+i+"@abc.com"),
            i*5+10);
        }

        BookStore bookStore = new BookStore(bookList, 0);

        Scanner s = new Scanner(System.in);
        int is_exit = 0;
        while(is_exit != -1){
            System.out.print("\nPress 1 to display books" +
                    "\nPress 2 to print revenue" +
                    "\nPress 3 to add a book" +
                    "\nPress 4 to sell a book" +
                    "\nPress 5 to search for a book" +
                    "\nPress -1 to quit\n\n");

            int input = s.nextInt();

            switch (input){
                case -1:
                    is_exit = -1;
                    break;
                case 1:
                        bookStore.printBooks();
                    break;
                case 2:
                    bookStore.printRevenue();
                    break;
                case 3: {
                    if(bookStore.MAX_CAP == bookStore.getBookList().length)
                    {
                        System.out.println("Reached Max Capacity ("+ bookStore.MAX_CAP + ") of store");
                        break;
                    }

                    System.out.println("Enter author's first name, last name and email separated by spaces: ");
                    String authorFirst = s.next(), authorLast = s.next(), authorEmail = s.next();

                    System.out.println("Enter book title: ");
                    s.nextLine();
                    String bookTitle = s.nextLine();

                    System.out.println("Enter isbn, quantity and price separated by spaces: ");
                    int bookIsbn = s.nextInt(), bookQuantity = s.nextInt();
                    double bookPrice = s.nextDouble();

                    bookStore.addBook(new Book(bookIsbn, bookQuantity, bookTitle, new Person(authorFirst, authorLast, authorEmail),
                            bookPrice));
                    break;
                }
                case 4: {
                    System.out.println("Enter book's title: ");
                    String bookTitle = s.next();
                    int found = bookStore.searchBook(bookTitle);
                    if(found == -1){
                        System.out.println("Could not find book "+bookTitle+".");
                        break;
                    }
                    System.out.println("Enter quantity to sell: ");
                    int bookQuantity = s.nextInt();
                    bookStore.sellBook(bookTitle, bookQuantity);
                    break;
                }
                case 5: {
                    System.out.println("Enter book's title: ");
                    String bookTitle = s.next();
                    int rackNo = bookStore.searchBook(bookTitle);
                    if(rackNo != -1)
                        System.out.println("Found book at rack no."+rackNo);
                    else
                        System.out.println("No book found");
                    break;
                }
                default:
                    System.out.println("Could not recognize input");
            }

        }

        System.out.println("Exited...");
    }
}
