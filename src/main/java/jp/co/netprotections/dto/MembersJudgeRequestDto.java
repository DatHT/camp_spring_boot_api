package jp.co.netprotections.dto;

import java.util.List;

import javax.validation.Valid;

/**
 * @author h.dat
 * MemberJudgeRequestDtoのリスト
 *
 */
public class MembersJudgeRequestDto {
	
	@Valid
	private List<MemberJudgeRequestDto> memberCandidatesList;
	
	public MembersJudgeRequestDto() {
		// TODO Auto-generated constructor stub
	}

	public MembersJudgeRequestDto(List<MemberJudgeRequestDto> memberCandidatesList) {
		super();
		this.memberCandidatesList = memberCandidatesList;
	}

	public List<MemberJudgeRequestDto> getMemberCandidatesList() {
		return memberCandidatesList;
	}

	public void setMemberCandidatesList(List<MemberJudgeRequestDto> memberCandidatesList) {
		this.memberCandidatesList = memberCandidatesList;
	}
	
}
