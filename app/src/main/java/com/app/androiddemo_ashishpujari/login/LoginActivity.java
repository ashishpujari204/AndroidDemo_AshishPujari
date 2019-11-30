package com.app.androiddemo_ashishpujari.login;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.androiddemo_ashishpujari.R;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rest.ApiClient;
import rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import util.AppUtils;
import util.BaseActivity;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.etMobileNumber)
    EditText etMobileNumber;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.buttonLogin)
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        initial();

    }

    private void initial() {

        buttonLogin.setOnClickListener(view -> {
            if (AppUtils.isNetworkAvailable(LoginActivity.this)) {
                validateLoginDetails();
            }
        });
    }

    private void validateLoginDetails() {
        if (TextUtils.isEmpty(etMobileNumber.getText().toString())) {
            showToast("Please enter mobile number");
        } else if (etMobileNumber.getText().toString().length() != 10) {
            showToast("Please enter valid mobile number");
        } else if (TextUtils.isEmpty(etPassword.getText().toString())) {
            showToast("Please enter password");
        } else {
            callLoginAPI(etMobileNumber.getText().toString(), etPassword.getText().toString());
        }
    }

    private void callLoginAPI(String mobileNumber, String password) {
        JsonObject loginObject = new JsonObject();
        loginObject.addProperty("userName", mobileNumber);
        loginObject.addProperty("password", password);
        loginObject.addProperty("userType", "USERTYPE_EXISTING");
        loginObject.addProperty("appLanguagePref", "en");

        startProgressDialog();
        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
        Call<User> donation = api.callLogin(loginObject);
        donation.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                stopProgressDialog();

                if (response.code() == 200) {
                    Log.e("app", "user response is--" + response.body().toString());
                    try {
                        JSONObject object = new JSONObject(response.body().toString());
                        if (object.getString("status").equalsIgnoreCase("success")) {

                        }
                    } catch (JSONException e) {
                        Log.e("app", "while parse getting user response is--" + e.toString());
                    }
                } else {
                    showToast("Invalid login details,Please try again");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                stopProgressDialog();
            }
        });

    }
}

