package SenderMethods;

import Model.BlacklistDTO;
import Model.NotificationDTO;
import Model.PersonDTO;
import Validation.PayingBillsValidation;

public class FixedQuotaSmsSender implements IPackage {


    PayingBillsValidation payingBillsValidation;

    public FixedQuotaSmsSender(PayingBillsValidation payingBillsValidation) {
        this.payingBillsValidation = payingBillsValidation;
    }

    public void sendNotification(BlacklistDTO blacklistDTO, NotificationDTO notificationDTO) {

        if (payingBillsValidation.checkBills(blacklistDTO, notificationDTO)) {

            for (PersonDTO person : notificationDTO.getReceiverGroup().getNotificationGroup())
                System.out.println(notificationDTO.getCompanySender().getCompanyName() +
                        " is sending this NOTIFICATION: " + notificationDTO.getText() +
                        " with Fixed Quota Sms Package " +
                        "to " + person.getPersonName());
            notificationDTO.getCompanySender().increaseFixedQuotaSmsCount();
       }
    }

}