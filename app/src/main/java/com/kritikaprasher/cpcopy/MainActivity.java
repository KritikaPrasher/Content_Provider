package com.kritikaprasher.cpcopy;

//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView txtView;
    EditText editName, editPassword, editEmail;
    Button btnSubmit, btnLogin;

    Student student;

    ContentResolver resolver;

    public void initViews(){
        txtView = (TextView) findViewById(R.id.textView);
        editName = (EditText) findViewById(R.id.editName);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editPassword = (EditText) findViewById(R.id.editPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnLogin.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        student= new Student();

        setTitle("News_Aggregator");

        resolver = getContentResolver();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btnLogin) {
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);

            student.setName(editName.getText().toString().trim());
            student.setName(editEmail.getText().toString().trim());
            student.setName(editPassword.getText().toString().trim());

            insertIntoDB();
        }

    }

    void insertIntoDB(){

        ContentValues values = new ContentValues();

        values.put(Util.USER_NAME,student.getName());

        values.put(Util.USER_EMAIL,student.getEmail());

        Uri dummy = resolver.insert(Util.STUDENT_URI,values);
        Toast.makeText(this,student.getName()+ " Registered Successfully "+dummy.getLastPathSegment(),Toast.LENGTH_LONG).show();

        Log.i("Insert",student.toString());

        clearFields();
    }

    void clearFields(){
        editName.setText("");
        editPassword.setText("");
        editEmail.setText("");

    }
}
