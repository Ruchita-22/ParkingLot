package com.scaler.modal;

import com.scaler.modal.enums.VechileType;

public class Vechile {
	private Long id;
	private String vechileNumber;
	private VechileType vechileType;
	
	
	//getter
	public Long getId() {
		return id;
	}
	public String getVechileNumber() {
		return vechileNumber;
	}
	public VechileType getVechileType() {
		return vechileType;
	}
	//setter
	public void setId(Long id) {
		this.id = id;
	}
	public void setVechileNumber(String vechileNumber) {
		this.vechileNumber = vechileNumber;
	}
	public void setVechileType(VechileType vechileType) {
		this.vechileType = vechileType;
	}
	
	@Override
	public String toString() {
		return "Vechile [id=" + id + ", vechileNumber=" + vechileNumber + ", vechileType=" + vechileType + "]";
	}
	
	
	
}
