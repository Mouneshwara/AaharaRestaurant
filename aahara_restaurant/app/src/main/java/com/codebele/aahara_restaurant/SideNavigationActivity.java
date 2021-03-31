package com.codebele.aahara_restaurant;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.codebele.aahara_restaurant.SessionManager.UserSessionManager;
import com.codebele.aahara_restaurant.login.LoginActivity;
import com.codebele.aahara_restaurant.newOrders.NewOrdersActivity;
import com.codebele.aahara_restaurant.outForDelivery.Modle.OutForDeiveryModle;
import com.codebele.aahara_restaurant.outForDelivery.OutForDeliveryActivity;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SideNavigationActivity extends AppCompatActivity implements View.OnClickListener {
    private DrawerLayout drawerLayout;
    HashMap<String, String> user;
    private OutForDeiveryModle outForDeiveryModle;
    private ArrayList<OutForDeiveryModle> outForDeiveryModles = new ArrayList<>();
    /*@BindView(R.id.expandable_layout_settings)
    ExpandableLayout expandableLayout;
    @BindView(R.id.rr_settings)
    RelativeLayout rlRelativeLayout;
    @BindView(R.id.iv_leftNav)
    ImageView ivLeftNav;
    @BindView(R.id.iv_DownNav)
    ImageView ivRightNav;

    @BindView(R.id.rr_newOrders)
    RelativeLayout rlOrders;
    @BindView(R.id.iv_leftNavOrders)
    ImageView ivLeftNavOrders;
    @BindView(R.id.iv_DownNavOrders)
    ImageView ivDownnavOrders;
    @BindView(R.id.expandable_layout_Orders)
    ExpandableLayout OrdersexpandableLayout;

    @BindView(R.id.rr_items)
    RelativeLayout rlItems;
    @BindView(R.id.iv_leftNavmanage)
    ImageView iv_LeftNavItem;
    @BindView(R.id.iv_DownNavmanage)
    ImageView iv_DownNavmanage;
    @BindView(R.id.expandable_layout_ManageItems)
    ExpandableLayout ManageItemsexpandableLayout;
*/
    @BindView(R.id.rl_newOrders)
    RelativeLayout rlNewOrder;

    @BindView(R.id.rl_delivery)
    RelativeLayout rlDelivery;

    @BindView(R.id.tv_hotelName)
    TextView tvHotelName;

    @BindView(R.id.rl_Logout)
     RelativeLayout rlLogout;

    @BindView(R.id.rr_profile)
    RelativeLayout rlProfile;


/*    @BindView(R.id.rr_myStores)
    RelativeLayout rlMyStore;*/
    UserSessionManager session;
    String restaurantName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saide_navigation);
        drawerLayout = findViewById(R.id.drawer_layout);
        ButterKnife.bind(this);
//        session.checkLogin();
        getSessionData();

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(restaurantName);


        tvHotelName.setText(restaurantName);
            /*String s = outForDeiveryModle.getData().get(i).getRestaurantName();
            tvHotelName.setText(s);*/

//        tvHotelName.setText(outForDeiveryModle.getData().get(0).getRestaurantName());
       /* rlRelativeLayout.setOnClickListener(this);
        rlOrders.setOnClickListener(this);
        rlItems.setOnClickListener(this);*/
        rlNewOrder.setOnClickListener(this);
        rlDelivery.setOnClickListener(this);
        rlProfile.setOnClickListener(this);
      //  rlMyStore.setOnClickListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            //setContentView(R.layout.activity_g_n_s_landing_logout);
            // getSupportFragmentManager().beginTransaction().replace(R.id.,new LandingFragment()).commit();
        }

        rlLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.clearSession();
                Intent logIntent = new Intent(getApplicationContext(), LoginActivity.class);
                logIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                logIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                logIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(logIntent);
                getActivity().finish();
            }
        });
    }

    private ActionMode getActivity() {
        return null;
    }

    public void getSessionData(){
        session = new UserSessionManager(getApplicationContext());
        user = session.getUserDetails();
        restaurantName =session.getRestaurantName();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
       /*     case R.id.rr_settings:
                if (expandableLayout.isExpanded()) {
                    expandableLayout.collapse();
                    ivRightNav.setVisibility(View.GONE);
                    ivLeftNav.setVisibility(View.VISIBLE);

                } else {
                    expandableLayout.expand();
                    ivLeftNav.setVisibility(View.GONE);
                    ivRightNav.setVisibility(View.VISIBLE);
                }

                break;
            case R.id.rr_newOrders:
                if (OrdersexpandableLayout.isExpanded()) {
                    OrdersexpandableLayout.collapse();
                    ivDownnavOrders.setVisibility(View.GONE);
                    ivLeftNavOrders.setVisibility(View.VISIBLE);
                } else {
                    OrdersexpandableLayout.expand();
                    ivLeftNavOrders.setVisibility(View.GONE);
                    ivDownnavOrders.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.rr_items:
                if (ManageItemsexpandableLayout.isExpanded()) {
                    ManageItemsexpandableLayout.collapse();
                    iv_DownNavmanage.setVisibility(View.GONE);
                    iv_LeftNavItem.setVisibility(View.VISIBLE);
                } else {
                    ManageItemsexpandableLayout.expand();
                    iv_LeftNavItem.setVisibility(View.GONE);
                    iv_DownNavmanage.setVisibility(View.VISIBLE);
                }
                break;*/

            case R.id.rl_newOrders:
                Intent intent = new Intent(this, NewOrdersActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_delivery:
                Intent i = new Intent(this, OutForDeliveryActivity.class);
                startActivity(i);
                break;

           /* case R.id.rl_Logout:
                session.clearSession();
                break;*/

            case R.id.rr_profile:
                Intent j = new Intent(this, SideNavigationActivity.class);
                startActivity(j);
                break;
           /* case R.id.rr_myStores:
                Intent j = new Intent(this, MyStoreActivity.class);
                startActivity(j);*/
        }
    }
}