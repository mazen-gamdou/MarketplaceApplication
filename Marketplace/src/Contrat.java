import java.util.Date;

public class Contrat {
	public static int global_id=0;
    protected int num;
    protected String startDate;
    protected String endDate;

    

    public String getNum() {
		return Integer.toString(num);
	}



	public void setNum(int num) {
		this.num = num;
	}



	public String getStartDate() {
		return startDate;
	}



	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}



	public String getEndDate() {
		return endDate;
	}



	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}



	public Contrat(String startDate, String endDate){
        global_id +=1;
        this.num=global_id;
        this.startDate=startDate;
        this.endDate=endDate;
        
    }
    
    
    
    
}
