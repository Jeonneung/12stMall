package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryCancelled extends AbstractEvent {

    private Long id;
    private String deliveryStatus;
    private Long orderId;
    private Long customerId;
    private Long stockId;
    private Integer quantity;

    public DeliveryCancelled(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryCancelled() {
        super();
    }
}
//>>> DDD / Domain Event
