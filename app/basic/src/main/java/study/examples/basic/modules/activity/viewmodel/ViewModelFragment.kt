package study.examples.basic.modules.activity.viewmodel

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import study.examples.basic.databinding.BasicViewModelFragmentBinding
import study.examples.component.ext.viewBinding
import study.examples.component.fragment.BaseVBFragment
import study.examples.constant.basic.BASIC_VIEW_MODEL_FRAGMENT

@Route(path = BASIC_VIEW_MODEL_FRAGMENT)
class ViewModelFragment : BaseVBFragment() {
    private lateinit var mViewModel: BasicViewModel
    private val mBinding by viewBinding<BasicViewModelFragmentBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (activity != null) {
            mViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(activity!!.application))[BasicViewModel::class.java]
            mViewModel.testField = "ViewModelFragment"
            mViewModel.liveData.observe(this, {
                mBinding.basicViewModelText1.text = it
            })
            return
        }
        throw RuntimeException("activity is null")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.basicViewModelText1.text = mViewModel.testField
        mBinding.basicViewModelButton1.setOnClickListener {
            mViewModel.liveData.value = "button click"
        }
    }
}