package fpoly.giapdqph34273.lab6_kot104.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fpoly.giapdqph34273.lab6_kot104.model.entities.Seat
import fpoly.giapdqph34273.lab6_kot104.model.entities.SeatStatus
import fpoly.giapdqph34273.lab6_kot104.ui.components.SeatComposable
import fpoly.giapdqph34273.lab6_kot104.utils.createTheaterSeating

@Composable
fun CinemaSeatBookingScreen(
    seats: List<Seat>,
    totalSeatsPerRow: Int
) {
    val textModifier = Modifier
        .padding(
            end = 16.dp,
            start = 4.dp
        )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(12.dp)
    ) {
        Text(
            "Screen",
            modifier = Modifier.padding(16.dp),
            fontStyle = FontStyle.Italic,
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(20.dp))
        LazyVerticalGrid(
            columns =
            GridCells.Fixed(totalSeatsPerRow)
        ) {
            items(seats.size) { index ->
                SeatComposable(seat = seats[index])
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val exampleEmptySeat = remember {
                Seat(
                    'X', 1,
                    SeatStatus.EMPTY
                )
            }
            val exampleSelectedSeat = remember {
                Seat(
                    'Y', 1,
                    SeatStatus.SELECTED
                )
            }
            val exampleBookedSeat = remember {
                Seat(
                    'Z', 1,
                    SeatStatus.BOOKED
                )
            }
            SeatComposable(exampleEmptySeat, false)
            Text(
                text = "Available",
                style = MaterialTheme.typography.titleSmall,
                modifier = textModifier
            )
            SeatComposable(exampleSelectedSeat, false)
            Text(
                text = "Selected",
                style = MaterialTheme.typography.titleSmall,
                modifier = textModifier
            )
            SeatComposable(exampleBookedSeat, false)
            Text(
                text = "Booked",
                style = MaterialTheme.typography.titleSmall,
                modifier = textModifier
            )
        }
    }
}

const val totalRows = 9
const val totalSeatsPerRow = 9
const val aislePositionInRow = 4
const val aislePositionInColumn = 5

@Preview(showBackground = true)
@Composable
fun PreviewCinemaSeatBooking() {
    CinemaSeatBookingScreen(
        createTheaterSeating(
            totalRows,
            totalSeatsPerRow,
            aislePositionInRow,
            aislePositionInColumn
        ), totalSeatsPerRow
    )
}