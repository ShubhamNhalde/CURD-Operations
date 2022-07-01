package com.netcore.candidate.dto;

import lombok.Data;

@Data
public class HiredCandidateDto {

    public long id;
    private String firstName;
    private String lastName;
    private String email;
    private String status;
    private String location;
}
