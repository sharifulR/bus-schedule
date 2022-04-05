package com.example.radiobutton

data class BusSchedule(
    val id:Long,
    val name:String,
    val from:String,
    val to:String,
    val date:String,
    val time:String,
    val busType:String,
)

val scheduleList= mutableListOf<BusSchedule>(
    BusSchedule(id = System.currentTimeMillis(), name = "Hanif", time = "2:00", date = "7/4/2022", busType = "Business", from = "Dhaka", to = "Rajshahi"),
    BusSchedule(id = System.currentTimeMillis(), name = "Hanif", time = "2:00", date = "7/4/2022", busType = "Business", from = "Dhaka", to = "Rajshahi"),
    BusSchedule(id = System.currentTimeMillis(), name = "Hanif", time = "2:00", date = "7/4/2022", busType = "Business", from = "Dhaka", to = "Rajshahi"),
    BusSchedule(id = System.currentTimeMillis(), name = "Hanif", time = "2:00", date = "7/4/2022", busType = "Business", from = "Dhaka", to = "Rajshahi"),
    BusSchedule(id = System.currentTimeMillis(), name = "Hanif", time = "2:00", date = "7/4/2022", busType = "Business", from = "Dhaka", to = "Rajshahi"),
    BusSchedule(id = System.currentTimeMillis(), name = "Hanif", time = "2:00", date = "7/4/2022", busType = "Business", from = "Dhaka", to = "Rajshahi"),
    BusSchedule(id = System.currentTimeMillis(), name = "Hanif", time = "2:00", date = "7/4/2022", busType = "Business", from = "Dhaka", to = "Rajshahi"),
    BusSchedule(id = System.currentTimeMillis(), name = "Hanif", time = "2:00", date = "7/4/2022", busType = "Business", from = "Dhaka", to = "Rajshahi"),
    BusSchedule(id = System.currentTimeMillis(), name = "Hanif", time = "2:00", date = "7/4/2022", busType = "Business", from = "Dhaka", to = "Rajshahi"),
    BusSchedule(id = System.currentTimeMillis(), name = "Hanif", time = "2:00", date = "7/4/2022", busType = "Business", from = "Dhaka", to = "Rajshahi"),
)
