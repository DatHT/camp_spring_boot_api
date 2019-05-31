package jp.co.netprotections.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.netprotections.dto.MemberJudgeRequestDto;
import jp.co.netprotections.dto.MemberJugdeResponseDto;
import jp.co.netprotections.dto.MembersJudgeRequestDto;
import jp.co.netprotections.dto.MembersJugdeResponseDto;
import jp.co.netprotections.service.MemberJudgeService;

/**
 * @author h.dat
 * MemberJudgeServiceの実装
 *
 */
@Service
public class MemberJudgeServiceImpl implements MemberJudgeService {

	@Override
	public MembersJugdeResponseDto judgeMembers(MembersJudgeRequestDto members) {
		List<MemberJugdeResponseDto> list =new ArrayList<MemberJugdeResponseDto>();
		MembersJugdeResponseDto result =new MembersJugdeResponseDto(list);
		if (members !=null && members.getMemberCandidatesList().size() > 0) {
			for (MemberJudgeRequestDto mem : members.getMemberCandidatesList()) {
				list.add(checkMember(mem));
			}
		}
		return result;
	}
	
	
	private MemberJugdeResponseDto checkMember(MemberJudgeRequestDto member) {
		
		MemberJugdeResponseDto memResult = new MemberJugdeResponseDto();
		memResult.setMemberName(member.getMemberName());
		memResult.setEnlistedProperty(true);
		if (member.getMemberName() != null && !member.getMemberName().isEmpty()) {
			if (member.getEventPlanning() < 1) {
				memResult.setEnlistedProperty(false);
			} else {
				if (member.getCogitation() < 1) {
					memResult.setEnlistedProperty(false);
				}
				if (member.getCoodination() < 1) {
					memResult.setEnlistedProperty(false);
				}
				if ((member.getEventPlanning() + member.getCogitation() + 
						member.getCoodination() + member.getProgrammingAbility() + 
						member.getInfrastructureKnowledge()) < 10) {
					memResult.setEnlistedProperty(false);
				}
			}
		} else {
			memResult.setEnlistedProperty(false);
		}
		return memResult;
	}
	

}
