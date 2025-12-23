package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class q3 extends r3 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private OfflineMapManager f6970a;

    /* renamed from: b, reason: collision with root package name */
    private View f6971b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f6972c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f6973d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f6974e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f6975f;

    /* renamed from: g, reason: collision with root package name */
    private int f6976g;

    /* renamed from: h, reason: collision with root package name */
    private String f6977h;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            q3.this.dismiss();
        }
    }

    public final void c(int i6, String str) {
        this.f6972c.setText(str);
        if (i6 == 0) {
            this.f6973d.setText("暂停下载");
            this.f6973d.setVisibility(0);
            this.f6974e.setText("取消下载");
        }
        if (i6 == 2) {
            this.f6973d.setVisibility(8);
            this.f6974e.setText("取消下载");
        } else if (i6 == -1 || i6 == 101 || i6 == 102 || i6 == 103) {
            this.f6973d.setText("继续下载");
            this.f6973d.setVisibility(0);
        } else if (i6 == 3) {
            this.f6973d.setVisibility(0);
            this.f6973d.setText("继续下载");
            this.f6974e.setText("取消下载");
        } else if (i6 == 4) {
            this.f6974e.setText("删除");
            this.f6973d.setVisibility(8);
        }
        this.f6976g = i6;
        this.f6977h = str;
    }

    public q3(Context context, OfflineMapManager offlineMapManager) {
        super(context);
        this.f6970a = offlineMapManager;
    }

    @Override // com.amap.api.col.p0003l.r3
    protected final void a() {
        View d6 = x3.d(getContext(), 2130903041);
        this.f6971b = d6;
        setContentView(d6);
        this.f6971b.setOnClickListener(new a());
        this.f6972c = (TextView) this.f6971b.findViewById(2131165191);
        TextView textView = (TextView) this.f6971b.findViewById(2131165192);
        this.f6973d = textView;
        textView.setText("暂停下载");
        this.f6974e = (TextView) this.f6971b.findViewById(2131165193);
        this.f6975f = (TextView) this.f6971b.findViewById(2131165194);
        this.f6973d.setOnClickListener(this);
        this.f6974e.setOnClickListener(this);
        this.f6975f.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            int id = view.getId();
            if (id == 2131165192) {
                int i6 = this.f6976g;
                if (i6 == 0) {
                    this.f6973d.setText("继续下载");
                    this.f6970a.pauseByName(this.f6977h);
                } else if (i6 == 3 || i6 == -1 || i6 == 101 || i6 == 102 || i6 == 103) {
                    this.f6973d.setText("暂停下载");
                    this.f6970a.downloadByCityName(this.f6977h);
                }
                dismiss();
                return;
            }
            if (id == 2131165193) {
                if (!TextUtils.isEmpty(this.f6977h)) {
                    this.f6970a.remove(this.f6977h);
                    dismiss();
                    return;
                }
                return;
            }
            if (id == 2131165194) {
                dismiss();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }
}
