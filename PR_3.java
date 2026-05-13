import java.util.Scanner;

class Processor extends Thread
{
    int start, end;
    int arr[];
    int sum = 0;

    Processor(int arr[], int start, int end)
    {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    public void run()
    {
        for(int i = start; i < end; i++)
        {
            sum = sum + arr[i];
        }

        System.out.println("Partial Sum = " + sum);
    }

    public int getSum()
    {
        return sum;
    }
}

public class PR_3
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter array elements:");

        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        int mid = n / 2;

        // Two processors
        Processor p1 = new Processor(arr, 0, mid);
        Processor p2 = new Processor(arr, mid, n);

        // Start processors
        p1.start();
        p2.start();

        try
        {
            p1.join();
            p2.join();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        int total = p1.getSum() + p2.getSum();

        System.out.println("Total Sum = " + total);
    }
}
