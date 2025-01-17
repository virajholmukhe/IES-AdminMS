package com.ies.AdminMS.controller;

import com.ies.AdminMS.dto.CaseWorkerDTO;
import com.ies.AdminMS.dto.PlanDTO;
import com.ies.AdminMS.exception.AdminMSException;
import com.ies.AdminMS.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping(value = "create-case-worker")
    public ResponseEntity<CaseWorkerDTO> createCaseWorker(@RequestBody CaseWorkerDTO caseWorkerDTO){
        return ResponseEntity.ok(adminService.createCaseWorker(caseWorkerDTO));
    }

    @GetMapping(value = "get-all-case-workers")
    public ResponseEntity<List<CaseWorkerDTO>> getAllCaseWorkers(){
        return ResponseEntity.ok(adminService.getAllCaseWorkers());
    }

    @PutMapping(value = "edit-case-worker")
    public ResponseEntity<CaseWorkerDTO> editCaseWorker(@RequestBody CaseWorkerDTO caseWorkerDTO){
        return ResponseEntity.ok(adminService.editCaseWorker(caseWorkerDTO));
    }

    @PutMapping(value = "toggle-case-worker")
    public ResponseEntity<CaseWorkerDTO> toggleIsActive(@RequestParam String emailId){
        return ResponseEntity.ok(adminService.toggleIsActive(emailId));
    }

    @PostMapping(value = "create-plan")
    public ResponseEntity<PlanDTO> createPlan(@RequestBody PlanDTO planDTO){
        return ResponseEntity.ok(adminService.createPlan(planDTO));
    }

    @GetMapping(value = "get-all-plans")
    public ResponseEntity<List<PlanDTO>> getAllPlans(){
        return ResponseEntity.ok(adminService.getAllPlans());
    }

    @PutMapping(value = "edit-plan")
    public ResponseEntity<PlanDTO> editPlan(@RequestBody PlanDTO planDTO){
        return ResponseEntity.ok(adminService.editPlan(planDTO));
    }

    @PutMapping(value = "toggle-plan")
    public ResponseEntity<PlanDTO> toggleIsActive(@RequestParam Long planId) throws AdminMSException {
        return ResponseEntity.ok(adminService.toggleIsActive(planId));
    }
}
