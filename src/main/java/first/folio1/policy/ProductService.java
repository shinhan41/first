package first.folio1.policy;

import first.folio1.exceptions.ProductNotFoundException;
import first.folio1.products.Product;

import java.util.List;

public interface ProductService {
    // 상품 등록
    public void addProduct(Product product);

    // 전체 상품 조회
    public List<Product> getProductList();

    // 상품 상세 조회
    public Product getProductById(Long productId) throws ProductNotFoundException;

    // 상품 수정
    public void updateProduct(Product product) throws ProductNotFoundException;

    // 상품 삭제
    public void deleteProduct(Long productId) throws ProductNotFoundException;

    // 카테고리에서 조회
    public List<Product> getProductsByCategory(String category);

    //키워드로 상품 조회
    public List<Product> getProductsByKeyword(String keyword);



}
