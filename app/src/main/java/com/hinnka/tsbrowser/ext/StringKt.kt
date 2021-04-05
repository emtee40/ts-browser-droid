package com.hinnka.tsbrowser.ext

import android.webkit.URLUtil
import com.hinnka.tsbrowser.util.AUTOLINK_WEB_URL

fun String.toUrl(): String {
    val inUrl = this.trim()
    if (!inUrl.contains(".") || inUrl.contains(" ")) {
        return toSearchUrl()
    }
    if (URLUtil.isValidUrl(inUrl)) {
        return this
    }
    val matcher = AUTOLINK_WEB_URL.matcher(inUrl)
    if (matcher.matches()) {
        return this
    }
    return toSearchUrl()
}

fun String.toSearchUrl(): String {
    return "https://www.google.com/search?q=$this"
}