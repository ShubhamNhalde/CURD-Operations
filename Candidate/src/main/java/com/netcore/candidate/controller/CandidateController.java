package com.netcore.candidate.controller;


import com.netcore.candidate.dto.HiredCandidateDto;
import com.netcore.candidate.dto.ResponseDto;
import com.netcore.candidate.model.HiredCandidate;
import com.netcore.candidate.service.IHiredCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/candidate")
@RestController
public class CandidateController {

    @Autowired
    IHiredCandidateService iHiredCandidateService;

    @PostMapping("/addCandidate")
    public ResponseEntity<ResponseDto> createUser(@RequestBody HiredCandidateDto hiredCandidateDto) {
        HiredCandidate hiredCandidate = iHiredCandidateService.createCandidate(hiredCandidateDto);
        ResponseDto response = new ResponseDto("Hired Candidate Added Successfully !!!", hiredCandidate);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseDto> getAllCandidates() {
        List<HiredCandidate> candidates = iHiredCandidateService.getAllCandidates();
        ResponseDto response = new ResponseDto("GET CALL FOR HIRED CANDIDATES SUCCESSFUL", candidates);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> updateCandidateData(@PathVariable("id") long id,
                                                           @RequestBody HiredCandidateDto hiredCandidateDto) {
        HiredCandidate hiredCandidate = iHiredCandidateService.updateCandidate(id, hiredCandidateDto);
        ResponseDto response = new ResponseDto("UPDATED CANDIDATE DATA SUCCESSFULLY !!!", hiredCandidate);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> deleteCandidate(@PathVariable("id") long id) {
        iHiredCandidateService.deleteCandidate(id);
        ResponseDto response = new ResponseDto("DELETED CANDIDATE DATA SUCCESSFULLY !!!", "DATABASE UPDATED.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
