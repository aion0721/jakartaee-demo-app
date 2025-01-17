package com.example.demoapp.presentation.backingbean;

import java.util.ArrayList;
import java.util.List;

import com.example.demoapp.dto.ReportDto;
import com.example.demoapp.infrastructure.repository.ReportRepository;

import jakarta.faces.context.ExternalContext;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.inject.Inject;

import jakarta.annotation.PostConstruct;
import java.io.IOException;

import lombok.Getter;
import lombok.Setter;

@Named
@RequestScoped
@Getter
@Setter
public class ReportListBean{
	private List<ReportDto> reports;
	private ReportDto selectedReport;

	@Inject
	private ReportRepository reportRepository;

	@Inject
	private ExternalContext externalContext;

	@PostConstruct
	public void init() {
		reports = reportRepository.findAll();

	}

	public void navigateToShowPage() throws IOException{
		String redirectUrl = externalContext.getRequestContextPath() + "/reportShow.xhtml?reportId=" + selectedReport.getReportId();
		externalContext.redirect(redirectUrl);
	}


}