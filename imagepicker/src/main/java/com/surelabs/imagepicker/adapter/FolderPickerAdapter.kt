package com.surelabs.imagepicker.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.surelabs.imagepicker.adapter.FolderPickerAdapter.FolderViewHolder
import com.surelabs.imagepicker.databinding.EfImagepickerItemFolderBinding
import com.surelabs.imagepicker.features.imageloader.ImageLoader
import com.surelabs.imagepicker.features.imageloader.ImageType
import com.surelabs.imagepicker.listeners.OnFolderClickListener
import com.surelabs.imagepicker.model.Folder

class FolderPickerAdapter(
    context: Context,
    imageLoader: ImageLoader,
    private val folderClickListener: OnFolderClickListener
) : BaseListAdapter<FolderViewHolder>(context, imageLoader) {

    private val folders: MutableList<Folder> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FolderViewHolder {
        val binding = EfImagepickerItemFolderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FolderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FolderViewHolder, position: Int) {
        val folder = folders.getOrNull(position) ?: return

        imageLoader.loadImage(folder.images.first(), holder.image, ImageType.FOLDER)

        holder.apply {
            name.text = folder.folderName
            number.text = folder.images.size.toString()
            itemView.setOnClickListener { folderClickListener(folder) }
        }
    }

    fun setData(folders: List<Folder>?) {
        folders?.let {
            this.folders.clear()
            this.folders.addAll(folders)
        }

        notifyDataSetChanged()
    }

    override fun getItemCount() = folders.size

    class FolderViewHolder(binding: EfImagepickerItemFolderBinding) : ViewHolder(binding.root) {
        val image = binding.image
        val name = binding.tvName
        val number = binding.tvNumber
    }
}