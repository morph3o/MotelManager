package com.motelmanager.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesMessageUtil {

	public static void showInfoMessage(String message){
		FacesContext
			.getCurrentInstance()
			.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Información:", message));
	}
	
	public static void showWarningMessage(String message){
		FacesContext
			.getCurrentInstance()
			.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Precaución!", message));
	}
	
	public static void showErrorMessage(String message){
		System.out.println("Message: "+message);
		FacesContext
			.getCurrentInstance()
			.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ha ocurrido un error:", message));
	}
	
	public static void showFatalMessage(String message){
		FacesContext
			.getCurrentInstance()
			.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_FATAL,"Fatal!", message));
	}

}
