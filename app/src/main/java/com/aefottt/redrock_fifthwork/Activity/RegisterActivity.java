package com.aefottt.redrock_fifthwork.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.aefottt.redrock_fifthwork.R;
import com.aefottt.redrock_fifthwork.Service.DataInterface;
import com.aefottt.redrock_fifthwork.Service.DataService;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etAccountRegister;
    private EditText etPasswordRegister;
    private EditText getEtPasswordAgain;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView(){
        findViewById(R.id.btn_register).setOnClickListener(this);
        etAccountRegister = findViewById(R.id.et_register_account);
        etPasswordRegister = findViewById(R.id.et_register_password);
        getEtPasswordAgain = findViewById(R.id.et_register_password_again);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==R.id.btn_register){
            String tag = "";
            boolean registerSucceed = false;
            String inputAccount = etAccountRegister.getText().toString();
            String inputPassword = etPasswordRegister.getText().toString();
            String inputPasswordAgain = getEtPasswordAgain.getText().toString();
            if(inputAccount.isEmpty()||inputPassword.isEmpty()||inputPasswordAgain.isEmpty()){
                tag = "账户或密码不能为空";
            }else if(!inputPassword.equals(inputPasswordAgain)){
                tag = "两次密码输入不相同";
            }else{
                DataInterface dataSer = new DataService();
                dataSer.saveData(RegisterActivity.this,inputAccount,inputPassword);
                tag = "注册成功！";
                registerSucceed = true;
            }
            Toast.makeText(RegisterActivity.this,tag,
                    Toast.LENGTH_SHORT).show();
            if(registerSucceed) this.finish();
        }
    }
}
