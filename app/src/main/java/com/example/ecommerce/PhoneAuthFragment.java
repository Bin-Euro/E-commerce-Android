package com.example.ecommerce;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class PhoneAuthFragment extends Fragment {

    private EditText editTextPhone, editTextOtp;
    private Button btnSendOtp, btnVerifyOtp;
    private FirebaseAuth auth;
    private String verificationId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_phone_auth, container, false);

        editTextPhone = view.findViewById(R.id.editTextPhone);
        editTextOtp = view.findViewById(R.id.editTextOtp);
        btnSendOtp = view.findViewById(R.id.btnSendOtp);
        btnVerifyOtp = view.findViewById(R.id.btnVerifyOtp);

        auth = FirebaseAuth.getInstance();

        btnSendOtp.setOnClickListener(v -> sendVerificationCode());
        btnVerifyOtp.setOnClickListener(v -> verifyCode());

        return view;
    }
    private void sendVerificationCode() {
        String phone = editTextPhone.getText().toString().trim();

        if (TextUtils.isEmpty(phone)) {
            editTextPhone.setError("Enter a valid phone number");
            editTextPhone.requestFocus();
            return;
        }
        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(auth)
                .setPhoneNumber("+84" + phone)       // Phone number to verify
                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                .setActivity(requireActivity())                 // Activity (for callback binding)
                .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks =
            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                @Override
                public void onVerificationCompleted(@NonNull PhoneAuthCredential credential) {
                    String code = credential.getSmsCode();
                    if (code != null) {
                        editTextOtp.setText(code);
                        verifyCode();
                    }
                }
                @Override
                public void onVerificationFailed(@NonNull FirebaseException e) {
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
                }

                @Override
                public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken token) {
                    super.onCodeSent(s, token);
                    verificationId = s;
                    Toast.makeText(getActivity(), "OTP Sent", Toast.LENGTH_SHORT).show();
                }
            };

    private void verifyCode() {
        String code = editTextOtp.getText().toString().trim();
        if (code.isEmpty()) {
            editTextOtp.setError("Enter OTP");
            editTextOtp.requestFocus();
            return;
        }
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
        signInWithCredential(credential);
    }

    private void signInWithCredential(AuthCredential credential) {
        auth.signInWithCredential(credential)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(getActivity(), "Authentication Successful", Toast.LENGTH_SHORT).show();
                        navigateToMainActivity();
                    } else {
                        Toast.makeText(getActivity(), "Authentication Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void navigateToMainActivity() {
        Intent intent = new Intent(getActivity(), HomeActivity.class);
        startActivity(intent);
        requireActivity().finish();
    }
}
