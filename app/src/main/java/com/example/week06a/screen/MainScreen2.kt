package com.example.week06a.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.example.week06a.component.TextLazyColumnFAB

@Composable
fun MainScreen2() {
    var dataList = rememberSaveable(saver = listSaver) { mutableStateListOf<String>() }

    if (dataList.isEmpty()) {
        dataList.apply {
            repeat(30) {
                add((it + 1).toString())
            }
        }
    }

    Column {
        TextLazyColumnFAB(
            dataList,
            Modifier
                .fillMaxSize()
        )
    }
}