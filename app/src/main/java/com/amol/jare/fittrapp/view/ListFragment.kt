package com.amol.jare.fittrapp.view

import android.graphics.drawable.ClipDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import com.amol.jare.fittrapp.R
import com.amol.jare.fittrapp.adapter.ListAdapter
import com.amol.jare.fittrapp.viewModel.ListViewModel
import com.ankit.jare.utils.NetworkConnecitity
import kotlinx.android.synthetic.main.fragment_list.*
import java.lang.NullPointerException

class ListFragment : Fragment() {

    lateinit var viewModel: ListViewModel
    private lateinit var adapter: ListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val decoration = DividerItemDecoration(requireContext(), ClipDrawable.HORIZONTAL)
        listrcv.addItemDecoration(decoration)
        viewModel = ViewModelProviders.of(this@ListFragment).get(ListViewModel::class.java)

        try {
            if (NetworkConnecitity.isNetworkAvailable(requireContext())) {
                viewModel.fetchRepoList()
            } else {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.network_message),
                    Toast.LENGTH_SHORT
                ).show()
            }

        } catch (e: NullPointerException) {
            e.printStackTrace()
        }

//        view.findViewById<Button>(R.id.button_second).setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }
    }
}
