package jdbc;

public class BbsVO {
    private String nm;
    private String title;
    private String readCount;
    private String updateDt;
	
    public String getNm() {
    	return nm;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReadCount() {
		return readCount;
	}

	public void setReadCount(String readCount) {
		this.readCount = readCount;
	}

	public String getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}
}
    