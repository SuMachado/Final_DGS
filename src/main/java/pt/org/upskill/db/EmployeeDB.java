package pt.org.upskill.db;

import pt.org.upskill.auth.Email;
import pt.org.upskill.domain.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDB implements PersistableObject<Employee> {


    @Override
    public boolean save(Connection connection, Employee object) {
        String sqlCmd;
        sqlCmd = "select * from Employee where name = ?";
        try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
            ps.setString(1, object.getName());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    sqlCmd = "update Employee set name = ?";
                } else {
                    sqlCmd = "insert into Employee(employeeID, name, phone, address, birthdate, EmergencyContact, Role, Email, CitizenCardNumber) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                }
                //
                try (PreparedStatement ps2 = connection.prepareStatement(sqlCmd)) {
                    ps2.setInt(1, object.getEmployeeID());
                    ps2.setString(2, object.getName());
                    ps2.setInt(3, object.getPhone());
                    ps2.setString(4, object.getAddress());
                    ps2.setString(5, object.getBirthdate());
                    ps2.setString(6, object.getEmergencyContact());
                    ps2.setString(7, object.getRole().name());
                    ps2.setString(8, object.getEmail().getAddressEmail());
                    ps2.setString(9, object.getCitizenCardNumber());
                    ps2.executeUpdate();
                    //connection.commit();

                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(Connection connection, Employee object) {
        try {
            String sqlCmd;
            sqlCmd = "delete from Employee where id = ?";
            try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
                ps.setString(1, object.getName());
                ps.setInt(2, object.getPhone());
                ps.setString(3, object.getAddress());
                ps.setString(4, object.getBirthdate());
                ps.setString(5, object.getEmergencyContact());
                ps.setString(6, object.getRole().name()); //vai tar male
                ps.setString(7, object.getEmail().getAddressEmail());
                ps.setString(8, object.getCitizenCardNumber());
                ps.setInt(9, object.getEmployeeID());

                ps.executeUpdate();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Employee getById(Connection connection, int employeeID) {
        try {
            String sqlCmd;
            sqlCmd = "select * from Employee where id = ?";
            try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
                ps.setInt(1, employeeID);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    Employee employee = null;
                    try {
                        employee = new Employee.Builder()
                                .withEmployeeID(rs.getInt("employeeID"))
                                .withName(rs.getString("name"))
                                .withPhone(rs.getInt(rs.getInt("phoneNumber")))
                                .withAddress(rs.getString("address"))
                                .withBirthdate(rs.getString("birthdate"))
                                .withEmergencyContact(rs.getString("emergencyContact"))
                                .withRole(Employee.Role.valueOf(rs.getString("role")))
                                .withEmail(new Email(rs.getString("email")))
                                .withCitizenCardNumber(rs.getString("citizenCardNumber"))
                                .build();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return employee;
                }
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
