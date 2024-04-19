package com.sinovoice.hcicloudinputvehicle.engine.handwrite;

import java.util.ArrayList;
/* loaded from: classes.dex */
interface Engine {
    ArrayList<String> associateChinese(String str);

    ArrayList<String> associateEnglish(String str);

    ArrayList<String> hwrRecogChinese(short[] sArr);

    ArrayList<String> hwrRecogChinese(short[] sArr, int i);

    ArrayList<String> hwrRecogChinese(short[] sArr, String str);

    ArrayList<String> hwrRecogEnglish(short[] sArr);

    void init();

    void raisePriorityChinese(String str);

    void raisePriorityEnglish(String str);

    void release();

    void startHwrAssSession();

    void startHwrSession();

    void stopHwrAssSession();

    void stopHwrSession();
}
