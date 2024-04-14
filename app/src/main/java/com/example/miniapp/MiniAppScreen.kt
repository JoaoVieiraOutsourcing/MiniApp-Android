package com.example.miniapp

import android.content.Context
import android.content.Intent
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.miniapp.ui.AppViewModel
import com.example.miniapp.ui.ShareScreen
import com.example.miniapp.ui.StartScren
import org.jetbrains.annotations.TestOnly

enum class MiniAppScreen() {
    Start,
    Share
}

@Composable
fun MiniAppStart(
    viewModel: AppViewModel = AppViewModel(),
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = MiniAppScreen.Start.name,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(12.dp)
    ) {
        composable(route = MiniAppScreen.Start.name) {
            val context = LocalContext.current
            StartScren(
                onShareButtonClicked = { email: String, subject: String, content: String ->
                    shareEmail(context, email, subject, content)
                },
                onSendButtonClicked = { navController.navigate(MiniAppScreen.Share.name) },
                modifier = modifier
            )
        }
        composable(route = MiniAppScreen.Share.name) {
            ShareScreen(
                onBackButtonClicked = { navController.navigateUp() }
            )
        }
    }
}

private fun shareEmail(context: Context, email: String, subject: String, content: String) {
    var summary = "To: " + email + "\nSubject: " + subject + "\n" + content

    // Create an ACTION_SEND implicit intent with order details in the intent extras
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, email)
        putExtra(Intent.EXTRA_TEXT, summary)
    }

    context.startActivity(
        Intent.createChooser(
            intent,
            context.getString(R.string.share)
        )
    )
}

@VisibleForTesting
internal fun shareEmailTest(email: String, subject: String, content: String): Intent {
    var summary = "To: " + email + "\nSubject: " + subject + "\n" + content

    // Create an ACTION_SEND implicit intent with order details in the intent extras
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, email)
        putExtra(Intent.EXTRA_TEXT, summary)
    }

    return intent
}