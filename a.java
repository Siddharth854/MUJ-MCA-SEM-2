package access_modifier;
public class a
{
	public void a()
    {
        System.out.println("public function called");
    }
}

class b
{
     private void b()
    {
        System.out.println("This is private function");
    }
}
private class c
{
private void c()
    {
        System.out.println("tHIS IS DEFAULT FUNCTION");
    }
}
protected class d
{
    protected void d()
    {
        System.out.println("This is protected function");
    }
}
class a_m{
    public static void main(String[] args)
    {
    }
}