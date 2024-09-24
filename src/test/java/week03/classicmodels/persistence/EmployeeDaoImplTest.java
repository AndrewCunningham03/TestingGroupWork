package week03.classicmodels.persistence;

import org.junit.jupiter.api.Test;
import week03.classicmodels.business.Employee;

import java.sql.SQLOutput;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDaoImplTest {

    @Test
    void getAllEmployees_Found() {
        System.out.println("Testing to find one");
        EmployeeDao empDao = new EmployeeDaoImpl();
        List<Employee> results = empDao.getAllEmployees();
        Employee actualResult = results.get(results.size()-2);;
        Employee expectedResult = new Employee(1625,"kato","Yoshimi","x102","ykato@classicmodelcars.com","5",1621,"Sales Rep");
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void getAllEmployees_AllFound() {
        EmployeeDao empDao = new EmployeeDaoImpl();
        List<Employee> results = empDao.getAllEmployees();
        assertEquals(0, results.size());
    }

    @Test
    void getById_NoMatchFound() {
        EmployeeDao empDao = new EmployeeDaoImpl();
        Employee result = empDao.getById(1);
        assertNull(result);
    }

    @Test
    void getById_MatchFound() {
        EmployeeDao empDao = new EmployeeDaoImpl();
        Employee expected = new Employee(1625, "Kato", "Yoshimi", "x102", "ykato@classicmodelcars.com", "5", 1621,
                "Sales Rep");
        Employee result = empDao.getById(1625);
        assertEmployeeEquals(expected, result);
    }

    void assertEmployeeEquals(Employee expected, Employee result){
        assertEquals(expected.getEmployeeNumber(), result.getEmployeeNumber());
        assertEquals(expected.getLastName(), result.getLastName());
        assertEquals(expected.getFirstName(), result.getFirstName());
        assertEquals(expected.getEmail(), result.getEmail());
        assertEquals(expected.getExtension(), result.getExtension());
        assertEquals(expected.getJobTitle(), result.getJobTitle());
        assertEquals(expected.getReportsTo(), result.getReportsTo());
        assertEquals(expected.getOfficeCode(), result.getOfficeCode());
    }
}