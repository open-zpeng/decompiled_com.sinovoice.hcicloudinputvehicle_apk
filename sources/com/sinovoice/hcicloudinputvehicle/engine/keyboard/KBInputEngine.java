package com.sinovoice.hcicloudinputvehicle.engine.keyboard;

import android.content.Context;
/* loaded from: classes.dex */
interface KBInputEngine {
    d getMoreEnglish();

    d getMorePinYin();

    void init(Context context);

    d queryEnglish(String str);

    d queryPinYin(String str);

    void release();

    void setPinYinFuzzy(boolean z);

    void startKBSession();

    void stopKBSession();

    void submitChineseUDB(String str, String str2);
}
