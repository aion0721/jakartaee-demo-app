package com.example.demoapp.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.demoapp.dto.ReportDto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import jakarta.enterprise.context.RequestScoped;
import com.example.demoapp.infrastructure.entity.ReportEntity;

import jakarta.transaction.Transactional;
import java.util.stream.Stream;

@RequestScoped
@Transactional
public class ReportRepository{
	@PersistenceContext
	private EntityManager em;

	public List<ReportDto> findAll(){
		Stream<ReportEntity> reportStream = em.createQuery("select r from ReportEntity r", ReportEntity.class).getResultStream();
		return reportStream.map(ReportRepository::convertToDto).toList();
	}

	public ReportDto findById(Integer id) {
       ReportEntity report = em.find(ReportEntity.class, id);
       return convertToDto(report);
   }

	static private ReportDto convertToDto(ReportEntity entity){
		ReportDto report = new ReportDto();
		report.setReportId(entity.getReportId());
		report.setTitle(entity.getTitle());
		report.setDetail(entity.getDetail());

		return report;
	}

	public void create(ReportDto report){
		ReportEntity entity = convertToEntity(report);
		em.persist(entity);
	}

	static private ReportEntity convertToEntity(ReportDto dto){
		ReportEntity report = new ReportEntity();
		report.setReportId(dto.getReportId());
		report.setTitle(dto.getTitle());
		report.setDetail(dto.getDetail());

		return report;
	}
}