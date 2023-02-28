package com.example.a43.ui.fragments.home

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a43.App
import com.example.a43.R
import com.example.a43.databinding.FragmentNoteAppBinding
import com.example.a43.interfaces.OnClickItem
import com.example.a43.model.NoteModel
import com.example.a43.ui.adapters.NoteAppAdapter


class NoteAppFragment() : Fragment(), OnClickItem {

    private lateinit var binding: FragmentNoteAppBinding
    private val list = ArrayList<NoteModel>()
    private val notAppAdapter = NoteAppAdapter(list, this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentNoteAppBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setList()
        setupListeners()
    }

    private fun initialize() {
        binding.notResView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = notAppAdapter
        }
    }

    private fun setupListeners() = with(binding) {
        btnMaterial.setOnClickListener {
            findNavController().navigate(R.id.action_noteAppFragment_to_detailFragment)
        }
    }

    private fun setList() {
        App().getInstance()?.noteDao()?.getAll()?.observe(viewLifecycleOwner) {
            notAppAdapter.setList(it as ArrayList<NoteModel>)
        }
    }

    override fun onLongClick(noteModel: NoteModel) {
        val builder = AlertDialog.Builder(requireContext())
        with(builder) {
            setTitle("Вы точно хотите удалить")
            setPositiveButton("Да", DialogInterface.OnClickListener { dialog, which ->
                App.appDataBase?.noteDao()?.delete(noteModel)
            })
            setNegativeButton("Нет", DialogInterface.OnClickListener { dialog, which ->
                dialog.cancel()
            })
            show()
        }
        builder.create()
    }
}