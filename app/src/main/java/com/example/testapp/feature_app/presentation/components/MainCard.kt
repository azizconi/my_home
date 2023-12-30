package com.example.testapp.feature_app.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.testapp.feature_app.data.local.entity.camera.CameraEntity
import com.example.testapp.feature_app.data.local.entity.door.DoorEntity

@Composable
fun MainCard(model: CameraEntity) {
    Box(Modifier.padding(vertical = 8.dp)) {
        Column(
            Modifier
                .fillMaxWidth()
                .height(400.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
        ) {

            Image(
                painter = rememberAsyncImagePainter(model = model.snapshot),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentScale = ContentScale.FillBounds
            )


            Text(
                text = model.name ?: " ",
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 32.dp, horizontal = 16.dp)
            )
        }
    }
}


@Composable
fun MainCard(model: DoorEntity) {
    Box(Modifier.padding(vertical = 8.dp)) {
        Column(
            Modifier
                .fillMaxWidth()
                .height(400.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
        ) {

            Image(
                painter = rememberAsyncImagePainter(model = model.snapshot),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentScale = ContentScale.FillBounds
            )


            Text(
                text = model.name ?: "",
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 32.dp, horizontal = 16.dp)
            )
        }
    }
}