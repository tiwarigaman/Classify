package com.mobile.classify
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val dataSet: List<Subject>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    // ViewHolder class to hold references to the views for each item in the RecyclerView
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val subjectName: TextView = view.findViewById(R.id.subjectName)
        val faculty: TextView = view.findViewById(R.id.faculty)
        val roomNumber: TextView = view.findViewById(R.id.roomNumber)
        val timing: TextView = view.findViewById(R.id.timing)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        val subject = dataSet[position]
        holder.subjectName.text = subject.subjectName
        holder.roomNumber.text = subject.roomNumber
        holder.timing.text = subject.timing
        holder.faculty.text = subject.faculty
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size
}