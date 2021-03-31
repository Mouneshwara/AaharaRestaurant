package com.codebele.aahara_restaurant.myStore;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.codebele.aahara_restaurant.myStore.adapters.MyStoreSpinnerAdapter;
import com.codebele.aahara_restaurant.myStore.modle.MyStore;
import com.codebele.aahara_restaurant.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyStoreActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,View.OnClickListener {
    private Spinner issueSpinner;
    private MyStoreSpinnerAdapter myStoreSpinnerAdapter;
    private ArrayList<MyStore> storesList= new ArrayList<>();
    @BindView(R.id.btn_chooseFile)
    Button btnChooseFile;
    DocumentPickBottomSheetDialog documentPickBottomSheetDialog;
    private static final int PICK_FROM_GALLERY = 101;
    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.ivOnBackPress)
    ImageView ivOnBackPress;
    Uri URI = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_store);
        ButterKnife.bind(this);
        issueSpinner = (Spinner)findViewById(R.id.issueSpinner);
        initList();
        setSpinnerAdapter();

        btnChooseFile.setOnClickListener(this);
        ivOnBackPress.setOnClickListener(this);
    }

    private void initList(){
        storesList.add(new MyStore("0","Select"));
        storesList.add(new MyStore("1","Veg"));
        storesList.add(new MyStore("2","Non Veg"));
        storesList.add(new MyStore("3","Both"));
    }

    private void setSpinnerAdapter(){
        myStoreSpinnerAdapter=new MyStoreSpinnerAdapter(this,R.layout.layout_spinner,storesList);
        issueSpinner.setAdapter(myStoreSpinnerAdapter);
        issueSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public boolean checkPermissionForExternalAndRead() {
        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        // check if all permissions are granted
                        if (report.areAllPermissionsGranted()) {
                            if (documentPickBottomSheetDialog != null && !documentPickBottomSheetDialog.isShowing())
                                documentPickBottomSheetDialog.show();
                        }
                        // check for permanent denial of any permission
                        if (report.isAnyPermissionPermanentlyDenied()) {
                            //showSettingsDialog();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                })
                .onSameThread()
                .check();
        return true;
    }

    public void openFolder() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra("return-data", true);
        startActivityForResult(Intent.createChooser(intent, "Complete action using"), PICK_FROM_GALLERY);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_chooseFile:
                if (checkPermissionForExternalAndRead()){
                    openFolder();
                }
                break;
            case R.id.ivOnBackPress:
                onBackPressed();
                break;
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_FROM_GALLERY && resultCode == RESULT_OK) {
            URI = data.getData();
            ivLogo.setImageURI((Uri) URI);
        }
    }


}