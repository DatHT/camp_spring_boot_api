package jp.co.netprotections.dto;

/**
 * @author h.dat
 * MemberJugdeResponseDtoのリストの項目
 *
 */
public class MemberJugdeResponseDto {
	private String memberName;
	private boolean enlistedProperty;
	
	public MemberJugdeResponseDto() {
		// TODO Auto-generated constructor stub
	}
	public MemberJugdeResponseDto(String memberName, boolean enlistedProperty) {
		super();
		this.memberName = memberName;
		this.enlistedProperty = enlistedProperty;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public boolean isEnlistedProperty() {
		return enlistedProperty;
	}
	public void setEnlistedProperty(boolean enlistedProperty) {
		this.enlistedProperty = enlistedProperty;
	}
	
}
