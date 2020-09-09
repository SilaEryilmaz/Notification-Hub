package Service;

import Model.BillDTO;

public class PayingBill {

    public void payTheBill(BillDTO billDTO){

        //FIRST IN FIRST OUT
        billDTO.getAllFees().remove();


    }
}


