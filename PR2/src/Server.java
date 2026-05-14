import CalcApp.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.CosNaming.*;

class Server
{
    public static void main(String args[])
    {
        try
        {
            ORB orb = ORB.init(args, null);

            POA rootpoa = POAHelper.narrow(
                    orb.resolve_initial_references("RootPOA"));

            rootpoa.the_POAManager().activate();

            CalcImpl obj = new CalcImpl();

            org.omg.CORBA.Object ref =
                    rootpoa.servant_to_reference(obj);

            Calc href = CalcHelper.narrow(ref);

            org.omg.CORBA.Object objRef =
                    orb.resolve_initial_references("NameService");

            NamingContextExt ncRef =
                    NamingContextExtHelper.narrow(objRef);

            ncRef.rebind(ncRef.to_name("ABC"), href);

            System.out.println("Server Started");

            orb.run();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}