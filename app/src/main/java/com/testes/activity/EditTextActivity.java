package com.testes.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.testes.android.R;

public class EditTextActivity extends AppCompatActivity {

    String buttonText = "";
    private EditText numberEdit, doubleEdit, mailEdit;
    TextView angleText;
    private boolean atualizando = false;
    public static final String TAG = "EditTextActivity";
    View line;

    float degreesSoItIsParallelToTheGround = 0f;
    String phoneRotationDegrees = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_edittext);

        String[] degreesValues = new String[20];

        for (int i = 0; i < 20; i++) {
            degreesValues[i] = String.valueOf(i) + (char) 0x00B0;
        }

        doubleEdit = (EditText) findViewById(R.id.doubleEditText);
        Button validateButton = (Button) findViewById(R.id.validateButton);
        final EditText editText = (EditText) findViewById(R.id.editTextAct);
        mailEdit = (EditText) findViewById(R.id.user2Edit);
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mailEdit.getText().toString();
                if (email.length() != 0) {
                    if (isValidEmail(email)) {
                        Toast.makeText(getApplicationContext(), "valid email address", Toast.LENGTH_SHORT).show();
                    } else {
                        mailEdit.setError("Email required!");
                        showAlertValidation();
                    }
                } else {
                    mailEdit.setError("Email required!");
                }
            }
        });

        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().contains(",")) {
                    Log.i(TAG, "Contains");
                }
                if (s.length() > 3) {
                    Log.i(TAG, "Content: " + s.toString().replace("'", "''"));
                }

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0)
                    Log.i(TAG, "some text");
            }
        });

        doubleEdit.addTextChangedListener(filterTextWatcherTelefone);

    }

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    public void showAlertValidation() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(EditTextActivity.this);
        alertDialog.setTitle("Failed");
        alertDialog.setMessage("Invalid Email");
        alertDialog.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.create().show();
    }

    private TextWatcher filterTextWatcherTelefone = new TextWatcher() {
        public void afterTextChanged(Editable s) {


        }

        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            try {
                if (atualizando) {
                    atualizando = false;
                    return;
                }

                String resultado = limparFormatacaoNumero(s.toString());

//                if (isNumero(resultado)) {

                if (resultado.length() <= 14) {
                    resultado = adicionarFormatacaoTelefone(resultado);

                } else {
                    resultado = resultado.substring(0, 14);
                    resultado = adicionarFormatacaoTelefone(resultado);
                }
                atualizando = true;
                doubleEdit.setText(resultado);
                doubleEdit.setSelection(doubleEdit.getText().length());

//                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };


    @Override
    protected void onPause() {

        super.onPause();

    }

    @Override
    protected void onResume() {

        super.onResume();
    }

    public void whenbuttonisclicked(View view) {
        String edittext1str = doubleEdit.getText().toString();
        double editext1dob = 0;
        if (!TextUtils.isEmpty(edittext1str))
            editext1dob = Double.parseDouble(edittext1str);

        String edittext2str = "2";
        double editext2dob = Double.parseDouble(edittext2str);
        double add = (editext1dob + editext2dob);
        String yourDoubleString = String.valueOf(add);
        Log.i(TAG, "result:" + yourDoubleString);
    }

    public String adicionarFormatacaoTelefone(String string) {
        return "444+" + string;
    }

    public String limparFormatacaoNumero(String s) {
        return s.trim();
    }

}
