package ressources;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat
public class RSMenu {
	private String message;
	private List<RSLien> liens;
	public List<RSLien> getLiens() {
		return liens;
	}
	public void setLiens(List<RSLien> liens) {
		this.liens = liens;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
}
