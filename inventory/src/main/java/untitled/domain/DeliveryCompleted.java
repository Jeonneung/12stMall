package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class DeliveryCompleted extends AbstractEvent {

    private Long id;
    private Long stockId;
    private Integer quantity;
    private Long deliveryId;
    private String deliveryStatus;
    private Long orderId;
    private Long customerId;
}
