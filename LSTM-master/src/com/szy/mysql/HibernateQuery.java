package com.szy.mysql;

import java.util.ArrayList;
import java.util.List;

import com.szy.entity.Data;
import com.szy.utils.HibernateUtils;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateQuery {
	@SuppressWarnings("unchecked")
	public List<Double> testAdd1() {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		List<Double> list_data = new ArrayList<>();
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = HibernateUtils.getSessionobject();
			tx = session.beginTransaction();
			SQLQuery sqlQuery = session.createSQLQuery("select * from t_data");
			sqlQuery.addEntity(Data.class);
			List<Data> list = sqlQuery.list();
			/*
			 * for (Data data : list) { System.out.println(data); }
			 */
			for (Data data : list) {
				list_data.add((double) data.getD_data());
			}

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			// sessionFactory.close();
		}
		return list_data;
	}
}
