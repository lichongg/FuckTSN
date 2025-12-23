package com.bxkj.student.home.physicaltest.calc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.SeralizableMap;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class CalcResultActivity extends BaseActivity {
    private RecyclerView W;
    private LinearLayout X;
    private LinearLayout Y;
    private LinearLayout Z;

    /* renamed from: a0, reason: collision with root package name */
    private LinearLayout f17945a0;

    /* renamed from: b0, reason: collision with root package name */
    private List<Map<String, Object>> f17946b0 = new ArrayList();

    /* renamed from: c0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f17947c0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131298986, JsonParse.getString(stringObjectMap, CommonNetImpl.NAME));
            holder.J(2131299181, JsonParse.getString(stringObjectMap, "result"));
            holder.J(R.id.tv_scor, JsonParse.getString(stringObjectMap, "standard"));
            holder.J(R.id.tv_ss, JsonParse.getString(stringObjectMap, "score"));
            holder.J(R.id.tv_level, JsonParse.getString(stringObjectMap, "level"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements UMShareListener {
        b() {
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(((BaseActivity) CalcResultActivity.this).T, " 分享取消了", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(((BaseActivity) CalcResultActivity.this).T, " 分享成功啦", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onError(SHARE_MEDIA platform, Throwable t5) {
            t5.printStackTrace();
            Toast.makeText(((BaseActivity) CalcResultActivity.this).T, " 分享失败啦", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onStart(SHARE_MEDIA share_media) {
        }
    }

    private Bitmap l0(Bitmap src, Bitmap watermark) {
        if (src == null) {
            return null;
        }
        int width = src.getWidth();
        int height = src.getHeight();
        int width2 = watermark.getWidth();
        Bitmap createBitmap = Bitmap.createBitmap(width, height + width2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawRGB(255, 255, 255);
        canvas.drawBitmap(src, 0.0f, 0.0f, (Paint) null);
        int i6 = width - width2;
        canvas.drawBitmap(watermark, i6, height, (Paint) null);
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), com.bxkj.competition.R.mipmap.makepic), ((width / 5) * 2) - (r11.getWidth() / 2), height - r11.getHeight(), (Paint) null);
        Paint paint = new Paint(1);
        paint.setColor(SupportMenu.CATEGORY_MASK);
        paint.setTextSize(u.a(20.0f, this.T));
        Rect rect = new Rect();
        paint.getTextBounds("扫描右侧二维码", 0, 7, rect);
        float width3 = ((i6 / 2) + 10) - (rect.width() / 2);
        int i7 = height + MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED;
        canvas.drawText("扫描右侧二维码", width3, (i7 - (rect.height() / 2)) - rect.height(), paint);
        paint.getTextBounds("下载体测成绩计算器", 0, 9, new Rect());
        canvas.drawText("下载体测成绩计算器", r10 - (r1.width() / 2), (i7 - (r1.height() / 2)) + rect.height() + 10, paint);
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    public Bitmap k0(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        return view.getDrawingCache();
    }

    private void m0(SHARE_MEDIA platform) {
        new ShareAction(this).setPlatform(platform).setCallback(new b()).withMedia(new UMImage(this.T, l0(k0(this.W), BitmapFactory.decodeResource(getResources(), 2131690127)))).share();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.X.setOnClickListener(this);
        this.Y.setOnClickListener(this);
        this.Z.setOnClickListener(this);
        this.f17945a0.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("体测成绩");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_calc_result;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra(CommonNetImpl.SM)) {
            this.f17946b0 = JsonParse.getList(((SeralizableMap) getIntent().getSerializableExtra(CommonNetImpl.SM)).getMap(), "data");
        }
        HashMap hashMap = new HashMap(5);
        hashMap.put(CommonNetImpl.NAME, "项目");
        hashMap.put("result", "成绩");
        hashMap.put("standard", "分数");
        hashMap.put("score", "比例分");
        hashMap.put("level", "等级");
        this.f17946b0.add(0, hashMap);
        this.W.setLayoutManager(new LinearLayoutManager(this.T));
        a aVar = new a(this.T, R.layout.item_for_calc_reslut, this.f17946b0);
        this.f17947c0 = aVar;
        this.W.setAdapter(aVar);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (RecyclerView) findViewById(2131298421);
        this.X = (LinearLayout) findViewById(2131298085);
        this.Y = (LinearLayout) findViewById(2131298053);
        this.Z = (LinearLayout) findViewById(2131298063);
        this.f17945a0 = (LinearLayout) findViewById(2131298066);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        switch (v5.getId()) {
            case 2131298053:
                m0(SHARE_MEDIA.WEIXIN_CIRCLE);
                break;
            case 2131298063:
                m0(SHARE_MEDIA.QQ);
                break;
            case 2131298066:
                m0(SHARE_MEDIA.QZONE);
                break;
            case 2131298085:
                m0(SHARE_MEDIA.WEIXIN);
                break;
        }
    }
}
