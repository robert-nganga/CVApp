package com.nganga.robert.cvapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.nganga.robert.cvapp.model.Person

class DetailsViewModel: ViewModel() {

    var personalDetails by mutableStateOf(myDetails)
        private set


    fun updateName(name: String){
        personalDetails = personalDetails.copy(names = name)
    }

    fun updateGithubHandle(handle: String){
        personalDetails = personalDetails.copy(githubHandle = handle)
    }

    fun updateSlackUserName(userName: String){
        personalDetails = personalDetails.copy(slackUserName = userName)
    }

    fun updateBio(bio: String){
        personalDetails = personalDetails.copy(bio = bio)
    }
}

val myDetails = Person(
    names = "Robert Nganga",
    slackUserName = "robert nganga",
    githubHandle = "@robert-nganga",
    bio = "A passionate mobile developer"
)