package com.example.casestudy.repository.contract;

import com.example.casestudy.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract,Long> {
}
