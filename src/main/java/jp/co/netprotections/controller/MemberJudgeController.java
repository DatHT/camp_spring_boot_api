package jp.co.netprotections.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.netprotections.dto.MembersJudgeRequestDto;
import jp.co.netprotections.dto.MembersJugdeResponseDto;
import jp.co.netprotections.service.MemberJudgeService;

/**
 * @author h.dat
 * MemberJudgeController
 *
 */
@RestController
@RequestMapping("/api/v1")
@Validated
public class MemberJudgeController {
	
	@Autowired
	MemberJudgeService service;

	@PostMapping("/check")
	public ResponseEntity<?> checkUsers(@RequestBody @Valid MembersJudgeRequestDto data, Errors errors) {
		return new ResponseEntity<MembersJugdeResponseDto>(service.judgeMembers(data), HttpStatus.OK);
	}
}
