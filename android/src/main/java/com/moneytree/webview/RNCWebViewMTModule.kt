package com.moneytree.webview

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule

class RNCWebViewMTModule(
    reactContext: ReactApplicationContext
) : ReactContextBaseJavaModule(reactContext) {

    private val impl = RNCWebViewModuleImplMT(reactContext)

    override fun getName(): String {
        return "RNCWebViewMT"
    }

    fun setDownloadRequest(request: android.app.DownloadManager.Request) {
        impl.setDownloadRequest(request)
    }

    fun grantFileDownloaderPermissions(downloadingMessage: String, lackPermissionMessage: String): Boolean {
        return impl.grantFileDownloaderPermissions(downloadingMessage, lackPermissionMessage)
    }

    fun downloadFile(downloadingMessage: String) {
        impl.downloadFile(downloadingMessage)
    }
}