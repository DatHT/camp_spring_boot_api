package jp.co.netprotections.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author h.dat
 * MemberJudgeRequestDtoのリストの項目
 *
 */
public class MemberJudgeRequestDto {
	private String memberName;
	
	@NotNull
	@Min(value = 0, message = "Id can't be less than 0 or bigger than 5")
	@Max(5)
	private Integer eventPlanning;
	
	@NotNull
	@Min(value = 0, message = "Id can't be less than 0 or bigger than 5")
	@Max(5)
	private Integer cogitation;
	
	@NotNull
	@Min(value = 0, message = "Id can't be less than 0 or bigger than 5")
	@Max(5)
	private Integer coodination;
	
	@NotNull
	@Min(value = 0, message = "Id can't be less than 0 or bigger than 5")
	@Max(5)
	private Integer programmingAbility;
	
	@NotNull
	@Min(value = 0, message = "Id can't be less than 0 or bigger than 5")
	@Max(5)
	private Integer infrastructureKnowledge;
	
	public MemberJudgeRequestDto() {
		// TODO Auto-generated constructor stub
	}

	public MemberJudgeRequestDto(String memberName, @Min(0) @Max(5) Integer eventPlanning,
			@Min(0) @Max(5) Integer cogitation, @Min(0) @Max(5) Integer coodination,
			@Min(0) @Max(5) Integer programmingAbility, @Min(0) @Max(5) Integer infrastructureKnowledge) {
		super();
		this.memberName = memberName;
		this.eventPlanning = eventPlanning;
		this.cogitation = cogitation;
		this.coodination = coodination;
		this.programmingAbility = programmingAbility;
		this.infrastructureKnowledge = infrastructureKnowledge;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Integer getEventPlanning() {
		return eventPlanning;
	}

	public void setEventPlanning(Integer eventPlanning) {
		this.eventPlanning = eventPlanning;
	}

	public Integer getCogitation() {
		return cogitation;
	}

	public void setCogitation(Integer cogitation) {
		this.cogitation = cogitation;
	}

	public Integer getCoodination() {
		return coodination;
	}

	public void setCoodination(Integer coodination) {
		this.coodination = coodination;
	}

	public Integer getProgrammingAbility() {
		return programmingAbility;
	}

	public void setProgrammingAbility(Integer programmingAbility) {
		this.programmingAbility = programmingAbility;
	}

	public Integer getInfrastructureKnowledge() {
		return infrastructureKnowledge;
	}

	public void setInfrastructureKnowledge(Integer infrastructureKnowledge) {
		this.infrastructureKnowledge = infrastructureKnowledge;
	}

	
	
	
}
