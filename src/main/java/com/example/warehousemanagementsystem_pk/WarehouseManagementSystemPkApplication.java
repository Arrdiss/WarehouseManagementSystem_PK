package com.example.warehousemanagementsystem_pk;

import org.hibernate.cfg.AvailableSettings;
import org.hibernate.tool.schema.Action;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.hibernate.cfg.Configuration;
import static java.lang.System.out;
		;

@SpringBootApplication
public class WarehouseManagementSystemPkApplication {

	public static void main(String[] args) {
		var sessionFactory = new Configuration()
				.addAnnotatedClass(Product.class)
				// MariaDB
				.setProperty(AvailableSettings.JAKARTA_JDBC_URL, "jdbc:mariadb://localhost:3306/warehouse")
				// Credentials
				.setProperty(AvailableSettings.JAKARTA_JDBC_USER, "root")
				.setProperty(AvailableSettings.JAKARTA_JDBC_PASSWORD, "password")
				// Automatic schema export
				.setProperty(AvailableSettings.JAKARTA_HBM2DDL_DATABASE_ACTION,
						Action.SPEC_ACTION_DROP)
				.buildSessionFactory();

		// export the inferred database schema
		sessionFactory.getSchemaManager().exportMappedObjects(true);

		// persist an entity
		sessionFactory.inTransaction(session -> {
			session.persist(new Product("OIL001", "Synthetic oli 10W-40", 10, Category.Oils));
		});

		// query data using HQL
		sessionFactory.inSession(session -> {
			out.println(session.createSelectionQuery("select productName||': '||amount from Product").getSingleResult());
		});

//		SpringApplication.run(WarehouseManagementSystemPkApplication.class, args);
	}
}
