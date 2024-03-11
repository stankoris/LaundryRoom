package com.LaundryRoom.app.Database.DAO;

import com.LaundryRoom.app.Database.Connection.JDBIManager;
import com.LaundryRoom.app.Models.Laundry;
import org.jdbi.v3.core.Jdbi;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class LaundryDAO {
    public static ArrayList<Laundry> all() throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        return (ArrayList<Laundry>) jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM `laundry`;")
                    .mapToBean(Laundry.class)
                    .list();
        });
    }
    public static int save(Laundry laundry) throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        jdbi.useHandle(handle -> {
            handle.createUpdate("INSERT INTO laundry VALUES (NULL, :name, :price);")
                    .bindBean(laundry)
                    .execute();
        });
        return jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM laundry ORDER BY laundry_id DESC LIMIT 1")
                    .mapToBean(Laundry.class)
                    .one().getLaundry_id();
        });
    }
    public static Laundry get(int laundry_id) throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        return jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM laundry WHERE laundry_id = :laundry_id")
                    .bind("laundry_id", laundry_id)
                    .mapToBean(Laundry.class)
                    .one();
        });
    }
    public static void delete(int laundry_id) throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        jdbi.useHandle(handle -> {
            handle.createUpdate("DELETE FROM laundry WHERE laundry_id = :laundry_id")
                    .bind("laundry_id", laundry_id)
                    .execute();
        });
    }
    public static void update(Laundry laundry) throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        jdbi.useHandle(handle -> {
            handle.createUpdate("""
                            UPDATE laundry SET
                            name = :name,
                            price = :price
                            WHERE laundry_id = :laundry_id;
                            """)
                    .bindBean(laundry)
                    .execute();
        });
    }
}
