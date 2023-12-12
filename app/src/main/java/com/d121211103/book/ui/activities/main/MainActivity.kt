package com.d121211103.book.ui.activities.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.d121211103.book.data.models.Book
import com.d121211103.book.ui.activities.detail.DetailActivity
import com.d121211103.book.ui.theme.FinalmobileTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalmobileTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        CenterAlignedTopAppBar(
                            title = {
                                Text(
                                    text = "Children's Literature",
                                    fontWeight = FontWeight.SemiBold,
                                )
                            }
                        )
                        val mainViewModel: MainViewModel =
                            viewModel(factory = MainViewModel.Factory)
                        ListBookScreen(mainViewModel.mainUiState)

                    }
                }
            }
        }
    }

    @Composable
    private fun ListBookScreen(mainUiState: MainUiState, modifier: Modifier = Modifier) {
        Box(
            modifier = modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            when (mainUiState) {
                is MainUiState.Loading -> Text(
                    text = "Loading ...",
                    fontSize = 16.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
                is MainUiState.Error -> Text(
                    text = "Error Found",
                    fontSize = 16.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
                is MainUiState.Success -> BookList(
                    books = mainUiState.books,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }

    @Composable
    fun BookList(books: List<Book>, modifier: Modifier = Modifier) {
        LazyVerticalGrid(
            modifier = modifier,
            columns = GridCells.Fixed(2),
        ) {
            items(books) { book ->
                BookItem(book = book)
            }
        }
    }

    @Composable
    fun BookItem(book: Book) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp),)
                .clickable {
                    val intent = Intent(this, DetailActivity::class.java)
                    intent.putExtra("BOOK", book)
                    startActivity(intent)
                }

        ) {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .height(260.dp)
            ){
                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(book.formats?.image_jpeg.toString())
                        .crossfade(true)
                        .build(), contentDescription = book.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(MaterialTheme.shapes.extraSmall),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = book.title.toString(),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }

    @Preview(
        showBackground = true,
        showSystemUi = true
    )

    @Composable
    fun BookListPreview() {
        FinalmobileTheme {
        }
    }
}
