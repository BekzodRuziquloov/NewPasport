package space.beka.newpasport.fragments

import android.Manifest
import android.app.AlertDialog
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import space.beka.newpasport.R
import space.beka.newpasport.adapters.RvAdapter
import space.beka.newpasport.databinding.FragmentAddBinding
import space.beka.newpasport.db.AppDatabase
import space.beka.newpasport.db.Person
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    private lateinit var list: ArrayList<Person>
    private lateinit var appDatabase: AppDatabase
    private lateinit var adapter: RvAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(layoutInflater)

binding.addImage.setOnClickListener {


//        val getImageContent =
//            registerForActivityResult(ActivityResultContracts.GetContent()) {
//                it ?: return@registerForActivityResult
//                binding.addImage.setImageURI(it)
//                val inputStream = requireActivity().contentResolver.openInputStream(it)
//                val title = SimpleDateFormat("yyyyMMdd_hhmmss").format(Date())
//                val file = File(requireActivity().filesDir, "$title.jpg")
//                val fileOutputStream = FileOutputStream(file)
//                inputStream?.copyTo(fileOutputStream)
//                inputStream?.close()
//                fileOutputStream.close()
//                absolutePath = file.absolutePath
//                Toast.makeText(context, "$absolutePath", Toast.LENGTH_SHORT).show()
//            }
//
//

}

        appDatabase = AppDatabase.getInstance(binding.root.context)
        list = ArrayList()
        list.addAll(appDatabase.myDao().getAllPasports())
        adapter = RvAdapter(list)

        binding.apply {
            rvList.adapter = adapter
            binding.btnSave.setOnClickListener {
                val myCard = Person(
                    edtName.text.toString()+ " <-Ismi",
                    edtLastName.text.toString()+" <-Familiyasi",
                    edtFatherName.text.toString() +" <-Otasining ismi",


                )
                appDatabase.myDao().addPasport(myCard)
                Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show()
                list.add(myCard)
                adapter.notifyItemInserted(list.size-1)
            }
        }

        return binding.root
    }


}