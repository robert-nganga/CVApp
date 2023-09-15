package com.nganga.robert.cvapp

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                .padding(horizontal = 10.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Personal Info",
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(10.dp))
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
