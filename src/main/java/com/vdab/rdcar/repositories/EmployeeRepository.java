package com.vdab.rdcar.repositories;

import com.vdab.rdcar.domain.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Employee> getEmployee() {
        TypedQuery<Employee> employees = entityManager.createQuery("select e from Employee e",Employee.class);
        return employees.getResultList();
    }

    @Transactional(rollbackOn = Exception.class)
    public void saveEmployee(Employee newEmployee) {
        entityManager.persist(newEmployee);
    }

    public Employee findByID(long id) {
      return entityManager.find(Employee.class, id);
    }
    @Transactional
    public void updateEmployee(Employee employee) {
        entityManager.merge(employee);
    }
    @Transactional
    public void removeEmployee(long id) {
        Employee employee = findByID(id);
        entityManager.remove(employee);
    }
}
