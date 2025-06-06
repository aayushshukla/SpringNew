package com.infosys.curddemo.beans;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor

@Entity
@Table(name ="tb_batches")
public class Batches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Size(min = 1, message = "Batch Id must have 3 character")
    private  int batchId;
/*
      @NotNull : check if given field is not null
      if will allow 0 and empty values
      @NotEmpty : check if given field is not null and its size greater than 0
      @NotBlank : check if given field is not null and trimmed length is greater than zero

 */
   @NotBlank(message = "Batch name can not be empty")
    private  String batchName;
    @NotBlank(message = "Batch Start Date can not be empty")
    private    String batchStartDate;
    private    String batchEndDate;

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getBatchStartDate() {
        return batchStartDate;
    }

    public void setBatchStartDate(String batchStartDate) {
        this.batchStartDate = batchStartDate;
    }

    public String getBatchEndDate() {
        return batchEndDate;
    }

    public void setBatchEndDate(String batchEndDate) {
        this.batchEndDate = batchEndDate;
    }
// @Email  private @Getter @Setter String trainerEmail;

    //@Pattern(regexp = "(^$|[0-9]{10})" ,message = "Please give valid mobile no mobile no must have 10 digits")
    //  private String trainerMobileNumber;
//    public Batches(String batchName, String batchStartDate, String batchEndDate) {
//        this.batchName = batchName;
//        this.batchStartDate = batchStartDate;
//        this.batchEndDate = batchEndDate;
//    }

    @Override
    public String toString() {
        return "Batches{" +
                "batchId=" + batchId +
                ", batchName='" + batchName + '\'' +
                ", batchStartDate='" + batchStartDate + '\'' +
                ", batchEndDate='" + batchEndDate + '\'' +
                '}';
    }






}
