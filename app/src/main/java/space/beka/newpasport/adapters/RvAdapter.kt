package space.beka.newpasport.adapters

import android.app.Person
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import space.beka.newpasport.databinding.ItemRvBinding

class RvAdapter(var list: List<space.beka.newpasport.db.Person>) : RecyclerView.Adapter<RvAdapter.Vh>() {
    inner  class Vh(var itemTvBinding: ItemRvBinding):RecyclerView.ViewHolder(itemTvBinding.root) {
        fun onBind(person: space.beka.newpasport.db.Person, position: Int) {
itemTvBinding.tvName.text = person.name
            itemTvBinding.tvLastName.text = person.lastName
            itemTvBinding.tvFatherName.text =person.fatherName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position] ,position)
    }

    override fun getItemCount(): Int =list.size



}