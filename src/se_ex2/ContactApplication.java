package se_ex2;

public abstract class ContactApplication implements Application {
    private MobilePhone phone;

    // Remove entry correlates with c
    public abstract void removeEntry(Contact c);

    public ContactApplication(MobilePhone phone) {
        this.phone = phone;
    }

    public MobilePhone getPhone() {
        return phone;
    }

    public void setPhone(MobilePhone phone) {
        this.phone = phone;
    }
}
