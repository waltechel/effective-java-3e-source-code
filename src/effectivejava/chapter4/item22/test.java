package effectivejava.chapter4.item22;

// import static effectivejava.chapter4.item22.constantutilityclass.PhysicalConstants.* 별도 안된다.
import static effectivejava.chapter4.item22.constantutilityclass.PhysicalConstants.AVOGADROS_NUMBER;

import effectivejava.chapter4.item22.constantutilityclass.PhysicalConstants;

public class test {

	double atoms(double mols) {
		return PhysicalConstants.AVOGADROS_NUMBER * mols;
	}
	
	double atomsGood(double mols) {
		return AVOGADROS_NUMBER * mols;
	}
}
