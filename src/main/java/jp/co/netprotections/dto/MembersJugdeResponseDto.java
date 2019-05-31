package jp.co.netprotections.dto;

import java.util.List;

/**
 * @author h.dat
 * MemberJugdeResponseDtoのリスト
 *
 */
public class MembersJugdeResponseDto {
	private List<MemberJugdeResponseDto> judgedCandidatesResultList;

	public MembersJugdeResponseDto(List<MemberJugdeResponseDto> judgedCandidatesResultList) {
		super();
		this.judgedCandidatesResultList = judgedCandidatesResultList;
	}

	public List<MemberJugdeResponseDto> getJudgedCandidatesResultList() {
		return judgedCandidatesResultList;
	}

	public void setJudgedCandidatesResultList(List<MemberJugdeResponseDto> judgedCandidatesResultList) {
		this.judgedCandidatesResultList = judgedCandidatesResultList;
	}
	
	
	
}
