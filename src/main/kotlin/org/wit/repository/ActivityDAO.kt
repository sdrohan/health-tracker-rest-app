package org.wit.repository

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.wit.db.Activities
import org.wit.domain.ActivityDTO
import org.wit.utilities.mapToActivityDTO

class ActivityDAO {

    //Get all the activities in the database regardless of user id
    fun getAll(): ArrayList<ActivityDTO> {
        val activitiesList: ArrayList<ActivityDTO> = arrayListOf()
        transaction {
            Activities.selectAll().map {
                activitiesList.add(mapToActivityDTO(it)) }
        }
        return activitiesList
    }

    //Find a specific activity by activity id
    fun findByActivityId(id: Int): ActivityDTO?{
        return transaction {
            Activities
                .select() { Activities.id eq id}
                .map{mapToActivityDTO(it)}
                .firstOrNull()
        }
    }

    //Find all activities for a specific user id
    fun findByUserId(userId: Int): List<ActivityDTO>{
        return transaction {
            Activities
                .select {Activities.userId eq userId}
                .map {mapToActivityDTO(it)}
        }
    }

    //Save an activity to the database
    fun save(activityDTO: ActivityDTO){
        transaction {
            Activities.insert {
                it[description] = activityDTO.description
                it[duration] = activityDTO.duration
                it[started] = activityDTO.started
                it[calories] = activityDTO.calories
                it[userId] = activityDTO.userId
            }
        }
    }

}