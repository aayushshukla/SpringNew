package com.infosys.curddemo.services;

import com.infosys.curddemo.beans.Batches;
import com.infosys.curddemo.repos.BatchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatchServices implements  BatchServiceInterface{
    @Autowired
    BatchRepo batchRepo;

    @Override
    public void addBatch(Batches batch) {
        batchRepo.save(batch);
    }

    @Override
    public void addMultipleBatches(List<Batches> batchesList) {
      Iterable<Batches> batchInfo =  batchRepo.saveAll(batchesList);
//

    }

    @Override
    public Optional<Batches> findBatchById(int batchId) {
        return batchRepo.findById(batchId);
    }
}
