package com.repo.aldinaldin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.repo.aldinaldin.model.OrderProduct;

@Repository
public interface IOrderProductRepository extends JpaRepository<OrderProduct, Long> {
      @Query(value = "SELECT * FROM aldinaldin.order_product u WHERE u.order_id = ?1", nativeQuery = true)
    List<OrderProduct> findOrderDetail(long order_id);

      @Query(value = "select * From aldinaldin.order_product as orderProduct \r\n" + //
              "INNER JOIN aldinaldin.product as product on \r\n" + //
              "orderProduct.product_id =product.id \r\n" + //
              "where product.seller_id=?1", nativeQuery = true)
    List<OrderProduct> findOrderProductBySeller(long seller_id);
}
