import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        System.out.println("Loading Books from File.");
        library.loadBooksFromFile("Books.txt");

        while(true)
        {
            int choice = 0;
            System.out.println("\n-------Main Menu--------\n");
            System.out.println("1.Add Books");
            System.out.println("2.Search Books");
            System.out.println("3.Remove Books");
            System.out.println("4.Update Book");
            System.out.println("5.Show Books");
            System.out.println("6.Exit");
            System.out.println("\nEnter your Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            if(choice == 1)
            {
                String title = "";
                String author = "";
                float price = 0F;
                int quantity = 0;
                System.out.println("Enter Book Title: ");
                title = scanner.nextLine();
                System.out.println("Enter Author Name: ");
                author = scanner.nextLine();
                System.out.println("Enter the Price: ");
                price = scanner.nextFloat();
                System.out.println("Enter the Quantity: ");
                quantity = scanner.nextInt();
                scanner.nextLine();
                Book newBook = new Book();
                newBook.setTitle(title);
                newBook.setAuthor(author);
                newBook.setPrice(price);
                newBook.setQuantity(quantity);
                library.addBooks(newBook);
            }
            else if(choice == 2)
            {
                library.searchBooks();
            }
            else if(choice == 3)
            {
                String title = "";
                System.out.println("Enter Book Title: ");
                title = scanner.nextLine();
                library.removeBook(title);
            }
            else if (choice == 4)
            {
                String title = "";
                System.out.println("Enter Book Title: ");
                title = scanner.nextLine();
                String author = "";
                System.out.println("Enter Book Author: ");
                author = scanner.nextLine();
                library.updateBookDetails(title,author);
            }
            else if(choice == 5)
            {
                library.ShowBooks();
            }
            else if (choice == 6)
            {
                scanner.close();
                library.saveBooksToFile("Books.txt");
                System.out.println("File Saved Successfully.");
                System.out.println("\nGOOD BYE!");
                break;
            }
            else
            {
                System.out.println("INVALID INPUT!");
            }
        }
    }
}

class Book{
    private String Title = "";
    private String Author = "";
    private float Price = 0F;
    private int Quantity = 0;


    public void setTitle(String title)
    {
        Title = title;
    }
    public void setAuthor(String author)
    {
        Author = author;
    }
    public void setPrice(float price)
    {
        Price = price;
    }
    public void setQuantity(int quantity)
    {
        Quantity = quantity;
    }

    public String getTitle()
    {
        return Title;
    }
    public String getAuthor()
    {
        return Author;
    }
    public float getPrice()
    {
        return Price;
    }
    public int getQuantity()
    {
        return Quantity;
    }

}

class Library
{
    private List <Book> Books = new ArrayList<>();

    public void addBooks(Book newBook) {
        Books.add(newBook);
        System.out.println("New Book Added Successfully.");
    }

    public void updateBookDetails(String title, String author)
    {
        Scanner scanner = new Scanner(System.in);
        for(Book it : Books)
        {
            if(Objects.equals(it.getTitle(), title) && Objects.equals(it.getAuthor(), author))
            {
                int choice = 0;
                System.out.println("\n1.Update Title\n2.Update Author\n3.Update Price\n4.Update Quantity\nEnter Your Choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();
                if(choice == 1)
                {
                    String Title = "";
                    System.out.println("Enter a New Title: ");
                    Title = scanner.nextLine();
                    it.setTitle(Title);
                    System.out.println("Title Updated Successfully.");
                }
                else if(choice == 2)
                {
                    String Author = "";
                    System.out.println("Enter a New Author name: ");
                    Author = scanner.nextLine();
                    it.setAuthor(Author);
                    System.out.println("Author Updated Successfully.");
                }
                else if (choice == 3)
                {
                    float newPrice = 0F;
                    System.out.println("Enter new Price: ");
                    newPrice = scanner.nextFloat();
                    it.setPrice(newPrice);
                    System.out.println("Price Updated Successfully.");
                }
                else if(choice == 4)
                {
                    int newQuantity = 0;
                    System.out.println("Enter new Quantity: ");
                    newQuantity = scanner.nextInt();
                    it.setQuantity(newQuantity);
                    System.out.println("Quantity Updated Successfully.");
                }
                else
                {
                    System.out.println("Invalid Input");
                }
            }
        }

    }
    public void ShowBooks()
    {
        int count = 1;
        for(Book it : Books)
        {
            System.out.println("---------Book " + count +"----------");
            System.out.println("Title: " + it.getTitle());
            System.out.println("Author: " + it.getAuthor());
            System.out.println("Price: " + it.getPrice());
            System.out.println("Quantity: " + it.getQuantity());
            System.out.println("\n\n");
            count++;
        }
    }

    public void searchBooks()
    {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        System.out.println("1.Search by Title\n2.Search by Author\n\nEnter your Choice: ");
        choice = scanner.nextInt();
        scanner.nextLine();
        if(choice == 1)
        {
            String title = "";
            System.out.println("Enter the Title of the Book: ");
            title = scanner.nextLine();
            for(Book it : Books)
            {
                if(Objects.equals(it.getTitle(), title))
                {
                    System.out.println("Book Title: " + it.getTitle());
                    System.out.println("Author: " + it.getAuthor());
                    System.out.println("Price: " + it.getPrice());
                    System.out.println("Quantity: " + it.getQuantity());
                    System.out.println("\n\n");
                    return;
                }
            }
            System.out.println("Book not Found!");
        }
        else if (choice == 2)
        {
            String author = "";
            System.out.println("Enter the Author of the Book: ");
            author = scanner.nextLine();
            for(Book it : Books)
            {
                if(Objects.equals(it.getAuthor(), author))
                {
                    System.out.println("Book Title: " + it.getTitle());
                    System.out.println("Author: " + it.getAuthor());
                    System.out.println("Price: " + it.getPrice());
                    System.out.println("Quantity: " + it.getQuantity());
                    System.out.println("\n\n");
                }
            }
        }
        else
        {
            System.out.println("Invalid Input!");
        }

    }

    public void removeBook(String title)
    {
        if(Books.removeIf(it -> Objects.equals(it.getTitle(), title)))
        {
            System.out.println("Book removed Successfully.");
        }
        else
        {
            System.out.println("Book not Found!");
        }
    }

    public void saveBooksToFile(String fileName)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName)))
        {
            for (Book book : Books)
            {
                writer.write(book.getTitle() + "," + book.getAuthor() + "," + book.getPrice() + "," + book.getQuantity() + "\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void loadBooksFromFile(String fileName)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    Book book = new Book();
                    book.setTitle(parts[0]);
                    book.setAuthor(parts[1]);
                    book.setPrice(Float.parseFloat(parts[2]));
                    book.setQuantity(Integer.parseInt(parts[3]));
                    Books.add(book);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}