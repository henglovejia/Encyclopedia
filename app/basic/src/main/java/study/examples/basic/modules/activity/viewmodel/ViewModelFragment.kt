package study.examples.basic.modules.activity.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import study.examples.basic.databinding.BasicViewModelFragmentBinding
import study.examples.component.fragment.BaseVBFragment
import study.examples.constant.basic.BASIC_VIEW_MODEL_FRAGMENT
import java.lang.RuntimeException

@Route(path = BASIC_VIEW_MODEL_FRAGMENT)
class ViewModelFragment : BaseVBFragment<BasicViewModelFragmentBinding>() {
    private lateinit var mViewModel: BasicViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (activity != null) {
            mViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(activity!!.application))[BasicViewModel::class.java]
            mViewModel.testField = "ViewModelFragment"
            mViewModel.liveData.observe(this, {
                binding.basicViewModelText1.text = it
            })
            return
        }
        throw RuntimeException("activity is null")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.basicViewModelText1.text = mViewModel.testField
        binding.basicViewModelButton1.setOnClickListener {
            mViewModel.liveData.value = "button click"
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?) = BasicViewModelFragmentBinding.inflate(inflater, container, false)
}