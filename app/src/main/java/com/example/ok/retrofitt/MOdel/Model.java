package com.example.ok.retrofitt.MOdel;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Model{

	@SerializedName("articles")
	private List<ArticlesItem> articles;

	@SerializedName("status")
	private String status;

	public void setArticles(List<ArticlesItem> articles){
		this.articles = articles;
	}

	public List<ArticlesItem> getArticles(){
		return articles;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Model{" + 
			"articles = '" + articles + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}