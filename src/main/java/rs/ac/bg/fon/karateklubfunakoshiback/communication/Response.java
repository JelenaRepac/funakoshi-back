/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.communication;

import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Jeks
 */
public class Response {
    
    private Object responseData;
    private Exception responseException;
    private String responseMessage;
    private UserDetails userDetails;

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
    
    
    public String getResponseMessage() {
        return responseMessage;
    }
    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
    
    public Object getResponseData() {
        return responseData;
    }

    public Exception getResponseException() {
        return responseException;
    }

    public void setResponseData(Object responseData) {
        this.responseData = responseData;
    }

    public void setResponseException(Exception responseException) {
        this.responseException = responseException;
    }
    
    
}
