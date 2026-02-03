class first
{
    public void show()
    {
        System.out.println("Base class function");
    }
}
class second extends first
{
    public void show()
    {
        System.out.println("Derived class function");
    }
}
public class vf
{
    public static void main(String[] args)
    {
        second s = new second();
        // s.show();
        first f = new second();
        f.show();
    }
}
