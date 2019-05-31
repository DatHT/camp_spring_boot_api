package jp.co.netprotections.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import jp.co.netprotections.AbstractTest;
import jp.co.netprotections.dto.MemberJudgeRequestDto;
import jp.co.netprotections.dto.MemberJugdeResponseDto;
import jp.co.netprotections.dto.MembersJudgeRequestDto;
import jp.co.netprotections.dto.MembersJugdeResponseDto;

public class MemberJudgeControllerTest extends AbstractTest {
	
	@Override
    @Before
    public void setUp() {
       super.setUp();
    }
	
	@Test
	public void testCheckUsers() throws Exception {
		String uri ="/api/v1/check";
		MemberJudgeRequestDto dat = new MemberJudgeRequestDto("dat", 5, 5, 5, 5, 5);
		MemberJudgeRequestDto huynh = new MemberJudgeRequestDto("huynh", 0, 5, 5, 5, 5);
		List<MemberJudgeRequestDto> list = new ArrayList<MemberJudgeRequestDto>();
		list.add(dat);
		list.add(huynh);
		MembersJudgeRequestDto requestDto = new MembersJudgeRequestDto(list);
		String inputJson =super.mapToJson(requestDto);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
		         .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
		         .content(inputJson)).andReturn();
		
		MembersJugdeResponseDto convertedObject = new Gson().fromJson(mvcResult.getResponse().getContentAsString(), MembersJugdeResponseDto.class);
		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals(2, convertedObject.getJudgedCandidatesResultList().size());
		for (MemberJugdeResponseDto dto : convertedObject.getJudgedCandidatesResultList()) {
			if (dto.getMemberName().equals("dat")) {
				Assert.assertEquals(true, dto.isEnlistedProperty());
			}
			if (dto.getMemberName().equals("huynh")) {
				Assert.assertEquals(false, dto.isEnlistedProperty());
			}
		}
	}
	
	@Test
	public void testCheckUsersUnsualCase() throws Exception {
		String uri ="/api/v1/check";
		MemberJudgeRequestDto dat = new MemberJudgeRequestDto("dat", 5, 5, 5, 5, 5);
		MemberJudgeRequestDto huynh = new MemberJudgeRequestDto("huynh", 0, 5, 5, 5, 7);
		List<MemberJudgeRequestDto> list = new ArrayList<MemberJudgeRequestDto>();
		list.add(dat);
		list.add(huynh);
		MembersJudgeRequestDto requestDto = new MembersJudgeRequestDto(list);
		String inputJson =super.mapToJson(requestDto);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
		         .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
		         .content(inputJson)).andReturn();
		
		assertEquals(400, mvcResult.getResponse().getStatus());
	}
}
