package com.example.applicationcuatoi.view.login;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.example.applicationcuatoi.view.home.HomeActivity;
import com.example.applicationcuatoi.view.signup.SignUpActivity;

public class LoginViewModel extends ViewModel {

    private String username;
    private String password;
    private Context context;

    public LoginViewModel(Context context) {
        this.context = context;
    }

    // xử lý sự kiện khi click đăng nhập
    public void onClickLogin(String username, String password) {

        if (username.equals("Admin") && password.equals("Admin")) {
            Toast.makeText(context, "Xin Chào Admin !", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, HomeActivity.class);
            context.startActivity(intent);
        } else if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(context, "Không được bỏ trống", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Tài khoản hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
        }
    }

    public void clickForgotPassword() {
        Toast.makeText(context, "ngu thì chết bấm bấm caiconcac !", Toast.LENGTH_SHORT).show();
    }

    public void onClickSignUp() {
        Intent intent = new Intent(context, SignUpActivity.class);
        context.startActivity(intent);
    }
}
