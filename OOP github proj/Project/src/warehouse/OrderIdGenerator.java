package warehouse;
public class OrderIdGenerator {
    private static int counter=1000;
    public static String nextId(){
        counter++;

        return String.format("ORD%4d",counter);
    }
}
