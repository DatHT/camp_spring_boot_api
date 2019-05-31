package jp.co.netprotections.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.netprotections.dto.MemberJudgeRequestDto;
import jp.co.netprotections.dto.MemberJugdeResponseDto;
import jp.co.netprotections.dto.MembersJudgeRequestDto;
import jp.co.netprotections.dto.MembersJugdeResponseDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberJudgeServiceTest {
	@Autowired
	private MemberJudgeService service;
	
	
	@Test
	public void testJudgeMembers() {
		MemberJudgeRequestDto dat = new MemberJudgeRequestDto("dat", 5, 5, 5, 5, 5);
		MemberJudgeRequestDto huynh = new MemberJudgeRequestDto("huynh", 0, 5, 5, 5, 5);
		List<MemberJudgeRequestDto> list = new ArrayList<MemberJudgeRequestDto>();
		list.add(dat);
		list.add(huynh);
		MembersJudgeRequestDto requestDto = new MembersJudgeRequestDto(list);
		MembersJugdeResponseDto result =service.judgeMembers(requestDto);
		Assert.assertEquals(2, result.getJudgedCandidatesResultList().size());
		for (MemberJugdeResponseDto dto : result.getJudgedCandidatesResultList()) {
			if (dto.getMemberName().equals("dat")) {
				Assert.assertEquals(true, dto.isEnlistedProperty());
			}
			if (dto.getMemberName().equals("huynh")) {
				Assert.assertEquals(false, dto.isEnlistedProperty());
			}
		}
	}
}
