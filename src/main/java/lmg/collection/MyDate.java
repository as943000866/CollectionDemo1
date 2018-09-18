package lmg.collection;

public class MyDate implements Comparable{
	private Integer month;
	private Integer day;
	private Integer year;
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public MyDate(Integer month, Integer day, Integer year) {
		super();
		this.month = month;
		this.day = day;
		this.year = year;
	}
	@Override
	public String toString() {
		return "MyDate [month=" + month + ", day=" + day + ", year=" + year + "]";
	}
	public int compareTo(Object o) {
		if(o instanceof MyDate){
			MyDate date = (MyDate) o;
			int i = this.year.compareTo(date.year);
			if(i == 0){
				i = this.month.compareTo(date.month);
				if(i == 0){
					i = this.day.compareTo(date.day);
				}
			}
			return i;
		}
		return 0;
	}
	
	
}
