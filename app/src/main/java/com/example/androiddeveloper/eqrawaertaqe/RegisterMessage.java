package com.example.androiddeveloper.eqrawaertaqe;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


public class RegisterMessage extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://readksapro.com/Register_eqra.php";
    private Map<String, String> params;

    public RegisterMessage(String message_title, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("Message_title", message_title);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
