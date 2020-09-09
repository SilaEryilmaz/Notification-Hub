package Model;

import java.util.List;

public class GroupDTO {

    private List<PersonDTO> notificationGroup ;

    public void setNotificationGroup(List<PersonDTO> notificationGroup) {
        this.notificationGroup = notificationGroup;
    }

    public void addPersonToGroupList(PersonDTO person){
        notificationGroup.add(person);
    }

    public List<PersonDTO> getNotificationGroup() {
        return notificationGroup;
    }


}
