package com.example.helloworld2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.helloworld2.ui.theme.HelloWorld2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloWorld2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("聊天", modifier = Modifier.padding(vertical = 8.dp))
                        ArtistList()
                    }
                }
            }
        }
    }
}

@Composable
fun ArtistList() {
    val artists = listOf(
        Artist("负八*", R.drawable.a, "Last seen 2 hours ago"),
        Artist("y.", R.drawable.c, "在吗"),
        Artist("再也不熬夜", R.drawable.d, "我是"),
        Artist("眼镜猴", R.drawable.b, "给你带了好吃的"),
        Artist("izyh", R.drawable.e, "想你")
    )
    LazyColumn {
        items(artists.size) { index ->
            ArtistCard(
                artist = artists[index],
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}


@Composable
fun ArtistCard(artist: Artist, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = artist.picture),
            contentDescription = null,
            modifier = Modifier.size(50.dp),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text(artist.name)
            Text(artist.lastSeenOnline)
        }

        Box(
            modifier = Modifier
                .weight(1f) // 将 Box 填充剩余空间
                .padding(start = 8.dp)
        ) {
            // 艺术家信息，垂直排列

            // 右侧图片
            Image(
                painter = painterResource(id = R.drawable.redpoint), // 替换为您的右侧图片资源
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .align(Alignment.CenterEnd) // 将图片放置在右侧末尾
            )
        }
    }

    Button(
        onClick = {
            // 点击按钮时启动 AnotherActivity
            val intent = Intent(context, AnotherActivity::class.java)
            intent.putExtra("message", artist.name)
            context.startActivity(intent)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        Text("点击我")
    }
}

data class Artist(
    val name: String,
    val picture: Int,
    val lastSeenOnline: String
)
