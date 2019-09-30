package zpq.myConstants;

public class ReportInfo {

	private double size;
	private String xAxis;
	public double getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public void setSizeByDouble(double size) {
		this.size = size;
	}
	public String getxAxis() {
		return xAxis;
	}
	public void setxAxis(String xAxis) {
		this.xAxis = xAxis;
	}
	@Override
	public String toString() {
		return "ReportInfo [size=" + size + ", xAxis=" + xAxis + "]";
	}

	

}
