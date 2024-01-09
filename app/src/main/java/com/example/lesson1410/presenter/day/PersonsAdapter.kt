package com.example.lesson1410.presenter.day

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Spinner
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.lesson1410.R
import com.example.lesson1410.data.Day
import com.example.lesson1410.data.Days
import com.example.lesson1410.data.Lesson
import com.example.lesson1410.databinding.ScheduleDayWeekBinding

class PersonsAdapter() : RecyclerView.Adapter<PersonsAdapter.PersonViewHolder>() {

    private val list = mutableListOf<Day>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val inflator = LayoutInflater.from((parent.context))
        val binding = ScheduleDayWeekBinding.inflate(inflator, parent, false)
        return  PersonViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun submitList(list: List<Day>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class PersonViewHolder(
        private val binding: ScheduleDayWeekBinding
    ) : RecyclerView.ViewHolder(binding.root){
        private var adapter = LessonAdapter()
        fun bind(data: Day) = with(binding){
            dayName.text = data.ofWeek.name
            //    startWeek.text = data.startsWith.toString()
            lessonSchedule.adapter = this@PersonViewHolder.adapter
            val dividerItemDecoration = DividerItemDecoration(lessonSchedule.context, LinearLayoutManager.VERTICAL)
            lessonSchedule.addItemDecoration(dividerItemDecoration)
            this@PersonViewHolder.adapter.submitList(data.lessons)
        }
    }


}