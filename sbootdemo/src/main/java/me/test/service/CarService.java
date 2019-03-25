package me.test.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.test.domain.CarDao;
import me.test.domain.CarDaoImpl;
import me.test.entity.Car;

@Service
public class CarService {
	Logger log=Logger.getLogger(CarService.class);
	
	@Autowired
	CarDao carDao;
	
	@Autowired
	CarDaoImpl carDaoImpl;
	
	public List<Car> findAll(){
		return carDao.findAll();
	}
	
	public void saveCar(Car car){
		carDao.save(car);
	}
	
	public void deleteCar(int id){
		carDao.delete(id);
	}
	
	public Car findCarById(int id){
		Car car=carDao.findOne(id);
		return car;
	}
	
	public List<Car> findByPrice(double price){
		return carDao.findByPrice(price);
	}
	
	public List<Car> findCarByIdAndPrice(int id,double price){
		return carDao.findByIdAndPrice(id, price);
	}
	
	public List<Car> findCarByColorOrPrice(String color,double price){
		return carDao.findByColorOrPrice(color, price);
	}
	
	public List<Car> findCarByPrice(double price){
		return carDao.findByPriceLessThan(price);
	}
	
	public List<Car> findByColorLike(String color){
		return carDao.findByColorLike(color);
	}
	
	public List<Car> findByTypeNameLike(String typeName){
		return carDao.findByTypeNameLike(typeName);
	}
	
	public Long countCar(String typeName){
		Car p=new Car();
		p.setTypeName(typeName);
		return (Long) carDaoImpl.getPage(p).get("count");
	}
}
