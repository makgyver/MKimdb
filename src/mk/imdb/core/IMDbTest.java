package mk.imdb.core;


import mk.imdb.entity.IMDbMovie;
import mk.imdb.exception.IMDbResponseException;
import mk.imdb.utils.Log;

public class IMDbTest {

	public static void main(String[] args) {
		
		IMDbSearchByIdParameters params = new IMDbSearchByIdParameters("tt1375666");
		
		//params.setAka(IMDbVerbosity.FULL);
		//params.setRelease(IMDbVerbosity.FULL);
		//params.setOffset(0);
		
		IMDbMovie movie = null;
		try {
			movie = IMDbMovie.searchMovieById(params);
		} catch (IMDbResponseException e) {
			Log.print(e);
		}
		
		System.out.println(movie);

	}

}
