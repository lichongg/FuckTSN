package com.bykv.vk.component.ttvideo.player;

import java.util.ArrayList;
import java.util.List;

@JNINamespace("PLAYER")
/* loaded from: D:\Downloads\app\classes3.dex */
public class SidxListObject extends NativeObject {
    private long mBitrate;
    private int mEndIndex;
    private String mFileId;
    private List<SidxItem> mItems = new ArrayList();
    private int mMediaType;
    private int mStartIndex;
    private int mTotalNum;

    public static class SidxItem {
        private long mDuration;
        private int mIndex;
        private long mOffset;
        private long mSize;
        private long mTimestamp;

        public long getDuration() {
            return this.mDuration;
        }

        public int getIndex() {
            return this.mIndex;
        }

        public long getOffset() {
            return this.mOffset;
        }

        public long getSize() {
            return this.mSize;
        }

        public long getTimestamp() {
            return this.mTimestamp;
        }

        public SidxItem(int i6, long j6, long j7, long j8, long j9) {
            this.mIndex = i6;
            this.mOffset = j6;
            this.mTimestamp = j7;
            this.mDuration = j8;
            this.mSize = j9;
        }
    }

    @CalledByNative
    public void addItem(int i6, long j6, long j7, long j8, long j9) {
        this.mItems.add(new SidxItem(i6, j6, j7, j8, j9));
    }

    public long getBitrate() {
        return this.mBitrate;
    }

    public int getEndIndex() {
        return this.mEndIndex;
    }

    public String getFileId() {
        return this.mFileId;
    }

    public SidxItem getItem(int i6) {
        if (i6 < 0 || i6 >= this.mItems.size()) {
            return null;
        }
        return this.mItems.get(i6);
    }

    public int getMediaType() {
        return this.mMediaType;
    }

    public int getStartIndex() {
        return this.mStartIndex;
    }

    public int getTotalNum() {
        return this.mTotalNum;
    }

    @CalledByNative
    public SidxListObject(int i6, int i7, int i8, int i9, long j6, String str) {
        this.mMediaType = i6;
        this.mTotalNum = i7;
        this.mStartIndex = i8;
        this.mEndIndex = i9;
        this.mBitrate = j6;
        this.mFileId = str;
    }
}
