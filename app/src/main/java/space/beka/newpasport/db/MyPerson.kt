package space.beka.newpasport.db

import android.annotation.SuppressLint
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.*

@Entity
class MyPerson {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

   var ism:String? =null
   var familiya:String? =null
   var otasiningIsmi:String? =null

    @SuppressLint("SimpleDateFormat")
    var date = SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Date())



    constructor()
    constructor(ism: String?, familiya: String?, otasiningIsmi: String?, date: String?) {
        this.ism = ism
        this.familiya = familiya
        this.otasiningIsmi = otasiningIsmi
        this.date = date
    }
}