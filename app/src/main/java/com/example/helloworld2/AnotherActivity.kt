package com.example.helloworld2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.helloworld2.ui.theme.HelloWorld2Theme

class AnotherActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloWorld2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top // 顶部对齐
                    ) {
                        val message = intent.getStringExtra("message") ?: "No message received"

                        when (message) {
                            "负八*" -> {
                                Image(
                                    painter = painterResource(id = R.drawable.zyh2), // 替换为负八*对应的图片资源ID
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .fillMaxWidth()
                                        .heightIn(max = 300.dp), // 限制图片高度，根据实际情况调整
                                    contentScale = ContentScale.Crop
                                )
                            }
                            "y." -> {
                                Image(
                                    painter = painterResource(id = R.drawable.yxy3), // 替换为y.对应的图片资源ID
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .fillMaxWidth()
                                        .heightIn(max = 300.dp), // 限制图片高度，根据实际情况调整
                                    contentScale = ContentScale.Crop
                                )
                            }
                            "再也不熬夜" -> {
                                Image(
                                    painter = painterResource(id = R.drawable.wwj), // 替换为再也不熬夜对应的图片资源ID
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .fillMaxWidth()
                                        .heightIn(max = 300.dp), // 限制图片高度，根据实际情况调整
                                    contentScale = ContentScale.Crop
                                )
                            }
                            "眼镜猴" -> {
                                Image(
                                    painter = painterResource(id = R.drawable.zyx), // 替换为眼镜猴对应的图片资源ID
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .fillMaxWidth()
                                        .heightIn(max = 300.dp), // 限制图片高度，根据实际情况调整
                                    contentScale = ContentScale.Crop
                                )
                            }
                            "izyh" -> {
                                Image(
                                    painter = painterResource(id = R.drawable.wjb), // 替换为izyh对应的图片资源ID
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .fillMaxWidth()
                                        .heightIn(max = 300.dp), // 限制图片高度，根据实际情况调整
                                    contentScale = ContentScale.Crop
                                )
                            }
                            else -> {
                                Text("This is $message!")
                            }
                        }

                        Spacer(modifier = Modifier.height(32.dp)) // 增加图片和按钮之间的空间

                        Button(
                            onClick = {
                                // 返回到 MainActivity
                                finish()
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("返回")
                        }
                    }
                }
            }
        }
    }
}
