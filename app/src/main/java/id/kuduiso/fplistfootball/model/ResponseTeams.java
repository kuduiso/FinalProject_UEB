package id.kuduiso.fplistfootball.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseTeams{

	@SerializedName("teams")
	private List<TeamsItem> teams;

	public List<TeamsItem> getTeams(){
		return teams;
	}
}