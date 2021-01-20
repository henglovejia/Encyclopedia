package study.examples.component.log

import android.util.Log

/**
 * @author zhangHeng
 * @since 2021/1/18 5:54 下午
 * @email 932805400@qq.com
 */

fun String.logV(imp: LogImp) {
    Log.v(imp.getTAG(), this)
}

fun String.logD(imp: LogImp) {
    Log.d(imp.getTAG(), this)
}

fun String.logI(imp: LogImp) {
    Log.i(imp.getTAG(), this)
}

fun String.logW(imp: LogImp) {
    Log.w(imp.getTAG(), this)
}

fun String.logE(imp: LogImp) {
    Log.e(imp.getTAG(), this)
}