package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import untitled.infra.AbstractEvent;

@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private Long customerId;
    private Long productId;
    private Integer quantity;
    private Long stockId;
    private String address;
}
