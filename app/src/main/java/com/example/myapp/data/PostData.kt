package com.example.myapp.data

import com.fasterxml.jackson.annotation.JsonProperty

data class PostData (
    @JsonProperty("title") var title:String,
    @JsonProperty("content") var content:String
)