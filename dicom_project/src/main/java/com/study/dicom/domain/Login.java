package com.study.dicom.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@NoArgsConstructor
public class Login {

    @Id
    @Column(name = "User_Name")
    private String userName;
    
    @NonNull
    @Column(name = "User_Password")
    private String userPassword;
    
}
