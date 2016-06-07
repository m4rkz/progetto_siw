package it.uniroma3.controller;



import it.uniroma3.model.Amministratore;
import it.uniroma3.model.Facade;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ControllerAdmin {
	private Long id;
	private String password;
	private boolean loginSucceded = true;;
	
	
	@EJB
	private Facade amministratoreFacade;
	
	public String loginAdmin() {
		Amministratore admin = amministratoreFacade.getAmministratore(id);
		if (admin != null && admin.checkPassword(password)) {
			return "/adminPanel";
		}
		loginSucceded = false;
		return "/admin";
	}
	
	
	
	public boolean isLoginSucceded() {
		return loginSucceded;
	}



	public void setLoginSucceded(boolean loginSucceded) {
		this.loginSucceded = loginSucceded;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Facade getAmministratoreFacade() {
		return amministratoreFacade;
	}

	public void setAmministratoreFacade(Facade amministratoreFacade) {
		this.amministratoreFacade = amministratoreFacade;
	}
	
	
	
}