/*
 * [Stat].java
 * Author:  [Umair Irshad] 
 * Submission Date:  [APR 21 2023]
 * Purpose: In this program we implemented a class called stat. The Stat class stores an array of double values called data. As indicated by the class diagram, you
 * will need to implement public methods to compute the min, max, mode, and average of these values. 
 * 
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing 
 * or posting of source code for this assignment is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia.  
 */
public class Stat {
	private double[] data;

	public Stat() {
		data = new double[1];
		data[0] = 0.0;

	}

	public Stat(double[] d) {
		setData(d);
	}

	public Stat(float[] f) {
		setData(f);
	}

	public Stat(int[] i) {
		setData(i);
	}

	public Stat(long[] lo) {
		setData(lo);
	}

	public void setData(float[] f) {
		double[] newArray = new double[0];
		if (f != null) {
			newArray = new double[f.length];

			for (int i = 0; i < f.length; i++) {
				newArray[i] = f[i];
			}
		}
		data = newArray;
	}

	public void setData(double[] d) {
		double[] newArray = new double[0];
		if (d != null) {
			newArray = new double[d.length];

			for (int i = 0; i < d.length; i++) {
				newArray[i] = d[i];
			}
		}
		data = newArray;
	}

	public void setData(int[] i) {
		double[] newArray = new double[0];
		if (i != null) {
			newArray = new double[i.length];

			for (int j = 0; j < i.length; j++) {
				newArray[j] = i[j];
			}
		}
		data = newArray;
	}

	public void setData(long[] lo) {
		double[] newArray = new double[0];
		if (lo != null) {
			newArray = new double[lo.length];

			for (int i = 0; i < lo.length; i++) {
				newArray[i] = lo[i];
			}
		}
		data = newArray;
	}

	public double[] getData() {
		return data;
	}

	public boolean equals(Stat s) {
		boolean equality = true;

		if (s != null && s.data.length == data.length) {
			for (int i = 0; i < s.data.length; i++) {
				if (Math.abs(s.data[i] - data[i]) > 0.001) {
					equality = false;
					break;
				}
			}
		} else {
			equality = false;
		}
		return equality;
	}

	public void reset() {
		data = new double[0];
	}

	public void append(int[] i) {
		if (i != null) {
			double[] newArray = new double[data.length + i.length];

			for (int j = 0; j < newArray.length; j++) {
				if (j < data.length)
					newArray[j] = data[j];
				else
					newArray[j] = i[j - data.length];
			}

			data = newArray;
		}
	}

	public void append(float[] f) {
		if (f != null) {
			double[] newArray = new double[data.length + f.length];

			for (int j = 0; j < newArray.length; j++) {
				if (j < data.length)
					newArray[j] = data[j];
				else
					newArray[j] = f[j - data.length];
			}

			data = newArray;
		}
	}

	public void append(long[] lo) {
		if (lo != null) {
			double[] newArray = new double[data.length + lo.length];

			for (int j = 0; j < newArray.length; j++) {
				if (j < data.length)
					newArray[j] = data[j];
				else
					newArray[j] = lo[j - data.length];
			}

			data = newArray;
		}
	}

	public void append(double[] d) {
		if (d != null) {
			double[] newArray = new double[data.length + d.length];

			for (int j = 0; j < newArray.length; j++) {
				if (j < data.length)
					newArray[j] = data[j];
				else
					newArray[j] = d[j - data.length];
			}

			data = newArray;
		}
	}

	public boolean isEmpty() {
		return data.length == 0;
	}

	public String toString() {
		if (isEmpty())
			return "[]";
		String s = "[";
		for (int i = 0; i < data.length; i++) {
			s += data[i];
			if (i == data.length - 1)
				s += "]";
			else
				s += ", ";
		}

		return s;
	}

	public double min() {
		if (!isEmpty()) {
			double min = data[0];
			for (int i = 0; i < data.length; i++) {
				if (min > data[i])
					min = data[i];
			}

			return min;
		} else
			return Double.NaN;
	}

	public double max() {
		if (!isEmpty()) {
			double max = data[0];
			for (int i = 0; i < data.length; i++) {
				if (max < data[i])
					max = data[i];
			}

			return max;
		} else
			return Double.NaN;
	}

	public double average() {
		if (!isEmpty()) {
			double sum = 0;
			for (int i = 0; i < data.length; i++) {
				sum += data[i];
			}
			return sum / data.length;
		} else
			return Double.NaN;
	}

	public double mode() {
		if (!isEmpty()) {
			double mode = 0, iteration = 1;

			for (int i = 0; i < data.length; i++) {
				int temp = 0;
				for (int j = i; j < data.length; j++) {
					if (Math.abs(data[i] - data[j]) <= 0.001)
						temp++;
				}
				if (temp > iteration) {
					mode = data[i];
					iteration = temp;
				} else if (temp == iteration) {
					mode = Double.NaN;
				}
			}

			return mode;
		} else
			return Double.NaN;
	}

	private int occursNumberOfTimes(double d) {
		int counter = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] == d)
				counter++;
		}

		return counter;
	}

	public double variance() {
		if (!isEmpty()) {
			double distance = 0;

			for (int i = 0; i < data.length; i++)
				distance += Math.pow(data[i] - average(), 2);

			return distance / data.length;
		} else
			return Double.NaN;

	}

	public double standardDeviation() {
		return Math.sqrt(variance());
	}
}