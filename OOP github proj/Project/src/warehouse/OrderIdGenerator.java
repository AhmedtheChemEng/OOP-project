/**
 * Generates unique order IDs for the warehouse system.
 * Each generated ID follows the format "ORD####" with an incremental counter.
 *
 * @author Fahad Ali
 * @version 3.0
 * @since 2025-10-20
 */

package warehouse;
public class OrderIdGenerator {
    private static int counter=1000;
    public static String nextId(){
        counter++;

        return String.format("ORD%4d",counter);
    }
}
