package first.folio1.policy;

import first.folio1.exceptions.CartNotFoundException;
import first.folio1.orders.Order;
import first.folio1.exceptions.OrderNotFoundException;
import first.folio1.exceptions.UserNotFoundException;

import java.util.List;

public interface OrderService {




    /**
     * 주문내역 다 가져옴
     * @param order 생성할 주문 객체
     * @return 생성된 주문 번호
     */
    public List<Order> getAllOrders();


    /**
     * 주문을 생성하고 주문 번호를 반환하는 메소드
     * @param order 생성할 주문 객체
     * @return 생성된 주문 번호
     */
    public void createOrder(Long cartId, Long userId) throws CartNotFoundException, UserNotFoundException;

    /**
     * 주문 번호에 해당하는 주문 정보를 반환하는 메소드
     * @param orderId 조회할 주문 번호
     * @return 주문 정보
     * @throws OrderNotFoundException 주문 번호에 해당하는 주문이 없을 경우 예외 발생
     */
    public Order getOrderById(Long orderId) throws OrderNotFoundException;

    /**
     * 사용자 ID에 해당하는 주문 리스트를 반환하는 메소드
     * @param userId 조회할 사용자 ID
     * @return 주문 리스트
     */
    public List<Order> getOrdersByUserId(Long userId) throws UserNotFoundException;

    /**
     * 주문 번호에 해당하는 주문을 취소하는 메소드
     * @param orderId 취소할 주문 번호
     * @throws OrderNotFoundException 주문 번호에 해당하는 주문이 없을 경우 예외 발생
     */
    void cancelOrder(Long orderId) throws OrderNotFoundException;

}


