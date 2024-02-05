//package pt.org.upskill.db;
//
//import pt.org.upskill.domain.VaccineTech;
//import pt.org.upskill.domain.VaccineType;
//import pt.org.upskill.repository.VaccineTechRepository;
//
//import java.sql.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class VaccineTechDB implements PersistableObject<VaccineTech> {
//
//
//    @Override
//    public boolean save(Connection connection, VaccineTech object) {
//        String sqlCmd;
//        sqlCmd = "select * from VaccineTech where id = ?";
//        try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
//            ps.setInt(1, object.getId());
//            try (ResultSet rs = ps.executeQuery()) {
//                if (rs.next()) {
//                    //sqlCmd = "update VaccineTech set name = ?, description = ? where id = ?";
//                    //sqlCmd = "update VaccineTech set id = ?";
//
//                    sqlCmd = "update VaccineTech set id = ?, name = ?, description = ? ";
//                } else {
//                    sqlCmd = "insert into VaccineTech(id, name, description) values (?, ?, ?)";
//                }
//
//
//                //sqlCmd = "insert into VaccineTech(id, name, description) values (?, ?, ?)";
//                //
//                try (PreparedStatement ps2 = connection.prepareStatement(sqlCmd)) {
//                    ps2.setInt(1, object.getId());
//                    ps2.setString(2, object.getName());
//                    ps2.setString(3, object.getDescription());
//
//                    ps2.executeUpdate();
//                    //connection.commit();
//                    return true;
//                }
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(VaccineTechDB.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
//    }
//
//    /*    @Override
//    public boolean save(Connection connection, VaccineTech object) {
//        String sqlCmd;
//        sqlCmd = "select * from VaccineTech where id = ?";
//        try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
//            if (object.getId() == 0) {
//                ps.setNull(1, Types.INTEGER);
//            } else {
//                ps.setInt(1, object.getId());
//            }
//            try (ResultSet rs = ps.executeQuery()) {
//                    sqlCmd = "insert into VaccineTech set id = ?, name = ?, description = ? ";
//                    try (PreparedStatement ps2 = connection.prepareStatement(sqlCmd)) {
//                        ps2.setInt(1, object.getId());
//                        ps2.setString(2, object.getName());
//                        ps2.setString(3, object.getDescription());
//
//                        ps2.executeUpdate();
//                        return true;
//                }
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(VaccineTechDB.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
//    }*/
//
//
//    @Override
//    public boolean delete(Connection connection, VaccineTech object) {
//        try {
//            String sqlCmd;
//            sqlCmd = "delete from VaccineTech where id = ?";
//            try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
//                ps.setInt(1, object.getId());
//                ps.executeUpdate();
//                return true;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(VaccineTechDB.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
//    }
//
//    @Override
//    public VaccineTech getById(Connection connection, int id) {
//        try {
//            String sqlCmd;
//            sqlCmd = "select * from VaccineTech where id = ?";
//            try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
//                ps.setInt(1, id);
//                ResultSet rs = ps.executeQuery();
//                if (rs.next()) {
//                    VaccineTech vaccineTech = null;
//                    try {
//                        vaccineTech = new VaccineTech.Builder()
//                                .withId(rs.getInt("id"))
//                                .withName(rs.getString("name"))
//                                .withDescription(rs.getString("description"))
//                                .build();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    return vaccineTech;
//                }
//                return null;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
//    }
//}