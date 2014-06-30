package com.motelmanager.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesMessageUtil {

	public static void showInfoMessage(String message){
		FacesContext
			.getCurrentInstance()
			.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,message, null));
	}
	
	public static void showWarningMessage(String message){
		FacesContext
			.getCurrentInstance()
			.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_WARN,message, null));
	}
	
	public static void showErrorMessage(String message){
		FacesContext
			.getCurrentInstance()
			.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,message, null));
	}
	
	public static void showFatalMessage(String message){
		FacesContext
			.getCurrentInstance()
			.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_FATAL,message, null));
	}

}
