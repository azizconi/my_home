package com.example.testapp.feature_app.presentation.main.page

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.testapp.feature_app.data.local.entity.door.DoorEntity
import com.example.testapp.feature_app.presentation.components.MainCard

@Composable
fun DoorPageScreen(list: List<DoorEntity>) {

    val lazyState = rememberLazyListState()

    LazyColumn(
        state = lazyState,
        contentPadding = PaddingValues(16.dp)
    ) {
        items(list) {
            MainCard(it)
        }
    }

}