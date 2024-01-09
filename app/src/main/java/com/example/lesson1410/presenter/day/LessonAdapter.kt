package com.example.lesson1410.presenter.day

import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson1410.R
import com.example.lesson1410.data.Day
import com.example.lesson1410.data.Lesson
import com.example.lesson1410.databinding.LessonDayScheduleBinding
import com.example.lesson1410.databinding.ScheduleDayWeekBinding

class LessonAdapter() : RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {

    private val list = mutableListOf<Lesson>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonAdapter.LessonViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding = LessonDayScheduleBinding.inflate(inflator, parent, false)
        return LessonAdapter.LessonViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: LessonAdapter.LessonViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun submitList(list: List<Lesson>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }


    class LessonViewHolder(
        private val binding: LessonDayScheduleBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: Lesson) = with(binding){
            val context = binding.root.context
            lessonName.text = context.getString(R.string.predmet, data.name)
            cabinetName.text = context.getString(R.string.cabinet, data.cabinet)
            presenterName.text = context.getString(R.string.presenter, data.lecturer)
        }
    }


}