package com.nanioi.composeproject

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import com.nanioi.composeproject.ui.theme.ComposeProjectTheme

@Suppress("DEPRECATION")
class CharacterInfoActivity : ComponentActivity() {

    companion object {
        private const val CHARACTER_ID = "character_id"
        fun newIntent(context: Context, character: Character) =
            Intent(context, CharacterInfoActivity::class.java).apply {
                putExtra(CHARACTER_ID, character)
            }
    }

    private val character: Character by lazy {
        intent?.getSerializableExtra(CHARACTER_ID) as Character
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {
                if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                    CharacterMobileScreen(character = character)
                } else {
                    CharacterInfoScreen(character = character)
                }
            }
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        setContent {
            ComposeProjectTheme {
                if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
                    CharacterMobileScreen(character = character)
                } else {
                    CharacterInfoScreen(character = character)
                }
            }
        }
    }
}