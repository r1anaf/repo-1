/**
* Name: Riana Fazir
* Project Name: GuidanceGroup
*Project Description: Working with arrays in Guidance Group
**/

import java.util.Arrays;

public class GuidanceGroup {
	// Array group will store SatStudent objects
		private SatStudent[] group;

		/*
		 * Constructor with a SatStudent[] array as a parameter
		 */
		public GuidanceGroup(SatStudent[] myGroup) {
			group = myGroup;
		}

		public SatStudent[] getGroup() {
			return group;
		}

		/*
		 * This method displays a chart with 2 columns: Name and Total SAT score
		 */
		public void displayTotals() {
			System.out.println("NAME\tTOTAL");
			System.out.println("====\t=====");
			for (int i = 0; i<group.length; i++) {
				System.out.println(group[i].getName() + "\t" + group[i].getTotal());
			}
		}

		/*
		 * Sorts the array of the guidanceGroup by Name (ascending (alphabetically))
		 */
		public void sortByName() {

			for (int i =0; i<group.length; i++) {
				for (int j = i+1; j<group.length;j++) {
					if ((group[i].getName()).compareTo(group[j].getName())>0) {
						SatStudent temp = group[i];
						group[i] = group[j];
						group[j] = temp;
					}
				}
			}
			displayTotals();
			
		}

		/*
		 * Returns a new guidanceGroup with the SatStudent of this class
		 * combined with the SatStudent of other class
		 */
		public GuidanceGroup combineGroups(GuidanceGroup other) {
			SatStudent[] arr = new SatStudent[group.length+other.group.length];
			int j = 0;
			
			for(int i = 0; i< group.length; i++) {
				arr[i] = group[i];
			}
			for(int i = group.length; i< arr.length; i++) {
				arr[i] = other.group[j];
				j++;
			}
			GuidanceGroup two = new GuidanceGroup(arr);
			return two;
		}

		/*
		 * This method returns the name of the student with the lowest total SAT
		 * 
		 */
		public String getMin() {
			int min = group[0].getTotal();
			String name="";
			for (SatStudent x: group) {
				if(x.getTotal() < min) {
					min = x.getTotal();
					name = x.getName();
				}
				else {
					x = group[0];
					name = x.getName();
				}
			}
			return name;
		
		}

		/*
		 * This method returns the name of the student with the highest total SAT
		 * score
		 */
		public String getMax() {
			int max = group[0].getTotal();
			String name="";
			for (SatStudent x: group) {
				if(x.getTotal() > max) {
					max = x.getTotal();
					name = x.getName();
				}
			}
			return name;
		}

		/*
		 * This method returns the average of all SAT scores
		 */
		public int average() {
			int sum = 0;
			for (SatStudent x : group) {
				sum += x.getTotal();
			}
			return sum/group.length;
		}

		/*
		 * This method displays a list of names of students who scored below 1700
		 */
		public void below1700List() {
			for (SatStudent x : group) {
				if (x.getTotal() < 1700) {
					System.out.println(x.getName());
				}
			}
		}

		/*
		 * This method displays a list of names of students who scored above 2000
		 */
		public void above2000List() {
			for (SatStudent x : group) {
				if (x.getTotal() > 2000) {
					System.out.println(x.getName());
				}
			}
		}

		/*
		 * Return the total score of an requested name. Return -1 if student is not
		 * found
		 */
		public int getStudentScore(String lookfor) {
			for (SatStudent x : group) {
				if (x.getName().equals(lookfor))
					return x.getTotal();
			}
			return -1;
		}

		/*
		 * Sorts the array of the guidanceGroup by total score (descending) - everyhting works except for ascending
		 * and descending bc of temp thing
		 */
		public void sortByTotalDesc() {

		
			SatStudent[] newArr = new SatStudent[group.length];
	        for (int i = 0; i < group.length; i++) {
	            for (int j = i + 1; j < group.length; j++) {
	                if (group[i].getTotal() > group[j].getTotal()) {
	                    SatStudent temp = group[i];
	                    group[i] = group[j];
	                    group[j] = temp;
	                }
	            }
	        }
			
		}

		/*
		 * Sorts the array of the guidanceGroup by total score (ascending)
		 */
		public void sortByTotalAsc() {
			//int temp = group[0].getTotal();
			SatStudent[] newArr = new SatStudent[group.length];
	        for (int i = 0; i < group.length; i++) {
	            for (int j = i + 1; j < group.length; j++) {
	                if (group[i].getTotal() < group[j].getTotal()) {
	                    SatStudent temp = group[i];
	                    group[i] = group[j];
	                    group[j] = temp;
	                }
	            }
	        }
			
		}

		/*
		 * returns an array of SatStudent with total scores >1900
		 */
		public SatStudent[] scholarship() {
			int count = 0;
			int i = 0;
			
			for(SatStudent x: group) {
				if(x.getTotal()>1900)
					count++;
			}

			SatStudent[] newArr = new SatStudent[count];
			
			for(SatStudent x: group) {
				if(x.getTotal()>1900) {
					newArr[i] = x;
					i++;
				}
			}
			return newArr;
		}

		/*
		 * Return the average of all of the students in the Scholarship category
		 */
		public int getScholarShipAverage() {
			int count = 0;
			int i = 0;
			int sum = 0;
			
			for(SatStudent x: group) {
				if(x.getTotal()>1900)
					count++;
			}

			SatStudent[] newArr = new SatStudent[count];
			
			for(SatStudent x: group) {
				if(x.getTotal()>1900) {
					sum+= x.getTotal();
					newArr[i] = x;
					i++;
				}
			}
			
			return sum/count;
			
		}

		/*
		 * Return all students whose score in Math section is > 700
		 */
		public void mathClub() {

			for (SatStudent x : group) {
				if (x.getMath() > 700) {
					System.out.println(x.getName() + "\t" + x.getMath());
				}
			}
		}

		/*
		 * Return all students whose score in Verbal section is > 700
		 */
		public void verbalClub() {
			for (SatStudent x : group) {
				if (x.getVerbal() > 700) {
					System.out.println(x.getName() + "\t" + x.getVerbal());
				}
			}

		}

		/*
		 * Return all students whose score in Writing section is > 700
		 */
		public void writingClub() {
			for (SatStudent x : group) {
				if (x.getWriting() > 700) {
					System.out.println(x.getName() + "\t" + x.getWriting());
				}
			}

		}
		
}
