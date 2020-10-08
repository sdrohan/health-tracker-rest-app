package org.wit.domain

import org.joda.time.DateTime

data class ActivityDTO (var id: Int,
                        var description:String,
                        var duration: Double,
                        var calories: Int,
                        var started: DateTime,
                        var userId: Int)