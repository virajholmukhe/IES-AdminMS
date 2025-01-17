package com.ies.AdminMS.service;

import com.ies.AdminMS.dto.CaseWorkerDTO;
import com.ies.AdminMS.dto.PlanDTO;
import com.ies.AdminMS.entity.CaseWorkerEntity;
import com.ies.AdminMS.entity.PlanEntity;
import com.ies.AdminMS.exception.AdminMSException;
import com.ies.AdminMS.exception.ExceptionConstants;
import com.ies.AdminMS.repository.CaseWorkerRepository;
import com.ies.AdminMS.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdminServiceImpl implements AdminService{

    @Autowired
    private CaseWorkerRepository caseWorkerRepository;

    @Autowired
    private PlanRepository planRepository;

    @Override
    public CaseWorkerDTO createCaseWorker(CaseWorkerDTO caseWorkerDTO) {
        CaseWorkerEntity caseWorkerEntity = CaseWorkerDTO.prepareEntity(caseWorkerDTO);
        return CaseWorkerDTO.prepareDTO(caseWorkerRepository.save(caseWorkerEntity));
    }

    @Override
    public List<CaseWorkerDTO> getAllCaseWorkers() {
        List<CaseWorkerDTO> caseWorkerDTOList = new ArrayList<>();
        List<CaseWorkerEntity> caseWorkerEntityList = caseWorkerRepository.getAllCaseWorkers();
        for(CaseWorkerEntity caseWorkerEntity : caseWorkerEntityList){
            caseWorkerDTOList.add(CaseWorkerDTO.prepareDTO(caseWorkerEntity));
        }
        return caseWorkerDTOList;
    }

    @Override
    public CaseWorkerDTO editCaseWorker(CaseWorkerDTO caseWorkerDTO) {
        CaseWorkerEntity caseWorkerEntity = CaseWorkerDTO.prepareEntity(caseWorkerDTO);
        return CaseWorkerDTO.prepareDTO(caseWorkerRepository.save(caseWorkerEntity));
    }

    @Override
    public CaseWorkerDTO toggleIsActive(String emailId) {
        CaseWorkerEntity caseWorkerEntity = caseWorkerRepository.findByEmailId(emailId);
        caseWorkerEntity.setIsActive(!caseWorkerEntity.getIsActive());
        return CaseWorkerDTO.prepareDTO(caseWorkerRepository.save(caseWorkerEntity));
    }

    @Override
    public PlanDTO createPlan(PlanDTO planDTO) {
        PlanEntity planEntity = PlanDTO.prepareEntity(planDTO);
        return PlanDTO.prepareDTO(planRepository.save(planEntity));
    }

    @Override
    public List<PlanDTO> getAllPlans() {
        List<PlanDTO> planDTOList = new ArrayList<>();
        List<PlanEntity> planEntityList = planRepository.getAllPlans();
        for(PlanEntity planEntity : planEntityList){
            planDTOList.add(PlanDTO.prepareDTO(planEntity));
        }
        return planDTOList;
    }

    @Override
    public PlanDTO editPlan(PlanDTO planDTO) {
        PlanEntity planEntity = PlanDTO.prepareEntity(planDTO);
        return PlanDTO.prepareDTO(planRepository.save(planEntity));
    }

    @Override
    public PlanDTO toggleIsActive(Long planId) throws AdminMSException {
        Optional<PlanEntity> OptionalPlanEntity = planRepository.findById(planId);
        if(OptionalPlanEntity.isPresent()){
            PlanEntity planEntity = OptionalPlanEntity.get();
            planEntity.setIsActive(!planEntity.getIsActive());
            return PlanDTO.prepareDTO(planRepository.save(planEntity));
        }else{
            throw new AdminMSException(ExceptionConstants.PLAN_NOT_FOUND.toString());
        }
    }
}
