package com.LaundryRoom.app.Database.DAO;


import com.LaundryRoom.app.Database.Connection.JDBIManager;
import com.LaundryRoom.app.Models.Service;
import org.jdbi.v3.core.Jdbi;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ServiceDAO {
    public static ArrayList<Service> all() throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        return (ArrayList<Service>) jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM `service`;")
                    .mapToBean(Service.class)
                    .list();
        });
    }
    public static int save(Service service) throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        jdbi.useHandle(handle -> {
            handle.createUpdate("INSERT INTO service VALUES (NULL, :name, :price);")
                    .bindBean(service)
                    .execute();
        });
        return jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM laundry ORDER BY laundry_id DESC LIMIT 1")
                    .mapToBean(Service.class)
                    .one().getService_id();
        });
    }
    public static Service get(int service_id) throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        return jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM service WHERE service_id = :service_id")
                    .bind("service_id", service_id)
                    .mapToBean(Service.class)
                    .one();
        });
    }
    public static void delete(int service_id) throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        jdbi.useHandle(handle -> {
            handle.createUpdate("DELETE FROM service WHERE service_id = :service_id")
                    .bind("service_id", service_id)
                    .execute();
        });
    }
    public static void update(Service service) throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        jdbi.useHandle(handle -> {
            handle.createUpdate("""
                            UPDATE service SET
                            name = :name,
                            price = :price
                            WHERE service_id = :service_id;
                            """)
                    .bindBean(service)
                    .execute();
        });
    }
}
