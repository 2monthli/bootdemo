package me.test.domain;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import me.test.entity.Car;

public class CarDaoImpl {
	@PersistenceContext
    private EntityManager em;
	
    public Map<String,Object> getPage(Car param){
    	String dataSql = "select t from Car t where 1 = 1";
    	String countSql = "select count(t) from Car t where 1 = 1";
    	Map<String,Object> map=new HashMap<>();
    	dataSql=dataSql.concat(" and typeName=?1");
    	countSql=countSql.concat(" and typeName=?1");
    	Query dataQuery = em.createQuery(dataSql);
    	Query countQuery = em.createQuery(countSql);
    	dataQuery.setParameter(1, param.getTypeName());
    	countQuery.setParameter(1, param.getTypeName());
    	map.put("data", dataQuery.getResultList());
    	map.put("count", countQuery.getSingleResult());
    	return map;
    }
}
