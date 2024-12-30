package com.example.examfriendlychatter.data

import java.time.Instant
import java.util.Date

class Message (
    var message: String = "",
    var from: String = "",
    // For timestamp på besked
    var timeStamp: Date = Date.from(Instant.now())
)