package com.nganga.robert.cvapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nganga.robert.cvapp.components.DetailsFormField


@Composable
fun EditScreen(
    detailsViewModel: DetailsViewModel,
    onBackPressed: ()->Unit
){
    val personalDetails = detailsViewModel.personalDetails

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
            .verticalScroll(rememberScrollState())
    ) {
        EditScreenAppBar(
            title = "Update Personal Details",
            onBackPressed = onBackPressed
        )
        Spacer(modifier = Modifier.height(16.dp))
        DetailsFormField(
            value = personalDetails.names,
            onValueChanged = detailsViewModel::updateName,
            label = "Name"
        )
        Spacer(modifier = Modifier.height(16.dp))
        DetailsFormField(
            value = personalDetails.slackUserName,
            onValueChanged = detailsViewModel::updateSlackUserName,
            label = "Slack Username"
        )
        Spacer(modifier = Modifier.height(16.dp))
        DetailsFormField(
            value = personalDetails.githubHandle,
            onValueChanged = detailsViewModel::updateGithubHandle,
            label = "Github Handle"
        )
        Spacer(modifier = Modifier.height(16.dp))
        DetailsFormField(
            value = personalDetails.bio,
            onValueChanged = detailsViewModel::updateBio,
            label = "Bio"
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = onBackPressed,
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Save")
        }

    }
}

@Composable
fun EditScreenAppBar(
    title: String,
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onBackPressed
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "back icon"
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}