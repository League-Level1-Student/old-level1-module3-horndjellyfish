
public class Netflix {
	public static void main(String[] args) {
		Movie movie1 = new Movie("BohemianRhapsody", 4);
		Movie movie2 = new Movie("FirstMan", 4);
		Movie movie3 = new Movie("Jumanji", 4);
		Movie movie4 = new Movie("Avengers", 4);
		Movie movie5 = new Movie("JusticeLeague", 1);
		String price = movie1.getTicketPrice();
		System.out.println(price);
		NetflixQueue q = new NetflixQueue();
		q.addMovie(movie1);
		q.addMovie(movie2);
		q.addMovie(movie3);
		q.addMovie(movie4);
		q.addMovie(movie5);
		
	}
}
