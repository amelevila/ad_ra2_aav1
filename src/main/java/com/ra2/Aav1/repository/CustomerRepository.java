package com.ra2.Aav1.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ra2.Aav1.model.Customer;

@Repository
 public class CustomerRepository {
	 @Autowired
	 public JdbcTemplate jdbctemp;
	 
	 //CustomerRowMapper passa les dades de la BD a un objecte Customer
	 private static final class CustomerRowMapper implements RowMapper<Customer> {
		 @Override
		 public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			 Customer customer = new Customer();
			 customer.setId(rs.getLong("id"));
			 customer.setFirstName(rs.getString("firstName"));
			 customer.setLastName(rs.getString("lastName"));
			 customer.setAge(rs.getInt("age"));
			 customer.setYear(rs.getInt("yyear")); //year s'utilitza en SQL
			 customer.setCicle(rs.getString("cicle"));
			 return customer;
		 }
	 }
	 
	 //Crear taula Customers
	 public void createTableCustomers() {
		 jdbctemp.execute("DROP TABLE customers IF EXISTS");
		 jdbctemp.execute(
		 	"CREATE TABLE customers ("
		 	+ "id SERIAL,"
		 	+ "firstName VARCHAR(255),"
		 	+ "lastName VARCHAR(255),"
		 	+ "age TINYINT,"
		 	+ "yyear SMALLINT,"
		 	+ "cicle VARCHAR(255))"
		 );
	 }
	 
	 //insert de les dades quan executem el projecte
	 public void insertSampleData() {
		 jdbctemp.update(
		 	"INSERT INTO customers "
		 	+ "(firstName, lastName, age, yyear, cicle) "
		 	+ "VALUES (?, ?, ?, ?, ?)"
		 	, "John", "Doe", 24, 2025, "DAM"
		 );
		 jdbctemp.update(
			"INSERT INTO customers "
			+ "(firstName, lastName, age, yyear, cicle) "
			+ "VALUES (?, ?, ?, ?, ?)"
			, "Jane", "Smith", 19, 2025, "DAW"
		 );
		 jdbctemp.update(
			"INSERT INTO customers "
			+ "(firstName, lastName, age, yyear, cicle) "
			+ "VALUES (?, ?, ?, ?, ?)"
			, "Bob", "Johnson", 32, 2025, "ASIX"
		 );		 
	 }
	 
	 //Retornar les dades de tots els registres de customers la BD
	 public List<Customer> findAll() {
		 return jdbctemp.query(
				 "SELECT id, firstName, lastName, age, yyear, cicle "
				 + "from customers",
				 new CustomerRowMapper()
		 );
	 }
 }
 