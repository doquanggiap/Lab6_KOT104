package fpoly.giapdqph34273.lab6_kot104.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import fpoly.giapdqph34273.lab6_kot104.Movie
import fpoly.giapdqph34273.lab6_kot104.MovieScreen
import fpoly.giapdqph34273.lab6_kot104.ui.screens.CinemaSeatBookingScreen
import fpoly.giapdqph34273.lab6_kot104.utils.createTheaterSeating

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            MovieScreen(movies = Movie.getSampleMovies())

            CinemaSeatBookingScreen(
                createTheaterSeating(
                    12,
                    9,
                    4,
                    5
                ), 9
            )
        }
    }
}
