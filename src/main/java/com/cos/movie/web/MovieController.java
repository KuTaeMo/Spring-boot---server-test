package com.cos.movie.web;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.movie.domain.CommonDto;
import com.cos.movie.domain.Movie;
import com.cos.movie.domain.MovieRepository;
import com.cos.movie.domain.RegisterReqDto;
import com.cos.movie.domain.UpdateReqDto;

@RestController
public class MovieController {
	
	private MovieRepository movieRepository;
	
	public MovieController(MovieRepository movieRepository){
		this.movieRepository=movieRepository;
	}
	// http://localhost:8000/movie
	@GetMapping("/movie")
	public CommonDto<List<Movie>> findAll() throws Exception{
		return new CommonDto<>(HttpStatus.OK.value(),movieRepository.findAll());
	}
	
	@GetMapping("/movie/{id}")
	public CommonDto<Movie> findById(@PathVariable int id) throws Exception{
		return new CommonDto<>(HttpStatus.OK.value(),movieRepository.findById(id));
	}
	
	@PostMapping("/movie")
	public CommonDto<?> save(@Valid @RequestBody RegisterReqDto dto, BindingResult bindingResult){
		movieRepository.save(dto);
		
		return new CommonDto<>(HttpStatus.OK.value(),"ok");
	}
	
	@DeleteMapping("/movie/{id}")
	public CommonDto<String> delete(@PathVariable int id){
		movieRepository.delete(id);
		if(id==8) {
			return new CommonDto<>(HttpStatus.OK.value(),"ok");
		}else {
			return new CommonDto<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),"fail");
		}
	}
	
	@PutMapping("/movie/{id}")
	public CommonDto<String> update(@PathVariable int id,@Valid @RequestBody UpdateReqDto dto, BindingResult bindingResult){
		movieRepository.update(id, dto);
		return new CommonDto<>(HttpStatus.OK.value(),"ok");
	}
}
