package com.amol.jare.fittrapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.ExpandableListView.OnGroupClickListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.amol.jare.fittrapp.R
import com.amol.jare.fittrapp.adapter.ListAdapter
import com.amol.jare.fittrapp.model.ExpandableListData
import com.amol.jare.fittrapp.viewModel.ListViewModel


class ListFragment : Fragment() {

    lateinit var viewModel: ListViewModel

    private var expandableListView: ExpandableListView? = null
    private var adapter: ListAdapter? = null
    private var titleList: List<String>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this@ListFragment).get(ListViewModel::class.java)
        viewModel.fetchRepoList()

        expandableListView = view.findViewById(R.id.expendableList)
        if (expandableListView != null) {
            val listData = ExpandableListData.data
            titleList = ArrayList(listData.keys)
            adapter = ListAdapter(requireContext(), titleList as ArrayList<String>, listData)
            expandableListView!!.setAdapter(adapter)
            for (i in 0 until adapter!!.groupCount) expandableListView!!.expandGroup(i)

            expandableListView!!.setOnGroupClickListener(OnGroupClickListener { parent, v, groupPosition, id ->
                true
            })

        }
    }

}
