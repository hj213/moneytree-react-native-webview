package com.moneytree.webview;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.ContentSizeChangeEvent;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.views.scroll.OnScrollDispatchHelper;
import com.facebook.react.views.scroll.ScrollEvent;
import com.facebook.react.views.scroll.ScrollEventType;
import com.reactnativecommunity.webview.events.TopCustomMenuSelectionEvent;
import com.reactnativecommunity.webview.events.TopMessageEvent;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

public class RNCWebViewMT extends WebView implements LifecycleEventListener {
    protected @Nullable String injectedJS;
    protected @Nullable String injectedJSBeforeContentLoaded;
    protected static final String JAVASCRIPT_INTERFACE = "ReactNativeWebViewMT";
    protected @Nullable RNCWebViewBridgeMT bridge;

    protected boolean injectedJavaScriptForMainFrameOnly = true;
    protected boolean injectedJavaScriptBeforeContentLoadedForMainFrameOnly = true;

    protected boolean messagingEnabled = false;
    protected @Nullable String messagingModuleName;
    protected @Nullable RNCWebViewClientMT mRNCWebViewClient;
    protected @Nullable CatalystInstance mCatalystInstance;
    protected boolean sendContentSizeChangeEvents = false;
    private OnScrollDispatchHelper mOnScrollDispatchHelper;
    protected boolean hasScrollEvent = false;
    protected boolean nestedScrollEnabled = false;
    protected ProgressChangedFilter progressChangedFilter;

    public RNCWebViewMT(ThemedReactContext reactContext) {
        super(reactContext);
        this.createCatalystInstance();
        progressChangedFilter = new ProgressChangedFilter();
    }

    // ... existing code ...

    protected class RNCWebViewBridgeMT {
        private String TAG = "RNCWebViewBridgeMT";
        RNCWebViewMT mWebView;
        String injectedObjectJson;

        RNCWebViewBridgeMT(RNCWebViewMT c) {
            mWebView = c;
        }

        // ... rest of the bridge code ...
    }

    // ... rest of the class code ...
} 