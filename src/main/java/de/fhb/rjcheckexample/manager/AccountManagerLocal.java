/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.rjcheckexample.manager;

import de.fhb.rjcheckexample.entity.Account;
import javax.ejb.Local;

/**
 *
 * @author MacYser
 */
@Local
public interface AccountManagerLocal {

	Account getAccount(String mail);
}
