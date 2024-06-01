package banking.util

import java.time.Clock
import java.time.Instant.ofEpochMilli
import java.time.LocalDate
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID

fun generateStringUUID() = UUID.randomUUID().toString()

val clock = Clock.systemUTC()

fun now(): ZonedDateTime = ZonedDateTime.now(clock)

fun Long.toZoneDateTimeFromMilli(): ZonedDateTime = ZonedDateTime.ofInstant(ofEpochMilli(this), clock.zone)

fun String.toLocalDate(): LocalDate = LocalDate.parse(this, DateTimeFormatter.ofPattern("dd-MM-yyyy"))

/*
fun toZoneDateTimeFromMilli(epochTime: Long): ZonedDateTime {
    return ZonedDateTime.ofInstant(ofEpochMilli(epochTime), clock.zone)
}*/
