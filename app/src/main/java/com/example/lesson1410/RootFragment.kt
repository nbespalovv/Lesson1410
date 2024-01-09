package com.example.lesson1410
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lesson1410.databinding.FragmentRootBinding
import com.example.lesson1410.presenter.day.WeekFragment
import com.example.lesson1410.presenter.week.WeekScheduleFragment

class RootFragment : Fragment() {
    private var binding: FragmentRootBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRootBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.bottNavView?.setOnItemSelectedListener {
           selectTab(it.itemId)
           true
        }
        selectTab(R.id.nav_week_schedule)
    }

    private fun selectTab(itemId: Int) {
        val navHostId = binding?.bottomNavHost?.id
        navHostId ?: return
        val transaction = childFragmentManager.beginTransaction()
        when(itemId){
            R.id.navigation_day_schedule -> transaction.replace(
                navHostId,
                WeekScheduleFragment.newInstance()
            )
            R.id.nav_week_schedule -> transaction.replace(
                navHostId,
                WeekFragment.newInstance()
            )

        }
        transaction.commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            RootFragment()
    }
}