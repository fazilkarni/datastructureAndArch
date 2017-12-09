package com.cisco.company.tesco;

import java.util.HashMap;
import java.util.Map;

public class SortMillionRecordshavingOnly0To9 {

	public static void main(String[] args) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		int[] array = {1,2,3,0,1,0,0,1,0,2,3,4,1,1,0,0,4,5,6,7,8,9,9,8,7,6,2,3};
		int i=0;
		for(;i<array.length;i++){
			if(map.get(array[i])==null){
				map.put(array[i],1) ;
			}else{
				map.put(array[i],map.get(array[i])+1) ;
			}
			
		}
		
		System.out.println(map);
		System.out.println("i : "+i);
	}

}
