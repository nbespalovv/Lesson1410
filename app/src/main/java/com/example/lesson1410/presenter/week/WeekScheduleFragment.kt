package com.example.lesson1410.presenter.week

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lesson1410.data.Day
import com.example.lesson1410.data.Days
import com.example.lesson1410.data.Lesson
import com.example.lesson1410.databinding.FragmentWeekSchBinding
import com.example.lesson1410.presenter.day.PersonsAdapter
import java.time.LocalDate
import java.util.Calendar
import java.util.Date

class WeekScheduleFragment : Fragment() {

    private var binding : FragmentWeekSchBinding? = null
    private var adapter: PersonsAdapter? = null
    val calendarDay = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    val dayOfWeekString = when (calendarDay) {
        Calendar.SUNDAY -> "Sunday"
        Calendar.MONDAY -> "Monday"
        Calendar.TUESDAY -> "Tuesday"
        Calendar.WEDNESDAY -> "Wednesday"
        Calendar.THURSDAY -> "Thursday"
        Calendar.FRIDAY -> "Friday"
        Calendar.SATURDAY -> "Saturday"
        else -> "Неизвестный день"
    }


    val schedule = listOf<Day>(
        Day(
            ofWeek = Days.Monday,
            startsWith = 1,
            lessons = listOf<Lesson>(
                Lesson(
                    name = "Выходной",
                    lecturer = "",
                    cabinet = ""
                )
            )
        ),
        Day(
            ofWeek = Days.Tuesday,
            startsWith = 1,
            lessons = listOf<Lesson>(
                Lesson(
                    name = "Экономика программной инженерии (Лек)",
                    lecturer = "Ткач Е.С.",
                    cabinet = "221 (2 корпус)"
                ),
                Lesson(
                    name = "Окно",
                    lecturer = "",
                    cabinet = ""
                ),
                Lesson(
                    name = "Базы и хранилища данных (Лек)",
                    lecturer = "Барабанщиков И.В.",
                    cabinet = "413"
                ),
                Lesson(
                    name = "Базы и хранилища данных (Лек)",
                    lecturer = "Барабанщиков И.В.",
                    cabinet = "413"
                ),
            )
        ),
        Day(
            ofWeek = Days.Wednesday,
            startsWith = 1,
            lessons = listOf<Lesson>(
                Lesson(
                    name = "УПРАВЛЕНИЕ ИТ-ПРОЕКТАМИ И ЖИЗНЕННЫМ ЦИКЛОМ ПО (ЛЕК.)",
                    lecturer = " Владислав, Андрей",
                    cabinet = "А-15"
                ),
                Lesson(
                    name = "УПРАВЛЕНИЕ ИТ-ПРОЕКТАМИ И ЖИЗНЕННЫМ ЦИКЛОМ ПО (ЛЕК.)",
                    lecturer = " Владислав, Андрей",
                    cabinet = "А-15"
                ),
            )
        ),
        Day(
            ofWeek = Days.Thursday,
            startsWith = 1,
            lessons = listOf<Lesson>(
                Lesson(
                    name = "Выходной",
                    lecturer = "",
                    cabinet = ""
                )
            )
        ),
        Day(
            ofWeek = Days.Friday,
            startsWith = 1,
            lessons = listOf<Lesson>(
                Lesson(
                    name = "Выходной",
                    lecturer = "",
                    cabinet = ""
                )
            )
        ),
        Day(
            ofWeek = Days.Saturday,
            startsWith = 1,
            lessons = listOf<Lesson>(
                Lesson(
                    name = "Выходной",
                    lecturer = "",
                    cabinet = ""
                )
            )
        ),
        Day(
            ofWeek = Days.Sunday,
            startsWith = 1,
            lessons = listOf<Lesson>(
                Lesson(
                    name = "Выходной",
                    lecturer = "",
                    cabinet = ""
                )
            )
        )
    )





    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PersonsAdapter()
        binding?.dayWeekSchedule?.lessonSchedule?.adapter = this@WeekScheduleFragment.adapter

        adapter?.submitList(schedule.filter { it.ofWeek.toString() == dayOfWeekString })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeekSchBinding.inflate(inflater, container, false)
        return binding?.root
    }

    companion object{
        @JvmStatic
        fun newInstance() =
            WeekScheduleFragment()
    }
}