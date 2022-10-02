package com.assignment.Defense.of.the.Ancients2.DTO;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * DTO for Error Response Data.
 * @author Karan
 */

@XmlRootElement(name = "error")
public class ErrorResponseDTO {

    //General error message about nature of error
    private String message;

    //Specific errors in API request processing
    private List<String> details;

    /**
     * ErrorResponseDTO constructor.
     * @param message field.
     * @param details field.
     */
    public ErrorResponseDTO(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }

    public ErrorResponseDTO() {
    }


}
