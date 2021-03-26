package study.examples.component.sp

import android.content.Context
import android.content.SharedPreferences
import java.lang.ref.WeakReference


/**
 * @author ZhangHeng
 * @since 2/8/21
 * @email 932805400@qq.com
 * @description
 */

private val mSpMap: HashMap<String, WeakReference<SharedPreferences>> = HashMap()

fun Context.getSp(name: String): SharedPreferences? {
    var sp = mSpMap[name]?.get()
    if (sp == null) {
        sp = getSharedPreferences(name, Context.MODE_PRIVATE)
        mSpMap[name] = WeakReference(sp)
    }
    return sp
}

inline fun <reified T> Context.getSpValue(name: String, key: String, defaultValue: T): T {
    val sp = getSp(name)
    val value = when (defaultValue) {
        is Boolean -> {
            sp?.getBoolean(key, defaultValue) ?: defaultValue
        }
        is String -> {
            sp?.getString(key, defaultValue) ?: defaultValue
        }
        is Float -> {
            sp?.getFloat(key, defaultValue) ?: defaultValue
        }
        is Int -> {
            sp?.getInt(key, defaultValue) ?: defaultValue
        }
        is Long -> {
            sp?.getLong(key, defaultValue) ?: defaultValue
        }
        is MutableSet<*> -> {
            sp?.getStringSet(key, emptySet()) ?: defaultValue
        }
        else -> {
            defaultValue
        }
    }
    return value as T
}

fun Context.setValue(name: String, valueMap: Map<String, Any>, needCommit: Boolean = false) {
    val sp = getSp(name)?.edit()
    valueMap.forEach { (key, value) ->
        when (value) {
            is Boolean -> {
                sp?.putBoolean(key, value)?.apply()
            }
            is String -> {
                sp?.putString(key, value)?.apply()
            }
            is Float -> {
                sp?.putFloat(key, value)?.apply()
            }
            is Int -> {
                sp?.putInt(key, value)?.apply()
            }
            is Long -> {
                sp?.putLong(key, value)?.apply()
            }
            is Set<*> -> {
                sp?.putStringSet(key, value as? Set<String>)?.apply()
            }
        }
    }
    if (needCommit) {
        sp?.commit()
    }
}
