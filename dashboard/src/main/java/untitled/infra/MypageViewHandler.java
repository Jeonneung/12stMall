package untitled.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import untitled.config.kafka.KafkaProcessor;
import untitled.domain.*;

@Service
public class MypageViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private MypageRepository mypageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1(
        @Payload OrderPlaced orderPlaced
    ) {
        try {
            if (!orderPlaced.validate()) return;

            // view 객체 생성
            Mypage mypage = new Mypage();
            // view 객체에 이벤트의 Value 를 set 함
            mypage.setOrderId(orderPlaced.getId());
            mypage.setCustomerId(orderPlaced.getCustomerId());
            mypage.setItemId(orderPlaced.getProductId());
            mypage.setQuantity(orderPlaced.getQuantity());
            mypage.setAddress(orderPlaced.getAddress());
            // view 레파지 토리에 save
            mypageRepository.save(mypage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCompleted_then_UPDATE_1(
        @Payload DeliveryCompleted deliveryCompleted
    ) {
        try {
            if (!deliveryCompleted.validate()) return;
            // view 객체 조회
            Optional<Mypage> mypageOptional = mypageRepository.findByOrderId(
                deliveryCompleted.getOrderId()
            );

            if (mypageOptional.isPresent()) {
                Mypage mypage = mypageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                mypage.setDeliveryStatus(DELIVER);
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCancelled_then_UPDATE_2(
        @Payload OrderCancelled orderCancelled
    ) {
        try {
            if (!orderCancelled.validate()) return;
            // view 객체 조회
            Optional<Mypage> mypageOptional = mypageRepository.findByOrderId(
                orderCancelled.getId()
            );

            if (mypageOptional.isPresent()) {
                Mypage mypage = mypageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                mypage.setOrderStatus(CANCEL);
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCancelled_then_UPDATE_3(
        @Payload DeliveryCancelled deliveryCancelled
    ) {
        try {
            if (!deliveryCancelled.validate()) return;
            // view 객체 조회
            Optional<Mypage> mypageOptional = mypageRepository.findByOrderId(
                deliveryCancelled.getOrderId()
            );

            if (mypageOptional.isPresent()) {
                Mypage mypage = mypageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_UPDATE_4(
        @Payload OrderPlaced orderPlaced
    ) {
        try {
            if (!orderPlaced.validate()) return;
            // view 객체 조회
            Optional<Mypage> mypageOptional = mypageRepository.findByOrderId(
                orderPlaced.getId()
            );

            if (mypageOptional.isPresent()) {
                Mypage mypage = mypageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
