package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class DeliveryCancelled extends AbstractEvent {

    private Long id;
    private String deliveryStatus;
    private Long orderId;
    private Long customerId;
    private Long stockId;
    private Integer quantity;
}
