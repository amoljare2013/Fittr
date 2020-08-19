package com.amol.jare.fittrapp.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.amol.jare.fittrapp.R
import com.amol.jare.fittrapp.model.api.fittrResp
import com.amol.jare.fittrapp.view.DetailsDialogFragmen
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy


class ListAdapter internal constructor(
    private val context: Context,
    private val titleList: List<String>,
    private val dataList: HashMap<String, MutableList<fittrResp>>
) : BaseExpandableListAdapter() {

    override fun getChild(listPosition: Int, expandedListPosition: Int): Any {
        return this.dataList[this.titleList[listPosition]]!![expandedListPosition]
    }

    override fun getChildId(listPosition: Int, expandedListPosition: Int): Long {
        return expandedListPosition.toLong()
    }

    override fun getChildView(
        listPosition: Int,
        expandedListPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup
    ): View? {
        var convertView = convertView

        val fittrResp: fittrResp? = getChild(listPosition, expandedListPosition) as? fittrResp
        if (convertView == null) {
            val layoutInflater =
                this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.item_list, null)
        }
        val tvName = convertView!!.findViewById<TextView>(R.id.tvName)
        val ivProfile = convertView!!.findViewById<ImageView>(R.id.ivProfile)
        val tvDetails = convertView!!.findViewById<TextView>(R.id.tvDetails)
        val rel = convertView!!.findViewById<RelativeLayout>(R.id.rel)

        if (fittrResp != null && fittrResp.name != null) {
            tvName.text = fittrResp.name
        } else {
            tvName.text = " "
        }

        if (fittrResp != null && fittrResp.description != null) {
            tvDetails.text = fittrResp.description
        } else {
            tvDetails.text = " "
        }

        if (fittrResp != null && fittrResp.profilepic != null) {
            Glide.with(context!!)
                .load(fittrResp.profilepic)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(ivProfile)
        }

        rel.setOnClickListener(View.OnClickListener {
            if (fittrResp != null) {
                showDialog(fittrResp)
            }
        })

        return convertView
    }

    override fun getGroupView(
        listPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup
    ): View {
        var convertView = convertView
        val listTitle = getGroup(listPosition) as String
        if (convertView == null) {
            val layoutInflater =
                this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.list_header, null)
        }
        val tvTitle = convertView!!.findViewById<TextView>(R.id.tvTitle)
        tvTitle.text = listTitle
        return convertView
    }


    override fun getChildrenCount(listPosition: Int): Int {
        return this.dataList[this.titleList[listPosition]]!!.size
    }

    override fun getGroup(listPosition: Int): Any {
        return this.titleList[listPosition]
    }

    override fun getGroupCount(): Int {
        return this.titleList.size
    }

    override fun getGroupId(listPosition: Int): Long {
        return listPosition.toLong()
    }

    override fun isChildSelectable(listPosition: Int, expandedListPosition: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    private fun showDialog(fittrItem: fittrResp) {
        val manager =
            (context as AppCompatActivity).supportFragmentManager
        val dialogFragment = DetailsDialogFragmen(context)
        manager?.let {
            val args = Bundle()
            args.putString("albumName", fittrItem.name)
            args.putString("albumAtistName", fittrItem.description)
            args.putString("albumImageUrl", fittrItem.profilepic)
            dialogFragment.arguments = args
            dialogFragment.show(it, "DetailsFragment")
        }
    }
}