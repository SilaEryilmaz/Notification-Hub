package Service;


import Model.BlacklistDTO;
import Model.NotificationDTO;
import SenderMethods.IPackage;
import Exception.BillNotPaidException;

import java.util.List;

public class SenderService {


    private List<IPackage> packages;

    public SenderService(List<IPackage> packages) {

        this.packages = packages;
    }

    public void sendNotification(BlacklistDTO blacklistDTO, NotificationDTO notificationDTO) {
        for (IPackage iPackage : packages) {
            try {
                iPackage.sendNotification(blacklistDTO, notificationDTO);

            } catch (BillNotPaidException billNotPaidException) {
                System.out.println(billNotPaidException.getMessage());
            }

        }
    }

}


