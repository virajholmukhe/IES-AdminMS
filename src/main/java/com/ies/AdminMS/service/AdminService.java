package com.ies.AdminMS.service;

import com.ies.AdminMS.dto.CaseWorkerDTO;
import com.ies.AdminMS.dto.PlanDTO;
import com.ies.AdminMS.exception.AdminMSException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    public CaseWorkerDTO createCaseWorker(CaseWorkerDTO caseWorkerDTO) throws AdminMSException;
    public List<CaseWorkerDTO> getAllCaseWorkers();
    public CaseWorkerDTO editCaseWorker(CaseWorkerDTO caseWorkerDTO) throws AdminMSException;
    public CaseWorkerDTO toggleIsActive(String emailId);

    public PlanDTO createPlan(PlanDTO planDTO);
    public List<PlanDTO> getAllPlans();
    public PlanDTO editPlan(PlanDTO planDTO) throws AdminMSException;
    public PlanDTO toggleIsActive(Long planId) throws AdminMSException;
}
