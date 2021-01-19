package com.cos.movie.domain;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {

	
	public List<Movie> findAll() throws ParseException{
		DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
		Date date1=dateFormat.parse("12/10/2001");
		Date date2=dateFormat.parse("10/06/2002");
		Date date3=dateFormat.parse("20/03/2004");
		Timestamp timeStampDate1=new Timestamp(date1.getTime());
		Timestamp timeStampDate2=new Timestamp(date2.getTime());
		Timestamp timeStampDate3=new Timestamp(date3.getTime());
		
		List<Movie> movies=new ArrayList<>();
		movies.add(new Movie(1,"해리포터와 마법사의 돌",4.5,timeStampDate1));
		movies.add(new Movie(2,"해리포터와 비밀의 방",4.5,timeStampDate2));
		movies.add(new Movie(3,"해리포터와 아즈카반의 죄수",4.5,timeStampDate3));
		return movies;
	}
	
	public Movie findById(int id) throws Exception {
		DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
		Date date1=dateFormat.parse("12/09/2010");
		Timestamp timeStampDate1=new Timestamp(date1.getTime());

		return new Movie(8,"해리포터와 죽음의 성물",4.8,timeStampDate1);
	}
	
	public void save(RegisterReqDto dto) {
		System.out.println("영화 등록 : "+dto);
	}
	
	public void delete(int id) {
		System.out.println("영화 삭제 : "+id+"번 영화 삭제");
	}
	
	public void update(int id, UpdateReqDto dto) {
		System.out.println(""+id+"번 영화 수정하기 ->"+dto);
	}
}
