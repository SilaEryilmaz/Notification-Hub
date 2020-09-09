package SenderMethods;

import Model.BlacklistDTO;
import Model.NotificationDTO;

public interface IPackage {

    void sendNotification(BlacklistDTO blacklistDTO, NotificationDTO notificationDTO);
}
