package Pricing;

import Model.BillDTO;
import Model.CompanyDTO;

public class FixedQuotaSmsPricing implements IPackagePricing {


    public void feeCalculation(BillDTO billDTO) {

        if(billDTO.getPayingCompany().getFixedQuotaEmailCount()%1000!=0) {
            billDTO.setBillFee(billDTO.getBillFee() + ((int) ((billDTO.getPayingCompany().getFixedQuotaEmailCount() / 1000) + 1) * 20));
        }
        else {
            billDTO.setBillFee(billDTO.getBillFee() + ((billDTO.getPayingCompany().getFixedQuotaEmailCount() / 1000) * 20));
        }

    }
}
