package com.sunshuai.zxing_demo;

import android.graphics.Bitmap;

import com.google.zxing.Result;
import com.sunshuai.android_zxing.CaptureActivity;

/**
 * Created by sunshuai on 2018/1/26
 */

public class ZxingActivity extends CaptureActivity {
    @Override
    public void handleDecode(Result rawResult, Bitmap barcode, float scaleFactor) {
        super.handleDecode(rawResult, barcode, scaleFactor);
    }
}
