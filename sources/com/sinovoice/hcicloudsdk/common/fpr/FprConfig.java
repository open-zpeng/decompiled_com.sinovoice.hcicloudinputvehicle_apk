package com.sinovoice.hcicloudsdk.common.fpr;

import com.sinovoice.hcicloudsdk.common.ParamProcessor;
/* loaded from: classes.dex */
public class FprConfig extends ParamProcessor {

    /* loaded from: classes.dex */
    public static final class ImageConfig {
        public static final String PARAM_KEY_BG_COLOR = "bgColor";
        public static final String PARAM_KEY_DPI = "dpi";
        public static final String PARAM_KEY_HEIGHT = "height";
        public static final String PARAM_KEY_IMAGE_TYPE = "imageType";
        public static final String PARAM_KEY_WIDTH = "width";
        public static final String VALUE_OF_PARAM_BG_COLOR_BLACK = "black";
        public static final String VALUE_OF_PARAM_BG_COLOR_WIGHT = "white";
        public static final String VALUE_OF_PARAM_IMAGE_TYPE_FORMAT = "format";
        public static final String VALUE_OF_PARAM_IMAGE_TYPE_RAW = "raw";
    }

    /* loaded from: classes.dex */
    public static final class ResultConfig {
        public static final String PARAM_KEY_ACTION_TYPE = "actionType";
        public static final String PARAM_KEY_THRESHOLD = "threshold";
    }

    /* loaded from: classes.dex */
    public static final class SessionConfig {
        public static final String PARAM_KEY_CAP_KEY = "capKey";
    }

    /* loaded from: classes.dex */
    public static final class UserConfig {
        public static final String PARAM_KEY_GROUP_ID = "groupid";
        public static final String PARAM_KEY_USER_ID = "userId";
    }
}
