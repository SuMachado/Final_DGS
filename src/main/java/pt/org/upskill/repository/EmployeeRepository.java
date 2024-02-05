package pt.org.upskill.repository;

import pt.org.upskill.db.ConnectionEmployee;
import pt.org.upskill.db.ConnectionFactory;
import pt.org.upskill.db.DatabaseConnection;
import pt.org.upskill.db.EmployeeDB;
import pt.org.upskill.domain.Employee;
import pt.org.upskill.dto.DTO;
import pt.org.upskill.dto.EmployeeDTO;
import pt.org.upskill.dto.KeyValueDTO;
import pt.org.upskill.session.Context;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements Persistable{
    private Connection conn;

    private List<Employee> employeeList = new ArrayList<Employee>();

    public EmployeeRepository() {}

    public int nextId() {
        int maxId = 0;
        for (Employee employee : employeeList) {
            if (employee.getEmployeeID() > maxId) {
                maxId = employee.getEmployeeID();
            };
        }
        return maxId+1;
    }
    public Employee getById(int employeeID) {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeID() == employeeID) {
                return employee;
            };
        }
        return null;
    }
    private Boolean validateSave(Employee employee) {
        return true;
    }

    private Boolean validateDelete(Employee employee) {
        return true;
    }

    public Employee createEmployee(DTO dto) throws Exception {
        EmployeeDTO employeeDTO = (EmployeeDTO) dto;
        return new Employee.Builder()
                .withEmployeeID(employeeDTO.getEmployeeID())
                .withName(employeeDTO.getName())
                .withPhone((employeeDTO.getPhoneDTO()))
                .withAddress(employeeDTO.getAddressDTO())
                .withBirthdate(employeeDTO.getBirthdateDTO())
                .withEmergencyContact(employeeDTO.getEmergencyContactDTO())
                .withRole(employeeDTO.getRoleDTO())
                .withEmail(employeeDTO.getEmailDTO())
                .withCitizenCardNumber(employeeDTO.getCitizenCardNumberDTO())
                .build();
    }


    @Override
    public boolean save(Object object) {
        ConnectionEmployee ce = Context.getConnectionEmployee();
        DatabaseConnection dbc = ce.getDatabaseConnection();
        Connection conn = dbc.getConnection();
        //
        try {
            conn.setAutoCommit(false);
            //
            EmployeeDB employeeDB = new EmployeeDB();
            employeeDB.save(conn, (Employee) object);
            //
            conn.commit();
            return true;
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        }
    }


    @Override
    public boolean delete(Object object) {
        /*Facility facility = (Facility) object;
        //Version without database persistence
        if (validateDelete(facility)) {
            facilityList.remove(facility);
        }
        return false;
         */
        ConnectionEmployee ce = Context.getConnectionEmployee();
        DatabaseConnection dbc = ce.getDatabaseConnection();
        Connection conn = dbc.getConnection();
        //
        try {
            conn.setAutoCommit(false);
            //
            EmployeeDB employeeDB = new EmployeeDB();
            employeeDB.delete(conn, (Employee) object);
            //
            conn.commit();
            return true;
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        }
    }

    public List<Employee> employeeList() {
        return employeeList;
    }


    public List<KeyValueDTO> keyValueDTOList() {
        List<KeyValueDTO> dtoList = new ArrayList<>();
        for (Employee item : employeeList()) {
            EmployeeDTO dto = item.toDTO();
            dtoList.add(new KeyValueDTO(dto.getEmployeeID(), dto.getName()));
        }
        return dtoList;
    }



//              .withEmployeeID(rs.getInt("employeeID"))
//                                .withName(rs.getString("name"))
//                                .withPhone(rs.getInt(rs.getInt("phoneNumber")))
//                                .withAddress(rs.getString("adress"))
//                                .withBirthdate(rs.getString("birthdate"))
//                                .withEmergencyContact(rs.getString("emergencyContact"))
//                                .withRole(Employee.Role.valueOf(rs.getString("role")))
//                                .withEmail(new Email(rs.getString("email")))
//                                .withCitizenCardNumber(rs.getString("citizenCardNumber"))




    /*public List<Employee> employeeList = new ArrayList<>();

    public EmployeeRepository() {}

    public Employee createEmployee(String name, int phone, String address, String birthdate, String emergencyContact, Email email, Employee.Role role, String citizenCardNumber){
        return new Employee(name, phone, address, birthdate, emergencyContact, email, role, citizenCardNumber);
    }

    private Boolean validateSave(Object object) {
        return true;
    }

    private Boolean validateDelete(Object object) {
        return true;
    }

    @Override
    public boolean save(Object object) {
        return false;
    }

    @Override
    public boolean delete(Object object) {
        return false;
    }
    public List<EmployeeDTO> listEmployeesByRole(Employee.Role role) {
        List<Employee> newEmployeeList = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getRole().equals(role)) {
                newEmployeeList.add(employee);
            }
        }
        return listEmployeesDtobyRole(newEmployeeList);
    }

    public List<EmployeeDTO>listEmployeesDtobyRole(List <Employee> employeeList) {
        List <EmployeeDTO> employeeDTOList = new ArrayList<>();
        EmployeeDTO employeeDto = new EmployeeDTO();
        for (Employee employee : employeeList) {
            employeeDto.email=employee.email();
            employeeDto.name=employee.name();
            employeeDto.role=employee.role();
            employeeDto.phone=employee.phone();
            employeeDto.citizenCardNumber=employee.citizenCardNumber();
            employeeDTOList.add((employeeDto));
        }
        return employeeDTOList;

    }
*/
}
