package com.ies.AdminMS.service;

import com.ies.AdminMS.dto.PlanDTO;
import com.ies.AdminMS.entity.PlanEntity;
import com.ies.AdminMS.exception.AdminMSException;
import com.ies.AdminMS.exception.ExceptionConstants;
import com.ies.AdminMS.repository.PlanRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private PlanRepository planRepository;

//    @Override
//    public CaseWorkerDTO createCaseWorker(CaseWorkerDTO caseWorkerDTO) throws AdminMSException {
//        CaseWorkerEntity caseWorkerEntityExists = caseWorkerRepository.findByEmailId(caseWorkerDTO.getEmailId());
//        if(caseWorkerEntityExists != null){
//            throw new AdminMSException(ExceptionConstants.CASE_WORKER_ALREADY_EXISTS.toString());
//        }
//        CaseWorkerEntity caseWorkerEntity = CaseWorkerEntity.builder().build();
//        BeanUtils.copyProperties(caseWorkerDTO, caseWorkerEntity);
//        CaseWorkerEntity savedCaseWorkerEntity = caseWorkerRepository.save(caseWorkerEntity);
//
////      Call UserMS Service to store caseworker as a user
//        UserDTO userDTO = new UserDTO();
//        userDTO.setEmail(caseWorkerDTO.getEmailId());
//        userDTO.setAadharNo(caseWorkerDTO.getAadharNumber());
//        userDTO.setDob(caseWorkerDTO.getDateOfBirth());
//        userDTO.setName(caseWorkerDTO.getFullname());
//        userDTO.setGender(caseWorkerDTO.getGender());
//
//        CaseWorkerDTO savedCaseWorkerDTO = new CaseWorkerDTO();
//        BeanUtils.copyProperties(savedCaseWorkerEntity, savedCaseWorkerDTO);
//        return savedCaseWorkerDTO;
//    }

//    @Override
//    public List<CaseWorkerDTO> getAllCaseWorkers() {
//        List<CaseWorkerDTO> caseWorkerDTOList = new ArrayList<>();
//        List<CaseWorkerEntity> caseWorkerEntityList = caseWorkerRepository.findAll();
//        for(CaseWorkerEntity caseWorkerEntity : caseWorkerEntityList){
//            CaseWorkerDTO caseWorkerDTO = new CaseWorkerDTO();
//            BeanUtils.copyProperties(caseWorkerEntity, caseWorkerDTO);
//            caseWorkerDTOList.add(caseWorkerDTO);
//        }
//        return caseWorkerDTOList;
//    }

//    @Override
//    public CaseWorkerDTO editCaseWorker(CaseWorkerDTO caseWorkerDTO) throws AdminMSException {
//        CaseWorkerEntity caseWorkerEntityExists = caseWorkerRepository.findByEmailId(caseWorkerDTO.getEmailId());
//        if(caseWorkerEntityExists != null){
//            BeanUtils.copyProperties(caseWorkerDTO, caseWorkerEntityExists);
//            CaseWorkerEntity savedCaseWorkerEntity = caseWorkerRepository.save(caseWorkerEntityExists);
//            CaseWorkerDTO savedCaseWorkerDTO = new CaseWorkerDTO();
//            BeanUtils.copyProperties(savedCaseWorkerEntity, savedCaseWorkerDTO);
//            return savedCaseWorkerDTO;
//        }
//        else{
//            throw new AdminMSException(ExceptionConstants.CASEWORKER_NOT_FOUND.toString());
//        }
//    }
//
//    @Override
//    public CaseWorkerDTO toggleIsActive(String emailId) {
//        CaseWorkerEntity caseWorkerEntity = caseWorkerRepository.findByEmailId(emailId);
//        caseWorkerEntity.setActiveStatus(!caseWorkerEntity.isActiveStatus());
//        CaseWorkerEntity savedCaseWorkerEntity = caseWorkerRepository.save(caseWorkerEntity);
//        CaseWorkerDTO savedCaseWorkerDTO = new CaseWorkerDTO();
//        BeanUtils.copyProperties(savedCaseWorkerEntity, savedCaseWorkerDTO);
//        return savedCaseWorkerDTO;
//    }

    @Override
    public PlanDTO createPlan(PlanDTO planDTO, String jwt) {

        PlanEntity planEntity = new PlanEntity();
        BeanUtils.copyProperties(planDTO, planEntity);
        PlanEntity savedPlanEntity = planRepository.save(planEntity);
        PlanDTO savedPlanDTO = new PlanDTO();
        BeanUtils.copyProperties(savedPlanEntity, savedPlanDTO);
        return savedPlanDTO;
    }

    @Override
    public List<PlanDTO> getAllPlans(String jwt) {
        List<PlanDTO> planDTOList = new ArrayList<>();
        List<PlanEntity> planEntityList = planRepository.findAll();
        for(PlanEntity planEntity : planEntityList){
            PlanDTO planDTO = new PlanDTO();
            BeanUtils.copyProperties(planEntity, planDTO);
            planDTOList.add(planDTO);
        }
        return planDTOList;
    }

    @Override
    public PlanDTO editPlan(PlanDTO planDTO, String jwt) throws AdminMSException {
        Optional<PlanEntity> planEntityOpt = planRepository.findById(planDTO.getId());
        if(planEntityOpt.isPresent()){
            BeanUtils.copyProperties(planDTO, planEntityOpt.get());
            PlanEntity savedPlanEntity = planRepository.save(planEntityOpt.get());
            PlanDTO savedPlanDTO = new PlanDTO();
            BeanUtils.copyProperties(savedPlanEntity, savedPlanDTO);
            return savedPlanDTO;
        }else{
            throw new AdminMSException(ExceptionConstants.PLAN_NOT_FOUND.toString());
        }

    }

    @Override
    public PlanDTO toggleIsActive(String planId, String jwt) throws AdminMSException {
        Optional<PlanEntity> OptionalPlanEntity = planRepository.findById(planId);
        if(OptionalPlanEntity.isPresent()){
            PlanEntity planEntity = OptionalPlanEntity.get();
            planEntity.setActiveStatus(!planEntity.getActiveStatus());
            PlanEntity savedPlanEntity = planRepository.save(planEntity);
            PlanDTO savedPlanDTO = new PlanDTO();
            BeanUtils.copyProperties(savedPlanEntity, savedPlanDTO);
            return savedPlanDTO;
        }else{
            throw new AdminMSException(ExceptionConstants.PLAN_NOT_FOUND.toString());
        }
    }
}
