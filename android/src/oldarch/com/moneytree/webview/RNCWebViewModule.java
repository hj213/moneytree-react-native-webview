package com.moneytree.webview;

import android.app.DownloadManager;
import android.net.Uri;

import androidx.annotation.NonNull;
import android.webkit.ValueCallback;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = RNCWebViewModuleImplMT.NAME)
public class RNCWebViewModuleMT extends ReactContextBaseJavaModule {
    final private RNCWebViewModuleImplMT mRNCWebViewModuleImplMT;

    public RNCWebViewModuleMT(ReactApplicationContext reactContext) {
        super(reactContext);
        mRNCWebViewModuleImplMT = new RNCWebViewModuleImplMT(reactContext);
    }

    @ReactMethod
    public void isFileUploadSupported(final Promise promise) {
        promise.resolve(mRNCWebViewModuleImplMT.isFileUploadSupported());
    }

    @ReactMethod
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