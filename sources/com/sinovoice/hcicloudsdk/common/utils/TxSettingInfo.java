package com.sinovoice.hcicloudsdk.common.utils;
/* loaded from: classes.dex */
public class TxSettingInfo {

    /* renamed from: a  reason: collision with root package name */
    private String f440a;

    /* renamed from: b  reason: collision with root package name */
    private String f441b;
    private String c;
    private String d;
    private String e;
    private String f;

    public void UpdateAccountResult(TxSettingInfo txSettingInfo) {
        setAppChannel(txSettingInfo.getAppChannel());
        setEid(txSettingInfo.getEid());
        setTid(txSettingInfo.getTid());
        setPushJson(txSettingInfo.e);
        setAppKey(txSettingInfo.f440a);
        setDeveloperKey(txSettingInfo.f441b);
    }

    public String getAppChannel() {
        return this.f;
    }

    public String getAppKey() {
        return this.f440a;
    }

    public String getDeveloperKey() {
        return this.f441b;
    }

    public String getEid() {
        return this.d;
    }

    public String getPushJson() {
        return this.e;
    }

    public String getTid() {
        return this.c;
    }

    public boolean isAvailable() {
        return (PlatformUtil.isEmpty(this.f441b) || PlatformUtil.isEmpty(this.f440a) || PlatformUtil.isEmpty(this.c) || PlatformUtil.isEmpty(this.d) || PlatformUtil.isEmpty(this.e) || PlatformUtil.isEmpty(this.f)) ? false : true;
    }

    public void setAppChannel(String str) {
        this.f = str;
    }

    public void setAppKey(String str) {
        this.f440a = str;
    }

    public void setDeveloperKey(String str) {
        this.f441b = str;
    }

    public void setEid(String str) {
        this.d = str;
    }

    public void setPushJson(String str) {
        this.e = str;
    }

    public void setTid(String str) {
        this.c = str;
    }
}
