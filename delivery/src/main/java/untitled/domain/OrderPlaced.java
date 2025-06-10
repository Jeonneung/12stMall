package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private Long customerId;
    private Long productId;
    private Integer quantity;
    private Long stockId;
    private String address;
}
