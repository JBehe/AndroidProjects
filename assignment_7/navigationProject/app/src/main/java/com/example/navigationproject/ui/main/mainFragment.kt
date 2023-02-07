package com.example.navigationproject.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationproject.R
import com.example.navigationproject.databinding.FragmentMainBinding
import androidx.navigation.Navigation
import androidx.lifecycle.ViewModelProvider
import com.example.navigationproject.secondFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER



/**
 * A simple [Fragment] subclass.
 * Use the [mainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class mainFragment : Fragment() {
    companion object {
        fun newInstance() = mainFragment()
    }


    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    /*fun getImg(imgID: Int): mainFragmentDirections.ActionMainFragmentToSecondFragment{
        val action: mainFragmentDirections.ActionMainFragmentToSecondFragment = mainFragmentDirections.actionMainFragmentToSecondFragment(imgID)
    }*/





    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)
        var imgid = resources.getIdentifier("android_image_1", "drawable", context?.packageName)
        binding.button1.setOnClickListener {
            val action:  mainFragmentDirections.ActionMainFragmentToSecondFragment = mainFragmentDirections.actionMainFragmentToSecondFragment()
            action.setMessage("image 1")
            action.setImg(R.drawable.android_image_1)
            Navigation.findNavController(it).navigate(action)





        }
        binding.button2.setOnClickListener {
            val action:  mainFragmentDirections.ActionMainFragmentToSecondFragment = mainFragmentDirections.actionMainFragmentToSecondFragment()
            action.setMessage("image 2")
            action.setImg(R.drawable.android_image_2)
            Navigation.findNavController(it).navigate(action)


        }
        binding.button3.setOnClickListener {
            val action:  mainFragmentDirections.ActionMainFragmentToSecondFragment = mainFragmentDirections.actionMainFragmentToSecondFragment()
            action.setMessage("image 3")
            action.setImg(R.drawable.android_image_3)
            Navigation.findNavController(it).navigate(action)




        }



    }
}
