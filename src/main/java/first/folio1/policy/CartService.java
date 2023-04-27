package first.folio1.policy;

import first.folio1.etc.CartItem;

import java.util.List;

public interface CartService {


    //----------------------------------------------------------------
    /**
     * 상품을 장바구니에 추가합니다.
     *
     * @param productId 장바구니에 추가할 상품 ID
     * @param quantity  상품 수량
     * @param userId     현재 로그인한 사용자 ID
     */
    void addItemToCart(Long productId, int quantity, Long userId);

    /**
     * 장바구니에서 상품을 삭제합니다.
     *
     * @param cartItemId 장바구니에서 삭제할 상품 ID
     * @param userId      현재 로그인한 사용자 ID
     */
    void removeItemFromCart(Long cartItemId, Long userId);

    /**
     * 장바구니에 담긴 모든 상품을 조회합니다.
     *
     * @param userId 현재 로그인한 사용자 ID
     * @return 장바구니에 담긴 모든 상품 목록
     */
    List<CartItem> getAllCartItems(Long userId);

    /**
     * 장바구니에 담긴 모든 상품을 주문합니다.
     *
     * @param userId 현재 로그인한 사용자 ID
     */
    void placeOrder(Long userId);
    /**
     * 장바구니에 담긴 모든 상품을 삭제합니다.
     *
     * @param userId 현재 로그인한 사용자 ID
     */
    void clearCart(Long cartId);

    /**
     * 장바구니에 담긴 모든 상품의 가격을 다 더한 값.
     *
     * @param userId 현재 로그인한 사용자 ID
     */
    int getTotalPrice();
}





