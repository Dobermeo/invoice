package com.example.facturasapi.service

import com.example.facturasapi.model.Product
import com.example.facturasapi.repository.ProductRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class ProductServiceTest {

  @InjectMocks
  lateinit var productService: ProductService

  @Mock
  lateinit var productRepository: ProductRepository

  var productMock = Product().apply {
    id = 1
    description = "MCB-2508"
    brand = "David Bermeo"
    stock = 911
  }

  @Test
  fun saveProductWhenPlateisZero() {

    Assertions.assertThrows(Exception::class.java) {
      productMock.apply { description = "0" }
      Mockito.`when`(productRepository.save(Mockito.any(Product::class.java))).thenReturn(productMock)
      productService.save(productMock)
    }

  }

  @Test
  fun savePlateWhenisSeven() {

    Assertions.assertThrows(Exception::class.java) {
      productMock.apply { description = "AAC-895" }
      Mockito.`when`(productRepository.save(Mockito.any(Product::class.java))).thenReturn(productMock)
      productService.save(productMock)
    }

  }

  @Test
  fun letterByProvince() {
    Assertions.assertThrows(Exception::class.java) {
      val patron = Regex("^a")
      productMock.apply { description = "AAC-895" }
      Mockito.`when`(productRepository.save(Mockito.any(Product::class.java))).thenReturn(productMock)
      productService.save(productMock)

    }

  }
}


