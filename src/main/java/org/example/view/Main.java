package org.example.view;

import org.example.service.AuthorService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        PrintList printList = new PrintList();
        AuthorService authorService = new AuthorService();

        boolean program = true;



        while (program) {
            System.out.println("1 - Create author");
            System.out.println("2 - Create book");
            System.out.println("3 - Sort author family");
            System.out.println("4 - Create print book of author with id ");
            System.out.println("5 - Print all of book from all author and their info ");
            System.out.println("6 - EXIT");
            System.out.print("Enter your choice : ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    printList.createAuthor();
                    break;
                case 2:
                    printList.createBook();
                    break;

                case 3:
                    authorService.sortAuthorFamily();
                    break;

                case 4:
                    printList.printAuthorBook(1L);
                    break;

                case 5:
                    authorService.printAuthorInfo();
                    break;

                case 6:
                    System.exit(0);
            }
        }

    }
}
