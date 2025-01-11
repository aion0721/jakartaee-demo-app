package com.example.demoapp.presentation.backingbean;

import jakarta.enterprise.context.RequestScoped;
import jakarta.validation.constraints.NotBlank;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ReportNewBean{
    @NotBlank(message = "タイトルは空白にできません")
	private String title;
	private String detail;

	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getDetail(){
		return detail;
	}

	public void setDetail(String detail){
		this.detail = detail;
	}
}