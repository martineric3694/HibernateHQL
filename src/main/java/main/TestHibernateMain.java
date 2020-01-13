package main;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import dao.EmployeeDao;
import model.Employees;
import model.Jobs;

public class TestHibernateMain {

	public static void main(String[] args) {
		EmployeeDao empDao = new EmployeeDao();
		
//		List<Employees> result = empDao.getFindSalary(new BigDecimal(3000));
		
		Employees emp1 = new Employees();
		
		emp1.setEmployeeId(999);
		emp1.setLastName("AdIns");
		emp1.setEmail("ad-ins");
		emp1.setHireDate(new Date());
//		emp1.setJobs(job1);
		
		System.out.println(empDao.getJobs("IT_PROG"));
		
//		empDao.insertNewData(emp1);
		
		List<Employees> result = empDao.getList();
		System.out.println(result.size());
		
		for(Employees emp : result) {
			System.out.println(emp.getEmployeeId()+" "+emp.getFirstName()+" "+emp.getLastName());
		}
	}
}
