package dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Employees;
import model.Jobs;
import util.HibernateUtil;

public class EmployeeDao {

	private static SessionFactory sessionFactory;

	public EmployeeDao() {
		// TODO Auto-generated constructor stub
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	public List<Employees> getList() {
		Session session = sessionFactory.openSession();
		List<Employees> result = session.createQuery("FROM Employees e ORDER BY e.employeeId desc", Employees.class).list();
		return result;
	}

	public List<Employees> getFindSalary(BigDecimal salary) {
		Session session = sessionFactory.openSession();
		String hql = "FROM Employees WHERE salary > :salary";
		Query query = session.createQuery(hql, Employees.class);
		query.setParameter("salary", salary);
		List<Employees> result = query.list();
		return result;
	}
	
	public Jobs getJobs(String jobTitle) {
		Session session = sessionFactory.openSession();
		String hql = "FROM Jobs WHERE jobId > :jId";
		Query query = session.createQuery(hql, Jobs.class);
		query.setParameter("jId", jobTitle);
		Jobs result = (Jobs) query.getSingleResult();
		return result;
	}

	public void insertNewData(Employees emp) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();
		session.close();
	}

	public void updateData(Employees emp) {
		Session session = sessionFactory.openSession();
		String hql = "UPDATE Employees SET lastName = :lName WHERE employeeId = :empId";
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setString("lName", emp.getLastName());
		query.setInteger("empId", emp.getEmployeeId());
		int n = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}

	public void deleteData(int id) {
		Session session = sessionFactory.openSession();
		String hql = "DELETE FROM Employees WHERE employeeId = :empId";
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter("empId", id);
		int n = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}
}
