package com.nanioi.composeproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

/**
 * iptv 용 화면
 */
@Composable
fun CharacterInfoScreen(character: Character) {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize()) {
        /*
            BoxWithConstraints => 화면의 콘텐츠를 적절하게 조정하고 크기를 조정할 수 있도록 콘텐츠에 화면 높이를 전달하는 데 사용
         */
        BoxWithConstraints {
            Surface { // 머티리얼 디자인
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .horizontalScroll(scrollState),
                ) {
                    CharacterHeader(
                        character,
                        this@BoxWithConstraints.maxWidth
                    )
                    CharacterContent(character,this@BoxWithConstraints.maxWidth/2)
                }
            }
        }
    }
}


@Composable
private fun CharacterHeader(
    character: Character,
    containerWidth: Dp
) {
    Image(
        modifier = Modifier
            .widthIn(max = containerWidth / 2)
            .fillMaxHeight(),
        painter = rememberAsyncImagePainter(character.imageUrl),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}

@Composable
private fun CharacterContent(character: Character, containerWidth: Dp) {
    Column {
        Title(character)

        CharacterDescription(stringResource(R.string.sex), character.sex,containerWidth)
        CharacterDescription(stringResource(R.string.age), character.age.toString(),containerWidth)
        CharacterDescription(stringResource(R.string.personality), character.description,containerWidth)
    }
}

@Composable
private fun Title(
    character: Character
) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 16.dp)) {
        Text(
            text = character.title,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun CharacterDescription(label: String, value: String, containerWidth: Dp) {
    Row(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Text(
            text = label,
            modifier = Modifier.widthIn(containerWidth/5),
            style = MaterialTheme.typography.caption,
        )
        Text(
            text = value,
            modifier = Modifier.width(containerWidth - containerWidth/5),
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Visible
        )
    }
}
