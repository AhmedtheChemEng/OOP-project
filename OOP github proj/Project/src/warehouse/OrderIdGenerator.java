package warehouse;
public class OrderIdGenerator {
    private static int counter=0;
    public static String nextId(){
        counter++;

        return String.format("ORD-%04D",counter);
    }
}
