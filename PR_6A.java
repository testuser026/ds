package pr_5;

import java.util.Scanner;

class Bully_Algo_6A 
{
    static boolean[] state = {true, true, true, true, true};
    static int coordinator = 5;

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("Processes: P1 P2 P3 P4 P5");
        System.out.println("Initial Coordinator: P5");
        do 
        {
            System.out.println("\n1. Down Process");
            System.out.println("2. Up Process");
            System.out.println("3. Start Election");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter process to DOWN: ");
                    int down = sc.nextInt();
                    state[down - 1] = false;
                    System.out.println("P" + down + " is DOWN");
                    break;

                case 2:
                    System.out.print("Enter process to UP: ");
                    int up = sc.nextInt();

                    if (!state[up - 1]) 
                    {
                        state[up - 1] = true;
                        System.out.println("P" + up + " is UP");

                        // 🔥 Auto election
                        System.out.println("P" + up + " automatically starts election");
                        election(up);

                    } 
                    else 
                    {
                        System.out.println("P" + up + " is already UP");
                    }
                    break;

                case 3:
                    System.out.print("Enter process starting election: ");
                    int px = sc.nextInt();
                    election(px);
                    break;
            }

        } while (choice != 4);

        sc.close();
    }

    static void election(int px) 
    {
        if (!state[px - 1]) 
        {
            System.out.println("P" + px + " is DOWN. Cannot start election.");
            return;
        }

        System.out.println("\nP" + px + " starts election");

        // Election message to ALL higher processes
        for (int i = px + 1; i <= 5; i++) 
        {   System.out.println("Election message sent from P" + px + " to P" + i);
            if (state[i - 1]) 
            {
                System.out.println("Alive message sent from P" + i + " to P" + px);
            }
        }

        // Highest active becomes coordinator
        for (int i = 5; i >= 1; i--) 
        {
            if (state[i - 1]) 
            {   coordinator = i;
                break;
            }
        }
        System.out.println("Coordinator message sent from P" + coordinator + " to all");
    }
}