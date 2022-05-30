package com.rickyandrean.herbapedia.ui.main.ui.plants

import android.content.Context
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.rickyandrean.herbapedia.databinding.FragmentPlantsBinding
import com.rickyandrean.herbapedia.ui.main.MainActivity

class PlantsFragment : Fragment() {
    private var _binding: FragmentPlantsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel = ViewModelProvider(this).get(PlantsViewModel::class.java)
        _binding = FragmentPlantsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val animation = TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move)
        sharedElementEnterTransition = animation
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (MainActivity.searchAnimation) {
            binding.tiSearchPlant.requestFocus()
            val imm: InputMethodManager = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(binding.tiSearchPlant, InputMethodManager.SHOW_IMPLICIT)
            MainActivity.searchAnimation = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}