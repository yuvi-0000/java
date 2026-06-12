import org.hibernate.Session;

public class HibernateDemoMain {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();

        try{
            UserClassHibernate user = new UserClassHibernate("virat");
            session.beginTransaction();
            session.persist(user); // save(user)
            session.getTransaction().commit();
            System.out.println("user saved :" + user.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil. close();
        }
    }
}
