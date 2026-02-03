import java.util.Scanner;

public class Lab_01 {

    public static int[] insert_element(int[] arr, int element) {
        int[] newArr = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        newArr[arr.length] = element;
        return newArr;
    }

    public static int[] delete_element(int[] arr, int index) {
        if (index < 0 || index >= arr.length) {
            System.out.println("Invalid index");
            return arr;
        }

        int[] newArr = new int[arr.length - 1];
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i == index)
                continue;
            newArr[j++] = arr[i];
        }

        return newArr;
    }

    public static void traverse(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Array is empty");
            return;
        }

        System.out.print("Array elements: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[0];  

        System.out.println("Enter your choice:");
        System.out.println("1. 1D ARRAY");
        System.out.println("2. 2D ARRAY");
        int selection = sc.nextInt();

        if (selection == 1) {
            int choice;
            do {
                System.out.println(" 1D ARRAY");
                System.out.println("1. Insert element");
                System.out.println("2. Delete element");
                System.out.println("3. Traverse array");
                System.out.println("4. Exit");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter element to insert: ");
                        arr = insert_element(arr, sc.nextInt());
                        break;

                    case 2:
                        System.out.print("Enter index to delete: ");
                        arr = delete_element(arr, sc.nextInt());
                        break;

                    case 3:
                        traverse(arr);
                        break;

                    case 4:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }
            } while (choice != 4);
        }
        else if (selection == 2) 
        {
            int choice;
            do{    
                System.out.println("2D Array ");
                System.out.println("Enter the Row number");
                int rows = sc.nextInt();
                System.out.println("Enter the Column number");
                int cols = sc.nextInt();
                int[][] arr = new int[rows][cols];
                int choice;
                do{
                    System.out.println("\n--- 2D ARRAY MENU ---");
                    System.out.println("1. Insert element");
                    System.out.println("2. Delete element");
                    System.out.println("3. Traverse array");
                    System.out.println("4. Exit");
                    choice = sc.nextInt();
                    switch(choice) 
                    {
                        case 1:
                            System.out.print("Enter row length: ");
                            int r = sc.nextInt();
                            System.out.print("Enter column length: ");
                            int c = sc.nextInt();

                            if(r>=0 && r<rows && c>=0 &&c<cols)
                            {
                                System.out.print("Enter Element: ");
                                arr[r][c] = sc.nextInt();
                                System.out.println("Element inserted Successfully!");
                            }else{
                                System.out.println("Invalid Syntax");
                            }
                            break;
                        case 2: 
                            System.out.print("Enter row length: ");
                            int r = sc.nextInt();
                            System.out.print("Enter column length: ");
                            int c = sc.nextInt();

                            if(r>=0 && r<rows && c>=0 && c<cols)
                            {
                                arr[r][c] = 0;
                                System.out.println("Element deleted Successfully!");
                            }else{
                                System.out.println("Invalid Syntax");
                            }
                            break;
                        case 3:
                            System.out.println("Traversing the  Array: ");
                            for(int i=0;i<rows;i++)
                            {
                                for(int j=0;j<cols;j++)
                                {
                                    System.out.println(arr[i][j]+" ");
                                }
                                System.out.println();
                            }
                            break;
                        case 4:
                            System.out.println("Exiting 2D Array...");
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                }
                while(choice!=4);
            }            
        }
        else {
            System.out.println("Invalid selection");
        }

        sc.close();
    }
}
