package com.sinovoice.hcicloudsdk.common.kb;
/* loaded from: classes.dex */
public class KbSlideInfoItem {
    public static final int KB_SLIDE_INFO_ITEM_TYPE_MAJOR = 1;
    public static final int KB_SLIDE_INFO_ITEM_TYPE_MINOR = 0;
    private int c = 0;

    /* renamed from: b  reason: collision with root package name */
    private String f387b = "";

    /* renamed from: a  reason: collision with root package name */
    private int f386a = 0;

    public int getPercent() {
        return this.c;
    }

    public String getSlideInfoItemKey() {
        return this.f387b;
    }

    public int getSlideInfoItemType() {
        return this.f386a;
    }

    public void setPercent(int i) {
        this.c = i;
    }

    public void setSlideInfoItemKey(String str) {
        this.f387b = str;
    }

    public void setSlideInfoItemType(int i) {
        this.f386a = i;
    }
}
