package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentService {
	
	private DepartmentDao dao = DaoFactory.createDepartmentDao(); /*criada uma f�rica(factory) para injetar a depend�ncia usando o padr�o factory de forma a retornar o valor mockado substitu�do pelo dao */

	public List<Department> findAll() {
		return dao.findAll();
	}

}

