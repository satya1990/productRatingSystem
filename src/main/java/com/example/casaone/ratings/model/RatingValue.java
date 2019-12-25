package com.example.casaone.ratings.model;

import com.google.common.base.Optional;

public enum RatingValue {
	NONE(0), WORSE(1), BAD(2), OK(3), GOOD(4), AWESOME(5);
	private int value;
	/**
	 * @param value of the rating range{1:5}
	 */
	private RatingValue(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public static RatingValue of(int v) {
		RatingValue result = null;
	        for(RatingValue r: RatingValue.values()){
	        	if(r.getValue() == v){
	        		result = r;
	        		break;
	        	}
	        }
	        if(result == null){
	        	throw new IllegalArgumentException();
	        }
	        return result;
	    }
	
}
