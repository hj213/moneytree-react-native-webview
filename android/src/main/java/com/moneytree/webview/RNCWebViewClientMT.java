package com.moneytree.webview;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Pair;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.moneytree.webview.events.TopHttpErrorEvent;
import com.moneytree.webview.events.TopLoadingErrorEvent;
import com.moneytree.webview.events.TopLoadingFinishEvent;
import com.moneytree.webview.events.TopLoadingStartEvent;
import com.moneytree.webview.events.TopRenderProcessGoneEvent;
import com.moneytree.webview.events.TopShouldStartLoadWithRequestEvent;

import java.util.concurrent.atomic.AtomicReference;

public class RNCWebViewClientMT extends WebViewClient {
    private static String TAG = "RNCWebViewClientMT";
    protected static final int SHOULD_OVERRIDE_URL_LOADING_TIMEOUT = 250;

    protected boolean mLastLoadFailed = false;
    protected RNCWebViewMT.ProgressChangedFilter progressChangedFilter = null;
    protected @Nullable String ignoreErrFailedForThisURL = null;
    protected @Nullable RNCBasicAuthCredential basicAuthCredential = null;

    // ... rest of the class code with RNCWebView replaced by RNCWebViewMT ...
} 