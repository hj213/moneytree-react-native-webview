package com.moneytree.webview

import android.app.DownloadManager
import android.content.pm.ActivityInfo
import android.graphics.Bitmap
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.webkit.CookieManager
import android.webkit.DownloadListener
import android.webkit.URLUtil
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.webkit.WebSettingsCompat
import androidx.webkit.WebViewFeature
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.common.MapBuilder
import com.facebook.react.common.build.ReactBuildConfig
import com.facebook.react.uimanager.ThemedReactContext
import java.net.MalformedURLException
import java.net.URL
import java.util.Locale

val invalidCharRegex = "[\\/%\"]".toRegex()

class RNCWebViewManagerImplMT {
    companion object {
        const val NAME = "RNCWebViewMT"
    }

    private val TAG = "RNCWebViewManagerImplMT"
    private var mDownloadingMessage: String? = null
    private var mLackPermissionToDownloadMessage: String? = null

    private fun getDownloadingMessageOrDefault(): String = mDownloadingMessage ?: "Downloading"
    private fun getLackPermissionToDownloadMessageOrDefault(): String =
        mLackPermissionToDownloadMessage
            ?: "Cannot download files as permission was denied. Please provide permission to write to storage, in order to download files."

    fun createViewInstance(context: ThemedReactContext): RNCWebViewWrapperMT {
        val webView = RNCWebViewMT(context)

        webView.setDownloadListener(DownloadListener { url, userAgent, contentDisposition, mimetype, contentLength ->
            webView.setIgnoreErrFailedForThisURL(url)
            val module = webView.themedReactContext.getNativeModule(RNCWebViewModuleImplMT::class.java)
                ?: return@DownloadListener

            val request = try {
                DownloadManager.Request(Uri.parse(url))
            } catch (e: IllegalArgumentException) {
                Log.w(TAG, "Unsupported URI, aborting download", e)
                return@DownloadListener
            }

            var fileName = URLUtil.guessFileName(url, contentDisposition, mimetype)
            fileName = fileName.replace(invalidCharRegex, "_")

            val downloadMessage = "Downloading $fileName"

            try {
                val baseUrl = URL(url).run { "$protocol://$host" }
                val cookie = CookieManager.getInstance().getCookie(baseUrl)
                request.addRequestHeader("Cookie", cookie)
            } catch (e: MalformedURLException) {
                Log.w(TAG, "Error getting cookie for DownloadManager", e)
            }

            request.addRequestHeader("User-Agent", userAgent)
            request.setTitle(fileName)
            request.setDescription(downloadMessage)
            request.allowScanningByMediaScanner()
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName)

            module.setDownloadRequest(request)
            if (module.grantFileDownloaderPermissions(
                    getDownloadingMessageOrDefault(),
                    getLackPermissionToDownloadMessageOrDefault()
                )
            ) {
                module.downloadFile(getDownloadingMessageOrDefault())
            }
        })

        return RNCWebViewWrapperMT(context, webView)
    }
}
