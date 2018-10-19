package com.yuansong.global;

public enum FixedListType {
	DBType(0),CrmRelationShip(1);
	
	private int value;
	
	private FixedListType(int value) {
		this.value = value;
	}
	
	@Override  
    public String toString() {  
        switch(value) {
			case 0:
				return "DBType";
			case 1:
				return "CrmRelationShip";
			default:
				throw new RuntimeException("未定义的枚举类型值");
        }
    }
	
}
