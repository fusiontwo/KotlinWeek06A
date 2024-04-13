package com.example.week06a.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.example.week06a.component.TextLazyColumnStickyHeader

@Composable
fun MainScreen4() {
    var dataList= rememberSaveable(saver = listSaver) { mutableStateListOf<String>() }

    if (dataList.isEmpty()) {
        dataList.apply {
            repeat(30) {
                this.add((it + 1).toString())
            }
        }
    }

    Column {
        TextLazyColumnStickyHeader(
            dataList,
            Modifier
                .fillMaxSize()
        )
    }
}