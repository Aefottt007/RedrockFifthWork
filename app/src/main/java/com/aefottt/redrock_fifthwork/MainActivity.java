package com.aefottt.redrock_fifthwork;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.aefottt.redrock_fifthwork.Activity.NormalActivity;
import com.aefottt.redrock_fifthwork.Activity.RegisterActivity;
import com.aefottt.redrock_fifthwork.Service.DataInterface;
import com.aefottt.redrock_fifthwork.Service.DataService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etAccount;
    private EditText etPassword;
    private RadioButton rbAgreement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.ll_main_sinaSign).setOnClickListener(this);
        findViewById(R.id.ll_main_tencentSign).setOnClickListener(this);
        findViewById(R.id.btn_main_login).setOnClickListener(this);
        findViewById(R.id.tv_main_noAccount).setOnClickListener(this);
        etAccount = findViewById(R.id.et_main_account);
        etPassword = findViewById(R.id.et_main_password);
        rbAgreement = findViewById(R.id.rb_main_agreeAgreement);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.ll_main_sinaSign) {
            Toast.makeText(MainActivity.this, "新浪微博登陆ing...",
                    Toast.LENGTH_SHORT).show();
        } else if (id == R.id.ll_main_tencentSign) {
            Toast.makeText(MainActivity.this, "腾讯微博登陆ing...",
                    Toast.LENGTH_SHORT).show();
        } else if (id == R.id.tv_main_noAccount) {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        } else if (id == R.id.btn_main_login) {
            String tag = "";
            boolean signSucceed = false;
            String[] userInfo = null;
            String inputAccount = etAccount.getText().toString();
            String inputPassword = etPassword.getText().toString();
            if (inputAccount.isEmpty() || inputPassword.isEmpty()) {
                tag = "账号或密码不能为空";
            } else if (!rbAgreement.isChecked()) {
                tag = "请先勾选用户协议";
            } else {
                DataInterface dataSer = new DataService();
                userInfo = dataSer.getData(MainActivity.this);
                if (userInfo[0] == null || userInfo[1] == null) tag = "该账号尚未创建";
                else if (userInfo[0].equals(inputAccount) && userInfo[1].equals(inputPassword)) {
                    tag = "登陆成功！欢迎回来，" + userInfo[0];
                    signSucceed = true;
                } else tag = "账号或密码错误";
            }
            Toast.makeText(MainActivity.this, tag,
                    Toast.LENGTH_SHORT).show();
            if(signSucceed){
                Intent intent = new Intent(MainActivity.this, NormalActivity.class);
                intent.putExtra("userInfo", userInfo);
                startActivity(intent);
                this.finish();
            }
        }
    }
}