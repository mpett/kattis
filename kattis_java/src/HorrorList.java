/**
 * Created with IntelliJ IDEA.
 * User: martinpettersson
 * Date: 2014-07-17
 * Time: 21:54
 * To change this template use File | Settings | File Templates.
 */
public class HorrorList {
    Kattio io = new Kattio(System.in, System.out);
    static int N, H, L; static Movie[] movies; static String horrorMovies; static int[] horrorIndices;
    final static int INFINITY = 999999999;

    public static void main(String[] args) {
        new HorrorList();
    }

    public HorrorList() {
        handleInput();
        calculateHorrorIndex();
        printOutput();
    }

    void calculateHorrorIndex() {


        horrorIndexHelper();
    }

    void printOutput() {
        for (int i = 0; i < N; i++) {
            System.err.println("Movie: " + i + ": " + horrorIndices[i]);
        }
    }


    void horrorIndexHelper() {
        for(Movie movie : movies) {
            int thisMovie = movie.movieId;
            int similar = movie.similarMovie;

            if ( (horrorMovies.contains(String.valueOf(thisMovie))) && (horrorMovies.contains(String.valueOf(similar))) ) {
                horrorIndices[thisMovie] = 0; horrorIndices[similar] = 0; continue;
            }

            if ( (horrorMovies.contains(String.valueOf(thisMovie))) && !(horrorMovies.contains(String.valueOf(similar))) ) {
                horrorIndices[thisMovie] = 0; horrorIndices[similar] = 1;
            }
            if ( !(horrorMovies.contains(String.valueOf(thisMovie))) && (horrorMovies.contains(String.valueOf(similar))) ) {
                horrorIndices[thisMovie]++;
            }

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
        horrorIndices = new int[N];
        System.err.println(N);
        for (int horrorIndex = 0; horrorIndex < N; horrorIndex++)
            horrorIndices[horrorIndex] = INFINITY;

    }

    // Data structure for storing a Movie ID along with a similar Movie ID,
    // all according to specs.
    class Movie {
        int movieId, similarMovie;
        boolean similarIsBad = false;
        Movie(int movieId, int similarMovie) { this.movieId = movieId; this.similarMovie = similarMovie; }
        void swap() {
            similarMovie = movieId;
            movieId = similarMovie;
        }
    }
}
