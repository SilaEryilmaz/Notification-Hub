package Service;

import Model.BillDTO;
import Model.CompanyDTO;
import Model.NotificationDTO;

public class FeeReportingService {

    public void printBillFees(BillDTO billDTO){

           if(billDTO.getPayingCompany().getPackageUsageDays()==30){
                System.out.println("MONTHLY NOTIFICATION SENDING FEES: " + billDTO.getBillFee());
                billDTO.addBillsToQueue(billDTO.getBillFee());
                billDTO.setBillFee(0);
                billDTO.getPayingCompany().setPackageUsageDays(0);

           }


    }
}
