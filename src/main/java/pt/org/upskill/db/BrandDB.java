//package pt.org.upskill.db;
//
//import pt.org.upskill.repository.BrandRepository;
//
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class BrandDB implements PersistableObject<Brand> {
//    @Override
//    public boolean save(Connection connection, Brand object) {
//        String sqlCmd;
//        sqlCmd = "select * from Brand where name = ?";
//        try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
//            ps.setString(1, object.name());
//            try (ResultSet rs = ps.executeQuery()) {
//                if (rs.next()) {
//                    sqlCmd = "update Brand set name = name where name = ?";
//                }
//                else {
//                    sqlCmd = "insert into Brand(name) values (?)";
//                }
//                //
//                try (PreparedStatement ps2 = connection.prepareStatement(sqlCmd)) {
//                    ps2.setString(1, object.name());
//                    ps2.executeUpdate();
//                    return true;
//                }
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(BrandDB.class.getName()).log(Level.SEVERE, null, ex);
//            return true;
//        }
//    }
//
//    @Override
//    public boolean delete(Connection connection, Brand object) {
//        try {
//            String sqlCmd;
//            sqlCmd = "delete from Brand where name = ?";
//            try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
//                ps.setString(1, object.name());
//                ps.executeUpdate();
//                return true;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(BrandDB.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
//    }
//
//    @Override
//    public Brand getById(Connection connection, int id) {
//        try{
//            String sqlCmd;
//            sqlCmd = "select * from Brand where id = ?";
//            try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
//                ps.setInt(1, id);
//                ResultSet rs = ps.executeQuery();
//                if (rs.next()) {
//                    Brand brand = null;
//                    try{
//                        brand = new Brand.Builder()
//                                .withBrandID(rs.getInt("id"))
//                                .withName(rs.getString("name"))
//                                .build();
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }
//                    return brand;
//                }
//                return null;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(BrandDB.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
//    }
//
//}