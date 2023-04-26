package first.folio1.policy;

public interface OrderService {
    /**
     * 주문을 생성하고 주문 번호를 반환하는 메소드
     * @param order 생성할 주문 객체
     * @return 생성된 주문 번호
     */
    Long createOrder(Order order);

    /**
     * 주문 번호에 해당하는 주문 정보를 반환하는 메소드
     * @param orderId 조회할 주문 번호
     * @return 주문 정보
     * @throws OrderNotFoundException 주문 번호에 해당하는 주문이 없을 경우 예외 발생
     */
    Order getOrder(Long orderId) throws OrderNotFoundException;

    /**
     * 사용자 ID에 해당하는 주문 리스트를 반환하는 메소드
     * @param userId 조회할 사용자 ID
     * @return 주문 리스트
     */
    List<Order> getOrderListByUserId(Long userId);

    /**
     * 주문 번호에 해당하는 주문을 취소하는 메소드
     * @param orderId 취소할 주문 번호
     * @throws OrderNotFoundException 주문 번호에 해당하는 주문이 없을 경우 예외 발생
     */
    void cancelOrder(Long orderId) throws OrderNotFoundException;

}

}
