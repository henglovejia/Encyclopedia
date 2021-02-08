package study.examples.widget

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.TextView

/**
 * @author zhangHeng
 * @since 1/29/21
 * @email 932805400@qq.com
 * @description
 */
@SuppressLint("AppCompatCustomView")
class EncyTextView @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyle: Int = 0
) : TextView(context, attr, defStyle) {
}