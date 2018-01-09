package project;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        Scanner scn2 = new Scanner(System.in);
        //Создаём обьект Treap
        Treap trpt = new Treap();
        System.out.println("Treap Main\n");
        //Меню
        boolean running = true;
        while (running)
        {
           running = Menu(scn, scn2, trpt, running);
            //Показ дерева
            if(running)
            {
                trpt.postorder();
                System.out.print("\nPre order : ");
                trpt.preorder();
                System.out.print("\nIn order : ");
                trpt.inorder();
            }

        }


    }

    private static boolean Menu(Scanner scn, Scanner scn2, Treap trpt, boolean running)
    {
        System.out.println("\nTreap Operations\n");
        System.out.println("[I]nsert ");
        System.out.println("[S]earch");
        System.out.println("[C]ount nodes");
        System.out.println("C[h]eck empty");
        System.out.println("C[l]ear");
        System.out.println("[E]xit");
        char choice = scn2.nextLine().toLowerCase().toCharArray()[0];
        switch (choice)
        {
            case 'i':
                System.out.println("Enter integer element to insert");
                trpt.insert(scn.nextInt());
                break;
            case 's':
                System.out.println("Enter integer element to search");
                System.out.println("Search result : " + trpt.search(scn.nextInt()));
                break;
            case 'c':
                System.out.println("Nodes = " + trpt.countNodes());
                break;
            case 'h':
                System.out.println("Empty status = " + trpt.isEmpty());
                break;
            case 'l':
                System.out.println("\nTreap Cleared");
                trpt.makeEmpty();
                break;
            case 'e':
                running = false;
                System.out.println("Exiting");
                return false;
            default:
                System.out.println("Wrong Entry \n ");
                break;
        }
        return true;

    }
}
