package first.folio1.policy;

public interface ProductService {
    // 상품 등록
    public Product registerProduct(Product product);

    // 상품 조회
    public List<Product> getProductList();

    // 상품 상세 조회
    public Product getProductDetail(Long id);

    // 상품 수정
    public Product updateProduct(Long id, Product product);

    // 상품 삭제
    public void deleteProduct(Long id);
}
