package com.example.week06a.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.example.week06a.component.TextLazyColumnBasic
import com.example.week06a.component.TextLazyRow

@Composable
fun MainScreen1() {
    var dataList= rememberSaveable(saver = listSaver) { mutableStateListOf<String>() }

    dataList.apply {
        repeat(100) {
            add((it + 1).toString())
        }
    }


    Column {
        TextLazyRow(
            dataList,
            Modifier
                .fillMaxWidth()
        )

        TextLazyColumnBasic(
            dataList,
            Modifier
                .fillMaxWidth()
        )
    }
}