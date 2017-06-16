package com.kaola.qrcodescanner.qrcode;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.kaola.qrcodescanner.R;
import com.xys.libzxing.zxing.encoding.EncodingUtils;

/**
 * Created by 浩琦 on 2017/6/15.
 */

public class GenerateCodeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generate_activity);
        findViewById(R.id.gen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "abc";
                if (str.equals("")) {
                    Toast.makeText(GenerateCodeActivity.this, "不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    // 位图
                    try {
                        /**
                         * 参数：1.文本 2 3.二维码的宽高 4.二维码中间的那个logo
                         */
                        Bitmap bitmap = EncodingUtils.createQRCode(str, 500, 500, null);
                        // 设置图片
                        ((ImageView) findViewById(R.id.gen_ims)).setImageBitmap(bitmap);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            }
        });

    }
}
