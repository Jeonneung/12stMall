package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import untitled.infra.AbstractEvent;

@Data
public class DeliveryCancelled extends AbstractEvent {

    private Long id;
    private String deliveryStatus;
    private Long orderId;
    private Long customerId;
    private Long stockId;
    private Integer quantity;
}
