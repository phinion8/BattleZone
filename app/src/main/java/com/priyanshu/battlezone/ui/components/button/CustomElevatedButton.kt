package com.priyanshu.battlezone.ui.components.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.priyanshu.battlezone.ui.theme.green
import com.priyanshu.battlezone.ui.theme.white

@Composable
fun CustomElevatedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String
) {

    ElevatedButton(
        onClick = {
            onClick()
        }, shape = CircleShape,
        modifier = modifier
            .fillMaxWidth(0.9f),
        colors = ButtonDefaults.buttonColors(containerColor = green)
    ) {
        Text(
            modifier = Modifier.padding(
                vertical = 4.dp
            ),
            text = text,
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold, color = white)
        )

    }

}