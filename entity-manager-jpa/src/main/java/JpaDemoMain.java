import jakarta.persistence.EntityManager;

public class JpaDemoMain {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();

        try{
            UserClassHibernate user = new UserClassHibernate("virat");
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            System.out.println("user saved :" + user.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            JPAUtil.close();
        }
    }
}
