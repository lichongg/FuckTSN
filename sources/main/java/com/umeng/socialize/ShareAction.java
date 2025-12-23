package com.umeng.socialize;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMEmoji;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMMin;
import com.umeng.socialize.media.UMQQMini;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.shareboard.ShareBoard;
import com.umeng.socialize.shareboard.ShareBoardConfig;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.CommonUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.ShareBoardlistener;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ShareAction {

    /* renamed from: b, reason: collision with root package name */
    private SHARE_MEDIA f42158b;

    /* renamed from: c, reason: collision with root package name */
    private UMShareListener f42159c;

    /* renamed from: d, reason: collision with root package name */
    private ShareBoardlistener f42160d;

    /* renamed from: e, reason: collision with root package name */
    private Activity f42161e;

    /* renamed from: f, reason: collision with root package name */
    private List<SHARE_MEDIA> f42162f;

    /* renamed from: k, reason: collision with root package name */
    private View f42167k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f42168l;

    /* renamed from: m, reason: collision with root package name */
    private ShareBoard f42169m;

    /* renamed from: a, reason: collision with root package name */
    private ShareContent f42157a = new ShareContent();

    /* renamed from: g, reason: collision with root package name */
    private final List<SnsPlatform> f42163g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private List<ShareContent> f42164h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private List<UMShareListener> f42165i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    private int f42166j = 80;

    /* renamed from: n, reason: collision with root package name */
    private ShareBoardlistener f42170n = new ShareBoardlistener() { // from class: com.umeng.socialize.ShareAction.1
        @Override // com.umeng.socialize.utils.ShareBoardlistener
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            ShareAction.this.setPlatform(share_media);
            ShareAction.this.share();
        }
    };

    /* renamed from: o, reason: collision with root package name */
    private ShareBoardlistener f42171o = new ShareBoardlistener() { // from class: com.umeng.socialize.ShareAction.2
        @Override // com.umeng.socialize.utils.ShareBoardlistener
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            int indexOf = ShareAction.this.f42162f.indexOf(share_media);
            int size = ShareAction.this.f42164h.size();
            if (size != 0) {
                ShareAction.this.f42157a = indexOf < size ? (ShareContent) ShareAction.this.f42164h.get(indexOf) : (ShareContent) ShareAction.this.f42164h.get(size - 1);
            }
            int size2 = ShareAction.this.f42165i.size();
            if (size2 != 0) {
                if (indexOf < size2) {
                    ShareAction shareAction = ShareAction.this;
                    shareAction.f42159c = (UMShareListener) shareAction.f42165i.get(indexOf);
                } else {
                    ShareAction shareAction2 = ShareAction.this;
                    shareAction2.f42159c = (UMShareListener) shareAction2.f42165i.get(size2 - 1);
                }
            }
            ShareAction.this.setPlatform(share_media);
            ShareAction.this.share();
        }
    };

    public static Rect locateView(View view) {
        int[] iArr = new int[2];
        if (view == null) {
            return null;
        }
        try {
            view.getLocationOnScreen(iArr);
            Rect rect = new Rect();
            int i6 = iArr[0];
            rect.left = i6;
            rect.top = iArr[1];
            rect.right = i6 + view.getWidth();
            rect.bottom = rect.top + view.getHeight();
            return rect;
        } catch (NullPointerException e6) {
            SLog.error(e6);
            return null;
        }
    }

    public ShareAction bySystem() {
        this.f42168l = true;
        return this;
    }

    public void open(ShareBoardConfig shareBoardConfig) {
        if (CommonUtil.isSilentMode(this.f42161e)) {
            return;
        }
        if (this.f42163g.size() != 0) {
            HashMap hashMap = new HashMap();
            hashMap.put(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, this.f42159c);
            hashMap.put("content", this.f42157a);
            try {
                ShareBoard shareBoard = new ShareBoard(this.f42161e, this.f42163g, shareBoardConfig);
                this.f42169m = shareBoard;
                ShareBoardlistener shareBoardlistener = this.f42160d;
                if (shareBoardlistener == null) {
                    shareBoard.setShareBoardlistener(this.f42171o);
                } else {
                    shareBoard.setShareBoardlistener(shareBoardlistener);
                }
                this.f42169m.setFocusable(true);
                this.f42169m.setBackgroundDrawable(new BitmapDrawable());
                if (this.f42167k == null) {
                    this.f42167k = this.f42161e.getWindow().getDecorView();
                }
                this.f42169m.showAtLocation(this.f42167k, this.f42166j, 0, 0);
                return;
            } catch (Exception e6) {
                SLog.error(e6);
                return;
            }
        }
        this.f42163g.add(SHARE_MEDIA.WEIXIN.toSnsPlatform());
        this.f42163g.add(SHARE_MEDIA.WEIXIN_CIRCLE.toSnsPlatform());
        this.f42163g.add(SHARE_MEDIA.SINA.toSnsPlatform());
        this.f42163g.add(SHARE_MEDIA.QQ.toSnsPlatform());
        this.f42163g.add(SHARE_MEDIA.DINGTALK.toSnsPlatform());
        HashMap hashMap2 = new HashMap();
        hashMap2.put(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, this.f42159c);
        hashMap2.put("content", this.f42157a);
        ShareBoard shareBoard2 = new ShareBoard(this.f42161e, this.f42163g, shareBoardConfig);
        this.f42169m = shareBoard2;
        ShareBoardlistener shareBoardlistener2 = this.f42160d;
        if (shareBoardlistener2 == null) {
            shareBoard2.setShareBoardlistener(this.f42170n);
        } else {
            shareBoard2.setShareBoardlistener(shareBoardlistener2);
        }
        this.f42169m.setFocusable(true);
        this.f42169m.setBackgroundDrawable(new BitmapDrawable());
        if (this.f42167k == null) {
            this.f42167k = this.f42161e.getWindow().getDecorView();
        }
        this.f42169m.showAtLocation(this.f42167k, 80, 0, 0);
    }

    public ShareAction withMedia(UMImage uMImage) {
        this.f42157a.mMedia = uMImage;
        return this;
    }

    public ShareAction withMedias(UMImage... uMImageArr) {
        if (uMImageArr != null && uMImageArr.length > 0) {
            this.f42157a.mMedia = uMImageArr[0];
        }
        this.f42157a.mMedias = uMImageArr;
        return this;
    }

    public ShareAction addButton(String str, String str2, String str3, String str4) {
        this.f42163g.add(SHARE_MEDIA.createSnsPlatform(str, str2, str3, str4, 0));
        return this;
    }

    public void close() {
        ShareBoard shareBoard = this.f42169m;
        if (shareBoard != null) {
            shareBoard.dismiss();
            this.f42169m = null;
        }
    }

    public SHARE_MEDIA getPlatform() {
        return this.f42158b;
    }

    public ShareContent getShareContent() {
        return this.f42157a;
    }

    public boolean getUrlValid() {
        UMediaObject uMediaObject;
        ShareContent shareContent = this.f42157a;
        return shareContent == null || (uMediaObject = shareContent.mMedia) == null || !(uMediaObject instanceof UMWeb) || uMediaObject.toUrl() == null || this.f42157a.mMedia.toUrl().startsWith(master.flame.danmaku.danmaku.parser.b.f50154a);
    }

    public ShareAction setCallback(UMShareListener uMShareListener) {
        this.f42159c = uMShareListener;
        return this;
    }

    @Deprecated
    public ShareAction setContentList(ShareContent... shareContentArr) {
        if (shareContentArr != null && Arrays.asList(shareContentArr).size() != 0) {
            this.f42164h = Arrays.asList(shareContentArr);
            return this;
        }
        ShareContent shareContent = new ShareContent();
        shareContent.mText = "empty";
        this.f42164h.add(shareContent);
        return this;
    }

    public ShareAction setPlatform(SHARE_MEDIA share_media) {
        this.f42158b = share_media;
        return this;
    }

    public ShareAction setShareContent(ShareContent shareContent) {
        this.f42157a = shareContent;
        return this;
    }

    public ShareAction setShareboardclickCallback(ShareBoardlistener shareBoardlistener) {
        this.f42160d = shareBoardlistener;
        return this;
    }

    public void share() {
        UMShareAPI uMShareAPI = UMShareAPI.get(this.f42161e);
        if (uMShareAPI != null) {
            ShareContent shareContent = getShareContent();
            if (shareContent != null) {
                shareContent.bySystem = this.f42168l;
            }
            uMShareAPI.doShare(this.f42161e, this, this.f42159c);
        }
    }

    public ShareAction withApp(File file) {
        this.f42157a.app = file;
        return this;
    }

    public ShareAction withExtra(UMImage uMImage) {
        this.f42157a.mExtra = uMImage;
        return this;
    }

    public ShareAction withFile(File file) {
        this.f42157a.file = file;
        return this;
    }

    public ShareAction withFollow(String str) {
        this.f42157a.mFollow = str;
        return this;
    }

    public ShareAction withMedia(UMMin uMMin) {
        this.f42157a.mMedia = uMMin;
        return this;
    }

    public ShareAction withShareBoardDirection(View view, int i6) {
        this.f42166j = i6;
        this.f42167k = view;
        return this;
    }

    public ShareAction withSubject(String str) {
        this.f42157a.subject = str;
        return this;
    }

    public ShareAction withText(String str) {
        this.f42157a.mText = str;
        return this;
    }

    public ShareAction(Activity activity) {
        if (activity != null) {
            this.f42161e = (Activity) new WeakReference(activity).get();
        }
    }

    public ShareAction setDisplayList(SHARE_MEDIA... share_mediaArr) {
        this.f42162f = Arrays.asList(share_mediaArr);
        this.f42163g.clear();
        Iterator<SHARE_MEDIA> it = this.f42162f.iterator();
        while (it.hasNext()) {
            this.f42163g.add(it.next().toSnsPlatform());
        }
        return this;
    }

    @Deprecated
    public ShareAction setListenerList(UMShareListener... uMShareListenerArr) {
        this.f42165i = Arrays.asList(uMShareListenerArr);
        return this;
    }

    public ShareAction withMedia(UMQQMini uMQQMini) {
        this.f42157a.mMedia = uMQQMini;
        return this;
    }

    public ShareAction withMedia(UMEmoji uMEmoji) {
        this.f42157a.mMedia = uMEmoji;
        return this;
    }

    public ShareAction withMedias(UMVideo... uMVideoArr) {
        if (uMVideoArr != null && uMVideoArr.length > 0) {
            this.f42157a.mMedia = uMVideoArr[0];
        }
        this.f42157a.Video_mMedias = uMVideoArr;
        return this;
    }

    public ShareAction withMedia(UMWeb uMWeb) {
        this.f42157a.mMedia = uMWeb;
        return this;
    }

    public ShareAction withMedia(UMusic uMusic) {
        this.f42157a.mMedia = uMusic;
        return this;
    }

    public ShareAction withMedia(UMVideo uMVideo) {
        this.f42157a.mMedia = uMVideo;
        return this;
    }

    public void open() {
        open(null);
    }
}
