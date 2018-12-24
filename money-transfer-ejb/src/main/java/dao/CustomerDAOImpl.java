package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.fsusam.tutorial.jar.money.transfer.ejb.dao.CustomerDAO;
import com.fsusam.tutorial.jar.money.transfer.ejb.model.Account;
import com.fsusam.tutorial.jar.money.transfer.ejb.model.Customer;

@Stateless
public class CustomerDAOImpl implements CustomerDAO {
    @PersistenceContext(unitName = "persistenceUnit")
    private EntityManager em;

    @Override
    public void addCustomer(final Customer customer) {
        em.persist(customer);
    }

    @Override
    public void addAccount(final Account account) {
        em.persist(account);
    }

    @Override
    public List<Account> findAccountByIban(final String iban) {
        final Query query = em.createQuery("SELECT a FROM Account a Where a.iban = :iban");
        query.setParameter("iban", iban);
        return (List<Account>) query.getResultList();
    }

    @Override
    public void updateAccount(final Account account) {
        em.merge(account);
    }

    @Override
    public List<Customer> findAllCustomers() {
        final Query query = em.createQuery("SELECT c FROM Customer c");
        return (List<Customer>) query.getResultList();
    }
}
