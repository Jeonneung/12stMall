package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.DeliveryApplication;
import untitled.domain.DeliveryCancelled;
import untitled.domain.DeliveryCompleted;

@Entity
@Table(name = "Delivery_table")
@Data
//<<< DDD / Aggregate Root
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long deliveryId;

    private String deliveryStatus;

    private Long orderId;

    private String address;

    private Long customerId;

    private Long stockId;

    private Integer quantity;

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    //<<< Clean Arch / Port Method
    public static void startDelivery(OrderPlaced orderPlaced) {
        //implement business logic here:

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(delivery);
        deliveryCompleted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(orderPlaced.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            DeliveryCompleted deliveryCompleted = new DeliveryCompleted(delivery);
            deliveryCompleted.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void cancelDelivery(OrderCancelled orderCancelled) {
        //implement business logic here:

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        DeliveryCancelled deliveryCancelled = new DeliveryCancelled(delivery);
        deliveryCancelled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(orderCancelled.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            DeliveryCancelled deliveryCancelled = new DeliveryCancelled(delivery);
            deliveryCancelled.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
