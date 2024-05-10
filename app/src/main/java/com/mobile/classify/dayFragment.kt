package com.mobile.classify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

        val myDataset = listOf(
            Subject("Math", "Room 101", "9:00 AM", "John Doe"),
            Subject("Science", "Room 102", "10:00 AM", "Jane Smith"),
            Subject("History", "Room 103", "11:00 AM", "Michael Johnson"),
            Subject("English", "Room 104", "12:00 PM", "Emily Williams"),
            Subject("Computer Science", "Room 105", "1:00 PM", "David Brown"),
            Subject("Math", "Room 101", "9:00 AM", "John Doe"),
            Subject("Science", "Room 102", "10:00 AM", "Jane Smith"),
            Subject("History", "Room 103", "11:00 AM", "Michael Johnson"),
            Subject("English", "Room 104", "12:00 PM", "Emily Williams"),
            Subject("Computer Science", "Room 105", "1:00 PM", "David Brown"),
            Subject("Math", "Room 101", "9:00 AM", "John Doe"),
            Subject("Science", "Room 102", "10:00 AM", "Jane Smith"),
            Subject("History", "Room 103", "11:00 AM", "Michael Johnson"),
            Subject("English", "Room 104", "12:00 PM", "Emily Williams"),
            Subject("Computer Science", "Room 105", "1:00 PM", "David Brown"),
            Subject("Math", "Room 101", "9:00 AM", "John Doe"),
            Subject("Science", "Room 102", "10:00 AM", "Jane Smith"),
            Subject("History", "Room 103", "11:00 AM", "Michael Johnson"),
            Subject("English", "Room 104", "12:00 PM", "Emily Williams"),
            Subject("Computer Science", "Room 105", "1:00 PM", "David Brown"),
            Subject("Math", "Room 101", "9:00 AM", "John Doe"),
            Subject("Science", "Room 102", "10:00 AM", "Jane Smith"),
            Subject("History y", "Room 113", "11:00 AM", "Michael Johnson"),
            Subject("English", "Room 104", "12:00 PM", "Emily Williams"),
            Subject("Computer Science", "Room 105", "1:00 PM", "David Brown")
        )
        recyclerView.adapter = MyAdapter(myDataset)
    }
}