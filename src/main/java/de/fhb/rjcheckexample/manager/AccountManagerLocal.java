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
import javax.ejb.Local;

/**
 * Local Interface that have to be implemented of every Manager which is
 * interacting with accounts.
 *
 * @author Michael Koppen <michael.koppen@googlemail.com>
 */
@Local
public interface AccountManagerLocal {

	/**
	 * This method finds an account by its mail-adress
	 */
	Account getAccount(String mail);
}
