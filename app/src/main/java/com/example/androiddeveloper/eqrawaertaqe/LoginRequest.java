package com.example.androiddeveloper.eqrawaertaqe;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "http://readksapro.com/Login_eqra.php";
    private Map<String, String> params;

    public LoginRequest(String username, String password, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("User_name", username);
        params.put("User_Password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
