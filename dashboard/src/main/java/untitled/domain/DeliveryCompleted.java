package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import untitled.infra.AbstractEvent;

@Data
public class DeliveryCompleted extends AbstractEvent {

    private Long id;
    private Long stockId;
    private Integer quantity;
    private Long deliveryId;
    private String deliveryStatus;
    private Long orderId;
    private Long customerId;
}
