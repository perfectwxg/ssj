package com.xianguang.dao.impl;

import com.xianguang.dao.IProductDao;
import com.xianguang.domian.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class ProductDaoImpl implements IProductDao {

	// @Autowired 不能使用这个注入
	@PersistenceContext // 持久层上下文管理器
	private EntityManager entityManager;

	@Override
	public void save(Product product) {
		entityManager.persist(product);
	}

	@Override
	public void update(Product product) {
		entityManager.merge(product);
	}

	@Override
	public void delete(Long id) {
		Product product = get(id);
		if (product != null) {
			entityManager.remove(product);
		}
	}

	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public Product get(Long id) {
		return entityManager.find(Product.class, id);
	}

	@Override
	@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
	public List<Product> getAll() {
		String jpql = "select o from Product o";
		return entityManager.createQuery(jpql).getResultList();
	}

}