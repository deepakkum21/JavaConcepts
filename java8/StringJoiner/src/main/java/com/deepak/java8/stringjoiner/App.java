package com.deepak.java8.stringjoiner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        
        
        Map<String, List<Integer>> innerMap1 = new HashMap<>();
        Map<String, Integer> innerMap2 = new HashMap<>(); 
        innerMap2.put("English", 5);
        
        List<Map> innerAarrayList = new ArrayList<>();
        innerAarrayList.add(innerMap1);
        innerAarrayList.add(innerMap2);
        
        Map<String, List<Integer>> outerMap1 = new HashMap<>();
        Map<String, List<Integer>> outerMap2 = new HashMap<>();
        Map<String, List<Integer>> outerMap3 = new HashMap<>();
        Map<String, List<Map>> outerMap4 = new HashMap<>();
        outerMap1.put("map1key1", new ArrayList<>());
        outerMap1.put("map1key2", new ArrayList<>());
        outerMap1.put("map1key3", new ArrayList<>());
        outerMap1.put("map1key4", new ArrayList<>());
        outerMap2.put("map2key1", new ArrayList<>());
        outerMap2.put("map2key2", new ArrayList<>());
        outerMap2.put("map2key3", new ArrayList<>());
        outerMap2.put("map2key4", new ArrayList<>());
        outerMap3.put("map3key1", new ArrayList<>());
        outerMap3.put("map3key2", new ArrayList<>());
        outerMap3.put("map3key3", new ArrayList<>());
        outerMap3.put("map3key4", new ArrayList<>());
        outerMap4.put("map4key1", innerAarrayList);
        
        List<Map> outerAarrayList = new ArrayList<>();
        outerAarrayList.add(outerMap1);
        outerAarrayList.add(outerMap2);
        outerAarrayList.add(outerMap3);
        outerAarrayList.add(outerMap4);
        
        for(Map map: outerAarrayList) {
        	if(map.size()!=0) {
        		
        	}
        }
        
        Map<String, Integer> a = new HashMap<>();
        System.out.println(a.size());
    }
}
