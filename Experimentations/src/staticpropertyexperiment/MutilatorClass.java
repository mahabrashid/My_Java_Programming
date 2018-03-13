package staticpropertyexperiment;

/*
 * This is a mutilator class that will modify the static attribute in Utility class
 */
public class MutilatorClass {

	public MutilatorClass() {
		// modifying the static attribute in Utility class
	UtilityClass.anInteger = 100;
	System.out.println("in MutilatorClass UtilityClass.anInteger: " + UtilityClass.anInteger);
	}
}
