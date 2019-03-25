package me.test.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.test.entity.Car;
import me.test.service.CarService;

@Controller
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@RequestMapping("/showAll")
	@ResponseBody
	public List<Car> listCars(){
		List<Car> cars=carService.findAll();
		
		System.out.println(cars.get(0).getDriver().get(0).getCity().getCityName());
		return cars;
	}
	
	@RequestMapping("/addCar")
	@ResponseBody
	public String insertCar(HttpServletRequest request){
		String color=request.getParameter("color");
		String price=request.getParameter("price");
		Car car=new Car();
		car.setColor(color);
		car.setPrice(Double.parseDouble(price));
		String msg="操作失败";
		try {
			carService.saveCar(car);
			msg="操作完毕";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return msg;
	}
	
	@RequestMapping("/findCarByID")
	@ResponseBody
	public Car getCar(HttpServletRequest request){
		String id=request.getParameter("id");
		Car car=carService.findCarById(Integer.parseInt(id));
		return car;
	}
	
	@RequestMapping("/findCarByPrice")
	@ResponseBody
	public List<Car> getByPrice(HttpServletRequest request){
		String price=request.getParameter("price");
		return carService.findByPrice(Double.parseDouble(price));
	}
	
	
	@RequestMapping("/findCarByIdAndPrice")
	@ResponseBody
	public List<Car> findCarByIdAndPrice(HttpServletRequest request){
		String id=request.getParameter("id");
		String price=request.getParameter("price");
		return carService.findCarByIdAndPrice(Integer.parseInt(id), Double.parseDouble(price));
	}
	
	
	@RequestMapping("/findCarByColorOrPrice")
	@ResponseBody
	public List<Car> findCarByColorOrPrice(HttpServletRequest request){
		String color=request.getParameter("color");
		String price=request.getParameter("price");
		return carService.findCarByColorOrPrice(color, Double.parseDouble(price));
	}
	
	
	@RequestMapping("/findCarByPriceless")
	@ResponseBody
	public List<Car> findCarByPrice(HttpServletRequest request){
		String price=request.getParameter("price");
		return carService.findCarByPrice(Double.parseDouble(price));
	}
	
	
	@RequestMapping("/findByColorLike")
	@ResponseBody
	public List<Car> findByColorLike(HttpServletRequest request){
		String typeName=request.getParameter("typeName");
		System.out.println(typeName);
		return carService.findByColorLike(typeName);
	}
	@RequestMapping("/findByTypeNameLike")
	@ResponseBody
	public List<Car> findByTypeNameLike(HttpServletRequest request){
		String typeName=request.getParameter("typeName");
		System.out.println(typeName);
		return carService.findByTypeNameLike(typeName);
	}
	
	@RequestMapping("/count")
	@ResponseBody
	public long count(HttpServletRequest request){
		String typeName=request.getParameter("typeName");
		long n=carService.countCar(typeName);
		return n;
	}
}
