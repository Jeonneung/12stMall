package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class InventoryIncreased extends AbstractEvent {

    private Long id;
    private Long stockId;
    private Integer stockQuantity;
}
