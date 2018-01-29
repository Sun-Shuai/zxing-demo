目前二维码扫描功能在app上已经非常成熟了，google的zxing项目也是目前可以说是最流行的二维码扫描框架。但是它本身功能太多，这里我提取出一些基本的扫码功能，重新封装成库。
使用方法：
```
    compile 'com.sunshuai:android-zxing:1.0.0'
```
新建一个ZxingActivity继承CaptureActivity，自定义扫码界面。handleDecode方法是扫描后的回调方法，重写它来自定义扫描后的操作，比如像下面我这么写的，是扫描后返回二维码文本内容
```
public class ZxingActivity extends CaptureActivity {

    @Override
    public void handleDecode(Result rawResult, Bitmap barcode, float scaleFactor) {
        Intent intent = new Intent();
        intent.putExtra(IntentConstant.EXTRANAME_QR_CODE_TEXT, rawResult.getText());
        this.setResult(IntentConstant.REQUESTCODE_SCAN_QR_CODE, intent);
        finish();
    }
}
```


在需要扫码的地方添加如下代码：
```
     Intent intent = new Intent(this, ZxingActivity.class);
     startActivityForResult(intent,IntentConstant.REQUESTCODE_SCAN_QR_CODE);


-----------------------------------------------------------

   @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case IntentConstant.REQUESTCODE_SCAN_QR_CODE:
                ToastUtils.showShort(this, data.getStringExtra(IntentConstant.EXTRANAME_QR_CODE_TEXT));
                break;
        }
    }
```
