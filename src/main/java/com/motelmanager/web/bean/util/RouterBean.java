package com.motelmanager.web.bean.util;

import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service(value = "routerBean")
public class RouterBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private String nextPage;

	public String getNextPage() {
		return nextPage;
	}

	public void setNextPage(String nextPage) {
		this.nextPage = nextPage;
	}

}
