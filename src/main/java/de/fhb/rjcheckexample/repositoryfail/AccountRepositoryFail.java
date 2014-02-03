/*
 * Copyright (C) 2013 Michael Koppen
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.fhb.rjcheckexample.repositoryfail;

import de.fhb.rjcheckexample.entity.Account;
import de.fhb.rjcheckexample.manager.AccountManagerLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

/**
 * This class provides specialized methods for database operations related to
 * Accounts.
 *
 * @author Michael Koppen <michael.koppen@googlemail.com>
 */
@Stateless
public class AccountRepositoryFail extends AbstractRepositoryFail<Account> {

	@PersistenceContext(unitName = "RJCheckExamplePU")
	private EntityManager em;
	@EJB
	private AccountManagerLocal accManager;

	public AccountRepositoryFail() {
		super(Account.class);
	}

	@PostConstruct
	private void init() {
	}

	@Override
	public EntityManager getEntityManager() {
		return em;
	}

	@Override
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	/**
	 * This method offers the ability to find accounts with thier username
	 * attribute. This method can provoke a {@link NonUniqueResultException} or
	 * a {@link NoResultException} which are for now handled in this method.
	 *
	 * @param username the username the user belongs to
	 * @return the account with the given username
	 */
	public Account findAccountByUsername(String username) {
		Account acc = null;

		//TODO may handle exceptions in the next higher layer.
		try {
			acc = (Account) em.createNamedQuery("Account.findByUsername").setParameter("username", username).getSingleResult();
		} catch (NonUniqueResultException | NoResultException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Exception: " + e.getMessage(), e);
		}
		return acc;
	}
}
