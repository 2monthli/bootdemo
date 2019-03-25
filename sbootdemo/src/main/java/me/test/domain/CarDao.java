package me.test.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import me.test.entity.Car;

public interface CarDao extends JpaRepository<Car, Integer> {
	
	List<Car> findByPrice(double price);
	
	List<Car> findByIdAndPrice(int id,double price);
	
	List<Car> findByColorOrPrice(String color,double price);
	
	List<Car> findByPriceLessThan(double price);
	
	List<Car> findByColorLike(String color);//no work
    
	/**
	 * //中文不起作用  原因  spring.datasource.url=jdbc:mysql://localhost:3306/waysdb   没有允许中文
	 * 需要改为spring.datasource.url=jdbc:mysql://localhost:3306/waysdb?useUnicode=true&characterEncoding=utf8

	 * @param typeName
	 * @return
	 */
	List<Car> findByTypeName(String typeName); 
	
	
	@Query("select u from Car u where u.typeName like %?1%")  
	List<Car> findByTypeNameLike(String typeName);//work
	
}
