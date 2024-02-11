package model;

public class CreateUserResponse{
	private int id;
	private String token;

	public void setId(int id) {
		this.id = id;
	}

	public void setToken(String token) {
		this.token = token;
	}


	public int getId(){
		return id;
	}
	public String getToken(){
		return token;
	}
}
