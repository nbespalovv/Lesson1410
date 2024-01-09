package com.example.lesson1410.presenter.day

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson1410.R
import com.example.lesson1410.data.Day
import com.example.lesson1410.data.Days
import com.example.lesson1410.data.Lesson
import com.example.lesson1410.databinding.FragmentWeekBinding

class WeekFragment : Fragment() {

    private var _binding: FragmentWeekBinding? = null
    private val binding
        get() = requireNotNull(_binding)
    private var adapter: PersonsAdapter? = null

    var schedule = mutableListOf<Day>(
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
    val defaultSchedule = schedule

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PersonsAdapter()
        binding.daySchedule.adapter = this@WeekFragment.adapter

        

        val weekSpinner: Spinner = binding.startWeek


        val weekArray = resources.getStringArray(R.array.spinner_number_week)


        val weekAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, weekArray)
        weekAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


        weekSpinner.adapter = weekAdapter

        weekSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedWeek = weekArray[position]
                schedule.clear()
                schedule.addAll(
                    when(selectedWeek) {
                    "Неделя 1" -> getScheduleForWeek1()
                    "Неделя 2" -> getScheduleForWeek2()
                    else -> defaultSchedule
                    }
                )


                adapter?.submitList(schedule)
                schedule.clear()
            }
            private fun getScheduleForWeek1(): MutableList<Day> {
                return mutableListOf(
                    Day(
                        ofWeek = Days.Monday,
                        startsWith = 1,
                        lessons = listOf<Lesson>(
                            Lesson(
                                name = "Ваш урок",
                                lecturer = "Преподаватель",
                                cabinet = "221"
                            )

                        )
                    ),

                )
            }

            private fun getScheduleForWeek2(): MutableList<Day> {
                return mutableListOf(
                    Day(
                        ofWeek = Days.Monday,
                        startsWith = 1,
                        lessons = listOf<Lesson>(
                            Lesson(
                                name = "Ваш урок для второй недели",
                                lecturer = "Преподаватель",
                                cabinet = "221"
                            )
                            // Добавьте остальные уроки
                        )
                    ),
                    // Добавьте остальные дни недели
                )
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWeekBinding.inflate(inflater, container, false)
        return binding.root
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            WeekFragment()
    }
}