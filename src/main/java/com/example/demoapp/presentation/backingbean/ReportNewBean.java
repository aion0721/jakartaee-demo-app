package com.example.demoapp.presentation.backingbean;

import com.example.demoapp.infrastructure.repository.ReportRepository;
import com.example.demoapp.dto.ReportDto;

import jakarta.enterprise.context.RequestScoped;
import jakarta.validation.constraints.NotBlank;
import jakarta.inject.Named;
import jakarta.inject.Inject;

import lombok.Getter;
import lombok.Setter;

@Named
@RequestScoped
@Getter
@Setter
public class ReportNewBean{
	private String title;
	private String detail;

	@Inject
	private ReportRepository reportRepository;

	public String create() {
		ReportDto newReport = new ReportDto();
		newReport.setTitle(title);
		newReport.setDetail(detail);
		reportRepository.create(newReport);
		return "/reportList?faces-redirect=true";
	}

}