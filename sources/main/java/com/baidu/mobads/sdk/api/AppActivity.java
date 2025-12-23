package com.baidu.mobads.sdk.api;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.baidu.mobads.sdk.internal.bu;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AppActivity extends Activity {
    private static Activity activity;
    public static String activityName;
    private static boolean canShowWhenLock;
    private static boolean mIsShowActionBarTitle;
    private static ActionBarColorTheme mSActionBarColorTheme;
    private ClassLoader mLoader;
    private IActivityImpl mProxyActivity;

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    static {
        StubApp.interface11(12049);
        mSActionBarColorTheme = ActionBarColorTheme.ACTION_BAR_WHITE_THEME;
        mIsShowActionBarTitle = true;
    }

    public static void canLpShowWhenLocked(boolean z5) {
        canShowWhenLock = z5;
    }

    public static Activity getActivity() {
        return activity;
    }

    public static Class<?> getActivityClass() {
        if (TextUtils.isEmpty(activityName)) {
            return AppActivity.class;
        }
        try {
            return Class.forName(activityName);
        } catch (Exception e6) {
            bu.a().c(e6);
            return AppActivity.class;
        }
    }

    public static boolean getLpShowWhenLocked() {
        return canShowWhenLock;
    }

    public static boolean isAnti() {
        return !TextUtils.isEmpty(activityName);
    }

    public static void setActionBarColorTheme(ActionBarColorTheme actionBarColorTheme) {
        if (actionBarColorTheme != null) {
            mSActionBarColorTheme = actionBarColorTheme;
        }
    }

    public static void setActivityName(String str) {
        activityName = str;
    }

    public static void setIsShowActionBarTitle(boolean z5) {
        mIsShowActionBarTitle = z5;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null ? iActivityImpl.dispatchKeyEvent(keyEvent) : false) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null ? iActivityImpl.dispatchTouchEvent(motionEvent) : false) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i6, int i7, Intent intent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onActivityResult(i6, i7, intent);
        }
        super.onActivityResult(i6, i7, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onConfigurationChanged(configuration);
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onDestroy();
        }
        super.onDestroy();
        activity = null;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i6, KeyEvent keyEvent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null ? iActivityImpl.onKeyDown(i6, keyEvent) : false) {
            return true;
        }
        return super.onKeyDown(i6, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i6, KeyEvent keyEvent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null ? iActivityImpl.onKeyUp(i6, keyEvent) : false) {
            return true;
        }
        return super.onKeyUp(i6, keyEvent);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onNewIntent(intent);
        }
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onPause();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null ? iActivityImpl.onTouchEvent(motionEvent) : false) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onAttachedToWindow();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onDetachedFromWindow();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onRestoreInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onStart();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onStop();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onWindowFocusChanged(z5);
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i6, int i7) {
        super.overridePendingTransition(i6, i7);
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.overridePendingTransition(i6, i7);
        }
    }
}
