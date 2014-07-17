/**
 * Created with IntelliJ IDEA.
 * User: martinpettersson
 * Date: 2014-07-17
 * Time: 21:54
 * To change this template use File | Settings | File Templates.
 */
public class HorrorList {
    Kattio io = new Kattio(System.in, System.out);
    static int N, H, L; static Movie[] movies; static String horrorMovies;

    public static void main(String[] args) {
        new HorrorList();
    }

    public HorrorList() {
        handleInput();
        printInput();
        calculateHorrorIndex();
    }

    void calculateHorrorIndex() {
        for(Movie movie : movies) {
            if (horrorMovies.contains(String.valueOf(movie.movieId)))
                movie.horrorIndex = 0;
            if (horrorMovies.contains(String.valueOf(movie.similarMovie)))
                movie.similarMovieIsBad = true;
        }
    }


    void printInput() {
        System.err.println(N + " " + H + " " + L);
        System.err.println(horrorMovies);
        for (Movie movie : movies)
            System.err.println(movie.movieId + " " + movie.similarMovie);
    }

    // Handles the input as specified.
    void handleInput() {
        // This is the first line of input data.
        N = io.getInt(); H = io.getInt(); L = io.getInt();
        // Second line.
        horrorMovies = "";
        for(int horrorMovie = 0; horrorMovie < H; horrorMovie++)
            horrorMovies += io.getInt() + " ";
        // Handle following L lines.
        movies = new Movie[L];
        for (int movieIndex = 0; movieIndex < L; movieIndex++)
            movies[movieIndex] = new Movie(io.getInt(), io.getInt());
    }

    // Data structure for storing a Movie ID along with a similar Movie ID,
    // all according to specs.
    class Movie {
        final int movieId;
        final int similarMovie;
        int horrorIndex;
        boolean similarMovieIsBad = false;
        Movie(int movieId, int similarMovie) { this.movieId = movieId; this.similarMovie = similarMovie; }
        // depending on your use case, equals? hashCode?  More methods?
    }
}
