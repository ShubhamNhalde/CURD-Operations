package com.netcore.candidate.service;

import com.netcore.candidate.dto.HiredCandidateDto;
import com.netcore.candidate.model.HiredCandidate;

import java.util.List;

public interface IHiredCandidateService {

    HiredCandidate createCandidate(HiredCandidateDto hiredCandidateDto);

    List<HiredCandidate> getAllCandidates();

    HiredCandidate updateCandidate(long id, HiredCandidateDto hiredCandidateDto);

    HiredCandidate deleteCandidate(Long id);
}
