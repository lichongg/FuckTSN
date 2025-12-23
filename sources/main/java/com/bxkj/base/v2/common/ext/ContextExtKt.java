package com.bxkj.base.v2.common.ext;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import com.bxkj.base.BaseApp;
import com.bxkj.base.R;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nContextExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContextExt.kt\ncom/bxkj/base/v2/common/ext/ContextExtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,210:1\n1#2:211\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class ContextExtKt {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private static Toast f16745a;

    @NotNull
    public static final iOSTwoButtonDialog g(@NotNull Context context, @Nullable String str, @NotNull CharSequence message, @NotNull final Function1<? super iOSTwoButtonDialog, n1> confirm, @Nullable final Function1<? super iOSTwoButtonDialog, n1> function1, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        g0.p(context, "<this>");
        g0.p(message, "message");
        g0.p(confirm, "confirm");
        final iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(context);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                iostwobuttondialog.setTitle(str);
                iostwobuttondialog.setMessage(message);
                iostwobuttondialog.setLeftButtonText(charSequence);
                iostwobuttondialog.setRightButtonText(charSequence2);
                iostwobuttondialog.setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.base.v2.common.ext.c
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
                    public final void buttonLeftOnClick() {
                        ContextExtKt.i(Function1.this, iostwobuttondialog);
                    }
                });
                iostwobuttondialog.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.base.v2.common.ext.d
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        ContextExtKt.j(Function1.this, iostwobuttondialog);
                    }
                });
                iostwobuttondialog.show();
                if (context instanceof ComponentActivity) {
                    ((ComponentActivity) context).getLifecycle().addObserver(new LifecycleObserver() { // from class: com.bxkj.base.v2.common.ext.ContextExtKt$showAlertConfirmDialog$2
                        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                        public final void onDestroy() {
                            iOSTwoButtonDialog.this.dismiss();
                        }
                    });
                }
            }
        }
        return iostwobuttondialog;
    }

    public static /* synthetic */ iOSTwoButtonDialog h(Context context, String str, CharSequence charSequence, Function1 function1, Function1 function12, CharSequence charSequence2, CharSequence charSequence3, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = "提示";
        }
        if ((i6 & 8) != 0) {
            function12 = null;
        }
        if ((i6 & 16) != 0) {
            charSequence2 = "取消";
        }
        if ((i6 & 32) != 0) {
            charSequence3 = "确定";
        }
        CharSequence charSequence4 = charSequence3;
        return g(context, str, charSequence, function1, function12, charSequence2, charSequence4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 function1, iOSTwoButtonDialog iostwobuttondialog) {
        if (function1 != null) {
            function1.invoke(iostwobuttondialog);
        }
    }

    @NotNull
    public static final iOSOneButtonDialog k(@NotNull Context context, @NotNull CharSequence title, int i6, @NotNull final Function1<? super iOSOneButtonDialog, n1> click) {
        g0.p(context, "<this>");
        g0.p(title, "title");
        g0.p(click, "click");
        final iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(context);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                iosonebuttondialog.setCenterCustomView(i6).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.v2.common.ext.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ContextExtKt.l(Function1.this, iosonebuttondialog, view);
                    }
                });
                iosonebuttondialog.setTitle(title);
                iosonebuttondialog.show();
                if (context instanceof ComponentActivity) {
                    ((ComponentActivity) context).getLifecycle().addObserver(new LifecycleObserver() { // from class: com.bxkj.base.v2.common.ext.ContextExtKt$showAlertCustomDialog$2
                        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                        public final void onDestroy() {
                            iOSOneButtonDialog.this.dismiss();
                        }
                    });
                }
            }
        }
        return iosonebuttondialog;
    }

    @NotNull
    public static final iOSOneButtonDialog m(@NotNull Context context, @NotNull CharSequence message) {
        g0.p(context, "<this>");
        g0.p(message, "message");
        final iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(context);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                iosonebuttondialog.setMessage(message);
                iosonebuttondialog.show();
                if (context instanceof ComponentActivity) {
                    ((ComponentActivity) context).getLifecycle().addObserver(new LifecycleObserver() { // from class: com.bxkj.base.v2.common.ext.ContextExtKt$showAlertDialog$2
                        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                        public final void onDestroy() {
                            iOSOneButtonDialog.this.dismiss();
                        }
                    });
                }
            }
        }
        return iosonebuttondialog;
    }

    @NotNull
    public static final iOSOneButtonDialog n(@NotNull Context context, @NotNull CharSequence message, @NotNull CharSequence title) {
        g0.p(context, "<this>");
        g0.p(message, "message");
        g0.p(title, "title");
        final iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(context);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                iosonebuttondialog.setTitle(title);
                iosonebuttondialog.setMessage(message);
                iosonebuttondialog.show();
                if (context instanceof ComponentActivity) {
                    ((ComponentActivity) context).getLifecycle().addObserver(new LifecycleObserver() { // from class: com.bxkj.base.v2.common.ext.ContextExtKt$showAlertDialog$4
                        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                        public final void onDestroy() {
                            iOSOneButtonDialog.this.dismiss();
                        }
                    });
                }
            }
        }
        return iosonebuttondialog;
    }

    @NotNull
    public static final iOSOneButtonDialog o(@NotNull Context context, @NotNull CharSequence message, @NotNull final Function1<? super iOSOneButtonDialog, n1> click) {
        g0.p(context, "<this>");
        g0.p(message, "message");
        g0.p(click, "click");
        final iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(context);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                iosonebuttondialog.setMessage(message).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.v2.common.ext.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ContextExtKt.p(Function1.this, iosonebuttondialog, view);
                    }
                }).show();
                if (context instanceof ComponentActivity) {
                    ((ComponentActivity) context).getLifecycle().addObserver(new LifecycleObserver() { // from class: com.bxkj.base.v2.common.ext.ContextExtKt$showAlertDialog$7
                        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                        public final void onDestroy() {
                            iOSOneButtonDialog.this.dismiss();
                        }
                    });
                }
            }
        }
        return iosonebuttondialog;
    }

    public static final void q(@NotNull Context context, @NotNull CharSequence errorMsg) {
        g0.p(context, "<this>");
        g0.p(errorMsg, "errorMsg");
        Toast toast = new Toast(BaseApp.c());
        View inflate = View.inflate(context, R.layout.toast_ok, null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_msg);
        ((ImageView) inflate.findViewById(R.id.iv_hint)).setImageResource(R.mipmap.toast_n);
        textView.setText(errorMsg);
        toast.setView(inflate);
        toast.setGravity(17, 0, 0);
        toast.setDuration(0);
        toast.show();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0048, code lost:
    
        if (r5.isDestroyed() == false) goto L16;
     */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final android.widget.Toast r(@org.jetbrains.annotations.NotNull android.content.Context r4, @org.jetbrains.annotations.NotNull java.lang.CharSequence r5, int r6) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.g0.p(r4, r0)
            java.lang.String r0 = "msg"
            kotlin.jvm.internal.g0.p(r5, r0)
            android.widget.Toast r0 = new android.widget.Toast
            com.bxkj.base.BaseApp r1 = com.bxkj.base.BaseApp.c()
            r0.<init>(r1)
            r1 = 17
            r2 = 0
            r0.setGravity(r1, r2, r2)
            int r1 = com.bxkj.base.R.layout.toast_ok
            r2 = 0
            android.view.View r1 = android.view.View.inflate(r4, r1, r2)
            r0.setView(r1)
            if (r1 == 0) goto L2e
            int r3 = com.bxkj.base.R.id.tv_msg
            android.view.View r1 = r1.findViewById(r3)
            android.widget.TextView r1 = (android.widget.TextView) r1
            goto L2f
        L2e:
            r1 = r2
        L2f:
            if (r1 == 0) goto L34
            r1.setText(r5)
        L34:
            r0.setDuration(r6)
            boolean r5 = r4 instanceof android.app.Activity
            if (r5 == 0) goto L4b
            r5 = r4
            android.app.Activity r5 = (android.app.Activity) r5
            boolean r6 = r5.isFinishing()
            if (r6 != 0) goto L4b
            boolean r5 = r5.isDestroyed()
            if (r5 != 0) goto L4b
            goto L4c
        L4b:
            r4 = r2
        L4c:
            if (r4 == 0) goto L51
            r0.show()
        L51:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.v2.common.ext.ContextExtKt.r(android.content.Context, java.lang.CharSequence, int):android.widget.Toast");
    }

    public static /* synthetic */ Toast s(Context context, CharSequence charSequence, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 1;
        }
        return r(context, charSequence, i6);
    }

    public static final void t(@NotNull Context context, @NotNull CharSequence message) {
        g0.p(context, "<this>");
        g0.p(message, "message");
        Toast toast = f16745a;
        Toast toast2 = null;
        if (toast == null) {
            toast = Toast.makeText(BaseApp.c(), message, 0);
            toast.setGravity(17, 0, 0);
            if ((context instanceof ComponentActivity ? toast : null) != null) {
                ((ComponentActivity) context).getLifecycle().addObserver(new LifecycleObserver() { // from class: com.bxkj.base.v2.common.ext.ContextExtKt$showToast$1$2$1
                    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
                    public final void onStop() {
                        Toast toast3;
                        toast3 = ContextExtKt.f16745a;
                        if (toast3 != null) {
                            toast3.cancel();
                        }
                        ContextExtKt.f16745a = null;
                    }
                });
            }
        }
        f16745a = toast;
        toast.setText(message);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                toast2 = toast;
            }
        }
        if (toast2 != null) {
            toast2.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 function1, iOSTwoButtonDialog iostwobuttondialog) {
        function1.invoke(iostwobuttondialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 function1, iOSOneButtonDialog iosonebuttondialog, View view) {
        function1.invoke(iosonebuttondialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 function1, iOSOneButtonDialog iosonebuttondialog, View view) {
        function1.invoke(iosonebuttondialog);
    }
}
