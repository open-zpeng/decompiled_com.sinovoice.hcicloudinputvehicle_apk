package com.sinovoice.hcicloudsdk.common.afr;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class AfrDetectFace {

    /* renamed from: a  reason: collision with root package name */
    private String f320a;

    /* renamed from: b  reason: collision with root package name */
    private AfrDetectFacebox f321b;
    private ArrayList<AfrDetectLandmark> c = new ArrayList<>();
    private ArrayList<AfrDetectFaceAttribute> d = new ArrayList<>();

    public ArrayList<AfrDetectFaceAttribute> getAttributeList() {
        return this.d;
    }

    public String getFaceId() {
        return this.f320a;
    }

    public AfrDetectFacebox getFacebox() {
        return this.f321b;
    }

    public ArrayList<AfrDetectLandmark> getLandmarkList() {
        return this.c;
    }

    public void setAttributeList(ArrayList<AfrDetectFaceAttribute> arrayList) {
        this.d = arrayList;
    }

    public void setFaceId(String str) {
        this.f320a = str;
    }

    public void setFacebox(AfrDetectFacebox afrDetectFacebox) {
        this.f321b = afrDetectFacebox;
    }

    public void setLandmarkList(ArrayList<AfrDetectLandmark> arrayList) {
        this.c = arrayList;
    }
}
