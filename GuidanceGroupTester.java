/**
* Name: Riana Fazir
* Project Name: GuidanceGroupTester
*Project Description: Tester class for the arrays and methods in Guidance Group
**/

public class GuidanceGroupTester {
	public static void main(String[] args) {

		SatStudent[] one = new SatStudent[12];
		one[0] = new SatStudent("Ye", 640, 695, 686);
		one[1] = new SatStudent("Bradley", 778, 768, 780);
		one[2] = new SatStudent("Chen", 687, 614, 705);
		one[3] = new SatStudent("Davis", 620, 534, 556);
		one[4] = new SatStudent("Aarons", 550, 565, 517);
		one[5] = new SatStudent("Gupta", 687, 720, 640);
		one[6] = new SatStudent("Park", 722, 721, 745);
		one[7] = new SatStudent("Kohl", 595, 605, 615);
		one[8] = new SatStudent("Mehta", 525, 637, 521);
		one[9] = new SatStudent("Bahl", 611, 607, 610);
		one[10] = new SatStudent("Smith", 670, 703, 610);
		one[11] = new SatStudent("Issacs", 670, 690, 710);

		GuidanceGroup bryde = new GuidanceGroup(one);
		System.out.println("\nBRYDE CLASS");
		bryde.displayTotals();

		SatStudent[] two = new SatStudent[6];
		two[0] = new SatStudent("Jones", 644, 695, 696);
		two[1] = new SatStudent("Boomer", 778, 788, 780);
		two[2] = new SatStudent("Chung", 657, 612, 705);
		two[3] = new SatStudent("Addams", 627, 537, 557);
		two[4] = new SatStudent("Patel", 550, 565, 577);
		two[5] = new SatStudent("Garcia", 687, 720, 645);

		GuidanceGroup connolly = new GuidanceGroup(two);
		System.out.println("\nCONNOLLY CLASS");
		connolly.displayTotals();

		System.out.println("\nBRYDE CLASS\n(Alphabetical)");
		bryde.sortByName();
		//bryde.displayTotals();

		System.out.println("\nCONNOLLY CLASS\n(Alphabetical)");
		connolly.sortByName();
		//connolly.displayTotals();

		GuidanceGroup combined = bryde.combineGroups(connolly);
		combined.sortByName();

		System.out.println("\nALPHABETICAL LISTING\n(All Classes)");
		combined.displayTotals();

		System.out.println();
		System.out.println("LOWEST STUDENT TOTAL: " + combined.getMin());
		System.out.println("HIGHEST STUDENT TOTAL: " + combined.getMax());
		System.out.println("AVERAGE STUDENT TOTAL: " + combined.average());
		System.out.println();

		System.out.println("STUDENTS BELOW 1700");
		System.out.println("===================");
		combined.below1700List();

		System.out.println();
		System.out.println("STUDENTS ABOVE 2000");
		System.out.println("==================");
		combined.above2000List();

		System.out.println();
		String name = "Park";
		System.out.println("SCORE FOR: " + name + " - "
				+ combined.getStudentScore(name));
		String name2 = "Styles";
		System.out.println("SCORE FOR: " + name2 + " - "
				+ combined.getStudentScore(name2));

		System.out.println();
		combined.sortByTotalAsc();
		System.out.println("ORDERED BY TOTAL SCORE\n(Ascending)");
		combined.displayTotals();

		System.out.println();
		combined.sortByTotalDesc();
		System.out.println("ORDERED BY TOTAL SCORE\n(Descending)");
		combined.displayTotals();

		System.out.println();
		System.out.println("SCHOLARS");
		System.out.println("========");
		SatStudent[] scholars = combined.scholarship();
		for (SatStudent x : scholars)
			System.out.println(x);

		System.out.println();
		System.out.println("AVERAGE SCORE OF SCHOLARS: "
				+ combined.getScholarShipAverage());

		System.out.println();
		System.out.println("MATH SCHOLARS");
		System.out.println("=============");
		combined.mathClub();

		System.out.println();
		System.out.println("VERBAL SCHOLARS");
		System.out.println("=============");
		combined.verbalClub();

		System.out.println();
		System.out.println("WRITING SCHOLARS");
		System.out.println("=============");
		combined.writingClub();
	}
}
