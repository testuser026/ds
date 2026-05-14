import CalcApp.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import java.util.Scanner;

class Client
{
    public static void main(String args[])
    {
        try
        {
            ORB orb = ORB.init(args, null);

            org.omg.CORBA.Object objRef =
                    orb.resolve_initial_references("NameService");

            NamingContextExt ncRef =
                    NamingContextExtHelper.narrow(objRef);

            Calc obj = CalcHelper.narrow(
                    ncRef.resolve_str("ABC"));

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter first number: ");
            float a = sc.nextFloat();

            System.out.print("Enter second number: ");
            float b = sc.nextFloat();

            System.out.println("Addition = " + obj.add(a, b));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}