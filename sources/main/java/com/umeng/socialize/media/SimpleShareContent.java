package com.umeng.socialize.media;

import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.work.Data;
import com.baidu.mobads.sdk.internal.a;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.interfaces.CompressListener;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.DefaultClass;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.File;
import master.flame.danmaku.danmaku.parser.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SimpleShareContent {

    /* renamed from: a, reason: collision with root package name */
    private UMImage f42360a;

    /* renamed from: b, reason: collision with root package name */
    private UMImage[] f42361b;

    /* renamed from: c, reason: collision with root package name */
    private String f42362c;

    /* renamed from: d, reason: collision with root package name */
    private UMVideo f42363d;

    /* renamed from: e, reason: collision with root package name */
    private UMVideo[] f42364e;

    /* renamed from: f, reason: collision with root package name */
    private UMEmoji f42365f;

    /* renamed from: g, reason: collision with root package name */
    private UMusic f42366g;

    /* renamed from: h, reason: collision with root package name */
    private UMMin f42367h;

    /* renamed from: i, reason: collision with root package name */
    private UMQQMini f42368i;

    /* renamed from: j, reason: collision with root package name */
    private UMWeb f42369j;

    /* renamed from: k, reason: collision with root package name */
    private File f42370k;

    /* renamed from: l, reason: collision with root package name */
    private BaseMediaObject f42371l;

    /* renamed from: m, reason: collision with root package name */
    private int f42372m;

    /* renamed from: n, reason: collision with root package name */
    private String f42373n;

    /* renamed from: o, reason: collision with root package name */
    private String f42374o;

    /* renamed from: p, reason: collision with root package name */
    private CompressListener f42375p;
    public int THUMB_LIMIT = 24576;
    public int WX_THUMB_LIMIT = 18432;
    public int WX_MIN_LIMIT = 131072;
    public final int IMAGE_LIMIT = 491520;
    public final String DEFAULT_TITLE = "这里是标题";
    public final String DEFAULT_DESCRIPTION = "这里是描述";

    public String objectSetText(String str, int i6) {
        return TextUtils.isEmpty(str) ? "这里是描述" : str.length() > i6 ? str.substring(0, i6) : str;
    }

    private String a() {
        int i6 = this.f42372m;
        return i6 != 1 ? i6 != 2 ? i6 != 3 ? i6 != 4 ? i6 != 8 ? i6 != 16 ? i6 != 32 ? i6 != 64 ? i6 != 128 ? i6 != 256 ? "error" : "qqMini" : "minapp" : "emoji" : b.f50156c : "web" : "video" : "music" : "textandimage" : SocializeProtocolConstants.IMAGE : a.f10501b;
    }

    public String getAssertSubject() {
        return TextUtils.isEmpty(this.f42374o) ? "umengshare" : this.f42374o;
    }

    public BaseMediaObject getBaseMediaObject() {
        return this.f42371l;
    }

    public File getFile() {
        return this.f42370k;
    }

    public UMImage getImage() {
        return this.f42360a;
    }

    public UMusic getMusic() {
        return this.f42366g;
    }

    public UMQQMini getQQMini() {
        return this.f42368i;
    }

    public String getStrStyle() {
        return this.f42373n;
    }

    public String getSubject() {
        return this.f42374o;
    }

    public String getText() {
        return this.f42362c;
    }

    public UMEmoji getUmEmoji() {
        return this.f42365f;
    }

    public UMMin getUmMin() {
        return this.f42367h;
    }

    public UMVideo[] getUmVideos() {
        return this.f42364e;
    }

    public UMWeb getUmWeb() {
        return this.f42369j;
    }

    public UMVideo getVideo() {
        return this.f42363d;
    }

    public UMImage[] getmImages() {
        return this.f42361b;
    }

    public int getmStyle() {
        return this.f42372m;
    }

    public void setCompressListener(CompressListener compressListener) {
        this.f42375p = compressListener;
    }

    public void setImage(UMImage uMImage) {
        this.f42360a = uMImage;
    }

    public void setMusic(UMusic uMusic) {
        this.f42366g = uMusic;
    }

    public void setText(String str) {
        this.f42362c = str;
    }

    public void setVideo(UMVideo uMVideo) {
        this.f42363d = uMVideo;
    }

    public SimpleShareContent(ShareContent shareContent) {
        UMVideo[] uMVideoArr;
        this.f42362c = shareContent.mText;
        UMediaObject uMediaObject = shareContent.mMedia;
        if (uMediaObject != null && (uMediaObject instanceof UMImage) && (uMVideoArr = shareContent.Video_mMedias) != null) {
            UMImage uMImage = (UMImage) uMediaObject;
            this.f42360a = uMImage;
            this.f42371l = uMImage;
            UMImage[] uMImageArr = shareContent.mMedias;
            if (uMImageArr != null && uMImageArr.length > 0) {
                this.f42361b = uMImageArr;
            }
            this.f42371l = this.f42363d;
            if (uMVideoArr != null && uMVideoArr.length > 0) {
                this.f42364e = uMVideoArr;
            }
        } else {
            if (uMediaObject != null && (uMediaObject instanceof UMImage)) {
                UMImage uMImage2 = (UMImage) uMediaObject;
                this.f42360a = uMImage2;
                this.f42371l = uMImage2;
                UMImage[] uMImageArr2 = shareContent.mMedias;
                if (uMImageArr2 != null && uMImageArr2.length > 0) {
                    this.f42361b = uMImageArr2;
                }
            }
            if (uMediaObject != null && (uMediaObject instanceof UMusic)) {
                UMusic uMusic = (UMusic) uMediaObject;
                this.f42366g = uMusic;
                this.f42371l = uMusic;
            }
            if (uMediaObject != null && (uMediaObject instanceof UMVideo)) {
                UMVideo uMVideo = (UMVideo) uMediaObject;
                this.f42363d = uMVideo;
                this.f42371l = uMVideo;
                UMVideo[] uMVideoArr2 = shareContent.Video_mMedias;
                if (uMVideoArr2 != null && uMVideoArr2.length > 0) {
                    this.f42364e = uMVideoArr2;
                }
            }
            if (uMediaObject != null && (uMediaObject instanceof UMEmoji)) {
                UMEmoji uMEmoji = (UMEmoji) uMediaObject;
                this.f42365f = uMEmoji;
                this.f42371l = uMEmoji;
            }
            if (uMediaObject != null && (uMediaObject instanceof UMWeb)) {
                UMWeb uMWeb = (UMWeb) uMediaObject;
                this.f42369j = uMWeb;
                this.f42371l = uMWeb;
            }
            if (uMediaObject != null && (uMediaObject instanceof UMMin)) {
                this.f42367h = (UMMin) uMediaObject;
                this.f42371l = this.f42369j;
            }
            if (uMediaObject != null && (uMediaObject instanceof UMQQMini)) {
                this.f42368i = (UMQQMini) uMediaObject;
                this.f42371l = this.f42369j;
            }
            File file = shareContent.file;
            if (file != null) {
                this.f42370k = file;
            }
        }
        this.f42374o = shareContent.subject;
        this.f42372m = shareContent.getShareType();
        this.f42373n = a();
    }

    private byte[] b() {
        byte[] bytes = DefaultClass.getBytes();
        if (ContextUtil.getIcon() != 0) {
            bytes = com.umeng.socialize.c.a.a.a(new UMImage(ContextUtil.getContext(), ContextUtil.getIcon()), this.WX_THUMB_LIMIT);
            if (bytes != null && bytes.length > 0) {
                return bytes;
            }
            SLog.E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
        }
        return bytes;
    }

    public boolean canFileValid(UMImage uMImage) {
        if (uMImage.asFileImage() != null) {
            return true;
        }
        return false;
    }

    public byte[] getImageData(UMImage uMImage) {
        return uMImage.asBinImage();
    }

    public byte[] getImageThumb(UMImage uMImage) {
        if (uMImage.getThumbImage() != null) {
            byte[] a6 = com.umeng.socialize.c.a.a.a(uMImage.getThumbImage(), this.WX_THUMB_LIMIT);
            if (a6 != null && a6.length > 0) {
                return a6;
            }
            SLog.E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
            return b();
        }
        return b();
    }

    public String getMusicTargetUrl(UMusic uMusic) {
        if (TextUtils.isEmpty(uMusic.getmTargetUrl())) {
            return uMusic.toUrl();
        }
        return uMusic.getmTargetUrl();
    }

    public byte[] getStrictImageData(UMImage uMImage) {
        if (getUMImageScale(uMImage) > 491520) {
            byte[] a6 = com.umeng.socialize.c.a.a.a(getImage(), 491520);
            if (a6 != null && a6.length > 0) {
                return a6;
            }
            SLog.E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
            return null;
        }
        return getImageData(uMImage);
    }

    public int getUMImageScale(UMImage uMImage) {
        return com.umeng.socialize.c.a.a.a(uMImage);
    }

    public String objectSetDescription(BaseMediaObject baseMediaObject) {
        if (TextUtils.isEmpty(baseMediaObject.getDescription())) {
            return "这里是描述";
        }
        String description = baseMediaObject.getDescription();
        if (description.length() > 1024) {
            return description.substring(0, 1024);
        }
        return description;
    }

    public byte[] objectSetMInAppThumb(BaseMediaObject baseMediaObject) {
        if (baseMediaObject.getThumbImage() != null) {
            if (this.f42375p != null) {
                UMImage thumbImage = baseMediaObject.getThumbImage();
                if (thumbImage == null) {
                    return DefaultClass.getBytes();
                }
                byte[] asBinImage = thumbImage.asBinImage();
                if (asBinImage != null && com.umeng.socialize.c.a.a.a(thumbImage) <= this.WX_MIN_LIMIT) {
                    return asBinImage;
                }
                return this.f42375p.compressThumb(asBinImage);
            }
            byte[] a6 = com.umeng.socialize.c.a.a.a(baseMediaObject.getThumbImage().asBinImage(), this.WX_MIN_LIMIT, Bitmap.CompressFormat.JPEG);
            if (a6 != null && a6.length > 0) {
                return a6;
            }
            SLog.E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
            return a6;
        }
        return DefaultClass.getBytes();
    }

    public byte[] objectSetThumb(BaseMediaObject baseMediaObject) {
        if (baseMediaObject.getThumbImage() != null) {
            if (this.f42375p != null) {
                UMImage thumbImage = baseMediaObject.getThumbImage();
                if (thumbImage == null) {
                    return DefaultClass.getBytes();
                }
                byte[] asBinImage = thumbImage.asBinImage();
                if (asBinImage != null && com.umeng.socialize.c.a.a.a(thumbImage) <= this.THUMB_LIMIT) {
                    return asBinImage;
                }
                return this.f42375p.compressThumb(asBinImage);
            }
            byte[] a6 = com.umeng.socialize.c.a.a.a(baseMediaObject.getThumbImage(), this.THUMB_LIMIT);
            if (a6 != null && a6.length > 0) {
                return a6;
            }
            SLog.E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
            return b();
        }
        return b();
    }

    public String objectSetTitle(BaseMediaObject baseMediaObject) {
        if (TextUtils.isEmpty(baseMediaObject.getTitle())) {
            return "这里是标题";
        }
        String title = baseMediaObject.getTitle();
        if (title.length() > 512) {
            return title.substring(0, 512);
        }
        return title;
    }

    public String subString(String str, int i6) {
        if (TextUtils.isEmpty(str) && str.length() > i6) {
            return str.substring(0, i6);
        }
        return str;
    }

    public String objectSetText(String str) {
        return objectSetText(str, Data.MAX_DATA_BYTES);
    }
}
