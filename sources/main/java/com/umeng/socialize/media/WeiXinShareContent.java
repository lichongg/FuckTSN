package com.umeng.socialize.media;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.umeng.socialize.Config;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.utils.SocializeUtils;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class WeiXinShareContent extends SimpleShareContent {
    private final boolean bySystem;

    private WXMediaMessage buildFileParams() {
        WXFileObject wXFileObject = new WXFileObject();
        wXFileObject.fileData = SocializeUtils.File2byte(getFile());
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXFileObject;
        wXMediaMessage.description = getText();
        wXMediaMessage.title = getSubject();
        return wXMediaMessage;
    }

    private WXMediaMessage buildTextParams() {
        WXTextObject wXTextObject = new WXTextObject();
        wXTextObject.text = objectSetText(getText());
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXTextObject;
        wXMediaMessage.description = objectSetText(getText(), 1024);
        return wXMediaMessage;
    }

    public String getFileUri(Context context, File file, String str) {
        if (file == null || !file.exists()) {
            return null;
        }
        Uri uriForFile = FileProvider.getUriForFile(context, str, file);
        context.grantUriPermission("com.tencent.mm", uriForFile, 1);
        return uriForFile.toString();
    }

    public boolean isBySystem() {
        return this.bySystem;
    }

    public WeiXinShareContent(ShareContent shareContent) {
        super(shareContent);
        this.bySystem = shareContent.bySystem;
    }

    private WXMediaMessage buildEmojiParams() {
        String str;
        UMEmoji umEmoji = getUmEmoji();
        if (umEmoji != null && umEmoji.asFileImage() != null) {
            str = umEmoji.asFileImage().toString();
        } else {
            str = "";
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = str;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = objectSetThumb(umEmoji);
        return wXMediaMessage;
    }

    private WXMediaMessage buildEmojiParamsWithFileProvider(Context context, String str) {
        String str2;
        UMEmoji umEmoji = getUmEmoji();
        if (umEmoji != null && umEmoji.asFileImage() != null) {
            str2 = getFileUri(context, new File(umEmoji.asFileImage().toString()), str);
        } else {
            str2 = "";
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = str2;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = objectSetThumb(umEmoji);
        return wXMediaMessage;
    }

    private WXMediaMessage buildImageParams() {
        UMImage image = getImage();
        WXImageObject wXImageObject = new WXImageObject();
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXImageObject.imageData = image.asBinImage();
        if (canFileValid(image)) {
            wXImageObject.imagePath = image.asFileImage().toString();
            wXImageObject.imageData = null;
        } else {
            wXImageObject.imageData = getStrictImageData(image);
        }
        wXMediaMessage.thumbData = getImageThumb(image);
        wXMediaMessage.mediaObject = wXImageObject;
        return wXMediaMessage;
    }

    private WXMediaMessage buildImageParamsWithFileProvider(Context context, String str) {
        UMImage image = getImage();
        WXImageObject wXImageObject = new WXImageObject();
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXImageObject.imageData = image.asBinImage();
        if (canFileValid(image)) {
            wXImageObject.imagePath = getFileUri(context, new File(image.asFileImage().toString()), str);
            wXImageObject.imageData = null;
        } else {
            wXImageObject.imageData = getStrictImageData(image);
        }
        wXMediaMessage.thumbData = getImageThumb(image);
        wXMediaMessage.mediaObject = wXImageObject;
        return wXMediaMessage;
    }

    private WXMediaMessage buildMinApp() {
        UMMin umMin = getUmMin();
        WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
        wXMiniProgramObject.webpageUrl = umMin.toUrl();
        wXMiniProgramObject.userName = umMin.getUserName();
        wXMiniProgramObject.path = umMin.getPath();
        wXMiniProgramObject.miniprogramType = Config.getMINITYPE();
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = objectSetTitle(umMin);
        wXMediaMessage.description = objectSetDescription(umMin);
        wXMediaMessage.thumbData = objectSetMInAppThumb(umMin);
        wXMediaMessage.mediaObject = wXMiniProgramObject;
        return wXMediaMessage;
    }

    private WXMediaMessage buildMusicParams() {
        UMusic music = getMusic();
        WXMusicObject wXMusicObject = new WXMusicObject();
        wXMusicObject.musicUrl = getMusicTargetUrl(music);
        wXMusicObject.musicDataUrl = music.toUrl();
        if (!TextUtils.isEmpty(music.getLowBandDataUrl())) {
            wXMusicObject.musicLowBandDataUrl = music.getLowBandDataUrl();
        }
        if (!TextUtils.isEmpty(music.getLowBandUrl())) {
            wXMusicObject.musicLowBandUrl = music.getLowBandUrl();
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXMusicObject;
        wXMediaMessage.title = objectSetTitle(music);
        wXMediaMessage.description = objectSetDescription(music);
        wXMediaMessage.mediaObject = wXMusicObject;
        wXMediaMessage.thumbData = objectSetThumb(music);
        return wXMediaMessage;
    }

    private WXMediaMessage buildUrlParams() {
        UMWeb umWeb = getUmWeb();
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = umWeb.toUrl();
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = objectSetTitle(umWeb);
        wXMediaMessage.description = objectSetDescription(umWeb);
        wXMediaMessage.mediaObject = wXWebpageObject;
        wXMediaMessage.thumbData = objectSetThumb(umWeb);
        return wXMediaMessage;
    }

    private WXMediaMessage buildVideoParams() {
        UMVideo video = getVideo();
        WXVideoObject wXVideoObject = new WXVideoObject();
        wXVideoObject.videoUrl = video.toUrl();
        if (!TextUtils.isEmpty(video.getLowBandUrl())) {
            wXVideoObject.videoLowBandUrl = video.getLowBandUrl();
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXVideoObject;
        wXMediaMessage.title = objectSetTitle(video);
        wXMediaMessage.description = objectSetDescription(video);
        wXMediaMessage.thumbData = objectSetThumb(video);
        return wXMediaMessage;
    }

    public WXMediaMessage getWxMediaMessage(Context context, boolean z5, String str) {
        if (getmStyle() != 2 && getmStyle() != 3) {
            if (getmStyle() == 4) {
                return buildMusicParams();
            }
            if (getmStyle() == 16) {
                return buildUrlParams();
            }
            if (getmStyle() == 8) {
                return buildVideoParams();
            }
            if (getmStyle() == 64) {
                if (z5) {
                    return buildEmojiParamsWithFileProvider(context, str);
                }
                return buildEmojiParams();
            }
            if (getmStyle() == 32) {
                return buildFileParams();
            }
            if (getmStyle() == 128) {
                return buildMinApp();
            }
            return buildTextParams();
        }
        if (z5) {
            return buildImageParamsWithFileProvider(context, str);
        }
        return buildImageParams();
    }
}
