package com.tencent.open.web.security;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.tencent.open.log.SLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a extends InputConnectionWrapper {

    /* renamed from: a, reason: collision with root package name */
    public static String f40686a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f40687b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f40688c;

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i6) {
        f40688c = true;
        f40686a = charSequence.toString();
        SLog.v("openSDK_LOG.CaptureInputConnection", "-->commitText: " + charSequence.toString());
        return super.commitText(charSequence, i6);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i6) {
        f40688c = true;
        f40686a = charSequence.toString();
        SLog.v("openSDK_LOG.CaptureInputConnection", "-->setComposingText: " + charSequence.toString());
        return super.setComposingText(charSequence, i6);
    }

    public a(InputConnection inputConnection, boolean z5) {
        super(inputConnection, z5);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            SLog.i("openSDK_LOG.CaptureInputConnection", "sendKeyEvent");
            f40686a = String.valueOf((char) keyEvent.getUnicodeChar());
            f40688c = true;
            SLog.d("openSDK_LOG.CaptureInputConnection", "s: " + f40686a);
        }
        SLog.d("openSDK_LOG.CaptureInputConnection", "-->sendKeyEvent: " + f40686a);
        return super.sendKeyEvent(keyEvent);
    }
}
