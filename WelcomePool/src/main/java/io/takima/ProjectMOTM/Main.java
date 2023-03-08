package io.takima.ProjectMOTM;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
    }
}
