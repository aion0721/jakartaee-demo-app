package com.example.demoapp.presentation.backingbean;

import java.util.ArrayList;
import java.util.List;

import com.example.demoapp.dto.ReportDto;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import lombok.Getter;
import lombok.Setter;

@Named
@RequestScoped
@Getter
@Setter
public class ReportListBean{
	private List<ReportDto> reports;

	public ReportListBean() {
		reports = new ArrayList<>();
		reports.add(new ReportDto("Title1", "Detail1"));
		reports.add(new ReportDto("Title2", "Detail2"));
		reports.add(new ReportDto("Title3", "Detail3"));
	}


}