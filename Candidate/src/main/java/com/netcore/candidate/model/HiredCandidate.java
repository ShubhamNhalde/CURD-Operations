package com.netcore.candidate.model;

import com.netcore.candidate.dto.HiredCandidateDto;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@Document(collection = "HiredCandidate")
public class HiredCandidate {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private long id;

    private String firstName;
    private String lastName;
    private String email;

    private String status;
    private String location;

    public HiredCandidate() {
        super();
    }

    public HiredCandidate(HiredCandidateDto hiredCandidateDto) {

        this.firstName = hiredCandidateDto.getFirstName();
        this.lastName = hiredCandidateDto.getLastName();
        this.email = hiredCandidateDto.getEmail();
        this.location = hiredCandidateDto.getLocation();

    }
}
