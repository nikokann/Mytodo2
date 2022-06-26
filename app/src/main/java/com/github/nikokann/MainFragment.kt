package com.github.nikokann

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment: Fragment(R.layout.main_fragment) {
    private  val vm: MainViewModel by viewModels()

}