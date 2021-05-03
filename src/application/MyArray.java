package application;

import java.util.ArrayList;

public class MyArray {

	private ArrayList<Integer> Array;
	private int localMinIndex;
	private int I;
	private int J;

	public MyArray() {
		Array = new ArrayList<Integer>();
		localMinIndex = 0;
		I = 0;
		J = 0;
	}

	public void add(int value) {
		Array.add(value);
	}

	public void deleteByIndex(int index) {
		Array.remove(index);
	}

	public int getByIndex(int index) {
		return Array.get(index);
	}

	public int size() {
		return Array.size();
	}

	public void changeByIndex(int index, int value) {
		Array.set(index, value);
	}

	public void selectionSort() {

		for (int i = 0; i < Array.size() - 1; i++) {
			int local_min_index = i;
			for (int j = i + 1; j < Array.size(); j++) {
				if (Array.get(j) < Array.get(local_min_index))
					local_min_index = j;
			}
			swapItemsByIndices(i, local_min_index);
		}
	}

	public void swapItemsByIndices(int i, int j) {

		int tmp = Array.get(i);
		Array.set(i, Array.get(j));
		Array.set(j, tmp);
	}

	public void setJ(int J) {
		this.J = J;
	}

	public void setI(int I) {
		this.I = I;
	}

	public void setLocalMinIndex(int localMinIndex) {
		this.localMinIndex = localMinIndex;
	}

	public void inkI() {
		I++;
	}

	public void inkJ() {
		J++;
	}

	public int getI() {
		return I;
	}

	public int getJ() {
		return J;
	}

	public int getLocalMinIndex() {
		return localMinIndex;
	}
}
