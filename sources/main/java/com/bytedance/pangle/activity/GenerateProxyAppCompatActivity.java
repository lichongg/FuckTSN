package com.bytedance.pangle.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.Application;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.SharedElementCallback;
import android.app.TaskStackBuilder;
import android.app.VoiceInteractor;
import android.app.assist.AssistContent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.LocusId;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.PersistableBundle;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toolbar;
import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.sdk.openadsdk.api.m;
import com.stub.StubApp;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;
import java.util.function.Consumer;

@Keep
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class GenerateProxyAppCompatActivity extends AppCompatActivity implements xt {
    public Plugin mPlugin;
    public GeneratePluginAppCompatActivity mTargetActivity;

    @Override // android.app.Activity
    public void enterPictureInPictureMode() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.enterPictureInPictureMode();
        } else {
            super.enterPictureInPictureMode();
        }
    }

    @Override // com.bytedance.pangle.activity.xt
    public abstract String getPluginPkgName();

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        cw.j(this, bundle);
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i6) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.onCreateDialog(i6) : super.onCreateDialog(i6);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.onCreateView(view, str, context, attributeSet) : super.onCreateView(view, str, context, attributeSet);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean z5) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onMultiWindowModeChanged(z5);
        } else {
            super.onMultiWindowModeChanged(z5);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onPictureInPictureModeChanged(boolean z5) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onPictureInPictureModeChanged(z5);
        } else {
            super.onPictureInPictureModeChanged(z5);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onPostCreate(bundle);
        } else {
            super.onPostCreate(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i6, Dialog dialog) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onPrepareDialog(i6, dialog);
        } else {
            super.onPrepareDialog(i6, dialog);
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onRestoreInstanceState(bundle);
        } else {
            super.onRestoreInstanceState(bundle);
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onSaveInstanceState(bundle);
        } else {
            super.onSaveInstanceState(bundle);
        }
        bundle.clear();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.onSearchRequested() : super.onSearchRequested();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.onWindowStartingActionMode(callback) : super.onWindowStartingActionMode(callback);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i6) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setContentView(i6);
        } else {
            super.setContentView(i6);
        }
    }

    @Override // android.app.Activity
    public void setTitle(int i6) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setTitle(i6);
        } else {
            super.setTitle(i6);
        }
    }

    @Override // android.app.Activity
    public ActionMode startActionMode(ActionMode.Callback callback) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.startActionMode(callback) : super.startActionMode(callback);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startActivities(intentArr);
        } else {
            super.startActivities(intentArr);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startActivity(intent);
        } else {
            super.startActivity(intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i6) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startActivityForResult(intent, i6);
        } else {
            super.startActivityForResult(intent, i6);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity activity, Intent intent, int i6) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startActivityFromChild(activity, intent, i6);
        } else {
            super.startActivityFromChild(activity, intent, i6);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(Fragment fragment, Intent intent, int i6) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startActivityFromFragment(fragment, intent, i6);
        } else {
            super.startActivityFromFragment(fragment, intent, i6);
        }
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i6) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.startActivityIfNeeded(intent, i6) : super.startActivityIfNeeded(intent, i6);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i6, int i7, int i8) throws IntentSender.SendIntentException {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startIntentSender(intentSender, intent, i6, i7, i8);
        } else {
            super.startIntentSender(intentSender, intent, i6, i7, i8);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i6, Intent intent, int i7, int i8, int i9) throws IntentSender.SendIntentException {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startIntentSenderForResult(intentSender, i6, intent, i7, i8, i9);
        } else {
            super.startIntentSenderForResult(intentSender, i6, intent, i7, i8, i9);
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(Activity activity, IntentSender intentSender, int i6, Intent intent, int i7, int i8, int i9) throws IntentSender.SendIntentException {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startIntentSenderFromChild(activity, intentSender, i6, intent, i7, i8, i9);
        } else {
            super.startIntentSenderFromChild(activity, intentSender, i6, intent, i7, i8, i9);
        }
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent intent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.startNextMatchingActivity(intent) : super.startNextMatchingActivity(intent);
    }

    public boolean zeusSuperConvertToTranslucent(Activity.TranslucentConversionListener translucentConversionListener, ActivityOptions activityOptions) {
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", Class.forName("android.app.Activity$TranslucentConversionListener"), ActivityOptions.class);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(this, translucentConversionListener, activityOptions)).booleanValue();
        } catch (Exception e6) {
            m.j(e6);
            return false;
        }
    }

    public void zeusSuperEnterPictureInPictureMode() {
        super.enterPictureInPictureMode();
    }

    @Override // com.bytedance.pangle.activity.xt
    public void zeusSuperOnCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected Dialog zeusSuperOnCreateDialog(int i6) {
        return super.onCreateDialog(i6);
    }

    public View zeusSuperOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public void zeusSuperOnMultiWindowModeChanged(boolean z5) {
        super.onMultiWindowModeChanged(z5);
    }

    public void zeusSuperOnPictureInPictureModeChanged(boolean z5) {
        super.onPictureInPictureModeChanged(z5);
    }

    protected void zeusSuperOnPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }

    protected void zeusSuperOnPrepareDialog(int i6, Dialog dialog) {
        super.onPrepareDialog(i6, dialog);
    }

    protected void zeusSuperOnRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    protected void zeusSuperOnSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public boolean zeusSuperOnSearchRequested() {
        return super.onSearchRequested();
    }

    public ActionMode zeusSuperOnWindowStartingActionMode(ActionMode.Callback callback) {
        return super.onWindowStartingActionMode(callback);
    }

    public void zeusSuperSetContentView(int i6) {
        super.setContentView(i6);
    }

    public void zeusSuperSetTitle(int i6) {
        super.setTitle(i6);
    }

    public ActionMode zeusSuperStartActionMode(ActionMode.Callback callback) {
        return super.startActionMode(callback);
    }

    public void zeusSuperStartActivities(Intent[] intentArr) {
        super.startActivities(intentArr);
    }

    public void zeusSuperStartActivity(Intent intent) {
        super.startActivity(intent);
    }

    public void zeusSuperStartActivityForResult(Intent intent, int i6) {
        super.startActivityForResult(intent, i6);
    }

    public void zeusSuperStartActivityFromChild(Activity activity, Intent intent, int i6) {
        super.startActivityFromChild(activity, intent, i6);
    }

    public void zeusSuperStartActivityFromFragment(Fragment fragment, Intent intent, int i6) {
        super.startActivityFromFragment(fragment, intent, i6);
    }

    public boolean zeusSuperStartActivityIfNeeded(Intent intent, int i6) {
        return super.startActivityIfNeeded(intent, i6);
    }

    public void zeusSuperStartIntentSender(IntentSender intentSender, Intent intent, int i6, int i7, int i8) throws IntentSender.SendIntentException {
        super.startIntentSender(intentSender, intent, i6, i7, i8);
    }

    public void zeusSuperStartIntentSenderForResult(IntentSender intentSender, int i6, Intent intent, int i7, int i8, int i9) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i6, intent, i7, i8, i9);
    }

    public void zeusSuperStartIntentSenderFromChild(Activity activity, IntentSender intentSender, int i6, Intent intent, int i7, int i8, int i9) throws IntentSender.SendIntentException {
        super.startIntentSenderFromChild(activity, intentSender, i6, intent, i7, i8, i9);
    }

    public boolean zeusSuperStartNextMatchingActivity(Intent intent) {
        return super.startNextMatchingActivity(intent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.addContentView(view, layoutParams);
        } else {
            super.addContentView(view, layoutParams);
        }
    }

    @Override // android.app.Activity
    public void closeContextMenu() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.closeContextMenu();
        } else {
            super.closeContextMenu();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void closeOptionsMenu() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.closeOptionsMenu();
        } else {
            super.closeOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public PendingIntent createPendingResult(int i6, Intent intent, int i7) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.createPendingResult(i6, intent, i7) : super.createPendingResult(i6, intent, i7);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.dispatchGenericMotionEvent(motionEvent) : super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.dispatchKeyEvent(keyEvent) : super.dispatchKeyEvent(keyEvent);
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.dispatchKeyShortcutEvent(keyEvent) : super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.dispatchPopulateAccessibilityEvent(accessibilityEvent) : super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.dispatchTouchEvent(motionEvent) : super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.dispatchTrackballEvent(motionEvent) : super.dispatchTrackballEvent(motionEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.dump(str, fileDescriptor, printWriter, strArr);
        } else {
            super.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public View findViewById(int i6) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.findViewById(i6) : super.findViewById(i6);
    }

    @Override // android.app.Activity, com.bytedance.pangle.activity.xt
    public void finish() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.finish();
        } else {
            super.finish();
        }
    }

    @Override // android.app.Activity
    public void finishActivity(int i6) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.finishActivity(i6);
        } else {
            super.finishActivity(i6);
        }
    }

    @Override // android.app.Activity
    public void finishActivityFromChild(Activity activity, int i6) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.finishActivityFromChild(activity, i6);
        } else {
            super.finishActivityFromChild(activity, i6);
        }
    }

    @Override // android.app.Activity
    public void finishAffinity() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.finishAffinity();
        } else {
            super.finishAffinity();
        }
    }

    @Override // android.app.Activity
    public void finishAfterTransition() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.finishAfterTransition();
        } else {
            super.finishAfterTransition();
        }
    }

    @Override // android.app.Activity
    public void finishAndRemoveTask() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.finishAndRemoveTask();
        } else {
            super.finishAndRemoveTask();
        }
    }

    @Override // android.app.Activity
    public void finishFromChild(Activity activity) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.finishFromChild(activity);
        } else {
            super.finishFromChild(activity);
        }
    }

    @Override // android.app.Activity
    public ActionBar getActionBar() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.getActionBar() : super.getActionBar();
    }

    @Override // android.app.Activity
    public ComponentName getCallingActivity() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.getCallingActivity() : super.getCallingActivity();
    }

    @Override // android.app.Activity
    public String getCallingPackage() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.getCallingPackage() : super.getCallingPackage();
    }

    @Override // android.app.Activity
    public int getChangingConfigurations() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.getChangingConfigurations() : super.getChangingConfigurations();
    }

    @Override // android.app.Activity
    public ComponentName getComponentName() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.getComponentName() : super.getComponentName();
    }

    @Override // android.app.Activity
    public Scene getContentScene() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.getContentScene() : super.getContentScene();
    }

    @Override // android.app.Activity
    public TransitionManager getContentTransitionManager() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.getContentTransitionManager() : super.getContentTransitionManager();
    }

    @Override // android.app.Activity
    public View getCurrentFocus() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.getCurrentFocus() : super.getCurrentFocus();
    }

    @Override // android.app.Activity
    public FragmentManager getFragmentManager() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.getFragmentManager() : super.getFragmentManager();
    }

    @Override // android.app.Activity, com.bytedance.pangle.activity.xt
    public Intent getIntent() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.getIntent() : super.getIntent();
    }

    @Override // android.app.Activity
    public Object getLastNonConfigurationInstance() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.getLastNonConfigurationInstance() : super.getLastNonConfigurationInstance();
    }

    @Override // android.app.Activity
    public LayoutInflater getLayoutInflater() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.getLayoutInflater() : super.getLayoutInflater();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.getLifecycle() : super.getLifecycle();
    }

    @Override // android.app.Activity
    public LoaderManager getLoaderManager() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.getLoaderManager() : super.getLoaderManager();
    }

    @Override // android.app.Activity
    public String getLocalClassName() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.getLocalClassName() : super.getLocalClassName();
    }

    @Override // android.app.Activity
    public int getMaxNumPictureInPictureActions() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.getMaxNumPictureInPictureActions() : super.getMaxNumPictureInPictureActions();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public MenuInflater getMenuInflater() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.getMenuInflater() : super.getMenuInflater();
    }

    @Override // android.app.Activity
    public Intent getParentActivityIntent() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.getParentActivityIntent() : super.getParentActivityIntent();
    }

    @Override // com.bytedance.pangle.activity.xt
    public Plugin getPlugin() {
        return this.mPlugin;
    }

    @Override // android.app.Activity
    public SharedPreferences getPreferences(int i6) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.getPreferences(i6) : super.getPreferences(i6);
    }

    @Override // android.app.Activity
    public Uri getReferrer() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.getReferrer() : super.getReferrer();
    }

    @Override // android.app.Activity
    public int getRequestedOrientation() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.getRequestedOrientation() : super.getRequestedOrientation();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public androidx.appcompat.app.ActionBar getSupportActionBar() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.getSupportActionBar() : super.getSupportActionBar();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public androidx.fragment.app.FragmentManager getSupportFragmentManager() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.getSupportFragmentManager() : super.getSupportFragmentManager();
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.getSystemService(str) : super.getSystemService(str);
    }

    @Override // android.app.Activity
    public int getTaskId() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.getTaskId() : super.getTaskId();
    }

    @Override // android.app.Activity
    public VoiceInteractor getVoiceInteractor() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.getVoiceInteractor() : super.getVoiceInteractor();
    }

    @Override // android.app.Activity
    public Window getWindow() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.getWindow() : super.getWindow();
    }

    @Override // android.app.Activity
    public WindowManager getWindowManager() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.getWindowManager() : super.getWindowManager();
    }

    @Override // android.app.Activity
    public boolean hasWindowFocus() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.hasWindowFocus() : super.hasWindowFocus();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void invalidateOptionsMenu() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.invalidateOptionsMenu();
        } else {
            super.invalidateOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public boolean isActivityTransitionRunning() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.isActivityTransitionRunning() : super.isActivityTransitionRunning();
    }

    @Override // android.app.Activity
    public boolean isChangingConfigurations() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.isChangingConfigurations() : super.isChangingConfigurations();
    }

    @Override // android.app.Activity
    public boolean isDestroyed() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.isDestroyed() : super.isDestroyed();
    }

    @Override // android.app.Activity
    public boolean isFinishing() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.isFinishing() : super.isFinishing();
    }

    @Override // android.app.Activity
    public boolean isImmersive() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.isImmersive() : super.isImmersive();
    }

    @Override // android.app.Activity
    public boolean isInMultiWindowMode() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.isInMultiWindowMode() : super.isInMultiWindowMode();
    }

    @Override // android.app.Activity
    public boolean isInPictureInPictureMode() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.isInPictureInPictureMode() : super.isInPictureInPictureMode();
    }

    @Override // android.app.Activity
    public boolean isLocalVoiceInteractionSupported() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.isLocalVoiceInteractionSupported() : super.isLocalVoiceInteractionSupported();
    }

    @Override // android.app.Activity
    public boolean isTaskRoot() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.isTaskRoot() : super.isTaskRoot();
    }

    @Override // android.app.Activity
    public boolean isVoiceInteraction() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.isVoiceInteraction() : super.isVoiceInteraction();
    }

    @Override // android.app.Activity
    public boolean isVoiceInteractionRoot() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.isVoiceInteractionRoot() : super.isVoiceInteractionRoot();
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z5) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.moveTaskToBack(z5) : super.moveTaskToBack(z5);
    }

    @Override // android.app.Activity
    public boolean navigateUpTo(Intent intent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.navigateUpTo(intent) : super.navigateUpTo(intent);
    }

    @Override // android.app.Activity
    public boolean navigateUpToFromChild(Activity activity, Intent intent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.navigateUpToFromChild(activity, intent) : super.navigateUpToFromChild(activity, intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onActionModeFinished(actionMode);
        } else {
            super.onActionModeFinished(actionMode);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onActionModeStarted(actionMode);
        } else {
            super.onActionModeStarted(actionMode);
        }
    }

    @Override // android.app.Activity
    public void onActivityReenter(int i6, Intent intent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onActivityReenter(i6, intent);
        } else {
            super.onActivityReenter(i6, intent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i6, int i7, Intent intent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onActivityResult(i6, i7, intent);
        } else {
            super.onActivityResult(i6, i7, intent);
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper
    protected void onApplyThemeResource(Resources.Theme theme, int i6, boolean z5) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onApplyThemeResource(theme, i6, z5);
        } else {
            super.onApplyThemeResource(theme, i6, z5);
        }
    }

    @Override // android.app.Activity
    public void onAttachFragment(Fragment fragment) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onAttachFragment(fragment);
        } else {
            super.onAttachFragment(fragment);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onAttachedToWindow();
        } else {
            super.onAttachedToWindow();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    protected void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onChildTitleChanged(activity, charSequence);
        } else {
            super.onChildTitleChanged(activity, charSequence);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onConfigurationChanged(configuration);
        } else {
            super.onConfigurationChanged(configuration);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onContentChanged();
        } else {
            super.onContentChanged();
        }
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.onContextItemSelected(menuItem) : super.onContextItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onContextMenuClosed(Menu menu) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onContextMenuClosed(menu);
        } else {
            super.onContextMenuClosed(menu);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onCreate(bundle, persistableBundle);
        } else {
            super.onCreate(bundle, persistableBundle);
        }
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        } else {
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        }
    }

    @Override // android.app.Activity
    public CharSequence onCreateDescription() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.onCreateDescription() : super.onCreateDescription();
    }

    @Override // android.app.Activity
    public void onCreateNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onCreateNavigateUpTaskStack(taskStackBuilder);
        } else {
            super.onCreateNavigateUpTaskStack(taskStackBuilder);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.onCreateOptionsMenu(menu) : super.onCreateOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i6, Menu menu) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.onCreatePanelMenu(i6, menu) : super.onCreatePanelMenu(i6, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public View onCreatePanelView(int i6) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.onCreatePanelView(i6) : super.onCreatePanelView(i6);
    }

    @Override // android.app.Activity
    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.onCreateThumbnail(bitmap, canvas) : super.onCreateThumbnail(bitmap, canvas);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onDestroy();
        } else {
            super.onDestroy();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onDetachedFromWindow();
        } else {
            super.onDetachedFromWindow();
        }
    }

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onEnterAnimationComplete();
        } else {
            super.onEnterAnimationComplete();
        }
    }

    @Override // android.app.Activity
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.onGenericMotionEvent(motionEvent) : super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onGetDirectActions(CancellationSignal cancellationSignal, Consumer consumer) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onGetDirectActions(cancellationSignal, consumer);
        } else {
            super.onGetDirectActions(cancellationSignal, consumer);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i6, KeyEvent keyEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.onKeyDown(i6, keyEvent) : super.onKeyDown(i6, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i6, KeyEvent keyEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.onKeyLongPress(i6, keyEvent) : super.onKeyLongPress(i6, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i6, int i7, KeyEvent keyEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.onKeyMultiple(i6, i7, keyEvent) : super.onKeyMultiple(i6, i7, keyEvent);
    }

    @Override // android.app.Activity
    public boolean onKeyShortcut(int i6, KeyEvent keyEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.onKeyShortcut(i6, keyEvent) : super.onKeyShortcut(i6, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i6, KeyEvent keyEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.onKeyUp(i6, keyEvent) : super.onKeyUp(i6, keyEvent);
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStarted() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onLocalVoiceInteractionStarted();
        } else {
            super.onLocalVoiceInteractionStarted();
        }
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStopped() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onLocalVoiceInteractionStopped();
        } else {
            super.onLocalVoiceInteractionStopped();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onLowMemory();
        } else {
            super.onLowMemory();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i6, Menu menu) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.onMenuOpened(i6, menu) : super.onMenuOpened(i6, menu);
    }

    @Override // android.app.Activity
    public boolean onNavigateUp() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.onNavigateUp() : super.onNavigateUp();
    }

    @Override // android.app.Activity
    public boolean onNavigateUpFromChild(Activity activity) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.onNavigateUpFromChild(activity) : super.onNavigateUpFromChild(activity);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onNewIntent(intent);
        } else {
            super.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.onOptionsItemSelected(menuItem) : super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu menu) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onOptionsMenuClosed(menu);
        } else {
            super.onOptionsMenuClosed(menu);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i6, Menu menu) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onPanelClosed(i6, menu);
        } else {
            super.onPanelClosed(i6, menu);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onPause();
        } else {
            super.onPause();
        }
    }

    @Override // android.app.Activity
    public void onPerformDirectAction(String str, Bundle bundle, CancellationSignal cancellationSignal, Consumer consumer) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onPerformDirectAction(str, bundle, cancellationSignal, consumer);
        } else {
            super.onPerformDirectAction(str, bundle, cancellationSignal, consumer);
        }
    }

    @Override // android.app.Activity
    public boolean onPictureInPictureRequested() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.onPictureInPictureRequested() : super.onPictureInPictureRequested();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPostResume() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onPostResume();
        } else {
            super.onPostResume();
        }
    }

    @Override // android.app.Activity
    public void onPrepareNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onPrepareNavigateUpTaskStack(taskStackBuilder);
        } else {
            super.onPrepareNavigateUpTaskStack(taskStackBuilder);
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.onPrepareOptionsMenu(menu) : super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i6, View view, Menu menu) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.onPreparePanel(i6, view, menu) : super.onPreparePanel(i6, view, menu);
    }

    @Override // android.app.Activity
    public void onProvideAssistContent(AssistContent assistContent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onProvideAssistContent(assistContent);
        } else {
            super.onProvideAssistContent(assistContent);
        }
    }

    @Override // android.app.Activity
    public void onProvideAssistData(Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onProvideAssistData(bundle);
        } else {
            super.onProvideAssistData(bundle);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List list, Menu menu, int i6) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onProvideKeyboardShortcuts(list, menu, i6);
        } else {
            super.onProvideKeyboardShortcuts(list, menu, i6);
        }
    }

    @Override // android.app.Activity
    public Uri onProvideReferrer() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.onProvideReferrer() : super.onProvideReferrer();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i6, String[] strArr, int[] iArr) {
        StubApp.interface22(i6, strArr, iArr);
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onRequestPermissionsResult(i6, strArr, iArr);
        } else {
            super.onRequestPermissionsResult(i6, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onRestart();
        } else {
            super.onRestart();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onResume();
        } else {
            super.onResume();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onStart();
        } else {
            super.onStart();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStateNotSaved() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onStateNotSaved();
        } else {
            super.onStateNotSaved();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onStop();
        } else {
            super.onStop();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i6) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onTitleChanged(charSequence, i6);
        } else {
            super.onTitleChanged(charSequence, i6);
        }
    }

    @Override // android.app.Activity
    public void onTopResumedActivityChanged(boolean z5) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onTopResumedActivityChanged(z5);
        } else {
            super.onTopResumedActivityChanged(z5);
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.onTouchEvent(motionEvent) : super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.onTrackballEvent(motionEvent) : super.onTrackballEvent(motionEvent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i6) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onTrimMemory(i6);
        } else {
            super.onTrimMemory(i6);
        }
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onUserInteraction();
        } else {
            super.onUserInteraction();
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onUserLeaveHint();
        } else {
            super.onUserLeaveHint();
        }
    }

    @Override // android.app.Activity
    public void onVisibleBehindCanceled() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onVisibleBehindCanceled();
        } else {
            super.onVisibleBehindCanceled();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onWindowAttributesChanged(layoutParams);
        } else {
            super.onWindowAttributesChanged(layoutParams);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z5) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onWindowFocusChanged(z5);
        } else {
            super.onWindowFocusChanged(z5);
        }
    }

    @Override // android.app.Activity
    public void openContextMenu(View view) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.openContextMenu(view);
        } else {
            super.openContextMenu(view);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void openOptionsMenu() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.openOptionsMenu();
        } else {
            super.openOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i6, int i7) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.overridePendingTransition(i6, i7);
        } else {
            super.overridePendingTransition(i6, i7);
        }
    }

    @Override // android.app.Activity
    public void postponeEnterTransition() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.postponeEnterTransition();
        } else {
            super.postponeEnterTransition();
        }
    }

    @Override // android.app.Activity
    public void recreate() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.recreate();
        } else {
            super.recreate();
        }
    }

    @Override // android.app.Activity
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        } else {
            super.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    @Override // android.app.Activity
    public void registerForContextMenu(View view) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.registerForContextMenu(view);
        } else {
            super.registerForContextMenu(view);
        }
    }

    @Override // android.app.Activity
    public boolean releaseInstance() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.releaseInstance() : super.releaseInstance();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void reportFullyDrawn() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.reportFullyDrawn();
        } else {
            super.reportFullyDrawn();
        }
    }

    @Override // android.app.Activity
    public DragAndDropPermissions requestDragAndDropPermissions(DragEvent dragEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.requestDragAndDropPermissions(dragEvent) : super.requestDragAndDropPermissions(dragEvent);
    }

    @Override // android.app.Activity
    public boolean requestVisibleBehind(boolean z5) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.requestVisibleBehind(z5) : super.requestVisibleBehind(z5);
    }

    @Override // android.app.Activity
    public void setActionBar(Toolbar toolbar) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setActionBar(toolbar);
        } else {
            super.setActionBar(toolbar);
        }
    }

    @Override // android.app.Activity
    public void setContentTransitionManager(TransitionManager transitionManager) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setContentTransitionManager(transitionManager);
        } else {
            super.setContentTransitionManager(transitionManager);
        }
    }

    @Override // android.app.Activity
    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setEnterSharedElementCallback(sharedElementCallback);
        } else {
            super.setEnterSharedElementCallback(sharedElementCallback);
        }
    }

    @Override // android.app.Activity
    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setExitSharedElementCallback(sharedElementCallback);
        } else {
            super.setExitSharedElementCallback(sharedElementCallback);
        }
    }

    @Override // android.app.Activity
    public void setFinishOnTouchOutside(boolean z5) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setFinishOnTouchOutside(z5);
        } else {
            super.setFinishOnTouchOutside(z5);
        }
    }

    @Override // android.app.Activity
    public void setImmersive(boolean z5) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setImmersive(z5);
        } else {
            super.setImmersive(z5);
        }
    }

    @Override // android.app.Activity
    public void setInheritShowWhenLocked(boolean z5) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setInheritShowWhenLocked(z5);
        } else {
            super.setInheritShowWhenLocked(z5);
        }
    }

    @Override // android.app.Activity
    public void setIntent(Intent intent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setIntent(intent);
        } else {
            super.setIntent(intent);
        }
    }

    @Override // android.app.Activity
    public void setLocusContext(LocusId locusId, Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setLocusContext(locusId, bundle);
        } else {
            super.setLocusContext(locusId, bundle);
        }
    }

    @Override // android.app.Activity
    public void setPictureInPictureParams(PictureInPictureParams pictureInPictureParams) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setPictureInPictureParams(pictureInPictureParams);
        } else {
            super.setPictureInPictureParams(pictureInPictureParams);
        }
    }

    @Override // com.bytedance.pangle.activity.xt
    public void setPlugin(Plugin plugin) {
        this.mPlugin = plugin;
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i6) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setRequestedOrientation(i6);
        } else {
            super.setRequestedOrientation(i6);
        }
    }

    @Override // android.app.Activity
    public void setShowWhenLocked(boolean z5) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setShowWhenLocked(z5);
        } else {
            super.setShowWhenLocked(z5);
        }
    }

    @Override // com.bytedance.pangle.activity.xt
    public void setTargetActivity(IPluginActivity iPluginActivity) {
        this.mTargetActivity = (GeneratePluginAppCompatActivity) iPluginActivity;
    }

    @Override // android.app.Activity
    public void setTaskDescription(ActivityManager.TaskDescription taskDescription) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setTaskDescription(taskDescription);
        } else {
            super.setTaskDescription(taskDescription);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i6) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setTheme(i6);
        } else {
            super.setTheme(i6);
        }
    }

    @Override // android.app.Activity
    public void setTitleColor(int i6) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setTitleColor(i6);
        } else {
            super.setTitleColor(i6);
        }
    }

    @Override // android.app.Activity
    public boolean setTranslucent(boolean z5) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.setTranslucent(z5) : super.setTranslucent(z5);
    }

    @Override // android.app.Activity
    public void setTurnScreenOn(boolean z5) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setTurnScreenOn(z5);
        } else {
            super.setTurnScreenOn(z5);
        }
    }

    @Override // android.app.Activity
    public void setVisible(boolean z5) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setVisible(z5);
        } else {
            super.setVisible(z5);
        }
    }

    @Override // android.app.Activity
    public void setVrModeEnabled(boolean z5, ComponentName componentName) throws PackageManager.NameNotFoundException {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setVrModeEnabled(z5, componentName);
        } else {
            super.setVrModeEnabled(z5, componentName);
        }
    }

    @Override // android.app.Activity
    public boolean shouldShowRequestPermissionRationale(String str) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.shouldShowRequestPermissionRationale(str) : super.shouldShowRequestPermissionRationale(str);
    }

    @Override // android.app.Activity
    public boolean shouldUpRecreateTask(Intent intent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.shouldUpRecreateTask(intent) : super.shouldUpRecreateTask(intent);
    }

    @Override // android.app.Activity
    public boolean showAssist(Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        return generatePluginAppCompatActivity != null ? generatePluginAppCompatActivity.showAssist(bundle) : super.showAssist(bundle);
    }

    @Override // android.app.Activity
    public void showLockTaskEscapeMessage() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.showLockTaskEscapeMessage();
        } else {
            super.showLockTaskEscapeMessage();
        }
    }

    @Override // android.app.Activity
    public void startLocalVoiceInteraction(Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startLocalVoiceInteraction(bundle);
        } else {
            super.startLocalVoiceInteraction(bundle);
        }
    }

    @Override // android.app.Activity
    public void startLockTask() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startLockTask();
        } else {
            super.startLockTask();
        }
    }

    @Override // android.app.Activity
    public void startManagingCursor(Cursor cursor) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startManagingCursor(cursor);
        } else {
            super.startManagingCursor(cursor);
        }
    }

    @Override // android.app.Activity
    public void startPostponedEnterTransition() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startPostponedEnterTransition();
        } else {
            super.startPostponedEnterTransition();
        }
    }

    @Override // android.app.Activity
    public void startSearch(String str, boolean z5, Bundle bundle, boolean z6) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startSearch(str, z5, bundle, z6);
        } else {
            super.startSearch(str, z5, bundle, z6);
        }
    }

    @Override // android.app.Activity
    public void stopLocalVoiceInteraction() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.stopLocalVoiceInteraction();
        } else {
            super.stopLocalVoiceInteraction();
        }
    }

    @Override // android.app.Activity
    public void stopLockTask() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.stopLockTask();
        } else {
            super.stopLockTask();
        }
    }

    @Override // android.app.Activity
    public void stopManagingCursor(Cursor cursor) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.stopManagingCursor(cursor);
        } else {
            super.stopManagingCursor(cursor);
        }
    }

    @Override // android.app.Activity
    public void takeKeyEvents(boolean z5) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.takeKeyEvents(z5);
        } else {
            super.takeKeyEvents(z5);
        }
    }

    @Override // android.app.Activity
    public void triggerSearch(String str, Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.triggerSearch(str, bundle);
        } else {
            super.triggerSearch(str, bundle);
        }
    }

    @Override // android.app.Activity
    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        } else {
            super.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    @Override // android.app.Activity
    public void unregisterForContextMenu(View view) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.unregisterForContextMenu(view);
        } else {
            super.unregisterForContextMenu(view);
        }
    }

    public boolean zeusSuperEnterPictureInPictureMode(PictureInPictureParams pictureInPictureParams) {
        return super.enterPictureInPictureMode(pictureInPictureParams);
    }

    public void zeusSuperOnCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.onCreate(bundle, persistableBundle);
    }

    protected Dialog zeusSuperOnCreateDialog(int i6, Bundle bundle) {
        return super.onCreateDialog(i6, bundle);
    }

    public View zeusSuperOnCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    public void zeusSuperOnMultiWindowModeChanged(boolean z5, Configuration configuration) {
        super.onMultiWindowModeChanged(z5, configuration);
    }

    public void zeusSuperOnPictureInPictureModeChanged(boolean z5, Configuration configuration) {
        super.onPictureInPictureModeChanged(z5, configuration);
    }

    public void zeusSuperOnPostCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.onPostCreate(bundle, persistableBundle);
    }

    protected void zeusSuperOnPrepareDialog(int i6, Dialog dialog, Bundle bundle) {
        super.onPrepareDialog(i6, dialog, bundle);
    }

    public void zeusSuperOnRestoreInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        super.onRestoreInstanceState(bundle, persistableBundle);
    }

    public void zeusSuperOnSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        super.onSaveInstanceState(bundle, persistableBundle);
    }

    public boolean zeusSuperOnSearchRequested(SearchEvent searchEvent) {
        return super.onSearchRequested(searchEvent);
    }

    public ActionMode zeusSuperOnWindowStartingActionMode(ActionMode.Callback callback, int i6) {
        return super.onWindowStartingActionMode(callback, i6);
    }

    public void zeusSuperSetContentView(View view) {
        super.setContentView(view);
    }

    public void zeusSuperSetTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
    }

    public ActionMode zeusSuperStartActionMode(ActionMode.Callback callback, int i6) {
        return super.startActionMode(callback, i6);
    }

    public void zeusSuperStartActivities(Intent[] intentArr, Bundle bundle) {
        super.startActivities(intentArr, bundle);
    }

    public void zeusSuperStartActivity(Intent intent, Bundle bundle) {
        super.startActivity(intent, bundle);
    }

    public void zeusSuperStartActivityForResult(Intent intent, int i6, Bundle bundle) {
        super.startActivityForResult(intent, i6, bundle);
    }

    public void zeusSuperStartActivityFromChild(Activity activity, Intent intent, int i6, Bundle bundle) {
        super.startActivityFromChild(activity, intent, i6, bundle);
    }

    public void zeusSuperStartActivityFromFragment(Fragment fragment, Intent intent, int i6, Bundle bundle) {
        super.startActivityFromFragment(fragment, intent, i6, bundle);
    }

    public boolean zeusSuperStartActivityIfNeeded(Intent intent, int i6, Bundle bundle) {
        return super.startActivityIfNeeded(intent, i6, bundle);
    }

    public void zeusSuperStartIntentSender(IntentSender intentSender, Intent intent, int i6, int i7, int i8, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSender(intentSender, intent, i6, i7, i8, bundle);
    }

    public void zeusSuperStartIntentSenderForResult(IntentSender intentSender, int i6, Intent intent, int i7, int i8, int i9, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i6, intent, i7, i8, i9, bundle);
    }

    public void zeusSuperStartIntentSenderFromChild(Activity activity, IntentSender intentSender, int i6, Intent intent, int i7, int i8, int i9, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderFromChild(activity, intentSender, i6, intent, i7, i8, i9, bundle);
    }

    public boolean zeusSuperStartNextMatchingActivity(Intent intent, Bundle bundle) {
        return super.startNextMatchingActivity(intent, bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        cw.j(this, context);
    }

    public void zeusSuperAddContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addContentView(view, layoutParams);
    }

    @Override // com.bytedance.pangle.activity.xt
    public void zeusSuperAttachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public void zeusSuperCloseContextMenu() {
        super.closeContextMenu();
    }

    public void zeusSuperCloseOptionsMenu() {
        super.closeOptionsMenu();
    }

    public PendingIntent zeusSuperCreatePendingResult(int i6, Intent intent, int i7) {
        return super.createPendingResult(i6, intent, i7);
    }

    public boolean zeusSuperDispatchGenericMotionEvent(MotionEvent motionEvent) {
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean zeusSuperDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean zeusSuperDispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean zeusSuperDispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean zeusSuperDispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean zeusSuperDispatchTrackballEvent(MotionEvent motionEvent) {
        return super.dispatchTrackballEvent(motionEvent);
    }

    public void zeusSuperDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
    }

    public View zeusSuperFindViewById(int i6) {
        return super.findViewById(i6);
    }

    public void zeusSuperFinish() {
        super.finish();
    }

    public void zeusSuperFinishActivity(int i6) {
        super.finishActivity(i6);
    }

    public void zeusSuperFinishActivityFromChild(Activity activity, int i6) {
        super.finishActivityFromChild(activity, i6);
    }

    public void zeusSuperFinishAffinity() {
        super.finishAffinity();
    }

    public void zeusSuperFinishAfterTransition() {
        super.finishAfterTransition();
    }

    public void zeusSuperFinishAndRemoveTask() {
        super.finishAndRemoveTask();
    }

    public void zeusSuperFinishFromChild(Activity activity) {
        super.finishFromChild(activity);
    }

    public ActionBar zeusSuperGetActionBar() {
        return super.getActionBar();
    }

    public ComponentName zeusSuperGetCallingActivity() {
        return super.getCallingActivity();
    }

    public String zeusSuperGetCallingPackage() {
        return super.getCallingPackage();
    }

    public int zeusSuperGetChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    public ComponentName zeusSuperGetComponentName() {
        return super.getComponentName();
    }

    public Scene zeusSuperGetContentScene() {
        return super.getContentScene();
    }

    public TransitionManager zeusSuperGetContentTransitionManager() {
        return super.getContentTransitionManager();
    }

    public View zeusSuperGetCurrentFocus() {
        return super.getCurrentFocus();
    }

    public FragmentManager zeusSuperGetFragmentManager() {
        return super.getFragmentManager();
    }

    public Intent zeusSuperGetIntent() {
        return super.getIntent();
    }

    public Object zeusSuperGetLastNonConfigurationInstance() {
        return super.getLastNonConfigurationInstance();
    }

    public LayoutInflater zeusSuperGetLayoutInflater() {
        return super.getLayoutInflater();
    }

    public Lifecycle zeusSuperGetLifecycle() {
        return super.getLifecycle();
    }

    public LoaderManager zeusSuperGetLoaderManager() {
        return super.getLoaderManager();
    }

    public String zeusSuperGetLocalClassName() {
        return super.getLocalClassName();
    }

    public int zeusSuperGetMaxNumPictureInPictureActions() {
        return super.getMaxNumPictureInPictureActions();
    }

    public MenuInflater zeusSuperGetMenuInflater() {
        return super.getMenuInflater();
    }

    public Intent zeusSuperGetParentActivityIntent() {
        return super.getParentActivityIntent();
    }

    public SharedPreferences zeusSuperGetPreferences(int i6) {
        return super.getPreferences(i6);
    }

    public Uri zeusSuperGetReferrer() {
        return super.getReferrer();
    }

    public int zeusSuperGetRequestedOrientation() {
        return super.getRequestedOrientation();
    }

    public androidx.appcompat.app.ActionBar zeusSuperGetSupportActionBar() {
        return super.getSupportActionBar();
    }

    public androidx.fragment.app.FragmentManager zeusSuperGetSupportFragmentManager() {
        return super.getSupportFragmentManager();
    }

    public Object zeusSuperGetSystemService(String str) {
        return super.getSystemService(str);
    }

    public int zeusSuperGetTaskId() {
        return super.getTaskId();
    }

    public VoiceInteractor zeusSuperGetVoiceInteractor() {
        return super.getVoiceInteractor();
    }

    public Window zeusSuperGetWindow() {
        return super.getWindow();
    }

    public WindowManager zeusSuperGetWindowManager() {
        return super.getWindowManager();
    }

    public boolean zeusSuperHasWindowFocus() {
        return super.hasWindowFocus();
    }

    public void zeusSuperInvalidateOptionsMenu() {
        super.invalidateOptionsMenu();
    }

    public boolean zeusSuperIsActivityTransitionRunning() {
        return super.isActivityTransitionRunning();
    }

    public boolean zeusSuperIsChangingConfigurations() {
        return super.isChangingConfigurations();
    }

    public boolean zeusSuperIsDestroyed() {
        return super.isDestroyed();
    }

    public boolean zeusSuperIsFinishing() {
        return super.isFinishing();
    }

    public boolean zeusSuperIsImmersive() {
        return super.isImmersive();
    }

    public boolean zeusSuperIsInMultiWindowMode() {
        return super.isInMultiWindowMode();
    }

    public boolean zeusSuperIsInPictureInPictureMode() {
        return super.isInPictureInPictureMode();
    }

    public boolean zeusSuperIsLocalVoiceInteractionSupported() {
        return super.isLocalVoiceInteractionSupported();
    }

    public boolean zeusSuperIsTaskRoot() {
        return super.isTaskRoot();
    }

    public boolean zeusSuperIsVoiceInteraction() {
        return super.isVoiceInteraction();
    }

    public boolean zeusSuperIsVoiceInteractionRoot() {
        return super.isVoiceInteractionRoot();
    }

    public boolean zeusSuperMoveTaskToBack(boolean z5) {
        return super.moveTaskToBack(z5);
    }

    public boolean zeusSuperNavigateUpTo(Intent intent) {
        return super.navigateUpTo(intent);
    }

    public boolean zeusSuperNavigateUpToFromChild(Activity activity, Intent intent) {
        return super.navigateUpToFromChild(activity, intent);
    }

    public void zeusSuperOnActionModeFinished(ActionMode actionMode) {
        super.onActionModeFinished(actionMode);
    }

    public void zeusSuperOnActionModeStarted(ActionMode actionMode) {
        super.onActionModeStarted(actionMode);
    }

    public void zeusSuperOnActivityReenter(int i6, Intent intent) {
        super.onActivityReenter(i6, intent);
    }

    protected void zeusSuperOnActivityResult(int i6, int i7, Intent intent) {
        super.onActivityResult(i6, i7, intent);
    }

    protected void zeusSuperOnApplyThemeResource(Resources.Theme theme, int i6, boolean z5) {
        super.onApplyThemeResource(theme, i6, z5);
    }

    public void zeusSuperOnAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
    }

    public void zeusSuperOnAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void zeusSuperOnBackPressed() {
        super.onBackPressed();
    }

    protected void zeusSuperOnChildTitleChanged(Activity activity, CharSequence charSequence) {
        super.onChildTitleChanged(activity, charSequence);
    }

    public void zeusSuperOnConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void zeusSuperOnContentChanged() {
        super.onContentChanged();
    }

    public boolean zeusSuperOnContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    public void zeusSuperOnContextMenuClosed(Menu menu) {
        super.onContextMenuClosed(menu);
    }

    public void zeusSuperOnCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public CharSequence zeusSuperOnCreateDescription() {
        return super.onCreateDescription();
    }

    public void zeusSuperOnCreateNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        super.onCreateNavigateUpTaskStack(taskStackBuilder);
    }

    public boolean zeusSuperOnCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public boolean zeusSuperOnCreatePanelMenu(int i6, Menu menu) {
        return super.onCreatePanelMenu(i6, menu);
    }

    public View zeusSuperOnCreatePanelView(int i6) {
        return super.onCreatePanelView(i6);
    }

    public boolean zeusSuperOnCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        return super.onCreateThumbnail(bitmap, canvas);
    }

    protected void zeusSuperOnDestroy() {
        super.onDestroy();
    }

    public void zeusSuperOnDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void zeusSuperOnEnterAnimationComplete() {
        super.onEnterAnimationComplete();
    }

    public boolean zeusSuperOnGenericMotionEvent(MotionEvent motionEvent) {
        return super.onGenericMotionEvent(motionEvent);
    }

    public void zeusSuperOnGetDirectActions(CancellationSignal cancellationSignal, Consumer consumer) {
        super.onGetDirectActions(cancellationSignal, consumer);
    }

    public boolean zeusSuperOnKeyDown(int i6, KeyEvent keyEvent) {
        return super.onKeyDown(i6, keyEvent);
    }

    public boolean zeusSuperOnKeyLongPress(int i6, KeyEvent keyEvent) {
        return super.onKeyLongPress(i6, keyEvent);
    }

    public boolean zeusSuperOnKeyMultiple(int i6, int i7, KeyEvent keyEvent) {
        return super.onKeyMultiple(i6, i7, keyEvent);
    }

    public boolean zeusSuperOnKeyShortcut(int i6, KeyEvent keyEvent) {
        return super.onKeyShortcut(i6, keyEvent);
    }

    public boolean zeusSuperOnKeyUp(int i6, KeyEvent keyEvent) {
        return super.onKeyUp(i6, keyEvent);
    }

    public void zeusSuperOnLocalVoiceInteractionStarted() {
        super.onLocalVoiceInteractionStarted();
    }

    public void zeusSuperOnLocalVoiceInteractionStopped() {
        super.onLocalVoiceInteractionStopped();
    }

    public void zeusSuperOnLowMemory() {
        super.onLowMemory();
    }

    public boolean zeusSuperOnMenuOpened(int i6, Menu menu) {
        return super.onMenuOpened(i6, menu);
    }

    public boolean zeusSuperOnNavigateUp() {
        return super.onNavigateUp();
    }

    public boolean zeusSuperOnNavigateUpFromChild(Activity activity) {
        return super.onNavigateUpFromChild(activity);
    }

    protected void zeusSuperOnNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    public boolean zeusSuperOnOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    public void zeusSuperOnOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    public void zeusSuperOnPanelClosed(int i6, Menu menu) {
        super.onPanelClosed(i6, menu);
    }

    protected void zeusSuperOnPause() {
        super.onPause();
    }

    public void zeusSuperOnPerformDirectAction(String str, Bundle bundle, CancellationSignal cancellationSignal, Consumer consumer) {
        super.onPerformDirectAction(str, bundle, cancellationSignal, consumer);
    }

    public boolean zeusSuperOnPictureInPictureRequested() {
        return super.onPictureInPictureRequested();
    }

    protected void zeusSuperOnPostResume() {
        super.onPostResume();
    }

    public void zeusSuperOnPrepareNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        super.onPrepareNavigateUpTaskStack(taskStackBuilder);
    }

    public boolean zeusSuperOnPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean zeusSuperOnPreparePanel(int i6, View view, Menu menu) {
        return super.onPreparePanel(i6, view, menu);
    }

    public void zeusSuperOnProvideAssistContent(AssistContent assistContent) {
        super.onProvideAssistContent(assistContent);
    }

    public void zeusSuperOnProvideAssistData(Bundle bundle) {
        super.onProvideAssistData(bundle);
    }

    public void zeusSuperOnProvideKeyboardShortcuts(List list, Menu menu, int i6) {
        super.onProvideKeyboardShortcuts(list, menu, i6);
    }

    public Uri zeusSuperOnProvideReferrer() {
        return super.onProvideReferrer();
    }

    public void zeusSuperOnRequestPermissionsResult(int i6, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i6, strArr, iArr);
    }

    protected void zeusSuperOnRestart() {
        super.onRestart();
    }

    protected void zeusSuperOnResume() {
        super.onResume();
    }

    protected void zeusSuperOnStart() {
        super.onStart();
    }

    public void zeusSuperOnStateNotSaved() {
        super.onStateNotSaved();
    }

    protected void zeusSuperOnStop() {
        super.onStop();
    }

    protected void zeusSuperOnTitleChanged(CharSequence charSequence, int i6) {
        super.onTitleChanged(charSequence, i6);
    }

    public void zeusSuperOnTopResumedActivityChanged(boolean z5) {
        super.onTopResumedActivityChanged(z5);
    }

    public boolean zeusSuperOnTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public boolean zeusSuperOnTrackballEvent(MotionEvent motionEvent) {
        return super.onTrackballEvent(motionEvent);
    }

    public void zeusSuperOnTrimMemory(int i6) {
        super.onTrimMemory(i6);
    }

    public void zeusSuperOnUserInteraction() {
        super.onUserInteraction();
    }

    protected void zeusSuperOnUserLeaveHint() {
        super.onUserLeaveHint();
    }

    public void zeusSuperOnVisibleBehindCanceled() {
        super.onVisibleBehindCanceled();
    }

    public void zeusSuperOnWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        super.onWindowAttributesChanged(layoutParams);
    }

    public void zeusSuperOnWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
    }

    public void zeusSuperOpenContextMenu(View view) {
        super.openContextMenu(view);
    }

    public void zeusSuperOpenOptionsMenu() {
        super.openOptionsMenu();
    }

    public void zeusSuperOverridePendingTransition(int i6, int i7) {
        super.overridePendingTransition(i6, i7);
    }

    public void zeusSuperPostponeEnterTransition() {
        super.postponeEnterTransition();
    }

    public void zeusSuperRecreate() {
        super.recreate();
    }

    public void zeusSuperRegisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        super.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public void zeusSuperRegisterForContextMenu(View view) {
        super.registerForContextMenu(view);
    }

    public boolean zeusSuperReleaseInstance() {
        return super.releaseInstance();
    }

    public void zeusSuperReportFullyDrawn() {
        super.reportFullyDrawn();
    }

    public DragAndDropPermissions zeusSuperRequestDragAndDropPermissions(DragEvent dragEvent) {
        return super.requestDragAndDropPermissions(dragEvent);
    }

    public boolean zeusSuperRequestVisibleBehind(boolean z5) {
        return super.requestVisibleBehind(z5);
    }

    public void zeusSuperSetActionBar(Toolbar toolbar) {
        super.setActionBar(toolbar);
    }

    public void zeusSuperSetContentTransitionManager(TransitionManager transitionManager) {
        super.setContentTransitionManager(transitionManager);
    }

    public void zeusSuperSetContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
    }

    public void zeusSuperSetEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        super.setEnterSharedElementCallback(sharedElementCallback);
    }

    public void zeusSuperSetExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        super.setExitSharedElementCallback(sharedElementCallback);
    }

    public void zeusSuperSetFinishOnTouchOutside(boolean z5) {
        super.setFinishOnTouchOutside(z5);
    }

    public void zeusSuperSetImmersive(boolean z5) {
        super.setImmersive(z5);
    }

    public void zeusSuperSetInheritShowWhenLocked(boolean z5) {
        super.setInheritShowWhenLocked(z5);
    }

    public void zeusSuperSetIntent(Intent intent) {
        super.setIntent(intent);
    }

    public void zeusSuperSetLocusContext(LocusId locusId, Bundle bundle) {
        super.setLocusContext(locusId, bundle);
    }

    public void zeusSuperSetPictureInPictureParams(PictureInPictureParams pictureInPictureParams) {
        super.setPictureInPictureParams(pictureInPictureParams);
    }

    public void zeusSuperSetRequestedOrientation(int i6) {
        super.setRequestedOrientation(i6);
    }

    public void zeusSuperSetShowWhenLocked(boolean z5) {
        super.setShowWhenLocked(z5);
    }

    public void zeusSuperSetTaskDescription(ActivityManager.TaskDescription taskDescription) {
        super.setTaskDescription(taskDescription);
    }

    @Override // com.bytedance.pangle.activity.xt
    public void zeusSuperSetTheme(int i6) {
        super.setTheme(i6);
    }

    public void zeusSuperSetTitleColor(int i6) {
        super.setTitleColor(i6);
    }

    public boolean zeusSuperSetTranslucent(boolean z5) {
        return super.setTranslucent(z5);
    }

    public void zeusSuperSetTurnScreenOn(boolean z5) {
        super.setTurnScreenOn(z5);
    }

    public void zeusSuperSetVisible(boolean z5) {
        super.setVisible(z5);
    }

    public void zeusSuperSetVrModeEnabled(boolean z5, ComponentName componentName) throws PackageManager.NameNotFoundException {
        super.setVrModeEnabled(z5, componentName);
    }

    public boolean zeusSuperShouldShowRequestPermissionRationale(String str) {
        return super.shouldShowRequestPermissionRationale(str);
    }

    public boolean zeusSuperShouldUpRecreateTask(Intent intent) {
        return super.shouldUpRecreateTask(intent);
    }

    public boolean zeusSuperShowAssist(Bundle bundle) {
        return super.showAssist(bundle);
    }

    public void zeusSuperShowLockTaskEscapeMessage() {
        super.showLockTaskEscapeMessage();
    }

    public void zeusSuperStartLocalVoiceInteraction(Bundle bundle) {
        super.startLocalVoiceInteraction(bundle);
    }

    public void zeusSuperStartLockTask() {
        super.startLockTask();
    }

    public void zeusSuperStartManagingCursor(Cursor cursor) {
        super.startManagingCursor(cursor);
    }

    public void zeusSuperStartPostponedEnterTransition() {
        super.startPostponedEnterTransition();
    }

    public void zeusSuperStartSearch(String str, boolean z5, Bundle bundle, boolean z6) {
        super.startSearch(str, z5, bundle, z6);
    }

    public void zeusSuperStopLocalVoiceInteraction() {
        super.stopLocalVoiceInteraction();
    }

    public void zeusSuperStopLockTask() {
        super.stopLockTask();
    }

    public void zeusSuperStopManagingCursor(Cursor cursor) {
        super.stopManagingCursor(cursor);
    }

    public void zeusSuperTakeKeyEvents(boolean z5) {
        super.takeKeyEvents(z5);
    }

    public void zeusSuperTriggerSearch(String str, Bundle bundle) {
        super.triggerSearch(str, bundle);
    }

    public void zeusSuperUnregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        super.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public void zeusSuperUnregisterForContextMenu(View view) {
        super.unregisterForContextMenu(view);
    }

    @Override // android.app.Activity
    public boolean enterPictureInPictureMode(PictureInPictureParams pictureInPictureParams) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.enterPictureInPictureMode(pictureInPictureParams);
        }
        return super.enterPictureInPictureMode(pictureInPictureParams);
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i6, Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onCreateDialog(i6, bundle);
        }
        return super.onCreateDialog(i6, bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onCreateView(str, context, attributeSet);
        }
        return super.onCreateView(str, context, attributeSet);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean z5, Configuration configuration) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onMultiWindowModeChanged(z5, configuration);
        } else {
            super.onMultiWindowModeChanged(z5, configuration);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onPictureInPictureModeChanged(boolean z5, Configuration configuration) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onPictureInPictureModeChanged(z5, configuration);
        } else {
            super.onPictureInPictureModeChanged(z5, configuration);
        }
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle, PersistableBundle persistableBundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onPostCreate(bundle, persistableBundle);
        } else {
            super.onPostCreate(bundle, persistableBundle);
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i6, Dialog dialog, Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onPrepareDialog(i6, dialog, bundle);
        } else {
            super.onPrepareDialog(i6, dialog, bundle);
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onRestoreInstanceState(bundle, persistableBundle);
        } else {
            super.onRestoreInstanceState(bundle, persistableBundle);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent searchEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onSearchRequested(searchEvent);
        }
        return super.onSearchRequested(searchEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i6) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onWindowStartingActionMode(callback, i6);
        }
        return super.onWindowStartingActionMode(callback, i6);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setContentView(view);
        } else {
            super.setContentView(view);
        }
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setTitle(charSequence);
        } else {
            super.setTitle(charSequence);
        }
    }

    @Override // android.app.Activity
    public ActionMode startActionMode(ActionMode.Callback callback, int i6) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.startActionMode(callback, i6);
        }
        return super.startActionMode(callback, i6);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startActivities(intentArr, bundle);
        } else {
            super.startActivities(intentArr, bundle);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startActivity(intent, bundle);
        } else {
            super.startActivity(intent, bundle);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i6, Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startActivityForResult(intent, i6, bundle);
        } else {
            super.startActivityForResult(intent, i6, bundle);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity activity, Intent intent, int i6, Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startActivityFromChild(activity, intent, i6, bundle);
        } else {
            super.startActivityFromChild(activity, intent, i6, bundle);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(Fragment fragment, Intent intent, int i6, Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startActivityFromFragment(fragment, intent, i6, bundle);
        } else {
            super.startActivityFromFragment(fragment, intent, i6, bundle);
        }
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i6, Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.startActivityIfNeeded(intent, i6, bundle);
        }
        return super.startActivityIfNeeded(intent, i6, bundle);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i6, int i7, int i8, Bundle bundle) throws IntentSender.SendIntentException {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startIntentSender(intentSender, intent, i6, i7, i8, bundle);
        } else {
            super.startIntentSender(intentSender, intent, i6, i7, i8, bundle);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i6, Intent intent, int i7, int i8, int i9, Bundle bundle) throws IntentSender.SendIntentException {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startIntentSenderForResult(intentSender, i6, intent, i7, i8, i9, bundle);
        } else {
            super.startIntentSenderForResult(intentSender, i6, intent, i7, i8, i9, bundle);
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(Activity activity, IntentSender intentSender, int i6, Intent intent, int i7, int i8, int i9, Bundle bundle) throws IntentSender.SendIntentException {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startIntentSenderFromChild(activity, intentSender, i6, intent, i7, i8, i9, bundle);
        } else {
            super.startIntentSenderFromChild(activity, intentSender, i6, intent, i7, i8, i9, bundle);
        }
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent intent, Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.startNextMatchingActivity(intent, bundle);
        }
        return super.startNextMatchingActivity(intent, bundle);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onSaveInstanceState(bundle, persistableBundle);
        } else {
            super.onSaveInstanceState(bundle, persistableBundle);
        }
        bundle.clear();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setContentView(view, layoutParams);
        } else {
            super.setContentView(view, layoutParams);
        }
    }

    public void startActivityForResult(String str, Intent intent, int i6, Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startActivityForResult(intent, i6, bundle);
        } else {
            super.startActivityForResult(intent, i6, bundle);
        }
    }
}
