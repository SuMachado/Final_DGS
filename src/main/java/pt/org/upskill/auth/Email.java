package pt.org.upskill.auth;

import pt.org.upskill.dto.DTOable;
import pt.org.upskill.dto.EmailDTO;

public class Email implements DTOable {
    private String addressEmail;

    public Email(String addressEmail) throws Exception {
        if (!validate(addressEmail)) {
            throw new Exception("Invalid email address: " + addressEmail);
        }
        this.addressEmail = addressEmail;
    }

    public String getAddressEmail() {
        return addressEmail;
    }

    private boolean validate(String email) {
        return email.contains("@");
    }

    public String address() {
        return addressEmail;
    }
    @Override
    public Object toDTO() {
        return new EmailDTO(address());
    }
}
