/**
 * Enumeration representing the various stages of a shipment process
 * in the warehouse system. Used to track the delivery progress
 * of customer orders.
 *
 * Possible statuses include:
 * CREATED, PACKED, IN_TRANSIT, OUT_FOR_DELIVERY, and DELIVERED.
 *
 * @author Ahmed Seboui
 * @version 2.0
 * @since 2025-10-20
 */

package warehouse;

public enum ShipmentStatus {
	CREATED, PACKED, IN_TRANSIT, OUT_FOR_DELIVERY, DELIVERED;
}
