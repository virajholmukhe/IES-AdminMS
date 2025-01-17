package com.ies.AdminMS.repository;

import com.ies.AdminMS.entity.CaseWorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseWorkerRepository extends JpaRepository<CaseWorkerEntity, String> {

    public List<CaseWorkerEntity> getAllCaseWorkers();

    public CaseWorkerEntity findByEmailId(String emailId);
}
