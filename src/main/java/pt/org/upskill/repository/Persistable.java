package pt.org.upskill.repository;

import java.sql.SQLException;

/**
 * @author Nuno Castro anc@isep.ipp.pt
 */

public interface Persistable {
    boolean save(Object object) throws SQLException;;
    boolean delete(Object object) throws SQLException;
}
