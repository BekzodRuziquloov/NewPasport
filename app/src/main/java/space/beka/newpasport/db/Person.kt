package space.beka.newpasport.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class Person : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
    var name:String? = null
    var lastName:String? = null
    var fatherName:String? = null

    constructor(name: String?, lastName: String?, fatherName: String?) {
        this.name = name
        this.lastName = lastName
        this.fatherName = fatherName
    }

    constructor()
}