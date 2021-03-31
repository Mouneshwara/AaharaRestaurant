package com.codebele.aahara_restaurant.myStore;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.codebele.aahara_restaurant.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DocumentPickBottomSheetDialog extends BottomSheetDialog {
    private Context mContext;
    ChoosePictureCallBack choosePictureCallBack;


    @BindView(R.id.rl_parent_camera)
    RelativeLayout rl_parent_camera;

    @BindView(R.id.rl_parent_gallery)
    RelativeLayout rl_parent_gallery;


    @BindView(R.id.tv_cancel)
    TextView tv_cancel;

    public DocumentPickBottomSheetDialog(Context context, ChoosePictureCallBack choosePictureCallBack) {
        super(context);
        this.mContext = context;
        this.choosePictureCallBack = choosePictureCallBack;
        setContentView(R.layout.layout_document_picker);
        ButterKnife.bind(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(60, 0, 0, 0)));
    }


    @OnClick(R.id.rl_parent_gallery)
    void openGallery() {
        choosePictureCallBack.pickImageFromGallery();
    }

    @OnClick(R.id.rl_parent_camera)
    void openCamera() {
        choosePictureCallBack.pickDocument();
    }

    @OnClick(R.id.tv_cancel)
    void cancelDialog() {
        choosePictureCallBack.cancelDialog();
    }


    public interface ChoosePictureCallBack {
        void pickImageFromGallery();

        void pickDocument();

        void cancelDialog();

    }




}
