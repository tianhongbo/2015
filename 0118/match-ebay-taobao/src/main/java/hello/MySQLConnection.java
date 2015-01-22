package hello;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Component;


public class MySQLConnection {
	

	public JdbcTemplate getMySQLConnection() throws SQLException {
		
		
		SimpleDriverDataSource datasource = new SimpleDriverDataSource();
		datasource.setDriver(new com.mysql.jdbc.Driver());
		datasource.setUrl("jdbc:mysql://localhost/contactdb");
		datasource.setUsername("root");
		datasource.setPassword("root");
		
		// Instantiate a JdbcTemplate object
		JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
		
		return jdbcTemplate;
	}
}


