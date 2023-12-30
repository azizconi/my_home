package com.example.testapp.feature_app.presentation.main.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.testapp.feature_app.data.local.entity.camera.CameraEntity
import com.example.testapp.feature_app.presentation.components.MainCard

@Composable
fun CameraPageScreen(list: List<CameraEntity>) {


    val cameras = list.groupBy { it.room }


    val lazyState = rememberLazyListState()


    LazyColumn(
        state = lazyState,
        contentPadding = PaddingValues(16.dp)
    ) {
        cameras.forEach {
            item {
                Box(modifier = Modifier.padding(vertical = 16.dp)) {
                    Text(
                        text = it.key ?: "Неизвестно",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

            }
            items(it.value) {
                MainCard(it)
            }
        }
    }


}

