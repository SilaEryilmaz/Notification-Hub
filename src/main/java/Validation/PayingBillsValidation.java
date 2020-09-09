package Validation;

import Model.BlacklistDTO;
import Exception.BillNotPaidException;
import Model.NotificationDTO;

public class PayingBillsValidation {


    public boolean checkBills(BlacklistDTO blacklistDTO, NotificationDTO notificationDTO) throws BillNotPaidException {
        if(blacklistDTO.getCompanyBlackList().contains(notificationDTO.getCompanySender())){ //fatura ödenmemiş ise

            throw new BillNotPaidException(notificationDTO.getCompanySender().getLanguage().printErrorMessage() );
        }
        return true;
    }
}
