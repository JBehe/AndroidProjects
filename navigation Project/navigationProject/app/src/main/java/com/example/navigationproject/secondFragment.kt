package com.example.navigationproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.net.Uri
import androidx.core.graphics.drawable.toDrawable
import androidx.core.net.toUri
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding
import com.example.navigationproject.databinding.ActivityMainBinding
import com.example.navigationproject.databinding.FragmentSecondBinding
import com.example.navigationproject.ui.main.mainFragment
import com.example.navigationproject.ui.main.mainViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [secondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */





class secondFragment : Fragment() {
    companion object{
        fun newInstance() = secondFragment
    }

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding2 : FragmentSecondBinding? = null
    private val binding2 get() = _binding2!!




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding2 = FragmentSecondBinding.inflate(inflater, container, false)
        return binding2.root
    }
    interface OnFragmentInteractionListener{
        fun onFragmentInteraction(uri: Uri)
    }

    override fun onStart() {
        super.onStart()
        arguments?.let {
            val args = secondFragmentArgs.fromBundle(it)
            binding2.textView2.text = args.message
            binding2.imageView.setImageResource(args.img)


        }

    }


        // TODO: Rename and change types and number of parameters


    }


