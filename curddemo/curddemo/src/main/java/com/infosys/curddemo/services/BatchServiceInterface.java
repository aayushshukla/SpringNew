package com.infosys.curddemo.services;

import com.infosys.curddemo.beans.Batches;

import java.util.List;
import java.util.Optional;

public interface BatchServiceInterface {

    public void addBatch(Batches batch);
    public  void addMultipleBatches(List<Batches> batches);
    public Optional<Batches> findBatchById(int batchId);
   // public List<Batches> showAllBatches();

}
