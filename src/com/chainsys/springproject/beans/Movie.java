package com.chainsys.springproject.beans;

public class Movie {

	public String title;
	public String director;
	public Movie(String filmtitle,String filmdirector) 
	{
		// this.title=title;  //this.title is global variable and title is a local variable
		title=filmtitle;  // This is similar to this.title=filmtitle, but using this. prefix is not compulsory
		director=filmdirector; // This is similar to this.director=filmdirector but using this. prefix is not compulsory
		// as there are no local variable by name title, or director so here they will implicitly referred to global variable
		// If the parameter names are similar to the global variables
		// Note: If title and director are not globally declare then it will be cannot be resolved to a variable
		// then there is an ambiguity between the local variable (parameters) and global variable
		// Hence this .prefix is used for referring the global variable
		// title=title will be referring the local variable on both sides = operator (x=x) Self assigning
	
	System.out.println(title);
	System.out.println(director);
	}
}

