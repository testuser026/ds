package pr_5;

import java.util.Scanner;
 class PR_6_B_Ring
 {  static int n = 5; 
    static boolean[] active = {true, true, true, true, true};

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
       
        active[4] = false;  
        System.out.println("Process 5 fails");
        System.out.print("Enter process starting election: ");//2
        int initiator = sc.nextInt();//initiator = 2
        if (initiator < 1 || initiator > n) 
        {
            System.out.println("Invalid Process Number");
            return;
        }
        if (!active[initiator - 1]) 
        {
            System.out.println("Process P" + initiator + " is DOWN. Cannot start election.");
            return;
        }
        
        System.out.println("Election initiated by Process P" + initiator);

        int maxId = -1;
        int i = initiator - 1;  

        
        do 
        {
            if (active[i]) 
            {
                System.out.println("Process P" + (i + 1) + " passes election message");
                if (i > maxId)
                {
                    maxId = i; 
                }                    
            }
            i = (i + 1) % n;        
        } while (i != initiator - 1); 
        System.out.println("New Coordinator is Process P" + (maxId + 1));
        
        i = maxId;
        do 
        {
            if (active[i]) 
            {
                System.out.println("Coordinator message passed from Process P" + (i + 1));
            }
            i = (i + 1) % n;
        } while (i != maxId);
        System.out.println("Election Completed");
    }
}