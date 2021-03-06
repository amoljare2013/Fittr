package com.amol.jare.fittrapp.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.amol.jare.fittrapp.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.layout_full_screen_dialog.*

class DetailsDialogFragmen(firstFragment: Context) : DialogFragment() {

    private var albumName: String? = null
    private var albumAtistName: String? = null
    private var albumImageUrl: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        isCancelable = false
        return inflater.inflate(R.layout.layout_full_screen_dialog, container, false)
    }

    override fun getTheme(): Int {
        return R.style.DialogTheme
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        albumName = arguments?.getString("albumName")
        albumAtistName = arguments?.getString("albumAtistName")
        albumImageUrl = arguments?.getString("albumImageUrl")

        Glide.with(requireContext()!!)
            .load(albumImageUrl)
            .centerCrop()
            .error(R.drawable.ic_user)
            .placeholder(R.drawable.ic_user)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(ivProfile)

        tvName.setText(albumName)
        tvArtist.setText(albumAtistName)

        btnClose.setOnClickListener {
            dismiss()
        }

    }
}