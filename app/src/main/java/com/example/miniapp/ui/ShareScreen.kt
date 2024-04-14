package com.example.miniapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.miniapp.R

@Composable
fun ShareScreen(
    onBackButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            stringResource(R.string.succesful),
            style = MaterialTheme.typography.displaySmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(12.dp)
        )
        Icon(Icons.Rounded.Check, contentDescription = null, 
            modifier = Modifier
                .size(50.dp))
        
        Button(
            onClick = onBackButtonClicked,
            modifier = modifier.padding(top = 50.dp)
        ) {
            Text(stringResource(R.string.back))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShareScreenPreview(
    modifier: Modifier = Modifier
) {
    ShareScreen(
        onBackButtonClicked = {}
    )
}