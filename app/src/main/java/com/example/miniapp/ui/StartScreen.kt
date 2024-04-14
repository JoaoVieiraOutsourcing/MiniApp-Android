package com.example.miniapp.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.miniapp.R
import com.example.miniapp.ui.theme.MiniAppTheme

@Composable
fun StartScren(
    onShareButtonClicked: (String, String, String) -> Unit,
    onSendButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {

    var email by remember { mutableStateOf("") }
    var subject by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }


    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ){
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .padding(horizontal = 40.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EditNumberField(
                label = R.string.email,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                value = email,
                onValueChanged = { email = it },
                modifier = Modifier
                    .padding(bottom = 52.dp)
                    .fillMaxWidth()
            )
            EditNumberField(
                label = R.string.subject,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                value = subject,
                onValueChanged = { subject = it },
                modifier = Modifier
                    .padding(bottom = 52.dp)
                    .fillMaxWidth(),
            )
            EditNumberField(
                label = R.string.content,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                value = content,
                onValueChanged = { content = it },
                minLines = 5,
                maxLines = 5,
                singleLine = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 80.dp),
            )
        }

        Column (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            OutlinedButton(
                modifier = Modifier.widthIn(min = 300.dp).padding(bottom = 12.dp),
                onClick = { onShareButtonClicked(email, subject, content) }
            ) {
                Text(stringResource(R.string.share))
            }
            Button(
                modifier = Modifier.widthIn(min = 300.dp),
                onClick = onSendButtonClicked
            ) {
                Text(stringResource(R.string.send))
            }
        }
    }
}

@Composable
fun EditNumberField(
    @StringRes label: Int,
    keyboardOptions: KeyboardOptions,
    value: String,
    onValueChanged: (String) -> Unit,
    minLines: Int = 1,
    maxLines: Int = 1,
    singleLine: Boolean = true,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        singleLine = singleLine,
        modifier = modifier,
        onValueChange = onValueChanged,
        label = { Text(stringResource(label)) },
        minLines = minLines,
        maxLines = maxLines,
        keyboardOptions = keyboardOptions
    )
}

@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    MiniAppTheme {
        StartScren(
            onShareButtonClicked = {email: String, subject: String, content: String -> },
            onSendButtonClicked = {},
        )
    }
}