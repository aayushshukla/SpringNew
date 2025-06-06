package com.infosys.curddemo.repos;

import com.infosys.curddemo.beans.Batches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepo extends JpaRepository<Batches,Integer> {

}
