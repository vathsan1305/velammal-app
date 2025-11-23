package ifaces;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> { //Data Access Object 
	
	boolean add(T t) throws SQLException;
	T findById(int id) throws SQLException;
	List<T> findAll() throws SQLException;
	boolean delete(T t) throws SQLException;
	T update(T t) throws SQLException;

}
