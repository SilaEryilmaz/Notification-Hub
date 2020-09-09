package Model;

import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

public class NotificationDTO {

    private CompanyDTO companySender;
    private GroupDTO  receiverGroup;
    private String text;
    private LocalDate notificationDate;



    public CompanyDTO getCompanySender() {
        return companySender;
    }

    public void setCompanySender(CompanyDTO companySender) {
        this.companySender = companySender;
    }

    public GroupDTO getReceiverGroup() {
        return receiverGroup;
    }

    public void setReceiverGroup(GroupDTO receiverGroup) {
        this.receiverGroup = receiverGroup;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(LocalDate notificationDate) {
        this.notificationDate = notificationDate;
    }
}
