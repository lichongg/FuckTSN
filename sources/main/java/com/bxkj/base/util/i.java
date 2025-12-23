package com.bxkj.base.util;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import okhttp3.ResponseBody;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private Context f16621a;

    /* renamed from: b, reason: collision with root package name */
    private List<Map<String, Object>> f16622b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    final DateFormat f16623c = new SimpleDateFormat("yyyy-MM-dd");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f16624a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16625b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f16626c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f16627d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ c f16628e;

        a(TextView textView, String str, String str2, String str3, c cVar) {
            this.f16624a = textView;
            this.f16625b = str;
            this.f16626c = str2;
            this.f16627d = str3;
            this.f16628e = cVar;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            i.this.f16622b = (List) map.get("data");
            i iVar = i.this;
            iVar.h(this.f16624a, this.f16625b, iVar.f16622b, this.f16626c, this.f16627d, this.f16628e);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void a(String str);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c {
        void a(String str, String str2, Map<String, Object> map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(TextView textView, b bVar, DatePicker datePicker, int i6, int i7, int i8) {
        String str = i6 + "-" + (i7 + 1) + "-" + i8;
        try {
            DateFormat dateFormat = this.f16623c;
            str = dateFormat.format(dateFormat.parse(str));
        } catch (ParseException e6) {
            e6.printStackTrace();
        }
        textView.setText(str);
        if (bVar != null) {
            bVar.a(str);
        }
    }

    public void g(final TextView textView, final b bVar) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(new Date());
        new DatePickerDialog(this.f16621a, new DatePickerDialog.OnDateSetListener() { // from class: com.bxkj.base.util.h
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i6, int i7, int i8) {
                i.this.f(textView, bVar, datePicker, i6, i7, i8);
            }
        }, calendar.get(1), calendar.get(2), calendar.get(5)).show();
    }

    public i i(TextView textView, String str, rx.e<retrofit2.c0<ResponseBody>> eVar, c cVar) {
        j(textView, str, eVar, "id", CommonNetImpl.NAME, cVar);
        return this;
    }

    public i j(TextView textView, String str, rx.e<retrofit2.c0<ResponseBody>> eVar, String str2, String str3, c cVar) {
        List<Map<String, Object>> list = this.f16622b;
        if (list == null || list.size() <= 0) {
            Http.with(this.f16621a).setObservable(eVar).setDataListener(new a(textView, str, str2, str3, cVar));
            return this;
        }
        h(textView, str, this.f16622b, str2, str3, cVar);
        return this;
    }

    public i(Context context) {
        this.f16621a = context;
    }

    public static /* synthetic */ void a(List list, String str, TextView textView, String[] strArr, c cVar, DialogInterface dialogInterface, int i6) {
        Map<String, Object> map = (Map) list.get(i6);
        String string = JsonParse.getString(map, str);
        textView.setTag(string);
        String str2 = strArr[i6];
        textView.setText(str2);
        if (cVar != null) {
            cVar.a(string, str2, map);
        }
    }

    private void e(Dialog dialog, int i6) {
        View findViewById = dialog.findViewById(dialog.getContext().getResources().getIdentifier("android:id/titleDivider", null, null));
        if (findViewById != null) {
            findViewById.setBackgroundColor(i6);
        }
    }

    public i h(final TextView textView, String str, final List<Map<String, Object>> list, final String str2, String str3, final c cVar) {
        final String[] strArr = new String[list.size()];
        for (int i6 = 0; i6 < list.size(); i6++) {
            strArr[i6] = cn.bluemobi.dylan.base.utils.u.O(list.get(i6), str3);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f16621a);
        View inflate = LayoutInflater.from(this.f16621a).inflate(R.layout.dialog_title, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tvTitle)).setText(str);
        builder.setCustomTitle(inflate);
        builder.setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.bxkj.base.util.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i7) {
                i.a(list, str2, textView, strArr, cVar, dialogInterface, i7);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        e(create, Color.parseColor("#999999"));
        return this;
    }
}
