package bsu.lab.business.businessObjects;

/**
 * Created with IntelliJ IDEA.
 * User: meloman
 * Date: 27.09.12
 * Time: 18:11
 */
public class Client {
    private String name;
    private String address;
    private String telephone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String toString() {
        return String.format("<client>" +
                "<name>%1$s</name>" +
                "<address>%2$s</address>" +
                "<address>%3$s</address>" +
                "</client>", name, address, telephone);
    }
}
