package space.beka.newpasport.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MyDao {
    @Insert
    fun addPasport(person: Person)

    @Query("select * from person")
    fun getAllPasports():List<Person>
}