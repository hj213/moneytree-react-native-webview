package com.moneytree.webview;

import android.app.DownloadManager;
import android.net.Uri;
import android.webkit.ValueCallback;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = RNCWebViewModuleImplMT.NAME)
public class RNCWebViewModuleMT extends NativeRNCWebViewSpec {
    final private RNCWebViewModuleImplMT mRNCWebViewModuleImplMT;

    public RNCWebViewModuleMT(ReactApplicationContext reactContext) {
        super(reactContext);
        mRNCWebViewModuleImplMT = new RNCWebViewModuleImplMT(reactContext);
    }   

    @Override
    public void isFileUploadSupported(final Promise promise) {
        promise.resolve(mRNCWebViewModuleImplMT.isFileUploadSupported());
    }

    @Override
    public void shouldStartLoadWithLockIdentifier(boolean shouldStart, double lockIdentifier) {
        mRNCWebViewModuleImplMT.shouldStartLoadWithLockIdentifier(shouldStart, lockIdentifier);
    }

    public void startPhotoPickerIntent(ValueCallback<Uri> filePathCallback, String acceptType) {
        mRNCWebViewModuleImplMT.startPhotoPickerIntent(acceptType, filePathCallback);
    }

    public boolean startPhotoPickerIntent(final ValueCallback<Uri[]> callback, final String[] acceptTypes, final boolean allowMultiple, final boolean isCaptureEnabled) {
        return mRNCWebViewModuleImplMT.startPhotoPickerIntent(acceptTypes, allowMultiple, callback, isCaptureEnabled);
    }

    public void setDownloadRequest(DownloadManager.Request request) {
        mRNCWebViewModuleImplMT.setDownloadRequest(request);
    }

    public void downloadFile(String downloadingMessage) {
        mRNCWebViewModuleImplMT.downloadFile(downloadingMessage);
    }

    public boolean grantFileDownloaderPermissions(String downloadingMessage, String lackPermissionToDownloadMessage) {
        return mRNCWebViewModuleImplMT.grantFileDownloaderPermissions(downloadingMessage, lackPermissionToDownloadMessage);
    }

    @NonNull
    @Override
    public String getName() {
        return RNCWebViewModuleImplMT.NAME;
    }
}