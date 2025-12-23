package com.beizi.fusion.tool;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.beizi.ad.internal.view.a.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private TextView f13724a;

    /* renamed from: b, reason: collision with root package name */
    private a f13725b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(String str);
    }

    public void a(Context context, ViewGroup viewGroup, String str) {
        try {
            a(context, str);
            TextView textView = this.f13724a;
            if (textView != null) {
                viewGroup.addView(textView);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void a(Context context, String str) {
        try {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            this.f13724a = textView;
            textView.setText("投诉");
            this.f13724a.setTextColor(Color.parseColor("#FFFFFF"));
            am.a(this.f13724a, "#99000000", 0, "", 30);
            if ("1".equals(str)) {
                this.f13724a.setTextSize(2, 13.0f);
                this.f13724a.setPadding(ap.a(context, 12.0f), ap.a(context, 1.0f), ap.a(context, 12.0f), ap.a(context, 1.0f));
                layoutParams.leftMargin = 18;
                layoutParams.topMargin = 18;
            } else if ("2".equals(str)) {
                this.f13724a.setTextSize(2, 13.0f);
                this.f13724a.setPadding(ap.a(context, 12.0f), ap.a(context, 1.0f), ap.a(context, 12.0f), ap.a(context, 1.0f));
                layoutParams.leftMargin = ap.a(context, 16.0f);
                layoutParams.topMargin = ap.a(context, 16.0f);
            } else if ("3".equals(str)) {
                this.f13724a.setTextSize(2, 10.0f);
                this.f13724a.setPadding(ap.a(context, 11.0f), ap.a(context, 1.0f), ap.a(context, 11.0f), ap.a(context, 1.0f));
                layoutParams.leftMargin = 16;
                layoutParams.topMargin = 16;
            }
            this.f13724a.setLayoutParams(layoutParams);
            a();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void a() {
        try {
            this.f13724a.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.tool.l.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        Context context = l.this.f13724a.getContext();
                        View rootView = l.this.f13724a.getRootView();
                        if (rootView != null) {
                            context = rootView.getContext();
                        }
                        a.C0116a c0116a = new a.C0116a(context);
                        c0116a.a(new a.b() { // from class: com.beizi.fusion.tool.l.1.1
                            @Override // com.beizi.ad.internal.view.a.a.b
                            public void a() {
                            }

                            @Override // com.beizi.ad.internal.view.a.a.b
                            public void a(String str) {
                                if (l.this.f13725b != null) {
                                    l.this.f13725b.a(str);
                                }
                            }
                        });
                        c0116a.a().show();
                    } catch (Exception e6) {
                        aa.c("BeiZis", "e ：" + e6);
                    }
                }
            });
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void a(a aVar) {
        this.f13725b = aVar;
    }
}
