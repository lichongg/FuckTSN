package com.bxkj.base.keyboard;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.Build;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bxkj.base.R;
import com.stub.StubApp;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class c implements View.OnClickListener, View.OnFocusChangeListener, KeyboardView.OnKeyboardActionListener, PopupWindow.OnDismissListener {

    /* renamed from: g, reason: collision with root package name */
    private static final int f16518g = R.id.keyboard_view;

    /* renamed from: h, reason: collision with root package name */
    private static PopupWindow f16519h;

    /* renamed from: a, reason: collision with root package name */
    protected Keyboard f16520a;

    /* renamed from: b, reason: collision with root package name */
    private View f16521b;

    /* renamed from: c, reason: collision with root package name */
    protected KeyboardView f16522c;

    /* renamed from: d, reason: collision with root package name */
    private Activity f16523d;

    /* renamed from: e, reason: collision with root package name */
    private a f16524e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f16525f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a();
    }

    public c(Activity activity) {
        this(activity, null);
    }

    public c(Activity activity, EditText editText) {
        this.f16525f = false;
        this.f16523d = activity;
        PopupWindow d6 = d(StubApp.getOrigApplicationContext(activity.getApplicationContext()));
        f16519h = d6;
        d6.setOnDismissListener(this);
        this.f16522c = (KeyboardView) f16519h.getContentView().findViewById(R.id.keyboard_view);
        this.f16521b = f16519h.getContentView().findViewById(R.id.keyboard_view_layout);
        f16519h.setOutsideTouchable(true);
        j(activity);
        a(editText);
    }

    protected static PopupWindow d(Context context) {
        PopupWindow popupWindow = f16519h;
        if (popupWindow != null) {
            return popupWindow;
        }
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(context).inflate(R.layout.keyboard_layout, (ViewGroup) null), StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().widthPixels, -2, true);
        popupWindow2.setInputMethodMode(1);
        popupWindow2.setSoftInputMode(16);
        popupWindow2.setFocusable(false);
        popupWindow2.setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.transparent)));
        popupWindow2.setAnimationStyle(R.style.keyboard_anim_style);
        return popupWindow2;
    }

    public static Point e(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }

    public static Point h(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        return point;
    }

    private static boolean l(int i6) {
        int i7 = i6 & 4095;
        return i7 == 129 || i7 == 225 || i7 == 18;
    }

    public c a(EditText editText) {
        if (editText != null) {
            editText.setCursorVisible(true);
            editText.setSingleLine(false);
            editText.setOnClickListener(this);
            editText.setOnFocusChangeListener(this);
            if (l(editText.getInputType())) {
                b(editText, false);
            }
        }
        return this;
    }

    public c b(EditText editText, boolean z5) {
        if (z5) {
            editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            return this;
        }
        editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        return this;
    }

    @Nullable
    protected EditText f() {
        Object tag = this.f16522c.getTag(f16518g);
        if (tag == null || !(tag instanceof EditText)) {
            return null;
        }
        return (EditText) tag;
    }

    public void i(EditText editText) {
        int visibility = this.f16521b.getVisibility();
        if (visibility == 0 || visibility == 4) {
            f16519h.dismiss();
        }
    }

    protected void j(Activity activity) {
        Keyboard keyboard = new Keyboard(StubApp.getOrigApplicationContext(activity.getApplicationContext()), R.xml.keyboard_digs);
        this.f16520a = keyboard;
        this.f16522c.setKeyboard(keyboard);
        this.f16522c.setEnabled(true);
        this.f16522c.setPreviewEnabled(false);
        this.f16522c.setOnKeyboardActionListener(this);
    }

    protected boolean k(String str) {
        return "0123456789".indexOf(str) > -1;
    }

    protected boolean m(String str) {
        return "abcdefghijklmnopqrstuvwxyz".indexOf(str.toLowerCase()) > -1;
    }

    protected void o() {
        List<Keyboard.Key> keys = this.f16520a.getKeys();
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < keys.size(); i6++) {
            if (keys.get(i6).label != null && k(keys.get(i6).label.toString())) {
                arrayList.add(keys.get(i6));
            }
        }
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        LinkedList linkedList = new LinkedList();
        for (int i7 = 0; i7 < size; i7++) {
            linkedList.add(new com.bxkj.base.keyboard.a(Integer.valueOf(i7 + 48), i7 + ""));
        }
        Random random = new Random();
        for (int i8 = 0; i8 < size; i8++) {
            int nextInt = random.nextInt(size - i8);
            arrayList2.add(new com.bxkj.base.keyboard.a(((com.bxkj.base.keyboard.a) linkedList.get(nextInt)).a(), ((com.bxkj.base.keyboard.a) linkedList.get(nextInt)).b()));
            linkedList.remove(nextInt);
        }
        for (int i9 = 0; i9 < arrayList.size(); i9++) {
            ((Keyboard.Key) arrayList.get(i9)).label = ((com.bxkj.base.keyboard.a) arrayList2.get(i9)).b();
            ((Keyboard.Key) arrayList.get(i9)).codes[0] = ((com.bxkj.base.keyboard.a) arrayList2.get(i9)).a().intValue();
        }
        this.f16522c.setKeyboard(this.f16520a);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof EditText) {
            r((EditText) view);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f16522c.setTag(f16518g, null);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z5) {
        if (view instanceof EditText) {
            EditText editText = (EditText) view;
            if (!z5) {
                i(editText);
                return;
            }
            try {
                Method method = EditText.class.getMethod("setShowSoftInputOnFocus", Boolean.TYPE);
                method.setAccessible(true);
                method.invoke(editText, Boolean.FALSE);
            } catch (Exception unused) {
            }
            ((InputMethodManager) editText.getContext().getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
            r(editText);
        }
    }

    public c p(a aVar) {
        this.f16524e = aVar;
        return this;
    }

    public c q(boolean z5) {
        this.f16525f = z5;
        return this;
    }

    public static Point g(Context context) {
        Point e6 = e(context);
        Point h6 = h(context);
        if (e6.x < h6.x) {
            return new Point(h6.x - e6.x, e6.y);
        }
        if (e6.y < h6.y) {
            return new Point(e6.x, h6.y - e6.y);
        }
        return new Point();
    }

    public c c(boolean z5) {
        EditText f6 = f();
        if (f6 == null) {
            return this;
        }
        return b(f6, z5);
    }

    protected boolean n(View view) {
        Context context = view.getContext();
        if (context instanceof ContextWrapper) {
            return ((ContextWrapper) context).getBaseContext() instanceof Activity;
        }
        return false;
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void onKey(int i6, int[] iArr) {
        EditText f6 = f();
        if (f6 != null) {
            Editable text = f6.getText();
            int selectionStart = f6.getSelectionStart();
            int selectionEnd = f6.getSelectionEnd();
            if (i6 == -3) {
                i(f6);
                return;
            }
            if (i6 == -99999999) {
                f6.setText("");
                return;
            }
            if (i6 == -5) {
                if (selectionStart == selectionEnd) {
                    selectionStart--;
                }
                if (!TextUtils.isEmpty(text) && selectionStart >= 0 && selectionEnd <= text.length()) {
                    text.delete(selectionStart, selectionEnd);
                    return;
                }
                return;
            }
            text.insert(selectionStart, Character.toString((char) i6));
        }
    }

    public void r(@NonNull EditText editText) {
        EditText f6 = f();
        if (editText != f6) {
            i(f6);
            this.f16522c.setTag(f16518g, editText);
            int visibility = this.f16521b.getVisibility();
            if (visibility == 8 || visibility == 4) {
                this.f16521b.setVisibility(0);
            }
            if (this.f16525f) {
                o();
            }
            IBinder windowToken = editText.getWindowToken();
            if (windowToken != null && windowToken.isBinderAlive()) {
                editText.getRootView().getGlobalVisibleRect(new Rect());
                int i6 = StubApp.getOrigApplicationContext(editText.getContext().getApplicationContext()).getResources().getDisplayMetrics().heightPixels;
                if (Build.VERSION.SDK_INT >= 22) {
                    f16519h.setAttachedInDecor(n(editText));
                }
                ((WindowManager) this.f16523d.getSystemService("window")).getDefaultDisplay().getWidth();
                f16519h.setTouchable(true);
                f16519h.getContentView().measure(0, 0);
                f16519h.showAtLocation(editText, 81, 0, -f16519h.getContentView().getMeasuredHeight());
                editText.requestFocus();
            }
        }
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void onPress(int i6) {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void onRelease(int i6) {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void onText(CharSequence charSequence) {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void swipeDown() {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void swipeLeft() {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void swipeRight() {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void swipeUp() {
    }
}
