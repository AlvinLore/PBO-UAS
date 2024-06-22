/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public abstract class Form {
    private List<String> errorMessages = new ArrayList<String>();

    public abstract boolean validatePermintaan();
    
    public abstract boolean validateUpdatePertemuan();

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    protected void addErrorMessages(String message) {
        this.errorMessages.add(message);
    }
}
