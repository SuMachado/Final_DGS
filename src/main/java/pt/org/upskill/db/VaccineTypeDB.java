//package pt.org.upskill.db;
//
//import pt.org.upskill.domain.VaccineType;
//import pt.org.upskill.repository.VaccineTypeRepository;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class VaccineTypeDB implements PersistableObject<VaccineType> {
//
//
//    @Override
//    public boolean save(Connection connection, VaccineType object) {
//        String sqlCmd;
//        sqlCmd = "select * from VaccineType where code = ?";
//        try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
//            ps.setInt(1, object.code());
//            try (ResultSet rs = ps.executeQuery()) {
//                if (rs.next()) {
//                    sqlCmd = "update VaccineType set shortdescription = ?, vaccinetech_id = ? where code = ?";
//                } else {
//                    sqlCmd = "insert into VaccineType(shortdescription, vaccinetech_id, code) values (?, ?, ?)";
//                }
//                //
//                try (PreparedStatement ps2 = connection.prepareStatement(sqlCmd)) {
//                    ps2.setString(1, object.shortDescription());
//                    ps2.setInt(2, object.vaccineTech().getId());
//                    ps2.setInt(3, object.code());
//                    ps2.executeUpdate();
//                    return true;
//                }
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(VaccineTypeDB.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
//    }
//
//
//    @Override
//    public boolean delete(Connection connection, VaccineType object) {
//        try {
//            String sqlCmd;
//            sqlCmd = "delete from VaccineType where code = ?";
//            try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
//                ps.setInt(1, object.code());
//                ps.executeUpdate();
//                return true;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(VaccineTypeDB.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
//    }
//
//    @Override
//    public VaccineType getById(Connection connection, int id) {
//        try {
//            String sqlCmd;
//            sqlCmd = "select * from VaccineType where code = ?";
//            try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
//                ps.setInt(1, id);
//                ResultSet rs = ps.executeQuery();
//                if (rs.next()) {
//                    VaccineType vaccineType = null;
//                    try {
//                        vaccineType = new VaccineType.Builder()
//                                .withCode(rs.getInt("code"))
//                                .withShortDescription(rs.getString("shortdescription"))
//                                //.withVaccineTech(rs.getInt("vaccinetech_id"));
//                                .build();
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    return vaccineType;
//                }
//                return null;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(VaccineTypeDB.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
//    }
//
//}