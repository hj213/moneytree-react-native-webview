package com.moneytree.webview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.scroll.ScrollEventType;
import com.moneytree.webview.events.TopCustomMenuSelectionEvent;
import com.moneytree.webview.events.TopHttpErrorEvent;
import com.moneytree.webview.events.TopLoadingErrorEvent;
import com.moneytree.webview.events.TopLoadingFinishEvent;
import com.moneytree.webview.events.TopLoadingProgressEvent;
import com.moneytree.webview.events.TopLoadingStartEvent;
import com.moneytree.webview.events.TopMessageEvent;
import com.moneytree.webview.events.TopOpenWindowEvent;
import com.moneytree.webview.events.TopRenderProcessGoneEvent;
import com.moneytree.webview.events.TopShouldStartLoadWithRequestEvent;

import java.util.Map;

public class RNCWebViewManagerMT extends ViewGroupManager<RNCWebViewWrapperMT> {

    private final RNCWebViewManagerImplMT mRNCWebViewManagerImplMT;

    public RNCWebViewManagerMT() {
        mRNCWebViewManagerImplMT = new RNCWebViewManagerImplMT();
    }

    @Override
    public String getName() {
        return RNCWebViewManagerImplMT.NAME;
    }

    @Override
    public RNCWebViewWrapperMT createViewInstance(ThemedReactContext context) {
        return mRNCWebViewManagerImplMT.createViewInstance(context);
    }

    public RNCWebViewWrapperMT createViewInstance(ThemedReactContext context, RNCWebViewWrapperMT view) {
      return mRNCWebViewManagerImplMT.createViewInstance(context, view.getWebView());
    }

    @ReactProp(name = "allowFileAccess")
    public void setAllowFileAccess(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setAllowFileAccess(view, value);
    }

    @ReactProp(name = "allowFileAccessFromFileURLs")
    public void setAllowFileAccessFromFileURLs(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setAllowFileAccessFromFileURLs(view, value);

    }

    @ReactProp(name = "allowUniversalAccessFromFileURLs")
    public void setAllowUniversalAccessFromFileURLs(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setAllowUniversalAccessFromFileURLs(view, value);
    }

    @ReactProp(name = "allowsFullscreenVideo")
    public void setAllowsFullscreenVideo(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setAllowsFullscreenVideo(view, value);
    }

    @ReactProp(name = "allowsProtectedMedia")
    public void setAllowsProtectedMedia(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setAllowsProtectedMedia(view, value);
    }

    @ReactProp(name = "androidLayerType")
    public void setAndroidLayerType(RNCWebViewWrapperMT view, @Nullable String value) {
        mRNCWebViewManagerImplMT.setAndroidLayerType(view, value);
    }

    @ReactProp(name = "applicationNameForUserAgent")
    public void setApplicationNameForUserAgent(RNCWebViewWrapperMT view, @Nullable String value) {
        mRNCWebViewManagerImplMT.setApplicationNameForUserAgent(view, value);
    }

    @ReactProp(name = "basicAuthCredential")
    public void setBasicAuthCredential(RNCWebViewWrapperMT view, @Nullable ReadableMap value) {
        mRNCWebViewManagerImplMT.setBasicAuthCredential(view, value);
    }

    @ReactProp(name = "cacheEnabled")
    public void setCacheEnabled(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setCacheEnabled(view, value);
    }

    @ReactProp(name = "cacheMode")
    public void setCacheMode(RNCWebViewWrapperMT view, @Nullable String value) {
        mRNCWebViewManagerImplMT.setCacheMode(view, value);
    }

    @ReactProp(name = "domStorageEnabled")
    public void setDomStorageEnabled(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setDomStorageEnabled(view, value);
    }

    @ReactProp(name = "downloadingMessage")
    public void setDownloadingMessage(RNCWebViewWrapperMT view, @Nullable String value) {
        mRNCWebViewManagerImplMT.setDownloadingMessage(value);
    }

    @ReactProp(name = "forceDarkOn")
    public void setForceDarkOn(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setForceDarkOn(view, value);
    }

    @ReactProp(name = "geolocationEnabled")
    public void setGeolocationEnabled(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setGeolocationEnabled(view, value);
    }

    @ReactProp(name = "hasOnScroll")
    public void setHasOnScroll(RNCWebViewWrapperMT view, boolean hasScrollEvent) {
        mRNCWebViewManagerImplMT.setHasOnScroll(view, hasScrollEvent);
    }

    @ReactProp(name = "incognito")
    public void setIncognito(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setIncognito(view, value);
    }

    @ReactProp(name = "injectedJavaScript")
    public void setInjectedJavaScript(RNCWebViewWrapperMT view, @Nullable String value) {
        mRNCWebViewManagerImplMT.setInjectedJavaScript(view, value);
    }

    @ReactProp(name = "injectedJavaScriptBeforeContentLoaded")
    public void setInjectedJavaScriptBeforeContentLoaded(RNCWebViewWrapperMT view, @Nullable String value) {
        mRNCWebViewManagerImplMT.setInjectedJavaScriptBeforeContentLoaded(view, value);
    }

    @ReactProp(name = "injectedJavaScriptForMainFrameOnly")
    public void setInjectedJavaScriptForMainFrameOnly(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setInjectedJavaScriptForMainFrameOnly(view, value);

    }

    @ReactProp(name = "injectedJavaScriptBeforeContentLoadedForMainFrameOnly")
    public void setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(view, value);

    }

    @ReactProp(name = "injectedJavaScriptObject")
    public void setInjectedJavaScriptObject(RNCWebViewWrapperMT view, @Nullable String value) {
        mRNCWebViewManagerImplMT.setInjectedJavaScriptObject(view, value);
    }

    @ReactProp(name = "javaScriptCanOpenWindowsAutomatically")
    public void setJavaScriptCanOpenWindowsAutomatically(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setJavaScriptCanOpenWindowsAutomatically(view, value);
    }

    @ReactProp(name = "javaScriptEnabled")
    public void setJavaScriptEnabled(RNCWebViewWrapperMT view, boolean enabled) {
        mRNCWebViewManagerImplMT.setJavaScriptEnabled(view, enabled);
    }

    @ReactProp(name = "lackPermissionToDownloadMessage")
    public void setLackPermissionToDownloadMessage(RNCWebViewWrapperMT view, @Nullable String value) {
        mRNCWebViewManagerImplMT.setLackPermissionToDownloadMessage(value);
    }

    @ReactProp(name = "hasOnOpenWindowEvent")
    public void setHasOnOpenWindowEvent(RNCWebViewWrapperMT view, boolean hasEvent) {
        mRNCWebViewManagerImplMT.setHasOnOpenWindowEvent(view, hasEvent);
    }

    @ReactProp(name = "mediaPlaybackRequiresUserAction")
    public void setMediaPlaybackRequiresUserAction(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setMediaPlaybackRequiresUserAction(view, value);
    }

    @ReactProp(name = "messagingEnabled")
    public void setMessagingEnabled(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setMessagingEnabled(view, value);
    }

    @ReactProp(name = "menuItems")
    public void setMenuCustomItems(RNCWebViewWrapperMT view, @Nullable ReadableArray items) {
        mRNCWebViewManagerImplMT.setMenuCustomItems(view, items);
    }

    @ReactProp(name = "messagingModuleName")
    public void setMessagingModuleName(RNCWebViewWrapperMT view, @Nullable String value) {
        mRNCWebViewManagerImplMT.setMessagingModuleName(view, value);
    }

    @ReactProp(name = "minimumFontSize")
    public void setMinimumFontSize(RNCWebViewWrapperMT view, int value) {
        mRNCWebViewManagerImplMT.setMinimumFontSize(view, value);
    }

    @ReactProp(name = "mixedContentMode")
    public void setMixedContentMode(RNCWebViewWrapperMT view, @Nullable String value) {
        mRNCWebViewManagerImplMT.setMixedContentMode(view, value);
    }

    @ReactProp(name = "nestedScrollEnabled")
    public void setNestedScrollEnabled(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setNestedScrollEnabled(view, value);
    }

    @ReactProp(name = "overScrollMode")
    public void setOverScrollMode(RNCWebViewWrapperMT view, @Nullable String value) {
        mRNCWebViewManagerImplMT.setOverScrollMode(view, value);
    }

    @ReactProp(name = "saveFormDataDisabled")
    public void setSaveFormDataDisabled(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setSaveFormDataDisabled(view, value);
    }

    @ReactProp(name = "scalesPageToFit")
    public void setScalesPageToFit(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setScalesPageToFit(view, value);
    }

    @ReactProp(name = "setBuiltInZoomControls")
    public void setSetBuiltInZoomControls(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setSetBuiltInZoomControls(view, value);
    }

    @ReactProp(name = "setDisplayZoomControls")
    public void setSetDisplayZoomControls(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setSetDisplayZoomControls(view, value);
    }

    @ReactProp(name = "setSupportMultipleWindows")
    public void setSetSupportMultipleWindows(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setSetSupportMultipleWindows(view, value);
    }

    @ReactProp(name = "showsHorizontalScrollIndicator")
    public void setShowsHorizontalScrollIndicator(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setShowsHorizontalScrollIndicator(view, value);
    }

    @ReactProp(name = "showsVerticalScrollIndicator")
    public void setShowsVerticalScrollIndicator(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setShowsVerticalScrollIndicator(view, value);
    }

    @ReactProp(name = "source")
    public void setSource(RNCWebViewWrapperMT view, @Nullable ReadableMap value) {
        mRNCWebViewManagerImplMT.setSource(view, value, false);
    }

    @ReactProp(name = "textZoom")
    public void setTextZoom(RNCWebViewWrapperMT view, int value) {
        mRNCWebViewManagerImplMT.setTextZoom(view, value);
    }

    @ReactProp(name = "thirdPartyCookiesEnabled")
    public void setThirdPartyCookiesEnabled(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setThirdPartyCookiesEnabled(view, value);
    }

    @ReactProp(name = "webviewDebuggingEnabled")
    public void setWebviewDebuggingEnabled(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setWebviewDebuggingEnabled(view, value);
    }

    @ReactProp(name = "userAgent")
    public void setUserAgent(RNCWebViewWrapperMT view, @Nullable String value) {
        mRNCWebViewManagerImplMT.setUserAgent(view, value);
    }

    @Override
    protected void addEventEmitters(@NonNull ThemedReactContext reactContext, RNCWebViewWrapperMT viewWrapper) {
        // Do not register default touch emitter and let WebView implementation handle touches
        viewWrapper.getWebView().setWebViewClient(new RNCWebViewClientMT());
    }

    @Override
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> export = super.getExportedCustomDirectEventTypeConstants();
        if (export == null) {
            export = MapBuilder.newHashMap();
        }
        // Default events but adding them here explicitly for clarity
        export.put(TopLoadingStartEvent.EVENT_NAME, MapBuilder.of("registrationName", "onLoadingStart"));
        export.put(TopLoadingFinishEvent.EVENT_NAME, MapBuilder.of("registrationName", "onLoadingFinish"));
        export.put(TopLoadingErrorEvent.EVENT_NAME, MapBuilder.of("registrationName", "onLoadingError"));
        export.put(TopMessageEvent.EVENT_NAME, MapBuilder.of("registrationName", "onMessage"));
        // !Default events but adding them here explicitly for clarity

        export.put(TopLoadingProgressEvent.EVENT_NAME, MapBuilder.of("registrationName", "onLoadingProgress"));
        export.put(TopShouldStartLoadWithRequestEvent.EVENT_NAME, MapBuilder.of("registrationName", "onShouldStartLoadWithRequest"));
        export.put(ScrollEventType.getJSEventName(ScrollEventType.SCROLL), MapBuilder.of("registrationName", "onScroll"));
        export.put(TopHttpErrorEvent.EVENT_NAME, MapBuilder.of("registrationName", "onHttpError"));
        export.put(TopRenderProcessGoneEvent.EVENT_NAME, MapBuilder.of("registrationName", "onRenderProcessGone"));
        export.put(TopCustomMenuSelectionEvent.EVENT_NAME, MapBuilder.of("registrationName", "onCustomMenuSelection"));
        export.put(TopOpenWindowEvent.EVENT_NAME, MapBuilder.of("registrationName", "onOpenWindow"));
        return export;
    }

    @Override
    public @Nullable
    Map<String, Integer> getCommandsMap() {
        return mRNCWebViewManagerImplMT.getCommandsMap();
    }

    @Override
    public void receiveCommand(@NonNull RNCWebViewWrapperMT reactWebView, String commandId, @Nullable ReadableArray args) {
        mRNCWebViewManagerImplMT.receiveCommand(reactWebView, commandId, args);
        super.receiveCommand(reactWebView, commandId, args);
    }

    @Override
    public void onDropViewInstance(@NonNull RNCWebViewWrapperMT view) {
        mRNCWebViewManagerImplMT.onDropViewInstance(view);
        super.onDropViewInstance(view);
    }
}