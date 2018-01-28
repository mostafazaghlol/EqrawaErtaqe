package com.example.androiddeveloper.eqrawaertaqe;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://readksapro.com/Register_eqra.php";
    private Map<String, String> params;

    public RegisterRequest(String email, String username, String password, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("User_email", email);
        params.put("User_name", username);
        params.put("User_Password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
