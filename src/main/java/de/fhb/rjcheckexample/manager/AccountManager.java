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
package de.fhb.rjcheckexample.manager;

import de.fhb.rjcheckexample.entity.Account;
import de.fhb.rjcheckexample.repository.AccountRepository;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 * This class provides all business operations on accounts.
 *
 * @author Michael Koppen <michael.koppen@googlemail.com>
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AccountManager implements AccountManagerLocal {

	@EJB
	private AccountRepository accountRepository;

	public AccountManager() {
	}

	@PostConstruct
	private void init() {
	}

	@Override
	public Account getAccount(String mail) {
		return accountRepository.find(mail);
	}
}
