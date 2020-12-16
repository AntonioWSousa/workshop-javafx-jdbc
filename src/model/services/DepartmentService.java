package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentService {
	
	private DepartmentDao dao = DaoFactory.createDepartmentDao(); /*criada uma fárica(factory) para injetar a dependência usando o padrão factory de forma a retornar o valor mockado substituído pelo dao */

	public List<Department> findAll() {
		return dao.findAll();
	}

}

