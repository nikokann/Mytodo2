package com.github.nikokann.page.create.create

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.github.nikokann.R
import com.github.nikokann.databinding.CreateTodoFragmentBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateTodoFragment: Fragment(R.layout.create_todo_fragment) {
    private val vm: CreateTodoViewModel by viewModels()

    private var _binding: CreateTodoFragmentBinding? = null
    private val binding: CreateTodoFragmentBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this._binding = CreateTodoFragmentBinding.bind(view)

        vm.errorMassege.observe(viewLifecycleOwner) { msg ->
            if (msg.isEmpty()) return@observe

            Snackbar.make(requireView(), msg, Snackbar.LENGTH_SHORT).show()
            vm.errorMassege.value = ""
        }
        vm.done.observe(viewLifecycleOwner){
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        this._binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_create, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_save -> {
                save()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }

    private fun save() {
        val title = binding.titleEdit.text.toString()
        val detail = binding.detailEdit.text.toString()

        vm.save(title, detail)
    }

}