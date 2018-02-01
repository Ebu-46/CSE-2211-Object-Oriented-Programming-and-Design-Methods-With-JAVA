package com.Ebu;
import edu.duke.*;
import java.util.Scanner;
public class WordLengths {
	public static void countWordLengths(FileResource resource,int counts[]){
		for(String s: resource.words()){
			if(s!=null && s.length()>0){
				if(!Character.isLetter(s.charAt(0))){
					s=s.substring(1,s.length());
				}
				if(!Character.isLetter(s.charAt(s.length()-1))){
					s=s.substring(0,s.length()-1);
				}
			}
			//System.out.println(s);
			counts[s.length()]++;
		}
	}
	public static int indexOfMax(int values[]){
		int ans=0;
		for(int i=0;i<31;i++){
			if(values[ans]<=values[i]) ans=i;
		}
		
		return ans;
	}
	public static void testCountWordLengths(){
		FileResource fr=new FileResource();
		int counts[]=new int [31];
		for(int i=0;i<31;i++){
			counts[i]=0;
		}
		countWordLengths(fr,counts);
		int ans=indexOfMax(counts);
		System.out.println(ans);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testCountWordLengths();
		
	}

}
