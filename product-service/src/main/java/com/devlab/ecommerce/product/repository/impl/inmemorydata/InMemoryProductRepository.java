package com.devlab.ecommerce.product.repository.impl.inmemorydata;

import com.devlab.ecommerce.product.entity.Product;
import com.devlab.ecommerce.product.entity.ProductDetails;
import com.devlab.ecommerce.product.enums.ProductStatus;
import com.devlab.ecommerce.product.enums.StockStatus;
import com.devlab.ecommerce.product.repository.ProductRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

@Slf4j
@RequiredArgsConstructor
@Repository
@ConditionalOnProperty(name = "product.db.enabled", havingValue = "false")
public class InMemoryProductRepository implements ProductRepository {

  @Override
  public List<Product> findAllProductsByStoreId(long storeId) {
    List<Product> productsByStoreId =  loadProductData().stream().filter(product -> storeId == product.getProductDetails().getStoreId()).toList();
    log.info(" Total products of store fetched=[{}]", productsByStoreId.size());
    return productsByStoreId;
  }

  @Override
  public Optional<Product> findById(String id) {
    return loadProductData().stream().filter(product -> id.equalsIgnoreCase(product.getId()))
        .findFirst();
  }

  private List<Product> loadProductData() {
    return getProducts();
  }

  public static List<Product> getProducts() {

    Product p1 = Product.builder()
        .id("p1")
        .categoryId(101L)
        .sku("SKU-IPHONE-15")
        .name("iPhone 15")
        .slug("iphone-15")
        .brand("Apple")
        .price(new BigDecimal("999.99"))
        .discountPrice(new BigDecimal("899.99"))
        .stockStatus(StockStatus.IN_STOCK)
        .status(ProductStatus.ACTIVE)
        .thumbnail("iphone15.png")
        .shortDescription("Latest Apple iPhone")
        .build();

    ProductDetails d1 = ProductDetails.builder()
//        .id("d1")
        .description("Full description of iPhone 15")
        .specifications("128GB, A16 Bionic")
        .image("iphone15-detail.png")
        .metaTitle("Buy iPhone 15")
        .metaDescription("Best iPhone 15 price")
        .returnable(true)
        .returnWindowDays(7)
        .warranty("1 Year")
        .storeId(1L)
        .build();

    link(p1, d1);

    // ----------------------------

    Product p2 = Product.builder()
        .id("p2")
        .categoryId(102L)
        .sku("SKU-SAMSUNG-S24")
        .name("Samsung S24")
        .slug("samsung-s24")
        .brand("Samsung")
        .price(new BigDecimal("899.99"))
        .discountPrice(new BigDecimal("799.99"))
        .stockStatus(StockStatus.IN_STOCK)
        .status(ProductStatus.ACTIVE)
        .thumbnail("s24.png")
        .shortDescription("Samsung flagship")
        .build();

    ProductDetails d2 = ProductDetails.builder()
//        .id("d2")
        .description("Full description of Samsung S24")
        .specifications("256GB, Snapdragon")
        .image("s24-detail.png")
        .metaTitle("Buy Samsung S24")
        .metaDescription("Best Samsung S24 deal")
        .returnable(true)
        .returnWindowDays(10)
        .warranty("1 Year")
        .storeId(1L)
        .build();

    link(p2, d2);

    // ----------------------------

    Product p3 = Product.builder()
        .id("p3")
        .categoryId(103L)
        .sku("SKU-MBP")
        .name("MacBook Pro")
        .slug("macbook-pro")
        .brand("Apple")
        .price(new BigDecimal("1999.99"))
        .discountPrice(new BigDecimal("1799.99"))
        .stockStatus(StockStatus.IN_STOCK)
        .status(ProductStatus.ACTIVE)
        .thumbnail("mbp.png")
        .shortDescription("Apple laptop")
        .build();

    ProductDetails d3 = ProductDetails.builder()
//        .id("d3")
        .description("MacBook Pro M3")
        .specifications("16GB RAM, 512GB SSD")
        .image("mbp-detail.png")
        .metaTitle("Buy MacBook Pro")
        .metaDescription("Latest MacBook Pro")
        .returnable(false)
        .returnWindowDays(0)
        .warranty("1 Year")
        .storeId(2L)
        .build();

    link(p3, d3);

    // ----------------------------

    Product p4 = Product.builder()
        .id("p4")
        .categoryId(104L)
        .sku("SKU-DELL-XPS")
        .name("Dell XPS 13")
        .slug("dell-xps-13")
        .brand("Dell")
        .price(new BigDecimal("1299.99"))
        .discountPrice(new BigDecimal("1199.99"))
        .stockStatus(StockStatus.OUT_OF_STOCK)
        .status(ProductStatus.INACTIVE)
        .thumbnail("xps.png")
        .shortDescription("Dell ultrabook")
        .build();

    ProductDetails d4 = ProductDetails.builder()
//        .id("d4")
        .description("Dell XPS premium laptop")
        .specifications("16GB RAM, i7")
        .image("xps-detail.png")
        .metaTitle("Dell XPS 13")
        .metaDescription("Powerful ultrabook")
        .returnable(true)
        .returnWindowDays(5)
        .warranty("2 Years")
        .storeId(2L)
        .build();

    link(p4, d4);

    // ----------------------------

    Product p5 = Product.builder()
        .id("p5")
        .categoryId(105L)
        .sku("SKU-SONY-HN")
        .name("Sony Headphones")
        .slug("sony-headphones")
        .brand("Sony")
        .price(new BigDecimal("299.99"))
        .discountPrice(new BigDecimal("249.99"))
        .stockStatus(StockStatus.IN_STOCK)
        .status(ProductStatus.ACTIVE)
        .thumbnail("sony.png")
        .shortDescription("Noise cancelling")
        .build();

    ProductDetails d5 = ProductDetails.builder()
//        .id("d5")
        .description("Sony WH-1000XM5")
        .specifications("ANC, 30hr battery")
        .image("sony-detail.png")
        .metaTitle("Sony Headphones")
        .metaDescription("Best ANC headphones")
        .returnable(true)
        .returnWindowDays(15)
        .warranty("1 Year")
        .storeId(3L)
        .build();

    link(p5, d5);

    return List.of(p1, p2, p3, p4, p5);
  }

  // 🔑 CRITICAL: maintain both sides
  private static void link(Product p, ProductDetails d) {
    p.setProductDetails(d);
//    d.setProduct(p);
  }
}
