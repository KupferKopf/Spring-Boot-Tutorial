package com.KupferKopf.Springboot.tutorial.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;

    @NotBlank(message = "An Employee needs a SVNR/SSNR")
    private int employeeSVNR;
    @NotBlank(message = "An Employee needs a Firtsname")
    private String employeeFirstName;
    @NotBlank(message = "An Employee needs a Lastname")
    private String employeeLastName;
    private String employeeAddress;
    private String employeePLZ;

}
