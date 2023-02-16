package com.nanioi.composeproject

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import com.nanioi.composeproject.DataProvider.characterList

@Composable
fun HomeContent() {
    val character = remember{ characterList }

    //compose recyclerview
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = character,
            itemContent = {
                CharacterListItem(character = it)
            })
    }
}
