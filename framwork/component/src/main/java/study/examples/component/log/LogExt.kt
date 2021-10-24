package study.examples.component.log

import android.util.Log

/**
 * @author zhangHeng
 * @since 2021/1/18 5:54 下午
 * @email 932805400@qq.com
 */

fun LogImp.logV(msg: String) {
    Log.v(getTAG(), msg)
}

fun LogImp.logD(msg: String) {
    Log.d(getTAG(), msg)
}

fun LogImp.logI(msg: String) {
    Log.i(getTAG(), msg)
}

fun LogImp.logW(msg: String) {
    Log.w(getTAG(), msg)
}

fun LogImp.logE(msg: String) {
    Log.e(getTAG(), msg)
}