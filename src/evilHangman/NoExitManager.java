package evilHangman;

import java.security.Permission;

/**
 * 
 */

/**
 * @author Anne
 * Code Referenced code written by TofuBeer on StackOverflow on May 26, 2011
 * http://stackoverflow.com/questions/6141252/dealing-with-system-exit0-in-junit-tests
 *
 *This code is used in testing. 
 *It makes sure that the code does not actually exit during the tests.
 *
 */
public class NoExitManager extends SecurityManager {
	       
	@SuppressWarnings("unused")
	private final SecurityManager parent;

	/**
	 * Takes in the current Security Manager to modify
	 * @param manager
	 */
    public NoExitManager(SecurityManager manager){
        parent = manager;
    }
    
	@Override
    public void checkExit(int status) {
        throw new SecurityException("Overriding shutdown for test");
    }

	@Override
	public void checkPermission(Permission perm){
		//to make the security check not check anything
		//So code can change the security as needed
		//THIS IS NOT SECURE
	}
}
