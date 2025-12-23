package com.umeng.socialize.media;

import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface UMediaObject {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.socialize.media.UMediaObject$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum MediaType {
        IMAGE { // from class: com.umeng.socialize.media.UMediaObject.MediaType.1
            @Override // java.lang.Enum
            public String toString() {
                return "0";
            }
        },
        VEDIO { // from class: com.umeng.socialize.media.UMediaObject.MediaType.2
            @Override // java.lang.Enum
            public String toString() {
                return "1";
            }
        },
        MUSIC { // from class: com.umeng.socialize.media.UMediaObject.MediaType.3
            @Override // java.lang.Enum
            public String toString() {
                return "2";
            }
        },
        TEXT { // from class: com.umeng.socialize.media.UMediaObject.MediaType.4
            @Override // java.lang.Enum
            public String toString() {
                return "3";
            }
        },
        TEXT_IMAGE { // from class: com.umeng.socialize.media.UMediaObject.MediaType.5
            @Override // java.lang.Enum
            public String toString() {
                return "4";
            }
        },
        WEBPAGE { // from class: com.umeng.socialize.media.UMediaObject.MediaType.6
            @Override // java.lang.Enum
            public String toString() {
                return "5";
            }
        };

        /* synthetic */ MediaType(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    MediaType getMediaType();

    boolean isUrlMedia();

    byte[] toByte();

    String toUrl();

    Map<String, Object> toUrlExtraParams();
}
