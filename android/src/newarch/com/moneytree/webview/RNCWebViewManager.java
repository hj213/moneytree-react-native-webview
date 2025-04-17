package com.moneytree.webview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNCWebViewManagerDelegate;
import com.facebook.react.viewmanagers.RNCWebViewManagerInterface;
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

import android.webkit.WebChromeClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

@ReactModule(name = RNCWebViewManagerImplMT.NAME)
public class RNCWebViewManagerMT extends ViewGroupManager<RNCWebViewWrapperMT>
        implements RNCWebViewManagerInterface<RNCWebViewWrapperMT> {

    private final ViewManagerDelegate<RNCWebViewWrapperMT> mDelegate;
    private final RNCWebViewManagerImplMT mRNCWebViewManagerImplMT;

    public RNCWebViewManager() {
        mDelegate = new RNCWebViewManagerDelegate<>(this);
        mRNCWebViewManagerImplMT = new RNCWebViewManagerImplMT();
    }

    @Nullable
    @Override
    protected ViewManagerDelegate<RNCWebViewWrapperMT> getDelegate() {
        return mDelegate;
    }

    @NonNull
    @Override
    public String getName() {
        return RNCWebViewManagerImplMT.NAME;
    }

    @NonNull
    @Override
    protected RNCWebViewWrapperMT createViewInstance(@NonNull ThemedReactContext context) {
        return mRNCWebViewManagerImplMT.createViewInstance(context);
    }

    @Override
    @ReactProp(name = "allowFileAccess")
    public void setAllowFileAccess(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setAllowFileAccess(view, value);
    }

    @Override
    @ReactProp(name = "allowFileAccessFromFileURLs")
    public void setAllowFileAccessFromFileURLs(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setAllowFileAccessFromFileURLs(view, value);

    }

    @Override
    @ReactProp(name = "allowUniversalAccessFromFileURLs")
    public void setAllowUniversalAccessFromFileURLs(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setAllowUniversalAccessFromFileURLs(view, value);
    }

    @Override
    @ReactProp(name = "allowsFullscreenVideo")
    public void setAllowsFullscreenVideo(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setAllowsFullscreenVideo(view, value);
    }

    @Override
    @ReactProp(name = "allowsProtectedMedia")
    public void setAllowsProtectedMedia(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setAllowsProtectedMedia(view, value);
    }

    @Override
    @ReactProp(name = "androidLayerType")
    public void setAndroidLayerType(RNCWebViewWrapperMT view, @Nullable String value) {
        mRNCWebViewManagerImplMT.setAndroidLayerType(view, value);
    }

    @Override
    @ReactProp(name = "applicationNameForUserAgent")
    public void setApplicationNameForUserAgent(RNCWebViewWrapperMT view, @Nullable String value) {
        mRNCWebViewManagerImplMT.setApplicationNameForUserAgent(view, value);
    }

    @Override
    @ReactProp(name = "basicAuthCredential")
    public void setBasicAuthCredential(RNCWebViewWrapperMT view, @Nullable ReadableMap value) {
        mRNCWebViewManagerImplMT.setBasicAuthCredential(view, value);
    }

    @Override
    @ReactProp(name = "cacheEnabled")
    public void setCacheEnabled(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setCacheEnabled(view, value);
    }

    @Override
    @ReactProp(name = "cacheMode")
    public void setCacheMode(RNCWebViewWrapperMT view, @Nullable String value) {
        mRNCWebViewManagerImplMT.setCacheMode(view, value);
    }

    @Override
    @ReactProp(name = "domStorageEnabled")
    public void setDomStorageEnabled(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setDomStorageEnabled(view, value);
    }

    @Override
    @ReactProp(name = "downloadingMessage")
    public void setDownloadingMessage(RNCWebViewWrapperMT view, @Nullable String value) {
        mRNCWebViewManagerImplMT.setDownloadingMessage(value);
    }

    @Override
    @ReactProp(name = "forceDarkOn")
    public void setForceDarkOn(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setForceDarkOn(view, value);
    }

    @Override
    @ReactProp(name = "geolocationEnabled")
    public void setGeolocationEnabled(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setGeolocationEnabled(view, value);
    }

    @Override
    @ReactProp(name = "hasOnScroll")
    public void setHasOnScroll(RNCWebViewWrapperMT view, boolean hasScrollEvent) {
        mRNCWebViewManagerImplMT.setHasOnScroll(view, hasScrollEvent);
    }

    @Override
    @ReactProp(name = "incognito")
    public void setIncognito(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setIncognito(view, value);
    }

    @Override
    @ReactProp(name = "injectedJavaScript")
    public void setInjectedJavaScript(RNCWebViewWrapperMT view, @Nullable String value) {
        mRNCWebViewManagerImplMT.setInjectedJavaScript(view, value);
    }

    @Override
    @ReactProp(name = "injectedJavaScriptBeforeContentLoaded")
    public void setInjectedJavaScriptBeforeContentLoaded(RNCWebViewWrapperMT view, @Nullable String value) {
        mRNCWebViewManagerImplMT.setInjectedJavaScriptBeforeContentLoaded(view, value);
    }

    @Override
    @ReactProp(name = "injectedJavaScriptForMainFrameOnly")
    public void setInjectedJavaScriptForMainFrameOnly(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setInjectedJavaScriptForMainFrameOnly(view, value);

    }

    @Override
    @ReactProp(name = "injectedJavaScriptBeforeContentLoadedForMainFrameOnly")
    public void setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(view, value);

    }

    @ReactProp(name = "injectedJavaScriptObject")
    public void setInjectedJavaScriptObject(RNCWebViewWrapperMT view, @Nullable String value) {
        mRNCWebViewManagerImplMT.setInjectedJavaScriptObject(view, value);
    }

    @Override
    @ReactProp(name = "javaScriptCanOpenWindowsAutomatically")
    public void setJavaScriptCanOpenWindowsAutomatically(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setJavaScriptCanOpenWindowsAutomatically(view, value);
    }

    @ReactProp(name = "javaScriptEnabled")
    public void setJavaScriptEnabled(RNCWebViewWrapperMT view, boolean enabled) {
        mRNCWebViewManagerImplMT.setJavaScriptEnabled(view, enabled);
    }

    @Override
    @ReactProp(name = "lackPermissionToDownloadMessage")
    public void setLackPermissionToDownloadMessage(RNCWebViewWrapperMT view, @Nullable String value) {
        mRNCWebViewManagerImplMT.setLackPermissionToDownloadMessage(value);
    }

    @Override
    @ReactProp(name = "hasOnOpenWindowEvent")
    public void setHasOnOpenWindowEvent(RNCWebViewWrapperMT view, boolean hasEvent) {
        mRNCWebViewManagerImplMT.setHasOnOpenWindowEvent(view, hasEvent);
    }

    @Override
    @ReactProp(name = "mediaPlaybackRequiresUserAction")
    public void setMediaPlaybackRequiresUserAction(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setMediaPlaybackRequiresUserAction(view, value);
    }

    @Override
    @ReactProp(name = "menuItems")
    public void setMenuItems(RNCWebViewWrapperMT view, @Nullable ReadableArray items) {
        mRNCWebViewManagerImplMT.setMenuCustomItems(view, items);
    }

    @Override
    @ReactProp(name = "suppressMenuItems ")
    public void setSuppressMenuItems(RNCWebViewWrapperMT view, @Nullable ReadableArray items) {
        mRNCWebViewManagerImplMT.setSuppressMenuItems(view, items);
    }

    @Override
    @ReactProp(name = "messagingEnabled")
    public void setMessagingEnabled(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setMessagingEnabled(view, value);
    }

    @Override
    @ReactProp(name = "messagingModuleName")
    public void setMessagingModuleName(RNCWebViewWrapperMT view, @Nullable String value) {
        mRNCWebViewManagerImplMT.setMessagingModuleName(view, value);
    }

    @Override
    @ReactProp(name = "minimumFontSize")
    public void setMinimumFontSize(RNCWebViewWrapperMT view, int value) {
        mRNCWebViewManagerImplMT.setMinimumFontSize(view, value);
    }

    @Override
    @ReactProp(name = "mixedContentMode")
    public void setMixedContentMode(RNCWebViewWrapperMT view, @Nullable String value) {
        mRNCWebViewManagerImplMT.setMixedContentMode(view, value);
    }

    @Override
    @ReactProp(name = "nestedScrollEnabled")
    public void setNestedScrollEnabled(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setNestedScrollEnabled(view, value);
    }

    @Override
    @ReactProp(name = "overScrollMode")
    public void setOverScrollMode(RNCWebViewWrapperMT view, @Nullable String value) {
        mRNCWebViewManagerImplMT.setOverScrollMode(view, value);
    }

    @Override
    @ReactProp(name = "saveFormDataDisabled")
    public void setSaveFormDataDisabled(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setSaveFormDataDisabled(view, value);
    }

    @Override
    @ReactProp(name = "scalesPageToFit")
    public void setScalesPageToFit(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setScalesPageToFit(view, value);
    }

    @Override
    @ReactProp(name = "setBuiltInZoomControls")
    public void setSetBuiltInZoomControls(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setSetBuiltInZoomControls(view, value);
    }

    @Override
    @ReactProp(name = "setDisplayZoomControls")
    public void setSetDisplayZoomControls(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setSetDisplayZoomControls(view, value);
    }

    @Override
    @ReactProp(name = "setSupportMultipleWindows")
    public void setSetSupportMultipleWindows(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setSetSupportMultipleWindows(view, value);
    }

    @Override
    @ReactProp(name = "showsHorizontalScrollIndicator")
    public void setShowsHorizontalScrollIndicator(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setShowsHorizontalScrollIndicator(view, value);
    }

    @Override
    @ReactProp(name = "showsVerticalScrollIndicator")
    public void setShowsVerticalScrollIndicator(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setShowsVerticalScrollIndicator(view, value);
    }

    @Override
    @ReactProp(name = "newSource")
    public void setNewSource(RNCWebViewWrapperMT view, @Nullable ReadableMap value) {
        mRNCWebViewManagerImplMT.setSource(view, value, true);
    }

    @Override
    @ReactProp(name = "textZoom")
    public void setTextZoom(RNCWebViewWrapperMT view, int value) {
        mRNCWebViewManagerImplMT.setTextZoom(view, value);
    }

    @Override
    @ReactProp(name = "thirdPartyCookiesEnabled")
    public void setThirdPartyCookiesEnabled(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setThirdPartyCookiesEnabled(view, value);
    }

    @Override
    @ReactProp(name = "webviewDebuggingEnabled")
    public void setWebviewDebuggingEnabled(RNCWebViewWrapperMT view, boolean value) {
        mRNCWebViewManagerImplMT.setWebviewDebuggingEnabled(view, value);
    }

    /* iOS PROPS - no implemented here */
    @Override
    public void setAllowingReadAccessToURL(RNCWebViewWrapperMT view, @Nullable String value) {}

    @Override
    public void setAllowsBackForwardNavigationGestures(RNCWebViewWrapperMT view, boolean value) {}

    @Override
    public void setAllowsInlineMediaPlayback(RNCWebViewWrapperMT view, boolean value) {}

    @Override
    public void setAllowsAirPlayForMediaPlayback(RNCWebViewWrapperMT view, boolean value) {}

    @Override
    public void setAllowsLinkPreview(RNCWebViewWrapperMT view, boolean value) {}

    @Override
    public void setAutomaticallyAdjustContentInsets(RNCWebViewWrapperMT view, boolean value) {}

    @Override
    public void setAutoManageStatusBarEnabled(RNCWebViewWrapperMT view, boolean value) {}

    @Override
    public void setBounces(RNCWebViewWrapperMT view, boolean value) {}

    @Override
    public void setContentInset(RNCWebViewWrapperMT view, @Nullable ReadableMap value) {}

    @Override
    public void setContentInsetAdjustmentBehavior(RNCWebViewWrapperMT view, @Nullable String value) {}

    @Override
    public void setContentMode(RNCWebViewWrapperMT view, @Nullable String value) {}

    @Override
    public void setDataDetectorTypes(RNCWebViewWrapperMT view, @Nullable ReadableArray value) {}

    @Override
    public void setDecelerationRate(RNCWebViewWrapperMT view, double value) {}

    @Override
    public void setDirectionalLockEnabled(RNCWebViewWrapperMT view, boolean value) {}

    @Override
    public void setEnableApplePay(RNCWebViewWrapperMT view, boolean value) {}

    @Override
    public void setHideKeyboardAccessoryView(RNCWebViewWrapperMT view, boolean value) {}

    @Override
    public void setKeyboardDisplayRequiresUserAction(RNCWebViewWrapperMT view, boolean value) {}

    @Override
    public void setPagingEnabled(RNCWebViewWrapperMT view, boolean value) {}

    @Override
    public void setPullToRefreshEnabled(RNCWebViewWrapperMT view, boolean value) {}

    @Override
    public void setScrollEnabled(RNCWebViewWrapperMT view, boolean value) {}

    @Override
    public void setSharedCookiesEnabled(RNCWebViewWrapperMT view, boolean value) {}

    @Override
    public void setUseSharedProcessPool(RNCWebViewWrapperMT view, boolean value) {}

    @Override
    public void setLimitsNavigationsToAppBoundDomains(RNCWebViewWrapperMT view, boolean value) {}

    @Override
    public void setTextInteractionEnabled(RNCWebViewWrapperMT view, boolean value) {}

    @Override
    public void setHasOnFileDownload(RNCWebViewWrapperMT view, boolean value) {}

    @Override
    public void setMediaCapturePermissionGrantType(RNCWebViewWrapperMT view, @Nullable String value) {}

    @Override
    public void setFraudulentWebsiteWarningEnabled(RNCWebViewWrapperMT view, boolean value) {}
    /* !iOS PROPS - no implemented here */

    @Override
    @ReactProp(name = "userAgent")
    public void setUserAgent(RNCWebViewWrapperMT view, @Nullable String value) {
        mRNCWebViewManagerImplMT.setUserAgent(view, value);
    }

    // These will never be called because we use the shared impl for now
  @Override
  public void goBack(RNCWebViewWrapperMT view) {
    view.getWebView().goBack();
  }

  @Override
  public void goForward(RNCWebViewWrapperMT view) {
    view.getWebView().goForward();
  }

  @Override
  public void reload(RNCWebViewWrapperMT view) {
    view.getWebView().reload();
  }

  @Override
  public void stopLoading(RNCWebViewWrapperMT view) {
    view.getWebView().stopLoading();
  }

  @Override
  public void injectJavaScript(RNCWebViewWrapperMT view, String javascript) {
      view.getWebView().evaluateJavascriptWithFallback(javascript);
  }

  @Override
  public void requestFocus(RNCWebViewWrapperMT view) {
      view.requestFocus();
  }

  @Override
  public void postMessage(RNCWebViewWrapperMT view, String data) {
      try {
        JSONObject eventInitDict = new JSONObject();
        eventInitDict.put("data", data);
        view.getWebView().evaluateJavascriptWithFallback(
          "(function () {" +
            "var event;" +
            "var data = " + eventInitDict.toString() + ";" +
            "try {" +
            "event = new MessageEvent('message', data);" +
            "} catch (e) {" +
            "event = document.createEvent('MessageEvent');" +
            "event.initMessageEvent('message', true, true, data.data, data.origin, data.lastEventId, data.source);" +
            "}" +
            "document.dispatchEvent(event);" +
            "})();"
        );
      } catch (JSONException e) {
        throw  new RuntimeException(e);
      }
  }

  @Override
  public void loadUrl(RNCWebViewWrapperMT view, String url) {
      view.getWebView().loadUrl(url);
  }

  @Override
  public void clearFormData(RNCWebViewWrapperMT view) {
      view.getWebView().clearFormData();
  }

  @Override
  public void clearCache(RNCWebViewWrapperMT view, boolean includeDiskFiles) {
      view.getWebView().clearCache(includeDiskFiles);
  }

  @Override
  public void clearHistory(RNCWebViewWrapperMT view) {
      view.getWebView().clearHistory();
  }
  // !These will never be called

  @Override
    protected void addEventEmitters(@NonNull ThemedReactContext reactContext, RNCWebViewWrapperMT view) {
        // Do not register default touch emitter and let WebView implementation handle touches
        view.getWebView().setWebViewClient(new RNCWebViewClientMT());
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
        return mRNCWebViewManagerImpl.getCommandsMap();
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