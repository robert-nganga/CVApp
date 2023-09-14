package com.nganga.robert.cvapp

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nganga.robert.cvapp.components.Attribute


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onEditClick: ()->Unit,
    detailsViewModel: DetailsViewModel
){
    val personalDetails = detailsViewModel.personalDetails


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MediumTopAppBar(
                title = {
                    Text(text = "Personal Info")
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onEditClick
            ) {
                Icon(
                    imageVector = Icons.Outlined.Edit,
                    contentDescription = "edit"
                )
            }
        }
    ) {  padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Attribute(title = "Full Name", value = personalDetails.names)
            Spacer(modifier = Modifier.height(16.dp))
            Attribute(title = "Slack Username", value = personalDetails.slackUserName)
            Spacer(modifier = Modifier.height(16.dp))
            Attribute(title = "Github Handle", value = personalDetails.githubHandle)
            Spacer(modifier = Modifier.height(16.dp))
            Attribute(title = "Bio", value = personalDetails.bio)
        }
    }
}
