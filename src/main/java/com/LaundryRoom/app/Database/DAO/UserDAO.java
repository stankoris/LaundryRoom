package com.LaundryRoom.app.Database.DAO;


import com.LaundryRoom.app.Database.Connection.JDBIManager;
import com.LaundryRoom.app.Models.Laundry;
import com.LaundryRoom.app.Models.User;
import com.google.common.hash.Hashing;
import org.jdbi.v3.core.Jdbi;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class UserDAO {
    public static User for_username(String username) throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        return jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM users WHERE username = :username;")
                    .bind("username", username)
                    .mapToBean(User.class)
                    .findFirst().orElse(null);
        });
    }
    public static ArrayList<User> all() throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        return (ArrayList<User>) jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM `users`;")
                    .mapToBean(User.class)
                    .list();
        });
    }
    public static int save(String username, String password) throws FileNotFoundException {
        final String employee = "employee";
        Jdbi jdbi = JDBIManager.get();
        jdbi.useHandle(handle -> {
            handle.createUpdate("INSERT INTO users VALUES (NULL, :username, :password, :employee);")
                    .bind("username", username)
                    .bind("password", password)
                    .bind("employee", employee)
                    .execute();
        });
        return jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM users ORDER BY user_id DESC LIMIT 1")
                    .mapToBean(User.class)
                    .one().getUser_id();
        });
    }
    public static User get(int user_id) throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        return jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM users WHERE user_id = :user_id")
                    .bind("user_id", user_id)
                    .mapToBean(User.class)
                    .one();
        });
    }
    public static void delete(int user_id) throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        jdbi.useHandle(handle -> {
            handle.createUpdate("DELETE FROM users WHERE user_id = :user_id")
                    .bind("user_id", user_id)
                    .execute();
        });
    }
    public static void update(User user) throws FileNotFoundException {
        Jdbi jdbi = JDBIManager.get();
        jdbi.useHandle(handle -> {
            handle.createUpdate("""
                            UPDATE users SET
                            username = :username,
                            password = :password,
                            user_type = :user_type
                            WHERE user_id = :user_id;
                            """)
                    .bindBean(user)
                    .execute();
        });
    }
}
