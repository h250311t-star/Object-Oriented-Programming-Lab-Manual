/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.librarystarter;

/**
 *
 * @author Windows 10 Pro
 */

import java.util.*;
import java.time.LocalDate;
import java.io.*;

// Custom exception for unavailable items
class ItemNotAvailableException extends RuntimeException {
    ItemNotAvailableException(String message) {
        super(message);
    }
}

// Custom exception for the three-loan limit
class MemberLimitExceededException extends RuntimeException {
    MemberLimitExceededException(String message) {
        super(message);
    }
}

// Abstract parent class
abstract class LibraryItem {
    private final String id;
    private final String title;
    private boolean available = true;

    LibraryItem(String id, String title) {
        if (id == null || id.isBlank() ||
            title == null || title.isBlank() ||
            id.contains(",") || title.contains(",")) {
            throw new IllegalArgumentException(
                "ID and title are required and cannot contain commas");
        }

        this.id = id;
        this.title = title;
    }

    String getId() {
        return id;
    }

    String getTitle() {
        return title;
    }

    boolean isAvailable() {
        return available;
    }

    void setAvailable(boolean value) {
        available = value;
    }

    abstract int loanPeriodDays();

    public String toString() {
        return id + " - " + title +
               " (Available: " + available + ")";
    }
}

// Interface
interface Borrowable {
    void borrow(Member member);
    void giveBack();
}

// Book class
class Book extends LibraryItem implements Borrowable {
    Book(String id, String title) {
        super(id, title);
    }

    int loanPeriodDays() {
        return 14;
    }

    public void borrow(Member member) {
        if (!isAvailable()) {
            throw new ItemNotAvailableException(
                "Book is not available");
        }

        if (!member.canBorrow()) {
            throw new MemberLimitExceededException(
                "Member already has 3 active loans");
        }

        setAvailable(false);
    }

    public void giveBack() {
        setAvailable(true);
    }
}

// DVD class
class Dvd extends LibraryItem {
    Dvd(String id, String title) {
        super(id, title);
    }

    int loanPeriodDays() {
        return 7;
    }
}

// Member class
class Member {
    private final String id;
    private final String name;
    private final List<String> loans = new ArrayList<>();

    Member(String id, String name) {
        if (id == null || id.isBlank() ||
            name == null || name.isBlank() ||
            id.contains(",") || name.contains(",")) {
            throw new IllegalArgumentException(
                "Member ID and name are required and cannot contain commas");
        }

        this.id = id;
        this.name = name;
    }

    String getId() {
        return id;
    }

    String getName() {
        return name;
    }

    boolean canBorrow() {
        return loans.size() < 3;
    }

    void addLoan(String itemId) {
        loans.add(itemId);
    }

    void removeLoan(String itemId) {
        loans.remove(itemId);
    }

    List<String> getLoans() {
        return loans;
    }

    public String toString() {
        return id + " - " + name;
    }
}

// Loan class
class Loan {
    private final String itemId;
    private final String memberId;
    private final LocalDate borrowDate;
    private final LocalDate dueDate;

    Loan(String itemId, String memberId, int days) {
        this.itemId = itemId;
        this.memberId = memberId;
        borrowDate = LocalDate.now();
        dueDate = borrowDate.plusDays(days);
    }

    Loan(String itemId, String memberId,
         LocalDate borrowDate, LocalDate dueDate) {
        this.itemId = itemId;
        this.memberId = memberId;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    String getItemId() {
        return itemId;
    }

    String getMemberId() {
        return memberId;
    }

    LocalDate getBorrowDate() {
        return borrowDate;
    }

    LocalDate getDueDate() {
        return dueDate;
    }

    boolean isOverdue() {
        return dueDate.isBefore(LocalDate.now());
    }

    public String toString() {
        return "Item: " + itemId +
               ", Member: " + memberId +
               ", Borrowed: " + borrowDate +
               ", Due: " + dueDate;
    }
}

// Main library system
public class LibraryStarter {
    private final Map<String, LibraryItem> items =
        new HashMap<>();

    private final Map<String, Member> members =
        new HashMap<>();

    private final List<Loan> loans =
        new ArrayList<>();

    private final Scanner input = new Scanner(System.in);

    // Add an item
    void addItem(LibraryItem item) {
        if (items.containsKey(item.getId())) {
            throw new IllegalArgumentException(
                "Item ID already exists");
        }

        items.put(item.getId(), item);
    }

    // Register a member
    void register(Member member) {
        if (members.containsKey(member.getId())) {
            throw new IllegalArgumentException(
                "Member ID already exists");
        }

        members.put(member.getId(), member);
    }

    // Borrow a book
    void borrowItem(String itemId, String memberId) {
        LibraryItem item = items.get(itemId);
        Member member = members.get(memberId);

        if (item == null || member == null) {
            throw new IllegalArgumentException(
                "Invalid item ID or member ID");
        }

        if (!(item instanceof Book)) {
            throw new IllegalArgumentException(
                "Only books can be borrowed in this version");
        }

        Book book = (Book) item;

        book.borrow(member);

        member.addLoan(itemId);

        loans.add(new Loan(
            itemId, memberId, book.loanPeriodDays()));

        System.out.println("Book borrowed successfully.");
    }

    // Return a book
    void returnItem(String itemId, String memberId) {
        Loan foundLoan = null;

        for (Loan loan : loans) {
            if (loan.getItemId().equals(itemId) &&
                loan.getMemberId().equals(memberId)) {
                foundLoan = loan;
                break;
            }
        }

        if (foundLoan == null) {
            throw new IllegalArgumentException(
                "No matching active loan was found");
        }

        LibraryItem item = items.get(itemId);
        Member member = members.get(memberId);

        if (item instanceof Book) {
            ((Book) item).giveBack();
        }

        member.removeLoan(itemId);
        loans.remove(foundLoan);

        System.out.println("Book returned successfully.");
    }

    // Search items
    List<LibraryItem> search(String title) {
        List<LibraryItem> results = new ArrayList<>();

        for (LibraryItem item : items.values()) {
            if (item.getTitle().toLowerCase()
                    .contains(title.toLowerCase())) {
                results.add(item);
            }
        }

        results.sort(
            Comparator.comparing(LibraryItem::getTitle));

        return results;
    }

    // Display overdue loans
    void listOverdue() {
        boolean found = false;

        for (Loan loan : loans) {
            if (loan.isOverdue()) {
                System.out.println(loan);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No overdue loans.");
        }
    }

    // Save all data to CSV files
    void saveData() {
        try {
            PrintWriter itemWriter =
                new PrintWriter("items.csv");

            for (LibraryItem item : items.values()) {
                String type = item instanceof Book
                    ? "BOOK" : "DVD";

                itemWriter.println(
                    item.getId() + "," +
                    item.getTitle() + "," +
                    type + "," +
                    item.isAvailable());
            }

            itemWriter.close();

            PrintWriter memberWriter =
                new PrintWriter("members.csv");

            for (Member member : members.values()) {
                memberWriter.println(
                    member.getId() + "," +
                    member.getName());
            }

            memberWriter.close();

            PrintWriter loanWriter =
                new PrintWriter("loans.csv");

            for (Loan loan : loans) {
                loanWriter.println(
                    loan.getItemId() + "," +
                    loan.getMemberId() + "," +
                    loan.getBorrowDate() + "," +
                    loan.getDueDate());
            }

            loanWriter.close();

            System.out.println("Data saved successfully.");

        } catch (IOException e) {
            System.out.println(
                "Error saving data: " + e.getMessage());
        }
    }

    // Load data from CSV files
    void loadData() {
        try {
            File itemFile = new File("items.csv");

            if (itemFile.exists()) {
                Scanner file = new Scanner(itemFile);

                while (file.hasNextLine()) {
                    String[] data =
                        file.nextLine().split(",", -1);

                    if (data.length != 4) continue;

                    LibraryItem item;

                    if (data[2].equals("BOOK")) {
                        item = new Book(data[0], data[1]);
                    } else if (data[2].equals("DVD")) {
                        item = new Dvd(data[0], data[1]);
                    } else {
                        continue;
                    }

                    item.setAvailable(
                        Boolean.parseBoolean(data[3]));

                    items.put(item.getId(), item);
                }

                file.close();
            }

            File memberFile = new File("members.csv");

            if (memberFile.exists()) {
                Scanner file = new Scanner(memberFile);

                while (file.hasNextLine()) {
                    String[] data =
                        file.nextLine().split(",", -1);

                    if (data.length == 2) {
                        Member member =
                            new Member(data[0], data[1]);

                        members.put(member.getId(), member);
                    }
                }

                file.close();
            }

            File loanFile = new File("loans.csv");

            if (loanFile.exists()) {
                Scanner file = new Scanner(loanFile);

                while (file.hasNextLine()) {
                    String[] data =
                        file.nextLine().split(",", -1);

                    if (data.length != 4) continue;

                    String itemId = data[0];
                    String memberId = data[1];

                    Loan loan = new Loan(
                        itemId,
                        memberId,
                        LocalDate.parse(data[2]),
                        LocalDate.parse(data[3]));

                    if (items.containsKey(itemId) &&
                        members.containsKey(memberId)) {

                        loans.add(loan);
                        members.get(memberId).addLoan(itemId);
                        items.get(itemId).setAvailable(false);
                    }
                }

                file.close();
            }

            System.out.println("Data loaded successfully.");

        } catch (Exception e) {
            System.out.println(
                "Error loading data: " + e.getMessage());
        }
    }

    // Main menu
    void menu() {
        int choice = -1;

        while (choice != 0) {
            System.out.println("\n=== LIBRARY MANAGEMENT ===");
            System.out.println("1. Add book");
            System.out.println("2. Add DVD");
            System.out.println("3. Register member");
            System.out.println("4. Borrow book");
            System.out.println("5. Return book");
            System.out.println("6. List overdue loans");
            System.out.println("7. Search items");
            System.out.println("8. List all items");
            System.out.println("9. Save data");
            System.out.println("0. Save and exit");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(input.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Book ID: ");
                        String bookId = input.nextLine();

                        System.out.print("Book title: ");
                        String bookTitle = input.nextLine();

                        addItem(new Book(bookId, bookTitle));
                        System.out.println("Book added.");
                        break;

                    case 2:
                        System.out.print("DVD ID: ");
                        String dvdId = input.nextLine();

                        System.out.print("DVD title: ");
                        String dvdTitle = input.nextLine();

                        addItem(new Dvd(dvdId, dvdTitle));
                        System.out.println("DVD added.");
                        break;

                    case 3:
                        System.out.print("Member ID: ");
                        String memberId = input.nextLine();

                        System.out.print("Member name: ");
                        String memberName = input.nextLine();

                        register(new Member(
                            memberId, memberName));

                        System.out.println("Member registered.");
                        break;

                    case 4:
                        System.out.print("Book ID: ");
                        String borrowId = input.nextLine();

                        System.out.print("Member ID: ");
                        String borrowerId = input.nextLine();

                        borrowItem(borrowId, borrowerId);
                        break;

                    case 5:
                        System.out.print("Book ID: ");
                        String returnId = input.nextLine();

                        System.out.print("Member ID: ");
                        String returnMember = input.nextLine();

                        returnItem(returnId, returnMember);
                        break;

                    case 6:
                        listOverdue();
                        break;

                    case 7:
                        System.out.print("Enter title to search: ");
                        String query = input.nextLine();

                        for (LibraryItem item : search(query)) {
                            System.out.println(item);
                        }
                        break;

                    case 8:
                        for (LibraryItem item : items.values()) {
                            System.out.println(item);
                        }
                        break;

                    case 9:
                        saveData();
                        break;

                    case 0:
                        saveData();
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        input.close();
    }

    public static void main(String[] args) {
        LibraryStarter library = new LibraryStarter();

        library.loadData();
        library.menu();
    }
}

