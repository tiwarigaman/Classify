package com.mobile.classify

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class dayFragment : Fragment() {
    private val ARG_DAY = "arg_day"

    fun newInstance(day: String): dayFragment {
        val fragment = dayFragment()
        val args = Bundle()
        args.putString(ARG_DAY, day)
        fragment.arguments = args
        return fragment
    }

    private var day: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            day = it.getString(ARG_DAY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_day, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewDay)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference(day!!)
        val dataList = mutableListOf<Subject>()

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (childSnapshot in snapshot.children) {
                        val teacherName = childSnapshot.child("teachername").value.toString()
                        val className = childSnapshot.child("classname").value.toString()
                        val roomNumber = childSnapshot.child("roomno").value.toString()
                        val time = childSnapshot.child("time").value.toString()
                        val main = Subject(className, teacherName, time, roomNumber)
                        dataList.add(main)
                        Log.d(TAG, "Child value is: $main")
                    }
                    recyclerView.adapter = MyAdapter(dataList)
                } else {
                    Log.d(TAG, "No data available")
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
    }

}