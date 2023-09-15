package com.nganga.robert.cvapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
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
    detailsViewModel: DetailsViewModel
){
    val personalDetails = detailsViewModel.personalDetails

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        EditScreenAppBar(title = "Update Personal Details")
        Spacer(modifier = Modifier.height(16.dp))
        DetailsFormField(
            value = personalDetails.names,
            onValueChanged = detailsViewModel::updateName
        )
        Spacer(modifier = Modifier.height(10.dp))
        DetailsFormField(
            value = personalDetails.slackUserName,
            onValueChanged = detailsViewModel::updateSlackUserName
        )
        Spacer(modifier = Modifier.height(10.dp))
        DetailsFormField(
            value = personalDetails.githubHandle,
            onValueChanged = detailsViewModel::updateGithubHandle
        )
        Spacer(modifier = Modifier.height(10.dp))
        DetailsFormField(
            value = personalDetails.bio,
            onValueChanged = detailsViewModel::updateBio
        )

    }
}

@Composable
fun EditScreenAppBar(
    title: String,
    modifier: Modifier = Modifier
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "back icon"
        )
        Spacer(modifier = Modifier.width(30.dp))
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}