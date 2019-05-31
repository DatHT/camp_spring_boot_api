package jp.co.netprotections.service;

import jp.co.netprotections.dto.MembersJudgeRequestDto;
import jp.co.netprotections.dto.MembersJugdeResponseDto;

/**
 * @author h.dat
 * MemberJudgeService:ビジネスロジック処理 interface
 *
 */
public interface MemberJudgeService {
	
	/**
	 * 人の入隊基準を満たせるかどうかチェックする
	 * @param members
	 * @return MembersJugdeResponseDto
	 */
	public abstract MembersJugdeResponseDto judgeMembers(MembersJudgeRequestDto members);
}
