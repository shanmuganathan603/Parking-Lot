import java.util.*;
class ParkingLot{
    List<List<String>> carNumbers = new ArrayList<>();
    HashMap<String,Integer> hm = new HashMap<>();
    public void addFloor()
    {
        carNumbers.add(new ArrayList<>());
    }
    public void park(String s)
    {
        int a = carNumbers.get(0).size();
        int i=0;
        for(int j=1;j<carNumbers.size();j++)
            if(carNumbers.get(j).size()<a)
            {
                a=carNumbers.get(j).size();
                i=j;
            }
        carNumbers.get(i).add(s);
        hm.put(s,i);
    }
    public void unpark(String s)
    {
        if(!hm.containsKey(s))
        {
            System.out.println("This car is not present in parking lot.");
            return;
        }
        carNumbers.get(hm.get(s)).remove(s);
    }
    public List<List<String>> getList()
    {
        return carNumbers;
    }
}
public class carParking {
    static void print(List<List<String>> s)
    {
        for(int i=0;i<s.size();i++)
        {
            System.out.print("p"+(i+1)+" ");
            for(int j=0;j<s.get(i).size();j++)
            {
                System.out.print(s.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingLot p = new ParkingLot();
        while(true)
        {
            System.out.println("Enter 1 to Add Floor");
            System.out.println("Enter 2 to Park");
            System.out.println("Enter 3 to Unpark");
            System.out.println("Enter 4 to Exit");
            int a=sc.nextInt();
            switch (a) {
                case 1:
                    p.addFloor();
                    break;
                case 2:
                    String s = sc.next();
                    p.park(s);
                    break;
                case 3:
                    s = sc.next();
                    p.unpark(s);
                    break;
                case 4:
                    System.exit(0);
            }
            print(p.getList());
        }
    }
}
